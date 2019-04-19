package com.UDHFashion.udhmanagmentsystem.util;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.AbstractView;

import com.UDHFashion.udhmanagmentsystem.model.Bill;
import com.UDHFashion.udhmanagmentsystem.model.Billitems;
import com.itextpdf.io.font.FontConstants;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.borders.Border.Side;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.HorizontalAlignment;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;

@Component("ReturnNoteInvoice")
public class ReturnNotePDF extends AbstractView {

	NumberFormat formatter = new DecimalFormat("#0.00");

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		response.setHeader("Content-Disposition", "attachment; filename=saleInvoice.pdf");
		ArrayList<Billitems> billItems = (ArrayList<Billitems>) model.get("items");

		int heightCounter = 0;

		heightCounter = billItems.size() * 12;

		System.out.println("Cart Size " + billItems.size());

		// get height and width
		float height = heightCounter + 85;
		float width = 78;

		// after converting to inches
		height = (float) (height / 25.4 * 72.0);
		width = (float) (width / 25.4 * 72.0);

		Rectangle pagesize = new Rectangle(width, height);
		PageSize size = new PageSize(width, height);

		PdfWriter pdfWriter = new PdfWriter(response.getOutputStream());
		PdfDocument pdf = new PdfDocument(pdfWriter);
		pdf.setDefaultPageSize(size);
		Document doc = new Document(pdf);

		doc.setMargins(10, 10, 10, 10);

		Paragraph para1 = new Paragraph("UDM FASHION");
		para1.setFont(PdfFontFactory.createFont(FontConstants.HELVETICA));
		para1.setFontSize(10f);
		para1.setBold();
		para1.setHorizontalAlignment(HorizontalAlignment.CENTER);
		para1.setTextAlignment(TextAlignment.CENTER);

		Paragraph para2 = new Paragraph("Date : " + getDate());
		para2.setFont(PdfFontFactory.createFont(FontConstants.HELVETICA));
		para2.setFontSize(6f);
		para2.setHorizontalAlignment(HorizontalAlignment.LEFT);
		para2.setTextAlignment(TextAlignment.LEFT);
		para2.setFixedLeading(3);

		Paragraph para3 = new Paragraph("Time : " + getCurrentTime());
		para3.setFont(PdfFontFactory.createFont(FontConstants.HELVETICA));
		para3.setFontSize(6f);
		para3.setHorizontalAlignment(HorizontalAlignment.LEFT);
		para3.setTextAlignment(TextAlignment.LEFT);
		para3.setFixedLeading(3);

		Paragraph line = new Paragraph("====================================================================");
		line.setFont(PdfFontFactory.createFont(FontConstants.HELVETICA));
		line.setFontSize(5f);
		line.setHorizontalAlignment(HorizontalAlignment.LEFT);
		line.setTextAlignment(TextAlignment.LEFT);
		line.setFixedLeading(5);

		Paragraph address = new Paragraph("UDM FASHION, THALAWA ROAD, EPPAWALA");
		address.setFontSize(6f);
		address.setBold();
		address.setHorizontalAlignment(HorizontalAlignment.CENTER);
		address.setTextAlignment(TextAlignment.CENTER);
		address.setFixedLeading(6);
		;

		Paragraph telephone = new Paragraph("Contact No : 0714020007  \\ " + " 0712920989");
		telephone.setFontSize(6f);
		telephone.setHorizontalAlignment(HorizontalAlignment.CENTER);
		telephone.setTextAlignment(TextAlignment.CENTER);
		telephone.setFixedLeading(6);
		
		Paragraph returnNote = new Paragraph("RETURN NOTE");
		returnNote.setFontSize(9f);
		returnNote.setHorizontalAlignment(HorizontalAlignment.CENTER);
		returnNote.setTextAlignment(TextAlignment.CENTER);
		returnNote.setFixedLeading(6);

		doc.add(para1);
		doc.add(address);
		doc.add(telephone);
		doc.add(line);
		doc.add(para2);
		doc.add(para3);
		doc.add(line);
		doc.add(returnNote);
		doc.add(line);
		
		try {

			Table pdfPTable = new Table(4);

			Paragraph title1 = new Paragraph();
			Paragraph title2 = new Paragraph();
			Paragraph title3 = new Paragraph();
			Paragraph title4 = new Paragraph();

			title1.add("Description");
			title1.setFontSize(6f);

			title2.add("Quantity");
			title2.setFontSize(6f);

			title3.add("Unit Price");
			title3.setFontSize(6f);

			title4.add("Value");
			title4.setFontSize(6f);

			Cell pdfCell1 = new Cell().add(title1);
			Cell pdfCell2 = new Cell().add(title2);
			Cell pdfCell3 = new Cell().add(title3);
			Cell pdfCell4 = new Cell().add(title4);

			pdfCell1.setBorder(Border.NO_BORDER);
			pdfCell2.setBorder(Border.NO_BORDER);
			pdfCell3.setBorder(Border.NO_BORDER);
			pdfCell4.setBorder(Border.NO_BORDER);

			pdfPTable.addCell(pdfCell1);
			pdfPTable.addCell(pdfCell2);
			pdfPTable.addCell(pdfCell3);
			pdfPTable.addCell(pdfCell4);

			double totalValue=0;
			for (Billitems cart : billItems) {

				Paragraph p1 = new Paragraph();
				Paragraph p2 = new Paragraph();
				Paragraph p3 = new Paragraph();
				Paragraph p4 = new Paragraph();

				p1.add(cart.getItemName()+"");
				p1.setFontSize(6f);

				p2.add(cart.getQty() + " X ");
				p2.setFontSize(6f);

				p3.add(formatter.format(cart.getPrice() - (cart.getReduseDiscount()/cart.getQty() )) + "");
				p3.setFontSize(6f);

				p4.add(formatter.format(cart.getAmount()) + "");
				p4.setFontSize(6f);

				Cell cell1 = new Cell().add(p1);
				Cell cell2 = new Cell().add(p2);
				Cell cell3 = new Cell().add(p3);
				Cell cell4 = new Cell().add(p4);

				cell1.setBorder(Border.NO_BORDER);
				cell2.setBorder(Border.NO_BORDER);
				cell3.setBorder(Border.NO_BORDER);
				cell4.setBorder(Border.NO_BORDER);

				pdfPTable.addCell(cell1);
				pdfPTable.addCell(cell2);
				pdfPTable.addCell(cell3);
				pdfPTable.addCell(cell4);
				
				totalValue+=cart.getAmount();
			}

			Paragraph p1 = new Paragraph("Total Rs:");
			p1.setFontSize(7f);
			p1.setBold();

			Paragraph p2 = new Paragraph("");
			p2.setFontSize(7f);
			p2.setBold();

			Paragraph p3 = new Paragraph("");
			p3.setFontSize(7f);
			p3.setBold();

			Paragraph p4 = new Paragraph(formatter.format(totalValue));
			p4.setFontSize(7f);
			p4.setBold();

			Cell cell1 = new Cell().add(p1);
			Cell cell2 = new Cell().add(p2);
			Cell cell3 = new Cell().add(p3);
			Cell cell4 = new Cell().add(p4);

			cell1.setBorder(Border.NO_BORDER);
			cell2.setBorder(Border.NO_BORDER);
			cell3.setBorder(Border.NO_BORDER);
			cell4.setBorder(Border.NO_BORDER);

			pdfPTable.addCell(cell1);
			pdfPTable.addCell(cell2);
			pdfPTable.addCell(cell3);
			pdfPTable.addCell(cell4);

			pdfPTable.setWidth(width);
			doc.add(pdfPTable);

			

			Paragraph exchange = new Paragraph("TOTAL RETURN AMOUNT :Rs."+formatter.format(totalValue));
			exchange.setFontSize(8f);
			exchange.setBold();
			exchange.setHorizontalAlignment(HorizontalAlignment.CENTER);
			exchange.setTextAlignment(TextAlignment.CENTER);
			exchange.setFixedLeading(6);



			doc.add(line);
			doc.add(exchange);
			doc.add(line);
			doc.close();

			return;

		} catch (Exception e) {
			System.out.println("Exception in generateItemCodeBarcodePdf : " + e);
			e.printStackTrace();
		} finally {
			if (doc != null) {
				doc.close();
			}

		}

	}

	public static String getCurrentTime() {

		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

		return (sdf.format(cal.getTime()));
	}

	private String getDate() {

		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		return format1.format(new Date());

	}
}

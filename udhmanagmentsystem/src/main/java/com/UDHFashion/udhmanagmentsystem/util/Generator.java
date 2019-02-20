package com.UDHFashion.udhmanagmentsystem.util;

import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.swing.GroupLayout.Alignment;

import com.UDHFashion.udhmanagmentsystem.model.Barcode;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.Barcode128;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class Generator {

	private static DecimalFormat df2 = new DecimalFormat(".##");
	
	
	public static String generateNextItemCode(List<String> itemCodes, int shopId) {

		String newItemCode = "";
		String priceValue = ""; //to store the price value for later calculations

		List<Integer> codeListForMax = new ArrayList<Integer>();

		/*-------------- iterate through the itemCode list to break the incrementing part--------------*/
		for (String itemCode : itemCodes) {

			// remove the String values from the id
			String tempCode = itemCode.replaceAll("[^0-9]", "");

			// get the middle value incremented
			int count = 0;
			String concatShopId = ""; // used to concatenate the Shop Id when iterating through the loop

			for (count = 0; count < tempCode.length(); ++count) {

				if (concatShopId.equalsIgnoreCase(Integer.toString(shopId))) {

					break;
				}

				concatShopId += tempCode.charAt(count);

			}

			int incrValueStartIndex = count;
			int incrValueEndIndex = tempCode.length() - 2; // the start index of the price amount value

			String incrString = tempCode.substring(incrValueStartIndex, incrValueEndIndex);
			codeListForMax.add(Integer.parseInt(incrString));

		}

		
		for (Integer code : codeListForMax) {
			System.out.println(code);
		}

		/*------------------get the max in the list------------------*/
		int maxCode = Collections.max(codeListForMax);

		// increment the code by 1
		++maxCode;
	
		newItemCode = "I" + shopId + maxCode + itemCodes.get(0).substring( ( itemCodes.get(0).length() - 2) , (itemCodes.get(0).length()) );

		return newItemCode;
	}
	
	/*-------------------Generate Current Date -----------------*/
	public static String getCurrentDate() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String newDate = dateFormat.format(date);
		
		return newDate;
	}
	
	/*-------------------Generate Current Time -----------------*/
	public static String getCurrentTime() {
		
		Calendar cal = Calendar.getInstance();
	    SimpleDateFormat sdf = new SimpleDateFormat("HH-mm-ss");
	    
	     return (sdf.format(cal.getTime()));
	
	}
	
	/*--------------------- To generate the barcode pdf -------------------------------------*/
	public static void generateBarcodePdf(List<Barcode> itemList) {

		String fileName = "BAR_" + getCurrentDate() + "_" + getCurrentTime() + ".pdf";
		String filePath = "C:/Users/" + System.getProperty("user.name") + "/Documents/" + fileName;

		Document doc = new Document();
		PdfWriter docWriter = null;

		try {
			docWriter = PdfWriter.getInstance(doc, new FileOutputStream(filePath));
			doc.addAuthor("BarCode");
			doc.addCreationDate();
			doc.addProducer();
			doc.addCreator("");
			doc.addTitle("");
			doc.setPageSize(PageSize.A4);
			doc.open();
			PdfContentByte cb = docWriter.getDirectContent();

			PdfPTable pdfPTable = new PdfPTable(4);

			/*
			 * PdfPCell pdfCell1 = new PdfPCell(new Phrase("")); PdfPCell pdfCell2 = new
			 * PdfPCell(new Phrase("")); PdfPCell pdfCell3 = new PdfPCell(new Phrase(""));
			 * PdfPCell pdfCell4 = new PdfPCell(new Phrase(""));
			 * 
			 * pdfPTable.addCell(pdfCell1); pdfPTable.addCell(pdfCell2);
			 * pdfPTable.addCell(pdfCell3); pdfPTable.addCell(pdfCell4);
			 */

			//float paddingCount = 20;
			//int hopCount = 1;

			for (Barcode code : itemList) {

				for (int i = 0; i < code.getQuantity(); ++i) {

					Font cjk = new Font();

					Barcode128 code128 = new Barcode128();
					code128.setCode(code.getItemCode().trim());
					code128.setCodeType(Barcode128.CODE128);
					Image code128Image = code128.createImageWithBarcode(cb, null, null);

					code128Image.scalePercent(141);

					if (code.getItemCode() == null || code.getItemCode() == "") {
						PdfPCell cell = new PdfPCell();

						pdfPTable.addCell(cell);
					} else {
						PdfPCell cell = new PdfPCell();

						Paragraph p = new Paragraph();

						System.out.println("Round OFf " + Math.round(code.getPrice() * 100.0) / 100.0);
						
						p.add(new Chunk(code128Image, 0, 0));
						p.add(new Phrase("\t\t\nRs: " + df2.format(code.getPrice()) +"0",
								new Font(Font.FontFamily.HELVETICA, 10)));

						
						
						// cell.setBorderWidth(5);

						/*
						cell.setPaddingLeft(13);

						if (hopCount > 20) {
							cell.setPaddingTop(9);
						} else if (hopCount > 4) {
							cell.setPaddingTop(8);
						} else {
							cell.setPaddingTop(paddingCount);
						}

						++hopCount;
						if (hopCount == 85) {
							hopCount = 1;
						}
						*/
						cell.setHorizontalAlignment(Element.ALIGN_CENTER);
						cell.addElement(p);
						cell.setPaddingTop(5);
						cell.setPaddingLeft(8);

						pdfPTable.addCell(cell);
					}

				}

				pdfPTable.setWidthPercentage(110);

			}

			doc.add(pdfPTable);
			doc.close();

			/*
			 * BarcodeEAN codeEAN = new BarcodeEAN(); codeEAN.setCode(myString.trim());
			 * codeEAN.setCodeType(BarcodeEAN.EAN13); Image codeEANImage =
			 * code128.createImageWithBarcode(cb, null, null);
			 * codeEANImage.setAbsolutePosition(10, 600); codeEANImage.scalePercent(125);
			 * doc.add(codeEANImage);
			 */

		} catch (Exception e) {
			System.out.println("Exception in generateItemCodeBarcodePdf : " + e);
		} finally {
			if (doc != null) {
				doc.close();
			}
			if (docWriter != null) {
				docWriter.close();
			}
		}
	}
}

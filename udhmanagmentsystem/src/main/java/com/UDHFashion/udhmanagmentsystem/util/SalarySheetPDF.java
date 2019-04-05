package com.UDHFashion.udhmanagmentsystem.util;

import com.UDHFashion.udhmanagmentsystem.model.Salary;
import com.itextpdf.io.font.FontConstants;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.HorizontalAlignment;
import com.itextpdf.layout.property.TextAlignment;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.AbstractView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@Component("salarySheet")
public class SalarySheetPDF extends AbstractView {

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		response.setHeader("Content-Disposition", "attachment; filename=salarySheet.pdf");
		Salary report = (Salary) model.get("report");

		NumberFormat formatter = new DecimalFormat("#0.00");
		report.setTotalBussines(Double.parseDouble(formatter.format(report.getTotalBussines())));
		report.setBasicSalary(Double.parseDouble(formatter.format(report.getBasicSalary())));
		report.setBonus(Double.parseDouble(formatter.format(report.getBonus())));
		report.setBasicSalary(Double.parseDouble(formatter.format(report.getBasicSalary())));
		report.setTotalSalray(Double.parseDouble(formatter.format(report.getTotalSalray())));

		// IText API
		PdfWriter pdfWriter = new PdfWriter(response.getOutputStream());
		PdfDocument pdf = new PdfDocument(pdfWriter);
		Document pdfDocument = new Document(pdf);

		// title
		Paragraph title = new Paragraph("UDH FASHIONS");
		title.setFont(PdfFontFactory.createFont(FontConstants.HELVETICA));
		title.setFontSize(20f);
		title.setBold();
		title.setHorizontalAlignment(HorizontalAlignment.CENTER);
		title.setTextAlignment(TextAlignment.CENTER);
		title.setFixedLeading(20);
		pdfDocument.add(title);

		// Adress
		Paragraph address = new Paragraph("No : 12, Main Street, Anuradhapura");
		address.setFont(PdfFontFactory.createFont(FontConstants.HELVETICA));
		address.setFontSize(10f);
		address.setItalic();
		address.setHorizontalAlignment(HorizontalAlignment.CENTER);
		address.setTextAlignment(TextAlignment.CENTER);
		address.setFixedLeading(5);
		pdfDocument.add(address);

		// tp number
		Paragraph tpNumber = new Paragraph("Contact Number : 077 234 5678 / 071 232 2223");
		tpNumber.setFont(PdfFontFactory.createFont(FontConstants.HELVETICA));
		tpNumber.setFontSize(10f);
		tpNumber.setItalic();
		tpNumber.setHorizontalAlignment(HorizontalAlignment.CENTER);
		tpNumber.setTextAlignment(TextAlignment.CENTER);
		tpNumber.setFixedLeading(5);
		pdfDocument.add(tpNumber);

		// break
		Paragraph newline = new Paragraph("\n");
		pdfDocument.add(newline);

		// date
		Paragraph date = new Paragraph("Date : " + getCurrentDate());
		date.setFontSize(11f);
		pdfDocument.add(date);

		// break
		pdfDocument.add(newline);

		// Employee Name
		Paragraph name = new Paragraph(report.getEmpName());
		name.setFont(PdfFontFactory.createFont(FontConstants.HELVETICA));
		name.setFontSize(13f);
		name.setBold();
		name.setFixedLeading(5);
		pdfDocument.add(name);

		// Employee Number
		Paragraph number = new Paragraph("Employee No: " + report.getEmpNo());
		number.setFont(PdfFontFactory.createFont(FontConstants.HELVETICA));
		number.setFontSize(10f);
		pdfDocument.add(number);

		// break
		pdfDocument.add(newline);

		// Absent Days and Number
		Table pdfPTable = new Table(2);

		Cell pdfCell1 = new Cell().add(new Paragraph("Present Days : " + report.getPresent()));
		pdfCell1.setBorder(Border.NO_BORDER);

		Cell pdfCell2 = new Cell().add(new Paragraph("Absent Days : " + report.getAbsent()));
		pdfCell2.setBorder(Border.NO_BORDER);

		pdfPTable.addCell(pdfCell1);
		pdfPTable.addCell(pdfCell2);

		pdfPTable.setWidth(700);

		pdfDocument.add(pdfPTable);

		// Total Business and bonus
		Paragraph bonus = new Paragraph("Total Business : Rs." + report.getTotalBussines());
		bonus.setFont(PdfFontFactory.createFont(FontConstants.HELVETICA));
		bonus.setFontSize(12f);
		pdfDocument.add(bonus);

		// earnings
		Paragraph earnings = new Paragraph("Earnings");
		earnings.setFont(PdfFontFactory.createFont(FontConstants.HELVETICA));
		earnings.setFontSize(12f);
		earnings.setBold();
		earnings.setFixedLeading(30);
		pdfDocument.add(earnings);

		// Earnings table

		// Basic Salary
		Table salaryTable = new Table(2);

		Cell sCell1 = new Cell().add(new Paragraph("Basic Salary : "));

		Cell sCell2 = new Cell().add(new Paragraph("Rs." + report.getBasicSalary()));

		salaryTable.addCell(sCell1);
		salaryTable.addCell(sCell2);

		// bonus
		Cell sCell3 = new Cell().add(new Paragraph("Bonus : "));
		sCell3.setWidth(225);
		Cell sCell4 = new Cell().add(new Paragraph("Rs." + report.getBonus()));
		sCell4.setWidth(225);
		salaryTable.addCell(sCell3);
		salaryTable.addCell(sCell4);

		salaryTable.setWidth(550);

		pdfDocument.add(salaryTable);

		// deductions
		Paragraph deductions = new Paragraph("Deductions");
		deductions.setFont(PdfFontFactory.createFont(FontConstants.HELVETICA));
		deductions.setFontSize(12f);
		deductions.setBold();
		deductions.setFixedLeading(30);
		pdfDocument.add(deductions);

		// deduction table

		// Advance payment
		Table deductionTable = new Table(2);

		Cell sCell5 = new Cell().add(new Paragraph("Advance Payments : "));
		sCell5.setWidth(235);
		
		Cell sCell6 = new Cell().add(new Paragraph("Rs." + report.getAdvancePayment()));
		sCell6.setWidth(225);
		
		deductionTable.addCell(sCell5);
		deductionTable.addCell(sCell6);

		deductionTable.setWidth(550);

		pdfDocument.add(deductionTable);

		// break
		pdfDocument.add(newline);

		// break
		pdfDocument.add(newline);
		
		// total salary
		Paragraph total = new Paragraph("Total Salary : \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t  Rs." + report.getTotalSalray());
		total.setFont(PdfFontFactory.createFont(FontConstants.HELVETICA));
		total.setFontSize(13f);
		total.setBold();
		pdfDocument.add(total);

		pdfDocument.close();

		
	}

	private String getCurrentDate() {

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String newDate = dateFormat.format(date);

		return newDate;

	}

}
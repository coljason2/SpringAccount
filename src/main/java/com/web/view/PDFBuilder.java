package com.web.view;

import java.text.NumberFormat;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.web.model.AccountForm;
import com.web.model.MedItem;

/**
 * This view class generates a PDF document 'on the fly' based on the data
 * contained in the model.
 * 
 * @author www.codejava.net
 *
 */

public class PDFBuilder extends AbstractITextPdfView {
	NumberFormat nf = NumberFormat.getInstance();

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document doc, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// get data model which is passed by the Spring container
		AccountForm form = (AccountForm) model.get("form");
		List<MedItem> listMedItems = form.getMedItems();
		BaseFont bfChinese = BaseFont.createFont("C:\\windows\\fonts\\KAIU.TTF", BaseFont.IDENTITY_H,
				BaseFont.NOT_EMBEDDED);
		Font ChFont = new Font(bfChinese, 16);
		doc.add(new Paragraph("【" + form.getHospital().getHos_name() + "】" + "帳單月份" + form.getAcctDate(), ChFont));

		PdfPTable table = new PdfPTable(9);
		table.setWidthPercentage(100.0f);
		// table.setWidths(new float[] { 3.0f, 2.0f, 2.0f, 2.0f, 1.0f });
		table.setSpacingBefore(8);

		// define font for table header row
		Font font = FontFactory.getFont(FontFactory.HELVETICA);
		font.setColor(BaseColor.WHITE);

		//Cell cellHeader = new Cell(new Phrase("表頭一",FontChinese));
		
		
		// define table header cell
		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(BaseColor.WHITE);
		cell.setPadding(5);
		
		
		// write table header
		cell.setPhrase(new Phrase("藥廠", ChFont));
		table.addCell(cell);
		cell.setPhrase(new Phrase("進貨日", ChFont));
		table.addCell(cell);
		cell.setPhrase(new Phrase("藥品", ChFont));
		table.addCell(cell);
		cell.setPhrase(new Phrase("數量", ChFont));
		table.addCell(cell);
		cell.setPhrase(new Phrase("價格", ChFont));
		table.addCell(cell);
		cell.setPhrase(new Phrase("折扣1", ChFont));
		table.addCell(cell);
		cell.setPhrase(new Phrase("折扣2", ChFont));
		table.addCell(cell);
		cell.setPhrase(new Phrase("折扣3", ChFont));
		table.addCell(cell);
		cell.setPhrase(new Phrase("總價", ChFont));
		table.addCell(cell);
		table.setHeaderRows(1);
		int FormTotal = 0;
		// write table row data
		for (MedItem MedItem : listMedItems) {
			table.addCell(MedItem.getCompany());
			table.addCell(MedItem.getInputdate());
			table.addCell(MedItem.getMedicine());
			table.addCell(String.valueOf(nf.format(MedItem.getItemcount())));
			table.addCell(String.valueOf(nf.format(MedItem.getInput_cost())));
			table.addCell(String.valueOf(nf.format(MedItem.getDiscount1())));
			table.addCell(String.valueOf(nf.format(MedItem.getDiscount2())));
			table.addCell(String.valueOf(nf.format(MedItem.getDiscount3())));
			table.addCell(String.valueOf(nf.format(MedItem.getTotal())));
			FormTotal = FormTotal + MedItem.getTotal();
		}

		table.addCell("");
		table.addCell("");
		table.addCell("");
		table.addCell("");
		table.addCell("");
		table.addCell("");
		table.addCell("");
		table.addCell("TOTAL");
		table.addCell(String.valueOf(nf.format(FormTotal)));

		doc.add(table);

	}

}
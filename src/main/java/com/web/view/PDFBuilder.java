package com.web.view;

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

/**
 * This view class generates a PDF document 'on the fly' based on the data
 * contained in the model.
 * 
 * @author www.codejava.net
 *
 */

public class PDFBuilder extends AbstractITextPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document doc, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// get data model which is passed by the Spring container
		// List<Book> listBooks = (List<Book>) model.get("listBooks");
		BaseFont bfChinese = BaseFont.createFont("C:\\windows\\fonts\\KAIU.TTF", BaseFont.IDENTITY_H,
				BaseFont.NOT_EMBEDDED);
		Font ChFont = new Font(bfChinese, 12);
		doc.add(new Paragraph("帳單", ChFont));

		PdfPTable table = new PdfPTable(9);
		table.setWidthPercentage(100.0f);
		// table.setWidths(new float[] { 3.0f, 2.0f, 2.0f, 2.0f, 1.0f });
		table.setSpacingBefore(10);

		// define font for table header row
		Font font = FontFactory.getFont(FontFactory.HELVETICA);
		font.setColor(BaseColor.WHITE);

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
		// write table row data
		// for (Book aBook : listBooks) {
		// table.addCell(aBook.getTitle());
		// table.addCell(aBook.getAuthor());
		// table.addCell(aBook.getIsbn());
		// table.addCell(aBook.getPublishedDate());
		// table.addCell(String.valueOf(aBook.getPrice()));
		// }

		doc.add(table);

	}

}
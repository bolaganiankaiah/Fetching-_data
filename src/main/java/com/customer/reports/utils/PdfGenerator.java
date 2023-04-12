package com.customer.reports.utils;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import com.customer.reports.entity.CustomerEntity;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;


@Component
public class PdfGenerator {
	

	public void generate(HttpServletResponse response,List<CustomerEntity> plans) throws Exception {
		

		Document document = new Document(PageSize.A4);


		PdfWriter.getInstance(document, response.getOutputStream());

		document.open();



		Font fontTiltle = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		fontTiltle.setSize(20);


		Paragraph paragraph = new Paragraph("Citizen Plans", fontTiltle);


		paragraph.setAlignment(Paragraph.ALIGN_CENTER);

	
		document.add(paragraph);


		PdfPTable table = new PdfPTable(6);
		table.setSpacingBefore(8);
      
		table.addCell("ID");
		table.addCell("Customer Name");
	    table.addCell("Customer Plan");
		table.addCell("Plan Status");
		table.addCell("Start Date");
		table.addCell("End Date");


      for (CustomerEntity plan : plans)
 {
     table.addCell(String.valueOf(plan.getCustomerId()));
     table.addCell(plan.getCustomerName());
     table.addCell(plan.getPlanName());
     table.addCell(plan.getPlanStatus());
     table.addCell(plan.getPlanStartDate() +"");
     table.addCell(plan.getPlanEndDate()+"");


}
		document.add(table);


		document.close();
	}
}

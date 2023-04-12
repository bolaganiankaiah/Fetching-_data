package com.customer.reports.utils;

import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;

import com.customer.reports.entity.CustomerEntity;


@Component
public class ExcelGenerator {


	public void generate (HttpServletResponse response,List<CustomerEntity> records) throws Exception {

		Workbook workbook = new HSSFWorkbook();
		Sheet sheet = workbook.createSheet("plans-info");
		Row headerRow = sheet.createRow(0);
		headerRow.createCell(0).setCellValue("ID");
		headerRow.createCell(1).setCellValue("Customer Name");
		headerRow.createCell(2).setCellValue("Gender");
		headerRow.createCell(3).setCellValue("Plan Name");
		headerRow.createCell(4).setCellValue("Plan Status");
		headerRow.createCell(5).setCellValue("Plan Start Date");
		headerRow.createCell(6).setCellValue("Plan End Date");
		headerRow.createCell(7).setCellValue("Benefit Amount");




		int dataRowIndex = 1;

		for (CustomerEntity plan : records)
		{
			Row dataRow = sheet.createRow(dataRowIndex);
			dataRow.createCell(0).setCellValue(plan.getCustomerId());
			dataRow.createCell(1).setCellValue(plan.getCustomerName());
			dataRow.createCell(2).setCellValue(plan.getGender());
			dataRow.createCell(3).setCellValue(plan.getPlanName());
			dataRow.createCell(4).setCellValue(plan.getPlanStatus());
			dataRow.createCell(5).setCellValue(plan.getPlanStartDate());
			dataRow.createCell(6).setCellValue(plan.getPlanEndDate());
			
			if (null!= plan.getBenefitAmount())
			{
				dataRow.createCell(7).setCellValue(plan.getBenefitAmount());
			}
			else {
				
				dataRow.createCell(7).setCellValue("N/A");
			}



			dataRowIndex++;

		}
		ServletOutputStream outputStream = response.getOutputStream();
		workbook.write(outputStream);
		workbook.close();
}
}
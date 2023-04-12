package com.customer.reports.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.customer.reports.dto.SearchRequest;
import com.customer.reports.entity.CustomerEntity;
import com.customer.reports.repo.CustomerRepo;
import com.customer.reports.utils.ExcelGenerator;
import com.customer.reports.utils.PdfGenerator;


@Service
public class CustomerServiceIMPL implements CustomerService {

	@Autowired

	public CustomerRepo repo;
	
	@Autowired
	private ExcelGenerator excelgenerator;
	
	@Autowired
	private PdfGenerator pdfGenerator;

	@Override
	public List<String> getplanName() {
		return repo.getplanName();
	}

	@Override
	public List<String> getplanStatus() {
		return repo.getplanStatus();
	}
	
	

	@Override
	public List<CustomerEntity> getCustomerEntities(SearchRequest request) {

		CustomerEntity entity = new CustomerEntity();

		if (null != request.getPlanName() && !"".equals(request.getPlanName())) {
			entity.setPlanName(request.getPlanName());
		}

		if (null != request.getPlanStatus() && !"".equals(request.getPlanStatus())) {
			entity.setPlanStatus(request.getPlanStatus());
		}

		if (null != request.getGender() && !"".equals(request.getGender())) {
			entity.setGender(request.getGender());
		}

		if (null != request.getStartDate() && !"".equals(request.getStartDate())) {
			String startDate = request.getStartDate();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate localDate = LocalDate.parse(startDate, formatter);
			entity.setPlanStartDate(localDate);
		}
		return repo.findAll(Example.of(entity));
	}
	
	
	@Override
	public boolean exportExcel(HttpServletResponse response) throws Exception {
		
		List<CustomerEntity> plans = repo.findAll();
		excelgenerator.generate(response, plans);
		
		return true;
	}


	
	@Override
	public boolean exportPdf(HttpServletResponse response) throws Exception {
		

		List<CustomerEntity> plans = repo.findAll();
		pdfGenerator.generate(response, plans);
			
	
		return true;
	}

}

package com.customer.reports.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.customer.reports.dto.SearchRequest;
import com.customer.reports.entity.CustomerEntity;


@Service
public interface CustomerService {
	
	public List<String> getplanName();
	public List<String> getplanStatus();
	public List<CustomerEntity> getCustomerEntities(SearchRequest request);
	public boolean exportExcel(HttpServletResponse response) throws Exception;
	public boolean exportPdf(HttpServletResponse response) throws Exception;
		
	

}

package com.customer.reports.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.customer.reports.dto.SearchRequest;
import com.customer.reports.entity.CustomerEntity;
import com.customer.reports.service.CustomerService;

import lombok.Data;

@Controller
@Data

public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/excel")

	public void pdfExport(HttpServletResponse response) throws Exception {
		response.setContentType("application/octet-stream");
		response.addHeader("content-Disposition", "attachment;filename=plans.xls;attachement");
		customerService.exportExcel(response);
	}
	

	@GetMapping("/pdf")

	public void excelExport(HttpServletResponse response) throws Exception {
		response.setContentType("application/pdf");
		response.addHeader("content-Disposition", "attachment;filename=plans.pdf;attachement");
		customerService.exportPdf(response);
	}

	@PostMapping("/search")
	public String handleSearch(SearchRequest search, Model model) {

		System.out.println(search);
		List<CustomerEntity> plans = customerService.getCustomerEntities(search);
		model.addAttribute("plans", plans);
		model.addAttribute("search", search);
		init(model);

		return "index";
	}

	@GetMapping("/")
	public String indexPage(Model model) {

		model.addAttribute("search", new SearchRequest());

		init(model);

		return "index";
	}

	private void init(Model model) {

		model.addAttribute("names", customerService.getplanName());
		model.addAttribute("status", customerService.getplanStatus());
	}
}
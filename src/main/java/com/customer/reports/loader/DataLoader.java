package com.customer.reports.loader;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.customer.reports.entity.CustomerEntity;
import com.customer.reports.repo.CustomerRepo;

@Component
public class DataLoader implements ApplicationRunner {

	@Autowired

	private CustomerRepo repo;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		repo.deleteAll();

		CustomerEntity c1 = new CustomerEntity();

		c1.setCustomerName("David");
		c1.setGender("Male");
		c1.setPlanName("Cash");
		c1.setPlanStatus("Approved");
		c1.setPlanStartDate(LocalDate.now());
		c1.setPlanEndDate(LocalDate.now().plusMonths(6));
		c1.setBenefitAmount(2000.00);

		CustomerEntity c2 = new CustomerEntity();

		c2.setCustomerName("Smith");
		c2.setGender("Male");
		c2.setPlanName("Cash");
		c2.setPlanStatus("Denied");
		c2.setDenialReason("Rental Income");

		CustomerEntity c3 = new CustomerEntity();

		c3.setCustomerName("Dany");
		c3.setGender("Male");
		c3.setPlanName("Cash");
		c3.setPlanStatus("Terminated");
		c3.setPlanStartDate(LocalDate.now().minusMonths(4));
		c3.setPlanEndDate(LocalDate.now().plusMonths(6));
		c3.setBenefitAmount(4000.00);
		c3.setTerminationDate(LocalDate.now());
		c3.setTerminationReason("Salaried");

		// food plan

		CustomerEntity c4 = new CustomerEntity();

		c4.setCustomerName("John");
		c4.setGender("Fe-Male");
		c4.setPlanName("Food");
		c4.setPlanStatus("Approved");
		c4.setPlanStartDate(LocalDate.now());
		c4.setPlanEndDate(LocalDate.now().plusMonths(6));
		c4.setBenefitAmount(4000.00);

		CustomerEntity c5 = new CustomerEntity();

		c5.setCustomerName("Robert");
		c5.setGender("Male");
		c5.setPlanName("Food");
		c5.setPlanStatus("Denied");
		c5.setDenialReason("external Income");

		CustomerEntity c6 = new CustomerEntity();

		c6.setCustomerName("Orlen");
		c6.setGender("Fe-Male");
		c6.setPlanName("Food");
		c6.setPlanStatus("Approved");
		c6.setPlanStartDate(LocalDate.now().minusMonths(4));
		c6.setPlanEndDate(LocalDate.now().plusMonths(6));
		c6.setBenefitAmount(4000.00);
		c6.setTerminationDate(LocalDate.now());
		c6.setTerminationReason("Got Job");

		// medical field

		CustomerEntity c7 = new CustomerEntity();

		c7.setCustomerName("Charles");
		c7.setGender("Male");
		c7.setPlanName("Medical");
		c7.setPlanStatus("Terminated");
		c7.setPlanStartDate(LocalDate.now());
		c7.setPlanEndDate(LocalDate.now().plusMonths(6));
		c7.setBenefitAmount(5000.00);

		CustomerEntity c8 = new CustomerEntity();

		c8.setCustomerName("Raj");
		c8.setGender("Male");
		c8.setPlanName("Medical");
		c8.setPlanStatus("Denied");
		c8.setDenialReason("Property Income");

		CustomerEntity c9 = new CustomerEntity();

		c9.setCustomerName("Neel");
		c9.setGender("Fe-Male");
		c9.setPlanName("Cash");
		c9.setPlanStatus("Terminated");
		c9.setPlanStartDate(LocalDate.now().minusMonths(4));
		c9.setPlanEndDate(LocalDate.now().plusMonths(6));
		c9.setBenefitAmount(4000.00);
		c9.setTerminationDate(LocalDate.now());
		c9.setTerminationReason("Got Job");

		// Employment data

		CustomerEntity c10 = new CustomerEntity();

		c10.setCustomerName("Steeve");
		c10.setGender("Male");
		c10.setPlanName("Employement");
		c10.setPlanStatus("Approved");
		c10.setPlanStartDate(LocalDate.now());
		c10.setPlanEndDate(LocalDate.now().plusMonths(6));
		c10.setBenefitAmount(5000.00);

		CustomerEntity c11 = new CustomerEntity();

		c11.setCustomerName("Moris");
		c11.setGender("Male");
		c11.setPlanName("Medical");
		c11.setPlanStatus("Denied");
		c11.setDenialReason("Property Income");

		CustomerEntity c12 = new CustomerEntity();

		c12.setCustomerName("Gibs");
		c12.setGender("Fe-Male");
		c12.setPlanName("Cash");
		c12.setPlanStatus("Terminated");
		c12.setPlanStartDate(LocalDate.now().minusMonths(4));
		c12.setPlanEndDate(LocalDate.now().plusMonths(6));
		c12.setBenefitAmount(4000.00);
		c12.setTerminationDate(LocalDate.now());
		c12.setTerminationReason("Got Job");

List<CustomerEntity> list = Arrays.asList(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12);
		repo.saveAll(list);
	}

}

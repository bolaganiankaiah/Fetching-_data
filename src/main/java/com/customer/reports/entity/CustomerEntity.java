package com.customer.reports.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Data
@Entity
@Table(name = "customer_reports")
public class CustomerEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private Integer customerId;
	private String customerName;
	private String gender;
	private String planName;
	private String planStatus;
	private LocalDate planStartDate;
	private LocalDate planEndDate;
	private Double  benefitAmount;
	private String denialReason;
	private LocalDate terminationDate;
	private String terminationReason;
	
	
	
}

package com.customer.reports.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.customer.reports.entity.CustomerEntity;


@Repository
public interface CustomerRepo extends JpaRepository<CustomerEntity, Integer> {

	
	
	@Query("select distinct (planName) from CustomerEntity")
	public List<String> getplanName();
	
	
	@Query("select distinct(planStatus) from CustomerEntity")
    public List<String> getplanStatus();	

}

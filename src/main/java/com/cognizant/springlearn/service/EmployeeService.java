package com.cognizant.springlearn.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cognizant.springlearn.dao.EmployeeDao;

@Component
public class EmployeeService {
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeService.class);
	private EmployeeDao employeeDao;
	
	@Autowired
	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
		LOGGER.info("Inside EmployeeService EmployeeDao setter");
	}

	public EmployeeDao getEmployeeDao() {
		return employeeDao;
	}
}

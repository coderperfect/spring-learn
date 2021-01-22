package com.cognizant.springlearn.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class EmployeeDao {
	private String daoMessage = "Hard-coded Message";
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeDao.class);

	public String getDaoMessage() {
		return daoMessage;
	}

	public void setDaoMessage(String daoMessage) {
		this.daoMessage = daoMessage;
		LOGGER.info("Inside EmployeeDao Message setter");
	}
}

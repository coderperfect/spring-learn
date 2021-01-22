package com.cognizant.springlearn.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.springlearn.controller.EmployeeController;

@SpringBootApplication
@ComponentScan(basePackages = "com.cognizant.springlearn.controller, com.cognizant.springlearn.service, com.cognizant.springlearn.dao")
public class SpringLearnApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

	private static void displayEmployee() {
		LOGGER.info("START");
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
		
		Employee employee = (Employee) context.getBean("employee");
		
		LOGGER.debug(employee.toString());
		
		context.close();
		
		LOGGER.info("END");
	}
	
	private static void displayEmployeeControllerXML() {
		LOGGER.info("START");
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
		
		EmployeeController employeeController = (EmployeeController) context.getBean("employeeController");
		
		LOGGER.debug(employeeController.toString());
		
		context.close();
		
		LOGGER.info("END");
	}
	
	private static void displayEmployeeControllerXMLAW() {
		LOGGER.info("START");
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
		
		EmployeeController employeeController = (EmployeeController) context.getBean("employeeController");
		
		LOGGER.debug(employeeController.toString());
		
		context.close();
		
		LOGGER.info("END");
	}
	
	public static void displayEmployeeControllerAnnotation(ApplicationContext applicationContext) {
		LOGGER.info("START");
		EmployeeController employeeController = (EmployeeController) applicationContext.getBean("employeeController");
		LOGGER.debug(employeeController.toString());
		LOGGER.info("END");
	}
	
	
	
	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(SpringLearnApplication.class, args);
		
//		 Module 08 - 03 - Q1 & Q2 & Q3
		displayEmployee();
		
		// Module 08 - 03 - Q4
		displayEmployeeControllerXML();
		
		displayEmployeeControllerXMLAW();
		
		displayEmployeeControllerAnnotation(applicationContext);
		
	}

}
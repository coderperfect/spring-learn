package com.cognizant.springlearn;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.springlearn.bean.Country;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class SpringLearnApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

	public static void displayDate() {
		LOGGER.info("START");

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
		SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);

		try {
			Date date = format.parse("31/12/2018");

			// Module08: HandsOn 02 - Q3
			LOGGER.debug(date.toString());
		} catch (ParseException e) {
			e.printStackTrace();
		}

		context.close();

		LOGGER.info("END");

	}

	public static void displayCountry() {
		LOGGER.info("START");
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

		Country country = context.getBean("country", Country.class);
		
		Country anotherCountry = context.getBean("country", Country.class);

		LOGGER.debug("Country : {}", country.toString());
		
		// Module08: HandsOn 02 - Q5
		LOGGER.debug("Country : {}", anotherCountry.toString());

		context.close();
		
		LOGGER.info("END");
	}
	
	public static void displayCountries() {
		LOGGER.info("START");
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

		@SuppressWarnings("unchecked")
		List<Country> countryList = (ArrayList<Country>) (context.getBean("countryList"));
		
		LOGGER.debug("Country : {}", countryList.toString());

		context.close();
		
		LOGGER.info("END");
	}

	public static void main(String[] args) {
		// Module08: HandsOn 02 - Q1
		SpringApplication.run(SpringLearnApplication.class, args);

		// Module08: HandsOn 02 - Q2
		displayDate();
		
		// Module08: HandsOn 02 - Q4
		displayCountry();
		
		// Module08: HandsOn 02 - Q6
		displayCountries();
	}

}

////////


//package com.cognizant.springlearn.bean;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//import com.cognizant.springlearn.controller.EmployeeController;
//
//@SpringBootApplication
//@ComponentScan(basePackages = "com.cognizant.springlearn.controller, com.cognizant.springlearn.service, com.cognizant.springlearn.dao")
//public class SpringLearnApplication {
//
//	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);
//
//	private static void displayEmployee() {
//		LOGGER.info("START");
//		
//		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
//		
//		Employee employee = (Employee) context.getBean("employee");
//		
//		LOGGER.debug(employee.toString());
//		
//		context.close();
//		
//		LOGGER.info("END");
//	}
//	
//	private static void displayEmployeeControllerXML() {
//		LOGGER.info("START");
//		
//		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
//		
//		EmployeeController employeeController = (EmployeeController) context.getBean("employeeController");
//		
//		LOGGER.debug(employeeController.toString());
//		
//		context.close();
//		
//		LOGGER.info("END");
//	}
//	
//	private static void displayEmployeeControllerXMLAW() {
//		LOGGER.info("START");
//		
//		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
//		
//		EmployeeController employeeController = (EmployeeController) context.getBean("employeeController");
//		
//		LOGGER.debug(employeeController.toString());
//		
//		context.close();
//		
//		LOGGER.info("END");
//	}
//	
//	public static void displayEmployeeControllerAnnotation(ApplicationContext applicationContext) {
//		LOGGER.info("START");
//		EmployeeController employeeController = (EmployeeController) applicationContext.getBean("employeeController");
//		LOGGER.debug(employeeController.toString());
//		LOGGER.info("END");
//	}
//	
//	
//	
//	public static void main(String[] args) {
//		ApplicationContext applicationContext = SpringApplication.run(SpringLearnApplication.class, args);
//		
////		 Module 08 - 03 - Q1 & Q2 & Q3
//		displayEmployee();
//		
//		// Module 08 - 03 - Q4
//		displayEmployeeControllerXML();
//		
//		displayEmployeeControllerXMLAW();
//		
//		displayEmployeeControllerAnnotation(applicationContext);
//		
//	}
//
//}
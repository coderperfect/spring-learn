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
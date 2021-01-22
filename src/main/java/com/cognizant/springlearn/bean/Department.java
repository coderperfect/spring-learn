package com.cognizant.springlearn.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Department {
	private int id;
	private String name;

	private static final Logger LOGGER = LoggerFactory.getLogger(Department.class);

	public Department() {
		super();
		LOGGER.info("Inside Department Constructor");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + "]";
	}
}

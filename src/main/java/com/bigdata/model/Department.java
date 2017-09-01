package com.bigdata.model;


import com.datastax.driver.mapping.annotations.Field;
import com.datastax.driver.mapping.annotations.UDT;

public class Department{

	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Department(String name) {		
		this.name = name;
	}
	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}

}

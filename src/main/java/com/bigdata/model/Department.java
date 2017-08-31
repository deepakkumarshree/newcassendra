package com.bigdata.model;


import com.datastax.driver.mapping.annotations.Field;
import com.datastax.driver.mapping.annotations.UDT;
@UDT(keyspace="test_validated",name="dept")
public class Department{
	@Field
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

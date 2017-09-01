package com.bigdata.model;

import org.springframework.data.cassandra.mapping.CassandraType;
import org.springframework.data.cassandra.mapping.UserDefinedType;

import com.datastax.driver.core.DataType;

@UserDefinedType("address")
public class Address{
	
	public Address(String street, Integer phone) {
		
		this.street = street;
		this.phone = phone;
	}
	//private static final long serialVersionUID = 1L;
	@CassandraType(type = DataType.Name.TEXT) 
	private String street;
	@CassandraType(type = DataType.Name.INT) 
	private Integer phone;
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	
}

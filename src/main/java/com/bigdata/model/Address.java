package com.bigdata.model;

import com.datastax.driver.mapping.annotations.Field;
import com.datastax.driver.mapping.annotations.UDT;
@UDT(keyspace="test_validated", name="address")
public class Address{
	
	public Address(String street, int phone) {
		
		this.street = street;
		this.phone = phone;
	}
	//private static final long serialVersionUID = 1L;
	@Field
	private String street;
	@Field
	private int phone;
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

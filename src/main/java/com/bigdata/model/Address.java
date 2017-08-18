package com.bigdata.model;

import java.io.Serializable;

public class Address implements Serializable{
	
	public Address(String street, int phone) {
		
		this.street = street;
		this.phone = phone;
	}
	private static final long serialVersionUID = 1L;
	private String street;
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

package com.bigdata.model;


import java.io.Serializable;

public class Department  implements Serializable{
	private static final long serialVersionUID = 1L;
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

}

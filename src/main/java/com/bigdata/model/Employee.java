package com.bigdata.model;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.datastax.driver.mapping.annotations.Column;
import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;



@Table(name="employee")
public class Employee implements Serializable{
	private static final long serialVersionUID = 1L;
	@PartitionKey
    private String name;
	private boolean manager;
	private String message;
	private Map<String,String> dept;
	@Column(name="addressList")
	private List <Map<String,Object>> addressList = new ArrayList<Map<String,Object>>();
	@Column(name="employeeLeavesMap")
	private Map<String,Integer> employeeLeavesMap;  
	@Column(name="deductSalary")
	private boolean deductSalary;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isManager() {
		return manager;
	}
	public void setManager(boolean manager) {
		this.manager = manager;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
	
	
	public Map<String, Integer> getEmployeeLeavesMap() {
		return employeeLeavesMap;
	}
	public void setEmployeeLeavesMap(Map<String, Integer> employeeLeavesMap) {
		this.employeeLeavesMap = employeeLeavesMap;
	}
	public boolean isDeductSalary() {
		return deductSalary;
	}
	public void setDeductSalary(boolean deductSalary) {
		this.deductSalary = deductSalary;
	}
	public Employee(String name, boolean manager, String message, Map<String,String> dept, List<Map<String,Object>> addressList,
			Map<String,Integer> employeeLeavesMap, boolean deductSalary) {
		super();
		this.name = name;
		this.manager = manager;
		this.message = message;
		this.dept = dept;
		this.addressList = addressList;
		this.employeeLeavesMap = employeeLeavesMap;
		this.deductSalary = deductSalary;
	}
	public Map<String,String> getDept() {
		return dept;
	}
	public void setDept(Map<String,String> dept) {
		this.dept = dept;
	}
	public List<Map<String, Object>> getAddressList() {
		return addressList;
	}
	public void setAddressList(List<Map<String, Object>> addressList) {
		this.addressList = addressList;
	}
	
	
}

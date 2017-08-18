package com.bigdata.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.data.cassandra.mapping.Table;

@Table(value="employee")
public class Employee implements Serializable{
	private static final long serialVersionUID = 1L;
    private String name;
	private boolean manager;
	private String message;
	private Department dept;
	private List <Address> addressList = new ArrayList<Address>();
	private Map<String, List<Integer>> employeeLeavesMap;  
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
	public Department getDept() {
		return dept;
	}
	public void setDept(Department dept) {
		this.dept = dept;
	}
	public List<Address> getAddressList() {
		return addressList;
	}
	public void setAddressList(List<Address> addressList) {
		this.addressList = addressList;
	}
	public Map<String, List<Integer>> getEmployeeLeavesMap() {
		return employeeLeavesMap;
	}
	public void setEmployeeLeavesMap(Map<String, List<Integer>> employeeLeavesMap) {
		this.employeeLeavesMap = employeeLeavesMap;
	}
	public boolean isDeductSalary() {
		return deductSalary;
	}
	public void setDeductSalary(boolean deductSalary) {
		this.deductSalary = deductSalary;
	}
	public Employee(String name, boolean manager, String message, Department dept, List<Address> addressList,
			Map<String, List<Integer>> employeeLeavesMap, boolean deductSalary) {
		super();
		this.name = name;
		this.manager = manager;
		this.message = message;
		this.dept = dept;
		this.addressList = addressList;
		this.employeeLeavesMap = employeeLeavesMap;
		this.deductSalary = deductSalary;
	}
	
	
}

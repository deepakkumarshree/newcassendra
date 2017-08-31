package com.bigdata.model;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.data.cassandra.mapping.CassandraType;
import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

import com.datastax.driver.core.DataType;
import com.datastax.driver.core.DataType.Name;

@Table(value="employee")
public class Employee implements Serializable{
	private static final long serialVersionUID = 1L;
	@PrimaryKey	
    private String name;	
	private boolean manager;	
	private String message;
	private Department dept;
	@Column(value="addressList")
	@CassandraType(type = Name.LIST , typeArguments= DataType.Name.UDT,userTypeName ="com.bigdata.model.Address")
	private List <Address> addressList = new ArrayList<Address>();
	@Column(value="employeeLeavesMap")
	private Map<String, List<Employeeleavecnt>> employeeLeavesMap;  
	@Column(value="deductSalary")
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
	public Map<String, List<Employeeleavecnt>> getEmployeeLeavesMap() {
		return employeeLeavesMap;
	}
	public void setEmployeeLeavesMap(Map<String, List<Employeeleavecnt>> employeeLeavesMap) {
		this.employeeLeavesMap = employeeLeavesMap;
	}
	public boolean isDeductSalary() {
		return deductSalary;
	}
	public void setDeductSalary(boolean deductSalary) {
		this.deductSalary = deductSalary;
	}
	public Employee(String name, boolean manager, String message, Department dept, List <Address> addressList,
			Map<String, List<Employeeleavecnt>> employeeLeavesMap, boolean deductSalary) {
		super();
		this.name = name;
		this.manager = manager;
		this.message = message;
		this.dept = dept;
		this.addressList = addressList;
		this.employeeLeavesMap = employeeLeavesMap;
		this.deductSalary = deductSalary;
	}
	
	@Override
	public String toString() {
		return "Employee [name=" + name + ", manager=" + manager + ", message=" + message + ", dept=" + dept
				+ ", addressList=" + addressList + ", employeeLeavesMap=" + employeeLeavesMap + ", deductSalary="
				+ deductSalary + "]";
	}
	
	
}

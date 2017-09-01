package com.bigdata.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
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
	private Boolean manager=false;	
	private String message;	
	@CassandraType(type = DataType.Name.UDT,userTypeName="dept")
	private Department dept=new Department();		
	@CassandraType(type = DataType.Name.UDT,userTypeName="address")
	@Column(value="addressList",forceQuote=true)
	private List <Address> addressList = new ArrayList<Address>();
	//@CassandraType(type = DataType.Name.UDT,userTypeName="employeeleavecnt")
	//private Map<String, List<Employeeleavecnt>> employeeLeavesMap;  
	/*@CassandraType(type = DataType.Name.MAP)
	private Map<String, List<Integer>> employeeLeavesMap; */
	
	@Column(value="deductSalary",forceQuote=true)
	private Boolean deductSalary;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		if(message==null)message="";
		this.message = message;
	}
	public Boolean getDeductSalary() {
		return deductSalary;
	}
	public void setDeductSalary(Boolean deductSalary) {
		this.deductSalary = deductSalary;
	}
	public Boolean getManager() {
		return manager;
	}
	public void setManager(Boolean manager) {
		this.manager = manager;
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
	@Override
	public String toString() {
		return "Employee [name=" + name + ", manager=" + manager + ", message=" + message + ", dept=" + dept
				+ ", addressList=" + addressList + ", deductSalary=" + deductSalary + "]";
	}
	public Employee(String name, Boolean manager, String message, Department dept, List<Address> addressList,
			Boolean deductSalary) {
		super();
		this.name = name;
		this.manager = manager;
		this.message = message;
		this.dept = dept;
		this.addressList = addressList;
		this.deductSalary = deductSalary;
	}

	

	
	
	
	
	
}

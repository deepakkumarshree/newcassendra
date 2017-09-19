package com.bigdata.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
/*import org.springframework.data.cassandra.mapping.CassandraType;
import org.springframework.data.cassandra.mapping.Column;*/
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

/*import com.datastax.driver.core.DataType;

import jnr.ffi.mapper.FromNativeConverter.FromNative;*/

@Table(value="employee")
public class Employee implements Serializable{
	private static final long serialVersionUID = 1L;
	@PrimaryKey	
    private String name;	
	private Boolean manager=false;	
	private String message;	
	//@CassandraType(type = DataType.Name.UDT,userTypeName="dept")
	private Department dept=new Department();		
	//@CassandraType(type = DataType.Name.UDT,userTypeName="address")
	//@Column(value="addressList",forceQuote=true)
	private List <Address> addressList = new ArrayList<Address>();	

	private Map<String, List<?>> employeeLeavesMap; 

	
//	@Column(value="deductSalary",forceQuote=true)
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
	public void setAddressList(String addressList) {
		if(addressList!=null)
		{
			JSONArray add=new JSONArray(addressList);
			ArrayList addList=new ArrayList<>();
			for(Object obj:add)
			{
				JSONObject addObj=(JSONObject)obj;
				addList.add(new Address(addObj.getString("street"), addObj.getInt("phone")));
			}
			setAddressList(addList);
		}
	}
	
	public Map<String, List<?>> getEmployeeLeavesMap() {
		return employeeLeavesMap;
	}
	public void setEmployeeLeavesMap(Map<String, List<?>> employeeLeavesMap) {
		this.employeeLeavesMap = employeeLeavesMap;
	}
	public void setEmployeeLeavesMap(String employeeLeavesMap) {
		System.out.println("employeeLeavesMap  ---"+employeeLeavesMap);
		Map<String ,List<?>> leaveMap=new HashMap<String ,List<?>>();
		if(employeeLeavesMap!=null && employeeLeavesMap.length()>2)
		{
			JSONObject leaveObj=new JSONObject(employeeLeavesMap);
			String key=leaveObj.keys().next();
			leaveMap.put(key,(List<?>) leaveObj.get(key));
			
			setEmployeeLeavesMap(leaveMap);
		}
		
	}
	
	

	public Employee(String name, Boolean manager, String message, Department dept, List<Address> addressList,
			Map<String, List<?>> employeeLeavesMap, Boolean deductSalary) {
		super();
		this.name = name;
		this.manager = manager;
		this.message = message;
		this.dept = dept;
		this.addressList = addressList;
		this.employeeLeavesMap = employeeLeavesMap;
		this.deductSalary = deductSalary;
	}
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", manager=" + manager + ", message=" + message + ", dept=" + dept
				+ ", addressList=" + addressList + ", employeeLeavesMap=" + employeeLeavesMap + ", deductSalary="
				+ deductSalary + "]";
	}
	

}

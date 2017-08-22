package com.bigdata.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bigdata.model.Address;
import com.bigdata.model.Department;
import com.bigdata.model.Employee;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ProtocolVersion;
import com.datastax.driver.core.Session;
import com.google.common.collect.ImmutableSet;




@Repository
public class DbConnectionDaoImpl implements DbConnectionDao {
	@Autowired
	EmployeeRepository employeeRepository;
	//@Autowired
   // private CassandraOperations cassandraTemplate;
	public Session getSession() {
		Cluster cluster = Cluster.builder().withPort(9042).withProtocolVersion(ProtocolVersion.V3)
				.withCredentials("cassandra", "cassandra")
				.addContactPoint("13.56.105.107").build();
		Session session = cluster.connect();
		
	/*	  System.out.println("Cluster and Session created with SSL"); 
		  ResultSet	  results = session.execute("SELECT * from test_validated.employee ");
		  for (Row row : results) {
		  System.out.println("data==> "+row.getString("name"));*/
		 

		return session;

	}

	@Override
	public Employee add() {
		// TODO Auto-generated method stub
		List<Address> addressList=new ArrayList<Address>();
		int phone=78585235;
		addressList.add(new Address("om nagar",phone));
		List<Integer> cleave=new ArrayList<Integer>();
		cleave.add(new Integer(10));
		Map<String,List<Integer>> leave=new HashMap<String,List<Integer>>();
		leave.put("CL", cleave);
		
		//Employee(String name, boolean manager, String message, Department dept, List<Address> addressList,
		//Map<String, List<Integer>> employeeLeavesMap, boolean deductSalary)
		Employee employee=new Employee("raj",false,"msg",new Department("dev"),addressList,leave,false);
		employeeRepository.save(ImmutableSet.of(employee));
	//	cassandraTemplate.insert(employee);
		System.out.println(employee);
		return null;//myCassandraTemplate.create(employee, Employee.class);
   }
		
		
	 

	

	@Override
	public void update() {
		// TODO Auto-generated method stub
		System.out.println("updateEmp");
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		System.out.println("deleteEmp");
	}
}

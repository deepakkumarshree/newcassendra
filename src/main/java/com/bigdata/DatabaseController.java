package com.bigdata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bigdata.dao.EmployeeRepository;
import com.bigdata.model.Employee;
import com.bigdata.service.dbConnectionService;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ProtocolVersion;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;



@RestController
@RequestMapping("/cassendraCURDApi")
public class DatabaseController {
	@Autowired
	dbConnectionService dbConnectionService;
	@Autowired
	EmployeeRepository employeeRepository;

	@RequestMapping("/")
	public String hello() {
		System.out.println("Welcome to Cassandra DataBase Connection ---->");
		Cluster cluster = Cluster.builder().withPort(9042).withProtocolVersion(ProtocolVersion.V3)
				.withCredentials("cassandra", "cassandra")
				.addContactPoint("13.56.105.107").build();
		Session session = cluster.connect("test_validated");
		
		  System.out.println("Cluster and Session created with SSL"); 
		  ResultSet
		  results = session.execute("SELECT * from test_validated.employee ");
		  for (Row row : results) {
		  System.out.println("data==> "+row.getString("name"));
		  }

		return "nextPage";
	}

	@RequestMapping("/add")
	public String add() {
		//dbConnectionService.add();
		List<Map<String, Object>> addressList=new ArrayList<Map<String, Object>>();
		
		int phone=78585235;
		Map<String, Object> addmap=new HashMap<String, Object>();
		addmap.put("street", "om nagar");
		addmap.put("phone", phone);
		addressList.add(addmap);
		
		Map<String,Integer> leavecnt=new HashMap<String,Integer>();
		leavecnt.put("cnt", new Integer(10));
		Map<String,String> dep=new HashMap<String,String>();
		dep.put("name","ItdfgDept");
		
		//Employee(String name, boolean manager, String message, Department dept, List<Address> addressList,
		//Map<String, List<Integer>> employeeLeavesMap, boolean deductSalary)
		//Employee employee=new Employee("raj",false,"msg",new Department("dev"),addressList,leave,false);
		Employee employee=new Employee("raj",false,"msg",dep,addressList,leavecnt,false);
		employeeRepository.save(employee);
		
		
		return "add";
	}

	@RequestMapping("/update")
	public String update() {
		
		return "update";
	}

	@RequestMapping("/delete")
	public String delete() {
		//dbConnectionService.delete();
		return "delete";
	}
}

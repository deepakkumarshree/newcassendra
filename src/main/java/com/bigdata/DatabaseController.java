package com.bigdata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bigdata.dao.EmployeeRepository;
import com.bigdata.model.Department;
import com.bigdata.model.Employee;
import com.bigdata.service.dbConnectionService;




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
		/*Cluster cluster = Cluster.builder().withPort(9042).withProtocolVersion(ProtocolVersion.V3)
				.withCredentials("cassandra", "cassandra")
				.addContactPoint("13.56.105.107").build();
		Session session = cluster.connect("test_validated");
		
		  System.out.println("Cluster and Session created with SSL"); 
		  ResultSet
		  results = session.execute("SELECT * from test_validated.employee ");
		//  TypeCodec<Department>   mapper = new MappingManager(session).udtCodec(Department.class);
		  for (Row row : results) 
		  {
			  System.out.println("data==> "+row.getString("name"));
		  	  UDTValue dept = row.getUDTValue("dept");
		  	  List addresslist = row.getList("addressList",Address.class);
		  	  //Map employeeLeavesMap = row.getMap("employeeLeavesMap", String.class, List.class);
		  	  boolean deductSalary = row.getBool("deductSalary");
		  	  boolean manager = row.getBool("manager");
			  String message = row.getString("message");
				System.out.println(deductSalary);
			  	System.out.println(manager);
			  	System.out.println(message);			
			  	System.out.println(dept);
			//  	System.out.println(addresslist);
			  	//System.out.println(employeeLeavesMap);
			  
		  	//  mapper.parse(dept);
		  		
		  		
			
		  
		  
		  }*/
		
		List <Employee> emplist=(List<Employee>)employeeRepository.findAll();
		for(Employee emp:emplist)
		{
			System.out.println("deepak");
			System.out.println(emp);
		}
		

		return "nextPage";
	}

	@RequestMapping("/add")
	public String add() {
		//dbConnectionService.add();
		/*int phone=78585235;
		List<Address> addressList=new ArrayList<Address>();
		Address address = new Address("om nagar",phone);
		addressList.add(address);
	
	
		List<Employeeleavecnt> employeeleavecntList = new ArrayList<Employeeleavecnt>();
		Employeeleavecnt employeeleavecnt = new Employeeleavecnt();
		employeeleavecnt.setCnt(10);
		employeeleavecntList.add(employeeleavecnt);
		Map<String,List<Employeeleavecnt>> leavecnt=new HashMap<String,List<Employeeleavecnt>>();
		leavecnt.put("leave", employeeleavecntList);*/
		List<Map<String, Object>> addressList=new ArrayList<Map<String, Object>>();
	
		//Department dep = new Department("ItdfgDept");
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
		try{
		/*MappingManager manager = new MappingManager(new CassandraConfig().cassandraTemplate().getSession());
		Mapper<Employee> mapper = manager.mapper(Employee.class);
		*/
		
	//	Employee employee=new Employee("raj",false,"msg",dep,null,leavecnt,false);
		//mapper.save(employee);
	//	employeeRepository.save(employee);
		Employee employee=new Employee("raj123",false,"msg",false);		
		employeeRepository.save(employee);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
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

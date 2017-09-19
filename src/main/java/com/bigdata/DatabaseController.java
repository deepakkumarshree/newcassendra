package com.bigdata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bigdata.dao.EmployeeRepository;
import com.bigdata.model.Address;
import com.bigdata.model.Department;
import com.bigdata.model.Employee;
import com.bigdata.model.Employeeleavecnt;
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
		
		int phone=78585235;
		List<Address> addressList=new ArrayList<Address>();
		Address address = new Address("om nagar",phone);
		addressList.add(address);
		Department department=new Department("ItdfgDept");
		
	
	
		/*List<Employeeleavecnt> employeeleavecntList = new ArrayList<Employeeleavecnt>();
		Employeeleavecnt employeeleavecnt = new Employeeleavecnt();
		employeeleavecnt.setCnt(10);
		employeeleavecntList.add(employeeleavecnt);
		Map<String,List<Employeeleavecnt>> leavecnt=new HashMap<String,List<Employeeleavecnt>>();
		leavecnt.put("leave", employeeleavecntList);*/
	
		try{
		
		Employee employee=new Employee("kundan123",false,"msg",department,addressList,null,false);		
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
		int phone=78585235;
		List<Address> addressList=new ArrayList<Address>();
		Address address = new Address("om nagar",phone);
		addressList.add(address);
		Department department=new Department("ItdfgDept");
		
	
	
		/*List<Employeeleavecnt> employeeleavecntList = new ArrayList<Employeeleavecnt>();
		Employeeleavecnt employeeleavecnt = new Employeeleavecnt();
		employeeleavecnt.setCnt(10);
		employeeleavecntList.add(employeeleavecnt);
		Map<String,List<Employeeleavecnt>> leavecnt=new HashMap<String,List<Employeeleavecnt>>();
		leavecnt.put("leave", employeeleavecntList);*/
	
		try{
		
		Employee employee=new Employee("kundan1234",false,"msg",department,addressList,null,false);		
		employeeRepository.save(employee);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	
		return "update";
	}

	@RequestMapping("/delete")
	public String delete() {
		int phone=78585235;
		List<Address> addressList=new ArrayList<Address>();
		Address address = new Address("om nagar",phone);
		addressList.add(address);
		Department department=new Department("ItdfgDept");
		
	
	
	
		/*List<Employeeleavecnt> employeeleavecntList = new ArrayList<Employeeleavecnt>();
		Employeeleavecnt employeeleavecnt = new Employeeleavecnt();
		employeeleavecnt.setCnt(10);
		employeeleavecntList.add(employeeleavecnt);
		Map<String,List<Employeeleavecnt>> leavecnt=new HashMap<String,List<Employeeleavecnt>>();
		leavecnt.put("leave", employeeleavecntList);*/
	
		try{
		
		Employee employee=new Employee("kundan1234",false,"msg",department,addressList,null,false);		
		//employeeRepository.save(employee);
		employeeRepository.delete(employee);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return "delete";
	}
}
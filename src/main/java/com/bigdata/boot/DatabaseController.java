package com.bigdata.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bigdata.service.dbConnectionService;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ProtocolVersion;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;



@RestController

public class DatabaseController {
	@Autowired
	dbConnectionService dbConnectionService;

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
		dbConnectionService.add();
		return "add";
	}

	@RequestMapping("/update")
	public String update() {
		dbConnectionService.update();
		;
		return "add";
	}

	@RequestMapping("/delete")
	public String delete() {
		dbConnectionService.delete();
		return "add";
	}
}

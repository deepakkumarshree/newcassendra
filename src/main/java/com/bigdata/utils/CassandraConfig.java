package com.bigdata.utils;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.boot.json.BasicJsonParser;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonSimpleJsonParser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;
import org.springframework.data.cassandra.config.CassandraSessionFactoryBean;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.convert.CassandraConverter;
import org.springframework.data.cassandra.convert.CustomConversions;
import org.springframework.data.cassandra.convert.MappingCassandraConverter;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.data.cassandra.mapping.BasicCassandraMappingContext;
import org.springframework.data.cassandra.mapping.CassandraMappingContext;
import org.springframework.data.cassandra.mapping.SimpleUserTypeResolver;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.convert.WritingConverter;

import com.bigdata.model.Employee;
import com.datastax.driver.core.ColumnDefinitions;
import com.datastax.driver.core.Row;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
@EnableCassandraRepositories(basePackages = "com.bigdata")
public class CassandraConfig {

	protected String getKeyspaceName() {
		return "test_validated";
	}

	@Bean
	public CassandraClusterFactoryBean cluster() {
		CassandraClusterFactoryBean cluster = new CassandraClusterFactoryBean();
		cluster.setContactPoints("13.56.105.107");
		cluster.setPort(9042);
		cluster.setUsername("cassandra");
		cluster.setPassword("cassandra");
		return cluster;
	}

	@Bean
	public CassandraMappingContext cassandraMapping() throws ClassNotFoundException {
		return new BasicCassandraMappingContext();
	}

	@Bean
	public CassandraSessionFactoryBean session() throws Exception {
		CassandraSessionFactoryBean session = new CassandraSessionFactoryBean();
		session.setCluster(cluster().getObject());
		session.setKeyspaceName("test_validated");
		session.setConverter(converter());
		session.setSchemaAction(SchemaAction.NONE);
		return session;
	}

	@Bean
	public CassandraConverter converter() {
		MappingCassandraConverter mappingCassandraConverter = new MappingCassandraConverter(mappingContext());
		mappingCassandraConverter.setCustomConversions(customConversions());
		return mappingCassandraConverter;
	}

	@Bean
	public CassandraMappingContext mappingContext() {
		BasicCassandraMappingContext mappingContext = new BasicCassandraMappingContext();
		mappingContext.setUserTypeResolver(new SimpleUserTypeResolver(cluster().getObject(), "test_validated"));
		return mappingContext;
	}

	@Bean
	public CassandraOperations cassandraTemplate() throws Exception {
		return new CassandraTemplate(session().getObject());
	}

	@Bean
	public CustomConversions customConversions() {
		return new CustomConversions(Arrays.asList(EmployeeReadConverter.INSTANCE));
	}

	@ReadingConverter
	public enum EmployeeReadConverter implements Converter<Row, Employee> {
		INSTANCE;
		public Employee convert(Row source) {
			Employee emp = new Employee();
			HashMap<String, Object> attr = new HashMap<String, Object>();
			ColumnDefinitions col = source.getColumnDefinitions();
			for (int i = 0; i < col.size(); i++) {
				attr.put(col.getName(i), (source.getObject(i) != null ? source.getObject(i).toString() : null));
				System.out.println(col.getName(i));
				// System.out.println(source.getObject(i).toString());
			}
			JSONObject json = new JSONObject(attr);
			System.out.println("json===>> " + json);
			String jsonInString = json.toString();
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);

			try {
				emp = mapper.readValue(jsonInString, Employee.class);
				System.out.println("emp:::::::::" + emp);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// HashMap<String,List<?>>
			// employeeLeavesMap=(HashMap<String,List<?>>)source.getObject("employeeLeavesMap");
			// System.out.println(employeeLeavesMap);
			// emp.setEmployeeLeavesMap(employeeLeavesMap);

			// System.out.println("Calling of converter");
			return emp;
		}
	}
	/*@WritingConverter
	public enum EmployeeWriteConverter implements Converter<Employee,Row> {
		INSTANCE;
		public Row convert(Employee source) {
			Row emp = new Row();
			HashMap<String, Object> attr = new HashMap<String, Object>();
			ColumnDefinitions col = source.getColumnDefinitions();
			for (int i = 0; i < col.size(); i++) {
				attr.put(col.getName(i), (source.getObject(i) != null ? source.getObject(i).toString() : null));
				System.out.println(col.getName(i));
				// System.out.println(source.getObject(i).toString());
			}
			JSONObject json = new JSONObject(attr);
			System.out.println("json===>> " + json);
			String jsonInString = json.toString();
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);

			try {
				emp = mapper.readValue(jsonInString, Employee.class);
				System.out.println("emp:::::::::" + emp);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// HashMap<String,List<?>>
			// employeeLeavesMap=(HashMap<String,List<?>>)source.getObject("employeeLeavesMap");
			// System.out.println(employeeLeavesMap);
			// emp.setEmployeeLeavesMap(employeeLeavesMap);

			// System.out.println("Calling of converter");
			return emp;
		}
	}*/
}
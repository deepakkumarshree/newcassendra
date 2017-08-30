package com.bigdata.dao;


import org.springframework.data.cassandra.repository.CassandraRepository;
import com.bigdata.model.Employee;
public interface EmployeeRepository extends CassandraRepository<Employee>{

}

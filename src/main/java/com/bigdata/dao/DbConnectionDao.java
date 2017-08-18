package com.bigdata.dao;

import com.bigdata.model.Employee;

public interface DbConnectionDao {
	
	public Employee add();
	public void update();
	public void delete();

}

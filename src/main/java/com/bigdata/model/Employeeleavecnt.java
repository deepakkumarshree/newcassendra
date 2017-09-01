package com.bigdata.model;

import org.springframework.data.cassandra.mapping.CassandraType;
import org.springframework.data.cassandra.mapping.UserDefinedType;

import com.datastax.driver.core.DataType;

@UserDefinedType("employeeleavecnt")
public class Employeeleavecnt {
	@CassandraType(type = DataType.Name.INT) 
	private Integer cnt;

	public int getCnt() {
		return cnt;
	}

	public void setCnt(Integer cnt) {
		this.cnt = cnt;
	}
	

}

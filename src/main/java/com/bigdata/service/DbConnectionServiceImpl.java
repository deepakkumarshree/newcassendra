package com.bigdata.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bigdata.dao.DbConnectionDao;

@Service
public class DbConnectionServiceImpl implements dbConnectionService{	
	@Autowired
	DbConnectionDao dbConnectionDao;
	@Override
	public void add() {
		// TODO Auto-generated method stub
		dbConnectionDao.add();
		System.out.println("addEmpSer");
		
	}
	@Override
	public void update() {
		// TODO Auto-generated method stub
		System.out.println("updateEmpSer");
	}
	@Override
	public void delete() {
		// TODO Auto-generated method stub
		System.out.println("deleteEmpSer");
	}

}

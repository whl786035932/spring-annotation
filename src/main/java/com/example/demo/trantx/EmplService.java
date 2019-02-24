package com.example.demo.trantx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmplService {
	
	@Autowired
	private EmplDao emplDao;
	
	@Transactional
	public void insertEmpl() {
		emplDao.insert();
		int i=1/0;
	}
	
	@Transactional
	public void insertEmpl2() {
		emplDao.insert2();
	}
}

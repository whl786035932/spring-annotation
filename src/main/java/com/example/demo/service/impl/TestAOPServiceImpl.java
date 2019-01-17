package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.TestAopDaoImpl;
import com.example.demo.service.TestAOPService;
/**
 * 定义注解版的切面逻辑
 * @author whl
 *
 */
@Service
public class TestAOPServiceImpl implements TestAOPService{
	@Autowired
	private TestAopDaoImpl testAopDao;
	
	public void addUser() {
		testAopDao.adddUser();
	}

	
}

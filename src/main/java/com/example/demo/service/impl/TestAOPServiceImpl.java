package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.TestAopDaoImpl;
import com.example.demo.service.TestAOPService;
/**
 * ����ע���������߼�
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

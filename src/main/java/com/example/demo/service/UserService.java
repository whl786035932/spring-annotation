package com.example.demo.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserDao;

@Service
public class UserService {
//  @AutowiredĬ���ǰ����Ե����ֵ�idȥIOC�����в�ѯbean
//	@Autowired(required=false)
	
//	@Qualifier��ָ�������id
//	@Autowired
//	@Qualifier(value="userDao")  
	
	
//	@Autowired  //���Դ���@Primaryʹ�ã���Ҫʹ���ĸ����
	
	
	@Resource(name="userDao2") //@Resource�ǰ������ִ�IOC�����в�ѯ����֧��requird=fasle �Ͳ��ܺ�@Primary����ʹ��
	private UserDao userDao;
	@Override
	public String toString() {
		return "UserService��[UserDao]="+userDao;
	}

}

package com.example.demo.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserDao;

@Service
public class UserService {
//  @Autowired默认是按属性的名字当id去IOC容器中查询bean
//	@Autowired(required=false)
	
//	@Qualifier是指定组件的id
//	@Autowired
//	@Qualifier(value="userDao")  
	
	
//	@Autowired  //可以搭配@Primary使用，首要使用哪个组件
	
	
	@Resource(name="userDao2") //@Resource是按照名字从IOC容器中查询，不支持requird=fasle 和不能和@Primary搭配使用
	private UserDao userDao;
	@Override
	public String toString() {
		return "UserService的[UserDao]="+userDao;
	}

}

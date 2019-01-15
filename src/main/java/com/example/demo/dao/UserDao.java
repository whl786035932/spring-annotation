package com.example.demo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	private String label;
	
	@Override
	public String toString() {
		return "UserDao.label="+label;
	}
}

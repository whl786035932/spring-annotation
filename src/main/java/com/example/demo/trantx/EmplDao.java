package com.example.demo.trantx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EmplDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	public void insert() {
		String  sql ="insert into emp(name,age) values('whl',20)";
		jdbcTemplate.update(sql);
	}
	
	public void insert2() {
		String  sql ="insert into emp(name,age) values('whl2',20)";
		jdbcTemplate.update(sql);
	}
}

package com.example.demo.trantx;

import java.beans.PropertyVetoException;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;
@EnableTransactionManagement
@Configuration
@ComponentScan("com.example.demo.trantx")
public class TXConfig {
	
	@Bean
	public DataSource dataSource() {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		 dataSource.setUser("root");
		 dataSource.setPassword("123456");
		 dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test-transactional");
		 try {
			dataSource.setDriverClass("com.mysql.jdbc.Driver");
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return dataSource;
	}
	
	
	@Bean
	public JdbcTemplate jdbcTemplate() throws Exception{
		//Spring��@Configuration������⴦���������м�����ķ�������ε��ö�ֻ�Ǵ������������
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource());
		return jdbcTemplate;
	}
}

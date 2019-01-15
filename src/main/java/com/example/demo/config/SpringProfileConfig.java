package com.example.demo.config;

import java.beans.PropertyVetoException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.StringValueResolver;

import com.example.demo.importt.Yellow;
import com.mchange.v2.c3p0.ComboPooledDataSource;


//@Profile("prod")
@Configuration
@PropertySource("database.properties")
public class SpringProfileConfig implements EmbeddedValueResolverAware{
	
	
	private  String user;
	private String pwd;
	
	private String driverClass;
	
	//如果不指定profile,在任何环境中都会注册到IOC容器中
	@Bean
	public Yellow yellow() {
		return new Yellow();
	}
	
//	@Profile(value="default")   //profile默认的是default
	@Profile(value="test")
	@Bean(name="testDataSource")
	public DataSource testDataSource() {
		System.out.println("user="+user);
		 ComboPooledDataSource dataSource = new ComboPooledDataSource();
		 dataSource.setUser(user);
		 dataSource.setPassword(pwd);
		 dataSource.setJdbcUrl("jdbc:mysql://10.2.17.65:3306/testDruid");
		 try {
			dataSource.setDriverClass(driverClass);
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return dataSource;
	}
	
	@Profile(value="dev")
	@Bean(name="devDataSource")
	public DataSource devDataSource() {
		 ComboPooledDataSource dataSource = new ComboPooledDataSource();
		 dataSource.setUser(user);
		 dataSource.setPassword(pwd);
		 dataSource.setJdbcUrl("jdbc:mysql://10.2.17.65:3306/testDruid");
		 try {
			dataSource.setDriverClass(driverClass);
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return dataSource;
	}
	@Profile(value="prod")
	@Bean(name="prodDataSource")
	public DataSource prodDataSource() {
		 ComboPooledDataSource dataSource = new ComboPooledDataSource();
		 dataSource.setUser(user);
		 dataSource.setPassword(pwd);
		 dataSource.setJdbcUrl("jdbc:mysql://10.2.17.65:3306/testDruid");
		 try {
			dataSource.setDriverClass(driverClass);
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return dataSource;
	}


	public void setEmbeddedValueResolver(StringValueResolver resolver) {
		String driverClass = resolver.resolveStringValue("jdbc.driverClass");
		this.driverClass = driverClass;
		this.user=resolver.resolveStringValue("${jdbc.username}");
		this.pwd= resolver.resolveStringValue("${jdbc.password}");
	}

}

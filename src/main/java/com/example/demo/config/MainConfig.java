package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import com.example.demo.bean.Person;
import com.example.demo.bean.Student;
import com.example.demo.condition.LinuxCondition;
import com.example.demo.condition.WindowCondition;
import com.example.demo.factorybean.MyColorFactoryBean;
import com.example.demo.importselector.MyImportBeanDefinitionRegistrar;
import com.example.demo.importselector.MyImportSelector;
import com.example.demo.importt.Circle;
import com.example.demo.importt.Square;
/**
 * 模拟的是beans.xml=使用配置类
 * @author whl
 * 
 * 使用
 */

@Configuration
@Import(value= {Circle.class,Square.class,MyImportSelector.class,MyImportBeanDefinitionRegistrar.class})
//@ComponentScan(basePackages= {"com.example.demo"})
//@ComponentScans(value= {
//		@ComponentScan(value="com.example",includeFilters= {
//				@Filter(type=FilterType.CUSTOM,value= {Person.class})
//		},useDefaultFilters=false)
//})
public class MainConfig {
	/**
	 * 默认的注入的bean的id是方法名
	 * 如果不想按照方法名注入就修改@Bean的属性
	 * @Lazy是针对单实例的对象，只有再getBean（）才会去创建对象
	 * @return
	 */
	@Lazy
	@Bean(name="person_anno")
	@Scope(value="singleton")
	public Person person1() {
		Person person = new Person("王海丽_注解",18);
		return person;
	}
	
	@Bean
	@Conditional(value=WindowCondition.class)
	public Person person() {
		Person person = new Person("bill",65);
		return person;
	}
	
	
	@Bean
	@Conditional(value=LinuxCondition.class)
	public Person personwindows() {
		Person person = new Person("linux",43);
		return person;
	}
	
	/**
	 * scope默认是singleton,就是spring的容器创建完成后就会去创建bean
	 * 如果scope是prototype,多实例的，只有再getBean（“”）才会去 创建bean
	 * @return
	 */
	@Bean(name="student_anno")
	@Scope(value="prototype")
	public Student student() {
		Student student = new Student("学生_注解",12);
		return student;
	}
	
	
	@Bean
	public MyColorFactoryBean colrFacotoryBean() {
		return new MyColorFactoryBean();
	}
}

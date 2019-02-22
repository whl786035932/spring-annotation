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
 * ģ�����beans.xml=ʹ��������
 * @author whl
 * 
 * ʹ��
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
	 * Ĭ�ϵ�ע���bean��id�Ƿ�����
	 * ������밴�շ�����ע����޸�@Bean������
	 * @Lazy����Ե�ʵ���Ķ���ֻ����getBean�����Ż�ȥ��������
	 * @return
	 */
	@Lazy
	@Bean(name="person_anno")
	@Scope(value="singleton")
	public Person person1() {
		Person person = new Person("������_ע��",18);
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
	 * scopeĬ����singleton,����spring������������ɺ�ͻ�ȥ����bean
	 * ���scope��prototype,��ʵ���ģ�ֻ����getBean���������Ż�ȥ ����bean
	 * @return
	 */
	@Bean(name="student_anno")
	@Scope(value="prototype")
	public Student student() {
		Student student = new Student("ѧ��_ע��",12);
		return student;
	}
	
	
	@Bean
	public MyColorFactoryBean colrFacotoryBean() {
		return new MyColorFactoryBean();
	}
}

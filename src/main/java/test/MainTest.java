package test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.demo.bean.Color;
import com.example.demo.bean.Person;
import com.example.demo.bean.Student;
import com.example.demo.config.MainConfig;
import com.example.demo.importt.Rabbow;
/**
 *模拟Spring的运行环境，然后测试在xml中配置bean
 * @author whl
 *
 */
public class MainTest {
	AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
	
	@SuppressWarnings("resource")
	@Test
	public void test() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
		Person person = (Person) applicationContext.getBean("person");
		System.out.println(person.getName());
		System.out.println(person.getAge());
		
		
		Student stu = (Student) applicationContext.getBean("student1");
		System.out.println(stu.getName());
		System.out.println(stu.getAge());
	}
	
	@SuppressWarnings("resource")
	@Test
	public void testMainConfig() {
		
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
		Person person = (Person) applicationContext.getBean("person_anno");
//		System.out.println("person.anme="+person.getName());
//		System.out.println("person.age="+person.getAge());
//		
//		Person person2 = (Person) applicationContext.getBean("person_anno");
//		System.out.println(person==person2);
//		
//		
//		Student stu = (Student) applicationContext.getBean("student_anno");
//		Student stu2 = (Student) applicationContext.getBean("student_anno");
//		System.out.println(stu==stu2);
//		System.out.println(stu.getName());
//		System.out.println(stu.getAge());
		
	}
	
	
	@Test
	public void testCondition() {
		
		Person person = applicationContext.getBean(Person.class);
		System.out.println(person.getName());
	}
	/**
	 * 要想@Import给容器中快速导入一个组件，必须要在组件上加上@Configuration
	 */
	@Test
	public void testImport() {
		String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
		for (String string : beanDefinitionNames) {
			System.out.println(string);
		}
	}
	/**
	 * 如果使用@Import快速导入组件，组件需要添加@Configuration注解，如：Blue, Circle
	 * 如果使用ImportBeanDefinitionRegistrar  ,注册的类就不需要添加@Configuration注解,如Rabbow.class
	 */
	@Test
	public void testImportRegistrar() {
		System.out.println("------444----------");
		String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
		for (String string : beanDefinitionNames) {
			System.out.println("bean  name==="+string);
		}
		Rabbow bean = applicationContext.getBean(Rabbow.class);
		System.out.println(bean);
	}
	
	
	@Test
	public void testColorFactoryBean() {
		Color bean = applicationContext.getBean(Color.class);
		
		System.out.println("color="+bean);
	}
}

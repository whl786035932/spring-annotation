package test;

import java.util.HashMap;
import java.util.HashSet;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.demo.config.MainConfigLifeCycle;

public class MainTestBeanLifeCycle {

	AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigLifeCycle.class);
	/**
	 *  car  无参的构造
		car属性被赋值后调用
		car   init  method
		十一月 08, 2018 2:02:59 下午 org.springframework.context.annotation.AnnotationConfigApplicationContext doClose
		信息: Closing org.springframework.context.annotation.AnnotationConfigApplicationContext@1c1b77f8: startup date [Thu Nov 08 14:02:58 CST 2018]; root of context hierarchy
		car  destroy method
	 */
	@SuppressWarnings("resource")
	@Test
	public void testBeanLifeCyCle() {
		
		applicationContext.close();
	}
	/**
		car  无参的构造
		postProcessBeforeInitialization---car---->com.example.demo.lifcycle.Car@259881f0
		car属性被赋值后调用
		postProcessAfterInitialization ----car---->com.example.demo.lifcycle.Car@259881f0
		House   constructor----------
		postProcessBeforeInitialization---house---->com.example.demo.lifcycle.House@2250b410
		House   属性赋值----------
		postProcessAfterInitialization ----house---->com.example.demo.lifcycle.House@2250b410
		Boss  contructor---
		postProcessBeforeInitialization---boss---->com.example.demo.lifcycle.Boss@1de61363
		Boss  init ------
		postProcessAfterInitialization ----boss---->com.example.demo.lifcycle.Boss@1de61363
		Bosss destroy
		House  destroy-----------
		car  destroy method
		
		
		1）、指定初始化和销毁方法；
 		通过@Bean指定init-method和destroy-method；
	 * 2）、通过让Bean实现InitializingBean（定义初始化逻辑），
	 * 				DisposableBean（定义销毁逻辑）;
	 * 3）、可以使用JSR250；
	 * 		@PostConstruct：在bean创建完成并且属性赋值完成；来执行初始化方法
	 * 		@PreDestroy：在容器销毁bean之前通知我们进行清理工作
	 * 4）、BeanPostProcessor【interface】：bean的后置处理器；
	 * 		在bean初始化前后进行一些处理工作；
	 * 		postProcessBeforeInitialization:在初始化之前工作
	 * 		postProcessAfterInitialization:在初始化之后工作
	 * 
	 * Spring底层对 BeanPostProcessor 的使用；
	 * 		bean赋值，注入其他组件，@Autowired，生命周期注解功能，@Async,xxx BeanPostProcessor;
		
		
		
	 */
	@Test
	public void postProcess() {
		
		HashSet<Object> hashSet = new HashSet<Object>();
		System.out.println(hashSet.size());
//		applicationContext.close();
	}
}

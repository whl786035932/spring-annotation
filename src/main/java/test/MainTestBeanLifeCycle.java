package test;

import java.util.HashMap;
import java.util.HashSet;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.demo.config.MainConfigLifeCycle;

public class MainTestBeanLifeCycle {

	AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigLifeCycle.class);
	/**
	 *  car  �޲εĹ���
		car���Ա���ֵ�����
		car   init  method
		ʮһ�� 08, 2018 2:02:59 ���� org.springframework.context.annotation.AnnotationConfigApplicationContext doClose
		��Ϣ: Closing org.springframework.context.annotation.AnnotationConfigApplicationContext@1c1b77f8: startup date [Thu Nov 08 14:02:58 CST 2018]; root of context hierarchy
		car  destroy method
	 */
	@SuppressWarnings("resource")
	@Test
	public void testBeanLifeCyCle() {
		
		applicationContext.close();
	}
	/**
		car  �޲εĹ���
		postProcessBeforeInitialization---car---->com.example.demo.lifcycle.Car@259881f0
		car���Ա���ֵ�����
		postProcessAfterInitialization ----car---->com.example.demo.lifcycle.Car@259881f0
		House   constructor----------
		postProcessBeforeInitialization---house---->com.example.demo.lifcycle.House@2250b410
		House   ���Ը�ֵ----------
		postProcessAfterInitialization ----house---->com.example.demo.lifcycle.House@2250b410
		Boss  contructor---
		postProcessBeforeInitialization---boss---->com.example.demo.lifcycle.Boss@1de61363
		Boss  init ------
		postProcessAfterInitialization ----boss---->com.example.demo.lifcycle.Boss@1de61363
		Bosss destroy
		House  destroy-----------
		car  destroy method
		
		
		1����ָ����ʼ�������ٷ�����
 		ͨ��@Beanָ��init-method��destroy-method��
	 * 2����ͨ����Beanʵ��InitializingBean�������ʼ���߼�����
	 * 				DisposableBean�����������߼���;
	 * 3��������ʹ��JSR250��
	 * 		@PostConstruct����bean������ɲ������Ը�ֵ��ɣ���ִ�г�ʼ������
	 * 		@PreDestroy������������bean֮ǰ֪ͨ���ǽ���������
	 * 4����BeanPostProcessor��interface����bean�ĺ��ô�������
	 * 		��bean��ʼ��ǰ�����һЩ��������
	 * 		postProcessBeforeInitialization:�ڳ�ʼ��֮ǰ����
	 * 		postProcessAfterInitialization:�ڳ�ʼ��֮����
	 * 
	 * Spring�ײ�� BeanPostProcessor ��ʹ�ã�
	 * 		bean��ֵ��ע�����������@Autowired����������ע�⹦�ܣ�@Async,xxx BeanPostProcessor;
		
		
		
	 */
	@Test
	public void postProcess() {
		
		HashSet<Object> hashSet = new HashSet<Object>();
		System.out.println(hashSet.size());
//		applicationContext.close();
	}
}

package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.example.demo.dao.UserDao;
/**
* �Զ�װ��;
* 		Spring��������ע�루DI������ɶ�IOC�������и��������������ϵ��ֵ��
* 
* 1����@Autowired���Զ�ע�룺
* 		1����Ĭ�����Ȱ�������ȥ�������Ҷ�Ӧ�����:applicationContext.getBean(BookDao.class);�ҵ��͸�ֵ
* 		2��������ҵ������ͬ���͵�������ٽ����Ե�������Ϊ�����idȥ�����в���
* 							applicationContext.getBean("bookDao")
* 		3����@Qualifier("bookDao")��ʹ��@Qualifierָ����Ҫװ��������id��������ʹ��������
* 		4�����Զ�װ��Ĭ��һ��Ҫ�����Ը�ֵ�ã�û�оͻᱨ��
* 			����ʹ��@Autowired(required=false);
* 		5����@Primary����Spring�����Զ�װ���ʱ��Ĭ��ʹ����ѡ��bean��
* 				Ҳ���Լ���ʹ��@Qualifierָ����Ҫװ���bean������
* 		BookService{
* 			@Autowired
* 			BookDao  bookDao;
* 		}
* 
* 2����Spring��֧��ʹ��@Resource(JSR250)��@Inject(JSR330)[java�淶��ע��]
* 		@Resource:
* 			���Ժ�@Autowiredһ��ʵ���Զ�װ�书�ܣ�Ĭ���ǰ���������ƽ���װ��ģ�
* 			û����֧��@Primary����û��֧��@Autowired��reqiured=false��;
* 		@Inject:
* 			��Ҫ����javax.inject�İ�����Autowired�Ĺ���һ����û��required=false�Ĺ��ܣ�
*  @Autowired:Spring����ģ� @Resource��@Inject����java�淶
* 	
* AutowiredAnnotationBeanPostProcessor:��������Զ�װ�书�ܣ�		
* 
* 3���� @Autowired:�����������������������ԣ����Ǵ������л�ȡ���������ֵ
* 		1����[��ע�ڷ���λ��]��@Bean+���������������������л�ȡ;Ĭ�ϲ�д@AutowiredЧ����һ���ģ������Զ�װ��
* 		2����[���ڹ�������]��������ֻ��һ���вι�����������вι�������@Autowired����ʡ�ԣ�����λ�õ�������ǿ����Զ��������л�ȡ
* 		3�������ڲ���λ�ã�
* 
* 4�����Զ��������Ҫʹ��Spring�����ײ��һЩ�����ApplicationContext��BeanFactory��xxx����
* 		�Զ������ʵ��xxxAware���ڴ��������ʱ�򣬻���ýӿڹ涨�ķ���ע����������Aware��
* 		��Spring�ײ�һЩ���ע�뵽�Զ����Bean�У�
* 		xxxAware������ʹ��xxxProcessor��
* 			ApplicationContextAware==��ApplicationContextAwareProcessor��
* 	
* 		
* @author lfy
*
*/
@Configuration
@ComponentScan(basePackages= {"com.example.demo.controller","com.example.demo.service","com.example.demo.dao","com.example.demo.aware"})
public class AutowiredResourcePrimaryConfig {
	
	@Primary
	@Bean(name="userDao2")
	public UserDao userDao() {
		UserDao userDao = new UserDao();
		userDao.setLabel("2");
		return userDao;
	}
	

}

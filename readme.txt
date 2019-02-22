/**
 * ��չԭ��
 * BeanPostProcessor��bean���ô�������bean���������ʼ��ǰ��������ع�����
 * 
 * 1��BeanFactoryPostProcessor��beanFactory�ĺ��ô�������
 * 		��BeanFactory��׼��ʼ��֮����ã������ƺ��޸�BeanFactory�����ݣ�
 * 		���е�bean�����Ѿ�������ص�beanFactory������bean��ʵ����δ����
 * 
 * 
 * BeanFactoryPostProcessorԭ��:
 * 1)��ioc������������
 * 2)��invokeBeanFactoryPostProcessors(beanFactory);
 * 		����ҵ����е�BeanFactoryPostProcessor��ִ�����ǵķ�����
 * 			1����ֱ����BeanFactory���ҵ�����������BeanFactoryPostProcessor���������ִ�����ǵķ���
 * 			2�����ڳ�ʼ�������������ǰ��ִ��
 * 
 * 2��BeanDefinitionRegistryPostProcessor extends BeanFactoryPostProcessor
 * 		postProcessBeanDefinitionRegistry();
 * 		������bean������Ϣ��Ҫ�����أ�beanʵ����δ�����ģ�
 * 
 * 		������BeanFactoryPostProcessorִ�У�
 * 		����BeanDefinitionRegistryPostProcessor���������ٶ������һЩ�����
 * 
 * 	ԭ��
 * 		1����ioc��������
 * 		2����refresh()-��invokeBeanFactoryPostProcessors(beanFactory);
 * 		3�����������л�ȡ�����е�BeanDefinitionRegistryPostProcessor�����
 * 			1�����δ������е�postProcessBeanDefinitionRegistry()����
 * 			2����������postProcessBeanFactory()����BeanFactoryPostProcessor��
 * 
 * 		4�����������������ҵ�BeanFactoryPostProcessor�����Ȼ�����δ���postProcessBeanFactory()����
 * 	
 * 3��ApplicationListener�����������з������¼����¼�����ģ�Ϳ�����
 * 	  public interface ApplicationListener<E extends ApplicationEvent>
 * 		���� ApplicationEvent ������������¼���
 * 
 * 	 ���裺
 * 		1����дһ����������ApplicationListenerʵ���ࣩ������ĳ���¼���ApplicationEvent�������ࣩ
 * 			@EventListener;
 * 			ԭ��ʹ��EventListenerMethodProcessor�����������������ϵ�@EventListener��
 * 
 * 		2�����Ѽ��������뵽������
 * 		3����ֻҪ������������¼��ķ��������Ǿ��ܼ���������¼���
 * 				ContextRefreshedEvent������ˢ����ɣ�����bean����ȫ�������ᷢ������¼���
 * 				ContextClosedEvent���ر������ᷢ������¼���
 * 		4��������һ���¼���
 * 				applicationContext.publishEvent()��
 * 	
 *  ԭ��
 *  	ContextRefreshedEvent��IOCTest_Ext$1[source=�ҷ�����ʱ��]��ContextClosedEvent��
 *  1����ContextRefreshedEvent�¼���
 *  	1����������������refresh()��
 *  	2����finishRefresh();����ˢ����ɻᷢ��ContextRefreshedEvent�¼�
 *  2�����Լ������¼���
 *  3���������رջᷢ��ContextClosedEvent��
 *  
 *  ���¼��������̡���
 *  	3����publishEvent(new ContextRefreshedEvent(this));
 *  			1������ȡ�¼��Ķಥ�����ɷ�������getApplicationEventMulticaster()
 *  			2����multicastEvent�ɷ��¼���
 *  			3������ȡ�����е�ApplicationListener��
 *  				for (final ApplicationListener<?> listener : getApplicationListeners(event, type)) {
 *  				1���������Executor������֧��ʹ��Executor�����첽�ɷ���
 *  					Executor executor = getTaskExecutor();
 *  				2��������ͬ���ķ�ʽֱ��ִ��listener������invokeListener(listener, event);
 *  				 �õ�listener�ص�onApplicationEvent������
 *  
 *  ���¼��ಥ�����ɷ�������
 *  	1����������������refresh();
 *  	2����initApplicationEventMulticaster();��ʼ��ApplicationEventMulticaster��
 *  		1������ȥ����������û��id=��applicationEventMulticaster���������
 *  		2�������û��this.applicationEventMulticaster = new SimpleApplicationEventMulticaster(beanFactory);
 *  			���Ҽ��뵽�����У����ǾͿ������������Ҫ�ɷ��¼����Զ�ע�����applicationEventMulticaster��
 *  
 *  ������������Щ��������
 *  	1����������������refresh();
 *  	2����registerListeners();
 *  		���������õ����еļ�������������ע�ᵽapplicationEventMulticaster�У�
 *  		String[] listenerBeanNames = getBeanNamesForType(ApplicationListener.class, true, false);
 *  		//��listenerע�ᵽApplicationEventMulticaster��
 *  		getApplicationEventMulticaster().addApplicationListenerBean(listenerBeanName);
 *  		
 *   SmartInitializingSingleton ԭ��->afterSingletonsInstantiated();
 *   		1����ioc������������refresh()��
 *   		2����finishBeanFactoryInitialization(beanFactory);��ʼ��ʣ�µĵ�ʵ��bean��
 *   			1�����ȴ������еĵ�ʵ��bean��getBean();
 *   			2������ȡ���д����õĵ�ʵ��bean���ж��Ƿ���SmartInitializingSingleton���͵ģ�
 *   				����Ǿ͵���afterSingletonsInstantiated();
 * 		
 * 
 *
 */
 --------------------------------�Զ�װ��-----------------------------------------------------------------------------------
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


 
 
��. MainTestBeanLifeCycle �����������ڵ����н��
	
	MyBeanFactoryPostProcessor postProcessBeanFactory-----begin---- 
	��ǰBeanFactory����12 ��Bean
	[org.springframework.context.annotation.internalConfigurationAnnotationProcessor, org.springframework.context.annotation.internalAutowiredAnnotationProcessor, org.springframework.context.annotation.internalRequiredAnnotationProcessor, org.springframework.context.annotation.internalCommonAnnotationProcessor, mainConfigLifeCycle, org.springframework.context.annotation.ConfigurationClassPostProcessor.importAwareProcessor, org.springframework.context.annotation.ConfigurationClassPostProcessor.enhancedConfigurationProcessor, myBeanpostProcessor, myBeanFactoryBeanProcessor, house, car, boss]
	MyBeanFactoryPostProcessor postProcessBeanFactory-----end---- 
	 House  �вι��췽��------------------------------
	����ȷ����ַ��%%%%%%%%%%%%%%%%%%%
	postProcessBeforeInitialization---house---->com.example.demo.lifcycle.House@6d3a388c
	House   ���Ը�ֵ----------
	postProcessAfterInitialization ----house---->com.example.demo.lifcycle.House@6d3a388c
	car  �޲εĹ���
	postProcessBeforeInitialization---car---->com.example.demo.lifcycle.Car@932bc4a
	car���Ա���ֵ�����
	postProcessAfterInitialization ----car---->com.example.demo.lifcycle.Car@932bc4a
	Boss  contructor---
	postProcessBeforeInitialization---boss---->com.example.demo.lifcycle.Boss@2fd1433e
	Boss  init ------
	postProcessAfterInitialization ----boss---->com.example.demo.lifcycle.Boss@2fd1433e
	���� 22, 2019 11:20:09 ���� org.springframework.context.annotation.AnnotationConfigApplicationContext doClose
	��Ϣ: Closing org.springframework.context.annotation.AnnotationConfigApplicationContext@57855c9a: startup date [Fri Feb 22 11:20:06 CST 2019]; root of context hierarchy
	Bosss destroy
	car  destroy method
	House  destroy----------- 

 
 
 

/**
 * 扩展原理：
 * BeanPostProcessor：bean后置处理器，bean创建对象初始化前后进行拦截工作的
 * 
 * 1、BeanFactoryPostProcessor：beanFactory的后置处理器；
 * 		在BeanFactory标准初始化之后调用，来定制和修改BeanFactory的内容；
 * 		所有的bean定义已经保存加载到beanFactory，但是bean的实例还未创建
 * 
 * 
 * BeanFactoryPostProcessor原理:
 * 1)、ioc容器创建对象
 * 2)、invokeBeanFactoryPostProcessors(beanFactory);
 * 		如何找到所有的BeanFactoryPostProcessor并执行他们的方法；
 * 			1）、直接在BeanFactory中找到所有类型是BeanFactoryPostProcessor的组件，并执行他们的方法
 * 			2）、在初始化创建其他组件前面执行
 * 
 * 2、BeanDefinitionRegistryPostProcessor extends BeanFactoryPostProcessor
 * 		postProcessBeanDefinitionRegistry();
 * 		在所有bean定义信息将要被加载，bean实例还未创建的；
 * 
 * 		优先于BeanFactoryPostProcessor执行；
 * 		利用BeanDefinitionRegistryPostProcessor给容器中再额外添加一些组件；
 * 
 * 	原理：
 * 		1）、ioc创建对象
 * 		2）、refresh()-》invokeBeanFactoryPostProcessors(beanFactory);
 * 		3）、从容器中获取到所有的BeanDefinitionRegistryPostProcessor组件。
 * 			1、依次触发所有的postProcessBeanDefinitionRegistry()方法
 * 			2、再来触发postProcessBeanFactory()方法BeanFactoryPostProcessor；
 * 
 * 		4）、再来从容器中找到BeanFactoryPostProcessor组件；然后依次触发postProcessBeanFactory()方法
 * 	
 * 3、ApplicationListener：监听容器中发布的事件。事件驱动模型开发；
 * 	  public interface ApplicationListener<E extends ApplicationEvent>
 * 		监听 ApplicationEvent 及其下面的子事件；
 * 
 * 	 步骤：
 * 		1）、写一个监听器（ApplicationListener实现类）来监听某个事件（ApplicationEvent及其子类）
 * 			@EventListener;
 * 			原理：使用EventListenerMethodProcessor处理器来解析方法上的@EventListener；
 * 
 * 		2）、把监听器加入到容器；
 * 		3）、只要容器中有相关事件的发布，我们就能监听到这个事件；
 * 				ContextRefreshedEvent：容器刷新完成（所有bean都完全创建）会发布这个事件；
 * 				ContextClosedEvent：关闭容器会发布这个事件；
 * 		4）、发布一个事件：
 * 				applicationContext.publishEvent()；
 * 	
 *  原理：
 *  	ContextRefreshedEvent、IOCTest_Ext$1[source=我发布的时间]、ContextClosedEvent；
 *  1）、ContextRefreshedEvent事件：
 *  	1）、容器创建对象：refresh()；
 *  	2）、finishRefresh();容器刷新完成会发布ContextRefreshedEvent事件
 *  2）、自己发布事件；
 *  3）、容器关闭会发布ContextClosedEvent；
 *  
 *  【事件发布流程】：
 *  	3）、publishEvent(new ContextRefreshedEvent(this));
 *  			1）、获取事件的多播器（派发器）：getApplicationEventMulticaster()
 *  			2）、multicastEvent派发事件：
 *  			3）、获取到所有的ApplicationListener；
 *  				for (final ApplicationListener<?> listener : getApplicationListeners(event, type)) {
 *  				1）、如果有Executor，可以支持使用Executor进行异步派发；
 *  					Executor executor = getTaskExecutor();
 *  				2）、否则，同步的方式直接执行listener方法；invokeListener(listener, event);
 *  				 拿到listener回调onApplicationEvent方法；
 *  
 *  【事件多播器（派发器）】
 *  	1）、容器创建对象：refresh();
 *  	2）、initApplicationEventMulticaster();初始化ApplicationEventMulticaster；
 *  		1）、先去容器中找有没有id=“applicationEventMulticaster”的组件；
 *  		2）、如果没有this.applicationEventMulticaster = new SimpleApplicationEventMulticaster(beanFactory);
 *  			并且加入到容器中，我们就可以在其他组件要派发事件，自动注入这个applicationEventMulticaster；
 *  
 *  【容器中有哪些监听器】
 *  	1）、容器创建对象：refresh();
 *  	2）、registerListeners();
 *  		从容器中拿到所有的监听器，把他们注册到applicationEventMulticaster中；
 *  		String[] listenerBeanNames = getBeanNamesForType(ApplicationListener.class, true, false);
 *  		//将listener注册到ApplicationEventMulticaster中
 *  		getApplicationEventMulticaster().addApplicationListenerBean(listenerBeanName);
 *  		
 *   SmartInitializingSingleton 原理：->afterSingletonsInstantiated();
 *   		1）、ioc容器创建对象并refresh()；
 *   		2）、finishBeanFactoryInitialization(beanFactory);初始化剩下的单实例bean；
 *   			1）、先创建所有的单实例bean；getBean();
 *   			2）、获取所有创建好的单实例bean，判断是否是SmartInitializingSingleton类型的；
 *   				如果是就调用afterSingletonsInstantiated();
 * 		
 * 
 *
 */
 --------------------------------自动装配-----------------------------------------------------------------------------------
 /**
* 自动装配;
* 		Spring利用依赖注入（DI），完成对IOC容器中中各个组件的依赖关系赋值；
* 
* 1）、@Autowired：自动注入：
* 		1）、默认优先按照类型去容器中找对应的组件:applicationContext.getBean(BookDao.class);找到就赋值
* 		2）、如果找到多个相同类型的组件，再将属性的名称作为组件的id去容器中查找
* 							applicationContext.getBean("bookDao")
* 		3）、@Qualifier("bookDao")：使用@Qualifier指定需要装配的组件的id，而不是使用属性名
* 		4）、自动装配默认一定要将属性赋值好，没有就会报错；
* 			可以使用@Autowired(required=false);
* 		5）、@Primary：让Spring进行自动装配的时候，默认使用首选的bean；
* 				也可以继续使用@Qualifier指定需要装配的bean的名字
* 		BookService{
* 			@Autowired
* 			BookDao  bookDao;
* 		}
* 
* 2）、Spring还支持使用@Resource(JSR250)和@Inject(JSR330)[java规范的注解]
* 		@Resource:
* 			可以和@Autowired一样实现自动装配功能；默认是按照组件名称进行装配的；
* 			没有能支持@Primary功能没有支持@Autowired（reqiured=false）;
* 		@Inject:
* 			需要导入javax.inject的包，和Autowired的功能一样。没有required=false的功能；
*  @Autowired:Spring定义的； @Resource、@Inject都是java规范
* 	
* AutowiredAnnotationBeanPostProcessor:解析完成自动装配功能；		
* 
* 3）、 @Autowired:构造器，参数，方法，属性；都是从容器中获取参数组件的值
* 		1）、[标注在方法位置]：@Bean+方法参数；参数从容器中获取;默认不写@Autowired效果是一样的；都能自动装配
* 		2）、[标在构造器上]：如果组件只有一个有参构造器，这个有参构造器的@Autowired可以省略，参数位置的组件还是可以自动从容器中获取
* 		3）、放在参数位置：
* 
* 4）、自定义组件想要使用Spring容器底层的一些组件（ApplicationContext，BeanFactory，xxx）；
* 		自定义组件实现xxxAware；在创建对象的时候，会调用接口规定的方法注入相关组件；Aware；
* 		把Spring底层一些组件注入到自定义的Bean中；
* 		xxxAware：功能使用xxxProcessor；
* 			ApplicationContextAware==》ApplicationContextAwareProcessor；
* 	
* 		
* @author lfy
*
*/


 
 
二. MainTestBeanLifeCycle 测试生命周期的运行结果
	
	MyBeanFactoryPostProcessor postProcessBeanFactory-----begin---- 
	当前BeanFactory中有12 个Bean
	[org.springframework.context.annotation.internalConfigurationAnnotationProcessor, org.springframework.context.annotation.internalAutowiredAnnotationProcessor, org.springframework.context.annotation.internalRequiredAnnotationProcessor, org.springframework.context.annotation.internalCommonAnnotationProcessor, mainConfigLifeCycle, org.springframework.context.annotation.ConfigurationClassPostProcessor.importAwareProcessor, org.springframework.context.annotation.ConfigurationClassPostProcessor.enhancedConfigurationProcessor, myBeanpostProcessor, myBeanFactoryBeanProcessor, house, car, boss]
	MyBeanFactoryPostProcessor postProcessBeanFactory-----end---- 
	 House  有参构造方法------------------------------
	房子确定地址了%%%%%%%%%%%%%%%%%%%
	postProcessBeforeInitialization---house---->com.example.demo.lifcycle.House@6d3a388c
	House   属性赋值----------
	postProcessAfterInitialization ----house---->com.example.demo.lifcycle.House@6d3a388c
	car  无参的构造
	postProcessBeforeInitialization---car---->com.example.demo.lifcycle.Car@932bc4a
	car属性被赋值后调用
	postProcessAfterInitialization ----car---->com.example.demo.lifcycle.Car@932bc4a
	Boss  contructor---
	postProcessBeforeInitialization---boss---->com.example.demo.lifcycle.Boss@2fd1433e
	Boss  init ------
	postProcessAfterInitialization ----boss---->com.example.demo.lifcycle.Boss@2fd1433e
	二月 22, 2019 11:20:09 上午 org.springframework.context.annotation.AnnotationConfigApplicationContext doClose
	信息: Closing org.springframework.context.annotation.AnnotationConfigApplicationContext@57855c9a: startup date [Fri Feb 22 11:20:06 CST 2019]; root of context hierarchy
	Bosss destroy
	car  destroy method
	House  destroy----------- 

 
 
 

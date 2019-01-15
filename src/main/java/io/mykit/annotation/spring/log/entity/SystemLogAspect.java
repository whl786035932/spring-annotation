package io.mykit.annotation.spring.log.entity;

import java.lang.reflect.Method;
import java.util.Date;

import javax.annotation.Resource;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 具体切面类的实现
 * @author whl
 *
 */
@Aspect
@Component
public class SystemLogAspect {

	@Resource
	private SystemLogService systemtLogService;
	
	private static final Logger logger = LoggerFactory.getLogger(SystemLogAspect. class); 
	
	/**
	 * 切入点
	 */
//	@Pointcut("execution (* io.mykit.annotation.spring.log.entity..*.*(..))")
//	@Pointcut("execution(public int com.example.demo.aop.AopLuoji.*(..))")
	@Pointcut("execution(public int io.mykit.annotation.spring.log.entity.SystemLogServiceImpl.*(..))")
	public void controllerAspect() {
		
	}
	
	//前置通知
	@Before("controllerAspect()")
	public void doBefore(JoinPoint joinPoint) {
		System.out.println("==========执行controller前置通知===============");
		if(logger.isInfoEnabled()) {
			logger.info("before"+joinPoint);
		}
	}
	
	
	@Around("controllerAspect()")
	public void around(JoinPoint joinPoint) {
		System.out.println("==========开始执行controller环绕通知===============");
        long start = System.currentTimeMillis();
        try {
			((ProceedingJoinPoint) joinPoint).proceed();
			long end = System.currentTimeMillis();
		    if(logger.isInfoEnabled()){
              logger.info("around " + joinPoint + "\tUse time : " + (end - start) + " ms!");
            }
		    System.out.println("==========结束执行controller环绕通知===============");
		} catch (Throwable e) {
			e.printStackTrace();
			 long end = System.currentTimeMillis();
             if(logger.isInfoEnabled()){
                 logger.info("around " + joinPoint + "\tUse time : " + (end - start) + " ms with exception : " + e.getMessage());
             }
		}
	}
	
	@After("controllerAspect()")
	public void after(JoinPoint joinPoint) {

		String targetName = joinPoint.getTarget().getClass().getName();
		String methodName = joinPoint.getSignature().getName();
		Object[] arguments = joinPoint.getArgs();
		
		try {
			Class<?> targetClass = Class.forName(targetName);
			Method[] methods = targetClass.getMethods();
			
			String operationType ="";
			String operationName = "";
			for (Method method : methods) {
				if(method.getName().equals(methodName)) {
					Class<?>[] clazzs = method.getParameterTypes();
					if(clazzs.length == arguments.length) {
						if(method.isAnnotationPresent(Log.class)) {
							 operationType = method.getAnnotation(Log.class).operationType();
							 operationName = method.getAnnotation(Log.class).operationName();
							 break;
						}
					}
					
				}
			}
			
			System.out.println("===controller后置通知开始===");
			
			System.out.println("请求方法:" + (joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()")+"."+operationType);  
            System.out.println("方法描述:" + operationName);  
            SystemLog log = new SystemLog();  
            log.setId("iddd");
            log.setDescription(operationName);  
            log.setMethod((joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()")+"."+operationType);  
            log.setLogType((long)0);  
            log.setRequestIp("10.2.16.80");  
            log.setExceptioncode( null);  
            log.setExceptionDetail( null);  
            log.setParams( null);  
            log.setCreateBy("用户名");  
            log.setCreateDate(new Date());  
            //保存数据库  
            systemtLogService.insert(log);
            System.out.println("=====controller后置通知结束=====");  
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			logger.error("==后置通知异常==");  
            logger.error("异常信息:{}", e.getMessage());  
		}
		
		
	}
	
	
	@AfterReturning("controllerAspect")
	public void afterReturn(JoinPoint joinPoint) {
		 System.out.println("=====执行controller后置返回通知=====");  
         if(logger.isInfoEnabled()){
             logger.info("afterReturn " + joinPoint);
         }
	}
	
	
	
	
}

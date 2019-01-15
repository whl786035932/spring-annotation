package com.example.demo.cglib;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
/**
 * 采用CGLIB ，对目标对象也就是业务逻辑类，进行扩展
 * @author whl
 *
 */
public class RequestCallback  implements MethodInterceptor {

	@Override
	public Object intercept(Object object, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		if(method.getName().equals("request")) {
			System.out.println("你调用了request方法");
			return proxy.invokeSuper(object	, args);
		}
		return null;
	}

}

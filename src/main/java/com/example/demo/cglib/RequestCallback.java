package com.example.demo.cglib;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
/**
 * ����CGLIB ����Ŀ�����Ҳ����ҵ���߼��࣬������չ
 * @author whl
 *
 */
public class RequestCallback  implements MethodInterceptor {

	@Override
	public Object intercept(Object object, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		if(method.getName().equals("request")) {
			System.out.println("�������request����");
			return proxy.invokeSuper(object	, args);
		}
		return null;
	}

}

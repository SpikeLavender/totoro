package com.hetengjiao.factory;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CGLIBFactory {

	/**
	 * CGLIB动态代理
	 * @param obj 委托对象
	 * @return 代理对象
	 */
	public Object getCGLIBProxy(Object obj) {
		return Enhancer.create(obj.getClass(), new MethodInterceptor() {
			@Override
			public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
				Object result;
				// 增强
				System.out.println("开始前做点什么事。。。。");
				result = method.invoke(obj, objects);
				// 增强
				System.out.println("结束后做点什么事。。。。");
				return result;
			}
		});
	}
}

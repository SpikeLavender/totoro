package com.hetengjiao.factory;

import java.lang.reflect.Proxy;

public class JDKFactory {


	/**
	 * JDK动态代理
	 * @param obj 委托对象
	 * @return 代理对象
	 */
	public Object getJDKProxy(Object obj) {
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(),
				(proxy, method, args) -> {
					Object result;
					// 增强
					System.out.println("开始前做点什么事。。。。");
					result = method.invoke(obj, args);
					// 增强
					System.out.println("结束后做点什么事。。。。");
					if (result.equals("ss")) throw new Exception("");
					return result;
				});
	}

}

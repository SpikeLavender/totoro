package com.hetengjiao.factory;

import com.hetengjiao.utils.TransactionManager;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import java.lang.reflect.Proxy;

/**
 * 动态代理类
 */
public class ProxyFactory {

	private ProxyFactory() {

	}

	private static class Holder {
		private static ProxyFactory proxyFactory = new ProxyFactory();
	}

	public static ProxyFactory getInstance() {
		return Holder.proxyFactory;
	}


	/**
	 * JDK 动态代理
	 * @param obj 委托对象
	 * @return  代理对象
	 */
	public Object getJdkProxy(Object obj) {

		return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(),
				((proxy, method, args) -> {
					Object result;
					try {
						TransactionManager.getInstance().beginTransaction();

						result = method.invoke(obj, args);

						TransactionManager.getInstance().commit();
					} catch (Exception e) {

						TransactionManager.getInstance().rollback();
						throw e;
					}
					return result;
				}));
	}

	/**
	 * CGLIB动态代理
	 * @param obj 委托对象
	 * @return  代理对象
	 */
	public Object getCglibProxy(Object obj) {
		return Enhancer.create(obj.getClass(), (MethodInterceptor) (o, method, objects, methodProxy) -> {
			Object result;
			try {
				TransactionManager.getInstance().beginTransaction();

				result = method.invoke(obj, objects);
				System.out.println();

				TransactionManager.getInstance().commit();
			} catch (Exception e) {

				TransactionManager.getInstance().rollback();
				throw e;
			}
			return result;
		});
	}

}

package com.hetengjiao.factory;

import com.hetengjiao.utils.TransactionManager;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import java.lang.reflect.Proxy;

/**
 * 动态代理类
 */
public class ProxyFactory {

	private TransactionManager transactionManager;

	public void setTransactionManager(TransactionManager transactionManager) {
		this.transactionManager = transactionManager;
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
						transactionManager.beginTransaction();

						result = method.invoke(obj, args);

						transactionManager.commit();
					} catch (Exception e) {

						transactionManager.rollback();
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
				transactionManager.beginTransaction();

				result = method.invoke(obj, objects);
				System.out.println();

				transactionManager.commit();
			} catch (Exception e) {

				transactionManager.rollback();
				throw e;
			}
			return result;
		});
	}

}

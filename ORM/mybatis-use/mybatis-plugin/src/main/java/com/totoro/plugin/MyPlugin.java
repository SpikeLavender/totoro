package com.totoro.plugin;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.*;

import java.sql.Connection;
import java.util.Properties;

@Intercepts({
		@Signature(
				type = StatementHandler.class,
				method = "prepare",
				args = {Connection.class, Integer.class}
				)
})
public class MyPlugin implements Interceptor {


	/**
	 * 拦截方法：只要被拦截的目标对象的目标方法被执行时，每次都会执行intercept方法
	 * @param invocation 代理方法
	 * @return object
	 * @throws Throwable e
	 */
	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		System.out.println("对方法进行了增强。。。");
		return invocation.proceed(); //原方法执行
	}

	/**
	 * 主要为了把当前的拦截器生成代理存到拦截器中
	 * @param target 被拦截的目标对象
	 * @return wrap
	 */
	@Override
	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	/**
	 * 获取配置文件的参数
	 * @param properties 参数
	 */
	@Override
	public void setProperties(Properties properties) {
		System.out.println("获取到的配置文件的参数是：" + properties);
	}
}

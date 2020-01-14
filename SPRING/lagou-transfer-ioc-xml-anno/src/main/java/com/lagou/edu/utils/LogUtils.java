package com.lagou.edu.utils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogUtils {

	@Pointcut("execution(* com.lagou.edu.service.impl.TransferServiceImpl.*(..)))")
	public void pt1() {

	}

	@Before("pt1()")
	public void beforeMethod(JoinPoint joinPoint) {
		Object[] args = joinPoint.getArgs();
		for (Object arg : args) {
			System.out.println(arg);
		}
		System.out.println("业务逻辑开始执行之前执行......");
	}

	/**
	 * 无论异常与否都执行
	 */
	@After("pt1()")
	public void afterMethod() {
		System.out.println("业务逻辑结束时执行......");
	}

	@AfterThrowing("pt1()")
	public void exceptionMethod() {
		System.out.println("业务逻辑异常时执行......");
	}

	/**
	 * 无论异常与否都执行
	 */
	@AfterReturning(value = "pt1()", returning = "retValue")
	public void successMethod(Object retValue) {
		System.out.println("业务逻辑正常结束时执行......");
	}

	/**
	 * 无论异常与否都执行
	 */
	@Around("pt1()")
	public Object aroundMethod(ProceedingJoinPoint joinPoint) {
		System.out.println("环绕通知中的beforeMethod......");
		//method.invoke
		Object result = null;
		try {
			result = joinPoint.proceed(joinPoint.getArgs());
		} catch (Throwable throwable) {
			System.out.println("环绕通知中的exceptionMethod......");
		} finally {
			System.out.println("环绕通知中的afterMethod......");
		}
		return result;
	}
}

package com.hetengjiao.pojo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Result implements BeanNameAware, BeanFactoryAware,
		ApplicationContextAware, InitializingBean, DisposableBean {

	private String status;

	private String message;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Result{" +
				"status='" + status + '\'' +
				", message='" + message + '\'' +
				'}';
	}

	@Override
	public void setBeanName(String name) {
		System.out.println("注册我成为bean时定义的id: " + name);
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("管理我的BeanFactory为: " + beanFactory);
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("高级容器接口ApplicationContext: " + applicationContext);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("afterPropertiesSet......");
	}

	public void initMethod() {
		System.out.println("init-method......");
	}

	@PostConstruct
	public void postConstruct() {
		System.out.println("postConstruct......");
	}

	@PreDestroy
	public void preDestroy() {
		System.out.println("PreDestroy......");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("destroy......");
	}
}

package com.lagou.demo.controller;

import com.lagou.demo.service.IDemoService;
import com.lagou.edu.mvcframework.annotation.IAutowired;
import com.lagou.edu.mvcframework.annotation.IController;
import com.lagou.edu.mvcframework.annotation.IRequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@IController
@IRequestMapping("/demo")
public class DemoController {

	@IAutowired
	private IDemoService demoService;

	/**
	 * URL: /demo/query
	 * @param request
	 * @param response
	 * @param name
	 * @return
	 */
	@IRequestMapping("/query")
	public String query(HttpServletRequest request, HttpServletResponse response, String name) {
		return demoService.get(name);
	}

}

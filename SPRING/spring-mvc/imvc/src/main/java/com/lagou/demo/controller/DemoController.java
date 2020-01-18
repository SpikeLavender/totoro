package com.lagou.demo.controller;

import com.lagou.demo.service.IDemoService;
import com.lagou.edu.mvcframework.annotation.IAutowired;
import com.lagou.edu.mvcframework.annotation.IController;
import com.lagou.edu.mvcframework.annotation.IRequestMapping;
import com.lagou.edu.mvcframework.annotation.ISecurity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@IController
@IRequestMapping("/demo")
@ISecurity({"hetengjiao", "lagou"})
public class DemoController {

	@IAutowired
	private IDemoService demoService;

	/**
	 * URL: /demo/handle01
	 * @param request
	 * @param response
	 * @param name
	 * @return
	 */
	@IRequestMapping("/handle01")
	public String handle01(HttpServletRequest request, HttpServletResponse response, String name) throws IOException {
		response.getWriter().write("handle01 success");
		return demoService.get(name);
	}

	/**
	 * URL: /demo/handle02
	 * @param request
	 * @param response
	 * @param name
	 * @return
	 */
	@IRequestMapping("/handle02")
	@ISecurity({"zhangsan", "lisi"})
	public String handle02(HttpServletRequest request, HttpServletResponse response, String name) throws IOException {
		response.getWriter().write("handle02 success");
		return demoService.get(name);
	}

	/**
	 * URL: /demo/handle03
	 * @param request
	 * @param response
	 * @param name
	 * @return
	 */
	@IRequestMapping("/handle03")
	@ISecurity({"wangwu", "zhaoliu"})
	public String handle03(HttpServletRequest request, HttpServletResponse response, String name) throws IOException {
		response.getWriter().write("handle03 success");
		return demoService.get(name);
	}

}

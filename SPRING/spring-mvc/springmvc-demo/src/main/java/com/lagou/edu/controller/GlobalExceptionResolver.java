package com.lagou.edu.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * 可以优雅的捕获所有Controller对象handler方法抛出的异常
 */
@ControllerAdvice
public class GlobalExceptionResolver {
	/**
	 * SpringMVC的异常处理机制（异常处理器）
	 */
//	@ExceptionHandler(ArithmeticException.class)
//	public void handleException(ArithmeticException exception, HttpServletResponse response) {
//		//异常处理逻辑
//		try {
//			response.getWriter().write("===> " + exception.getMessage());
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}

	@ExceptionHandler(ArithmeticException.class)
	public ModelAndView handleException(ArithmeticException exception) {
		//异常处理逻辑
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("msg", exception.getMessage());
		modelAndView.setViewName("error");
		return modelAndView;
	}
}

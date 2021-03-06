package com.hetengjiao.servlet;


import com.hetengjiao.factory.BeanFactory;
import com.hetengjiao.factory.ProxyFactory;
import com.hetengjiao.pojo.Result;
import com.hetengjiao.service.TransferService;
import com.hetengjiao.service.impl.TransferServiceImpl;
import com.hetengjiao.utils.JsonUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="transferServlet",urlPatterns = "/transferServlet")
public class TransferServlet extends HttpServlet {

	//private TransferService transferService = new TransferServiceImpl();
	//private TransferService transferService = (TransferService) BeanFactory.getBean("transferService");
	private TransferService transferService
			= (TransferService) ProxyFactory.getInstance().getCglibProxy(BeanFactory.getBean("transferService"));

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		doPost(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		// 设置请求体的字符编码
		req.setCharacterEncoding("UTF-8");

		String fromCardNo = req.getParameter("fromCardNo");
		String toCardNo = req.getParameter("toCardNo");
		String moneyStr = req.getParameter("money");
		int money = Integer.parseInt(moneyStr);

		Result result = new Result();

		try {

			// 2. 调用service层方法
			transferService.transfer(fromCardNo,toCardNo,money);
			result.setStatus("200");
		} catch (Exception e) {
			e.printStackTrace();
			result.setStatus("201");
			result.setMessage(e.toString());
		}

		// 响应
		resp.setContentType("application/json;charset=utf-8");
		resp.getWriter().print(JsonUtils.object2Json(result));
	}

}

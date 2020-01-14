package com.hetengjiao.factory;

import com.hetengjiao.utils.ConnectionUtils;

public class CreateBeanFactory {

	public static ConnectionUtils getInstanceStatic() {
		return new ConnectionUtils();
	}

	public ConnectionUtils getInstance() {
		return new ConnectionUtils();
	}
}

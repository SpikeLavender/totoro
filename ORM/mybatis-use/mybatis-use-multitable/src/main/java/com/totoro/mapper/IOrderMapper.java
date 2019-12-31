package com.totoro.mapper;

import com.totoro.pojo.Order;

import java.io.IOException;
import java.util.List;

public interface IOrderMapper {
	/**
	 *
	 * @return
	 * @throws IOException
	 */
	List<Order> findOrderAndUser() throws IOException;
}

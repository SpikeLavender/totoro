package com.totoro.pojo;

import java.util.List;

public class Order {

	private Integer id;

	private String orderTime;

	private Double total;

	User user;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Order{" +
				"id=" + id +
				", orderTime='" + orderTime + '\'' +
				", total=" + total +
				", user=" + user +
				'}';
	}
}

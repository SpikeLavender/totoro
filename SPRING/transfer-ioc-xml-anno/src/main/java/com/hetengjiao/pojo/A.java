package com.hetengjiao.pojo;

public class A {
	private Integer id;

	private String xingming;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getXingming() {
		return xingming;
	}

	public void setXingming(String xingming) {
		this.xingming = xingming;
	}

	@Override
	public String toString() {
		return "A{" +
				"id=" + id +
				", xingming='" + xingming + '\'' +
				'}';
	}
}

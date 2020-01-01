package com.totoro.pojo;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Table(name = "user")
public class UserInfo {

	@Id //对应的是注解id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //设置主键的生成策略
	private Integer id;

	private String username;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "UserInfo{" +
				"id=" + id +
				", username='" + username + '\'' +
				'}';
	}
}

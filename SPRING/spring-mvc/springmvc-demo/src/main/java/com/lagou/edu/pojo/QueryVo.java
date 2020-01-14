package com.lagou.edu.pojo;

public class QueryVo {
	private String mail;
	private String phone;
	private User user;

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "QueryVo{" +
				"mail='" + mail + '\'' +
				", phone='" + phone + '\'' +
				", user=" + user +
				'}';
	}
}

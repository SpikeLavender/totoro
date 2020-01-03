package com.hetengjiao.service;

import java.sql.SQLException;

public interface TransferService {
	void transfer(String fromCardNo, String toCardNo, int money) throws SQLException;
}

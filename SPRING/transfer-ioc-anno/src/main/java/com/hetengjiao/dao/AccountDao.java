package com.hetengjiao.dao;
import com.hetengjiao.pojo.Account;

import java.sql.SQLException;

public interface AccountDao {

	Account queryAccountByCardNo(String cardNo) throws SQLException;

	int updateAccountByCardNo(Account account) throws SQLException;
}

package com.hetengjiao.dao.impl;

import com.hetengjiao.dao.AccountDao;
import com.hetengjiao.pojo.Account;
import com.hetengjiao.utils.ConnectionUtils;
import com.hetengjiao.utils.DruidUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class JdbcAccountDaoImpl implements AccountDao {


	@Override
	public Account queryAccountByCardNo(String cardNo) throws SQLException {
		// 改造成线程绑定的connection
		//从连接池获取连接
		//Connection conn = DruidUtils.getInstance().getConnection();
		Connection conn = ConnectionUtils.getInstance().getCurrentThreadConn();
		String sql = "select * from account where cardNo = ?";
		PreparedStatement preparedStatement = conn.prepareStatement(sql);
		preparedStatement.setString(1, cardNo);

		ResultSet resultSet = preparedStatement.executeQuery();

		Account account = new Account();

		while (resultSet.next()) {
			account.setCardNo(resultSet.getString("cardNo"));
			account.setMoney(resultSet.getInt("money"));
			account.setName(resultSet.getString("name"));
		}
		resultSet.close();
		preparedStatement.close();
		//conn.close();

		return account;
	}

	@Override
	public int updateAccountByCardNo(Account account) throws SQLException {

		//从连接池获取连接
		//Connection conn = DruidUtils.getInstance().getConnection();
		Connection conn = ConnectionUtils.getInstance().getCurrentThreadConn();
		String sql = "update account set money = ? where cardNo = ?";
		PreparedStatement preparedStatement = conn.prepareStatement(sql);
		preparedStatement.setInt(1, account.getMoney());
		preparedStatement.setString(2, account.getCardNo());
		int i = preparedStatement.executeUpdate();
		preparedStatement.close();
		//conn.close();
		return i;
	}
}

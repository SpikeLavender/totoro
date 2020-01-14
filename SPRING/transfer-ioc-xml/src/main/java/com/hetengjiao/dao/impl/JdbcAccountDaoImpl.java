package com.hetengjiao.dao.impl;

import com.hetengjiao.dao.AccountDao;
import com.hetengjiao.pojo.Account;
import com.hetengjiao.utils.ConnectionUtils;
import com.hetengjiao.utils.DruidUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.Properties;
import java.util.Set;


public class JdbcAccountDaoImpl implements AccountDao {

	private ConnectionUtils connectionUtils;

	public void setConnectionUtils(ConnectionUtils connectionUtils) {
		this.connectionUtils = connectionUtils;
	}

	private String name;

	private int sex;

	private float money;

	private String[] myArray;

	private Map<String, String> myMap;

	private Set<String> mySet;

	private Properties myProperties;



	public void setName(String name) {
		this.name = name;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public void setMoney(float money) {
		this.money = money;
	}

	public void setMyArray(String[] myArray) {
		this.myArray = myArray;
	}

	public void setMyMap(Map<String, String> myMap) {
		this.myMap = myMap;
	}

	public void setMySet(Set<String> mySet) {
		this.mySet = mySet;
	}

	public void setMyProperties(Properties myProperties) {
		this.myProperties = myProperties;
	}

	public JdbcAccountDaoImpl() {
	}

	public JdbcAccountDaoImpl(ConnectionUtils connectionUtils, String name, int sex, float money) {
		this.connectionUtils = connectionUtils;
		this.name = name;
		this.sex = sex;
		this.money = money;
	}

	public void init() {
		System.out.println("初始化方法。。。");
	}

	public void destroy() {
		System.out.println("销毁方法。。。");
	}

	@Override
	public Account queryAccountByCardNo(String cardNo) throws SQLException {
		// 改造成线程绑定的connection
		//从连接池获取连接
		//Connection conn = DruidUtils.getInstance().getConnection();
		Connection conn = connectionUtils.getCurrentThreadConn();
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
		Connection conn = connectionUtils.getCurrentThreadConn();
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

package com.hetengjiao.dao.impl;

import com.hetengjiao.dao.ADao;
import com.hetengjiao.pojo.A;
import com.hetengjiao.utils.ConnectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Repository
public class ADaoImpl implements ADao {

	@Autowired
	private ConnectionUtils connectionUtils;

	@Override
	public A queryById(int id) throws Exception {
		Connection conn = connectionUtils.getCurrentThreadConn();
		String sql = "select * from A where id=?";
		PreparedStatement preparedStatement = conn.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();

		A a = new A();
		while (resultSet.next()) {
			a.setId(resultSet.getInt("id"));
			a.setXingming(resultSet.getString("xingming"));
		}

		resultSet.close();
		preparedStatement.close();
		return a;
	}
}

package com.hetengjiao.dao.impl;

import com.hetengjiao.dao.BDao;
import com.hetengjiao.pojo.B;
import com.hetengjiao.utils.ConnectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


@Repository
public class BDaoImpl implements BDao {

	@Autowired
	private ConnectionUtils connectionUtils;

	@Override
	public B queryById(int id) throws Exception {
		Connection conn = connectionUtils.getCurrentThreadConn();
		String sql = "select * from B where id=?";
		PreparedStatement preparedStatement = conn.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();

		B b = new B();
		while (resultSet.next()) {
			b.setId(resultSet.getInt("id"));
			b.setName(resultSet.getString("name"));
		}

		resultSet.close();
		preparedStatement.close();
		return b;
	}
}

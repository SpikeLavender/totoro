package com.hetengjiao.dao.impl;

import com.hetengjiao.dao.IBaseDao;
import com.hetengjiao.pojo.A;
import com.hetengjiao.pojo.B;
import com.hetengjiao.utils.ConnectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Repository
@Lazy
public class BaseDaoImpl<T> implements IBaseDao<T> {


	@Autowired
	private ConnectionUtils connectionUtils;

	private Class clazz; // 赋值为子类传递过来的泛型类型

	// 父Bean中在获取子Bean传递过来的泛型类型时，只有获取到具体的泛型类型比如A,B等，才能针对性的查询某张表，
	// 否则会异常
	public BaseDaoImpl() {
		Type genericSuperclass = this.getClass().getGenericSuperclass();
		// 转换为参数化类型
		ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
		clazz = (Class) parameterizedType.getActualTypeArguments()[0];
	}

	@Override
	@SuppressWarnings("unchecked")
	public T queryById(int id) throws Exception {
		// 公共代码

		Connection conn = connectionUtils.getCurrentThreadConn();
		//获取泛型名称
		String tableName = clazz.getName().split("\\.")[clazz.getName().split("\\.").length - 1];
		String sql = "select * from "+ tableName + " where id=?";
		PreparedStatement preparedStatement = conn.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();

		Object res = null;
		while (resultSet.next()) {
			if ("A".equalsIgnoreCase(tableName)) {
				A a = new A();
				a.setId(resultSet.getInt("id"));
				a.setXingming(resultSet.getString("xingming"));
				res = a;
			} else if ("B".equalsIgnoreCase(tableName)) {
				B b = new B();
				b.setId(resultSet.getInt("id"));
				b.setName(resultSet.getString("name"));
				res = b;
			}

		}

		resultSet.close();
		preparedStatement.close();
		return (T) res;
	}
}

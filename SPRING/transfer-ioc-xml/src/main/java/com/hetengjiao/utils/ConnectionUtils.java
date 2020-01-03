package com.hetengjiao.utils;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionUtils {

	private ThreadLocal<Connection> threadLocal = new ThreadLocal<>();

	public Connection getCurrentThreadConn() throws SQLException {
		Connection conn = threadLocal.get();

		if (null == conn) {
			conn = DruidUtils.getInstance().getConnection();
			threadLocal.set(conn);
		}

		return conn;
	}

}

package com.hetengjiao.utils;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionUtils {


	private ConnectionUtils() {

	}

	private static class Holder {
		private static ConnectionUtils instance = new ConnectionUtils();
	}

	public static ConnectionUtils getInstance() {
		return Holder.instance;
	}

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

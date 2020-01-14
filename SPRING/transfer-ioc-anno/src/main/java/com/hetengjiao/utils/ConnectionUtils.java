package com.hetengjiao.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Component("connectionUtils")

public class ConnectionUtils {

	@Autowired
	private DataSource dataSource;

	private ThreadLocal<Connection> threadLocal = new ThreadLocal<>();

	public Connection getCurrentThreadConn() throws SQLException {
		Connection conn = threadLocal.get();

		if (null == conn) {
			conn = dataSource.getConnection();
			threadLocal.set(conn);
		}

		return conn;
	}

}

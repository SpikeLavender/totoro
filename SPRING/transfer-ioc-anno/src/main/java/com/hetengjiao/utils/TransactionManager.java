package com.hetengjiao.utils;

import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.beans.Transient;
import java.sql.SQLException;

/**
 * 事务管理类：负责手动事务的开启、提交、回滚
 */

@Component("transactionManager")
@Aspect
public class TransactionManager {

	@Autowired
	private ConnectionUtils connectionUtils;

	//开启手动事务控制
	public void beginTransaction() throws SQLException {
		connectionUtils.getCurrentThreadConn().setAutoCommit(false);
	}

	//提交事务
	public void commit() throws SQLException {
		connectionUtils.getCurrentThreadConn().commit();
	}

	//回滚事务
	public void rollback() throws SQLException {
		connectionUtils.getCurrentThreadConn().rollback();
	}
}

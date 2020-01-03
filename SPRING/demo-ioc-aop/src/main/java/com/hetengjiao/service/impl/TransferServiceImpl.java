package com.hetengjiao.service.impl;

import com.hetengjiao.dao.AccountDao;
import com.hetengjiao.dao.impl.JdbcAccountDaoImpl;
import com.hetengjiao.factory.BeanFactory;
import com.hetengjiao.pojo.Account;
import com.hetengjiao.service.TransferService;
import com.hetengjiao.utils.ConnectionUtils;
import com.hetengjiao.utils.TransactionManager;

import java.sql.SQLException;

public class TransferServiceImpl implements TransferService {

	//private AccountDao accountDao = new JdbcAccountDaoImpl(); //不用new创建
	//private AccountDao accountDao = (AccountDao) BeanFactory.getBean("accountDao"); // 还是存在硬编码，继续优化
	private AccountDao accountDao;

	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	@Override
	public void transfer(String fromCardNo, String toCardNo, int money) throws SQLException {
//		try {
//			//开启事务
//			//ConnectionUtils.getInstance().getCurrentThreadConn().setAutoCommit(false);
//			TransactionManager.getInstance().beginTransaction();

			Account from = accountDao.queryAccountByCardNo(fromCardNo);
			Account to = accountDao.queryAccountByCardNo(toCardNo);

			from.setMoney(from.getMoney() - money);
			to.setMoney(to.getMoney() + money);

			accountDao.updateAccountByCardNo(from);
			//int c = 1 / 0;
			accountDao.updateAccountByCardNo(to);

			//提交事务
			//ConnectionUtils.getInstance().getCurrentThreadConn().commit();
//			TransactionManager.getInstance().commit();
//		} catch (Exception e) {
//			//ConnectionUtils.getInstance().getCurrentThreadConn().rollback();
//			TransactionManager.getInstance().rollback();
//			throw e;
//		}

	}
}

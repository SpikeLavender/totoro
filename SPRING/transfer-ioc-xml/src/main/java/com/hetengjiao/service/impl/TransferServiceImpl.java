package com.hetengjiao.service.impl;

import com.hetengjiao.dao.AccountDao;
import com.hetengjiao.pojo.Account;
import com.hetengjiao.service.TransferService;

import java.sql.SQLException;

public class TransferServiceImpl implements TransferService {

	private AccountDao accountDao;

	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	@Override
	public void transfer(String fromCardNo, String toCardNo, int money) throws SQLException {
			Account from = accountDao.queryAccountByCardNo(fromCardNo);
			Account to = accountDao.queryAccountByCardNo(toCardNo);

			from.setMoney(from.getMoney() - money);
			to.setMoney(to.getMoney() + money);

			accountDao.updateAccountByCardNo(from);
			//int c = 1 / 0;
			accountDao.updateAccountByCardNo(to);
	}
}

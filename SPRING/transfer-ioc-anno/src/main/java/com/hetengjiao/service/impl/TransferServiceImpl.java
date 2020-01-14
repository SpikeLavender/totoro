package com.hetengjiao.service.impl;

import com.hetengjiao.dao.AccountDao;
import com.hetengjiao.pojo.Account;
import com.hetengjiao.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.sql.SQLException;

@Service("transferService")
public class TransferServiceImpl implements TransferService {

	// @Autowired 按照类型注入, 如果按照类型无法确定唯一对象，可以结合@Qualifier指定具体的id
	@Autowired
	@Qualifier("accountDao")
	private AccountDao accountDao;

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

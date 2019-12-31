package com.totoro.mapper;

import com.totoro.pojo.User;

import java.io.IOException;
import java.util.List;

public interface IUserMapper {
	/**
	 *
	 * @return
	 * @throws IOException
	 */
	List<User> findAll() throws IOException;


	/**
	 * 多条件组合查询，<if></if>
	 * @param user
	 * @return
	 */
	List<User> findByCondition(User user);

	/**
	 * 多值查询
	 * @param ids
	 * @return
	 */
	List<User> findByIds(int[] ids);
}

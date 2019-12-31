package com.totoro;

import com.totoro.mapper.IUserMapper;
import com.totoro.mapper.impl.UserMapperImpl;
import com.totoro.pojo.User;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * 在Dao层使用传统方式
 */
public class DaoMethodTest {
	@Test
	public void testSelect() throws IOException {
		IUserMapper userMapper = new UserMapperImpl();
		List<User> all = userMapper.findAll();
		all.forEach(System.out::println);
	}
}

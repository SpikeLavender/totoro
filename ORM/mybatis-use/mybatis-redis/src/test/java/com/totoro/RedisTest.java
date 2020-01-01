package com.totoro;

import com.totoro.mapper.IUserMapper;
import com.totoro.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class RedisTest {

	private SqlSession sqlSession;

	private IUserMapper userMapper;

	@Before
	public void setUp() throws IOException {
		InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
		sqlSession = sqlSessionFactory.openSession();
		userMapper = sqlSession.getMapper(IUserMapper.class);
	}

	@Test
	public void firstLevelCache1Test() {
		//第一次查询id为1的用户
		User user1 = userMapper.findById(1);
		System.out.println(user1);

		//更新用户
		User user = new User();
		user.setId(1);
		user.setUsername("ha ha ha");
		userMapper.updateUser(user);
		sqlSession.commit();

		sqlSession.clearCache();

		//第二次查询id为1的用户
		User user2 = userMapper.findById(1);
		System.out.println(user2);

		System.out.println(user1 == user2);
	}
}

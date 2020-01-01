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

public class CacheTest {

	private SqlSession sqlSession;
	private SqlSessionFactory sqlSessionFactory;

	private IUserMapper userMapper;

	@Before
	public void setUp() throws IOException {
		InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
		sqlSession = sqlSessionFactory.openSession();
		userMapper = sqlSession.getMapper(IUserMapper.class);
	}

	@Test
	public void firstLevelCacheTest() {
		//第一次查询id为1的用户
		User user1 = userMapper.findById(1);
		System.out.println(user1);

		//第二次查询id为1的用户
		User user2 = userMapper.findById(1);
		System.out.println(user2);

		System.out.println(user1 == user2);
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

	@Test
	public void secondLevelCacheTest() {

		SqlSession sqlSession1 = sqlSessionFactory.openSession();
		SqlSession sqlSession2 = sqlSessionFactory.openSession();

		IUserMapper mapper1 = sqlSession1.getMapper(IUserMapper.class);
		IUserMapper mapper2 = sqlSession2.getMapper(IUserMapper.class);

		//第一次查询id为1的用户
		User user1 = mapper1.findById(1);
		System.out.println(user1);
		sqlSession1.close(); //清空一级缓存
		//第二次查询id为1的用户
		User user2 = mapper2.findById(1);
		System.out.println(user2);

		System.out.println(user1 == user2);
	}

	@Test
	public void secondLevelCache2Test() {

		SqlSession sqlSession1 = sqlSessionFactory.openSession();
		SqlSession sqlSession2 = sqlSessionFactory.openSession();
		SqlSession sqlSession3 = sqlSessionFactory.openSession();

		IUserMapper mapper1 = sqlSession1.getMapper(IUserMapper.class);
		IUserMapper mapper2 = sqlSession2.getMapper(IUserMapper.class);
		IUserMapper mapper3 = sqlSession3.getMapper(IUserMapper.class);

		//第一次查询id为1的用户
		User user1 = mapper1.findById(1);
		System.out.println(user1);
		sqlSession1.close(); //清空一级缓存

		//更新用户
		User user = new User();
		user.setId(1);
		user.setUsername("ha ha ha");
		mapper3.updateUser(user);
		sqlSession3.commit();

		//第二次查询id为1的用户
		User user2 = mapper2.findById(1);
		System.out.println(user2);

		System.out.println(user1 == user2);
	}
}

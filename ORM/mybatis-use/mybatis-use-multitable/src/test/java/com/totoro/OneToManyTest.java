package com.totoro;

import com.totoro.mapper.IOrderMapper;
import com.totoro.mapper.IUserMapper;
import com.totoro.pojo.Order;
import com.totoro.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class OneToManyTest {
	@Test
	public void testFindAll() throws IOException {
		InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
		SqlSession sqlSession = sessionFactory.openSession();

		IUserMapper mapper = sqlSession.getMapper(IUserMapper.class);
		List<User> users = mapper.findAll();

		users.forEach(System.out::println);

		sqlSession.close();
	}

	@Test
	public void testFindNotNull() throws IOException {
		InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
		SqlSession sqlSession = sessionFactory.openSession();

		IUserMapper mapper = sqlSession.getMapper(IUserMapper.class);
		List<User> users = mapper.findAll();

		users.forEach(System.out::println);

		sqlSession.close();
	}
}

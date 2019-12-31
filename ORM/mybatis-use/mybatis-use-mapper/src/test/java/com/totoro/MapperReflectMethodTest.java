package com.totoro;

import com.totoro.mapper.IUserMapper;
import com.totoro.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * 在Dao层使用传统方式
 */
public class MapperReflectMethodTest {
	@Test
	public void testSelect() throws IOException {
		InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
		SqlSession sqlSession = sessionFactory.openSession();

		IUserMapper mapper = sqlSession.getMapper(IUserMapper.class);
		List<User> users = mapper.findAll();

		users.forEach(System.out::println);

		sqlSession.close();
	}

	@Test
	public void testSelectById() throws IOException {
		InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
		SqlSession sqlSession = sessionFactory.openSession();

		User user = new User();
		user.setId(1);

		IUserMapper mapper = sqlSession.getMapper(IUserMapper.class);
		List<User> users = mapper.findByCondition(user);

		users.forEach(System.out::println);
		sqlSession.close();
	}

	@Test
	public void testSelectByUsername() throws IOException {
		InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
		SqlSession sqlSession = sessionFactory.openSession();

		User user = new User();
		user.setUsername("hetengjiao");

		IUserMapper mapper = sqlSession.getMapper(IUserMapper.class);
		List<User> users = mapper.findByCondition(user);

		users.forEach(System.out::println);
		sqlSession.close();
	}

	@Test
	public void testSelectByIdAndUsernameFalse() throws IOException {
		InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
		SqlSession sqlSession = sessionFactory.openSession();

		User user = new User();
		user.setId(10);
		user.setUsername("hetengjiao");

		IUserMapper mapper = sqlSession.getMapper(IUserMapper.class);
		List<User> users = mapper.findByCondition(user);

		users.forEach(System.out::println);
		sqlSession.close();
	}

	@Test
	public void testSelectByIdAndUsernameTrue() throws IOException {
		InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
		SqlSession sqlSession = sessionFactory.openSession();

		User user = new User();
		user.setId(1);
		user.setUsername("hetengjiao");

		IUserMapper mapper = sqlSession.getMapper(IUserMapper.class);
		List<User> users = mapper.findByCondition(user);

		users.forEach(System.out::println);
		sqlSession.close();
	}

	@Test
	public void testFindByIds() throws IOException {
		InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
		SqlSession sqlSession = sessionFactory.openSession();

		IUserMapper mapper = sqlSession.getMapper(IUserMapper.class);

		int[] arr = {1,5};
		List<User> users = mapper.findByIds(arr);

		users.forEach(System.out::println);
		sqlSession.close();
	}
}

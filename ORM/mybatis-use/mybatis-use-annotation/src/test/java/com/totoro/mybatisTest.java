package com.totoro;


import com.totoro.mapper.IOrderMapper;
import com.totoro.mapper.IUserMapper;
import com.totoro.pojo.Order;
import com.totoro.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {


	private IUserMapper userMapper;
	private IOrderMapper orderMapper;

	@Before
	public void setUp() throws IOException {
		InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
		SqlSession sqlSession = sessionFactory.openSession(true);
		userMapper = sqlSession.getMapper(IUserMapper.class);
		orderMapper = sqlSession.getMapper(IOrderMapper.class);
	}

	@Test
	public void addUserTest() {
		User user = new User();
		user.setId(101);
		user.setUsername("test101");
		userMapper.addUser(user);
	}

	@Test
	public void updateUserTest() {
		User user = new User();
		user.setId(101);
		user.setUsername("test101-update");
		userMapper.updateUser(user);
	}

	@Test
	public void selectUserTest() {
		List<User> users = userMapper.selectUser();
		users.forEach(System.out::println);
	}

	@Test
	public void deleteUserTest() {
		userMapper.deleteUser(101);
	}


	@Test
	public void oneToOne() {
		List<Order> orders = orderMapper.findOrderAndUser();
		orders.forEach(System.out::println);
	}

	@Test
	public void oneToMany() {
		List<User> users = userMapper.findAll();
		users.forEach(System.out::println);
	}

	@Test
	public void ManyToMany() {
		List<User> users = userMapper.findUserAndRole();
		users.forEach(System.out::println);
	}
}

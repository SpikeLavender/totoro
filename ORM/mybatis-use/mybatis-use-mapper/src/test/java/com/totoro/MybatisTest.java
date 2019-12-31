package com.totoro;


import com.totoro.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {

	@Test
	public void testSelect() throws IOException {
		InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
		SqlSession sqlSession = sessionFactory.openSession();
		List<User> users = sqlSession.selectList("userMapper.findAll");

		users.forEach(System.out::println);

		sqlSession.close();
		//Configuration：核心配置类：存放sqlMapConfig.xml解析出来的内容
		//MappedStatement：映射配置类：存放mapper.xml解析出来的内容
	}

	@Test
	public void testInsert() throws IOException {
		InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
		SqlSession sqlSession = sessionFactory.openSession();
		User user = new User();

		user.setId(11);
		user.setUsername("hetengjiao");

		sqlSession.insert("userMapper.saveUser", user);
		sqlSession.commit();
		sqlSession.close();
	}

	@Test
	public void testUpdate() throws IOException {
		InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
		SqlSession sqlSession = sessionFactory.openSession();
		User user = new User();

		user.setId(11);
		user.setUsername("chaixueyan");

		sqlSession.insert("userMapper.updateUser", user);
		sqlSession.commit();
		sqlSession.close();
	}

	@Test
	public void testDelete() throws IOException {
		InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
		SqlSession sqlSession = sessionFactory.openSession();

		sqlSession.delete("userMapper.deleteUser", 11);
		sqlSession.commit();
		sqlSession.close();
	}
}

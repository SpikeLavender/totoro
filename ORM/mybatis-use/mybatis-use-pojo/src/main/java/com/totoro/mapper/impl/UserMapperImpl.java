package com.totoro.mapper.impl;

import com.totoro.mapper.IUserMapper;
import com.totoro.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserMapperImpl implements IUserMapper {
	@Override
	public List<User> findAll() throws IOException {
		InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
		SqlSession sqlSession = sessionFactory.openSession();
		List<User> users = sqlSession.selectList("userMapper.findAll");

		sqlSession.close();
		return users;
	}
}

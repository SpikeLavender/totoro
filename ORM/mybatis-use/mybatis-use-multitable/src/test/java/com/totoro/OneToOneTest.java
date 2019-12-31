package com.totoro;

import com.totoro.mapper.IOrderMapper;
import com.totoro.pojo.Order;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class OneToOneTest {

	@Test
	public void testOneToOne() throws IOException {
		InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
		SqlSession sqlSession = sessionFactory.openSession();

		IOrderMapper mapper = sqlSession.getMapper(IOrderMapper.class);
		List<Order> orders = mapper.findOrderAndUser();

		orders.forEach(System.out::println);

		sqlSession.close();
	}
}

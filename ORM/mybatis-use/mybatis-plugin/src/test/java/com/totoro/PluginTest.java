package com.totoro;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.totoro.mapper.IOrderMapper;
import com.totoro.mapper.IUserMapper;
import com.totoro.mapper.IUserInfoMapper;
import com.totoro.pojo.Order;
import com.totoro.pojo.User;
import com.totoro.pojo.UserInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Config;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.mapperhelper.MapperHelper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class PluginTest {

	@Test
	public void myPluginTest() throws IOException {
		InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
		SqlSession sqlSession = sessionFactory.openSession();

		IOrderMapper mapper = sqlSession.getMapper(IOrderMapper.class);
		List<Order> orders = mapper.findOrderAndUser();

		orders.forEach(System.out::println);

		sqlSession.close();
	}

	@Test
	public void pageHelperTest() throws IOException {
		InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
		SqlSession sqlSession = sessionFactory.openSession();

		IUserMapper mapper = sqlSession.getMapper(IUserMapper.class);

		PageHelper.startPage(1, 5);
		List<User> users = mapper.findAll();

		users.forEach(System.out::println);

		PageInfo<User> pageInfo = new PageInfo<>(users);

		System.out.println("总条数: " + pageInfo.getTotal());
		System.out.println("总页数: " + pageInfo.getPages());
		System.out.println("当前页: " + pageInfo.getPageNum());
		System.out.println("每页显示的条数: " + pageInfo.getPageSize());
		sqlSession.close();
	}

	/**
	 * 3.1.2 版本
	 * @throws IOException e
	 */
	@Test
	public void mapperOldTest() throws IOException {
		InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
		SqlSession sqlSession = sessionFactory.openSession();

		IUserInfoMapper mapper = sqlSession.getMapper(IUserInfoMapper.class);

		UserInfo user = new UserInfo();
		user.setId(1);

		UserInfo user1 = mapper.selectOne(user);

		System.out.println(user1);

		//2.example方法
		Example example = new Example(UserInfo.class);
		example.createCriteria().andEqualTo("id", 5);
		List<UserInfo> userInfos = mapper.selectByExample(example);
		userInfos.forEach(System.out::println);

	}

	/**
	 * 3.2.0 以上版本
	 *
	 * @throws IOException e
	 */
	@Test
	public void mapperNewTest() throws IOException {
		InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
		SqlSession sqlSession = sessionFactory.openSession();


		//创建一个MapperHelper
		MapperHelper mapperHelper = new MapperHelper();
		//特殊配置
		Config config = new Config();
		//主键自增回写方法,默认值MYSQL,详细说明请看文档
		config.setIDENTITY("MYSQL");
		//支持getter和setter方法上的注解
		config.setEnableMethodAnnotation(true);
		//设置 insert 和 update 中，是否判断字符串类型!=''
		config.setNotEmpty(true);
		//校验Example中的类型和最终调用时Mapper的泛型是否一致
		config.setCheckExampleEntityClass(true);
		//启用简单类型
		config.setUseSimpleType(true);
		//枚举按简单类型处理
		config.setEnumAsSimpleType(true);
		//自动处理关键字 - mysql
		config.setWrapKeyword("`{0}`");
		//设置配置
		mapperHelper.setConfig(config);
		//注册通用接口，和其他集成方式中的 mappers 参数作用相同
		//4.0 之后的版本，如果类似 Mapper.class 这样的基础接口带有 @RegisterMapper 注解，就不必在这里注册
		mapperHelper.registerMapper(Mapper.class);
		//配置 mapperHelper 后，执行下面的操作
		mapperHelper.processConfiguration(sqlSession.getConfiguration());

		IUserInfoMapper mapper = sqlSession.getMapper(IUserInfoMapper.class);

		UserInfo user = new UserInfo();
		user.setId(1);

		UserInfo user1 = mapper.selectOne(user);

		System.out.println(user1);

		//2.example方法
		Example example = new Example(UserInfo.class);
		example.createCriteria().andEqualTo("id", 5);
		List<UserInfo> userInfos = mapper.selectByExample(example);
		userInfos.forEach(System.out::println);

	}
}

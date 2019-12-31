package com.totoro.mapper;

import com.totoro.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IUserMapper {
	//查询所有用户并查询用户关联的订单
	@Results({
			@Result(property = "id", column = "id"),
			@Result(property = "username", column = "username"),
			@Result(property = "orders", column = "id", javaType = List.class,
					many = @Many(select = "com.totoro.mapper.IOrderMapper.findOrderByUid")),
	})
	@Select("select * from user")
	List<User> findAll();


	@Results({
			@Result(property = "id", column = "id"),
			@Result(property = "username", column = "username"),
			@Result(property = "roles", column = "id", javaType = List.class,
					many = @Many(select = "com.totoro.mapper.IRoleMapper.findRoleByUid"))
	})
	@Select("select * from user")
	List<User> findUserAndRole();

	//添加用户
	@Insert("insert into user values(#{id}, #{username})")
	void addUser(User user);

	//更新用户
	@Update("update user set username = #{username} where id = #{id}")
	void updateUser(User user);

	//查询用户
	@Select("select * from user")
	List<User> selectUser();

	//删除用户
	@Delete("delete from user where id = #{id}")
	void deleteUser(Integer id);

	//根据id查询用户
	@Select("select * from user where id = #{id}")
	User findUserById(Integer id);
}

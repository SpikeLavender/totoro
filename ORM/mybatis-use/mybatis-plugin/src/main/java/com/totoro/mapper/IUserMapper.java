package com.totoro.mapper;

import com.totoro.pojo.User;

import java.util.List;

public interface IUserMapper {
	//查询所有用户并查询用户关联的订单
	List<User> findAll();

	//只查询所有关联的订单的用户，没有订单的用户不查询
	List<User> findNotNull();

	//查询所有用户，同时查询每个用户关联的角色信息
	List<User> findAllUserAndRole();
}

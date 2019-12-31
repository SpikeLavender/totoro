package com.totoro.mapper;

import com.totoro.pojo.Order;
import com.totoro.pojo.User;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.io.IOException;
import java.util.List;

public interface IOrderMapper {
	/**
	 *
	 * @return
	 */
	@Results({
			@Result(property = "id", column = "id"),
			@Result(property = "orderTime", column = "orderTime"),
			@Result(property = "total", column = "total"),
			@Result(property = "user", column = "uid", javaType = User.class,
					one = @One(select = "com.totoro.mapper.IUserMapper.findUserById"))
	})
	@Select("select * from orders")
	List<Order> findOrderAndUser();

	@Select("select * from orders where uid = #{uid}")
	List<Order> findOrderByUid(Integer uid);
}

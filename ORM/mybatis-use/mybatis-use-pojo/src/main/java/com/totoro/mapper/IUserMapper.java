package com.totoro.mapper;

import com.totoro.pojo.User;

import java.io.IOException;
import java.util.List;

public interface IUserMapper {
	List<User> findAll() throws IOException;
}

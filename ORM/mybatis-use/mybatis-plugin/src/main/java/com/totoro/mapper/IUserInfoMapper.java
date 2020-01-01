package com.totoro.mapper;

import com.totoro.pojo.UserInfo;
import tk.mybatis.mapper.annotation.RegisterMapper;
import tk.mybatis.mapper.common.Mapper;


@RegisterMapper
public interface IUserInfoMapper extends Mapper<UserInfo> {
}

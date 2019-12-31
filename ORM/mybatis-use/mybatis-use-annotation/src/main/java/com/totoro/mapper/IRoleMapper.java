package com.totoro.mapper;

import com.totoro.pojo.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IRoleMapper {

	@Select("select * from sys_role r, sys_user_role ur where r.id = ur.role_id and ur.user_id = #{id}")
	List<Role> findRoleByUid(Integer uid);
}

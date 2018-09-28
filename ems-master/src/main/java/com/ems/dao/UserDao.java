package com.ems.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.omg.CosNaming.IstringHelper;

import com.ems.model.User;

@Mapper
public interface UserDao
{
	@Select("select * from user where roleId=#{roleId}")
	User getUserByRoleId(String roleId);
	
	@Select("select * from user where authId=#{authId}")
	List<User> getUsersByAuthId(int authId);
	
	@Select("select * from user")
	List<User> getAll();
	@Select("select * from user where id=#{id}")
	User getUserById(int id);
	@Select("select * from user where type=#{type}")
	List<User> getUsersByType(String type);
}

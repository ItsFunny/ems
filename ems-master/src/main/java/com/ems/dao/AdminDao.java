package com.ems.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.ems.model.Admin;

@Mapper
public interface AdminDao
{
	@Select("select * from admin where id=#{id}")
	Admin getAdminById(int id);
}

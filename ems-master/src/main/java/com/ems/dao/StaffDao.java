package com.ems.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.ems.model.Staff;

@Mapper
public interface StaffDao
{

	@Select("select * from staff where stafName=#{stafName}")
	Staff getStaffByName(String name);
}

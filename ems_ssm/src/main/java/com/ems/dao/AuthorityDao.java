package com.ems.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.ems.model.Authority;

@Mapper
public interface AuthorityDao
{
	@Select("select * from authority")
	List<Authority> getAll();
	
	@Select("select * from authority where id=#{id}")
	Authority getAuthById(int id);
}

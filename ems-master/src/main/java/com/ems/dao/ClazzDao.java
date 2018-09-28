package com.ems.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.ems.model.Clazz;

@Mapper
public interface ClazzDao
{
	@Select("select id,name,spec_id as specId,year from class")
	public List<Clazz> getAll();
	@Delete("delete from class where id=#{id}")
	public void deleteById(int id);
	@Insert("insert into class (name,spec_id,year) values (#{name},#{specId},#{year})")
	public void add(Clazz clazz);
	
	@Select("select * from class where id=#{id}")
	public Clazz getClazzById(int id);
	
	@Select("select * from class where name=#{name}")
	public Clazz getClazzByName(String name);
}

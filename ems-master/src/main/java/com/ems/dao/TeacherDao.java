package com.ems.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.ems.model.Teacher;

@Mapper
public interface TeacherDao
{	
	@Select("select * from teacher where id=#{id}")
	Teacher getTeacherById(int id);
	
	@Select("select * from teacher")
	List<Teacher> getAll();

}

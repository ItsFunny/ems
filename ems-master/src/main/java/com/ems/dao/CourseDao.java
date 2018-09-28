package com.ems.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.ems.model.Course;

@Mapper
public interface CourseDao
{

	@Select("select * from course")
	public List<Course> getAll();
	@Select("select * from course where id=#{id}")
	Course getCourseById(int id);
	
	@Select("select * from course where name=#{name}")
	Course getCourseByName(String name);
	
	@Select("select * from course where spec_id=#{specId}")
	List<Course> getCourseListsBySpecId(int specId);
	
	
	@Insert("insert into course (name,type,credit,spec_id) values (#{name},#{type},#{credit},#{specId})")
	public void add(Course course);
	
	@Delete("delete from course where id=#{id}")
	public void deleteById(int id);
	
		
}

package com.ems.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.ems.model.CourseSection;


@Mapper
public interface CourseSectionDao
{
	@Select("select * from course_section ")
	public List<CourseSection> getAll();
	
	@Insert("insert into course_section (courseName,year,uid,limitCount) values (#{courseName},#{year},#{uid},#{limitCount})")
	public void addCourseSection(CourseSection courseSection);
	
	@Delete("delete from course_section where id=#{id}")
	public void deleteById(int id);
	
}

package com.ems.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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
	
	
	//19号或者20号把这个方法更改为xml中的方法
	@Update("update  course_section set choosedCount=#{choosedCount} where id=#{id}")
	public void update(@Param("choosedCount")Integer choosedCount,@Param("id")Integer id);
	
}

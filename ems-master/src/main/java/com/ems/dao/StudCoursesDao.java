package com.ems.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.ems.model.StudCourses;

@Mapper
public interface StudCoursesDao
{
	@Select("select * from stud_courses")
	List<StudCourses> getAll();
	
	
	//学生点击选课之后,添加一条记录,成绩默认为0分
	@Insert("insert into stud_courses (stud_id,course_section_id) values (#{studId},#{courseSectionId})")
	void addStudCourse(@Param("studId")Integer studId,@Param("courseSectionId")Integer courseSectionId);
}

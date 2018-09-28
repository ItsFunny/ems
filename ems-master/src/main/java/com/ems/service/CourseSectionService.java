package com.ems.service;

import java.util.List;

import com.ems.model.CourseSection;

public interface CourseSectionService
{
	public List<CourseSection> getAll();
	
	public void addCourseSection(CourseSection courseSection);
	
	public void deleteById(int id);
	
	public void update(Integer choosedCount,Integer id);
}

package com.ems.service;

import java.util.List;

import com.ems.model.StudCourses;

public interface StudCoursesService
{
	public List<StudCourses> getAll();
	void addStudCourse(Integer studId,Integer courseSectionId);
}

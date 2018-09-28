package com.ems.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.dao.StudCoursesDao;
import com.ems.model.StudCourses;
import com.ems.service.StudCoursesService;

@Service
public class StudCourseServiceImpl implements StudCoursesService
{
	@Autowired
	StudCoursesDao studCoursesDao;
	@Override
	public List<StudCourses> getAll()
	{
		return studCoursesDao.getAll();
	}
	@Override
	public void addStudCourse(Integer studId,Integer courseSectionId)
	{
		studCoursesDao.addStudCourse(studId,courseSectionId);
	}
}

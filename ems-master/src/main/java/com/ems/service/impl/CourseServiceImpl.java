package com.ems.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.dao.CourseDao;
import com.ems.model.Course;
import com.ems.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService
{

	@Autowired
	CourseDao courseDao;
	@Override
	public Course getCourseById(int id)
	{
		return courseDao.getCourseById(id);
	}
	@Override
	public Course getCourseByName(String name)
	{
		return courseDao.getCourseByName(name);
	}
	@Override
	public List<Course> getAll()
	{
		return courseDao.getAll();
	}
	@Override
	public List<Course> getCourseListsBySpecId(int specId)
	{
		return courseDao.getCourseListsBySpecId(specId);
	}
	@Override
	public void add(String name, String type, Float credit, int specId)
	{
		Course course=new Course();
		course.setName(name);
		course.setType(type);
		course.setCredit(credit);
		course.setSpecId(specId);
		courseDao.add(course);
		
	}
	@Override
	public void deleteById(int id)
	{
		courseDao.deleteById(id);
	}

	
}

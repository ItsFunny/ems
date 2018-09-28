package com.ems.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.dao.CourseSectionDao;
import com.ems.model.CourseSection;
import com.ems.service.CourseSectionService;

@Service
public class CourseSectionServiceImpl implements CourseSectionService
{
	
	@Autowired
	CourseSectionDao courseSectionDao;
	@Override
	public List<CourseSection> getAll()
	{
		return courseSectionDao.getAll();
	}
	@Override
	public void addCourseSection(CourseSection courseSection)
	{
		courseSectionDao.addCourseSection(courseSection);
	}
	@Override
	public void deleteById(int id)
	{
		courseSectionDao.deleteById(id);
	}
	@Override
	public void update(Integer choosedCount, Integer id)
	{
		courseSectionDao.update(choosedCount, id);
	}

}

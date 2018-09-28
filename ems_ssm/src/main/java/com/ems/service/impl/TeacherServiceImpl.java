/**
 * 
 */
package com.ems.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.dao.TeacherDao;
import com.ems.model.Teacher;
import com.ems.service.TeacherService;

/**
 * @author Administrator
 *
 */
@Service
public class TeacherServiceImpl implements TeacherService
{
	@Autowired
	TeacherDao teacherDao;

	public Teacher getTeacherById(int id)
	{
		return teacherDao.getTeacherById(id);
	}

	public List<Teacher> getAll()
	{
		return teacherDao.getAll();
	}
	
}

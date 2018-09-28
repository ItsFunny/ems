package com.ems.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.dao.StudentDao;
import com.ems.model.Student;
import com.ems.service.StudentService;

@Service
public class StundentServiceImpl implements StudentService
{
	@Autowired
	StudentDao studentDao;

	public Student getStudentById(int id)
	{
		return studentDao.getStudentById(id);
	}

	public void updateStudById(String password,int id)
	{
		Date date=new Date(System.currentTimeMillis());
		studentDao.updateStudById( password,date,id);
	}

	public List<Student> getAll()
	{
		// TODO Auto-generated method stub
		return studentDao.getAll();
	}

	public void updateStudentById(Student student)
	{
		studentDao.updateStudentById(student);
	}

	public List<Student> getStudentsByDeptId(int deptId)
	{
		return studentDao.getStudentsByDeptId(deptId);
	}

	public void add(Student student)
	{
		if(student.getId()==null)
		{
			student.setCredit(0f);
			student.setCreateDate(new Date());
			student.setUpgradeCredit(0f);
		}
		student.setUpdateDate(student.getCreateDate());
		studentDao.add(student);
	}

	public void deleteStudentById(Integer studId)
	{
		studentDao.deleteStudentById(studId);
	}

}
 
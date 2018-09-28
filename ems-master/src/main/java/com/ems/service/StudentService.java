package com.ems.service;

import java.util.List;

import com.ems.model.Student;

public interface StudentService
{
	Student getStudentByRoleId(int id);
	void updateStudById(String password,int id);
	public List<Student> getAll();
	public void updateStudentById(Student student);
	public List<Student> getStudentsByDeptId(int deptId);
	
	public void add(Student student);
	
	public void deleteStudentById(Integer id);
}

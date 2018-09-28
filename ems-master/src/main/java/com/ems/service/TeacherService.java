package com.ems.service;

import java.util.List;

import com.ems.model.Teacher;

public interface TeacherService
{
	Teacher getTeacherById(int id);
	List<Teacher> getAll();
}

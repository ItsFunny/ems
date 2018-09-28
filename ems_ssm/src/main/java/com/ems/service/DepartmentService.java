package com.ems.service;

import java.util.List;

import com.ems.model.Department;

public interface DepartmentService
{
	public List<Department> getAll();
	public void add(Department department,String name);
	public void update(String name,int deptId);
	public void delete(int id);
	public Department findByName(String name);
	public Department findById(int id);
}

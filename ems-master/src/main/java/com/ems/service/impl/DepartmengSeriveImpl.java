package com.ems.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.dao.DepartmengDao;
import com.ems.model.Department;
import com.ems.service.DepartmentService;

@Service
public class DepartmengSeriveImpl implements DepartmentService
{
	@Autowired
	DepartmengDao departmengDao;

	@Override
	public List<Department> getAll()
	{
		return departmengDao.getAll();
	}

	@Override
	public void add(Department department,String name)
	{
		department.setName(name);
		department.setCreateDate(new Date(System.currentTimeMillis()));
		departmengDao.add(department);
	}

	@Override
	public void update(String name,int deptId)
	{
		departmengDao.update(name,deptId);
	}

	@Override
	public void delete(int id)
	{
		departmengDao.delete(id);
	}

	@Override
	public Department findByName(String name)
	{
		return departmengDao.findByName(name);
	}

	@Override
	public Department findById(int id)
	{
		return departmengDao.findById(id);
	}

	

}

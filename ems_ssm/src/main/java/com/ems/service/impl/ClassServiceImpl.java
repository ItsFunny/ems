package com.ems.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.dao.ClazzDao;
import com.ems.model.Clazz;
import com.ems.service.ClazzService;


@Service
public class ClassServiceImpl  implements ClazzService
{
	@Autowired
	ClazzDao clazzDao;

	public List<Clazz> getAll()
	{
		return clazzDao.getAll();
	}

	public void deleteById(int id)
	{
		clazzDao.deleteById(id);
	}

	public void add(String name,int spec_id,String year)
	{
		Clazz clazz=new Clazz();
		clazz.setSpecId(spec_id);
		clazz.setName(name);
		clazz.setYear(year);
		clazzDao.add(clazz);
	}

	public Clazz getClazzById(int id)
	{
		return clazzDao.getClazzById(id);
	}

	public Clazz getClazzByName(String name)
	{
		return clazzDao.getClazzByName(name);
	}
	
}

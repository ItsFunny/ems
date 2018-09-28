package com.ems.service.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ems.dao.SpecialityDao;
import com.ems.model.Speciality;
import com.ems.service.SpeciailtyService;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

@Service
public class SpeciaityServiceImpl implements SpeciailtyService
{
	
	@Autowired
	SpecialityDao specialityDao;
	public List<Speciality> getAll()
	{
		return specialityDao.getAll();
	}
	public void add(Speciality speciality,String name,int deptId)
	{
		if(speciality.getCreateDate()==null)
		{
			speciality.setCreateDate(new Date(System.currentTimeMillis()));
		}
		speciality.setUpdateDate(speciality.getCreateDate());
		speciality.setName(name);
		speciality.setDeptId(deptId);
		specialityDao.add(speciality);
	}
	public void updateById(String name, int id)
	{
		specialityDao.updateById(name, new Date(System.currentTimeMillis()), id);
	}
	public void deleteById(int id)
	{
	
		specialityDao.deleteById(id);
	}
	public Speciality findById(int id)
	{
		return specialityDao.findById(id);
	}
	public Speciality findByName(String name)
	{
		return specialityDao.findByName(name);
	}
	public List<Speciality> findSpecialitiesByDeptId(int deptId)
	{
		return specialityDao.findSpecialitiesByDeptId(deptId);
	}

}

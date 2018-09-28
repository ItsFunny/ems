package com.ems.service;

import java.util.List;

import com.ems.model.Speciality;

public interface SpeciailtyService
{
	public List<Speciality>getAll();
	public void add(Speciality speciality,String name,int deptId);
	public void updateById(String name,int id);
	public void deleteById(int id);
	public Speciality findById(int id);
	public Speciality findByName(String name);
	public List<Speciality> findSpecialitiesByDeptId(int deptId);
}

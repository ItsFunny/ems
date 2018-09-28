package com.ems.service;

import java.util.List;

import com.ems.model.Clazz;

public interface ClazzService
{
	public List<Clazz>getAll();
	public void deleteById(int id);
	public void add(String name,int spec_id,String year);
	public Clazz getClazzById(int id);
	public Clazz getClazzByName(String name);
}

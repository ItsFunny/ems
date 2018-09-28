/**
 * 
 */
package com.ems.service;

import java.util.List;

import com.ems.model.Course;

/**
 * @author Administrator
 *
 */
public interface CourseService
{
	public Course getCourseById(int id);
	public Course getCourseByName(String name);
	public List<Course>getAll();
	public List<Course>getCourseListsBySpecId(int specId);
	public void add(String name,String type,Float credit,int specId);
	public void deleteById(int id);
}

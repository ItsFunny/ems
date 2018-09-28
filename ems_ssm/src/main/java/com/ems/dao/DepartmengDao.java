package com.ems.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ems.model.Department;

@Mapper
public interface DepartmengDao
{
	@Select("select * from department")
	List<Department> getAll();
	
	@Insert("insert into department (name,createDate) values (#{name},#{createDate})")
	public void add(Department department);
	
	
	@Update("update department set name=#{name} where id=#{deptId}")
	public void update(@Param("name")String name,@Param("deptId")int deptId);
	
	@Delete("delete from department where id=#{id}")
	public void delete(int id);
	
	@Select("select * from department where name=#{name}")
	public Department findByName(String name);
	
	@Select("select * from department where id=#{id}")
	public Department findById(int id);
	
}

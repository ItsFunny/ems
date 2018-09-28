package com.ems.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ems.model.Speciality;

@Mapper
public interface SpecialityDao
{

	@Select("select id,name,dept_id as deptId,create_date as createDate,update_date as updateDate from speciality")
	public List<Speciality> getAll();
	
	@Insert("insert into speciality (name,dept_id,create_date,update_date) values (#{name},#{deptId},#{createDate},#{updateDate})")
	public void add(Speciality speciality);
	@Update("update speciality set name=#{name},update_date=#{updateDate} where id=#{specId}")
	public void updateById(@Param("name")String name,@Param("updateDate")Date date,@Param("specId")int id);
	
	@Delete("delete from speciality where id=#{id}")
	public void deleteById(int id);
	
	@Select("select id,name,dept_id as deptId,create_date as createDate,update_date as updateDate from speciality where id=#{id}")
	public Speciality findById(int id);
	@Select("select id,name,dept_id as deptId,create_date as createDate,update_date as updateDate from speciality where name=#{name}")
	public Speciality findByName(String name);
	
	@Select("select * from speciality where dept_id=#{deptId}")
	public List<Speciality> findSpecialitiesByDeptId(int deptId);
}

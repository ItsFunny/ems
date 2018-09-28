package com.ems.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.ems.model.TimeTable;

@Mapper
public interface TimeTableDao
{
	@Select("select * from timetable")
	public List<TimeTable> getAll();
	
	@Insert("insert into timetable (sectId,time,weeks,week,classroom) values (#{sectId},#{time},#{weeks},#{week},#{classroom})")
	public void add(TimeTable timeTable);
}

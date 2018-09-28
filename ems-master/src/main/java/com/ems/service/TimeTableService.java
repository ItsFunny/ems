package com.ems.service;

import java.util.List;

import com.ems.model.TimeTable;

public interface TimeTableService
{
	public List<TimeTable> getAll();
	
	public void add(TimeTable timeTable);
}

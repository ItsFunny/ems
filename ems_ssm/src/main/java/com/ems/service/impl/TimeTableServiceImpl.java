package com.ems.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.dao.TimeTableDao;
import com.ems.model.TimeTable;
import com.ems.service.TimeTableService;

@Service

public class TimeTableServiceImpl implements TimeTableService
{
	@Autowired
	TimeTableDao timeTableDao;
	public List<TimeTable> getAll()
	{
		
		return timeTableDao.getAll();
	}
	public void add(TimeTable timeTable)
	{
		timeTableDao.add(timeTable);
	}
	
}

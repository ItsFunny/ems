package com.ems.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.dao.StaffDao;
import com.ems.model.Staff;
import com.ems.service.StaffService;

@Service
public class StaffServiceImpl implements StaffService
{

	@Autowired
	StaffDao staffDao;
	@Override
	public Staff getStaffByName(String name)
	{
		return staffDao.getStaffByName(name);
	}

}

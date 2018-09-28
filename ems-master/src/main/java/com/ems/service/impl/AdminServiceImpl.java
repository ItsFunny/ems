package com.ems.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.dao.AdminDao;
import com.ems.model.Admin;
import com.ems.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService
{
	@Autowired
	AdminDao adminDao;

	@Override
	public Admin getAdminById(int id)
	{
		return adminDao.getAdminById(id);
	}

}

package com.ems.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.dao.SysPermissionDao;
import com.ems.model.SysPermission;
import com.ems.service.SysPermissionService;

@Service
public class SysPermissionImpl implements SysPermissionService
{

	@Autowired
	SysPermissionDao sysPermissionDao;

	public List<SysPermission> getPermissionsByAuthId(int authId)
	{
		return sysPermissionDao.getPermissionsByAuthId(authId);
	}
	
}

package com.ems.service;

import java.util.List;

import com.ems.model.SysPermission;

public interface SysPermissionService
{
	public List<SysPermission> getPermissionsByAuthId(int authId);
}

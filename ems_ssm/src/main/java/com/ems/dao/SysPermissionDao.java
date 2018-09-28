package com.ems.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.ems.model.SysPermission;

@Mapper
public interface SysPermissionDao
{

	@Select("select * from sys_permission where authId=#{authId}")
	public List<SysPermission> getPermissionsByAuthId(int authId);
}

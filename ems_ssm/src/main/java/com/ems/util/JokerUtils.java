/**
 * 
 */
package com.ems.util;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import com.ems.model.SysPermission;
import com.ems.model.User;
import com.ems.service.SysPermissionService;

/**
 * @author Administrator
 *
 */
public class JokerUtils
{
	
	
	private static List<SysPermission>permissionLists;
	@Autowired
	SysPermissionService sysPermissionService;
	public  List<SysPermission>getLoginUserPermissions()
	{
		Subject subject = SecurityUtils.getSubject();
		User user = (User) subject.getPrincipal();
		permissionLists = sysPermissionService.getPermissionsByAuthId(user.getAuthId());
		return permissionLists;
	}
	public User getLoginUser()
	{
		Subject subject = SecurityUtils.getSubject();
		User user = (User) subject.getPrincipal();
		return user;
	}
	
	
}

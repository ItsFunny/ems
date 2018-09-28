package com.ems.service;

import java.util.List;

import com.ems.model.User;

public interface UserService
{
	User getUserByRoleId(String roleId);
	List<User> getUsersByAuthId(int authId);
	boolean getUserAuthority(String roleId,String password);
	public List<User> getAll();
	User getUserById(int id);
	
	List<User> getUsersByType(String type);
}

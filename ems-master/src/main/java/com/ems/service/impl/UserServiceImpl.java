package com.ems.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.ems.dao.UserDao;
import com.ems.model.User;
import com.ems.service.UserService;

@Service
public class UserServiceImpl implements UserService
{

	@Autowired
	UserDao userDao;
	
//	@Autowired
//	RedisTemplate<String, User> redis;
	
	@Override
	@Cacheable(value="user")
	public User getUserByRoleId(String roleId)
	{
		System.out.println("redisTest");
		User user=null;
//		if(redis.hasKey(roleId))
//		{
//			user = redis.opsForValue().get(roleId);
//		}
//		else {
			user=userDao.getUserByRoleId(roleId);
//		}
		return user;
	}

	@Override
	public List<User> getUsersByAuthId(int authId)
	{
		return userDao.getUsersByAuthId(authId);
	}

	@Override
	public boolean getUserAuthority(String roleId,String password)
	{
		User user=getUserByRoleId(roleId);
		if(user.getPassword().equals(password))
		{
			return true;
		}
		else return false;
	}

	@Override
	public List<User> getAll()
	{
		return userDao.getAll();
	}

	@Override
	public User getUserById(int id)
	{
		return userDao.getUserById(id);
	}

	@Override
	public List<User> getUsersByType(String type)
	{
		return userDao.getUsersByType(type);
	}
	


}

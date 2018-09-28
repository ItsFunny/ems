package com.ems.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.dao.AuthorityDao;
import com.ems.model.Authority;
import com.ems.service.AuthorityService;

@Service
public class AuthorityServiceImpl implements AuthorityService
{

	@Autowired
	AuthorityDao authorityDao;
	
	public List<Authority> getAll()
	{
		return authorityDao.getAll();
	}

	public Authority getAuthById(int id)
	{
		Authority authority=authorityDao.getAuthById(id);
		String resouces=authority.getResources();
		String[] res=resouces.split(",");
		List<String> resLists=new ArrayList<String>();
		for(int i=0;i<res.length;++i)
		{
			resLists.add(res[i]);
		}
		authority.setRes(resLists);
		return authority;
	}

}

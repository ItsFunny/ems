package com.ems.service;

import com.ems.model.Authority;

import java.util.List;

public interface AuthorityService
{
	public List<Authority> getAll();
	public Authority getAuthById(int id);
}

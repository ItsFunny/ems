package com.ems.model;

import java.util.List;

public class Authority
{
	private int id;
	private String description;
	private String name;
	private List<User>users;
	private String resources;
	private List<String> res;
	public List<String> getRes()
	{
		return res;
	}
	public void setRes(List<String> res)
	{
		this.res = res;
	}
	public List<User> getUsers()
	{
		return users;
	}
	public void setUsers(List<User> users)
	{
		this.users = users;
	}
	public String getResources()
	{
		return resources;
	}
	public void setResources(String resources)
	{
		this.resources = resources;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getDescription()
	{
		return description;
	}
	public void setDescription(String description)
	{
		this.description = description;
	}
}

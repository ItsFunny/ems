package com.ems.model;

public class User
{
	
	private Integer id;
	private Integer roleId;
	private String name;
	private String type;
	private String password;
	private Integer authId;
	//新增的角色判断,用于生成主页面
	public boolean isAdmin()
	{
		return type.equals("admin");
	}
	
	public boolean isTeacher()
	{
		return type.equals("teacher");
	}
	
	public boolean isStudent()
	{
		return type.equals("student");
	}
	
	
	public Integer getAuthId()
	{
		return authId;
	}
	public void setAuthId(Integer authId)
	{
		this.authId = authId;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public Integer getId()
	{
		return id;
	}
	public void setId(Integer id)
	{
		this.id = id;
	}
	public Integer getRoleId()
	{
		return roleId;
	}
	public void setRoleId(Integer roleId)
	{
		this.roleId = roleId;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getType()
	{
		return type;
	}
	public void setType(String type)
	{
		this.type = type;
	}
	@Override
	public String toString()
	{
		return "User [id=" + id + ", roleId=" + roleId + ", name=" + name + ", type=" + type + ", password=" + password
				+ ", authId=" + authId + "]";
	}

	
}

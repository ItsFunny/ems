package com.ems.model;

public class SysPermission
{
	private Integer id;
	private String name;
	private Integer authId;
	private String url;
	private String permission;

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}


	public Integer getAuthId()
	{
		return authId;
	}

	public void setAuthId(Integer authId)
	{
		this.authId = authId;
	}

	public String getUrl()
	{
		return url;
	}

	public void setUrl(String url)
	{
		this.url = url;
	}

	public String getPermission()
	{
		return permission;
	}

	public void setPermission(String permission)
	{
		this.permission = permission;
	}

	@Override
	public String toString()
	{
		return "SysPermission [id=" + id + ", name=" + name + ", authId=" + authId + ", url=" + url + ", permission="
				+ permission + "]";
	}

}

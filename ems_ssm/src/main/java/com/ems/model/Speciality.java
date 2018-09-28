/**
 * 
 */
package com.ems.model;

import java.util.Date;


/**
 * @author Administrator
 *
 */
public class Speciality
{
	private Integer id;
	private Integer deptId;
	private String name;
	private Date createDate;
	private Date updateDate;

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public Integer getDeptId()
	{
		return deptId;
	}

	public void setDeptId(Integer deptId)
	{
		this.deptId = deptId;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Date getCreateDate()
	{
		return createDate;
	}

	public void setCreateDate(Date createDate)
	{
		this.createDate = createDate;
	}

	public Date getUpdateDate()
	{
		return updateDate;
	}

	public void setUpdateDate(Date updateDate)
	{
		this.updateDate = updateDate;
	}

	@Override
	public String toString()
	{
		return "Speciality [id=" + id + ", deptId=" + deptId + ", name=" + name + ", createDate=" + createDate
				+ ", updateDate=" + updateDate + "]";
	}

}

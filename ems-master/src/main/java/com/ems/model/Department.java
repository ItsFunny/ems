/**
 * 
 */
package com.ems.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author Administrator
 *
 */
public class Department
{
	private Integer id;
	private String name;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date createDate;
	private List<Speciality> specialities;
	public List<Speciality> getSpecialities()
	{
		return specialities;
	}

	public void setSpecialities(List<Speciality> specialities)
	{
		this.specialities = specialities;
	}

	public Date getCreateDate()
	{
		return createDate;
	}

	public void setCreateDate(Date createDate)
	{
		this.createDate = createDate;
	}

	@Override
	public String toString()
	{
		return "Department [id=" + id + ", name=" + name + "]";
	}

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

}

package com.ems.model;

public class Clazz
{
	private Integer id;
	private String name;
	private Integer specId;
	private String year;
	private Speciality speciality;
	private Department department;
	public Department getDepartment()
	{
		return department;
	}

	public void setDepartment(Department department)
	{
		this.department = department;
	}

	public Speciality getSpeciality()
	{
		return speciality;
	}

	public void setSpeciality(Speciality speciality)
	{
		this.speciality = speciality;
	}

	public String getYear()
	{
		return year;
	}

	public void setYear(String year)
	{
		this.year = year;
	}

	@Override
	public String toString()
	{
		return "Class [id=" + id + ", name=" + name + ", specId=" + specId + ", createDate=" + "]";
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

	public Integer getSpecId()
	{
		return specId;
	}

	public void setSpecId(Integer specId)
	{
		this.specId = specId;
	}

}

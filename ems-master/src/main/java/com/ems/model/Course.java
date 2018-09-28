/**
 * 
 */
package com.ems.model;

/**
 * @author Administrator
 *
 */
public class Course
{
	private Integer id;
	private String name;
	private String type;
	private Float grade;
	private Float credit;
	private Integer specId;

	@Override
	public String toString()
	{
		return "Course [id=" + id + ", name=" + name + ", type=" + type + ", grade=" + grade + ", credit=" + credit
				+ ", specId=" + specId + "]";
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

	public String getType()
	{
		return type;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	public Float getGrade()
	{
		return grade;
	}

	public void setGrade(Float grade)
	{
		this.grade = grade;
	}

	public Float getCredit()
	{
		return credit;
	}

	public void setCredit(Float credit)
	{
		this.credit = credit;
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

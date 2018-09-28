package com.ems.model;

import java.util.List;

public class CourseSection
{
	private Integer id;
	private String courseName;
	private String year;
	private Integer uid;
	private Integer limitCount;
	private Integer choosedCount=0;
	private String teacher;
	private List<TimeTable> timeTables;
	public Integer getChoosedCount()
	{
		return choosedCount;
	}

	public void setChoosedCount(Integer choosedCount)
	{
		this.choosedCount = choosedCount;
	}
	public Integer getLimitCount()
	{
		return limitCount;
	}

	public void setLimitCount(Integer limitCount)
	{
		this.limitCount = limitCount;
	}

	public List<TimeTable> getTimeTables()
	{
		return timeTables;
	}

	public void setTimeTables(List<TimeTable> timeTables)
	{
		this.timeTables = timeTables;
	}

	public String getTeacher()
	{
		return teacher;
	}

	public void setTeacher(String teacher)
	{
		this.teacher = teacher;
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}


	public String getCourseName()
	{
		return courseName;
	}

	public void setCourseName(String courseName)
	{
		this.courseName = courseName;
	}

	public String getYear()
	{
		return year;
	}

	public void setYear(String year)
	{
		this.year = year;
	}

	public Integer getUid()
	{
		return uid;
	}

	public void setUid(Integer uid)
	{
		this.uid = uid;
	}

	@Override
	public String toString()
	{
		return "CourseSection [id=" + id + ", courseName=" + courseName + ", year=" + year + ", uid=" + uid + "]";
	}

}

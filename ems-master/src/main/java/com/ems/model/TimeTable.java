package com.ems.model;

public class TimeTable
{
	private Integer id;
	private Integer sectId;
	private String time;
	private String weeks;
	private String week;
	private String classroom;
	public String getClassroom()
	{
		return classroom;
	}
	public void setClassroom(String classroom)
	{
		this.classroom = classroom;
	}
	public Integer getId()
	{
		return id;
	}
	public void setId(Integer id)
	{
		this.id = id;
	}

	public Integer getSectId()
	{
		return sectId;
	}
	public void setSectId(Integer sectId)
	{
		this.sectId = sectId;
	}
	public String getTime()
	{
		return time;
	}
	public void setTime(String time)
	{
		this.time = time;
	}
	public String getWeeks()
	{
		return weeks;
	}
	public void setWeeks(String weeks)
	{
		this.weeks = weeks;
	}
	public String getWeek()
	{
		return week;
	}
	public void setWeek(String week)
	{
		this.week = week;
	}
	@Override
	public String toString()
	{
		return "TimeTable [id=" + id + ", sectId=" + sectId + ", time=" + time + ", weeks=" + weeks + ", week=" + week
				+ ", classroom=" + classroom + "]";
	}
	
}

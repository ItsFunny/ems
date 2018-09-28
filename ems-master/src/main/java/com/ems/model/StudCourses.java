package com.ems.model;

import java.io.Serializable;

public class StudCourses implements Serializable
{


	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String studId;
	private Double score;
	
	public Integer getId()
	{
		return id;
	}
	public void setId(Integer id)
	{
		this.id = id;
	}
	public String getStudId()
	{
		return studId;
	}
	public void setStudId(String studId)
	{
		this.studId = studId;
	}
	public Double getScore()
	{
		return score;
	}
	public void setScore(Double score)
	{
		this.score = score;
	}
	public static long getSerialversionuid()
	{
		return serialVersionUID;
	}
	@Override
	public String toString()
	{
		return "StudCourses [id=" + id + ", studId=" + studId + ", score=" + score + "]";
	}
	
}


package com.ems.model;

import com.ems.abstracT.Person;

public class Student extends Person
{
	

	private Integer id;
	private String roleId;//作为登陆账号
	private String name;
	private String password;
	private Integer courId;
	private String idCard;
	private int classId;
	private String telephone;
	private String originBase;
	private String gender;
	private Float upgradeCredit;//选修的学分
	private String year;
	private Float credit;//毕业需要的专业课学分
	private Clazz clazz;
	private int deptId;
	private String pic;
	public String getRoleId()
	{
		return roleId;
	}

	public void setRoleId(String roleId)
	{
		this.roleId = roleId;
	}
	public String getPic()
	{
		return pic;
	}

	public void setPic(String pic)
	{
		this.pic = pic;
	}

	public int getDeptId()
	{
		return deptId;
	}

	public void setDeptId(int deptId)
	{
		this.deptId = deptId;
	}

	public Clazz getClazz()
	{
		return clazz;
	}

	public void setClazz(Clazz clazz)
	{
		this.clazz = clazz;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(int id)
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

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getIdCard()
	{
		return idCard;
	}

	public void setIdCard(String idCard)
	{
		this.idCard = idCard;
	}

	public int getClassId()
	{
		return classId;
	}

	public void setClassId(int classId)
	{
		this.classId = classId;
	}

	public String getYear()
	{
		return year;
	}

	public void setYear(String year)
	{
		this.year = year;
	}

	public String getTelephone()
	{
		return telephone;
	}

	public void setTelephone(String telephone)
	{
		this.telephone = telephone;
	}

	public String getGender()
	{
		return gender;
	}

	public void setGender(String gender)
	{
		this.gender = gender;
	}

	public String getOriginBase()
	{
		return originBase;
	}

	public void setOriginBase(String originBase)
	{
		this.originBase = originBase;
	}

	public Integer getCourId()
	{
		return courId;
	}

	public void setCourId(Integer courId)
	{
		this.courId = courId;
	}

	public Float getCredit()
	{
		return credit;
	}

	public void setCredit(Float credit)
	{
		this.credit = credit;
	}

	public Float getUpgradeCredit()
	{
		return upgradeCredit;
	}

	public void setUpgradeCredit(Float upgradeCredit)
	{
		this.upgradeCredit = upgradeCredit;
	}

	@Override
	public String toString()
	{
		return "Student [courId=" + courId + ", credit=" + credit + ", upgradeCredit=" + upgradeCredit + "]";
	}

}

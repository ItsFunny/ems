/**
 * 
 */
package com.ems.model;

import java.util.Date;


/**
 * @author Administrator
 *
 */
public class Section
{
	private Integer id;
	private String courTitle;
	private Integer idCard;
	private Integer count;
	private Date createDate;
	private Date updateDate;


	public Integer getIdCard()
	{
		return idCard;
	}

	public void setIdCard(Integer idCard)
	{
		this.idCard = idCard;
	}


	public String getCourTitle()
	{
		return courTitle;
	}

	public void setCourTitle(String courTitle)
	{
		this.courTitle = courTitle;
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}


	public Integer getCount()
	{
		return count;
	}

	public void setCount(Integer count)
	{
		this.count = count;
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

}

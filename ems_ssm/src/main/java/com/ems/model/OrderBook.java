package com.ems.model;

public class OrderBook
{
	private Integer id;
	private Integer stafId;
	private Integer bookId;
	private String bookTitle;
	private String message;
	private Integer status;

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public Integer getStafId()
	{
		return stafId;
	}

	public void setStafId(Integer stafId)
	{
		this.stafId = stafId;
	}

	public Integer getBookId()
	{
		return bookId;
	}

	public void setBookId(Integer bookId)
	{
		this.bookId = bookId;
	}

	public String getBookTitle()
	{
		return bookTitle;
	}

	public void setBookTitle(String bookTitle)
	{
		this.bookTitle = bookTitle;
	}

	public String getMessage()
	{
		return message;
	}

	public void setMessage(String message)
	{
		this.message = message;
	}

	public Integer getStatus()
	{
		return status;
	}

	public void setStatus(Integer status)
	{
		this.status = status;
	}

	@Override
	public String toString()
	{
		return "OrderBook [id=" + id + ", stafId=" + stafId + ", bookId=" + bookId + ", bookTitle=" + bookTitle
				+ ", message=" + message + ", status=" + status + "]";
	}

}

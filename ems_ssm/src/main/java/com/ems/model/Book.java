package com.ems.model;

import java.util.Date;


public class Book
{
	

	private Integer id;
	private Integer bookId;
	private String bookTitle;
	private String bookCode;
	private String author;
	private String press;
	private Float orignalPrice;
	private Float promotePrice;
	private Date dateOfPrinting;
	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
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

	public String getBookCode()
	{
		return bookCode;
	}

	public void setBookCode(String bookCode)
	{
		this.bookCode = bookCode;
	}

	public String getAuthor()
	{
		return author;
	}

	public void setAuthor(String author)
	{
		this.author = author;
	}

	public String getPress()
	{
		return press;
	}

	public void setPress(String press)
	{
		this.press = press;
	}

	public Float getOrignalPrice()
	{
		return orignalPrice;
	}

	public void setOrignalPrice(Float orignalPrice)
	{
		this.orignalPrice = orignalPrice;
	}

	public Float getPromotePrice()
	{
		return promotePrice;
	}

	public void setPromotePrice(Float promotePrice)
	{
		this.promotePrice = promotePrice;
	}

	public Date getDateOfPrinting()
	{
		return dateOfPrinting;
	}

	public void setDateOfPrinting(Date dateOfPrinting)
	{
		this.dateOfPrinting = dateOfPrinting;
	}

	
	@Override
	public String toString()
	{
		return "Book [id=" + id + ", bookId=" + bookId + ", bookTitle=" + bookTitle + ", bookCode=" + bookCode
				+ ", author=" + author + ", press=" + press + ", orignalPrice=" + orignalPrice + ", promotePrice="
				+ promotePrice + ", dateOfPrinting=" + dateOfPrinting + "]";
	}

}

package com.ems.model;

public class Term
{
	String val;
	String text;

	public String getVal()
	{
		return val;
	}

	public void setVal(String val)
	{
		this.val = val;
	}

	public String getText()
	{
		return text;
	}

	public void setText(String text)
	{
		this.text = text;
	}

	@Override
	public String toString()
	{
		return "Term [val=" + val + ", text=" + text + "]";
	}
	
}

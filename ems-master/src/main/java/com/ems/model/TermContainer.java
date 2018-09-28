package com.ems.model;

import java.time.LocalDate;
import java.util.*;

import org.springframework.stereotype.Component;

/**
 * Created by c0de8ug on 16-2-15.
 */
@Component
public class TermContainer
{
	static List<Term> termList;
	static LocalDate beginTime;
	static HashMap<String, String> map = new HashMap<>();
	final static String lastTermStr = "上学期";
	final static String nextTermStr = "下学期";

	String lastSemester = "2,3,4,5,6,7,8";
	String nextSemester = "1,9,10,11,12";

	public TermContainer()
	{

		for (String temp : lastSemester.split(","))
		{
			map.put(temp, lastTermStr);
		}
		for (String temp : nextSemester.split(","))
		{
			map.put(temp, nextTermStr);
		}
		// 先将所有的信息都放在map里:月份-对应的学期(上/下)
		beginTime = LocalDate.of(2014, 1, 1);
		update();
	}

	public static void update()
	{
		termList = new ArrayList<>();

		LocalDate today = LocalDate.now();

		int beginYear = beginTime.getYear();
		int todayYear = today.getYear();
		int count = todayYear - beginYear;

		// 判断这个月份是否属于下学期的月份
		if (map.get(String.valueOf(today.getMonthValue())).equals(nextTermStr))
		{
			Term term = new Term();
			term.setVal(todayYear + "2");
			term.setText(todayYear + nextTermStr);
			termList.add(term);
		}
		// 不然的话就是上学期

		Term term = new Term();
		term.setVal(todayYear + "1");
		term.setText(todayYear + lastTermStr);
		termList.add(term);
		//50-63行代码是将当前年份的上下学期写入到list这种
		//之后将当前年份到14年份的上下学期也写入到list中
		for (int i = 0; i < count; i++)
		{
			// 因为有上下两个学期,所以执行了2遍
			todayYear--;
			term = new Term();
			term.setVal(todayYear + "2");
			term.setText(todayYear + nextTermStr);
			termList.add(term);
			term = new Term();
			term.setVal(todayYear + "1");
			term.setText(todayYear + lastTermStr);
			termList.add(term);

		}

	}

	public static String now()
	{
		return termList.get(0).getVal();
	}

	public static List<Term> getTermList()
	{
		return termList;
	}

	@Override
	public String toString()
	{
		return "TermContainer [lastSemester=" + lastSemester + ", nextSemester=" + nextSemester + "]";
	}

}

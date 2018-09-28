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
	static HashMap<String, String> map = new HashMap<String, String>();
	final static String lastTermStr = "涓婂鏈�";
	final static String nextTermStr = "涓嬪鏈�";

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
		// 鍏堝皢鎵�鏈夌殑淇℃伅閮芥斁鍦╩ap閲�:鏈堜唤-瀵瑰簲鐨勫鏈�(涓�/涓�)
		beginTime = LocalDate.of(2014, 1, 1);
		update();
	}

	public static void update()
	{
		termList = new ArrayList<Term>();

		LocalDate today = LocalDate.now();

		int beginYear = beginTime.getYear();
		int todayYear = today.getYear();
		int count = todayYear - beginYear;

		// 鍒ゆ柇杩欎釜鏈堜唤鏄惁灞炰簬涓嬪鏈熺殑鏈堜唤
		if (map.get(String.valueOf(today.getMonthValue())).equals(nextTermStr))
		{
			Term term = new Term();
			term.setVal(todayYear + "2");
			term.setText(todayYear + nextTermStr);
			termList.add(term);
		}
		// 涓嶇劧鐨勮瘽灏辨槸涓婂鏈�

		Term term = new Term();
		term.setVal(todayYear + "1");
		term.setText(todayYear + lastTermStr);
		termList.add(term);
		//50-63琛屼唬鐮佹槸灏嗗綋鍓嶅勾浠界殑涓婁笅瀛︽湡鍐欏叆鍒發ist杩欑
		//涔嬪悗灏嗗綋鍓嶅勾浠藉埌14骞翠唤鐨勪笂涓嬪鏈熶篃鍐欏叆鍒發ist涓�
		for (int i = 0; i < count; i++)
		{
			// 鍥犱负鏈変笂涓嬩袱涓鏈�,鎵�浠ユ墽琛屼簡2閬�
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

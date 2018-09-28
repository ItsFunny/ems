package com.ems.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.dao.SectionDao;
import com.ems.model.Section;
import com.ems.service.SectionService;

@Service
public class SectionServiceImpl implements SectionService
{
	
	@Autowired
	SectionDao sectionDao;
	
	@Override
	public List<Section> getAll()
	{
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void createSection()
	{
		Section section=new Section();
		section.setId(null);
		if(section.getCreateDate()==null)
		{
			section.setCreateDate(new Date(System.currentTimeMillis()));
		}
		section.setUpdateDate(section.getCreateDate());
		sectionDao.add(section);
	}



	@Override
	public List<Section> getSectionsByIdCard(String idCard)
	{
		
		return sectionDao.getSectionsByIdCard(idCard);
	}

}

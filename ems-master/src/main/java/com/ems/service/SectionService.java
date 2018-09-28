package com.ems.service;

import java.util.List;

import com.ems.model.Section;

public interface SectionService
{
	public List<Section> getAll();
	
	List<Section>getSectionsByIdCard(String string);
	
	public void createSection();
}

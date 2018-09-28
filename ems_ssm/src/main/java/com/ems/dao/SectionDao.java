package com.ems.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ems.model.Section;

@Mapper
public interface SectionDao
{
	@Select("select * from section")
	List<Section> getAll();
	
	//通过这个老师获取他添加的课程
	@Select("select * from section where idCard=#{idCard}")
	List<Section>getSectionsByIdCard(String idCard);
	
	@Insert("insert into section (courId,stafId,count,createDate,updateDate) values (#{courId},#{stafId},#{count},#{createDate},#{updateDate})")
	void add(Section section);
	

	
	
}

package com.ems.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ems.model.Student;

@Mapper
public interface StudentDao
{

	@Insert("insert into student (name,password,idCard,gender,telephone,classId,year,originBase,pic,createDate,updateDate,credit,upgradeCredit) values (#{name},#{password},#{idCard},#{gender},#{telephone},#{classId},#{year},#{originBase},#{pic},#{createDate},#{updateDate},#{credit},#{upgradeCredit})")
	void add(Student student);

	@Select("select * from student")
	List<Student> getAll();

	@Select("select * from student where id=#{id}")
	Student getStudentById(int id);

	@Update("update student set password=#{password},updateDate=#{updateDate} where id=#{id}")
	void updateStudById(@Param("password") String password, @Param("updateDate") Date date, @Param("id") int id);

	@Update("update student set name=#{name},classId=#{classId},idCard=#{idCard},gender=#{gender},year=#{year},originBase=#{originBase},pic=#{pic} where id=#{id}")
	void updateStudentById(Student student);

	// 根据系部查询学生
	@Select("select * from student where deptId=#{deptId}")
	List<Student> getStudentsByDeptId(int deptId);

	@Delete("delete from student where id=#{studId}")
	void deleteStudentById(Integer studId);

}

package com.eec.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.eec.entity.Student;

@Repository
public interface StudentDao {

	// 获取所有的学生对象
	public List<Student> getAll();
	
	//删除编号为stuid的学生
	public int deleteStu(int stuid);
	
	//插入一条用户信息
	public int insertStu(Student student);
	
	//根据stuid查询到学生信息
	public Student getStuById(int stuid);
	
	//根据学生对象修改学生信息
	public int updateStuByObject(Student student);
}

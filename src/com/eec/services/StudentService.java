package com.eec.services;

import java.util.List;

import com.eec.entity.Student;

public interface StudentService {

	// 获取所有学生信息
	public List<Student> getAllStu();
	
	//删除用户信息
	public boolean deleteStu(int stuid);
	
	//插入一条用户信息
	public boolean insertStu(Student student);
	
	//根据id查询到学生信息
	public Student getStuById(int stuid);
	
	//根据学生对象修改学生信息
	public boolean updateStu(Student student);

}

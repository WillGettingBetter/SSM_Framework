package com.eec.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eec.dao.StudentDao;
import com.eec.entity.Student;
import com.eec.services.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentDao studentDao;

	@Override
	public List<Student> getAllStu() {
		List<Student> list = studentDao.getAll();
		return list;
	}

	@Override
	public boolean deleteStu(int stuid) {
		int row = studentDao.deleteStu(stuid);
		return row == 1 ? true : false;
	}

	@Override
	public boolean insertStu(Student student) {
		int row = studentDao.insertStu(student);
		return row == 1 ? true : false;
	}

	@Override
	public Student getStuById(int stuid) {
		Student stu = studentDao.getStuById(stuid);
		return stu == null ? null : stu;
	}

	@Override
	public boolean updateStu(Student student) {
		int row = studentDao.updateStuByObject(student);
		return row == 1 ? true : false;
	}

}

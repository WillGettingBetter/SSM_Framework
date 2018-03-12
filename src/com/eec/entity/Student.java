package com.eec.entity;

import java.util.Date;

public class Student {

	private int stuid;
	private String stuname;
	private int stuage;
	private Date stubirth;

	public Student() {
		super();
	}

	public Student(int stuid, String stuname, int stuage, Date stubirth) {
		super();
		this.stuid = stuid;
		this.stuname = stuname;
		this.stuage = stuage;
		this.stubirth = stubirth;
	}

	public int getStuid() {
		return stuid;
	}

	public void setStuid(int stuid) {
		this.stuid = stuid;
	}

	public String getStuname() {
		return stuname;
	}

	public void setStuname(String stuname) {
		this.stuname = stuname;
	}

	public int getStuage() {
		return stuage;
	}

	public void setStuage(int stuage) {
		this.stuage = stuage;
	}

	public Date getStubirth() {
		return stubirth;
	}

	public void setStubirth(Date stubirth) {
		this.stubirth = stubirth;
	}

}

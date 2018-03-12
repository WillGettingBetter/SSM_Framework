package com.eec.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.eec.entity.Student;
import com.eec.services.StudentService;

@Controller
public class StudentAction {

	@Autowired
	private StudentService studentService;

	@RequestMapping("/getStudent.action")
	public ModelAndView getAllStudent(HttpServletRequest request,
			HttpServletResponse response) {
		// 从业务层获取所有用户信息
		List<Student> stuList = studentService.getAllStu();
		request.setAttribute("stuList", stuList);
		ModelAndView model = new ModelAndView();
		model.setViewName("index.jsp");
		return model;
	}

	@RequestMapping("/deleteStu.action")
	public void deleteStu(HttpServletRequest request,
			HttpServletResponse response, int stuid) {
		response.setCharacterEncoding("text/html;charset=utf-8");
		// 从业务层删除用户信息
		boolean bool = studentService.deleteStu(stuid);
		if (bool) {
			try {
				request.getRequestDispatcher("/getStudent.action").forward(
						request, response);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
			/* return "forward:getStudent.action"; 一种转发方式 */
		} else {
			PrintWriter out = null;
			try {
				out = response.getWriter();
			} catch (IOException e) {
				e.printStackTrace();
			}
			out.write("删除失败了");
			out.flush();
			out.close();
		}
	}

	@RequestMapping("/insertStu.action")
	public String insertStu(HttpServletRequest request,
			HttpServletResponse response) {
		// 设置页面编码格式
		response.setCharacterEncoding("text/html;charset=utf-8");
		String stuname = request.getParameter("stuname");
		int stuage = Integer.parseInt(request.getParameter("stuage"));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Student stu = null;
		try {
			stu = new Student(0, stuname, stuage, sdf.parse(request
					.getParameter("stubirth")));
		} catch (ParseException e1) {
			e1.printStackTrace();
			stu = null;
			return "redirect:insertStu.jsp";
		}
		// 去业务层插入一条用户信息
		boolean bool = studentService.insertStu(stu);
		if (bool) {
			return "forward:getStudent.action";
		} else {
			return "redirect:insertStu.jsp";
		}
	}

	@RequestMapping("/updateStu.action")
	public String updateStu(HttpServletRequest request,
			HttpServletResponse response, int stuid) {
		// 去业务层根据stuid查询到学生的信息
		Student stu = studentService.getStuById(stuid);
		if (stu != null) {
			request.setAttribute("stuInfo", stu);
			return "forward:updateStu.jsp";
		} else {
			return "redirect:getStudent.action";
		}
	}

	@RequestMapping("/doUpdateStu.action")
	public String doUpdateStu(HttpServletRequest request,
			HttpServletResponse response) {
		// 获取jsp页面传来的参数
		int stuid = Integer.parseInt(request.getParameter("stuid"));
		String stuname = request.getParameter("stuname");
		int stuage = Integer.parseInt(request.getParameter("stuage"));
		// 格式化日期
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		// 生成Student对象
		Student stu = null;
		try {
			stu = new Student(stuid, stuname, stuage, sdf.parse(request
					.getParameter("stubirth")));
		} catch (ParseException e1) {
			e1.printStackTrace();
			stu = null;
			return "redirect:updateStu.action?stuid=" + stuid + "";
		}
		// 进入业务层，更改学生信息
		boolean bool = studentService.updateStu(stu);
		if (bool) {
			return "redirect:getStudent.action";
		} else {
			return "redirect:updateStu.action?stuid=" + stuid + "";
		}
	}

}

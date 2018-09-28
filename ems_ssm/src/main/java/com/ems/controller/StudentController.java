package com.ems.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ems.model.Student;
import com.ems.service.AdminService;
import com.ems.service.StudentService;
import com.ems.service.TeacherService;
import com.ems.service.UserService;

@RestController
@RequestMapping("student")
public class StudentController
{
	@Autowired
	private StudentService studentService;
	@Autowired
	TeacherService teacherService;
	
	@Autowired
	AdminService adminService;
	@Autowired
	UserService userService;
	@RequestMapping("/index")
	public ModelAndView index(HttpServletRequest request,HttpServletResponse response)
	{
		ModelAndView modelAndView=new ModelAndView("studMain");
		return modelAndView;
	}
	@RequestMapping("/profile")
	public ModelAndView profile(HttpServletRequest request,HttpServletResponse response)
	{
		ModelAndView modelAndView=new ModelAndView("profile");
		return modelAndView;
	}
	@RequestMapping("chanPawd")
	public ModelAndView chanPawd(HttpServletRequest request,HttpServletResponse response)
	{
		ModelAndView modelAndView=null;
		Map<String, Object>params=new HashMap<String, Object>();
		HttpSession httpSession=request.getSession(true);
		Student student=(Student) httpSession.getAttribute("person");
		if(student==null)
		{
			return new ModelAndView("login");
		}
		String password=request.getParameter("password");
		System.out.println(password);
		studentService.updateStudById(password,student.getId());
		params.put("error", "修改成功");
		modelAndView=new ModelAndView("studMain",params);
		return modelAndView;
	}
	@RequestMapping("myCourses")
	public ModelAndView myCourses(HttpServletRequest request,HttpServletResponse response)
	{
		
//		ModelAndView modelAndView=new ModelAndView("")
		return null;
	}
}

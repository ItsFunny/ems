package com.ems.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ems.model.CourseSection;
import com.ems.model.Student;
import com.ems.model.Teacher;
import com.ems.model.User;
import com.ems.service.AdminService;
import com.ems.service.CourseSectionService;
import com.ems.service.StudCoursesService;
import com.ems.service.StudentService;
import com.ems.service.TeacherService;
import com.ems.service.UserService;
import com.ems.util.JokerUtils;


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
	@Autowired
	CourseSectionService courseSectionService;
	
	
	
	
	@Autowired
	JokerUtils jokerUtils;
	
	@Autowired
	StudCoursesService studCoursesService;
	
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
	//选课
	@RequestMapping("chooseCourse")
	public ModelAndView chooseCourse(HttpServletRequest request,HttpServletResponse response)
	{
		Map<String, Object>params=new HashMap<>();
		List<CourseSection> courseSectionLists = courseSectionService.getAll();
		for (CourseSection courseSection : courseSectionLists)
		{
			User user = userService.getUserById(courseSection.getUid());
			courseSection.setTeacher(user.getName());
		}
		params.put("courseSectionLists", courseSectionLists);
		params.put("permissionLists", jokerUtils.getLoginUserPermissions());
		ModelAndView modelAndView=new ModelAndView("stud_elective",params);
		return modelAndView;
	}
	@RequestMapping("chooseCourse.do/{id}/{choosedCount}")
	public ModelAndView doChooseCourse(@PathVariable("id")Integer id,@PathVariable("choosedCount")Integer choosedCount,HttpServletResponse response)
	{
		Map<String, Object>params=new HashMap<>();
		User user = jokerUtils.getLoginUser();
		Student student = studentService.getStudentByRoleId(user.getRoleId());
		//在add方法里可以添加判断,人数是否超过最大人数以及是否已经选过了
		studCoursesService.addStudCourse(Integer.parseInt(student.getRoleId()),id);
		courseSectionService.update(++choosedCount, id);
		params.put("permissionLists", jokerUtils.getLoginUserPermissions());
		params.put("error", "选课成功,请前往我的课表查询");
		ModelAndView modelAndView=new ModelAndView("/student/chooseCourse",params);
		return  modelAndView;		
	}
	@RequestMapping("myCourses")
	public ModelAndView myCourses(HttpServletRequest request,HttpServletResponse response)
	{
		
		return null;
	}
}

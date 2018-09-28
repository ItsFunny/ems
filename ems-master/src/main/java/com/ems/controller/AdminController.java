package com.ems.controller;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ems.dao.AuthorityDao;
import com.ems.model.Authority;
import com.ems.model.Clazz;
import com.ems.model.Course;
import com.ems.model.CourseSection;
import com.ems.model.Department;
import com.ems.model.Speciality;
import com.ems.model.Student;
import com.ems.model.Term;
import com.ems.model.TermContainer;
import com.ems.model.TimeTable;
import com.ems.model.User;
import com.ems.service.AuthorityService;
import com.ems.service.ClazzService;
import com.ems.service.CourseSectionService;
import com.ems.service.CourseService;
import com.ems.service.DepartmentService;
import com.ems.service.SpeciailtyService;
import com.ems.service.StudentService;
import com.ems.service.SysPermissionService;
import com.ems.service.TeacherService;
import com.ems.service.TimeTableService;
import com.ems.service.UserService;
import com.ems.util.JokerUtils;



@RestController
@RequestMapping("/admin")
@RequiresRoles("admin")
public class AdminController
{
	private static final Logger logger=LoggerFactory.getLogger(AdminController.class);
	@Autowired
	DepartmentService departmentService;
	@Autowired
	SpeciailtyService speciailtyService;
	@Autowired
	ClazzService clazzService;
	@Autowired
	CourseService courseService;
	@Autowired
	StudentService studentService;
	@Autowired
	UserService	userService;
	@Autowired
	AuthorityService authorityService;
	@Autowired
	CourseSectionService courserSectionService;
	@Autowired
	TimeTableService timeTableService;
	@Autowired
	SysPermissionService sysPermissionService;
	
	@Autowired
	TeacherService teacherService;
//	@Autowired
//	TermContainer termContainer;
	@Autowired
	JokerUtils jokerUtils;
	@RequestMapping("/index")
	public ModelAndView index()
	{
		return new ModelAndView("adminMain");
	}
	@RequiresPermissions("admin:editDepart")
	@RequestMapping("/editDepart")
	public ModelAndView editDepart(HttpServletRequest request,HttpServletResponse response,Model model)
	{
		Map<String, Object>params=new HashMap<>();
		List<Department>departmentLists=departmentService.getAll();
		params.put("departmentLists", departmentLists);

		params.put("permissionLists", jokerUtils.getLoginUserPermissions());
		ModelAndView modelAndView=new ModelAndView("dept",params);
		return modelAndView;
	}
	@RequestMapping("addDepart")
	public ModelAndView addDepart(HttpServletRequest request,HttpServletResponse response)
	{
		Map<String, Object>params=new HashMap<>();
		params.put("permissionLists", jokerUtils.getLoginUserPermissions());
		ModelAndView modelAndView=new ModelAndView("dept_add",params);
		return modelAndView;
	}
	@RequestMapping("/addDepart.do")
	public ModelAndView doAddDepart(HttpServletRequest request,HttpServletResponse response)
	{
		Map<String, Object>params=new HashMap<>();
		String deptName=request.getParameter("deptName");
		System.out.println(deptName);
		Department department=new Department();
		departmentService.add(department,deptName);
		params.put("permissionLists", jokerUtils.getLoginUserPermissions());
		params.put("errpr", "添加成功");
		ModelAndView modelAndView=new ModelAndView("redirect:/admin/editDepart",params);
		return modelAndView;
	}
	@RequestMapping("updateDepart")
	public ModelAndView updateDepart(HttpServletRequest request,HttpServletResponse response)
	{
		int deptId=Integer.parseInt(request.getParameter("deptId").toString());
		String deptName=request.getParameter("deptName");
		Map<String, Object>params=new HashMap<>();
		params.put("permissionLists", jokerUtils.getLoginUserPermissions());
		params.put("name", deptName);
		params.put("deptId",deptId);
		params.put("deptName", deptName);
		ModelAndView modelAndView=new ModelAndView("dept_update",params);
		return modelAndView;
	}
	@RequestMapping("updateDepart.do")
	public ModelAndView doUpdateDepart(@RequestParam Map<String, Object>params,HttpServletRequest request,HttpServletResponse response,Model model)
	{
		String oldName=request.getParameter("deptName");
		User user = jokerUtils.getLoginUser();
		int deptId=Integer.parseInt(request.getParameter("deptId").toString());
		String newName=request.getParameter("newName");
		departmentService.update(newName,deptId);
		logger.info("用户:"+user.getName()+"于"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(System.currentTimeMillis()))+"将原系名:"+oldName+",改为了:"+newName);
		params.put("error", "更新成功");
		params.put("permissionLists", jokerUtils.getLoginUserPermissions());
		model.addAttribute("error","更新成功");
		return new ModelAndView("redirect:/admin/editDepart");
	}
	@RequestMapping("deleteDepart")
	public ModelAndView deleteDepart(HttpServletRequest request,HttpServletResponse response)
	{
		int id=Integer.parseInt(request.getParameter("deptId").toString());
		departmentService.delete(id);
		return new ModelAndView("redirect:/admin/editDepart");
	}
	@RequestMapping("/editSpec")
	@RequiresPermissions("admin:editSpec")
	public ModelAndView editSpec(HttpServletRequest request,HttpServletResponse response)
	{
		List<Department>departmentLists=departmentService.getAll();
		List<Speciality>specialityLists=speciailtyService.getAll();

		Map<String, Object>params=new HashMap<>();
		params.put("permissionLists", jokerUtils.getLoginUserPermissions());
		params.put("departmentLists", departmentLists);
		params.put("specialityLists", specialityLists);
		ModelAndView modelAndView=new ModelAndView("spec",params);
		return modelAndView;
	}
	@RequestMapping("addSpec")
	public ModelAndView addSpec(HttpServletRequest request,HttpServletResponse response)
	{
		List<Department>departmentLists=departmentService.getAll();
		Map<String, Object>params=new HashMap<>();
		params.put("departmentLists", departmentLists);
		params.put("permissionLists", jokerUtils.getLoginUserPermissions());
		ModelAndView modelAndView=new ModelAndView("spec_add",params);
		return modelAndView;
	}
	@RequestMapping("addSpec.do")
	public ModelAndView doAddSpec(HttpServletRequest request,HttpServletResponse response)
	{
		String deptName=request.getParameter("deptName");
		Department department=departmentService.findByName(deptName);
		int deptId=department.getId();
		String specName=request.getParameter("specName");
		speciailtyService.add(new Speciality(), specName, deptId);
		Map<String,Object>params=new HashMap<>();
		params.put("permissionLists", jokerUtils.getLoginUserPermissions());
		ModelAndView modelAndView=new ModelAndView("redirect:/admin/editSpec",params);
		return modelAndView;
	}
	@RequestMapping("updateSpec")
	public ModelAndView updateSpec(HttpServletRequest request,HttpServletResponse response)
	{
		Map<String, Object>params=new HashMap<>();
		String specName=request.getParameter("specName");
		int specId=Integer.parseInt(request.getParameter("specId").toString());
		params.put("permissionLists", jokerUtils.getLoginUserPermissions());
		params.put("specName", specName);
		params.put("specId", specId);
		params.put("name", specName);
		ModelAndView modelAndView=new ModelAndView("spec_update",params);
		return modelAndView;
	}
	@RequestMapping("updateSpec.do")
	public ModelAndView doUpdateSpec(@RequestParam Map<String, Object>params,HttpServletRequest request,HttpServletResponse response)
	{
		int specId=Integer.parseInt(params.get("specId").toString());
		String newName=request.getParameter("newName");
		speciailtyService.updateById(newName, specId);
		params.put("permissionLists", jokerUtils.getLoginUserPermissions());
		ModelAndView modelAndView=new ModelAndView("redirect:/admin/editSpec",params);
		return modelAndView;
	}
	@RequestMapping("deleteSpec")
	public ModelAndView deleteSpec(HttpServletRequest request,HttpServletResponse response)
	{
		int id=Integer.parseInt(request.getParameter("specId").toString());
		speciailtyService.deleteById(id);
		ModelAndView modelAndView=new ModelAndView("redirect:/admin/editSpec");
		return modelAndView;
	}
	@RequiresPermissions("admin:editClass")
	@RequestMapping("editClass")
	public ModelAndView editClass(HttpServletRequest request,HttpServletResponse response)
	{
		List<Clazz>clazzLists=clazzService.getAll();
		List<Department>departmentLists=departmentService.getAll();
		for (Clazz clazz : clazzLists)
		{
			int specId=clazz.getSpecId();
			Speciality speciality=speciailtyService.findById(specId);
			Department department=departmentService.findById(speciality.getDeptId());
			clazz.setSpeciality(speciality);
			clazz.setDepartment(department);
		}
		Map<String, Object>params=new HashMap<>();
		params.put("permissionLists", jokerUtils.getLoginUserPermissions());
		params.put("clazzLists", clazzLists);
		params.put("departmentLists", departmentLists);
		ModelAndView modelAndView=new ModelAndView("class",params);
		return modelAndView;
	}
	@RequestMapping("deleteClass")
	public ModelAndView deleteClass(HttpServletRequest request,HttpServletResponse response)
	{
		Map<String, Object>params=new HashMap<>();
		int classId=Integer.parseInt(request.getParameter("classId").toString());
		clazzService.deleteById(classId);
		ModelAndView modelAndView=new ModelAndView("redirect:/admin/editSpec",params);
		return modelAndView;
	}
	@RequestMapping("addClass")
	public ModelAndView addClass(HttpServletRequest request,HttpServletResponse response)
	{
		int deptId=Integer.parseInt(request.getParameter("deptId").toString());
		Department department=departmentService.findById(deptId);
		String deptName=department.getName();
		List<Speciality>specialityLists=speciailtyService.findSpecialitiesByDeptId(deptId);
		List<Term>termLists=TermContainer.getTermList();
		
		Map<String, Object>params=new HashMap<>();
		params.put("permissionLists", jokerUtils.getLoginUserPermissions());
		params.put("deptName", deptName);
		params.put("specialityLists", specialityLists);
		params.put("termList",termLists );
		ModelAndView modelAndView=new ModelAndView("clazz_add",params);
		return modelAndView;
	}
	@RequestMapping("addClass.do")
	public ModelAndView doAddClass(HttpServletRequest request,HttpServletResponse response)
	{
		
		String specName=request.getParameter("specName");
		String year=request.getParameter("year");
		String className=request.getParameter("className");
		Speciality speciality=speciailtyService.findByName(specName);
		clazzService.add(className, speciality.getId(), year);
		ModelAndView modelAndView=new ModelAndView("redirect:/admin/editClass");
		return modelAndView;
	}
	@RequiresPermissions("admin:editCourse")
	@RequestMapping("courseDept")
	public ModelAndView editCourse(HttpServletRequest request,HttpServletResponse response)
	{
		List<Department>departmentLists=departmentService.getAll();
		Map<String, Object>params=new HashMap<>();
		params.put("departmentLists", departmentLists);
		params.put("permissionLists", jokerUtils.getLoginUserPermissions());
		ModelAndView modelAndView=new ModelAndView("course_dept",params);
		return modelAndView;
	}
	@RequestMapping("/courseDept/courseDeptSpec")
	public ModelAndView courseSpec(HttpServletRequest request,HttpServletResponse response)
	{
		int deptId=Integer.parseInt(request.getParameter("deptId").toString());
		List<Speciality>specialityLists=speciailtyService.findSpecialitiesByDeptId(deptId);
		Map<String, Object>params=new HashMap<>();
		params.put("permissionLists", jokerUtils.getLoginUserPermissions());
		params.put("specialityLists", specialityLists);
		ModelAndView modelAndView=new ModelAndView("course_dept_spec",params);
		return modelAndView;
	}
	
	@RequestMapping("/courseDept/courseDeptSpec/showCourses")
	public ModelAndView showCourse(HttpServletRequest request,HttpServletResponse response)
	{
		int specId=Integer.parseInt(request.getParameter("specId").toString());
		Speciality speciality=speciailtyService.findById(specId);
		List<Course>courseLists=courseService.getCourseListsBySpecId(specId);
		Map<String, Object>params=new HashMap<>();
		params.put("permissionLists", jokerUtils.getLoginUserPermissions());
		params.put("specId", specId);
		params.put("courseLists",courseLists);
		params.put("specName", speciality.getName());
		ModelAndView modelAndView=new ModelAndView("course",params);
		return modelAndView;
	}
	@RequestMapping("addCourse")
	public ModelAndView addCourse(HttpServletRequest request,HttpServletResponse response)
	{
		int specId=Integer.parseInt(request.getParameter("specId").toString());
		Speciality speciality=speciailtyService.findById(specId);
		Map<String, Object>params=new HashMap<>();
		params.put("permissionLists", jokerUtils.getLoginUserPermissions());
		params.put("specName", speciality.getName());
		
		params.put("specId", specId);
		ModelAndView modelAndView=new ModelAndView("course_add",params);
		return modelAndView;
	}
	@RequestMapping("addCourse.do")
	public ModelAndView doAddCourse(HttpServletRequest request,HttpServletResponse response)
	{
		int specId=Integer.parseInt(request.getParameter("specId").toString());
		String courseName=request.getParameter("courseName");
		String type=request.getParameter("type");
		float credit=Float.parseFloat(request.getParameter("credit").toString());
		courseService.add(courseName, type, credit, specId);
		ModelAndView modelAndView=new ModelAndView("redirect:/admin/courseDept");
		return modelAndView;
	}
	@RequestMapping("courseDept/courseDeptSpec/deleteCourse")
	public ModelAndView deleteCourse(HttpServletRequest request,HttpServletResponse response)
	{
		int courId=Integer.parseInt(request.getParameter("courId").toString());
		courseService.deleteById(courId);
		ModelAndView modelAndView=new ModelAndView("redirect:/admin/courseDept");
		return modelAndView;
	}
	@RequestMapping("editStudent")
	public ModelAndView editStudent(HttpServletRequest request,HttpServletResponse response)
	{
		List<Student>studentLists=studentService.getAll();
		for (Student student : studentLists)
		{
			student.setClazz(clazzService.getClazzById(student.getClassId()));
		}
		Map<String, Object>params=new HashMap<>();
		params.put("permissionLists", jokerUtils.getLoginUserPermissions());
		params.put("studentLists", studentLists);
		ModelAndView modelAndView=new ModelAndView("student",params);
		return modelAndView;
	}

	@RequestMapping("updateStudent")
	public ModelAndView updateStudent(HttpServletRequest request,HttpServletResponse response)
	{
		int studId=Integer.parseInt(request.getParameter("studId").toString());
		Student student=studentService.getStudentByRoleId(studId);
		student.setClazz(clazzService.getClazzById(student.getClassId()));
		Map<String, Object>params=new HashMap<>();
		params.put("permissionLists", jokerUtils.getLoginUserPermissions());
		params.put("studId", studId);
		params.put("student", student);
		ModelAndView modelAndView=new ModelAndView("student_update",params);
		return modelAndView;
	}
	@RequestMapping("updateStudent.do")
	public ModelAndView doUpdateStudent(@RequestParam("pic")MultipartFile pic,Student student,HttpServletRequest request,HttpServletResponse response) throws IllegalStateException, IOException 
	{
		String ext=FilenameUtils.getExtension(pic.getOriginalFilename());
		String picString=student.getIdCard().toString()+student+student.getClazz()+"."+ext;
		pic.transferTo(new File("E:\\list\\"+picString));
		student.setPic(picString);
		String className=request.getParameter("className");
		Clazz clazz=clazzService.getClazzByName(className);
		student.setClassId(clazz.getId());
		studentService.updateStudentById(student);
		ModelAndView modelAndView=new ModelAndView("redirect:editStudent");
		return modelAndView;
	}
	@RequestMapping("addStudent")
	public ModelAndView addStudent(HttpServletRequest request,HttpServletResponse response)
	{
		Map<String, Object>params=new HashMap<>();
		params.put("permissionLists", jokerUtils.getLoginUserPermissions());
		ModelAndView modelAndView=new ModelAndView("student_add",params);
		return modelAndView;
	}
	@RequestMapping("addStudent.do")
	public ModelAndView DoAddStudent(Student student,HttpServletRequest request,HttpServletResponse response)
	{
		String className=request.getParameter("className");
		Clazz clazz = clazzService.getClazzByName(className);
		student.setClassId(clazz.getId());
		studentService.add(student);
		ModelAndView modelAndView=new ModelAndView("redirect:/admin/editStudent");
		return modelAndView;
	}
	@RequestMapping("deleteStudent/{studId}")
	public ModelAndView deleteStudent(@PathVariable Integer studId,HttpServletRequest request,HttpServletResponse response)
	{
		Map<String, Object>params=new HashMap<>();
		params.put("permissionLists", jokerUtils.getLoginUserPermissions());
		studentService.deleteStudentById(studId);
		ModelAndView modelAndView=new ModelAndView("redirect:/admin/editStudent",params);
		modelAndView.addObject("error","成功删除学生");
		return modelAndView;
	}
	@Autowired
	AuthorityDao authorityDao;
	@RequestMapping("editAuthority")
	public ModelAndView editAuthority(HttpServletRequest request,HttpServletResponse response)
	{
		List<Authority> authorityLists=authorityDao.getAll();
		for (Authority authority : authorityLists)
		{
			List<User> userLists = userService.getUsersByAuthId(authority.getId());
			authority.setUsers(userLists);
		}
		Map<String, Object>params=new HashMap<>();
		params.put("permissionLists", jokerUtils.getLoginUserPermissions());
		params.put("authorityLists", authorityLists);
		ModelAndView modelAndView=new ModelAndView("authority",params);
		return modelAndView;
	}
	@RequestMapping("addAuth")
	public ModelAndView addAuth(HttpServletRequest request,HttpServletResponse response)
	{
		Map<String, Object>params=new HashMap<>();
		params.put("permissionLists", jokerUtils.getLoginUserPermissions());
		ModelAndView modelAndView=new ModelAndView("authority_add",params);
		return modelAndView;
	}
	@RequestMapping("editUser")
	public ModelAndView editUser(HttpServletRequest request,HttpServletResponse response)
	{
		List<User> userLists=userService.getAll();
		Map<String, Object>params=new HashMap<>();
		params.put("permissionLists", jokerUtils.getLoginUserPermissions());
		params.put("userLists", userLists);
		ModelAndView modelAndView=new ModelAndView("user",params);
		return modelAndView;
	}
	@RequestMapping("updateUser/{userId}")
	public ModelAndView updateUser(@PathVariable(value="userId" ,required=true)Integer userId,HttpServletRequest request,HttpServletResponse response)
	{
		User user = userService.getUserById(userId);
		List<Authority> authorityLists=authorityService.getAll();
		Map<String,Object>params=new HashMap<>();
		params.put("permissionLists", jokerUtils.getLoginUserPermissions());
		params.put("user", user);
		params.put("authorityLists", authorityLists);
		ModelAndView modelAndView=new ModelAndView("user_update",params);
		return modelAndView;
	}
//	@RequestMapping("updateStudent.do")
//	public ModelAndView doUpdateStudent(HttpServletRequest request,HttpServletResponse response)
//	{
//		String newPassword=request.getParameter("newPassword");
//		ModelAndView modelAndView=new ModelAndView("redirect:/admin/editUser");
//		return modelAndView;
//	}
	@RequestMapping("addUser")
	public ModelAndView addUser(HttpServletRequest request,HttpServletResponse response)
	{
		Map<String, Object>params=new HashMap<>();
		List<Authority>authorityLists=authorityService.getAll();
		params.put("permissionLists", jokerUtils.getLoginUserPermissions());
		params.put("authorityLists",authorityLists);
		ModelAndView modelAndView=new ModelAndView("user_add",params);
		return modelAndView;
	}
	@RequiresPermissions("admin:editSection")
	@RequestMapping("editSection")
	public ModelAndView editSection(HttpServletRequest request,HttpServletResponse response)
	{
		Map<String, Object>params=new HashMap<>();
		List<CourseSection> courseSectionLists = courserSectionService.getAll();
		List<TimeTable> timeTableLists = timeTableService.getAll();
		for (CourseSection courseSection : courseSectionLists)
		{
			User user = userService.getUserById(courseSection.getUid());
			courseSection.setTeacher(user.getName());
		}
		params.put("permissionLists", jokerUtils.getLoginUserPermissions());
		params.put("courseSectionLists", courseSectionLists);
		params.put("timeTableLists", timeTableLists);
		ModelAndView modelAndView=new ModelAndView("section",params);
		return modelAndView;
	}
	@RequestMapping("addSection")
	public ModelAndView addSection(HttpServletRequest request,HttpServletResponse response)
	{
		List<Course> courseLists = courseService.getAll();
		List<User> teacherLists = userService.getUsersByType("teacher");
		List<Term>termLists=TermContainer.getTermList();
		Map<String, Object>params=new HashMap<>();
		params.put("permissionLists", jokerUtils.getLoginUserPermissions());
		params.put("courseLists", courseLists);
		params.put("teacherLists", teacherLists);
		params.put("termLists", termLists);
		ModelAndView modelAndView=new ModelAndView("section_add",params);
		return modelAndView;
	}
	@RequestMapping("/addSection.do")
	public ModelAndView  doAddSection(HttpServletRequest request,HttpServletResponse response)
	{
		int limitCount=Integer.parseInt(request.getParameter("limitCount").toString());
		String courseName=request.getParameter("courseName");
		int teacherId=Integer.parseInt(request.getParameter("teacherId").toString());
		String year=request.getParameter("year");
		
		CourseSection courseSection=new CourseSection();
		courseSection.setCourseName(courseName);
		courseSection.setLimitCount(limitCount);
		courseSection.setUid(teacherId);
		courseSection.setYear(year);
		courserSectionService.addCourseSection(courseSection);
		
		ModelAndView modelAndView=new ModelAndView("redirect:/admin/editSection");
		modelAndView.addObject("error", "添加成功");
		return modelAndView;
	}
	@RequestMapping("deleteSection/{sectId}")
	public ModelAndView deleteSection(@PathVariable("sectId")Integer sectId,HttpServletRequest request,HttpServletResponse response)
	{
		courserSectionService.deleteById(sectId);
		ModelAndView modelAndView=new ModelAndView("redirect:/admin/editSection");
		modelAndView.addObject("error","成功删除");
		return modelAndView;
	}
	@RequestMapping("addTimeTable")
	public ModelAndView addTimeTable(HttpServletRequest request,HttpServletResponse response)
	{
		Map<String, Object>params=new HashMap<>();
		params.put("permissionLists", jokerUtils.getLoginUserPermissions());
		ModelAndView modelAndView=new ModelAndView("section_timetable_add",params);
		return modelAndView;
	}
	@RequestMapping("addTimeTable.do")
	public ModelAndView doAddTimeTable(TimeTable timeTable,HttpServletRequest request,HttpServletResponse response)
	{
		timeTableService.add(timeTable);
		ModelAndView modelAndView=new ModelAndView("redirect:/admin/editSection");
		return modelAndView;
	}
	@RequestMapping("editCollege")
	public ModelAndView editCollege(HttpServletRequest request,HttpServletResponse response)
	{
		List<Department>departmentLists=departmentService.getAll();
		Map<String, Object>params=new HashMap<>();
		params.put("permissionLists", jokerUtils.getLoginUserPermissions());
		params.put("departmentLists", departmentLists);
		ModelAndView modelAndView=new ModelAndView("all_dept",params);
		return modelAndView;
	}
}

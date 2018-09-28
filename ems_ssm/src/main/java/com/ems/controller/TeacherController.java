/**
 * 
 */
package com.ems.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ems.model.Section;
import com.ems.model.Teacher;
import com.ems.service.CourseService;
import com.ems.service.SectionService;
import com.ems.service.StaffService;

/**
 * @author Administrator
 *
 */
@RestController
public class TeacherController
{
	@Autowired
	SectionService sectionService;
	@Autowired
	CourseService courseService;
	@Autowired
	StaffService staffService;

	@RequestMapping("/addBook")
	public ModelAndView addBook(HttpServletRequest request, HttpServletResponse response)
	{
		Map<String, Object> params = new HashMap<String, Object>();
		HttpSession httpSession = request.getSession(true);
		Teacher teacher = (Teacher) httpSession.getAttribute("person");
		List<Section> sectionLists = sectionService.getSectionsByIdCard(teacher.getIdCard());

		params.put("sectionLists", sectionLists);
		ModelAndView modelAndView = new ModelAndView("addBook2", params);
		return modelAndView;
	}

}

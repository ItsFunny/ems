package com.ems.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.security.auth.login.AccountNotFoundException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.ems.model.SysPermission;
import com.ems.model.User;
import com.ems.service.AdminService;
import com.ems.service.AuthorityService;
import com.ems.service.SysPermissionService;
import com.ems.service.TeacherService;
import com.ems.service.UserService;

@RestController
public class WenController
{
	@Autowired
	TeacherService teacherService;

	@Autowired
	AdminService adminService;
	@Autowired
	UserService userService;
	@Autowired
	AuthorityService authorityService;

	@Autowired
	SysPermissionService sysPermissionService;
	Logger logger = org.slf4j.LoggerFactory.getLogger(this.getClass());

	@RequestMapping(value = "/login")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response)
	{
		ModelAndView modelAndView = null;
		Map<String, Object> params = new HashMap<String, Object>();
		Object exception = request.getAttribute("shiroLoginFailure");
		String error = "";
		if (exception != null)
		{

			// if( AccountNotFoundException.class.isInstance(exception))
//			System.out.println(AccountNotFoundException.class.getName());
//			System.out.println(AuthenticationException.class.getName());
			if (AccountNotFoundException.class.getName().equals(exception))
			{
				error = "璇峰厛杈撳叆璐︽埛鎴栧瘑鐮�";
			}
			// else if( AuthenticationException.class.isInstance(exception))
			else if (AuthenticationException.class.getName().equals(exception))
			{
				error = "璐﹀彿涓嶅瓨鍦ㄦ垨鑰呭瘑鐮侀敊璇�";
			}
			params.put("error", error);
			modelAndView = new ModelAndView("login", params);
			return modelAndView;
		}
		//鐧婚檰鎴愬姛鍚庡叏璁﹕hiro澶勭悊,杩欎釜涓嶅鐞嗙櫥闄�
		modelAndView = new ModelAndView("login");
		return modelAndView;
	}
	@RequestMapping(value = "/index")
	public ModelAndView index(@RequestParam Map<String, Object> params, HttpServletRequest request,
			HttpServletResponse response)
	{
		HttpSession session = request.getSession(true);
		Subject subject = SecurityUtils.getSubject();
		ModelAndView modelAndView = null;
		if (subject.isAuthenticated())
		{
			User user = (User) subject.getPrincipal();
			// 鏍规嵁user 鐨刟uthId鑾峰彇浠栫殑鏉冮檺瀵瑰簲鐨勮祫婧�,浠庤�屽姩鎬佺敓鎴愰〉闈�
			List<SysPermission> permissionLists = sysPermissionService.getPermissionsByAuthId(user.getAuthId());
			params.put("permissionLists", permissionLists);
			params.put("user", user);
			session.setAttribute("permissionLists", permissionLists);
			modelAndView = new ModelAndView("Main", params);
			return modelAndView;
		}
		else 
		return new ModelAndView("login");
	}
}

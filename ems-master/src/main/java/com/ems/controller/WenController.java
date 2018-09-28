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
		Map<String, Object> params = new HashMap<>();
		Object exception = request.getAttribute("shiroLoginFailure");
		String error = "";
		if (exception != null)
		{

			// if( AccountNotFoundException.class.isInstance(exception))
//			System.out.println(AccountNotFoundException.class.getName());
//			System.out.println(AuthenticationException.class.getName());
			if (AccountNotFoundException.class.getName().equals(exception))
			{
				error = "请先输入账户或密码";
			}
			// else if( AuthenticationException.class.isInstance(exception))
			else if (AuthenticationException.class.getName().equals(exception))
			{
				error = "账号不存在或者密码错误";
			}
			params.put("error", error);
			modelAndView = new ModelAndView("login", params);
			return modelAndView;
		}
		//登陆成功后全让shiro处理,这个不处理登陆
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
			// 根据user 的authId获取他的权限对应的资源,从而动态生成页面
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

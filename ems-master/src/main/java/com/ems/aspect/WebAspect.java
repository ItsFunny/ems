package com.ems.aspect;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.ems.model.SysPermission;
@Aspect
@Component
public class WebAspect
{
	private final static Logger logger=LoggerFactory.getLogger(WebAspect.class);
	@Pointcut("execution(public * com.ems.controller.WenController.index(..))")
	public void cut() {}
	
	@Pointcut("execution(public * com.ems.controller.AdminControlelr.*.*(..))")
	public void rendPage(){}

	@Before("cut()")
	public void doBefore()
	{
		ServletRequestAttributes attr=(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request=attr.getRequest();
		//url
		logger.info("url={}",request.getRequestURL());
		//method
		logger.info("method={}",request.getMethod());
		//ip
		logger.info("ip={}",request.getRemoteAddr());
	}
	@Before("rendPage()")
	public void doRendPage()
	{
		System.out.println("动态test");
		ServletRequestAttributes attributes=(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request=attributes.getRequest();
		HttpSession session = request.getSession(true);
		List<SysPermission> permissionLists = (List<SysPermission>) session.getAttribute("permissionLists");
		ModelAndView modelAndView=new ModelAndView("Main");
		modelAndView.addObject("permissionLists",permissionLists);
		
	}
	
	
	
	
	
	
	
}

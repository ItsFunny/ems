package com.ems.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class ExecptionHandle implements HandlerExceptionResolver
{
	private Logger logger = LoggerFactory.getLogger(ExecptionHandle.class);

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex)
	{
		String error = null;
		ModelAndView modelAndView = new ModelAndView();
		// 判断异常类型,是否是预期异常
		if (ex !=null)
		{
			error = "账号不存在或者密码错误,请重新输入";
		}
		// else if ("kaptchaValidateFailed".equals(ex))
		// {
		// error="验证码错误,请重新输入";
		// }
		logger.error(error);
		modelAndView.setViewName("error");
		modelAndView.addObject("error", error);
		return modelAndView;
	}

}

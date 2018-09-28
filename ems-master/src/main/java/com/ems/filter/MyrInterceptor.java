//package com.ems.filter;
//
//import java.util.Date;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//
//import com.ems.abstracT.Person;
//import com.ems.model.Admin;
//import com.ems.security.MyException;
//public class MyrInterceptor implements HandlerInterceptor
//{
//
//	private org.slf4j.Logger logger=org.slf4j.LoggerFactory.getLogger(MyrInterceptor.class);
//	@Override
//	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
//	{
//		boolean flag=false;
//		HttpSession session=request.getSession(true);
//		Person person=(Person) session.getAttribute("person");
//		if(person==null)
//		{
//			throw new MyException("尚未登陆");
//		}
//		else if(person instanceof Admin)
//		{
//			flag=true;
//		} 
//		else {
//			logger.info(person.getName()+"于"+new Date()+"企图登入");
//			throw new MyException("无权访问");
//		}
//		return flag;
//	}
//
//	@Override
//	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
//			ModelAndView modelAndView) throws Exception
//	{
////		System.out.println(">>>MyInterceptor1>>>>>>>请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）");
//    }
//	
//
//	@Override
//	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
//			throws Exception
//	{
////		System.out.println(">>>MyInterceptor1>>>>>>>在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）");
//	}
//
//}

package com.ems.config;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

import javax.servlet.Filter;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import com.ems.security.ExecptionHandle;
import com.ems.util.JokerUtils;


@Configuration
@EnableCaching
public class Config extends CachingConfigurerSupport
{

	// @Bean(name = "multipartResolver")
	// public CommonsMultipartResolver createMultipartResolver()
	// {
	// CommonsMultipartResolver resolver = new CommonsMultipartResolver();
	// resolver.setDefaultEncoding("utf-8");
	// return resolver;
	// }
	@Bean
	public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager)
	{
		System.out.println("shiroConfigure");
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		shiroFilterFactoryBean.setSecurityManager(securityManager);
		//自定义filter
		MyShiroLoginConfig myShiroLoginConfig=new MyShiroLoginConfig();
		Map<String,Filter>filterMap=shiroFilterFactoryBean.getFilters();
		filterMap.put("myShiroLoginConfig", myShiroLoginConfig);
		shiroFilterFactoryBean.setFilters(filterMap);
//		// 拦截器
		Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
		
		filterChainDefinitionMap.put("/static/**", "anon");
		// 配置退出 过滤器,其中的具体的退出代码Shiro已经替我们实现了
		filterChainDefinitionMap.put("/logout", "logout");
		// <!-- 过滤链定义，从上向下顺序执行，一般将/**放在最为下边 -->:这是一个坑呢，一不小心代码就不好使了;
		// <!-- authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问-->
		filterChainDefinitionMap.put("/login","myShiroLoginConfig");
		filterChainDefinitionMap.put("/**", "authc");
		// 如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
		shiroFilterFactoryBean.setLoginUrl("/login");
		
		// 登录成功后要跳转的链接
		shiroFilterFactoryBean.setSuccessUrl("/index");
		// 未授权界面;
		shiroFilterFactoryBean.setUnauthorizedUrl("/403");
		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
		return shiroFilterFactoryBean;
	}
	@Bean
	public MyShiroLoginConfig myShiroLoginConfig()
	{
		return new MyShiroLoginConfig();
	}

	@Bean
	public MySiroRealm myShiroRealm()
	{
		MySiroRealm myShiroRealm = new MySiroRealm();
		// 这是告诉shiro,密码用加密(参数为具体的方法)
		// myShiroRealm.setCredentialsMatcher(hashedCredentialsMatcher());
		return myShiroRealm;
	}

	// @Bean
	// public HashedCredentialsMatcher hashedCredentialsMatcher()
	// {
	// HashedCredentialsMatcher hashedCredentialsMatcher = new
	// HashedCredentialsMatcher();
	// hashedCredentialsMatcher.setHashAlgorithmName("md5");// 散列算法:这里使用MD5算法;
	// hashedCredentialsMatcher.setHashIterations(2);// 散列的次数，比如散列两次，相当于
	// // md5(md5(""));
	// return hashedCredentialsMatcher;
	// }
	@Bean
	public SecurityManager securityManager()
	{
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		securityManager.setRealm(myShiroRealm());
		return securityManager;
	}


	@Bean(name = "simpleMappingExceptionResolver")
	public SimpleMappingExceptionResolver createSimpleMappingExceptionResolver()
	{
		SimpleMappingExceptionResolver r = new SimpleMappingExceptionResolver();
		Properties mappings = new Properties();
		mappings.setProperty("DatabaseException", "databaseError");// 数据库异常处理
		mappings.setProperty("UnauthorizedException", "403");
		r.setExceptionMappings(mappings); // None by default
		r.setDefaultErrorView("error"); // No default
		r.setExceptionAttribute("ex"); // Default is "exception"
		// r.setWarnLogCategory("example.MvcLogger"); // No default
		return r;
	}

	/**
	 * 开启shiro aop注解支持. 使用代理方式;所以需要开启代码支持;
	 * 
	 * @param securityManager
	 * @return
	 */
	@Bean
	public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager)
	{
		AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
		authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
		return authorizationAttributeSourceAdvisor;
	}
	
	//工具类
	@Bean
	public JokerUtils jokerUtils()
	{
		return new JokerUtils();
	}
	
	//注入异常处理类
//	@Bean
//	public ExecptionHandle execptionHandle()
//	{
//		return new ExecptionHandle();
//	}

}

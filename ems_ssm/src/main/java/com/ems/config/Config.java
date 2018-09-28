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
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import com.ems.util.JokerUtils;


@Configuration
@ComponentScan(basePackages="com.*")
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
		//鑷畾涔塮ilter
		MyShiroLoginConfig myShiroLoginConfig=new MyShiroLoginConfig();
		Map<String,Filter>filterMap=shiroFilterFactoryBean.getFilters();
		filterMap.put("myShiroLoginConfig", myShiroLoginConfig);
		shiroFilterFactoryBean.setFilters(filterMap);
//		// 鎷︽埅鍣�
		Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
		
		filterChainDefinitionMap.put("/static/**", "anon");
		// 閰嶇疆閫�鍑� 杩囨护鍣�,鍏朵腑鐨勫叿浣撶殑閫�鍑轰唬鐮丼hiro宸茬粡鏇挎垜浠疄鐜颁簡
		filterChainDefinitionMap.put("/logout", "logout");
		// <!-- 杩囨护閾惧畾涔夛紝浠庝笂鍚戜笅椤哄簭鎵ц锛屼竴鑸皢/**鏀惧湪鏈�涓轰笅杈� -->:杩欐槸涓�涓潙鍛紝涓�涓嶅皬蹇冧唬鐮佸氨涓嶅ソ浣夸簡;
		// <!-- authc:鎵�鏈塽rl閮藉繀椤昏璇侀�氳繃鎵嶅彲浠ヨ闂�; anon:鎵�鏈塽rl閮介兘鍙互鍖垮悕璁块棶-->
		filterChainDefinitionMap.put("/login","myShiroLoginConfig");
		filterChainDefinitionMap.put("/**", "authc");
		// 濡傛灉涓嶈缃粯璁や細鑷姩瀵绘壘Web宸ョ▼鏍圭洰褰曚笅鐨�"/login.jsp"椤甸潰
		shiroFilterFactoryBean.setLoginUrl("/login");
		
		// 鐧诲綍鎴愬姛鍚庤璺宠浆鐨勯摼鎺�
		shiroFilterFactoryBean.setSuccessUrl("/index");
		// 鏈巿鏉冪晫闈�;
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
		// 杩欐槸鍛婅瘔shiro,瀵嗙爜鐢ㄥ姞瀵�(鍙傛暟涓哄叿浣撶殑鏂规硶)
		// myShiroRealm.setCredentialsMatcher(hashedCredentialsMatcher());
		return myShiroRealm;
	}

	// @Bean
	// public HashedCredentialsMatcher hashedCredentialsMatcher()
	// {
	// HashedCredentialsMatcher hashedCredentialsMatcher = new
	// HashedCredentialsMatcher();
	// hashedCredentialsMatcher.setHashAlgorithmName("md5");// 鏁ｅ垪绠楁硶:杩欓噷浣跨敤MD5绠楁硶;
	// hashedCredentialsMatcher.setHashIterations(2);// 鏁ｅ垪鐨勬鏁帮紝姣斿鏁ｅ垪涓ゆ锛岀浉褰撲簬
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
		mappings.setProperty("DatabaseException", "databaseError");// 鏁版嵁搴撳紓甯稿鐞�
		mappings.setProperty("UnauthorizedException", "403");
		r.setExceptionMappings(mappings); // None by default
		r.setDefaultErrorView("error"); // No default
		r.setExceptionAttribute("ex"); // Default is "exception"
		// r.setWarnLogCategory("example.MvcLogger"); // No default
		return r;
	}

	/**
	 * 寮�鍚痵hiro aop娉ㄨВ鏀寔. 浣跨敤浠ｇ悊鏂瑰紡;鎵�浠ラ渶瑕佸紑鍚唬鐮佹敮鎸�;
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
	
	//宸ュ叿绫�
	@Bean
	public JokerUtils jokerUtils()
	{
		return new JokerUtils();
	}
	
	//娉ㄥ叆寮傚父澶勭悊绫�
//	@Bean
//	public ExecptionHandle execptionHandle()
//	{
//		return new ExecptionHandle();
//	}

}

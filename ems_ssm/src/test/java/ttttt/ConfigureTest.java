package ttttt;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ems.config.Config;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-*.xml","classpath:mybatis-config.xml"})
public class ConfigureTest
{
	@Test
	public void test1()
	{
		ApplicationContext context=new AnnotationConfigApplicationContext(Config.class);
		ShiroFilterFactoryBean shiroFilter = (ShiroFilterFactoryBean) context.getBean("shiroFilter");
		System.out.println(shiroFilter.toString());
		System.err.println(shiroFilter.getClass().getName());
	}
}

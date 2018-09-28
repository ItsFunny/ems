//package ems;
//
//import static org.mockito.Matchers.intThat;
//
//import java.util.Date;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.SpringApplicationConfiguration;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.context.WebApplicationContext;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//
//import com.ems.App;
//import com.ems.model.User;
//import com.ems.service.UserService;
//
//@SuppressWarnings("deprecation")
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = App.class)
//@EnableWebMvc
//@WebAppConfiguration
//public class RedisTest
//{
//
//	@Autowired
//	WebApplicationContext webApplicationContext;
//
//	MockMvc mockMvc;
//
//	public void initMockMvc()
//	{
//		this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
//	}
//
//	@Autowired
//	UserService userService;
//
//	@Test
//	public void test2() throws Exception
//	{
//		initMockMvc();
//		Date begin = new Date();
//		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/").param("userId", "1")).andReturn();
//		Date end = new Date();
//		int length = (int) (end.getTime() - begin.getTime());
//		System.out.println(length);
//		System.out.println(result.toString());
//	}
//}

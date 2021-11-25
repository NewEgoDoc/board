package com.example.board;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.example.board.service.UserService;
import com.example.board.service.UserServiceImpl;
import com.example.board.vo.UserVO;

public class UserServiceTest {
	
	@Test
	public void insertTest() {
		UserVO u1 = new UserVO();
		UserVO u2 = new UserVO();
		UserVO u3 = new UserVO();
		
		u1.setId("1");
		u1.setName("홍길동");
		u1.setPassword("123");
		u1.setRole("guest");
		u2.setId("2");
		u2.setName("김길동");
		u2.setPassword("123");
		u2.setRole("guest");
		u3.setId("3");
		u3.setName("강길동");
		u3.setPassword("123");
		u3.setRole("admin");
		
		ApplicationContext ac = new GenericXmlApplicationContext("root-context.xml");
		UserService userService = ac.getBean("userServiceImpl",UserService.class);
		
		userService.insertUser(u1);
		userService.insertUser(u2);
		userService.insertUser(u3);
		
		System.out.println("입력 완료!!");
		
		UserVO getUser = userService.getUser(u1);
		System.out.println(getUser);
		//assertNotNull(getUser);
		assertEquals(getUser.getId(), u1.getId());
		assertEquals(getUser.getPassword(), u1.getPassword());
		assertEquals(getUser.getRole(), u1.getRole());
		assertEquals(getUser.getName(), u1.getName());
		
	}
}

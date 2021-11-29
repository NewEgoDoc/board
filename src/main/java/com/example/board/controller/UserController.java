package com.example.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user/")
public class UserController {
	
	@RequestMapping("/login")
	public String login() {
		return "user/login";
	}
	
	@RequestMapping("/boardList")
	public String boardList() {
		
		return "board/boardList";
	}
	
	
}

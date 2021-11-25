package com.example.board.service;

import com.example.board.vo.UserVO;

public interface UserService {
	UserVO getUser(UserVO vo);
	void insertUser(UserVO vo);
}

package com.example.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.board.dao.UserDAO;
import com.example.board.vo.UserVO;


@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserDAO userDAO;
	
	@Override
	public UserVO getUser(UserVO vo) {
		return userDAO.getUser(vo);
	}

	@Override
	public void insertUser(UserVO vo) {
		userDAO.insertUser(vo);
	}

}

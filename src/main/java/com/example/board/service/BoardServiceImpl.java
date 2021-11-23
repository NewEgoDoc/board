package com.example.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.board.common.LogAdvice;
import com.example.board.common.NewLogAdvice;
import com.example.board.dao.BoardDAO;
import com.example.board.vo.BoardVO;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardDAO boardDAO;	
	
//	public BoardServiceImpl(BoardDAO boardDAO) {
//		this.boardDAO = boardDAO;
//	}
	
	@Override
	public void insertBoard(BoardVO board) {
		boardDAO.insertBoard(board);
	}

	@Override
	public void deleteBoard(BoardVO board) {
		boardDAO.deleteBoard(board);
	}

	@Override
	public BoardVO getBoard(BoardVO board) {
		return boardDAO.getBoard(board);
	}

	@Override
	public List<BoardVO> getBoardList(BoardVO board) {
		return boardDAO.getBoardList(board);
	}

}

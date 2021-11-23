package com.example.board.service;

import java.util.List;

import com.example.board.vo.BoardVO;

public interface BoardService {
	void insertBoard(BoardVO board);
	void deleteBoard(BoardVO board);
	BoardVO getBoard(BoardVO board);
	List<BoardVO> getBoardList(BoardVO board);
}

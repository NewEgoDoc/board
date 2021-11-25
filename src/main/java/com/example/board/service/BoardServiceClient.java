package com.example.board.service;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.example.board.vo.BoardVO;

public class BoardServiceClient {
	
	@Test
	public void boardListTest() {
		ApplicationContext ac = new GenericXmlApplicationContext("root-context.xml");
		
		BoardService boardService = ac.getBean("boardServiceImpl", BoardServiceImpl.class);
		
		BoardVO board = new BoardVO();
		board.setTitle("임시 제목");
		board.setContent("임시 내용......");
		board.setWriter("나야나");
		
		//boardService.insertBoard(board);
		
		List<BoardVO> boardList = boardService.getBoardList(board);
		System.out.println("jyhgjhgjhgjh"+boardList);
		for(BoardVO b:boardList) {
			System.out.println(b);
		}
		BoardVO vvvv =  new BoardVO();
		vvvv.setSeq(3);
		System.out.println("--One-- " + boardService.getBoard(vvvv));
		
		((AbstractApplicationContext) ac).close();
	}
}
package com.example.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.board.common.JDBCUtil;
import com.example.board.vo.BoardVO;

@Repository
public class BoardDAO {
	
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	//sql 쿼리문을 필드에 둘 것인가? 메서드의 지역변수에 둘 것인가?
	// 전용 쿼리 인터페이스의 상수변수로 둘 것인가? <= sql 쿼리문에 고정된 값이 들어가는가 가변값이 들어가는가?
	
	RowMapper<BoardVO> mapper = (rs, count) -> {
		BoardVO board = new BoardVO();
		board.setCnt(rs.getLong("Cnt"));
		board.setSeq(rs.getLong("Seq"));
        board.setTitle(rs.getString("Title"));
        board.setContent(rs.getString("Content"));
        board.setWriter(rs.getString("Writer"));
        board.setRegDate(rs.getString("RegDate"));
		return 	board;
	};
	private final String BOARD_INSERT = "insert into board(seq, title,writer,content,cnt) values(  (select nvl(max(seq),0) + 1 from board),?,?,?,0)";
//	public void insertBoard(BoardVO board) {
//		//System.out.println("==> JDBC로 insertBoard() 기능 처리" );
//		
//		try {
//			conn = JDBCUtil.getConnection();
//			preparedStatement = conn.prepareStatement(BOARD_INSERT);
//			preparedStatement.setString(1, board.getTitle());
//			preparedStatement.setLong(3, board.getSeq());
//			preparedStatement.setString(2, board.getContent());
//			
//			preparedStatement.executeUpdate();
//			
//		} catch (Exception e) {
//			System.err.println(this.getClass().getName() + "입력중에 오류발생!!!!!!!!!");
//			
//		} finally {
//			JDBCUtil.close(preparedStatement, conn);
//		}
//	}
	
	public void insertBoard(BoardVO board) {
		jdbcTemplate.update(BOARD_INSERT,board.getTitle(),board.getWriter(),board.getContent());	
	}
	
	
	private final String BOARD_DELETE = "delete from board where seq = ?";
//	public void deleteBoard(BoardVO board) {
//		//System.out.println("==> JDBC로 deleteBoard() 기능 처리" );
//		
//		try {
//			conn = JDBCUtil.getConnection();
//			preparedStatement = conn.prepareStatement(BOARD_DELETE);
//			preparedStatement.setLong(1, board.getSeq());
//			
//			preparedStatement.executeUpdate();
//			
//		} catch (Exception e) {
//			System.err.println(this.getClass().getName() + "삭제중에 오류발생!!!!!!!!!");
//			
//		} finally {
//			
//			JDBCUtil.close(preparedStatement, conn);
//		}
//	}
	public void deleteBoard(BoardVO board) {
		jdbcTemplate.update(BOARD_DELETE,board.getSeq());
	}
	
	private final String BOARD_UPDATE = "update board set TITLE = ?, CONTENT = ? where seq = ?";
//	public void updateBoard(BoardVO board) {
//		//System.out.println("==> JDBC로 updateMode() 기능 처리" );
//		
//		try {
//			conn = JDBCUtil.getConnection();
//			preparedStatement = conn.prepareStatement(BOARD_UPDATE);
//			preparedStatement.setString(1, board.getTitle());
//			preparedStatement.setString(2, board.getWriter());
//			preparedStatement.setString(3, board.getContent());
//			
//			preparedStatement.executeUpdate();
//			
//		} catch (Exception e) {
//			System.err.println(this.getClass().getName() + "수정중에 오류발생!!!!!!!!!");
//			
//		} finally {
//			JDBCUtil.close(preparedStatement, conn);
//		}
//	}
	
	public void updateBoard(BoardVO board) {
		jdbcTemplate.update(BOARD_UPDATE,board.getTitle(),board.getContent(),board.getSeq());
	}
	
	private final String BOARD_GET = "select * from board where seq = ?";
	public BoardVO getBoard(BoardVO board) {
		System.out.println("getBoard");
		List<BoardVO> list = jdbcTemplate.query(BOARD_GET,mapper,board.getSeq());
		return list.get(0);
	}
//	public BoardVO getBoard(BoardVO board) {
//		BoardVO vo = null;
//		//System.out.println("==> JDBC로 getBoard() 기능 처리" );
//		
//		try {
//			conn = JDBCUtil.getConnection();
//			preparedStatement = conn.prepareStatement(BOARD_GET);
//			preparedStatement.setLong(1, board.getSeq());
//			
//			preparedStatement.executeQuery();
//			
//			resultSet = preparedStatement.executeQuery();
//			
//			//rollup? cube
//			while(resultSet.next()) {
//				vo = new BoardVO();
//				vo.setSeq(resultSet.getLong("Seq"));
//				vo.setTitle(resultSet.getString("Title"));
//				vo.setContent(resultSet.getString("Content"));
//				vo.setWriter(resultSet.getString("Writer"));
//				vo.setRegDate(resultSet.getString("RegDate"));
//				vo.setCnt(resultSet.getLong("Cnt"));
//				//return vo;
//			}
//			
//		} catch (Exception e) {
//			System.err.println(this.getClass().getName() + "getboard에 오류발생!!!!!!!!!");
//			
//		} finally {
//			JDBCUtil.close(preparedStatement, conn);
//			//throw new NullPointerException();
//		}
//		return vo;
//	}
	
	private final String BOARD_LIST = "select * from board order by seq desc";
	public List<BoardVO> getBoardList(BoardVO board) {
		System.out.println("getBoardList");
		List<BoardVO> list = jdbcTemplate.query(BOARD_GET,mapper);
			return list;
	}
}
//	public List<BoardVO> getBoardList(BoardVO board) {
//		List<BoardVO> boardList = null;
//		//vSystem.out.println("==> JDBC로 getBoard() 기능 처리" );
//		
//		try {
//			conn = JDBCUtil.getConnection();
//			preparedStatement = conn.prepareStatement(BOARD_LIST);
//			
//			preparedStatement.executeQuery();
//			
//			resultSet = preparedStatement.executeQuery();
//			
//			boardList = new ArrayList<BoardVO>();
//			while(resultSet.next()) {
//				BoardVO vo = new BoardVO();
//				vo.setSeq(resultSet.getLong("Seq"));
//				vo.setTitle(resultSet.getString("Title"));
//				vo.setContent(resultSet.getString("Content"));
//				vo.setWriter(resultSet.getString("Writer"));
//				vo.setRegDate(resultSet.getString("RegDate"));
//				vo.setCnt(resultSet.getLong("Cnt"));
//				boardList.add(vo);
//			}
//			return boardList;
//		} catch (Exception e) {
//			System.err.println(this.getClass().getName() + "getboardlist에 오류발생!!!!!!!!!");
//			
//		} finally {
//			JDBCUtil.close(preparedStatement, conn);
//		}
//		return boardList;
//	}


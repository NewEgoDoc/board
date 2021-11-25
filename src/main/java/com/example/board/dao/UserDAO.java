package com.example.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import com.example.board.common.JDBCUtil;
import com.example.board.vo.UserVO;


@Repository
public class UserDAO {

	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private final String USER_GET = "select * from users where id = ? and password = ?";
	
	public UserVO getUser(UserVO vo) {
		UserVO userVo = null;
		try {
			con = JDBCUtil.getConnection();
			pstmt = con.prepareStatement(USER_GET);
			System.out.println(vo);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPassword());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				System.out.println("asdfasdf");
				userVo= new UserVO();
				userVo.setId(rs.getString("id"));
				userVo.setPassword(rs.getString("password"));
				userVo.setName(rs.getString("name"));
				userVo.setRole(rs.getString("role"));
				return userVo;
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			JDBCUtil.close(pstmt, con, rs);
		}
		return userVo;
	}

	private final String USER_INSERT = "insert into users values(?,?,?,?)";	
	public void insertUser(UserVO vo) {
		try {
			con = JDBCUtil.getConnection();
			pstmt = con.prepareStatement(USER_INSERT);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPassword());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getRole());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			
		} finally {
			JDBCUtil.close(pstmt, con);
		}
	}
	
	
}

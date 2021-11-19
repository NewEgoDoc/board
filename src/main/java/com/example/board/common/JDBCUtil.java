package com.example.board.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCUtil {
	public static Connection getConnection() {
		Class.forName("");
		Connection con = null;
		return con;
	}
	
	public static void close(PreparedStatement pstmt, Connection con) {
		
	}
	
	public static void close(PreparedStatement pstmt, Connection con, ResultSet rs) {
		
	}
}

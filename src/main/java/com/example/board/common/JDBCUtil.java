package com.example.board.common;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class JDBCUtil {
	public static Connection getConnection() {
		
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			return DriverManager.getConnection("jdbc:oracle:thin:@192.168.150.55:1521:xe","byeon","byeon");
		} catch (ClassNotFoundException | SQLException e) {
			try {
				java.io.File fw = new File("exceptionMsg.txt");
				System.setErr(new PrintStream(fw));
			} catch (Exception e2) {
				// TODO: handle exception
			}
			System.err.println("클래스가 존재하지 않습니다");
			
		}
		return con;
	}
	
	public static void close(PreparedStatement pstmt, Connection con) {
		if(pstmt != null) {try {pstmt.close();} catch (Exception e) {}}
		if(con != null) {try {con.close();} catch (Exception e) {}}
		
	}
	
	public static void close(PreparedStatement pstmt, Connection con, ResultSet rs) {
		if(rs != null) {try {rs.close();} catch (Exception e) {}}
		close(pstmt, con);
	}
}

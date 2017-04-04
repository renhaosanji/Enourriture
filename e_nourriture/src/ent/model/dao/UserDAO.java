package ent.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ent.model.dto.User;

/*
 * userDAO
 * 
 * 1. user 등록
 * 2. user 로그인
 * 3. user 정보 조회
 */
public class UserDAO {
	
	private FactoryDAO fd = new FactoryDAO();
	
	public UserDAO(){
		
	}
	
	private Connection getConnection(){
		return fd.getConnection();
	}
	
	private Statement getStatement(Connection conn){
		Statement stmt = null;
		
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return stmt;
	}
	
	// 등록
	public int join(User user){
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql = "insert into userinfo values(?,?,?,?,?)";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUserId());
			pstmt.setString(2, user.getUserPw());
			pstmt.setString(3, user.getNickname());
			pstmt.setString(4, user.getPhoneNumber());
			pstmt.setString(5, user.getEmail());
			
			return pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		
			fd.close(pstmt,conn);
			
		}
		
		return 0;
		
	}
	
	// 로그인
	public boolean login(String userId, String userPw){
		
		Connection conn=null;
		Statement stmt=null;
		String sql = "select userpw from userinfo where userid=\'"+userId+"\'";
		ResultSet rs =null;
		String check_user_pw =null;
		try {
			conn = getConnection();
			stmt = getStatement(conn);
			rs = stmt.executeQuery(sql);
			
			if(rs.next()){
				check_user_pw = rs.getString(1);
			}
			if(check_user_pw==null){
				return false;
			} else {
				
				if(check_user_pw.equals(userPw)){
					return true;
				}
			}			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}
	
	// 조회
	
	
	
	
	
	

}

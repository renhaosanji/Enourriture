package ent.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ent.model.dto.Follow;
import ent.model.dto.User;

/*
 * userDAO
 * 
 * 1. user ���
 * 2. user �α���
 * 3. user ���� ��ȸ
 * 4. user �ֹ�
 * 5. user ����
 * 6. ȸ�� ���� ������Ʈ
 * 7. user ��й�ȣ ����
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
	
	// 1. user ���
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
	
	//2. user �α���
	public boolean login(String userId, String userPw){
		
		Connection conn=null;
		Statement stmt=null;
		String sql = "select userpw from userinfo where userid='"+userId+"'";
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
	
	// 3. user ���� ��ȸ
	public User selectOne(String userId){
	
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs=null;
		String sql = "select * from Member where userId='"+userId+"'";
		String userPw=null;
		String nickname=null;
		String phoneNumber=null;
		String email;
		Follow follow;	
		try {
			conn = getConnection();
			stmt = getStatement(conn);
			rs = stmt.executeQuery(sql);
			if(rs.next()){
				userPw = rs.getString(1);
				nickname = rs.getString(2);
				phoneNumber =rs.getString(3);
				email=rs.getString(4);	
				return new User(userId, userPw, nickname,phoneNumber,email);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			fd.close(rs, stmt,conn);
			
		}
		
		return null;
	}
	
	//5. user ����
	public int delete(String userId, String userPw){
		

		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql = "delete member where userId=? and userPw=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, userPw);
			return pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			fd.close(pstmt,conn);
		}
		
		return 0;
	}
	// 6. ȸ�� ���� ������Ʈ
	public int update(User dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			// 2. db ��������
			conn = getConnection();
			// 3. Ư�� sql ���� ��ΰ���
			String sql = "update member set userPw = ?, phoneNumber = ?, email=?, nickname=? where userId = ?";
			pstmt = conn.prepareStatement(sql); 
			pstmt.setString(1, dto.getUserPw());
		    pstmt.setString(2, dto.getPhoneNumber());
		    pstmt.setString(3, dto.getEmail());
		    pstmt.setString(4, dto.getNickname());
		    pstmt.setString(5, dto.getUserId());
			// 4. sql �����û :
			// 5. sql ���ó��
			return pstmt.executeUpdate();  
			
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
		} finally {
			fd.close(pstmt, conn);		
		}
		
		return 0;
	}
	// 7. user ��й�ȣ ����
	public int updateByUserPw(String userId, String userPw, String changeUserPw) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			
			String sql = "update member set user_pw=? where user_id=? and user_pw";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, changeUserPw);	
			pstmt.setString(2, userId);
			pstmt.setString(3, userPw);
			
			return pstmt.executeUpdate();
		} catch(SQLException e) {
			System.out.println("Error : ȸ����ȣ ���� ���� :" + e.getMessage());
			e.printStackTrace();
		} finally {
			fd.close(pstmt, conn);
		}
		
		return 0;
	}
	

}

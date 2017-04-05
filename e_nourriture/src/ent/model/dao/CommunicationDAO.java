package ent.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ent.model.dto.Communication;
import ent.model.dto.User;

public class CommunicationDAO {
	private FactoryDAO fd = new FactoryDAO();
	
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
	public CommunicationDAO(){
		
	}
	public int insertComSender(Communication dto) {
		Connection conn = null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		try {
			conn = getConnection();
		    String sql = "insert into USERCOMMUNICATION ( COMMENTS, senderId,COMMENTTIME,CONTENTSID) values(?, ?, ?,?,?)";
		    pstmt = conn.prepareStatement(sql); // insert ���� �̿ϼ� ���
		    
		    pstmt.setString(1, dto.getComments());
		    pstmt.setString(2, dto.getSenderId());
		    pstmt.setString(3, dto.getCommentTime()); 
		    pstmt.setString(4, dto.getContentsId()); 
		   
		    return pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error : " + e.getMessage());
	        e.printStackTrace();
	    } finally {
	    	fd.close(rs, pstmt, conn);
	      }
		return 0;
	}
	public int insertComReciver(Communication dto) { 
		Connection conn = null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		try {
			conn = getConnection();
		    String sql = "insert into USERCOMMUNICATION ( COMMENTS,RECIVERID,COMMENTTIME,CONTENTSID) values(?, ?, ?,?,?)";
		    pstmt = conn.prepareStatement(sql); // insert ���� �̿ϼ� ���
		    
		    pstmt.setString(1, dto.getComments());
		    pstmt.setString(2, dto.getReceiverId()); 
		    pstmt.setString(3, dto.getCommentTime()); 
		    pstmt.setString(4, dto.getContentsId()); 
		   
		    return pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error : " + e.getMessage());
	        e.printStackTrace();
	    } finally {
	    	fd.close(rs, pstmt, conn);
	      }
		return 0;
	}
	public int deleteCom(String userid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
	
		try {
			// . db ��������
			conn = getConnection();
			// 3. Ư�� sql ���� ��ΰ���
			String sql = "delete USERCOMMUNICATION where user_id=?";
			pstmt = conn.prepareStatement(sql); 
			// ? ���� �ƱԸ�Ʈ�� ����
			pstmt.setString(1, userid);	
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

}

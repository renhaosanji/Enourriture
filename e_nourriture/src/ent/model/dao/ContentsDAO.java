package ent.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ent.model.dto.Contents;

public class ContentsDAO {
	
	private FactoryDAO fd = new FactoryDAO();
	
	public ContentsDAO(){
		
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
	// 0. 글 아이디 찾기
	
	public int findID(Contents contents){

		Connection conn=null;
		Statement stmt=null;
		System.out.println(contents.getUserId()+","+contents.getWriteDate());
		String sql = "select contentsid from usercontents where userid='"+contents.getUserId()+"' AND times='"+contents.getWriteDate()+"'";
		ResultSet rs =null;
		int contentsid=0;
		try {
			conn = getConnection();
			stmt = getStatement(conn);
			rs = stmt.executeQuery(sql);
			
			if(rs.next()){
				contentsid = rs.getInt(1);
			}
			if(contentsid==0){
				return -1;
			} 
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return contentsid;
		
	}
	
	// 1. 글 등록
	
	public int inputContents(Contents contents){
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql = "insert into usercontents(contentsid,userid,text,imgurl,times,contentslikecount) values(contentsId_seq.nextVal,?,?,?,?,?)";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, contents.getUserId());
			pstmt.setString(2, contents.getContents());
			pstmt.setString(3, contents.getImgURL());
			pstmt.setString(4, contents.getWriteDate());
			pstmt.setInt(5, 0);
			
			return pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		
			fd.close(pstmt,conn);
			
		}
		
		return 0;
		
	}

}

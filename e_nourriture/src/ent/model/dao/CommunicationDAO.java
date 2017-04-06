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

	private Connection getConnection() {
		return fd.getConnection();
	}

	private Statement getStatement(Connection conn) {
		Statement stmt = null;

		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return stmt;
	}

	public CommunicationDAO() {

	}

	public int insertComSender(Communication dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
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
		PreparedStatement pstmt = null;
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
   
	//  ��� �� �� 
	public void insertCom(Communication communicationVo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			conn = getConnection();
			String sql = "insert into USERCOMMUNICATION ( COMMENTS,senderId,RECIVERID,COMMENTTIME,CONTENTSID) values(?, ?, ?,?,?)";
			pstmt = conn.prepareStatement(sql); // insert ���� �̿ϼ� ���

			pstmt.setString(1, communicationVo.getComments());
			pstmt.setString(2, communicationVo.getSenderId());
			pstmt.setString(3, communicationVo.getReceiverId());
			pstmt.setString(4, communicationVo.getCommentTime());
			pstmt.setString(5, communicationVo.getContentsId());

			pstmt.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			fd.close(pstmt, conn);
		}
	}
	
	// �ش� �Խù��� ��ü ����� list��
	public ArrayList<Communication> CommunicationList(String contentsId) {
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		ArrayList<Communication> communicationList = new ArrayList<>();
		try {
			conn = getConnection();
			stmt = getStatement(conn);
			String sql = "select COMMENTS, SENDERID, RECIVERID , "
					+ "COMMENTTIME, CONTENTSID from "
					+ "usercommunication where= \'"+contentsId+"'";
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				Communication communication = new Communication();
				communication.setContentsId(contentsId);
				communication.setComments(rs.getString(1));
				communication.setSenderId(rs.getString(2));
				communication.setReceiverId(rs.getString(3));
				communication.setCommentTime(rs.getString(4));
				communicationList.add(communication);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			fd.close(stmt, conn);
		}
		
		
		return communicationList;
	}

}

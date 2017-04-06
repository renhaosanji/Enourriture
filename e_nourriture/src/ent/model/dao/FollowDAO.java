package ent.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.tomcat.util.buf.UEncoder;

import ent.model.dto.Contents;

public class FollowDAO {

	private FactoryDAO fd = new FactoryDAO();

	public FollowDAO() {
		// TODO Auto-generated constructor stub
	}

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

	public ArrayList<String> usersFollowingIdListLoading(String userid) {
		Connection conn = null;
		Statement stmt = null;
		String sql = "select followingUserId from usernetwork where userid=\'" + userid + "\'";
		ResultSet rs = null;
		ArrayList<String> followingUserIds = new ArrayList<>();

		try {
			conn = getConnection();
			stmt = getStatement(conn);
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				followingUserIds.add(rs.getString(1));

			}

			return followingUserIds;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			fd.close(stmt, conn);

		}
		return followingUserIds;
	}

	public ArrayList<Contents> usersFollowingContentsLoading(ArrayList<String> followingUserIds) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		ArrayList<Contents> followingUserContentList = new ArrayList<>();
		String sqlcon1 = "select * from USERCONTENTS where userid=\'";
		String sqlcon2 = "or userid=\'";
		String sqlcon3 = "order by times";

		StringBuilder sb = new StringBuilder("");
		if (followingUserIds != null) {

			if (followingUserIds.size() > 1) {
				for (int i = 1; i < followingUserIds.size(); i++) {
					sb.append(sqlcon2 + followingUserIds.get(i));
				}
			}

			try {
				conn = getConnection();
				stmt = getStatement(conn);
				String sql = sqlcon1 + followingUserIds.get(0) + "\'" + sb.toString() + "\'" + sqlcon3;
				rs = stmt.executeQuery(sql);
				while (rs.next()) {
					Contents followingUserContent = new Contents();
					followingUserContent.setUserId(rs.getString(1));
					followingUserContent.setContentId(rs.getString(2));
					followingUserContent.setContents(rs.getString(3));
					followingUserContent.setImgURL(rs.getString(4));
					followingUserContent.setWriteDate(rs.getString(5));
					followingUserContent.setContentsLikeCount(rs.getInt(6));
					followingUserContentList.add(followingUserContent);
				}

			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			} finally {

				fd.close(stmt, conn);

			}

			return followingUserContentList;

		}

		return null;
	}

	public boolean isfollowedUser(String userId, String followingId) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql1 = "select FOLLOWINGUSERID from USERNETWORK where userid = \'" + userId +"'";
		try {

			conn = getConnection();
			stmt = getStatement(conn);
			rs = stmt.executeQuery(sql1);
			while (rs.next()) {

				if (followingId.equals(rs.getString(1))) {
					
					return true;
					
				}

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		} finally {

			fd.close(stmt, conn);

		}

		return false;

	}
	
	public String followingUser(String userId, String followingId) {
		
		if (isfollowedUser(userId, followingId)==false) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			System.out.println(userId+"+++++++++++++++++++"+followingId);
			String sql1 = "insert into USERNETWORK(userid, FOLLOWINGUSERID)  values(?,?)";
			
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement(sql1);
				pstmt.setString(1, userId);
				pstmt.setString(2, followingId);
				pstmt.executeUpdate();
				return "���������� "+ followingId+"user�� �ȷο��߽��ϴ�.";
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}finally {
				fd.close(pstmt,conn);
			}
			
		}
		  return "�̹��ȷο������Դϴ�";
		
		
	}

}

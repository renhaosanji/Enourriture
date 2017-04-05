package ent.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

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
		Contents followingUserContent = new Contents();
		ArrayList<Contents> followingUserContentList = new ArrayList<>();
		if (followingUserIds != null) {

			for (int i = 0; i < followingUserIds.size(); i++) {

				try {
					conn = getConnection();
					stmt = getStatement(conn);
					String sql = "select * from USERCONTENTS where userid=\'" + followingUserIds.get(i)
							+ "\'";
					rs = stmt.executeQuery(sql);
					while (rs.next()) {
						followingUserContent.setUserId(rs.getString(1));
						followingUserContent.setContentId(rs.getString(2));
						followingUserContent.setContents(rs.getString(3));
						followingUserContent.setImgURL(rs.getString(4));
						followingUserContent.setWriteDate(rs.getString(5));
						followingUserContent.setContentsLikeCount(rs.getInt(6));
						
					}
					followingUserContentList.add(followingUserContent);
					

				} catch (Exception e) {
					// TODO: handle exception
				} finally {

					fd.close(stmt, conn);

				}
			}
			return followingUserContentList;

		}

		return null;
	}

}

package ent.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

public class FollowDAO {
	
	private FactoryDAO fd = new FactoryDAO();
	
	public FollowDAO() {
		// TODO Auto-generated constructor stub
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
	
	public ArrayList<String> usersContentsLoading(String userid) {
		Connection conn=null;
		Statement stmt=null;
		String sql = "select followingUserId from usernetwork where userid=\'"+userid+"\'";
		ResultSet rs =null;
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
		
			fd.close(stmt,conn);
			
		}
		return followingUserIds;
	}

}

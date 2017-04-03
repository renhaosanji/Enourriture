package ent.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class FactoryDAO {
	
	// DataSource(Connection Pool)
	
	private DataSource ds;
	
	public FactoryDAO(){
		try {
			InitialContext context = new InitialContext();
			String codedName = "java:comp/env";
			String rsName = "jdbc/Oracle";
			String name = codedName+"/"+rsName;
			Object obj = context.lookup(name);
			
			ds = (DataSource)obj;
		
			
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	// connection 반환 메소드
	public Connection getConnection(){
		Connection conn=null;
		try {
			 conn = ds.getConnection();
		} catch (SQLException e) {
			System.out.println("연결 실패");
		}
		return conn;

	}
	
	//자원 해제
	public void close(ResultSet rs, Statement stmt, Connection conn){
		try {
			if(rs!=null){
				rs.close();
			}
			if(stmt!=null){
				stmt.close();
			}
			if(conn!=null){
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		
	//자원 해제
	public void close(Statement stmt, Connection conn){
		close(null,stmt,conn);
	}	
	

}

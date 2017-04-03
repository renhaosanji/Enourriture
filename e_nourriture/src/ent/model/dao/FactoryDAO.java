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
	
	// connection ��ȯ �޼ҵ�
	public Connection getConnection(){
		Connection conn=null;
		try {
			 conn = ds.getConnection();
		} catch (SQLException e) {
			System.out.println("���� ����");
		}
		return conn;

	}
	
	//�ڿ� ����
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
		
	//�ڿ� ����
	public void close(Statement stmt, Connection conn){
		close(null,stmt,conn);
	}	
	

}

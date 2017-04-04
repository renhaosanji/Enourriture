package ent.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ent.model.dto.Order;
import ent.model.dto.User;

public class OrderDAO {
	private FactoryDAO fd = new FactoryDAO();
	
	public OrderDAO(){
		
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
	public int purchase(Order order){
		String OrderNumber;	//�ֹ� ��ȣ
		 String userId;		//ID
		 String productName;	//�ֹ� ��ǰ �̸�
		 String orderCount;		//�ֹ� ����
		 String orderTime;	//�ֹ� �ð�
		 String Address;		//�ּ�
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql = "insert into Order values(?,?,?,?,?,?)";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, order.getOrderNumber());
			pstmt.setString(2, order.getUserId());
			pstmt.setString(3, order.getProductName());
			pstmt.setString(4, order.getOrderCount());
			pstmt.setString(5,order.getOrderTime() );
			pstmt.setString(6,order.getAddress() );
			
			return pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		
			fd.close(pstmt,conn);
			
		}
		
		return 0;
		
	}
}
/*
 * 	private String OrderNumber;	//�ֹ� ��ȣ
	private String userId;		//ID
	private String productName;	//�ֹ� ��ǰ �̸�
	private int orderCount;		//�ֹ� ����
	private String orderTime;	//�ֹ� �ð�
	private String Address;		//�ּ�
	public int join(User user){
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql = "insert into userinfo values(?,?,?,?,?)";s
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
 * */
 
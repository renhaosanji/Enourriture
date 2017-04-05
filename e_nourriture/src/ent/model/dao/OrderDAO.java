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
	//주문
	public int purchase(Order order){
		System.out.println("OrderDAO 까지 잘 들어왔어");
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql = "insert into ORDERINFO values(?,order_seq.nextVal,?,?,?,?)";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, order.getUserId());
			pstmt.setString(2, order.getProductName());
			pstmt.setString(3, order.getOrderCount());
			pstmt.setString(4,order.getAddress());
			pstmt.setString(5,order.getOrderTime());
			System.out.println("pstmt에 값넣고 있어 ");
			return pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		
			fd.close(pstmt,conn);
			
		}	
		return 0;
	}
	public int cancellation(String orderNumber, String userId){
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=getConnection();
			String sql = "delete ORDERINFO where OrderNumber=? and userId=?";
			pstmt = conn.prepareStatement(sql); 
			pstmt.setString(1, orderNumber);	
			pstmt.setString(2, userId);	
			return pstmt.executeUpdate();  
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {	
			fd.close(pstmt,conn);
		}	
		return 0;
	}
}

 
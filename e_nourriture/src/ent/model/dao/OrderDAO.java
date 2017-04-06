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
	public ArrayList<Order> purchaseInfo(String userId){
		System.out.println("purchaseInfo 까지 잘 들어왔어 ");
		ArrayList<Order> list = new ArrayList<Order>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		Order order=null;
		String sql = "select * from  ORDERINFO where userId=?";
		try {
			
			
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				order = new Order();
				order.setUserId(rs.getString(1));
				order.setOrderNumber(rs.getString(2));
				order.setProductName(rs.getString(3));
				order.setOrderCount(rs.getString(4));
				order.setAddress(rs.getString(5));
				order.setOrderTime(rs.getString(6));
				list.add(order);
			}

		} catch (Exception ex) {
			System.out.println("오류 발생 : " + ex);
		} finally {
			fd.close(rs, pstmt, conn);
		}

		return list;
	}
	
	public int cancellation(String orderNumber, String userId){
		System.out.println("cancellation 까지 잘 들어왔어 ");
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
	public int orderChange(Order order){
		System.out.println("OrderDAO 까지 잘 들어왔어");
		Connection conn=null;
		PreparedStatement pstmt=null;
		System.out.println(order.getUserId());
		System.out.println(order.getProductName());
		System.out.println(order.getOrderCount());
		System.out.println(order.getOrderTime());
	
		String sql = "update ORDERINFO set ProductionName = ?, orderCount = ?, orderTime=? where userId ='"+order.getUserId()+"' and orderNumber ='"+order.getOrderNumber();
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, order.getProductName());
			pstmt.setString(2, order.getOrderCount());
			pstmt.setString(3,order.getOrderTime());
			System.out.println("pstmt에 값넣고 있어 ");
			return pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		
			fd.close(pstmt,conn);
			
		}	
		return 0;
	}
}

 
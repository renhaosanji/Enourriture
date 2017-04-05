package ent.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import ent.model.dto.Contents;
import ent.model.dto.ProductInfo;

public class ProductInfoDAO {
	
private FactoryDAO fd = new FactoryDAO();
	
	public ProductInfoDAO(){
		
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

	
	// 1. ±Û µî·Ï
	
	public int inputProductInfo(ProductInfo productInfo){
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql = "insert into contentsinfodb values(?,?,?,?,?,?,?)";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, productInfo.getUserId());
			pstmt.setString(2, productInfo.getProductName());
			pstmt.setString(3, productInfo.getProductPrice());
			pstmt.setString(4, productInfo.getProductStore());
			pstmt.setString(5, productInfo.getProductStoreAddr());
			pstmt.setInt(6, productInfo.getEvaluation());
			pstmt.setInt(7, productInfo.getContentsId());
			
			
			return pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		
			fd.close(pstmt,conn);
			
		}
		
		return 0;
		
	}

}

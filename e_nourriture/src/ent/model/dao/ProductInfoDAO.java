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

	
	// 1. 글 등록
	
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
	
	// 글 변경
	public int updateProductInfo(ProductInfo productInfo){
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql = "update contentsinfodb set productionname=?, productionprice=?, sellername=?, selleraddress=?,evaluation=? where contentsid=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, productInfo.getProductName());
			pstmt.setString(2, productInfo.getProductPrice());
			pstmt.setString(3, productInfo.getProductStore());
			pstmt.setString(4, productInfo.getProductStoreAddr());
			pstmt.setInt(5, productInfo.getEvaluation());
			pstmt.setInt(6, productInfo.getContentsId());
			
			
			return pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		
			fd.close(pstmt,conn);
			
		}
		
		return 0;
		
	}

}

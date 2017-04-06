package ent.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ent.model.dto.Contents;
import ent.model.dto.ProductInfo;

public class ContentsDAO {
	
	private FactoryDAO fd = new FactoryDAO();
	
	public ContentsDAO(){
		
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
	// 0. 글 아이디 찾기
	
	public int findID(Contents contents){

		Connection conn=null;
		Statement stmt=null;
		System.out.println(contents.getUserId()+","+contents.getWriteDate());
		String sql = "select contentsid from usercontents where userid='"+contents.getUserId()+"' AND times='"+contents.getWriteDate()+"'";
		ResultSet rs =null;
		int contentsid=0;
		try {
			conn = getConnection();
			stmt = getStatement(conn);
			rs = stmt.executeQuery(sql);
			
			if(rs.next()){
				contentsid = rs.getInt(1);
			}
			if(contentsid==0){
				return -1;
			} 
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return contentsid;
		
	}
	
	// 1. 글 등록
	
	public int inputContents(Contents contents){
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql = "insert into usercontents(contentsid,userid,text,imgurl,times,contentslikecount) values(contentsId_seq.nextVal,?,?,?,?,?)";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, contents.getUserId());
			pstmt.setString(2, contents.getContents());
			pstmt.setString(3, contents.getImgURL());
			pstmt.setString(4, contents.getWriteDate());
			pstmt.setInt(5, 0);
			
			return pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		
			fd.close(pstmt,conn);
			
		}
		
		return 0;
		
	}
	
	public int updateContents(Contents contents){
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql = "update usercontents set text=?. imgurl=?, times=? where contentsid='"+contents.getContentId()+"'";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, contents.getContents());
			pstmt.setString(2, contents.getImgURL());
			pstmt.setString(3, contents.getWriteDate());
			
			return pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		
			fd.close(pstmt,conn);
			
		}
		
		return 0;
		
	}
	
	// 2. 내 글 조회
	public ArrayList<Contents> myContents(String userid){
		ArrayList<Contents> list = new ArrayList<Contents>();
		
		Connection conn=null;
		Statement stmt=null;
		Statement stmt2=null;
		
		String sql = "select contentsid, text, imgurl,times, contentslikecount from usercontents where userid='"+userid+"'";
		String sql_product = "select productionname,productionprice,sellername,selleraddress,evaluation from contentsinfodb where contentsid=";
		ResultSet rs =null;
		ResultSet rs_product=null;
		int contentsid=0;
		String text=null;
		String imgurl=null;
		String times=null;
		int contentslikecount=0;
		try {
			conn = getConnection();
			stmt = getStatement(conn);
			stmt2 = getStatement(conn);
			rs = stmt.executeQuery(sql);
			System.out.println(rs.next());
			while(rs.next()){
				contentsid = rs.getInt(1);
				text=rs.getString(2);
				imgurl=rs.getString(3);
				times=rs.getString(4);
				contentslikecount = rs.getInt(5);
				System.out.println(contentsid+","+text+","+imgurl+","+times+","+contentslikecount);
				Contents contents = new Contents();
				contents.setContentId(contentsid+"");
				contents.setContents(text);
				contents.setImgURL(imgurl);
				contents.setWriteDate(times);
				contents.setContentsLikeCount(contentslikecount);
				System.out.println(contents.toString());
				
				rs_product = stmt2.executeQuery(sql_product+contentsid);
				if(rs_product.next()){
					String productionName = rs_product.getString(1);
					String productionprice = rs_product.getString(2);
					String sellername = rs_product.getString(3);
					String selleraddress = rs_product.getString(4);
					int evaluation = rs_product.getInt(5);
					ProductInfo productInfo = new ProductInfo();
					productInfo.setProductName(productionName);
					productInfo.setProductPrice(productionprice);
					productInfo.setProductStore(sellername);
					productInfo.setProductStoreAddr(selleraddress);
					productInfo.setEvaluation(evaluation);
					System.out.println(productInfo.toString());
					contents.setProductInfo(productInfo);
				}
				list.add(contents);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
		
	}
	
public ArrayList<Contents> getList(String userid){
		
		ArrayList<Contents> list = new ArrayList<Contents>();
		
		Connection conn=null;
		Statement stmt=null;
		Statement stmt2=null;
		
		String sql = "select userid,contentsid,text,imgurl from usercontents where userid!='"+userid+"' order by times desc, contentslikecount desc";
		ResultSet rs =null;
		ResultSet rs_product=null;
		String usersid=null;
		String text=null;
		String imgurl=null;
		String times=null;
		int contentsid=0;
		try {
			conn = getConnection();
			stmt = getStatement(conn);
			stmt2 = getStatement(conn);
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				usersid=rs.getString(1);
				contentsid=rs.getInt(2);
				text=rs.getString(3);
				imgurl=rs.getString(4);
				Contents contents = new Contents();
				contents.setUserId(usersid);
				contents.setContentId(contentsid+"");
				contents.setContents(text);
				contents.setImgURL(imgurl);
			
				list.add(contents);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

public Contents getContents(String contentsId){
	
	Connection conn=null;
	Statement stmt=null;
	Statement stmt2=null;
	
	String sql = "select * from usercontents where contentsid="+contentsId;
	String sql_product = "select productionname,productionprice,sellername,selleraddress,evaluation from contentsinfodb where contentsid="+contentsId;
	ResultSet rs =null;
	ResultSet rs_product=null;
	String userid=null;
	String text=null;
	String imgurl=null;
	String times=null;
	int contentslikecount=0;
	try {
		conn = getConnection();
		stmt = getStatement(conn);
		stmt2 = getStatement(conn);
		rs = stmt.executeQuery(sql);
		
		Contents contents = new Contents();
		while(rs.next()){
			userid = rs.getString(1);
			text=rs.getString(3);
			imgurl=rs.getString(4);
			times=rs.getString(5);
			contentslikecount = rs.getInt(6);
			System.out.println(userid+","+text+","+imgurl+","+times+","+contentslikecount);
			
			contents.setContentId(contentsId);
			contents.setContents(text);
			contents.setImgURL(imgurl);
			contents.setWriteDate(times);
			contents.setContentsLikeCount(contentslikecount);
			System.out.println(contents.toString());
			
			rs_product = stmt2.executeQuery(sql_product);
			if(rs_product.next()){
				String productionName = rs_product.getString(1);
				String productionprice = rs_product.getString(2);
				String sellername = rs_product.getString(3);
				String selleraddress = rs_product.getString(4);
				int evaluation = rs_product.getInt(5);
				ProductInfo productInfo = new ProductInfo();
				productInfo.setProductName(productionName);
				productInfo.setProductPrice(productionprice);
				productInfo.setProductStore(sellername);
				productInfo.setProductStoreAddr(selleraddress);
				productInfo.setEvaluation(evaluation);
				System.out.println(productInfo.toString());
				contents.setProductInfo(productInfo);
			}
			
		}
		return contents;
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	return null;
}

}

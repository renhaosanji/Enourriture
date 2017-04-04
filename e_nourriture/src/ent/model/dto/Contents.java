package ent.model.dto;

import java.util.ArrayList;

public class Contents {
	private String ContentsId;			//index
	private String userId;				//writer
	private String name;				//name
	private String contents;			//내용
	private String writeDate;			//작성 시간
	private String imgURL;				//이미지 URL
	private int contentsLikeCount; 			//좋아요
	private ArrayList<Communication> communication;	//댓글
	private ProductInfo productInfo;		//상품 정보
	
	public String getContentsId() {
		return ContentsId;
	}
	public void setContentsId(String contentsId) {
		ContentsId = contentsId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}
	public String getImgURL() {
		return imgURL;
	}
	public void setImgURL(String imgURL) {
		this.imgURL = imgURL;
	}
	public int getContentsLikeCount() {
		return contentsLikeCount;
	}
	public void setContentsLikeCount(int contentsLikeCount) {
		this.contentsLikeCount = contentsLikeCount;
	}
	public ArrayList<Communication> getCommunication() {
		return communication;
	}
	public void setCommunication(ArrayList<Communication> communication) {
		this.communication = communication;
	}
	public ProductInfo getProductInfo() {
		return productInfo;
	}
	public void setProductInfo(ProductInfo productInfo) {
		this.productInfo = productInfo;
	}
	
	
}

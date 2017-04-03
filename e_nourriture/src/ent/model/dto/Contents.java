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
}

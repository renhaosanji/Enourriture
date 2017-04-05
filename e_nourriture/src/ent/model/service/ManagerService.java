package ent.model.service;

import ent.model.dao.ContentsDAO;
import ent.model.dao.ProductInfoDAO;
import ent.model.dto.Contents;
import ent.model.dto.ProductInfo;

public class ManagerService {
	
	private ContentsDAO content;
	private ProductInfoDAO product;
	
	public ManagerService(){
		content = new ContentsDAO();
		product = new ProductInfoDAO();
		
	}
	
	//0. 글 아이디 찾기
	public int findID(Contents contents){
		return content.findID(contents);
	}
	
	//1. 글 등록(글)
	public int inputContents(Contents contents){
		return content.inputContents(contents);
	}
	
	//1-2. 글 등록(상품)
	public int inputProductInfo(ProductInfo productInfo){
		return product.inputProductInfo(productInfo);
	}
	
}

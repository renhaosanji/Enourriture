package ent.model.service;

import java.util.ArrayList;

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
	
	//0. �� ���̵� ã��
	public int findID(Contents contents){
		return content.findID(contents);
	}
	
	//1. �� ���(��)
	public int inputContents(Contents contents){
		return content.inputContents(contents);
	}
	
	//1-2. �� ���(��ǰ)
	public int inputProductInfo(ProductInfo productInfo){
		return product.inputProductInfo(productInfo);
	}
	
	public int updateContents(Contents contents){
		return content.updateContents(contents);
	}
	
	public int updateProductInfo(ProductInfo productInfo){
		return product.updateProductInfo(productInfo);
	}
	
	
	
	//2. �� �۵� ��ȸ
	public ArrayList<Contents> myContents(String userid){
		return content.myContents(userid);
	}
	
	
	
}

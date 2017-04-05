package ent.model.dto;

public class ProductInfo {
	private int contentsId;		//index
	private String userId;			//userId
	private String productName;		//물품 이름
	private String productPrice;		//물품 가격
	private String productStore;		//물품 상점
	private String ProductStoreAddr;	//상점 주소
	private int evaluation;			//펑점
	
	public ProductInfo() {
		
	}
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}



	public int getContentsId() {
		return contentsId;
	}

	public void setContentsId(int contentsId) {
		this.contentsId = contentsId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductStore() {
		return productStore;
	}

	public void setProductStore(String productStore) {
		this.productStore = productStore;
	}

	public String getProductStoreAddr() {
		return ProductStoreAddr;
	}

	public void setProductStoreAddr(String productStoreAddr) {
		ProductStoreAddr = productStoreAddr;
	}

	public int getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(int evaluation) {
		this.evaluation = evaluation;
	}

	@Override
	public String toString() {
		return "ProductInfo [contentsId=" + contentsId + ", userId=" + userId + ", productName=" + productName
				+ ", productPrice=" + productPrice + ", productStore=" + productStore + ", ProductStoreAddr="
				+ ProductStoreAddr + ", evaluation=" + evaluation + "]";
	}
	
	
	
	
	
}

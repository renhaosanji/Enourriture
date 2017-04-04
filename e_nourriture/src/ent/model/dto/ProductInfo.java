package ent.model.dto;

public class ProductInfo {
	private String contentsId;		//index
	private String productName;		//물품 이름
	private String productPrice;		//물품 가격
	private String productStore;		//물품 상점
	private String ProductStoreAddr;	//상점 주소
	private int evaluation;			//펑점
	
	public ProductInfo() {
		super();
	}

	public String getContentsId() {
		return contentsId;
	}

	public void setContentsId(String contentsId) {
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
	
	
}

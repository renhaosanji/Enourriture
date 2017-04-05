package ent.model.dto;

public class Order {
	private String orderNumber;	//주문 번호
	private String userId;		//ID
	private String productName;	//주문 물품 이름
	private String orderCount;		//주문 수량
	private String orderTime;	//주문 시간
	private String address;		//주소
	
	public Order() {
		
	}

	public Order(String orderNumber, String userId) {
		super();
		this.orderNumber = orderNumber;
		this.userId = userId;
	}

	public Order( String userId, String productName, String orderCount, String orderTime,
			String address) {
		super();
		
		this.userId = userId;
		this.productName = productName;
		this.orderCount = orderCount;
		this.orderTime = orderTime;
		this.address = address;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getOrderCount() {
		return orderCount;
	}

	public void setOrderCount(String orderCount) {
		this.orderCount = orderCount;
	}

	public String getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	
	
	
}

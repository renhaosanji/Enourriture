package ent.model.dto;

public class Order {
	private String OrderNumber;	//주문 번호
	private String userId;		//ID
	private String productName;	//주문 물품 이름
	private int orderCount;		//주문 수량
	private String orderTime;	//주문 시간
	private String Address;		//주소
	
	public Order() {
		
	}

	public String getOrderNumber() {
		return OrderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		OrderNumber = orderNumber;
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

	public int getOrderCount() {
		return orderCount;
	}

	public void setOrderCount(int orderCount) {
		this.orderCount = orderCount;
	}

	public String getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}
	
	
	
	
}

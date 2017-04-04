package ent.model.dto;

public class Order {
	private String OrderNumber;	//주문 번호
	private String userId;		//ID
	private String productName;	//주문 물품 이름
	private String orderCount;		//주문 수량
	private String orderTime;	//주문 시간
	private String Address;		//주소
	
	public Order() {
		
	}

	public Order(String OrderNumber, String userId, String productName, String orderCount, String orderTime,
			String Address) {
		super();
		this.OrderNumber = OrderNumber;
		this.userId = userId;
		this.productName = productName;
		this.orderCount = orderCount;
		this.orderTime = orderTime;
		this.Address = Address;
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
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}
	
	
	
	
}

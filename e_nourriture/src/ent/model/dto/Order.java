package ent.model.dto;

public class Order {
	private String OrderNumber;	//�ֹ� ��ȣ
	private String userId;		//ID
	private String productName;	//�ֹ� ��ǰ �̸�
	private String orderCount;		//�ֹ� ����
	private String orderTime;	//�ֹ� �ð�
	private String Address;		//�ּ�
	
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

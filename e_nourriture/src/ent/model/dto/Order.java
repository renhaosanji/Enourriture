package ent.model.dto;

public class Order {
	private String orderNumber;	//�ֹ� ��ȣ
	private String userId;		//ID
	private String productName;	//�ֹ� ��ǰ �̸�
	private String orderCount;		//�ֹ� ����
	private String orderTime;	//�ֹ� �ð�
	private String address;		//�ּ�
	
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

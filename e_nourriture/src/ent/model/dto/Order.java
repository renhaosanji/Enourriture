package ent.model.dto;

public class Order {
	private String OrderNumber;	//�ֹ� ��ȣ
	private String userId;		//ID
	private String productName;	//�ֹ� ��ǰ �̸�
	private int orderCount;		//�ֹ� ����
	private String orderTime;	//�ֹ� �ð�
	private String Address;		//�ּ�
	
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

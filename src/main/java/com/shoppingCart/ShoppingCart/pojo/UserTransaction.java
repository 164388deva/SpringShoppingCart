package com.shoppingCart.ShoppingCart.pojo;

public class UserTransaction {
	private int userId ;
	private int productId ;
	private String productName ;
	private double price ;
	private int quantity;
	private double total;
	
	public UserTransaction(int userId, int productId, String productName,
			double price, int quantity) {
		super();
		this.userId = userId;
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
		this.total=price*quantity;

	}
	
	
	@Override
	public String toString() {
		return "UserTransaction [userId=" + userId + ", productId=" + productId
				+ ", productName=" + productName + ", price=" + price
				+ ", quantity=" + quantity + ", total=" + total
				 + "]";
	}
	public UserTransaction() {
		// TODO Auto-generated constructor stub
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}

}

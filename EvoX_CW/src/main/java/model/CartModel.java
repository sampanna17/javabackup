package model;

public class CartModel {
	private String userId;
	private String product_name;
	
	public CartModel( String userId, String product_name) {
		this.userId = userId;
		this.product_name = product_name;
	}
	
	public String getStudentID() {
		return userId;
	}
	public void setStudentID(String userId) {
		this.userId = userId;
	}
	
	
	public String getItemName() {
		return product_name;
	}
	public void setItemName(String product_name) {
		this.product_name = product_name;
	}
}

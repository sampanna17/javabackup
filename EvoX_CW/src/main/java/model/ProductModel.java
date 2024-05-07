package model;

public class ProductModel {
	private String productName;
	private String discription;
	private String price;
	private String path;
	private String category;
	private String stock;

	
	public ProductModel(String productName, String discription, String category, String price, String stock, String path) {
		this.productName = productName;
		this.discription = discription;
		this.price = price;
		this.path = path;
		this.category = category;
		this.stock = stock;
	}
	
	public String getProductName() {
		return productName;
	}
	
	public String getDiscription() {
		return discription;
	}
	
	public String getPrice() {
		return price;
	}
	
	public String getPath() {
		return path;
	}
	
	public String getCategory() {
		return category;
	}
	
	public String getStock() {
		return stock;
	}
	
}

package ingsw.pdd.factorymethod.entity;

public class Product {
	
	private long idproduct;
	private String productName;
	private double price;
	
	public Product(Long idproduct,String productName,double price) {
		this.idproduct=idproduct;
		this.price=price;
		this.productName=productName;
		
	}

	
	public long getIdproduct() {
		return idproduct;
	}


	public void setIdproduct(long idproduct) {
		this.idproduct = idproduct;
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


	@Override
	public String toString() {
		return "Product [idproduct=" + idproduct + ", productName=" + productName + ", price=" + price + "]";
	}
	
	
	
}

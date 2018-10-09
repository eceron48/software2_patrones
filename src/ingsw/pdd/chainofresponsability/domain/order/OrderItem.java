package ingsw.pdd.chainofresponsability.domain.order;

import ingsw.pdd.chainofresponsability.domain.Product;

public class OrderItem {

	private Product product;
	private double price;
	private float quantity;
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public float getQuantity() {
		return quantity;
	}
	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}
	

		
		 public double getTotal(){
		 return price*quantity;
		 }

	
}

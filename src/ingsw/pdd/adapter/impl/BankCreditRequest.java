package ingsw.pdd.adapter.impl;

public class BankCreditRequest {
	private String customer;
	private double amount;
	public String leerCustomer() {
		return customer;
	}
	public void darCustomer(String customer) {
		this.customer = customer;
	}
	public double leerAmount() {
		return amount;
	}
	public void dartAmount(double amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "BankCreditRequest [customer=" + customer + ", amount=" + amount + "]";
	}
	
	

}

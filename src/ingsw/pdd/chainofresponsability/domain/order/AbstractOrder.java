package ingsw.pdd.chainofresponsability.domain.order;

import java.util.Calendar;
import java.util.List;

import ingsw.pdd.chainofresponsability.domain.Contributor;

public abstract class AbstractOrder {

	private Calendar createDate;
	 private Contributor contributor;
	 private List<OrderItem> orderItems;
	
	 public Calendar getCreateDate() {
	 return createDate;
	 }
	
	public double getTotal(){
	 double total = 0d;
	 for (OrderItem abstractOrderItem : orderItems) {
	 total+=abstractOrderItem.getTotal();
	 }
	 return total;
	 }

	public Contributor getContributor() {
		return contributor;
	}

	public void setContributor(Contributor contributor) {
		this.contributor = contributor;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public void setCreateDate(Calendar createDate) {
		this.createDate = createDate;
	}
	
	
}

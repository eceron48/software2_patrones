package ingsw.pdd.chainofresponsability;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import java.util.*;
 import ingsw.pdd.chainofresponsability.domain.*;
 import ingsw.pdd.chainofresponsability.domain.order.*;
 import ingsw.pdd.chainofresponsability.validator.*;

public class ChainOfResponsabilityMain {

	public static void main(String[] args) {
		SalesORder salesOrder = new SalesORder();
		 salesOrder.setDeliveryDate(Calendar.getInstance());
		 Customer customer = new Customer();
		 customer.setName("Pepe Perez");
		customer.setRfc("XXX0000000X0");
		 customer.setStatus(Status.ACTIVO);
		
		Telephone phone = new Telephone();
		 phone.setExt("123");
		 phone.setLada("999");
		 phone.setNumber("1234567");
		 customer.setTelephone(phone);
		
		 Address address = new Address();
		 address.setAddress1("Address 1");
		 address.setAddress2("Address 2");
		 address.setCP("1234");
		 address.setCountry("Colombia");
		 customer.setAddress(address);
		
		 CreditData creditData = new CreditData();
		 creditData.setBalance(1000);
		 creditData.setCreditLimit(13000);
		 customer.setCreditData(creditData);
		
		 salesOrder.setContributor(customer);
		
		 List<OrderItem> orderItems = new ArrayList<OrderItem>();
		 for (int c = 0; c < 10; c++) {
		 OrderItem item = new OrderItem();
		
		item.setPrice((c + 1) * 30);  Product product = new Product();
		
		product.setListPrice((c + 1) * 32);  product.setName("Product " + (c + 1));
		
		item.setProduct(product);  item.setQuantity(c + 1);
		
		orderItems.add(item);  }
		
		salesOrder.setOrderItems(orderItems);  System.out.println("Total orden > " + salesOrder.getTotal());
		
		try {  AsbtractOrderValidator validator
		
		= OrderValidatorBuilder.buildSalesOrderValidator();  validator.validate(salesOrder);
		
		System.out.println("Validaci�n exitosa");  } catch (Exception e) {
		
		System.err.println(e.getMessage());  e.printStackTrace();
		
		}

	}

}

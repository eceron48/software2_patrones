package ingsw.pdd.abstractfactory.ws;

import ingsw.pdd.abstractfactory.service.IProductsService;

public class ProductServiceWSImp implements IProductsService {

	private static final String[] PRODUCTS = new String[]{"Refresco", "Jugo", "Fruta"};
	public String[] getProducts() {
		 System.out.println("WebServices");
		 return PRODUCTS;
		 }
}

package ingsw.pdd.factorymethod.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ingsw.pdd.factorymethod.DBFactory;
import ingsw.pdd.factorymethod.IDBAdapter;
import ingsw.pdd.factorymethod.entity.Product;

public class ProductDAO {
	private IDBAdapter dbAdapter;

	 public ProductDAO(){
	 dbAdapter = DBFactory.getDefaultDBAdapter();
	 }
	
 public List<Product> findAllProducts() throws SQLException{
	 Connection connection = dbAdapter.getConnection();
	 List<Product> productList = new ArrayList<>();

	try {  PreparedStatement statement = connection.
	
	prepareStatement("SELECT idproductos,nombreproducto," 
	+ "precioproducto FROM productos");

	ResultSet results = statement.executeQuery();  while(results.next()){
	
	productList.add(new Product(results.getLong(1),  results.getString(2), results.getDouble(3)));

	}  return productList;
	
	} catch (Exception e) {e.printStackTrace();

	return null;  }finally{
	
	try { connection.close();
	
	} catch (Exception e) {}  }

	} 
	
	public boolean saveProduct(Product product) throws SQLException{  
		Connection connection = dbAdapter.getConnection();

	try {  PreparedStatement statement = connection.

			prepareStatement("INSERT INTO productos(idproductos,"  + "nombreproducto, precioproducto) VALUES (?,?,?)");
	
	statement.setLong(1, product.getIdproduct()); statement.setString(2, product.getProductName());
	
	statement.setDouble(3, product.getPrice());  statement.executeUpdate();
	
	return true; } catch (Exception e) {
	
	e.printStackTrace();  return false;
	
	}finally{ try {

	connection.close();  } catch (Exception e) {}
	
	}  }

}

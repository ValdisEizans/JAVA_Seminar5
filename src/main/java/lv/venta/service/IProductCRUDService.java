package lv.venta.service;

import java.util.ArrayList;

import lv.venta.model.Product;
import lv.venta.model.ProductType;

public interface IProductCRUDService {
	//CRUD - create retrieve update delete
	//Create
	public abstract void createNewProduct(String title, float price, int quantity, String description, ProductType type) throws Exception;

	//Retrieve all
	public abstract ArrayList<Product> retrieveAll() throws Exception;
	
	//Retrieve by id
	public abstract Product retrieveProductById(long id) throws Exception;
	
	//Update
	public abstract void updateProductById(long id, String title, float price, int quantity, String description, ProductType type) throws Exception;
	
	//Delete
	public abstract void deleteProductById(long id) throws Exception;
}

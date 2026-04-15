package lv.venta.service.impl;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.model.Product;
import lv.venta.model.ProductType;
import lv.venta.repo.IProductRepo;
import lv.venta.service.IProductCRUDService;

@Service
public class ProductCRUDServiceImpl implements IProductCRUDService{
	
	@Autowired
	private IProductRepo prodRepo;

	@Override
	public void createNewProduct(String title, float price, int quantity, String description, ProductType type)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Product> retrieveAll() throws Exception {
		if(prodRepo.count() == 0) {
			throw new Exception("Produktu tabula DB ir tuksa!");
		}
		ArrayList<Product> allProductsFromDb = (ArrayList<Product>) prodRepo.findAll();
		return allProductsFromDb;
	}

	@Override
	public Product retrieveProductById(long id) throws Exception {
		//parbauda vai nav negativs
		if(id <= 0) {
			throw new Exception("Produktu Id nedrikst but negativs vai nulle!");
		}
		//parbauda vai ir tads id (existsById)
		if(!prodRepo.existsById(id)) {
			throw new Exception("Produkts ar sadu Id neeksiste!");
		}
		//ja ir, tad no DB iegust produktu
		Product ProductFromDb = prodRepo.findById(id).get();
		
		return ProductFromDb;
	}

	@Override
	public void updateProductById(long id, String title, float price, int quantity, String description,
			ProductType type) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteProductById(long id) throws Exception {
		Product ProductFromDb = retrieveProductById(id);
		prodRepo.delete(ProductFromDb);		
	}
}

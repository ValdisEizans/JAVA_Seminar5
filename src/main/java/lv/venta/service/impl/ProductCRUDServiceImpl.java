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
		if(title == null || !title.matches("[A-Z]{1}[a-z ]{2,30}") || price < 0 || price > 1000 || quantity < 0 || quantity > 100 ||  description == null || description.matches("[A-Z]{1}[A-Za-z0-9,. ]{2,150}") || type == null) {
			throw new Exception("Nekorekti ievades dati!");
		}
		//ja tads produkts jau eksiste, papildina krajumus
		if(prodRepo.existsByTitleAndPriceAndDescriptionAndProductType(title, price, description, type)) {
			Product productFromDB = prodRepo.findByTitleAndPriceAndDescriptionAndProductType(title, price, description, type);
			int newQantity = productFromDB.getQuantity() + quantity;
			productFromDB.setQuantity(newQantity);
			prodRepo.save(productFromDB);//izpildas UPDATE
		}
		else {
			Product newProduct = new Product(title, price, quantity, description, type);
			prodRepo.save(newProduct);//izpildas INSERT
		}
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
		//parbauda vai produkts eksiste
		Product ProductFromDb = retrieveProductById(id);

		if(title == null || !title.matches("[A-Z]{1}[a-z ]{2,30}") || price < 0 || price > 1000 || quantity < 0 || quantity > 100 ||  description == null || description.matches("[A-Z]{1}[A-Za-z0-9,. ]{2,150}") || type == null) {
			throw new Exception("Nekorekti ievades dati!");
		}
		if(!ProductFromDb.getTitle().equals(title)) {
			ProductFromDb.setTitle(title);
		}
		if (ProductFromDb.getPrice() != price) {
			ProductFromDb.setPrice(price);
			
		}
		if(ProductFromDb.getQuantity() != quantity) {
			ProductFromDb.setQuantity(quantity);
		}
		if(!ProductFromDb.getDescription().equals(description)) {
			ProductFromDb.setDescription(description);
		}
		if(ProductFromDb.getProductType().equals(type)) {
			ProductFromDb.setProductType(type);
		}
		
		prodRepo.save(ProductFromDb);
		
	}

	@Override
	public void deleteProductById(long id) throws Exception {
		Product ProductFromDb = retrieveProductById(id);
		prodRepo.delete(ProductFromDb);		
	}
}

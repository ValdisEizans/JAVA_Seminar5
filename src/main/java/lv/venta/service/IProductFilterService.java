package lv.venta.service;

import java.util.ArrayList;

import lv.venta.model.Product;
import lv.venta.model.ProductType;

public interface IProductFilterService {
	//filtre productus pec cenas slieksna
	public abstract ArrayList<Product> retrieveProductByPriceLessThan(float threshold) throws Exception;

	//filtre productus pec tipa
	public abstract ArrayList<Product> retrieveProductByProductType(ProductType type) throws Exception;
	
	//filtre productus pec atslegas varda
	public abstract ArrayList<Product> retrieveProductByKeyWord(String keyword) throws Exception;

	//aprekina videjo cenu visiem produktiem
	public abstract float calculateAveragePrice() throws Exception;
	
}

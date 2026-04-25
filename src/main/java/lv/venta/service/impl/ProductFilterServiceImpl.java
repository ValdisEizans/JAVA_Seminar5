package lv.venta.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.model.Product;
import lv.venta.model.ProductType;
import lv.venta.repo.IProductRepo;
import lv.venta.service.IProductFilterService;

@Service
public class ProductFilterServiceImpl implements IProductFilterService {
	
	@Autowired
	private IProductRepo prodRepo;
	
	@Override
	public ArrayList<Product> retrieveProductByPriceLessThan(float threshold) throws Exception{
		//parbauda vai nav negativs
		if(threshold <= 0) {
			throw new Exception("Ievadita cena nedrikst but negativa vai nulle!");
		}
		
		ArrayList<Product> result = prodRepo.findByPriceLessThan(threshold);
		
		if(result.isEmpty()) {
			throw new Exception("Sistema nav produktu ar sadu cenu!");
		}
		
		return result;
	}

	@Override
	public ArrayList<Product> retrieveProductByProductType(ProductType type) throws Exception {
		if(type == null) {
			throw new Exception("Nav noradits produkta tips!");
		}
		ArrayList<Product> result = prodRepo.findByProductType(type);

		if(result.isEmpty()) {
			throw new Exception("Sistema nav produktu ar sadu produkta tipu!");
		}
		
		return result;
	}

	@Override
	public ArrayList<Product> retrieveProductByKeyWord(String keyword) throws Exception {
		if(keyword == null || keyword.isEmpty()) {
			throw new Exception("Nav noradits atslegas vards!");
		}
		ArrayList<Product> result = prodRepo.findByTitleContainingOrDescriptionContaining(keyword,keyword);

		if(result.isEmpty()) {
			throw new Exception("Sistema nav produktu ar sadu produkta tipu!");
		}
		
		return result;
	}

	@Override
	public float calculateAveragePrice() throws Exception {
		if(prodRepo.count() == 0) {
			throw new Exception("DB nav produktu, nevar aprekinat videjo cenu!");
		}

		float result = prodRepo.calculateAvgPriceFromDb();
		
		
		return result;
	}


}

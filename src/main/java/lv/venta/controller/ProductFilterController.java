package lv.venta.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lv.venta.model.Product;
import lv.venta.model.ProductType;
import lv.venta.service.IProductFilterService;

@Controller
@RequestMapping("/product/filter")
public class ProductFilterController {

	@Autowired
	private IProductFilterService prodFilterService;
	
	@GetMapping("/price/{threshold}")//localhost:8080/product/filter/price/5
	public String getFilterProductsByPrice(@PathVariable(name = "threshold") float threshold, Model model) {
		try {
			ArrayList<Product> productFromDB = prodFilterService.retrieveProductByPriceLessThan(threshold);
			model.addAttribute("package", productFromDB);
			model.addAttribute("header", "Produkti, kuru cena mazaka par " + threshold + " eur");
			return "show-all-products-page";
		}
		catch (Exception e) {
			model.addAttribute("package", e.getMessage());
			return "error-page";
		}
	}

	@GetMapping("/type/{type}")//localhost:8080/product/filter/type/fruit
	public String getFilterProductsByType(@PathVariable(name = "type") ProductType type, Model model) {
		try {
			ArrayList<Product> productFromDB = prodFilterService.retrieveProductByProductType(type);
			model.addAttribute("package", productFromDB);
			model.addAttribute("header", "Produkti, kuru tips ir:");
			return "show-all-products-page";
		}
		catch (Exception e) {
			model.addAttribute("package", e.getMessage());
			return "error-page";
		}
	}
	
	@GetMapping("/keyword/{keyword}")//localhost:8080/product/filter/keyword/ban
	public String getFilterProductsByType(@PathVariable(name = "keyword") String keyword, Model model) {
		try {
			ArrayList<Product> productFromDB = prodFilterService.retrieveProductByKeyWord(keyword);
			model.addAttribute("package", productFromDB);
			model.addAttribute("header", "Produkti, kuru nosaukums vai apraksts satur " + keyword);
			return "show-all-products-page";
		}
		catch (Exception e) {
			model.addAttribute("package", e.getMessage());
			return "error-page";
		}
	}

	@GetMapping("/avg_price")//localhost:8080/product/filter/avg_price
	public String getAveragePrice(Model model) {
		try {
			model.addAttribute("package", prodFilterService.calculateAveragePrice());
			model.addAttribute("header", "Visu veikala produktu videja cena:");
			return "average-price-page";
		}
		catch (Exception e) {
			model.addAttribute("package", e.getMessage());
			return "error-page";
		}
	}
}

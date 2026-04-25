package lv.venta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lv.venta.model.Product;
import lv.venta.service.IProductCRUDService;

@Controller
@RequestMapping("/product/crud")
public class ProductCRUDController {
	
	@Autowired
	private IProductCRUDService prodService;
	
	@GetMapping("/all")//localhost:8080/product/crud/all
	public String getAllProducts(Model model) {
		try {
			model.addAttribute("package", prodService.retrieveAll());
			return "show-all-products-page";
		}
		catch (Exception e) {
			model.addAttribute("package", e.getMessage());
			return "error-page";
		}

	}
	
	//pirmais variants ar ? zimi
	@GetMapping("/one")//localhost:8080/product/crud/one?id=2
	public String getOneProductById(@RequestParam(name = "id") long id, Model model) {
		try {
			Product prodFromDB = prodService.retrieveProductById(id);
			model.addAttribute("package", prodFromDB);
			return "show-one-product-page";
		}
		catch (Exception e) {
			model.addAttribute("package", e.getMessage());
			return "error-page";
		}
	}

	
}

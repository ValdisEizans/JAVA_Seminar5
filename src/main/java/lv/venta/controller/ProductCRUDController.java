package lv.venta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lv.venta.model.Product;
import lv.venta.model.ProductType;
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

	//otrais variants ar / zimi
	@GetMapping("/all/{id}")//localhost:8080/product/crud/all/2
	public String getOneProductById2(@PathVariable(name = "id") long id, Model model) {
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
	
	//create
	@GetMapping("/add")//localhost:8080/product/crud/add
	public String getAddNewProduct(Model model) {
		try {
			model.addAttribute("product", new Product());
			return "add-new-product-page";
		}
		catch (Exception e) {
			model.addAttribute("package", e.getMessage());
			return "error-page";
		}
	}
	
	@PostMapping("/add")
	public String postAddNewProduct(Product product, Model model) {
		try {
			prodService.createNewProduct(product.getTitle(), product.getPrice(), product.getQuantity(), product.getDescription(), product.getProductType());
			return "redirect:/product/crud/all";
		}
		catch (Exception e) {
			model.addAttribute("package", e.getMessage());
			return "error-page";
		}
	}
	
	//update
	@GetMapping("/update/{id}")//localhost:8080/product/crud/update/2
	public String getUpdateProductById(@PathVariable(name = "id") long id, Model model) {
		try {
			Product prodFromDB = prodService.retrieveProductById(id);
			model.addAttribute("product", prodFromDB);
			return "update-product-page";
		}
		catch (Exception e) {
			model.addAttribute("package", e.getMessage());
			return "error-page";
		}
	}
	
	@PostMapping("/update/{id}")
	public String postUpdateProductById(@PathVariable(name = "id") long id,Product product,Model model) {
		try {
			prodService.updateProductById(id,product.getTitle(),product.getPrice(), product.getQuantity(), product.getDescription(), product.getProductType());
			return "redirect:/product/crud/all";
		}
		catch (Exception e) {
			model.addAttribute("package", e.getMessage());
			return "error-page";
		}
	}
	
	
	
}

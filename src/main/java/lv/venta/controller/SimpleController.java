package lv.venta.controller;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lv.venta.model.Product;
import lv.venta.model.ProductType;

@Controller
@RequestMapping("/simple")
public class SimpleController {
	
	@GetMapping("/page")//localhost:8080/simple/page
	public String getShowPage() {
		System.out.println("Mans pirmais kontrolieris");
		return "show-page";
	}
	
	@GetMapping("/data")//localhost:8080/simple/data
	public String getDataInPage(Model model) {
		System.out.println("Izpildas datu kontrolieris");
		Random rand = new Random();
		String data = "@Valdis " + rand.nextInt(2010,2026);
		model.addAttribute("package",data);
		return "show-data-page";
	}
	
	@GetMapping("/product")//localhost:8080/simple/product
	public String getProductInPage(Model model) {
		Product prod = new Product("Abols", 0.95f, 5, "Garsigs", ProductType.fruit);
		model.addAttribute("package",prod);
		return "show-one-product-page";
	}

}

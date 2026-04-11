package lv.venta;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lv.venta.model.Product;
import lv.venta.model.ProductType;
import lv.venta.repo.IProductRepo;

@SpringBootApplication
public class JavaSeminar5Application {

	public static void main(String[] args) {
		SpringApplication.run(JavaSeminar5Application.class, args);
	}
	
	@Bean
	public CommandLineRunner testRepo(IProductRepo productRepo) {
		return new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception {
				Product prod1 = new Product("Abols", 6.95f, 5, "Garsigs", ProductType.fruit);
				Product prod2 = new Product("Burkans", 0.99f, 5, "Super", ProductType.vegetable);
				Product prod3 = new Product("Biete", 1.05f, 5, "Negarsigs", ProductType.vegetable);				
				
				productRepo.save(prod1);
				productRepo.save(prod2);
				productRepo.save(prod3);
				
			}
		};
	}

}

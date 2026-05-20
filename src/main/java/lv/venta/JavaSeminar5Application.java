package lv.venta;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import lv.venta.model.MyAuthority;
import lv.venta.model.MyUser;
import lv.venta.model.Product;
import lv.venta.model.ProductType;
import lv.venta.repo.IMyAuthorityRepo;
import lv.venta.repo.IMyUserRepo;
import lv.venta.repo.IProductRepo;

@SpringBootApplication
public class JavaSeminar5Application {

	public static void main(String[] args) {
		SpringApplication.run(JavaSeminar5Application.class, args);
	}
	
	@Bean
	public CommandLineRunner testRepo(IProductRepo productRepo, IMyAuthorityRepo authRepo,
			IMyUserRepo userRepo) {
		return new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception {
				Product prod1 = new Product("Abols", 7.95f, 8, "Garsigs", ProductType.fruit);
				Product prod2 = new Product("Burkans", 0.99f, 3, "Super", ProductType.vegetable);
				Product prod3 = new Product("Biete", 2.55f, 25, "Negarsigs", ProductType.vegetable);				
				Product prod4 = new Product("Kartupeli", 1.05f, 15, "Ir OK", ProductType.vegetable);				
				Product prod5 = new Product("Banani", 10.05f, 28, "Super", ProductType.fruit);				
				Product prod6 = new Product("Tomats", 4.75f, 7, "Importa", ProductType.vegetable);				
				Product prod7 = new Product("Cukini", 8.74f, 3, "Cepamais", ProductType.vegetable);				
				Product prod8 = new Product("Kirsi", 9.15f, 53, "Saldie", ProductType.fruit);				
				
				productRepo.save(prod1);
				productRepo.save(prod2);
				productRepo.save(prod3);
				productRepo.save(prod4);
				productRepo.save(prod5);
				productRepo.save(prod6);
				productRepo.save(prod7);
				productRepo.save(prod8);
				
				MyAuthority auth1 = new MyAuthority("ADMIN");
				MyAuthority auth2 = new MyAuthority("USER");
				authRepo.saveAll(Arrays.asList(auth1, auth2));
				
				PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
				
				MyUser u1 = new MyUser("karina", encoder.encode("123"), auth2);
				MyUser u2 = new MyUser("janis", encoder.encode("321"), auth2);
				MyUser u3 = new MyUser("admin", encoder.encode("987"), auth1);
				
				userRepo.saveAll(Arrays.asList(u1,u2,u3));
				
				
			}
		};
	}

}

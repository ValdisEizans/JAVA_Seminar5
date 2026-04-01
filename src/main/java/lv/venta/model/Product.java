package lv.venta.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Product {
	//@Setter(value = AccessLevel.NONE)
	//Mainigie
	private long id;
	private String title; 
	private float price;
	private int quantity;
	private String description;
	private ProductType productType;
	
	private static long counter = 0;
	
	//No Maven repository pom faila pieviento Lombok

	//Geteri - nak no Lombok
	//Seteri -  nak no Lombok
	//Bezaurgumenta konstruktors -  nak no Lombok
	
	//Argumenta konstruktori -  nak no Lombok
	public Product(String inputTitle, float inputPrice, int inputQuantity, String inputDescription, ProductType inputProductType ) {
		setTitle(inputTitle);
		setDescription(inputDescription);
		setPrice(inputPrice);
		setQuantity(inputQuantity);
		setProductType(inputProductType);
	}
	//toString

}

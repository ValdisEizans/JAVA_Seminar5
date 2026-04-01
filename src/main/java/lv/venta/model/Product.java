package lv.venta.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Getter
//@Setter
//@NoArgsConstructor
//ToString
public class Product {
	//SSetter(value = AccessLevel.NONE)
	//Mainigie
	private long id;
	private String title; 
	private float price;
	private int quantity;
	private String description;
	private ProductType productType;
	
	private static long counter = 0;
	
	//Geteri - nak no Lombok
	//No Maven repository pom faila pieviento Lombok

	public long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public float getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

	public String getDescription() {
		return description;
	}

	public ProductType getProductType() {
		return productType;
	}
	
	//Seteri -  nak no Lombok
	
	

	public void setId(long id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}
	
	//Bezaurgumenta konstruktori -  nak no Lombok
	
	//Argumenta konstruktori -  nak no Lombok
	public Product(String inputTitle, float inputPrice, int inputQuantity, String inputDescription, ProductType inputProductType ) {
		setTitle(inputTitle);
		setDescription(inputDescription);
		setPrice(inputPrice);
		setQuantity(inputQuantity);
		setProductType(inputProductType);
	}
	//toString
	@Override
	public String toString() {
		String result = id + " " + title + " " + description + " " + price + " " + quantity + " " + productType;
		return result;
	}
}

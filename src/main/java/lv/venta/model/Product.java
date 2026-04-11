package lv.venta.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Getter
//@Setter
//@NoArgsConstructor
//ToString
@Table(name = "ProductTable")
@Entity
public class Product {
	//Setter(value = AccessLevel.NONE)
	//Mainigie
	@Column(name = "Id")
	@Id //ka primara atslega
	@GeneratedValue(strategy = GenerationType.AUTO)//tiks glabata autoincrement
	private long id;
	
	@Column(name = "Title")
	private String title; 

	@Column(name = "Price")
	private float price;

	@Column(name = "Quantity")
	private int quantity;
	
	@Column(name = "Description")
	private String description;
	
	@Column(name = "ProductType")
	private ProductType productType;
	
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
	public Product () {}
	
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

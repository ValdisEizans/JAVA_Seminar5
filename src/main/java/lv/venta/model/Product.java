package lv.venta.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "ProductTable")
@Entity
public class Product {
	@Setter(value = AccessLevel.NONE)
	//Mainigie
	@Column(name = "Id")
	@Id //ka primara atslega
	@GeneratedValue(strategy = GenerationType.AUTO)//tiks glabata autoincrement
	private long id;
	
	@Column(name = "Title")
	@NotNull
	@NotEmpty
	@Pattern(regexp = "[A-Z]{1}[a-z ]{2,30}")
	private String title; 

	@Column(name = "Price")
	@Min(0)
	@Max(1000)
	private float price;

	@Column(name = "Quantity")
	@Min(0)
	@Max(1000)
	private int quantity;
	
	@Column(name = "Description")
	@NotNull
	@NotEmpty
	@Pattern(regexp = "[A-Z]{1}[A-Za-z0-9,. ]{2,150}")
	private String description;
	
	@Column(name = "ProductType")
	@NotNull
	private ProductType productType;
	
	//Geteri - nak no Lombok
	//Seteri - nak no Lombok
	//Bezaurgumenta konstruktori -  nak no Lombok
	
	//Argumenta konstruktori
	public Product(String inputTitle, float inputPrice, int inputQuantity, String inputDescription, ProductType inputProductType ) {
		setTitle(inputTitle);
		setDescription(inputDescription);
		setPrice(inputPrice);
		setQuantity(inputQuantity);
		setProductType(inputProductType);
	}
	//toString - nak no Lombok
}

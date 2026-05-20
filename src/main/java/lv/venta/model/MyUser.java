package lv.venta.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Table(name = "MyUserTable")
@Entity
public class MyUser {
	@Setter(value = AccessLevel.NONE)
	//Mainigie
	@Column(name = "Idu")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idu;
	
	@Column(name = "Username")
	@NotNull(message = "Lietotajvardam jabut aizpilditam!")
	@NotEmpty
	@Pattern(regexp = "[A-Za-z0-9]{5,20}")
	private String username; 

	@Column(name = "Password")
	@NotNull(message = "Parolei jabut aizpilditam!")
	@NotEmpty
	//Neliekam patern jo te glabajas encoded parole
	private String password; 

	//Argumenta konstruktors
//	public MyUser(String username, String password) {
//		setUsername(username);
//		setPassword(password);
//	}
	
}

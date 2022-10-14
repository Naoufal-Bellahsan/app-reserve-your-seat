package com.app.rys.models;

import java.util.Objects;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CollectionId;

/**
 * Entidad Usuario
 * 
 * @author Naoufal
 *
 */
public class User {

	// propiedaes
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private Long id;
	
	private String fullName;
	
	@NotNull
	@Email(message = "Email not valid", regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}")
	private String email; 
	
	@Pattern(message = "User code not valid", regexp = "^[a-z]{1}-[0-9]")
	private String userCode; 
	
	@Pattern(message = "The password must have at least 8 and 16 characters, "
			+ "at least one digit, at least one lowercase and at least one uppercase. "
			+ "It can NOT have other symbols"
			, regexp = "^(?=\\w*\\d)(?=\\w*[A-Z])(?=\\w*[a-z])\\S{8,16}$")
	private String password;

	@Size(min = 9, max = 9, message = "The number phone must have 9 numbers")
	private String phone; 

	// Constructores: vacío y con campos
	public User(Long id, String fullName,
			@NotNull @Email(message = "Email not valid", regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}") String email,
			@Pattern(message = "User code not valid", regexp = "^[a-z]{1}-[0-9]") String userCode,
			@Pattern(message = "The password must have at least 8 and 16 characters, at least one digit, at least one lowercase and at least one uppercase. It can NOT have other symbols", regexp = "^(?=\\w*\\d)(?=\\w*[A-Z])(?=\\w*[a-z])\\S{8,16}$") String password,
			@Size(min = 9, max = 9, message = "The number phone must have 9 numbers") String phone) {
		this.id = id;
		this.fullName = fullName;
		this.email = email;
		this.userCode = userCode;
		this.password = password;
		this.phone = phone;
	}

	public User() {
		
	}

	// Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	// equals & hashcode
	@Override
	public int hashCode() {
		return email.length()*10 + fullName.length();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(userCode, other.userCode);
	}

	//toString
	@Override
	public String toString() {
		return String.format("User [id=%s, fullName=%s, email=%s, userCode=%s, password=%s, phone=%s]", id, fullName,
				email, userCode, password, phone);
	}

}

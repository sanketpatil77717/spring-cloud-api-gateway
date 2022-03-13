package com.user.model;

import javax.persistence.Entity;	
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users_data")
public class User {
	
	
	public User()
	{
		
	}
	
	
	public User(Long id,
			@NotEmpty @Size(min = 2, max = 16, message = "First Name Should be of min=2 and max 16 characters.") String firstName,
			@NotEmpty @Size(min = 2, max = 16, message = "Last Name Should be of min=2 and max 16 characters.") String lastName,
			@Email(message = "Invalid Email") String email, @Pattern(regexp = "[6789][\\d]{9}",message = "Invalid Mobile Number") String mobile) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobile = mobile;
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	
	@NotEmpty
	@Size(min = 2,max = 16,message = "First Name Should be of min=2 and max 16 characters.")
	private String firstName;
	
	
	@NotEmpty
	@Size(min=2,max=16,message = "Last Name Should be of min=2 and max 16 characters.")
	private String lastName;
	
	
	@Email(message = "Invalid Email")
	private String email;
	
	
	@Pattern(regexp = "[6789][\\d]{9}",message = "Invalid Mobile Number")
	private String mobile;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getMobile() {
		return mobile;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	

}

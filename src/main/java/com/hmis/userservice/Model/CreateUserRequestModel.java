package com.hmis.userservice.Model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CreateUserRequestModel {

	@NotNull(message = "First Name cannot be null")
	@Size(min = 2, message = "First Name must not be less than 2 character")
	private String firstName;
	
	@NotNull(message = "Last Name cannot be null")
	@Size(min = 2, message = "Last Name must not be less than 2 character")
	private String lastName;
	
	@NotNull(message="email cannot be null")
	@Email
	private String email;
	
	@NotNull(message="password cannot be null")
    @Size(min=8, max=16, message="password must be equal or greate than 8 and less than 16 charachers")
	private String password;

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}

package shop.customers.payload;

import javax.validation.constraints.*;


public class CustomerSignUpRequest {
	
    @NotBlank
    @Size(min = 4, max = 40)
    private String firstname;
    
    @NotBlank
    @Size(min = 4, max = 40)
    private String lastname;

    @NotBlank
    @Size(min = 4, max = 40)
    private String username;

    @NotBlank
    @Size(max = 40)
    @Email
    private String email;
    
    @NotBlank
    @Size(max = 40)
    private String phone;

    @NotBlank
    @Size(min = 6, max = 20)
    private String password;

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}

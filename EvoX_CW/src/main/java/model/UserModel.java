package model;

public class UserModel {
	private String username;
	private String firstname;
	private String lastname;	
	private String email;
	private String phonenumber;
	private String gender;
	private String password;
	private String role;
	
	public UserModel() {}

	public UserModel(String username, String firstname, String lastname, String email, String phonenumber, String gender,
			 String password, String role) {
		super();
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;	
		this.email = email;
		this.phonenumber = phonenumber;
		this.gender = gender;
		this.password = password;
		this.role = role;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}


	public String getFirstName() {
		return firstname;
	}

	public void setFirstName(String firstname) {
		this.firstname = firstname;
	}

	public String getLastName() {
		return lastname;
	}

	public void setLastName(String lastname) {
		this.lastname = lastname;
	}

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPhoneNumber() {
		return phonenumber;
	}

	public void setPhoneNumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
		
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}	
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
}



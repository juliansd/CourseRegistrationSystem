package data.structures.jsd410;

import java.util.Scanner;

public class User implements java.io.Serializable {
	private String username, password, firstName, lastName;
	
	public User(Scanner scan) {
	}
	
	public User(String username, String password, String firstName, String lastName, Scanner scan) {
		setUsername(username);
		setPassword(password);
		setFirstName(firstName);
		setLastName(lastName);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
	
}

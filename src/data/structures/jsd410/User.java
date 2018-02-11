package data.structures.jsd410;

import java.util.Scanner;

/**
 * Class which represents the users which will be registered within the Course Registration System.
 * @author juliansmithdeniro
 * @version 1.0
 */
@SuppressWarnings("serial")
public abstract class User implements java.io.Serializable {
	
	/**
	 * Instance variable Strings which represent the User object's username, password, first name, and last name.
	 */
	private String username, password, firstName, lastName;
	
	/**
	 * Default constructor for the User class which takes Scanner as a parameter to catch user input.
	 * @param scan is a Scanner object which is used to catch user input in later methods..
	 */
	public User(Scanner scan) {
	}
	
	/**
	 * Constructor which instantiates an object with the specified parameters,
	 * usually as input from someone using the application.
	 * @param username a String represents the User object's username.
	 * @param password a String represents the User object's password.
	 * @param firstName a String represents the User object's first name.
	 * @param lastName a String represents the User object's last name.
	 * @param scan a Scanner which is passed when instantiating the object to catch user input.
	 */
	public User(String username, String password, String firstName, String lastName, Scanner scan) {
		setUsername(username);
		setPassword(password);
		setFirstName(firstName);
		setLastName(lastName);
	}

	/**
	 * Getter for the instance variable username.
	 * @return a String representing the User object's username.
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Setter for the instance varibale username.
	 * @param username a String which represents the User object's username.
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Getter for the instance variable password.
	 * @return a String representing the User object's password.
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Setter for the instance variable password.
	 * @param password a String representing the User object's password.
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Getter for the instance variable firstName.
	 * @return a String representing the User object's first name.
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Setter for the instance variable firstName.
	 * @param firstName a String representing the User object's first name.
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Getter for the instance variable lastName.
	 * @return a String representing the User object's last name.
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Setter for the instance variable lastName.
	 * @param lastName a String representing the User object's last name.
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
}

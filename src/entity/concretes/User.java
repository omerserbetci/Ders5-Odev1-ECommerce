package entity.concretes;

import java.util.List;

import entity.abstracts.Entity;

public class User implements Entity {

	public static List<User> users;
	
	private int id;
	private String firstName;
	private String lastName;
	private String eMailAdress;
	private String password;
	
	public User() {}

	public User(int id, String firstName, String lastName, String eMailAdress, String password) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.eMailAdress = eMailAdress;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public String geteMailAdress() {
		return eMailAdress;
	}

	public void seteMailAdress(String eMailAdress) {
		this.eMailAdress = eMailAdress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	};
	
	
	
	
}

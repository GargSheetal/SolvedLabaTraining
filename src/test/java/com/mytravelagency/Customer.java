/**
 * 
 */
package com.mytravelagency;

/**
 * @author sheetal
 *
 */
public class Customer {

	private String name;
	private String email;
	
	public Customer(String name, String email) {
		
		this.setName(name);
		this.setEmail(email);
	}


	public String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	private void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
	
}

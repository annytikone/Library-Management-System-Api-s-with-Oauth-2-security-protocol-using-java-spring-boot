package com.example.demo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
 

@Entity 
@Table(name = "user")
public class User {
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id; 
	
	
	private String username;
	
	private String password;
	
	private String firstname;
	
	private String lastname;
	
	private String role;
	
/*	@OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL) 
	private List<UserRole> roles; 
 
	User() { 
	} 
 */
/*	public User(String username, String password, List<UserRole> roles) { 
		this.username = username; 
		this.password = password; 
		//this.roles = roles; 
	} */
 
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
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
 
/*	public List<UserRole> getRoles() { 
		return roles; 
	} 
 
	public void setRoles(List<UserRole> roles) { 
		this.roles = roles; 
	} */
 
}

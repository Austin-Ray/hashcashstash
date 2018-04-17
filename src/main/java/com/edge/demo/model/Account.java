package com.edge.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by spann303 on 4/7/2018
 * This class connects to the User model as part of a Spring JPA entity.
 */

@Entity
@Table (name="account")
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer id;
	private String first_name;
	private String last_name;
	private String username;
	private String password;
	private String role;
	
	public Account() { }
	
	public Account(String first_name, String last_name, String username, String password, String role) {
		this.first_name = first_name;
		this.last_name = last_name;
		this.username = username;
		this.password = password;
		this.role = role;
	}
	
	public Integer getId() {
		return this.id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return this.first_name;
	}
	
	public void setFirstName(String first_name) {
		this.first_name = first_name;
	}
	
	public String getLastName() {
		return this.last_name;
	}
	
	public void setLastName(String last_name) {
		this.last_name = last_name;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getRole() {
		return this.role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}

}

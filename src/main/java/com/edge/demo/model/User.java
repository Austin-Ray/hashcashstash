package com.edge.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by spann303 on 4/7/2018
 * This class connects to the User model as part of a Spring JPA entity.
 *
 */

@Entity
public class User {
	
	@Id
	Integer id;
	String first_name;
	String last_name;
	String email = null;
	
	public User() { }
	
	public User(Integer id, String first_name, String last_name, String email) {
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
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
	
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

}

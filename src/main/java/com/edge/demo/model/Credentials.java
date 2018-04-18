package com.edge.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by spann303 on 4/5/2018
 * This class connects the Credentials model as a Spring JPA entity.
 */

/**
 * TODO:
 * 		Relate this class with the user class by passing in this id into User.
 *		Ensure tables correspond to these entities.
 */

@Entity
public class Credentials {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	String username;
	String password;
	
	protected Credentials() {}
	
	public Credentials(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public Long get_id() {
		return this.id;
	}
	
	public void set_id(Long id) {
		this.id = id;
	}
	
	public String get_username() {
		return this.username;
	}
	
	public void set_username(String username) {
		this.username = username;
	}
	
	public String get_password() {
		return this.password;
	}
	
	public void set_password(String password) {
		this.password = password;
	}
}

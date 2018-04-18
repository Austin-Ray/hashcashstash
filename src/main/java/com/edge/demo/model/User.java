package com.edge.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by spann303 on 4/5/2018.
 * This class connects the User model as a Spring JPA entity.
 */

@Entity  //Model for a user table in Spring JPA
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	String first_name;
	String last_name;
	
	protected User() {}
	
	public User(String first_name, String last_name) {
		this.first_name = first_name;
		this.last_name = last_name;
	}
	
	public Long get_id() {
		return this.id;
	}
	
	public void set_id(Long id) {
		this.id = id;
	}
	
	public String get_first_name() {
		return this.first_name;
	}
	
	public void set_first_name(String first_name) {
		this.first_name = first_name;
	}
	
	public String get_last_name() {
		return this.get_last_name();
	}

}

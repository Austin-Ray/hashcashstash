package com.edge.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edge.demo.model.User;
import com.edge.demo.repository.UserRepository;


/**
 * Created my spann303 on 4/7/2018.
 * Manages the CRUD operations of the User Repository.
 */

@RestController
@RequestMapping("api/v1/")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	/**
	 * Adds user to hibernate database.
	 * (Temporary until database server established)
	 * @param user
	 */
	public void add_user(User user) {
		userRepository.saveAndFlush(user);
	}
}

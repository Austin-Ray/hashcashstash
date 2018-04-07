package com.edge.demo.controller;

import com.edge.demo.model.User;
import com.edge.demo.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created my spann303 on 4/7/2018.
 * Manages the CRUD operations of the User Repository.
 */
@RestController
@RequestMapping("api/v1/")
public class UserController {

	@Autowired
	private UserRepository userRepository;
		
	@RequestMapping(value = "account", method = RequestMethod.GET)
	public User get(@PathVariable Integer id) {

		return userRepository.findOne(id);
	}
	
	
}

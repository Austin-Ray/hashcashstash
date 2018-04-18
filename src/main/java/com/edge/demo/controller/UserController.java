package com.edge.demo.controller;

import com.edge.demo.model.User;
import com.edge.demo.repository.UserRepository;
//import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by spann303 on 3/5/2018
 * This class manages the queries of the user repository
 */

@RestController
@RequestMapping("api/v1/")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping(value = "users", method = RequestMethod.GET)
	public List<User> list() {
		return userRepository.findAll();
	}
	
}

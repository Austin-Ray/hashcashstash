package com.edge.demo.controller;

import com.edge.demo.model.User;
import com.edge.demo.repository.UserRepository;
//import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by spann303 on 4/5/2018
 * This class will manage quereies of the credentials repository
 *
 */

@RestController
@RequestMapping("api/v1/")
public class CredentialsController {

	@Autowired
	private CredentialsRepository credentialsRepository;
}

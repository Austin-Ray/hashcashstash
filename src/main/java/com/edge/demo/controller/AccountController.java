package com.edge.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.edge.demo.model.Account;
import com.edge.demo.repository.AccountRepository;


/**
 * Created my spann303 on 4/7/2018.
 * Manages the CRUD operations of the User Repository.
 */

@RestController
@RequestMapping("api/v1/")
public class AccountController {
	
	@Autowired
	private AccountRepository accountRepository;
	
	/**
	 * Adds user to hibernate database.
	 * (Temporary until database server established)
	 * @param user
	 */
	public void add_account(Account acc) {
		accountRepository.save(acc);
	}
	
	@RequestMapping(value = "account", method = RequestMethod.GET)
	public Account list() {
		return accountRepository.findOne(1);
	}
}

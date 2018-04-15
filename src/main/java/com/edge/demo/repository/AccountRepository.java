package com.edge.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.edge.demo.model.Account;

/**
 * Created my spann303 on 4/7/2018
 * Connects the User.java to the hibernate db through the Spring JPA.
 */

public interface AccountRepository extends CrudRepository<Account, Integer>{

}

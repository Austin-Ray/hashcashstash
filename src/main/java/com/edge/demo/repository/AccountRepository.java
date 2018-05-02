package com.edge.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.edge.demo.model.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> { }

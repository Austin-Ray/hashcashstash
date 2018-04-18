package com.edge.demo.bootstrap;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.edge.demo.SqlConnect;
import com.edge.demo.model.Account;
import com.edge.demo.repository.AccountRepository;

@Component
public class AccountLoader implements ApplicationListener<ContextRefreshedEvent>{

	private AccountRepository accountRepository;
	
//	private Logger log = Logger.getLogger(AccountLoader.class);
	
	@Autowired
	public void setUserRepository(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}
	
	/**
	 * Adds data from non-volatile database to h2 memory db.
	 */
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
    	
    	//Connects to the sqlite DB.
    	Connection connection = SqlConnect.connector();
    	
    	if (connection == null) {
    		System.exit(0);
    	}
    	
    	//A query statement to receive data from the sqlite db.
    	PreparedStatement ps = null;
    	String query = "select * from user";
    	try {
    		ps = connection.prepareStatement(query);
    		ResultSet result = ps.executeQuery();
    		
    		//Iterates through the list of results from the query.
    		while (result.next()) {
    			String first_name = result.getString("first_name");
    			String last_name = result.getString("last_name");
    			String username = result.getString("username");
    			String password = result.getString("password");
    			String role = result.getString("role");
    			Account acc = new Account(first_name,last_name,username,password,role);
    			accountRepository.save(acc);
    			
//    			log.info("Saved User -id: "+acc.getId());
    		}
    		
    	} catch (Exception e) {
    		System.out.println("Unable to execute query");
    	} finally {
    		try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
		
	}

}

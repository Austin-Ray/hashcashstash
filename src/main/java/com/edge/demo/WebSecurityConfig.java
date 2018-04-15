//package com.edge.demo;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.Properties;
//
//import org.springframework.boot.autoconfigure.security.SecurityProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.annotation.Order;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//
//import com.edge.demo.controller.UserController;
//import com.edge.demo.model.User;

//@Configuration
//@EnableWebSecurity
//@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//	
//    /**
//     * This method Determines what views a user can see while before authentication (logged in),
//     * while authenticated, and can allow views to be hidden or viewed based on the user's role
//     * @param http
//     * @throws Exception
//     */
//    @Override
//    protected void configure(final HttpSecurity http) throws Exception {
////        http.authorizeRequests()
////                .antMatchers("/login", "/complete/registration", "/css/bootstrap.min.css").permitAll().anyRequest()
////                .fullyAuthenticated().and().formLogin()
////                .failureUrl("/login?error").and().logout()
////                .logoutRequestMatcher(new AntPathRequestMatcher("/logout")).and()
////                .exceptionHandling().accessDeniedPage("/access?error");
//        http.authorizeRequests().antMatchers("/").permitAll().and().authorizeRequests().antMatchers("/console/*").permitAll();
//        
//        
//        http.csrf().disable();
//        http.headers().frameOptions().disable();
//    }
//

//    @Override
//    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(inMemoryUserDetailsManager()).passwordEncoder(passwordEncoder());
//    }

    /**
     * This method creates the username(s), password(s), and role(s) for
     * authentication.
     * 
     * Edited by: spann303 on 4/7/2018
     * Added implementation of non-volatile DB to store user info.
     * @return
     */
//    @Bean
//    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
//        
//    	final Properties users = new Properties();
//    	/**
//    	 * Pulling data from a text file to add users to the DB.
//    	 */
//    	
//    	//Connects to the sqlite DB.
//    	Connection connection = SqlConnect.connector();
//    	
//    	if (connection == null) {
//    		System.exit(0);
//    	}
//    	
//    	//A query statement to receive data from the sqlite db.
//    	PreparedStatement ps = null;
//    	String query = "select * from user";
//    	try {
//    		ps = connection.prepareStatement(query);
//    		ResultSet result = ps.executeQuery();
//    		
//    		//Iterates through the list of results from the query.
//    		while (result.next()) {
//    			String first_name = result.getString("first_name");
//    			String last_name = result.getString("last_name");
//    			String username = result.getString("username");
//    			String password = passwordEncoder().encode(result.getString("password"));
//    			String role = result.getString("role");
//    			users.put(username,password+",ROLE_"+role+",enabled");
//    		}
//    		
//    	} catch (Exception e) {
//    		System.out.println("Unable to execute query");
//    	} finally {
//    		try {
//				ps.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//    	}
//    	
////    	final Properties users = new Properties();
////        String adminPassword = passwordEncoder().encode("admin");
////        users.put("admin", adminPassword + ",ROLE_ADMIN,enabled");
////        users.put("qubuni@qub.ac.uk", "password,ROLE_USER,enabled");
////        users.put("kelsey", adminPassword+",ROLE_ADMIN,enabled");
////        users.put("austin", adminPassword+",ROLE_ADMIN,enabled");
////        users.put("sam", adminPassword+",ROLE_ADMIN,enabled");
////        users.put("michael", adminPassword+",ROLE_ADMIN,enabled");
////        users.put("user", adminPassword+",ROLE_USER,enabled");
////        //add whatever other user you need
//
//        return new InMemoryUserDetailsManager(users);
//    }
//
//    @Bean
//    public BCryptPasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
    		
//}
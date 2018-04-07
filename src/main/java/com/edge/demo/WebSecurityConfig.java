package com.edge.demo;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Properties;

@Configuration
@EnableWebSecurity
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    /**
     * This method Determines what views a user can see while before authentication (logged in),
     * while authenticated, and can allow views to be hidden or viewed based on the user's role
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/login", "/complete/registration", "/css/bootstrap.min.css").permitAll().anyRequest()
                .fullyAuthenticated().and().formLogin()
                .failureUrl("/login?error").and().logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout")).and()
                .exceptionHandling().accessDeniedPage("/access?error");
    }


    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(inMemoryUserDetailsManager()).passwordEncoder(passwordEncoder());
    }

    /**
     * This method creates the username(s), password(s), and role(s) for
     * authentication.
     * @return
     */
    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
        
    	final Properties users = new Properties();
    	/**
    	 * Pulling data from a text file to add users to the DB.
    	 */
    	
    	File file = new File("/src/main/resources/db/users.txt");
    	
    	try {
    		BufferedReader bf = new BufferedReader(new FileReader(file));
    		String line = bf.readLine();
    		
    		while (line != null) {
    			String [] line_split = line.trim().split("\t");
    			users.put(line_split[0],passwordEncoder().encode(line_split[1])+","+line_split[2]);
    			line = bf.readLine();
    		}
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	
//    	final Properties users = new Properties();
//        String adminPassword = passwordEncoder().encode("admin");
//        users.put("admin", adminPassword + ",ROLE_ADMIN,enabled");
//        users.put("qubuni@qub.ac.uk", "password,ROLE_USER,enabled");
//        users.put("kelsey", adminPassword+",ROLE_ADMIN,enabled");
//        users.put("austin", adminPassword+",ROLE_ADMIN,enabled");
//        users.put("sam", adminPassword+",ROLE_ADMIN,enabled");
//        users.put("michael", adminPassword+",ROLE_ADMIN,enabled");
//        users.put("user", adminPassword+",ROLE_USER,enabled");
//        //add whatever other user you need

        return new InMemoryUserDetailsManager(users);
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    		
}
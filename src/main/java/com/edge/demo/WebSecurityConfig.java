package com.edge.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.log4j.Logger;
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

import com.edge.demo.bootstrap.AccountLoader;
import com.edge.demo.controller.AccountController;
import com.edge.demo.repository.AccountRepository;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  static public InMemoryUserDetailsManager inMemoryUserDetailsManager;
  //private AccountRepository accountRepository;
  private Logger log = Logger.getLogger(AccountController.class);

  /**
   * This method Determines what views a user can see while before authentication (logged in),
   * while authenticated, and can allow views to be hidden or viewed based on the user's role
   *
   * @param http
   * @throws Exception
   */
  @Override
  protected void configure(final HttpSecurity http) throws Exception {

    http
        .authorizeRequests()
        .antMatchers("/login", "/j_spring_security_check", "/registration", "/h2/**").permitAll().anyRequest().authenticated()
        .and()
        .formLogin()
        .loginPage("/login")
        .failureUrl("/login-error.html")
        .defaultSuccessUrl("/home")
        .permitAll()
        .and()
        .logout()
        .logoutSuccessUrl("/home");

    //        http.authorizeRequests()
//                .antMatchers("/login", "/complete/registration", "/css/bootstrap.min.css","/h2/*","/signin/").permitAll().anyRequest()
//                .authenticated().and().formLogin().loginPage("/login").permitAll()
//                .failureUrl("/login?error").defaultSuccessUrl("/").and().logout()
//                .logoutRequestMatcher(new AntPathRequestMatcher("/logout")).and()
//                .exceptionHandling().accessDeniedPage("/access?error");
//        http.authorizeRequests().antMatchers("/").permitAll().and().authorizeRequests().antMatchers("/h2/*").permitAll();
//        
//        
    http.csrf().disable();
    http.headers().frameOptions().disable();
  }


  @Override
  protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
    WebSecurityConfig.inMemoryUserDetailsManager = this.inMemoryUserDetailsManagerInit();
    auth.userDetailsService(WebSecurityConfig.inMemoryUserDetailsManager).passwordEncoder(passwordEncoder());
  }

  /**
   * This method creates the username(s), password(s), and role(s) for
   * authentication.
   * <p>
   * Edited by: spann303 on 4/7/2018
   * Added implementation of non-volatile DB to store user info.
   *
   * @return
   */
  @Bean
  public InMemoryUserDetailsManager inMemoryUserDetailsManagerInit() {

    final Properties users = new Properties();
    /**
     * Pulling data from a text file to add users to the DB.
     */

    //Connects to the sqlite DB.
    Connection connection = SqlConnect.connector();

    if (connection == null) {
      System.exit(0);
    }

    //A query statement to receive data from the sqlite db.
    PreparedStatement ps = null;
    String query = "select * from account";
    try {
      ps = connection.prepareStatement(query);
      ResultSet result = ps.executeQuery();

      //Iterates through the list of results from the query.
      while (result.next()) {
        String username = result.getString("username");
//    			System.out.println(username);
        String password = passwordEncoder().encode(result.getString("password"));
        String role = result.getString("role");
        users.put(username, password + ",ROLE_" + role + ",enabled");
        log.info("Placed into memory");
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
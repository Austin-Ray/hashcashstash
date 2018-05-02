package com.edge.demo.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.edge.demo.SqlConnect;
import com.edge.demo.model.Account;

@Controller
@RequestMapping("/")
public class LoginController {

  private Logger log = Logger.getLogger(AccountController.class);
  private InMemoryUserDetailsManager inMemoryUserDetailsManager;

//	private AccountRepository accountRepository;

  @Autowired
  public LoginController(InMemoryUserDetailsManager inMemoryUserDetailsManager) {
    this.inMemoryUserDetailsManager = inMemoryUserDetailsManager;
  }

  /**
   * These are redirections for calls to the server from the HTML.
   *
   * @return
   */
  @RequestMapping(value = "login", method = RequestMethod.GET)
  public String getLoginPage() {
    return "views/login.html";
  }

  @RequestMapping(value = "login", method = RequestMethod.POST)
  public String authenticate() {
    return "/j_spring_security_check";
  }

  @RequestMapping(value = "login-error.html", method = RequestMethod.GET)
  public String errorPage() {
    return "redirect:/login";
  }

  @RequestMapping(value = "registration", method = RequestMethod.GET)
  public String registrationPage() {
    return "views/registration.html";
  }

  @RequestMapping(value = "registration/back", method = RequestMethod.GET)
  public String backPage() {
    return "redirect:/login";
  }

  /*
   * Adds new account to both hibernate and static database.
   * TODO: Add registration to memory. Currently having issues with this.
   */
  @RequestMapping(value = "registration", method = RequestMethod.POST)
  public String registrationForm(
      @RequestParam("username") String username,
      @RequestParam("password") String password,
      @RequestParam("confirmPassword") String confirmPassword,
      @RequestParam("firstName") String firstName,
      @RequestParam("lastName") String lastName
  ) {

    log.info("*********THIS BE BROKE ******************");
//		if (password.equals(confirmPassword)) {
//			return "views/registration.html";
//		}

    log.info("**************************");
    log.info(username);
    log.info(password);
    log.info(confirmPassword);
    log.info(firstName);
    log.info(lastName);
    log.info("**************************");

    Account acc = new Account(firstName, lastName, username, password, "user");
    System.out.println(acc);

    boolean exist = this.addAccount(acc);

    if (!exist) {
      this.inMemoryUserDetailsManager.createUser(new User(username, password, new ArrayList<>()));
      return "redirect:login";
    }

    return "redirect:registration";
  }


  private boolean addAccount(Account account) {
    Connection conn = SqlConnect.connector();

    if (conn == null) {
      System.exit(0);
    }

    PreparedStatement ps = null;
    String query = "INSERT INTO account (firstName, lastName, username, password, role) VALUES (?,?,?,?,?)";
    log.info(account.getFirstName());
    log.info(account.getLastName());
    log.info(account.getUsername());
    log.info(account.getPassword());
    log.info(account.getRole());
    log.info(query);
    log.info(conn);

    try {
      log.info("test 1");

      ps = conn.prepareStatement(query);
      log.info("test 2");
      ps.setString(1, account.getFirstName());
      log.info("test 3");
      ps.setString(4, account.getLastName());
      log.info("test 4");
      ps.setString(3, account.getUsername());
      log.info("test 5");
      ps.setString(2, account.getPassword());
      log.info("test 6");
      ps.setString(5, account.getRole());

      log.info("AFTER THINGS WERE PUT IN DA STUFF");
      ps.execute();
      log.info("Query executed");

    } catch (Exception e) {
      return true;
    } finally {
      try {
        if (ps != null) {
          ps.close();
        }
      } catch (SQLException e) {
        log.info("********* Broke closing the prepared statement ***********");
      }
    }

    return false;
  }
}

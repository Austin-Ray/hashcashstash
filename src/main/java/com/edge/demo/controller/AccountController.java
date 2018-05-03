/*
 * This file is part of HashCash Stash.
 *
 * HashCash Stash is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * HashCash Stash is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with HashCash Stash.  If not, see <http://www.gnu.org/licenses/>.
 */

/*
 * This file is part of HashCash Stash.
 *
 * HashCash Stash is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * HashCash Stash is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with HashCash Stash.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.edge.demo.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.edge.demo.bootstrap.LoginListener;
import com.edge.demo.model.Account;
import com.edge.demo.repository.AccountRepository;

@RestController
@RequestMapping("api/v1")
public class AccountController {

  private Logger log = Logger.getLogger(AccountController.class);

  @Autowired
  private AccountRepository accountRepository;

  @Autowired
  public void setAccountRepository(AccountRepository accountRepository) {
    this.accountRepository = accountRepository;
  }

  @RequestMapping(value = "/account", method = RequestMethod.GET)
  public Account getCurrentAccount() {
    //List<Account> list = accountRepository.findAll();
    //return new ResponseEntity<List<Account>>(list, HttpStatus.OK);
    Account current = null;
    for (Account acc : accountRepository.findAll()) {
      if (acc.getUsername().equals(LoginListener.userDetails.getUsername())) {
        current = acc;
      }
    }

    return current;
  }

}

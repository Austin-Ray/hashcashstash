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

package com.edge.demo;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service("userService")
public class UserService {
  /**
   * Where the app currently keeps all username, passwords, and roles
   *
   * @param username
   * @return
   */
  public Map<String, Object> getUserByUsername(String username) {
    Map<String, Object> userMap = null;
    //logic here to get your user from the database
    if (username.equals("admin") || username.equals("user")) {
      userMap = new HashMap<>();
      userMap.put("username", "admin");
      userMap.put("password", "password");
      //if username is admin, role will be admin, else role is user only
      userMap.put("role", (username.equals("admin")) ? "admin" : "user");
      //return the usermap
      return userMap;
    }
    //if username is not equal to admin, return null
    return null;
  }
}
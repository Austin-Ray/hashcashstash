package com.edge.demo;

/**
 * Created by kelseyedge on 4/2/18.
 */

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service("userService")
public class UserService {

    public Map<String, Object> getUserByUsername(String username) {
        Map<String, Object> userMap = null;
        //logic here to get your user from the database
        if (username.equals("admin") || username.equals("user")) {
            userMap = new HashMap();
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
package com.edge.demo.controller;
//
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.edge.demo.model.User;
//
//@RestController
//public class HomeController {
//    static ModelMap mm;
//
//    /**
//     * This method was created just as an example of how to crap the username from the
//     * web application. If you type localhost:8080/ into your browser when you are logged in
//     * and it should return a web page with your name on it.
//     * @param model
//     * @return
//     */
//    @RequestMapping(value="/", method = RequestMethod.GET)
//    public String printUser(ModelMap model) {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        String name = auth.toString(); //get logged in username
//        System.out.println(name);
//        mm = model;
//        model.addAttribute("username", name);
//        return "hello "+name;
//
//}}

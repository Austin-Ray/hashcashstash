//package com.edge.demo;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//
///**
// * Created by kelseyedge
// * This class is responsible for determining what views/pages a user can see
// * without logging in. This page uses Spring Security.
// */
//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
////                .antMatchers("/", "/registerUser","/home", "/faq", "/hello", "/account", "/aboutUs", "/currencies").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
////                .loginPage("/login")
////                .permitAll()
//                .and()
////                .logout()
////                .permitAll();
//                .httpBasic();
//    }
//
//    @Bean
//    @Override
//    public UserDetailsService userDetailsService() {
//        UserDetails user = User
//                .username("kelsey")
//                .password("password")
//                .roles("USER")
//                .build();
//
//        return new InMemoryUserDetailsManager(user);
//    }
//
////    // create two users, admin and user
////    @Autowired
////    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
////
////        auth.inMemoryAuthentication()
////                .withUser("user").password("password").roles("USER")
////                .and()
////                .withUser("admin").password("password").roles("ADMIN");
////    }
//}
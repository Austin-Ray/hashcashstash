package com.edge.demo.bootstrap;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class LoginListener implements ApplicationListener<ApplicationEvent> {

  public static UserDetails userDetails = null;

  @Override
  public void onApplicationEvent(ApplicationEvent appEvent) {
    if (appEvent instanceof AuthenticationSuccessEvent) {
      AuthenticationSuccessEvent event = (AuthenticationSuccessEvent) appEvent;
      userDetails = (UserDetails) event.getAuthentication().getPrincipal();
    }
  }
}

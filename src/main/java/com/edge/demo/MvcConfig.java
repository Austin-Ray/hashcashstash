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

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.Validator;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.*;

import java.util.List;

/**
 * Created by kelseyedge
 * This class is responsible for mapping URLs vis HTTP status code to views not assigned in angular code
 */

@Configuration
public class MvcConfig implements WebMvcConfigurer {

  @Override
  public void addFormatters(FormatterRegistry formatterRegistry) {

  }

  @Override
  public void configureMessageConverters(List<HttpMessageConverter<?>> list) {

  }

  @Override
  public void extendMessageConverters(List<HttpMessageConverter<?>> list) {

  }

  @Override
  public Validator getValidator() {
    return null;
  }

  @Override
  public void configureContentNegotiation(ContentNegotiationConfigurer contentNegotiationConfigurer) {

  }

  @Override
  public void configureAsyncSupport(AsyncSupportConfigurer asyncSupportConfigurer) {

  }

  @Override
  public void configurePathMatch(PathMatchConfigurer pathMatchConfigurer) {

  }

  @Override
  public void addArgumentResolvers(List<HandlerMethodArgumentResolver> list) {

  }

  @Override
  public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> list) {

  }

  @Override
  public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> list) {

  }

  @Override
  public void addInterceptors(InterceptorRegistry interceptorRegistry) {

  }

  @Override
  public MessageCodesResolver getMessageCodesResolver() {
    return null;
  }

  /**
   * The method maps url paths to a view
   *
   * @param registry
   */
  public void addViewControllers(ViewControllerRegistry registry) {
    registry.addViewController("/home").setViewName("index.html");
    registry.addViewController("/login").setViewName("login.html");
  }

  @Override
  public void configureViewResolvers(ViewResolverRegistry viewResolverRegistry) {

  }

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry resourceHandlerRegistry) {

  }

  @Override
  public void configureDefaultServletHandling(DefaultServletHandlerConfigurer defaultServletHandlerConfigurer) {

  }

  @Override
  public void addCorsMappings(CorsRegistry corsRegistry) {

  }

}
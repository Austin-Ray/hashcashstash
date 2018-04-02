//package com.edge.demo;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.format.FormatterRegistry;
//import org.springframework.http.converter.HttpMessageConverter;
//import org.springframework.validation.MessageCodesResolver;
//import org.springframework.validation.Validator;
//import org.springframework.web.method.support.HandlerMethodArgumentResolver;
//import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
//import org.springframework.web.servlet.HandlerExceptionResolver;
//import org.springframework.web.servlet.config.annotation.*;
//
//import java.util.List;
//
///**
// * Created by kelseyedge
// * This class is responsible for mapping URLs vis HTTP status code to views in the templates folder
// */
//
//@Configuration
//public class MvcConfig implements WebMvcConfigurer {
//
//    @Override
//    public void addFormatters(FormatterRegistry formatterRegistry) {
//
//    }
//
//    @Override
//    public void configureMessageConverters(List<HttpMessageConverter<?>> list) {
//
//    }
//
//    @Override
//    public void extendMessageConverters(List<HttpMessageConverter<?>> list) {
//
//    }
//
//    @Override
//    public Validator getValidator() {
//        return null;
//    }
//
//    @Override
//    public void configureContentNegotiation(ContentNegotiationConfigurer contentNegotiationConfigurer) {
//
//    }
//
//    @Override
//    public void configureAsyncSupport(AsyncSupportConfigurer asyncSupportConfigurer) {
//
//    }
//
//    @Override
//    public void configurePathMatch(PathMatchConfigurer pathMatchConfigurer) {
//
//    }
//
//    @Override
//    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> list) {
//
//    }
//
//    @Override
//    public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> list) {
//
//    }
//
//    @Override
//    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> list) {
//
//    }
//
//    @Override
//    public void addInterceptors(InterceptorRegistry interceptorRegistry) {
//
//    }
//
//    @Override
//    public MessageCodesResolver getMessageCodesResolver() {
//        return null;
//    }
//
//    public void addViewControllers(ViewControllerRegistry registry) {
////        registry.addViewController("/home").setViewName("home");
////        registry.addViewController("/").setViewName("home");
////        registry.addViewController("/hello").setViewName("hello");
////        registry.addViewController("/login").setViewName("login");
////        registry.addViewController("/templates/faq").setViewName("faq");
////        registry.addViewController("/templates/hello").setViewName("account");
////        registry.addViewController("/templates/aboutUs").setViewName("aboutUs");
////        registry.addViewController("/templates/currencies").setViewName("currencies");
////        registry.addViewController("/templates/registerUser").setViewName("registerUser");
//
//
//
//
//
//    }
//
//    @Override
//    public void configureViewResolvers(ViewResolverRegistry viewResolverRegistry) {
//
//    }
//
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry resourceHandlerRegistry) {
//
//    }
//
//    @Override
//    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer defaultServletHandlerConfigurer) {
//
//    }
//
//    @Override
//    public void addCorsMappings(CorsRegistry corsRegistry) {
//
//    }
//
//}
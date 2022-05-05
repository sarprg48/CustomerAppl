package com.sapit.swag;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


@Component
public class ProductServiceInterceptor implements HandlerInterceptor {
   @Override
   public boolean preHandle
      (HttpServletRequest request, HttpServletResponse response, Object handler) 
      throws Exception {
      
      System.out.println("Pre Handle method is Calling");
//      response.setCharacterEncoding("UTF-8");
//      response.getWriter().write("denied!");
//      response.setStatus(HttpStatus.BAD_REQUEST.value());
      System.out.println(request.getHeader("token"));
      if(request.getHeader("token")!=null) {
    	  if(request.getHeader("token").equals("sarathi")) {
        	  return true;
          }else {
        	  response.setCharacterEncoding("UTF-8");
	      	    response.getWriter().write("Token Id Mismatch Error!");
	      	    response.setStatus(HttpStatus.BAD_REQUEST.value());
          }
      }else {
    	  	response.setCharacterEncoding("UTF-8");
    	    response.getWriter().write("Token Id Must!");
    	    response.setStatus(HttpStatus.BAD_REQUEST.value());
      }
     
    	  
      
      return false;
   }
   @Override
   public void postHandle(HttpServletRequest request, HttpServletResponse response, 
      Object handler, ModelAndView modelAndView) throws Exception {
      
      System.out.println("Post Handle method is Calling");
   }
   @Override
   public void afterCompletion
      (HttpServletRequest request, HttpServletResponse response, Object 
      handler, Exception exception) throws Exception {
      
      System.out.println("Request and Response is completed");
   }
}
package com.nt.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.nt.service.WishMessageService;

public class WishMessageController extends AbstractController {
  private WishMessageService service;
  
  public WishMessageController(WishMessageService service) {   //cosntructor Injection
	  this.service=service;
}
  
  
	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String msg=null;
		//use service
		msg=service.generateMessage();
          //return MAV	     
		return new ModelAndView("result","wmsg",msg);
	}

}

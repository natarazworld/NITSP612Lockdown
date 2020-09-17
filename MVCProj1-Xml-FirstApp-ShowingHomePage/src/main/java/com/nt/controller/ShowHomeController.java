package com.nt.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class ShowHomeController  implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //return MAV object
		//return new ModelAndView("home","sysDate",new Date());  //  (lvn, mattrName, mAttrValue)
		return new ModelAndView("home");  //(lvn)
	}

}

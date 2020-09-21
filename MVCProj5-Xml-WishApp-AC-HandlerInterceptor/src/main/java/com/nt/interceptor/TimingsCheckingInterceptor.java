package com.nt.interceptor;

import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

public class TimingsCheckingInterceptor implements HandlerInterceptor {
	
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler)
			throws Exception {
		var hour=0;
		RequestDispatcher  rd=null;
		//get Current hour of day..
		hour=Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		//check the timings 
		if(hour<9 || hour>17) {
			rd=req.getRequestDispatcher("timeout.jsp");
			rd.forward(req,res);
			return false;
		}
		else
			return true;
	}

}

package com.nt.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.BankMgmtService;
@WebServlet("/controller")
public class MainControllerServlet extends HttpServlet {
   private ApplicationContext ctx;
	public void init() throws ServletException {
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
	}

	public void destroy() {
		((AbstractApplicationContext) ctx).close();
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		long srcNo=0L,destNo=0L;
		float  amt=0.0f;
		BankMgmtService service=null;
		String result=null;
		RequestDispatcher rd=null;
	   //read formdata
		srcNo=Long.parseLong(req.getParameter("srcAcNo"));
		destNo=Long.parseLong(req.getParameter("destAcNo"));
		amt=Float.parseFloat(req.getParameter("amt"));
		//get Service class object
		service=ctx.getBean("bankService",BankMgmtService.class);
		try {
			//invoke method
			result=service.transferMoney(srcNo, destNo, amt);
			req.setAttribute("resultMsg",result);
			//froward to result.jsp page
			rd=req.getRequestDispatcher("/result.jsp");
			rd.forward(req,res);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}

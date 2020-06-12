package com.nt.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.EmployeeMgmtService;


@WebServlet("/controller")
public class MainControllerServlet extends HttpServlet {
	private ApplicationContext ctx;   
    
	public void init() throws ServletException {
		//create IOC container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		
		
	}

	public void destroy() {
		//close container
		((AbstractApplicationContext) ctx).close();
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	  String desg[]=null;
	  EmployeeMgmtService service=null;
	  List<Map<String,Object>> listMap=null;
	  RequestDispatcher rd=null;
	  //read form data
	  desg=req.getParameterValues("job");
	  //get SErvice clas object
	  service=ctx.getBean("empService",EmployeeMgmtService.class);
	  try {
	  //invoke method
		  listMap=service.fetchEmpsByDesgs(desg);
		  //keep the result in reques scope
		  req.setAttribute("listEmps",listMap);
		  //forward to result.jsp
		  rd=req.getRequestDispatcher("/result.jsp");
		  rd.forward(req,res);
	  }//try
	  catch(Exception e) {
		  e.printStackTrace();
		  //keep eexception related error messages in request attribute
		  req.setAttribute("errorMsg",e.getMessage());
		//forward to error page
		  rd=req.getRequestDispatcher("/error.jsp");
		  rd.forward(req,res);
	  }
	}//doGet(req,res)

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}//doPost(req,res)

}

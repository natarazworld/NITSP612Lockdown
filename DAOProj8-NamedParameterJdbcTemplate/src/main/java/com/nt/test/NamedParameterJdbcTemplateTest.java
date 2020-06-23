package com.nt.test;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nt.dto.BookDTO;

import com.nt.service.BookStoreMgmtService;

public class NamedParameterJdbcTemplateTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		BookStoreMgmtService service=null;
		List<BookDTO> listDTO=null;
		BookDTO dto=null;
		//create IOC container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get service class object
		service=ctx.getBean("bookStoreService",BookStoreMgmtService.class);
		try {
			//invoke b.methods
			listDTO=service.fetchBooksByAuthors("HS","BE","ks");
					listDTO.forEach(System.out::println);
		}
		catch(DataAccessException dae) {
			dae.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("................................");
		try {
			dto=new BookDTO();
			dto.setBookName("EIJ"); dto.setAuthor("NIT-Team");
			dto.setCategory("java"); dto.setPrice(1000);
			dto.setPublisher("Sun Press"); dto.setStatus("no");
		  System.out.println(service.addBook(dto));
		}//try
		catch(DataAccessException dae) {
			dae.printStackTrace();
		}
		
		//close container
		((AbstractApplicationContext) ctx).close();

	}//main
}//class

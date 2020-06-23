package com.nt.test;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nt.dto.PassengerDetailsDTO;
import com.nt.service.RailwayTicketMgmtService;

public class BatchInsertionTest {

	public static void main(String[] args) {
		Scanner sc=null;
		
		float price=0.0f;
		String srcPlace=null,destPlace=null;
		int groupSize=0;
		String passengerName=null,gender=null;
		int age=0;
		List<PassengerDetailsDTO> listDTO=new ArrayList();
		PassengerDetailsDTO dto=null;
		ApplicationContext ctx=null;
		RailwayTicketMgmtService service=null;
		String result=null;
		//read inputs
		sc=new Scanner(System.in);
		try {
			System.out.println("Enter group size::");
			groupSize=sc.nextInt();
			if(groupSize>0) {
			 System.out.println("enter source place ::");
			 srcPlace=sc.next();
			 System.out.println("enter destination place ::");
			 destPlace=sc.next();
			 System.out.println("Enter ticket fare ::");
			 price=sc.nextFloat();
			 
			 for(int i=1;i<=groupSize;++i) {
				 System.out.println("Enter  "+i+" passenger details::");
				 System.out.println(" Enter passenger name::");
				 passengerName=sc.next();
				 System.out.println("Enter passenger age::");
				 age=sc.nextInt();
				 System.out.println("Enter Passenger gender");
				 gender=sc.next();
				 //add each passenger into to DTO
				 dto=new PassengerDetailsDTO();
				 dto.setPassengerName(passengerName);
				 dto.setAge(age); dto.setSourcePlace(srcPlace);
				 dto.setDestinationPlace(destPlace);
				 dto.setPrice(price);
				 dto.setGender(gender);
				 //add each DTO to listDTO
				 listDTO.add(dto);
			 }//for
			}//if
			else {
				System.out.println("Invalid group size");
			}
		}//try
		catch(Exception e) {
			e.printStackTrace();
		}
		//create IOC container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get service class object
		service=ctx.getBean("railwayService",RailwayTicketMgmtService.class);
		try {
			//invoke b.methods
			result=service.groupTicketReservation(listDTO);
			System.out.println(result);
		}
		catch(DataAccessException dae) {
			dae.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		//close container
		((AbstractApplicationContext) ctx).close();

	}//main
}//class

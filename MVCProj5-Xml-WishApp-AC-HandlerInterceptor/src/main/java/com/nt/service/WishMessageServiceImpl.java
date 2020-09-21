package com.nt.service;

import java.util.ArrayList;
import java.util.Calendar;

public class WishMessageServiceImpl implements WishMessageService {

	@Override
	public String generateMessage() {
		var  hour=0;  //java 10 feature local variable type inference  (compiler decides the data type based on the initial values)
		                         // using var we can not go for compound variables decl .. we can not declare two variables in same line
		                        // var type variables can not be intialized with null ... but can be intialized simple values.. like 0,0,0 and etc.
		                        //var type can be taken only for local variables..
		                         // var types supports generics  .. 
		//get System date and time
		var calendar=Calendar.getInstance();
		//get curent hour of the day
		hour=calendar.get(Calendar.HOUR_OF_DAY);
		//generate wish Message
		if(hour<12)
			   return "Good Morning";
		else if(hour<16)
			   return "Good Afternoon";
		else if(hour<20)
			return "Good Evening";
		else
			return "Good Night";
	} //method
}//class

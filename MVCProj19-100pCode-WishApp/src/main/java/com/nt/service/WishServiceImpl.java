package com.nt.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

@Service("wishService")
public class WishServiceImpl implements IWishService {

	@Override
	public String generateWishMessage() {
	    //get System  date and time
		LocalDateTime ldt=LocalDateTime.now();
		//get cuurent  hour of the day
		int hour=ldt.getHour();// 24 hours format
		//generate wish message
		if(hour<12)
			return "Good Morning";
		else if(hour<16)
			return "Good AfterNoon";
		else if(hour<20)
			return "Good Evening";
		else
			return "Good Night";
	}

}

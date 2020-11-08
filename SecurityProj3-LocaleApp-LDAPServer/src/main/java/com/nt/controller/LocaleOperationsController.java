package com.nt.controller;

import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nt.service.ILocaleInfoService;

@Controller
public class LocaleOperationsController {
	 @Autowired
	private ILocaleInfoService service;
	
	@RequestMapping(value="/welcome",method=RequestMethod.GET)
	public  String showHome() {
		return "home";
	}
	
	
	
	
	@RequestMapping(value="/countries",method=RequestMethod.GET)
	public String  fetchCountries(Map<String,Object> map) {
		Set<String> countriesList=null;
		//use Service
		countriesList=service.getAllCountries();
		//adding multiple model attribues
		map.put("listInfo", countriesList);
		map.put("operation", "countries");
		map.put("countriesCount", countriesList.size());
		//return lvn
		return "show_results";
		
	}
		
}//class

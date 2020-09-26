package com.nt.service;

import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.stereotype.Service;

@Service("localService")
public class LocaleInfoServiceImpl implements ILocaleInfoService {

	@Override
	public Set<String> getAllCountries() {
		Locale locales[]=null;
		Set<String> countriesList=null;
	    //get All Locales
		locales=Locale.getAvailableLocales();
		
		countriesList=new TreeSet();
		//copy all countries to  List colleciton
		for(Locale l: locales) {
			if(!l.getDisplayCountry().equals(""))
			   countriesList.add(l.getDisplayCountry());
			}
		return countriesList;
	}//method
}//class

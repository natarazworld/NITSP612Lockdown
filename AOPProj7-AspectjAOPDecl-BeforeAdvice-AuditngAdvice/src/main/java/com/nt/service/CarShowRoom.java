package com.nt.service;

public class CarShowRoom {
	
	public String purchaseCar(String modelname,float price,String color,String executive ) {
		
		if(price<1000000 && modelname.equalsIgnoreCase("baleno"))
			return modelname+" car having price"+price +" with color"+color+" sold to customer by"+executive;
		else
			return modelname+" car having price"+price +" with color"+color+" not available to sell to customer by"+executive;
	}//method
}//class

package com.nt.service;

public class ShoppingStore {
	
	public float calculateSingleProductBillAmt(float price ,float qty )throws IllegalAccessException {
		if(qty<=0.0f || price<=0.0f)
			throw new IllegalAccessException("Invalid inputs");
		
		return  price*qty;
		
		
	}

}

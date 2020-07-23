package com.nt.service;

public class ShoppingStore {
	
	public float calculateSingleProductBillAmt(float price ,float qty ) {
		if(qty<=0.0f || price<=0.0f)
			throw new IllegalArgumentException("Invalid inputs");
		
		return  price*qty;
		
		
	}

}

package com.nt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

import com.nt.dto.ProductDTO;

public  class ECommerceStore{ // implements IECommerceStore {
	private List<ProductDTO> cartList=new ArrayList();
	
	//method
	public String addItemToCart(ProductDTO dto) {
		cartList.add(dto);
        return dto.getPname()+" is added to Cart";
	}
	
	//method2
	public  void showCartItems(){
		System.out.println("All Items added to the cart");
		cartList.forEach(System.out::println);
		
		/* cartList.forEach(dto->{
		  System.out.println(dto);
		 });*/
		 //cartList.stream().forEach(System.out::println);
	}
	
	//method3
	public  float calcBillAmount(float cuponDiscount) {
		System.out.println("ECommerceStore.calcBillAmount():::"+cuponDiscount);
		    float bamt=0.0f;
		    float finalAmount=0.0f;
			 bamt=(float)cartList.stream().mapToDouble(dto->
		          dto.getPrice()* dto.getQty()).sum();
		finalAmount=bamt-(bamt*(cuponDiscount/100.0f));		 
		  
		return finalAmount;
		
	 	
	}

}

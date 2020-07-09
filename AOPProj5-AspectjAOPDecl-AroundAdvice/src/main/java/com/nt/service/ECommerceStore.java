package com.nt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

import com.nt.dto.ProductDTO;

public class ECommerceStore {
	private List<ProductDTO> cartList=new ArrayList();
	
	public String addItemToCart(ProductDTO dto) {
		cartList.add(dto);
        return dto.getPname()+" is added to Cart";
	}
	
	public  void showCartItems(){
		System.out.println("All Items added to the cart");
		cartList.forEach(System.out::println);
		
		/* cartList.forEach(dto->{
		  System.out.println(dto);
		 });*/
		 //cartList.stream().forEach(System.out::println);
	}
	
	public  double calcBillAmount(float cuponDiscount) {
		
		  double bamt=cartList.stream().mapToDouble(dto->
		          dto.getPrice()* dto.getQty()).sum();
				 
		  
		return bamt;
		
	 	/*finalAmount=Double.valueOf(bamt.toString())-(Double.valueOf(bamt.toString())* (cuponDiscount/100));
	 	return finalAmount;*/
	}

}

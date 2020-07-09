package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.dto.ProductDTO;
import com.nt.service.ECommerceStore;

public class AspectjAOPAroundTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		ECommerceStore target=null;
		ProductDTO p1=null,p2=null,p3=null;
		//create IOC container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Taget bean class object
		target=ctx.getBean("store",ECommerceStore.class);
		//create Products
		p1=new ProductDTO();
		p1.setPid(1); p1.setPname("table"); p1.setPrice(new Float(10000));p1.setQty(new Float(2));
		
		p2=new ProductDTO();
		p2.setPid(2); p2.setPname("chair"); p2.setPrice(new Float(10000));p2.setQty(new Float(2));
		try {
		 System.out.println(target.addItemToCart(p1));
		 System.out.println(target.addItemToCart(p2));
		 target.showCartItems();
		 System.out.println("Bill Amount::"+target.calcBillAmount(5));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		//close container
		((AbstractApplicationContext) ctx).close();

	}//main
}//class

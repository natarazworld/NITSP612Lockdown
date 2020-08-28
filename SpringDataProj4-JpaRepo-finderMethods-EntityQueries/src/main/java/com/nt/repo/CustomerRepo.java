package com.nt.repo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.Customer;

public interface CustomerRepo extends  JpaRepository<Customer,Integer> {
	     /*=> SELECT CNO,CNAME,CADD,BILLAMT  FROM CUSTOMER WHERE CADD=?
	      =>if no condition is taken default condition is Where with  " is " or "="  
	      if wrong property name is given in findByXxx method then we get 
	             "Invalid derived query! No property cadd1 found for type Customer! Did you mean 'cadd'" 
         //List<Customer> findByCadd(String addrs);*/
	
	       // SELECT CNO,CNAME,CADD,BILLAMT  FROM CUSTIMER WHERE CNAME=?
	            //List<Customer>      findByCname(String cname);
	       
	        // SELECT CNO,CNAME,CADD,BILLAMT  FROM CUSTIMER WHERE BILLAMT> ? 
	            //List<Customer>  findByBillAmtGreaterThan(double amount );
	         // SELECT CNO,CNAME,CADD,BILLAMT  FROM CUSTIMER WHERE BILLAMT< ? 
	            //List<Customer>  findByBillAmtLessThan(double amount );
	            
	            //SELECT  CNO,CNAME,CADD,BILLAMT FROM CUSTOMER WHERE CNAME like 'r%'
	               // List<Customer> findByCnameLike(String initChars);
	                
	                //SELECT  CNO,CNAME,CADD,BILLAMT FROM CUSTOMER WHERE CNAME like  'r%'
	                //List<Customer> findByCnameStartingWith(String initChars);
	
	             //SELECT  CNO,CNAME,CADD,BILLAMT FROM CUSTOMER WHERE  CNAME  LIKE '%h'
                  //  List<Customer> findByCnameEndingWith(String lastChars);
	
	             //SELECT  CNO,CNAME,CADD,BILLAMT FROM CUSTOMER WHERE  CNAME  LIKE '%j%'
	                 //Iterable<Customer> findByCnameContaining(String chars);
                    
	              // SELECT  CNO,CNAME,CADD,BILLAMT FROM CUSTOMER WHERE  CADD IS NULL
	                  //Iterable<Customer> findByCaddIsNull();
	
	        // SELECT  CNO,CNAME,CADD,BILLAMT FROM CUSTOMER WHERE  CADD IS NOT NULL
	                //Iterable<Customer> findByCaddIsNotNull();
	                  Iterable<Customer> findByCaddNotNull();
	
	
	
	               
	        
	                          
         
         
         
}

package com.nt.repo;


import java.util.Collection;

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
	                //  Iterable<Customer> findByCaddNotNull();
	
          	// SELECT  CNO,CNAME,CADD,BILLAMT FROM CUSTOMER WHERE  CNAME like '____'
	              //Iterable<Customer> findByCnameLike(String chars);
	
	        // SELECT  CNO,CNAME,CADD,BILLAMT FROM CUSTOMER WHERE  CNAME like '_____%' 
	            // Iterable<Customer> findByCnameLike(String chars);
	         //------------------------ Working with more than 1 property and condition ---------------------
	
	     //SELECT  CNO,CNAME,CADD,BILLAMT FROM CUSTOMER WHERE  BILLAMT>=4000 AND BILLAMT<=5000
	           //  Iterable<Customer>   findByBillAmtGreaterThanEqualAndBillAmtLessThanEqual(double min,double max);
	
	       //SELECT  CNO,CNAME,CADD,BILLAMT FROM CUSTOMER WHERE  BILLAMT BETWEEN(4000,6000)
	          //  Iterable<Customer>   findByBillAmtBetween(double min,double max);
	            
	            //SELECT  CNO,CNAME,CADD,BILLAMT FROM CUSTOMER WHERE  CNAME='raja' OR CADD='hyd'
	             //Iterable<Customer>   findByCnameEqualsOrCaddEquals(String name,String addrs);
	           // Iterable<Customer>   findByCnameOrCadd(String name,String addrs);
	
	           //SELECT  CNO,CNAME,CADD,BILLAMT FROM CUSTOMER WHERE	BILLAMT BETWEEN(4000,5000)  ORDER BY CNAME
	             // Iterable<Customer>   findByBillAmtBetweenOrderByCnameDesc(double min,double max);
	
	       //SELECT  CNO,CNAME,CADD,BILLAMT FROM CUSTOMER WHERE	CADD <> 'hyd'
	       // SELECT  CNO,CNAME,CADD,BILLAMT FROM CUSTOMER WHERE	CADD!='hyd'
	           //  Iterable<Customer>   findByCaddNot(String addrs);
	
	             //SELECT  CNO,CNAME,CADD,BILLAMT FROM CUSTOMER WHERE	CADD IN('vizag','hyd','delhi')
	            //     Iterable<Customer>   findByCaddIn(Collection<String> cities);
	
	            // SELECT  CNO,CNAME,CADD,BILLAMT FROM CUSTOMER WHERE	CNAME='raja' // assume CNAME is having UK constraint
	                 Customer   findByCname(String name);
	
	
	            
	            
	        
	            
	            
	
	  
	          
	
	
	        
	                  
	                  
	
	
	
	               
	        
	                          
         
         
         
}

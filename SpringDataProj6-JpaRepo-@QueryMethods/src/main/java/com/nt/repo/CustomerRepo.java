package com.nt.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nt.entity.Customer;
public interface CustomerRepo extends  JpaRepository<Customer,Integer> {
     //-------- select bulk operations with Postional params (Entity queries (all col values) -----------------------------------
	   @Query("FROM  Customer")
	   Iterable<Customer>  getAllCustomers();
	   
	   @Query("FROM  Customer WHERE  cadd=?1")
       Iterable<Customer>  getCustomersByCity(String city);
	   
	   @Query("FROM  Customer WHERE  billAmt>=?1 and billAmt<=?2 ")
       Iterable<Customer>  getCustomersByBillAmtRange(double start, double end);  
	   
	   //-------- select bulk operations with named params(Entity queries (all col values)) -----------------------------------
	   @Query("FROM  Customer WHERE  cadd IN(:cityOne,:cityTwo,:cityThree)")
       Iterable<Customer>  getCustomersByCityNames(@Param("cityOne")String city1,
    		                                                                                @Param("cityTwo")String city2,
    		                                                                             @Param("cityThree")String city3);
	   
	   @Query("FROM Customer  cust WHERE cust.cname=:name")
	   Iterable<Customer>  getCustomerByName(@Param("name")String name );
	   
	   /*@Query("FROM Customer  WHERE cno>=?1 and cno<=:max")    //invalid query
	   Iterable<Customer>  getCustomersByCnoRange(Integer min ,@Param("max")Integer end); */
	   
	   //-------- select bulk operations with named params (Specific multiple cols values --Scalar queries) -----------------------------------
	   @Query("SELECT cno,cname,cadd  FROM Customer WHERE cadd=:cty")
	    Iterable<Object[]>  getDataValuesByCity(@Param("cty")String city);
	    
	    //-------- select bulk operations with named params (Specific single col values --Scalar queries) -----------------------------------
		   @Query("SELECT billAmt FROM Customer WHERE cadd IN(:city1,:city2)")
		   Iterable<Double>  getBillAmtByCities(@Param("city1")String city1,
				                                                         @Param("city2")String city2);
		   
		    
	   
	   
}

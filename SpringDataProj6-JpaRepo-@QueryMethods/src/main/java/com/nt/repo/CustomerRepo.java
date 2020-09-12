package com.nt.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nt.entity.Customer;

//@Transactional
public interface CustomerRepo extends JpaRepository<Customer, Integer> {
	/*//-------- select bulk operations with Postional params (Entity queries (all col values) -----------------------------------
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
	  Iterable<Customer>  getCustomerByName(String name );
	  
	  @Query("FROM Customer  WHERE cno>=?1 and cno<=:max")    //invalid query
	  Iterable<Customer>  getCustomersByCnoRange(Integer min ,@Param("max")Integer end); 
	  
	  //-------- select bulk operations with named params (Specific multiple cols values --Scalar queries) -----------------------------------
	  @Query("SELECT cno,cname,cadd  FROM Customer WHERE cadd=:cty")
	   Iterable<Object[]>  getDataValuesByCity(@Param("cty")String city);
	   
	   //-------- select bulk operations with named params (Specific single col values --Scalar queries) -----------------------------------
	   @Query("SELECT billAmt FROM Customer WHERE cadd IN(:city1,:city2)")
	   Iterable<Double>  getBillAmtByCities(@Param("city1")String city1,
			                                                         @Param("city2")String city2);
	   
	  //--------------------------------------SingleRow select operation using HQL/JPQL  (Entity query) -------------
	   @Query("FROM Customer WHERE  cname=:name")  //assume "CNAME" col is having unique
	   Customer   getCustomerByCname(String name);
	 //--------------------------------------SingleRow select operation using HQL/JPQL  (Scalar query-selecting multiple specific cols) -------------
	   
	   @Query("SELECT cno,cname FROM Customer WHERE  cname=:name")
	 Object  getDataValuesByCname(String name);
	   
	 //--------------------------------------SingleRow select operation using HQL/JPQL  (Scalar query-selecting single specific col) -------------
	   @Query("SELECT billAmt FROM Customer WHERE  cname=:name")
	   Double  getBillAmtByCname(String name);
	   
	   //  ----------------------------- select query aggregate functions ------------------------------
	    @Query("SELECT MAX(billAmt) FROM Customer")
	     Double    findMaxBillAmount();
	    
	    @Query("SELECT MAX(billAmt),SUM(billAmt),AVG(billAmt),COUNT(*) FROM Customer")
	     Object    findAggregateResults();
	    
	   
	   //-----------------------------update opeartion  --------------------------------
	   @Modifying
	   @Query("UPDATE Customer SET  billAmt=billAmt+ :extraAmount WHERE cadd=:city")
	   int  modifyCustomerBillAmtByCity(String city ,double extraAmount);
	   
	   //-----------------------------delete opeartion  --------------------------------
	   @Modifying
	   @Query("DELETE FROM Customer WHERE cadd IS NULL")
	   int  deleteCustomersIfCaddIsNull();*/

	// --------------execute native SQL Select queries-------------------
	// @Query(nativeQuery = true, value = "SELECT CNO,CNAME,CADD,BILL_AMT FROM
	// CUSTOMER WHERE CADD=?")
	// @Query(nativeQuery = true, value = "SELECT CNO,CNAME,CADD,BILL_AMT FROM
	// CUSTOMER WHERE CADD=?1")
	// @Query(nativeQuery = true, value = "SELECT CNO,CNAME,CADD,BILL_AMT FROM
	// CUSTOMER WHERE CADD=:addrs")
	// Iterable<Customer> getCustomerByAddrs(String addrs);

	/*@Query(nativeQuery = true, value = "SELECT SYSDate from dual")
	  java.util.Date    getSysDate();*/

	/*	@Transactional
		@Query(nativeQuery = true, value = "INSERT INTO CUSTOMER(CNO,BILL_AMT,CADD,CNAME) VALUES(HIBERNATE_SEQUENCE.NEXTVAL,?,?,?)")
		@Modifying
		 int   insertCustomer(double billAmt,String addrs,String name); */

	// -------------------------------------------------------- Calling PL/SQL
	// procedure with IN param --------------------------

	// @Query(nativeQuery = true,value= "{call GET_CUSTOMERS_BY_ADDRS(?)}")
	// @Query(nativeQuery = true,value= "{call GET_CUSTOMERS_BY_ADDRS(?1)}")
	
	/*@Query(nativeQuery = true,value= "{call GET_CUSTOMERS_BY_ADDRS(?)}")
	Iterable<Customer>  fetchCustomerDataByAddrs(String addrs);*/
	
	/*@Procedure(value ="GET_CUSTOMERS_BY_ADDRS1" )
	 int  fetchCustomerData1ByAddrs(String addrs);
	*/

	
}

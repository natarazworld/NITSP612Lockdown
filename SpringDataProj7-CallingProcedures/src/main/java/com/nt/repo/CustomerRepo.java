package com.nt.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.nt.entity.Customer;

//@Transactional
public interface CustomerRepo extends JpaRepository<Customer, Integer> {
	
	/*@Procedure(procedureName = "GET_CUSTOMERS_COUNT_BY_ADDRS")
	int  fetchCustomersCountByAddrs(String addrs);  // method param values will become pl/sql procedures in params values
	                                                                                    // Pl/SQL procdure out param value becomes method return value 
	                                                                                    //So procedure can only one out param..
	*/
	
	/*@Procedure
	int  GET_CUSTOMERS_COUNT_BY_ADDRS(String addrs);*/
	
	
	
}

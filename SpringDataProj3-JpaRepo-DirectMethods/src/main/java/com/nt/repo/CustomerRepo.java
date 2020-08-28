package com.nt.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.nt.entity.Customer;

public interface CustomerRepo extends  JpaRepository<Customer,Integer> {

}

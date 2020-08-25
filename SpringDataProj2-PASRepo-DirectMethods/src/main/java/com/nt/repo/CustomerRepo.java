package com.nt.repo;


import org.springframework.data.repository.PagingAndSortingRepository;

import com.nt.entity.Customer;

public interface CustomerRepo extends  PagingAndSortingRepository<Customer,Integer> {

}

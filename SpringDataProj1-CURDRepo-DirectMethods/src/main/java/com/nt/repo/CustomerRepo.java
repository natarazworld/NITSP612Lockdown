package com.nt.repo;

import org.springframework.data.repository.CrudRepository;

import com.nt.entity.Customer;

public interface CustomerRepo extends  CrudRepository<Customer,Integer> {

}

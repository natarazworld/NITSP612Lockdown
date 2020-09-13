package com.nt.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nt.document.Employee;

public interface EmployeeRepo extends MongoRepository<Employee, Integer> {

}

package com.nt.service;

import java.util.List;
import java.util.Optional;

import com.nt.dto.CustomerDTO;

public interface CustomerMgmtService {
     public  String  registerCustomer(CustomerDTO dto);
     public  String  registerGroupCustomers(List<CustomerDTO> listDTO);
     public   String  removeCustomerById (int cno);
     public String  removeGivenCustomers(Iterable<CustomerDTO> itDTO);
     public  long  fetchCustomerCount();
     public  Iterable<CustomerDTO> fetchAllCustomers();
     public  Optional<CustomerDTO>  fetchCustomerById(int id);
     
}

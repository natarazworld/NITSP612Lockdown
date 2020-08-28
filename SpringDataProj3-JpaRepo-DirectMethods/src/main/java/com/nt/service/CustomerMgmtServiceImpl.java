package com.nt.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.nt.dto.CustomerDTO;
import com.nt.entity.Customer;
import com.nt.repo.CustomerRepo;

@Service("custService")
public class CustomerMgmtServiceImpl implements CustomerMgmtService {
	@Autowired
	private CustomerRepo custRepo;
	
	
	@Override
	public List<CustomerDTO> fetchAllRecordsByGivenExampleDTO(CustomerDTO dto) {
		Customer entity=null;
		Example<Customer> example=null;
		List<Customer> listEntities=null;
		List<CustomerDTO> listDTOs=new ArrayList();
		
		//Convert DTO to entity
		entity=new Customer();
		BeanUtils.copyProperties(dto, entity);

		//prepare Example object  (Wrapper around Entity object)
		example=Example.of(entity);
		
		//use repo
		listEntities=custRepo.findAll(example);
		//convert itEnties to itDTOs
		listEntities.forEach(ent->{
		    CustomerDTO dto1=new CustomerDTO();
		    BeanUtils.copyProperties(ent, dto1);
		     listDTOs.add(dto1);
	  });
	
	return listDTOs;
	}


	@Override
	public String removeAllCustomers() {
		boolean flag=true;
		//use repo
		 if(custRepo.count()>=1) {
		    custRepo.deleteAllInBatch();
		    flag=true;
		 }else {
			 flag=false;
		 }
		return flag?"All customers are deleted":" No customers found";
	}
	
	
}//class

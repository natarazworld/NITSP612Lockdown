package com.nt.service;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.nt.dto.CustomerDTO;
import com.nt.entity.Customer;
import com.nt.repo.CustomerRepo;

@Service("custService")
public class CustomerMgmtServiceImpl implements CustomerMgmtService {
	@Autowired
	private CustomerRepo custRepo;
	@Override
	public Iterable<CustomerDTO> fetchAllRecordsSortByProperty(String property,boolean asc) {
		Iterable<Customer> itEntities=null;
		Iterable<CustomerDTO> itDTOs=new ArrayList();
		
		//use repo
		itEntities=custRepo.findAll(Sort.by(asc?Direction.ASC:Direction.DESC, 
				                                                         property));
		// convert itEntities to itDTOs
		  itEntities.forEach(entity->{
			    CustomerDTO dto=new CustomerDTO();
			    BeanUtils.copyProperties(entity, dto);
			    ((ArrayList) itDTOs).add(dto);
		  });
		
		return itDTOs;
	}
	@Override
	public Iterable<CustomerDTO> fetchAllRecordsSortByProperties(boolean asc, String... properties) {
		Iterable<Customer> itEntities=null;
		Iterable<CustomerDTO> itDTOs=new ArrayList();
		
		//use repo
		itEntities=custRepo.findAll(Sort.by(asc?Direction.ASC:Direction.DESC, 
				                                                         properties));
		// convert itEntities to itDTOs
		  itEntities.forEach(entity->{
			    CustomerDTO dto=new CustomerDTO();
			    BeanUtils.copyProperties(entity, dto);
			    ((ArrayList) itDTOs).add(dto);
		  });
		
		return itDTOs;
	}
	
	@Override
	public Iterable<CustomerDTO> fetchRecordsByPageNoAndSize(int pageNo, int pageSize) {
		Pageable pageable=null;
		Page<Customer> page=null;
		Iterable<Customer> itEntities;
		Iterable<CustomerDTO> itDTOs=new ArrayList();
		//create Pageable object
		pageable=PageRequest.of(pageNo, pageSize);  //input (pageno,pagesize)
		// get Page object
		page=custRepo.findAll(pageable);
		//convert  page object into Iterable obj (List collection)
		itEntities=page.getContent();
		// convert itEntities to itDTOs
		  itEntities.forEach(entity->{
			    CustomerDTO dto=new CustomerDTO();
			    BeanUtils.copyProperties(entity, dto);
			    ((ArrayList) itDTOs).add(dto);
		  });
		
		return itDTOs;
		
	}//method
}//class

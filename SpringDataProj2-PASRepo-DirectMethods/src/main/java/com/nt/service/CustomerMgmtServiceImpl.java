package com.nt.service;


import java.util.ArrayList;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
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
		Slice<Customer> slice=null;
		Iterable<Customer> itEntities;
		Iterable<CustomerDTO> itDTOs=new ArrayList();
		//create Pageable object
		pageable=PageRequest.of(pageNo, pageSize);  //input (pageno,pagesize)
		// get Page object
		//page=custRepo.findAll(pageable);
		slice=custRepo.findAll(pageable);
		//convert  page object into Iterable obj (List collection)
		//itEntities=page.getContent();
		itEntities=slice.getContent();
		System.out.println(slice.getNumber()+"  "+slice.hasContent()+"  "+slice.isEmpty()+"  "+slice.isFirst()+"  "+slice.getNumberOfElements());
		//System.out.println(page.getNumber()+"  "+page.hasContent()+"  "+page.isEmpty()+"  "+page.isFirst()+"  "+page.getNumberOfElements()+" "+page.getTotalElements()+"  "+page.getTotalPages());
		
		// convert itEntities to itDTOs
		  itEntities.forEach(entity->{
			    CustomerDTO dto=new CustomerDTO();
			    BeanUtils.copyProperties(entity, dto);
			    ((ArrayList) itDTOs).add(dto);
		  });
		
		return itDTOs;
		
	}//method
	
	@Override
	public void fetchRecordsBypagination(int pageSize) {
		long recordsCount=0;
		long pagesCount=0;
		Pageable pageable=null;
		Page<Customer> page=null;
		//get total no.of records
		recordsCount=custRepo.count();
		pagesCount=recordsCount/pageSize;
		pagesCount=recordsCount%pageSize==0?pagesCount:++pagesCount;
		//display records through pagination
		for(int i=0;i<pagesCount;i++) {
			pageable=PageRequest.of(i, pageSize,Direction.ASC,"cname");
			page=custRepo.findAll(pageable);
			page.getContent().forEach(System.out::println);
		    System.out.println("page " +(i+1) +" of  "+ page.getTotalPages());
		}//for
	}//fetchRecords
}//class

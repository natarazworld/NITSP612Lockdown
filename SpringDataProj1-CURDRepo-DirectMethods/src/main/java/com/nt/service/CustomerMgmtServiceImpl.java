package com.nt.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dto.CustomerDTO;
import com.nt.entity.Customer;
import com.nt.repo.CustomerRepo;

@Service("custService")
public class CustomerMgmtServiceImpl implements CustomerMgmtService {
	@Autowired
	private CustomerRepo custRepo;

	@Override
	public String registerCustomer(CustomerDTO dto) {
		System.out.println(custRepo.getClass()+"---->"+Arrays.toString(custRepo.getClass().getInterfaces()));
		Customer cust=null;
		//convert dto to entity
		cust=new Customer();
		BeanUtils.copyProperties(dto,cust);
		//use repo
		cust=custRepo.save(cust);
		return  cust!=null?"Object saved with id"+cust.getCno():"Object not saved";
		
	}

	@Override
	public String registerGroupCustomers(List<CustomerDTO> listDTO) {
		List<Customer> listEntities=new ArrayList();
		List<Customer> listEntities1=null;
		String ids=new String();
		//covert listDTO to list Entities
		listDTO.forEach(dto->{
			Customer entity=new Customer();
			BeanUtils.copyProperties(dto, entity);
			listEntities.add(entity);
		});
		// use repo
		listEntities1=(List<Customer>) custRepo.saveAll(listEntities);
		/*for(Customer  e:listEntities1) {
			ids=ids+","+e.getCno();
		}*/
		 ids=listEntities1.stream().map(e->e.getCno()).collect(Collectors.toList()).toString();
				 
		return listEntities1!=null ?" Batch insertion is done with ids"+ids:" Batch insertion is not done ";
	}

	@Override
	public String removeCustomerById(int cno) {
		boolean flag=false;
	    //use repo
         flag=custRepo.existsById(cno);		  
		  if(flag) 
             custRepo.deleteById(cno);
		return flag? cno+" Customer is deleted":"Customer not exist";
	}
	
	@Override
	public String removeGivenCustomers(Iterable<CustomerDTO> itDTO) {
		Iterable<Customer> itEntities=new ArrayList();
		itDTO.forEach(dto->{
			Customer entity=new Customer();
			BeanUtils.copyProperties(dto, entity);
			((List<Customer>) itEntities).add(entity);
		});
		//use repo
		custRepo.deleteAll(itEntities);
		return "Bulk records are deleted";
	}
	
	@Override
	public long  fetchCustomerCount() {
		//use repo
		return (int) custRepo.count();
	}
	
	@Override
	public Iterable<CustomerDTO> fetchAllCustomers() {
		Iterable<Customer> itEntities=null;
		Iterable<CustomerDTO> itDTO=new ArrayList(); 
		//use reop
		itEntities=custRepo.findAll();
		//convert List Entities to listDTOs
		itEntities.forEach(entity->{
			CustomerDTO dto=new CustomerDTO();
			BeanUtils.copyProperties(entity, dto);
			((List<CustomerDTO>) itDTO).add(dto);
		});
		
		return itDTO;
	}

	
	

}

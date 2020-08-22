package com.nt.service;

import java.util.Arrays;

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
	
	

}

package com.nt.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dto.PhoneNumberDTO;
import com.nt.dto.UserDTO;
import com.nt.entity.PhoneNumber;
import com.nt.entity.User;
import com.nt.repo.PhoneNumberRepo;
import com.nt.repo.UserRepo;

@Service("tmService")
public class TelcomManagementServiceImpl implements TelcomManagementService {
	@Autowired
	  private  UserRepo userRepo;
	@Autowired
	private  PhoneNumberRepo phoneRepo;

	@Override
	public String registerCustomer(UserDTO userDTO) {
		User userEntity=null;
		Set<PhoneNumber> childEntities=new HashSet();
		Set<PhoneNumberDTO> childDTOS=null;
		   //convert DTO to Entity
		 userEntity=new User();
		 userEntity.setName(userDTO.getName());
		 userEntity.setAddrs(userDTO.getAddrs());
		 childDTOS=userDTO.getPhones();
		 childDTOS.forEach(phDTO->{
			 PhoneNumber phEntity=new PhoneNumber();
			 BeanUtils.copyProperties(phDTO,phEntity);
			 childEntities.add(phEntity);
		 });
		 userEntity.setPhones(childEntities);
		  
		   //save object
		  return "customer is saved havid  id :"+userRepo.save(userEntity).getUserId();
		 
		 
	}

}

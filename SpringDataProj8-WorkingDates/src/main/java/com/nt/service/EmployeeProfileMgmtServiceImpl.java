package com.nt.service;

import java.util.ArrayList;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dto.EmployeeInfoDTO;
import com.nt.entity.EmployeeInfo;
import com.nt.repository.EmployeeInfoRepo;

@Service("empService")
public class EmployeeProfileMgmtServiceImpl implements EmployeeProfileMgmtService {
	@Autowired
	private EmployeeInfoRepo  empRepo;

	@Override
	public Integer registerEmployee(EmployeeInfoDTO dto) {
		EmployeeInfo entity=null;
		//convert dto to entity
		entity=new EmployeeInfo();
		BeanUtils.copyProperties(dto, entity);
		//use repo
	     return empRepo.save(entity).getEid();
	}

	@Override
	public Iterable<EmployeeInfoDTO> getAllEmployees() {
		Iterable<EmployeeInfo> listEntities=null;
		Iterable<EmployeeInfoDTO> listDTO=new ArrayList();
		
		//use repo
		listEntities=empRepo.findAll();
		//convert listEntities  to  listDTOs
		listEntities.forEach(entity->{
			EmployeeInfoDTO dto=new EmployeeInfoDTO();
			BeanUtils.copyProperties(entity, dto);
			((ArrayList) listDTO).add(dto);
		});
		
		return listDTO;
	}

}

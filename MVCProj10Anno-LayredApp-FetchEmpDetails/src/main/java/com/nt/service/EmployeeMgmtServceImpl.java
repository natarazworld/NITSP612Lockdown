package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.bo.EmployeeBO;
import com.nt.dao.IEmployeeDAO;
import com.nt.dto.EmployeeDTO;

@Service("empService")
public class EmployeeMgmtServceImpl implements IEmployeeMgmtService {
	@Autowired
    private  IEmployeeDAO dao;
	
	@Override
	public List<EmployeeDTO> fetchAllEmployees() {
		List<EmployeeBO> listBO=null;
		List<EmployeeDTO> listDTO=new ArrayList();
		//use DAO
		listBO=dao.getAllEmployees();
		//convert listBO to ListDTO  having b.logic and convertions
		listBO.forEach(bo->{
			EmployeeDTO  dto=new EmployeeDTO();
			BeanUtils.copyProperties(bo, dto);
			dto.setSerialNo(listDTO.size()+1);
			dto.setGrossSalary(dto.getSal()+dto.getSal()*0.3f);
			dto.setNetSalary(dto.getGrossSalary()-dto.getGrossSalary()*0.1f);
			dto.setSal(Math.round(dto.getSal()));
			listDTO.add(dto);
		});
		return listDTO;
	}//method
}//class

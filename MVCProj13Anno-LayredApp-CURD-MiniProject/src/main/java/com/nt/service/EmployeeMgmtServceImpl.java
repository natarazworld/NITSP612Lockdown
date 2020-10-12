package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nt.bo.EmployeeBO;
import com.nt.dao.IEmployeeDAO;
import com.nt.dto.EmployeeDTO;

@Service("empService")
public class EmployeeMgmtServceImpl implements IEmployeeMgmtService {
	@Autowired
    private  IEmployeeDAO dao;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED,readOnly = true)
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

	@Override
	@Transactional(propagation = Propagation.REQUIRED,readOnly = false)
	public String registerEmployee(EmployeeDTO dto) {
		EmployeeBO bo=null;
		int count=0;
		//convert to DTO to BO
		bo=new EmployeeBO();
		BeanUtils.copyProperties(dto, bo);
	//use dAO
		count=dao.insertEmployee(bo);
		return count!=0?"Employee Registered": "Employee not registered";
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED,readOnly = true)
	public List<Integer> fetchAllDeptNos() {
	  //use DAO
		return dao.getAllDeptNos();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,readOnly = false)
	public String removeEmpByNo(int id) {
		int count=0;
		//use DAO
		count=dao.deleteEmpById(id);
		return count==0?id+" emp not found for deletion":id+"emp found and deleted";
	}
	@Override
	@Transactional(propagation = Propagation.REQUIRED,readOnly = true)
	public EmployeeDTO fetchEmpByNo(int id) {
		EmployeeDTO dto=null;
		EmployeeBO bo=null;
	    //use DAO
		bo=dao.getEmpById(id);
		// convert bo  to dto
		dto=new EmployeeDTO();
		BeanUtils.copyProperties(bo, dto);
		return dto;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED,readOnly = false)
	public String modifyEmployeeByNo(EmployeeDTO dto) {
		System.out.println(dto);
		EmployeeBO bo=null;
		int count=0;
		//convert dto to bo
		bo=new EmployeeBO();
		BeanUtils.copyProperties(dto, bo);
		//use service
		count=dao.updateEmployee(bo);
		return count==0?dto.getEmpNo()+"  employee details not found to update":dto.getEmpNo()+"  employee details are found to update";
	}
	
}//class

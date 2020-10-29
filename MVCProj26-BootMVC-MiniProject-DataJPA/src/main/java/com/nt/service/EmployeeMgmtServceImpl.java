package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nt.bo.EmployeeBO;
import com.nt.dto.EmployeeDTO;
import com.nt.repository.EmployeeRepository;

@Service("empService")
public class EmployeeMgmtServceImpl implements IEmployeeMgmtService {
	@Autowired
   private EmployeeRepository empRepo;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED,readOnly = true)
	public List<EmployeeDTO> fetchAllEmployees() {
		List<EmployeeBO> listBO=null;
		List<EmployeeDTO> listDTO=new ArrayList();
		//use DAO
		listBO=(List<EmployeeBO>) empRepo.findAll();
		//convert listBO to ListDTO  having b.logic and convertions
		listBO.forEach(bo->{
			EmployeeDTO  dto=new EmployeeDTO();
			BeanUtils.copyProperties(bo, dto);
			dto.setSerialNo(listDTO.size()+1);
			dto.setGrossSalary(dto.getSal()+dto.getSal()*0.3f);
			dto.setNetSalary(dto.getGrossSalary()-dto.getGrossSalary()*0.1f);
			dto.setSal((float)Math.round(dto.getSal().floatValue()));
			listDTO.add(dto);
		});
		return listDTO;
	}//method

	@Override
	@Transactional(propagation = Propagation.REQUIRED,readOnly = false)
	public String registerEmployee(EmployeeDTO dto) {
		EmployeeBO bo=null;
		//convert to DTO to BO
		bo=new EmployeeBO();
		BeanUtils.copyProperties(dto, bo);
	//use dAO
		bo=empRepo.save(bo);
		return bo!=null?"Employee Registered with"+bo.getEmpNo(): "Employee not registered";
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED,readOnly = true)
	public List<Integer> fetchAllDeptNos() {
	  //use DAO
		System.out.println(empRepo.getAllDeptNos());
		return empRepo.getAllDeptNos();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,readOnly = false)
	public void removeEmpByNo(int id) {
		int count=0;
		//use DAO
		empRepo.deleteById(id);
		
	}
	@Override
	@Transactional(propagation = Propagation.REQUIRED,readOnly = true)
	public EmployeeDTO fetchEmpByNo(int id) {
		EmployeeDTO dto=null;
		EmployeeBO bo=null;
	    //use DAO
		bo=empRepo.findById(id).get();
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
		//convert dto to bo
		bo=new EmployeeBO();
		BeanUtils.copyProperties(dto, bo);
		//use service
		bo=empRepo.save(bo);
		return bo==null?dto.getEmpNo()+"  employee details not found to update":dto.getEmpNo()+"  employee details are found to update";
	}
	
}//class

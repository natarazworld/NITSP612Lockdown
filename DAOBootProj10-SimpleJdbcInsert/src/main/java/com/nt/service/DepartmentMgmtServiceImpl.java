package com.nt.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.bo.DepartmentBO;
import com.nt.dao.DepartmentDAO;
import com.nt.dto.DepartmentDTO;

@Service("deptService")
public class DepartmentMgmtServiceImpl implements DepartmentMgmtService {
	@Autowired
	private DepartmentDAO dao;
	

	@Override
	public String registerDepartment(DepartmentDTO dto) {
		int count=0;
		DepartmentBO bo=null;
		//convert dto to bo
		bo=new DepartmentBO();
		BeanUtils.copyProperties(dto,bo);
		//use DAO
		count=dao.insert(bo);
		return count==0?"Registrtion failed":"Registrtion succeded";
		
	}

}

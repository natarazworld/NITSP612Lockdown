package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.bo.StudentBO;
import com.nt.dao.StudentDAO;
import com.nt.dto.StudentDTO;

@Service("studService")
public class StudentMgmtServiceImpl implements StudentMgmtService {
	@Autowired
	private StudentDAO dao;

	@Override
	public StudentDTO fetchStudentById(int no) {
		StudentBO bo=null;
		StudentDTO dto=null;
		//use DAO
		bo=dao.getStudentById(no);
		//convert BO to DTO
		dto=new StudentDTO();
		BeanUtils.copyProperties(bo, dto);
		return dto;
	}

	@Override
	public List<StudentDTO> fetchStudentByAddrs(String addrs) {
		List<StudentBO> listBO=null;
		List<StudentDTO> listDTO=new ArrayList();
		//use DAO
		listBO=dao.getStudentsByAddrs(addrs);
		//convert listBO to listDTO
		listBO.forEach(bo->{
			StudentDTO dto=new StudentDTO();
			BeanUtils.copyProperties(bo, dto, "avg");
			dto.setAvg(Math.round(bo.getAvg()));
		    dto.setSrNo(listDTO.size()+1);	
		    listDTO.add(dto);
		});
		return listDTO;
	}//method

	@Override
	public List<StudentDTO> fetchStudentsByCity(String city) {
		List<StudentBO> listBO=null;
		List<StudentDTO> listDTO=new ArrayList();
		//use DAO
		listBO=dao.getStudentsByCity(city);
		//convert listBO to listDTO
		listBO.forEach(bo->{
			StudentDTO dto=new StudentDTO();
			BeanUtils.copyProperties(bo, dto, "avg");
			dto.setAvg(Math.round(bo.getAvg()));
		    dto.setSrNo(listDTO.size()+1);	
		    listDTO.add(dto);
		});
		return listDTO;
	}

}//class

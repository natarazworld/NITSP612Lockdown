package com.nt.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nt.dao.ProjectDAO;
import com.nt.dto.ProjectDTO;
import com.nt.entity.Project;

@Service("projService")
@Transactional
public class ProjectMgmtServiceImpl implements ProjectMgmtService {
	@Autowired
	private ProjectDAO dao;

	@Override
	public String registerProject(ProjectDTO dto) {
		Project entity=null;
		Integer idVal=0;
		  //convert DTO to BO/Entity
		entity=new Project();
		BeanUtils.copyProperties(dto,entity);
		  //use DAO
		idVal=dao.insert(entity);
		return "Project is registered with the id ::"+idVal;
	}

}

package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nt.dao.ProjectDAO;
import com.nt.dto.ProjectDTO;
import com.nt.entity.Project;

@Service("projService")
@Transactional(transactionManager = "hbTxMgmr")
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

	@Override
	public  Object fetchProjectById(int id) {
		Project proj=null;
		ProjectDTO dto=null;
		//use DAO
		proj=dao.getProjectById(id);
		//convert to entity object DTO
		 
		 if(proj!=null) {
			 dto=new ProjectDTO();
		     BeanUtils.copyProperties(proj, dto);
		 }
		return dto!=null?dto:"record not found";
          
	}

	@Override
	public String modifyProjectById(int id, int teamSize, double cost) {
		boolean flag=false;
		//use DAO
		flag=dao.updateProjectById(id, teamSize, cost);
		return flag==false?"record not found for update": "record updated";
	}

	@Override
	public String removeProjectById(int id) {
		   boolean flag=false;
	        //use DAO
		   flag=dao.deleteProjectById(id);
		   
		return flag==true?"record found and deleted":"record not found for deletion";
	}

	@Override
	public List<ProjectDTO> fetchProjectsByCostRange(double start, double end) {
		List<Project> listEntities=null;
		List<ProjectDTO> listDTO=new ArrayList();
		
		//use DAO
		listEntities=dao.getProjectsByCostRange(start, end);
		//convert  listEntties to listDTOs
		listEntities.forEach(entity->{
		   	ProjectDTO dto=new ProjectDTO();
		   	BeanUtils.copyProperties(entity, dto);
		   	listDTO.add(dto);
		});
		
		return listDTO;
	}

}

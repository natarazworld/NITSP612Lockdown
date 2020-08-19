package com.nt.service;

import java.util.List;

import com.nt.dto.ProjectDTO;

public interface ProjectMgmtService {
	
	public  String registerProject(ProjectDTO  dto);
	public  Object  fetchProjectById(int id);
	public   String  modifyProjectById(int id, int teamSize, double cost);
	public  String   removeProjectById(int id);
	public  List<ProjectDTO>  fetchProjectsByCostRange(double start, double end);

}

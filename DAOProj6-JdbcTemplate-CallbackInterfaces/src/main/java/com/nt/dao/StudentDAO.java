package com.nt.dao;

import java.util.List;

import com.nt.bo.StudentBO;

public interface StudentDAO {
	
	public  StudentBO  getStudentById(int no);
	public  List<StudentBO>   getStudentsByAddrs(String addrs);
	

}

package com.nt.service;

import java.util.List;

import com.nt.dto.StudentDTO;

public interface StudentMgmtService {
	
	public  StudentDTO  fetchStudentById(int no);
	public List<StudentDTO> fetchStudentByAddrs(String addrs);

}

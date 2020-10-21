package com.nt.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nt.dto.StudentDTO;

@Service("studService")
public class StudentMgmtServiceImpl implements StudentMgmtService {

	@Override
	public List<StudentDTO> getAllStudents() {
		return List.of(new StudentDTO(101,"raja","hyd",90.4f),
				               new StudentDTO(102,"ramesh","vizag",30.4f),
				               new StudentDTO(103,"lokesh","delhi",60.4f)
				              );
	}

}

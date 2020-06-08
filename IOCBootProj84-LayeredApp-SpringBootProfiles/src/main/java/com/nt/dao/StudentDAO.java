package com.nt.dao;

import org.springframework.lang.NonNull;

import com.nt.bo.StudentBO;

public interface StudentDAO {
	
	public   int insert(@NonNull StudentBO bo)throws Exception;

}

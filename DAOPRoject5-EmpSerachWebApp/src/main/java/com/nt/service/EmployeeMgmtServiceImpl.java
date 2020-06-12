package com.nt.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dao.EmployeeDAO;

@Service("empService")
public class EmployeeMgmtServiceImpl implements EmployeeMgmtService {
	@Autowired
	private  EmployeeDAO  dao;

	@Override
	public List<Map<String, Object>> fetchEmpsByDesgs(String[] desg) {
		StringBuffer sb=null;
		String cond=null;
		List<Map<String,Object>> listMap=null;
		//convert desg[]  as required for query condition
		sb=new StringBuffer("(");
		for(int i=0;i<desg.length;++i) {
			if(i==desg.length-1)
				sb.append("'"+desg[i]+"')");
			else
				sb.append("'"+desg[i]+"',");
		}
		//convert to String
		cond=sb.toString();
		//use dao
		listMap=dao.getEmpsByDesgs(cond);
		
		return listMap;
	}

}

package com.nt.dao;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

public class EmployeeDAOImpl implements EmployeeDAO {
	private static final String GET_EMPS_COUNT="SELECT COUNT(*) FROM EMP";
	private  static final String GET_EMP_NAME_BY_NO="SELECT ENAME FROM EMP WHERE EMPNO=?";
	private static final String GET_EMP_DETAILS_BY_NO="SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP WHERE EMPNO=?";
	private static final String GET_EMPs_BY_DESGS="SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP WHERE JOB IN(?,?)";
	private static final String EMP_INSERT_QUERY="INSERT INTO EMP(EMPNO,ENAME,JOB,SAL) VALUES(?,?,?,?)";
	private static final String UPDATE_EMP_SALARY_BY_SALARYRANGE="UPDATE EMP SET SAL=SAL+(SAL*?) WHERE SAL<?";
	private static final String DELETE_EMP_BY_SALARYRANGER="DELETE FROM EMP WHERE SAL>=? and SAL<=?";
	private JdbcTemplate jt;

	public EmployeeDAOImpl(JdbcTemplate jt) {
	  System.out.println("EmployeeDAOImpl:: 1-param constructor");
		this.jt = jt;
	}

	public int getEmpsCount() {
		int count=0;
		count=jt.queryForObject(GET_EMPS_COUNT, Integer.class);
		return count;
	}

	public String getEmpNameByNo(int empNo) {
		String name=null;
		name=jt.queryForObject(GET_EMP_NAME_BY_NO, String.class, empNo);
		return name;
	}

	public Map<String, Object> getEmpByNo(int empNo) {
		Map<String,Object> map=null;
	    map=jt.queryForMap(GET_EMP_DETAILS_BY_NO,empNo);
		return map;
	}
	
	public List<Map<String, Object>> getEmpsByDesgs(String desg1, String desg2) {
		List<Map<String,Object>> listMap=null;
		listMap=jt.queryForList(GET_EMPs_BY_DESGS,desg1,desg2);
		return listMap;
	}
	
	public int insert(int eno, String ename, String desg, float salary) {
	    int count=0;
	    count=jt.update(EMP_INSERT_QUERY, eno,ename,desg,salary);
		return count;
	}
	
	public int updateSalary(float salRange, float Percentage) {
	   int count=0;
	   count=jt.update(UPDATE_EMP_SALARY_BY_SALARYRANGE,(Percentage/100.0f),salRange);
	   return count;
	}
	
	public int deleteEmployeesBySalaryRange(float start, float end) {
		int count=0;
		count=jt.update(DELETE_EMP_BY_SALARYRANGER, start,end);
	    return count;
	}

}

package com.nt.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class EmployeeDTO implements Serializable {
	private int serialNo;
	private Integer empNo;
	private String ename;
	private String job;
	private float sal;
	private int deptNo;
	private float grossSalary;
	private float netSalary;

		

}

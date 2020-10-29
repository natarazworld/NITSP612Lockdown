package com.nt.model;

import lombok.Data;

@Data
public class Employee {
	private Integer empNo;
    private String ename;
    private String job;
    private Float sal=10000.0f;
    private Integer deptNo=10;
    private String  vflag="no";
    
    
}

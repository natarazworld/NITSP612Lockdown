package com.nt.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="EMP")
public class EmployeeBO {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="EMPNO")
   private  Integer empNo;
   private  String ename;
   private  String job;
   private   Float sal;
   @Column(name="DEPTNO")
   private  Integer deptNo;
 
}

package com.nt.service;

import java.util.List;

import com.nt.dto.EmployeeDTO;

public interface IEmployeeMgmtService {
    public   List<EmployeeDTO>  fetchAllEmployees();
    public  String  registerEmployee(EmployeeDTO dto);
    public  List<Integer>  fetchAllDeptNos();
    public String     removeEmpByNo(int id);
    public EmployeeDTO fetchEmpByNo(int id);  
    public String  modifyEmployeeByNo(EmployeeDTO dto);
}

package com.nt.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.nt.bo.EmployeeBO;
import com.nt.dto.EmployeeDTO;

public interface IEmployeeMgmtService {
    public   List<EmployeeDTO>  fetchAllEmployees();
    public  String  registerEmployee(EmployeeDTO dto);
    public  List<Integer>  fetchAllDeptNos();
    public void      removeEmpByNo(int id);
    public EmployeeDTO fetchEmpByNo(int id);  
    public String  modifyEmployeeByNo(EmployeeDTO dto);
    public Page<EmployeeDTO>   getPageData(Pageable pageable);
}

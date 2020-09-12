package com.nt.service;

import com.nt.dto.EmployeeInfoDTO;
import com.nt.entity.EmployeeInfo;

public interface EmployeeProfileMgmtService {
     public  Integer  registerEmployee(EmployeeInfoDTO dto);
     public  Iterable<EmployeeInfoDTO>  getAllEmployees();
}

package com.nt.service;

import java.util.List;
import java.util.Optional;

import com.nt.dto.CustomerDTO;

public interface CustomerMgmtService {
     public Iterable<CustomerDTO> fetchAllRecordsSortByProperty(String property,boolean asc);
     public Iterable<CustomerDTO> fetchAllRecordsSortByProperties(boolean asc,String ... properties);
     public  Iterable<CustomerDTO> fetchRecordsByPageNoAndSize(int pageNo,int pageSize);
     
     
}

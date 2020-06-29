package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.bo.BankAccountBO;
import com.nt.dao.BankAccountDAO;
import com.nt.dto.BankAccountDTO;

@Service("bankService")
public class BankAccountMgmtServiceImpl implements BankAccountMgmtService {
	@Autowired
	private BankAccountDAO dao; 

	@Override
	public BankAccountDTO fetchAccountDetailsByNo(int no) {
		BankAccountBO bo=null;
		BankAccountDTO dto=null;
		//use DAO
		bo=dao.getBankAccountByNo(no);
		//copy BO to DTO
		dto=new BankAccountDTO();
		BeanUtils.copyProperties(bo,dto);
		return dto;
	}//method

	@Override
	public List<BankAccountDTO> fetchAccountDetailsByBalanceRange(float start, float end) {
		List<BankAccountBO> listBO=null;
		List<BankAccountDTO> listDTO=new ArrayList();
		//use DAO
		listBO=dao.getBankAccountByBalanceRanage(start, end);
		//convert listBO to listDTO
		listBO.forEach(bo->{
			BankAccountDTO dto=new BankAccountDTO();
			BeanUtils.copyProperties(bo,dto);
			listDTO.add(dto);
		});
		return listDTO;
	}//method

	@Override
	public String addBounsToAccountsByBalanceRange(float start, float end, float amount) {
		int count=0;
		//use DAO
		count=dao.updateBalnaceByBalanceRanage(start, end, amount);
		return count+" no.of employees are added with Bonus";
	}

}//class

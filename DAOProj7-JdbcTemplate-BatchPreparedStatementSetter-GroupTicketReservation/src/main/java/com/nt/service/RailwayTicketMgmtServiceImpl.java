package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.bo.PassengerDetailsBO;
import com.nt.dao.RailwayTicketReservationDAO;
import com.nt.dto.PassengerDetailsDTO;

@Service("railwayService")
public class RailwayTicketMgmtServiceImpl implements RailwayTicketMgmtService {
	@Autowired
	private  RailwayTicketReservationDAO dao;

	@Override
	public String groupTicketReservation(List<PassengerDetailsDTO> listDTO) {
		List<PassengerDetailsBO> listBO=new ArrayList();
		int result[]=null;
		//convert listDTO to  listBO
		listDTO.forEach(dto->{
			PassengerDetailsBO bo=new PassengerDetailsBO();
			BeanUtils.copyProperties(dto,bo);
			listBO.add(bo);
		});
		//use DAO
		result=dao.batchInsert(listBO);
		if(result!=null)
			return "Group reseveration succeded";
		else
			return "Group reseveration failed";
	}//method
}//class

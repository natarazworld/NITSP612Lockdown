package com.nt.service;

import java.util.List;

import com.nt.dto.PassengerDetailsDTO;

public interface RailwayTicketMgmtService {
	public String  groupTicketReservation(List<PassengerDetailsDTO> listDTO);

}

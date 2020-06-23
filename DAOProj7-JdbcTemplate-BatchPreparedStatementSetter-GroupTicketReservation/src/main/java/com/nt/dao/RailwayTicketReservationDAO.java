package com.nt.dao;

import java.util.List;

import com.nt.bo.PassengerDetailsBO;

public interface RailwayTicketReservationDAO {
	
	public  int[] batchInsert(List<PassengerDetailsBO> listBO);

}

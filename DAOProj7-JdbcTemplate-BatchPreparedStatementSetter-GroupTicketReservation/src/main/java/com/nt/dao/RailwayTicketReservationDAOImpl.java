package com.nt.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nt.bo.PassengerDetailsBO;

@Repository("railwayDAO")
public class RailwayTicketReservationDAOImpl implements RailwayTicketReservationDAO {
    private static final String RAILWAY_TICKET_RESERVATION="INSERT INTO RAILWAY_RESERVATION VALUES(TKID_SEQ.NEXTVAL,?,?,?,?,?,?)";
    		
	@Autowired
	private JdbcTemplate jt;
    
	@Override
	public int[] batchInsert(final List<PassengerDetailsBO> listBO) {
		int result[]=null;
		result=jt.batchUpdate(RAILWAY_TICKET_RESERVATION,
				              new BatchPreparedStatementSetter() {
								
								@Override
								public void setValues(PreparedStatement ps, int i) throws SQLException {
									System.out.println(
											"RailwayTicketReservationDAOImpl.batchInsert(...).new BatchPreparedStatementSetter() {...}.setValues()");
                                   ps.setString(1,listBO.get(i).getPassengerName());
                                   ps.setInt(2,listBO.get(i).getAge());
                                   ps.setString(3,listBO.get(i).getSourcePlace());
                                   ps.setString(4,listBO.get(i).getDestinationPlace());
                                   ps.setFloat(5,listBO.get(i).getPrice());
                                   ps.setString(6,listBO.get(i).getGender());
									
								}
								
								@Override
								public int getBatchSize() {
									System.out.println(
											"RailwayTicketReservationDAOImpl.batchInsert(...).new BatchPreparedStatementSetter() {...}.getBatchSize()");
									return listBO.size();
								}
							});
		
		return result;
	}

}

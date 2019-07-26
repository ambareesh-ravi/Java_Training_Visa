package com.visa.prj.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.visa.prj.entity.Employee;
import com.visa.prj.entity.Ticket;

public interface TicketDao extends JpaRepository<Ticket, Integer> {

	@Query("FROM Ticket t where t.resolvedInfo IS NOT NULL")
	List<Ticket> displayAllResolvedTickets();
	
	@Query("FROM Ticket t where t.resolvedInfo IS NULL")
	List<Ticket> displayAllUnresolvedTickets();
	
	@Query("UPDATE Ticket t set t.ticketResolvedDate =:trd , t.employee1 =:e1 , t.resolvedInfo =:info")
	void resolveTicket(@Param("trd")Date trd,@Param("e1")Employee e1,@Param("info")String info);
	
	Ticket findByTicketId(int id);
	
	
}

package com.visa.prj.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.visa.prj.dao.EmployeeDao;
import com.visa.prj.dao.TicketDao;
import com.visa.prj.entity.Department;
import com.visa.prj.entity.Ticket;

@Service
public class TicketService {

	@Autowired
	private TicketDao ticketDao;
	
	@Autowired
	private EmployeeDao employeeDao;
	
	public List<Ticket> getAllTickets() {
		return ticketDao.findAll();
	}
	
	public List<Ticket> displayAllResolvedTickets() {
		return ticketDao.findAll();
	}
	
	public List<Ticket> displayAllUnresolvedTickets() {
		return ticketDao.findAll();
	}
	
	public Ticket getTicketById(int id) {
		return ticketDao.findByTicketId(id);
	}
	/*
	public Ticket getTicketById(int id) {
		return ticketDao.findById(id);
	}*/
	
	@Transactional
	public void raiseTicket(Ticket t, String email) {
		t.setEmployee(employeeDao.getEmployeeById(email));
		ticketDao.save(t);
	}
	
	@Transactional
	public void resolveTicket(Ticket resolved) {
		ticketDao.save(resolved);

	}

}

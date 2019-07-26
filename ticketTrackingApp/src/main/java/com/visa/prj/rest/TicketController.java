package com.visa.prj.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.visa.prj.dao.EmployeeDao;
import com.visa.prj.entity.Department;
import com.visa.prj.entity.Ticket;
import com.visa.prj.service.DepartmentService;
import com.visa.prj.service.EmployeeService;
import com.visa.prj.service.TicketService;

@RestController
public class TicketController {

	@Autowired
	private TicketService service;
	
	@Autowired
	private EmployeeDao employeeDao;
	
	@GetMapping("tickets")
	public @ResponseBody List<Ticket> getTickets() {
			return service.getAllTickets();
	}
	
	/*
	@GetMapping("tickets/{id}")
	public @ResponseBody Ticket getTicket(@PathVariable("id") int id) {
		return service.getTicketById(id);
	}*/
	
	@GetMapping("resolve")
	public @ResponseBody List<Ticket> getAllUnresolvedTickets(@RequestParam(name="emp_id",required=false) String user_id) {
			return service.displayAllUnresolvedTickets();
	}
	/*
	@PostMapping("resolve/{id}")
	public ResponseEntity<Ticket> resolveTicket(@RequestBody Ticket t, @PathVariable("id") String email_id) {
		service.resolveTicket(t.getTicketResolvedDate(),email_id,t.getResolvedInfo());
		return new ResponseEntity<>(t,HttpStatus.CREATED);
	}*/
	
	@PostMapping("resolve/{id}")
	public ResponseEntity<Ticket> resolveTicket(@RequestParam(name="t_id")int id,@RequestBody Ticket t, @PathVariable("id") String email_id) {
		Ticket resolving = service.getTicketById(id);
		resolving.setEmployee1(employeeDao.getEmployeeById(email_id));
		resolving.setResolvedInfo(t.getResolvedInfo());
		resolving.setTicketResolvedDate(t.getTicketResolvedDate());
		System.out.println(resolving);
		service.resolveTicket(resolving);
		return new ResponseEntity<>(t,HttpStatus.CREATED);
	}
	
	@PostMapping("raise/{id}")
	public ResponseEntity<Ticket> raiseTicket(@RequestBody Ticket t, @PathVariable("id") String email_id) {
		service.raiseTicket(t,email_id);
		return new ResponseEntity<>(t,HttpStatus.CREATED);
	}
}

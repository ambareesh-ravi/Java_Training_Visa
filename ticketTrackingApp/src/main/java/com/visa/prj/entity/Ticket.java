package com.visa.prj.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ticketId;
	
	private String ticketDescription;
	
	@Column(name="raise_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date ticketRaiseDate = new Date();
	
	@ManyToOne
	@JoinColumn(name="raisedBy")
	private Employee employee;
	
	@Column(name="resolved_date")
	private Date ticketResolvedDate;
	@ManyToOne
	@JoinColumn(name="resolvedBy")
	private Employee employee1;
	
	private String resolvedInfo;

	public int getTicketId() {
		return ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	public String getTicketDescription() {
		return ticketDescription;
	}

	public void setTicketDescription(String ticketDescription) {
		this.ticketDescription = ticketDescription;
	}

	public Date getTicketRaiseDate() {
		return ticketRaiseDate;
	}

	public void setTicketRaiseDate(Date ticketRaiseDate) {
		this.ticketRaiseDate = ticketRaiseDate;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Date getTicketResolvedDate() {
		return ticketResolvedDate;
	}

	public void setTicketResolvedDate(Date ticketResolvedDate) {
		this.ticketResolvedDate = ticketResolvedDate;
	}

	public Employee getEmployee1() {
		return employee1;
	}

	public void setEmployee1(Employee employee1) {
		this.employee1 = employee1;
	}

	public String getResolvedInfo() {
		return resolvedInfo;
	}

	public void setResolvedInfo(String resolvedInfo) {
		this.resolvedInfo = resolvedInfo;
	}
	
	
}

package com.visa.prj.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.visa.prj.entity.Booking;

public interface BookingDao extends JpaRepository<Booking, Integer> {

	List<Booking> findByUser_email(String user_email);
}

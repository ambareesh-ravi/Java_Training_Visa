package com.visa.prj.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.visa.prj.dao.BookingDao;
import com.visa.prj.entity.Booking;
import com.visa.prj.entity.Hotel;
import com.visa.prj.entity.SearchCriteria;
import com.visa.prj.entity.User;

@Service
public class BookingService {
	
	@Autowired
	private BookingDao bookingDao;
	
	public List<Hotel> getHotels() {
		return bookingDao.findHotels("All");
	}
	
	@Transactional
	public long bookHotelById(Booking b) {
		//Again load the object here to move the objects into persistence Context
		User u = bookingDao.getUser(b.getUser().getEmail(), b.getUser().getPassword());
		Hotel h = bookingDao.findHotelById(b.getHotel().getId());
		b.setHotel(h);
		b.setUser(u);
		b.setBeds(5);
		b.setSmoking(false);
		long idd = bookingDao.createBooking(b);
		return idd;
	}
	
	public User getUser(String user_Email,String user_Password) {
		return bookingDao.getUser(user_Email, user_Password);
	}
	
	public Hotel getHotelById(long id) {
		return bookingDao.findHotelById(id);
	}
	
	public List<Hotel> searchHotel(SearchCriteria s) {
		return bookingDao.findHotels(s.getSearchString());
	}
	public List<Booking> getBookingsBasedOnUser(User u) {
		return bookingDao.getAllBookingsOfUser(u);
	}
	
	
	
	
	
	
	
	
	
	

}

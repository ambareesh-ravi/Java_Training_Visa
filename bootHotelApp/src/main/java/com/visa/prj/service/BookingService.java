package com.visa.prj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.visa.prj.dao.BookingDao;
import com.visa.prj.dao.HotelDao;
import com.visa.prj.dao.UserDao;
import com.visa.prj.entity.Booking;
import com.visa.prj.entity.Hotel;
import com.visa.prj.entity.User;

@Service
public class BookingService {
	
	@Autowired
	private BookingDao bookingDao;
	
	@Autowired
	private HotelDao hotelDao;
	
	@Autowired
	private UserDao userDao;
	
	/*
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
	
	
	
	public List<Hotel> searchHotel(SearchCriteria s) {
		return bookingDao.findHotels(s.getSearchString());
	}
	*/
	public List<Booking> getBookingsBasedOnUser(String email) {
		return bookingDao.findByUser_email(email);
	}
	public List<Booking> getAllBookings() {
		return bookingDao.findAll();
	}
	
	@Transactional
	public void addBooking(Booking b) {
		bookingDao.save(b);
	}
		
	
	public List<Hotel> getAllHotels() {
		return hotelDao.findAll();
	}
	public Hotel getHotelById(long id) {
		return hotelDao.findById(id);
	}
	
	public List<Hotel> getHotelBySearch(String search) {
		return hotelDao.searchHotels(search);
	}
	
	@Transactional
	public void addHotel(Hotel h) {
		hotelDao.save(h);
	}
	
	
	
	
	public List<User> getAllUsers() {
		return userDao.findAll();
	}
	
	@Transactional
	public void addUser(User u) {
		userDao.save(u);
	}
	
	
	
	
	
	
	

}

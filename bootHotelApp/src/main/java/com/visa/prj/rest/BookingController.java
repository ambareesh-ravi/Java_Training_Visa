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

import com.visa.prj.entity.Booking;
import com.visa.prj.entity.Hotel;
import com.visa.prj.entity.User;
import com.visa.prj.service.BookingService;

@RestController
public class BookingController {
	
	@Autowired
	private BookingService service;
	
	@GetMapping("bookings")
	public @ResponseBody List<Booking> getBookings(@RequestParam(name="user_id",required=false) String user_id) {
		if(user_id!=null) {
			return service.getBookingsBasedOnUser(user_id);
		}
		else {
			return service.getAllBookings();
		}
	}
	
	@PostMapping("bookings")
	public ResponseEntity<Booking> addBooking(@RequestBody Booking b) {
		service.addBooking(b);
		return new ResponseEntity<>(b,HttpStatus.CREATED);
	}
	
	
	
	
	
	
	
	
	@GetMapping("hotels")
	public @ResponseBody List<Hotel> getHotels(@RequestParam(name="search", required=false ) String search) {
		if(search==null) {
		return service.getAllHotels();
		}
		else {
			return service.getHotelBySearch(search);
		}
	}
	
	
	
	
	@GetMapping("hotels/{id}")
	public @ResponseBody Hotel getHotelById(@PathVariable("id") long id ) {
		return service.getHotelById(id);
	}
	
	@PostMapping("hotels")
	public ResponseEntity<Hotel> addHotel(@RequestBody Hotel h) {
		service.addHotel(h);
		return new ResponseEntity<>(h,HttpStatus.CREATED);
	}
	
	
	
	
	@GetMapping("users")
	public @ResponseBody List<User> getAllUsers() {
		return service.getAllUsers();
	}
	
	@PostMapping("users")
	public ResponseEntity<User> addUser(@RequestBody User u) {
		service.addUser(u);
		return new ResponseEntity<>(u,HttpStatus.CREATED);
	}

}

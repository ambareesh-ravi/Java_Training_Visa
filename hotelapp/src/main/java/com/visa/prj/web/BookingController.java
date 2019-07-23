package com.visa.prj.web;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.visa.prj.entity.Booking;
import com.visa.prj.entity.User;
import com.visa.prj.service.BookingService;

@Controller
public class BookingController {

	@Autowired
	private BookingService bookingService;
	

	@RequestMapping("bookingForm.do")
	public String openBookingForm(@RequestParam("id") long id,Model m) {
		
		Booking b = new Booking();
		b.setHotel(bookingService.getHotelById(id));
		System.out.println(b.getHotel());
		System.out.println("***********");
		User user = new User(); //Should get from service
		user.setEmail("a@visa.com"); //assume "a@visa.com" exists in DB
		b.setUser(user);
		m.addAttribute("booking",b);
		return "bookingForm.jsp";
	}
	
	
	@RequestMapping("placeReservation.do")
	public String placeReservation(@ModelAttribute("booking") Booking b) {
		
		System.out.println(b.getHotel().getId());
		System.out.println(b.getUser().getEmail());
		System.out.println(b.getCheckinDate());
		System.out.println(b.getCheckoutDate());
		// send booking to Service --> DAO ==> DB
		return "index.jsp";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		sdf.setLenient(true); //If we give 31st Feb, it will convert to 3rd March.
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf,false));
	}
}

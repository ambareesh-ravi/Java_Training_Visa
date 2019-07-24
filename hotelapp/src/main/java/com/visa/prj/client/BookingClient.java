package com.visa.prj.client;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.visa.prj.entity.Booking;
import com.visa.prj.entity.Hotel;
import com.visa.prj.entity.SearchCriteria;
import com.visa.prj.entity.User;
import com.visa.prj.service.BookingService;

public class BookingClient {

		public static void main(String[] args) {
			AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
			ctx.scan("com.visa");
			ctx.refresh();
			
			User u1 = new User("ambareesh05","pass","Ambareesh");
			u1.setEmail("ambareesh1205@gmail.com");
			
			User u2 = new User("ambu","pass","Ambareesh R");
			u2.setEmail("amba@visa.com");
			
			
			BookingService service = ctx.getBean("bookingService", BookingService.class);
//			List<Hotel> hotels = service.getHotels();
//			
//			for (Hotel h : hotels) {
//				System.out.println(h);
//			}
			
			Booking b = new Booking();
			User u = service.getUser(u1.getEmail(), u2.getPassword());
			Hotel h = service.getHotelById(1);
			b.setHotel(h);
			b.setUser(u);
			System.out.println("Booking Done with booking id" + service.bookHotelById(b));
			
			SearchCriteria s = new SearchCriteria();
			s.setSearchString("Place");
			s.setPage(3);
			s.setPageSize(5);
			List<Hotel> l1 = service.searchHotel(s);
			for (Hotel hotel : l1) {
				System.out.println(hotel);
			}
			
			SearchCriteria s1 = new SearchCriteria();
			s1.setSearchString("Manhattan");
			s1.setPage(5);
			s1.setPageSize(10);
			List<Hotel> l2 = service.searchHotel(s1);
			for (Hotel hotel : l2) {
				System.out.println(hotel);
			}
			
			List<Booking> myBookings = service.getBookingsBasedOnUser(u1);
			System.out.println("All bookings of User 1:");
			for (Booking booking : myBookings) {
				System.out.println(booking.getDescription());
			}
			
			
		}
}

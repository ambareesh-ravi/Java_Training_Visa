package com.visa.prj.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

//import com.visa.prj.entity.Booking;
import com.visa.prj.entity.Hotel;

public interface HotelDao extends JpaRepository<Hotel, Integer> {

	Hotel findById(long id);
	
	@Query("from Hotel h where h.name LIKE %:search% OR h.address LIKE %:search% OR h.city LIKE %:search%")
	List<Hotel> searchHotels(@Param("search") String search);
}

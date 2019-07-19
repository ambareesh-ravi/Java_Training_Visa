package com.visa.prj.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.visa.prj.entity.Booking;
import com.visa.prj.entity.Hotel;
import com.visa.prj.entity.User;

@Repository
public class BookingDaoJpaImpl implements BookingDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Hotel> findHotels(String criteria) {
		TypedQuery<Hotel> query = em.createQuery("from Hotel where hotel_name LIKE :hn OR address LIKE :a",Hotel.class);
		//System.out.println(criteria);
		query.setParameter("hn", "%" + criteria + "%");
		query.setParameter("a", "%" + criteria + "%");
		return query.getResultList();
	}

	@Override
	public Hotel findHotelById(long id) {
		return em.find(Hotel.class, id);
	}

	@Override
	public User getUser(String email, String password) {
		//return em.find(User.class, email);
		TypedQuery<User> query = em.createQuery("from User where email =:e and password =:p",User.class);
		query.setParameter("e", email);
		query.setParameter("p", password);
		//return query.getResultList().get(0)
		return query.getSingleResult();
	}

	@Override
	public long createBooking(Booking booking) {
		em.persist(booking);
		return booking.getId();
	}

	@Override
	public List<Booking> getAllBookingsOfUser(User user) {
		String user_id = user.getEmail();
		TypedQuery<Booking> query = em.createQuery("from Booking where user_email=:ue",Booking.class);
		query.setParameter("ue", user_id);
		return query.getResultList();
	}

}

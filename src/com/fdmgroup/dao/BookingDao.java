package com.fdmgroup.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.fdmgroup.model.Booking;
import com.fdmgroup.model.Seating;

public class BookingDao {
private DbConnection connection = null;
	
	public BookingDao() {
		super();
		connection = DbConnection.getInstance();
	}
	
	public void create(Booking m) {
		EntityManager em = connection.getEntityManager();
		em.getTransaction().begin();

		em.persist(m);

		em.getTransaction().commit();
		em.close();
	}
	
	public Booking findById(int id) {
		EntityManager em = connection.getEntityManager();
		Booking foundMovie = em.find(Booking.class, id);
		em.close();
		return foundMovie;
	}
	
	public List<Booking> findAll() {
		EntityManager em = connection.getEntityManager();
		TypedQuery<Booking> query = em.createNamedQuery("Booking.findAll", Booking.class);
		List<Booking> movies = query.getResultList();
		em.close();
		
		return movies;
	}
	
	public boolean delete(Booking m) {
		EntityManager em = connection.getEntityManager();
		Booking foundMovie = em.find(Booking.class, m.getId());
		
		if (foundMovie == null) {
			return false;
		}
		
		em.getTransaction().begin();
		em.remove(foundMovie);
		em.getTransaction().commit();
		em.close();
		return true;
	}
	
	public void update(Booking m) {
		EntityManager em = connection.getEntityManager();
		Booking foundMovie = em.find(Booking.class, m.getId());
		em.getTransaction().begin();
		foundMovie.setQuantity(m.getQuantity());;
		foundMovie.setSeatingid(m.getSeatingid());;
		foundMovie.setUserid(m.getUserid());
		
		em.getTransaction().commit();
		em.close();
	}
	public List<Booking> findByUserId(int userid) {
		EntityManager em = connection.getEntityManager();
		TypedQuery<Booking> query = em.createNamedQuery("Booking.findByUserId", Booking.class);
		query.setParameter("uid", userid);
		//User user = query.getSingleResult();
		List<Booking> movies = query.getResultList();
		em.close();
		
		return movies;
	}
	
}

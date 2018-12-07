package com.fdmgroup.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.fdmgroup.model.Seating;

public class SeatingDao {
private DbConnection connection = null;
	
	public SeatingDao() {
		super();
		connection = DbConnection.getInstance();
	}
	
	public void create(Seating m) {
		EntityManager em = connection.getEntityManager();
		em.getTransaction().begin();

		em.persist(m);

		em.getTransaction().commit();
		em.close();
	}
	
	public Seating findById(int id) {
		EntityManager em = connection.getEntityManager();
		Seating foundMovie = em.find(Seating.class, id);
		em.close();
		return foundMovie;
	}
	
	public List<Seating> findAll() {
		EntityManager em = connection.getEntityManager();
		TypedQuery<Seating> query = em.createNamedQuery("movie.findAll", Seating.class);
		List<Seating> movies = query.getResultList();
		em.close();
		
		return movies;
	}
	
	public boolean delete(Seating m) {
		EntityManager em = connection.getEntityManager();
		Seating foundMovie = em.find(Seating.class, m.getId());
		
		if (foundMovie == null) {
			return false;
		}
		
		em.getTransaction().begin();
		em.remove(foundMovie);
		em.getTransaction().commit();
		em.close();
		return true;
	}
	
	public void update(Seating m) {
		EntityManager em = connection.getEntityManager();
		Seating foundMovie = em.find(Seating.class, m.getId());
		em.getTransaction().begin();
		if (m.getMoviename() != null && !m.getMoviename().equals(""))
			foundMovie.setMoviename(m.getMoviename());
		if (m.getType() != null && !m.getType().equals(""))
			foundMovie.setType(m.getType());;
		if (m.getShowtime() != null && !m.getShowtime().equals(""))
			foundMovie.setShowtime(m.getShowtime());;
		foundMovie.setTicketsleft(m.getTicketsleft());
		foundMovie.setScreennum(m.getScreennum());
		foundMovie.setPrice(m.getPrice());
		
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Seating> findByMoviename(String moviename) {
		EntityManager em = connection.getEntityManager();
		TypedQuery<Seating> query = em.createNamedQuery("Seating.findByMoviename", Seating.class);
		query.setParameter("mname", moviename);
		//User user = query.getSingleResult();
		List<Seating> movies = query.getResultList();
		em.close();
		
		return movies;
	}
}

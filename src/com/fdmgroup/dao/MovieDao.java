package com.fdmgroup.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.fdmgroup.model.Movie;
import com.fdmgroup.model.User;

public class MovieDao {
	private DbConnection connection = null;
	
	public MovieDao() {
		super();
		connection = DbConnection.getInstance();
	}
	
	public void create(Movie m) {
		EntityManager em = connection.getEntityManager();
		em.getTransaction().begin();

		em.persist(m);

		em.getTransaction().commit();
		em.close();
	}
	
	public Movie findById(int id) {
		EntityManager em = connection.getEntityManager();
		Movie foundMovie = em.find(Movie.class, id);
		em.close();
		return foundMovie;
	}
	
	public List<Movie> findAll() {
		EntityManager em = connection.getEntityManager();
		TypedQuery<Movie> query = em.createNamedQuery("movie.findAll", Movie.class);
		List<Movie> movies = query.getResultList();
		em.close();
		
		return movies;
	}
	
	public boolean delete(Movie m) {
		EntityManager em = connection.getEntityManager();
		Movie foundMovie = em.find(Movie.class, m.getId());
		
		if (foundMovie == null) {
			return false;
		}
		
		em.getTransaction().begin();
		em.remove(foundMovie);
		em.getTransaction().commit();
		em.close();
		return true;
	}
	
	public void update(Movie m) {
		EntityManager em = connection.getEntityManager();
		Movie foundMovie = em.find(Movie.class, m.getId());
		em.getTransaction().begin();
		if (m.getCatagory() != null && !m.getCatagory().equals(""))
			foundMovie.setCatagory(m.getCatagory());
		if (m.getMoviename() != null && !m.getMoviename().equals(""))
			foundMovie.setMoviename(m.getMoviename());;

		if (m.getStars() != null && !m.getStars().equals(""))
			foundMovie.setStars(m.getStars());
		if (m.getDirector() != null && !m.getDirector().equals(""))
			foundMovie.setDirector(m.getDirector());
		if (m.getLength() != null && !m.getLength().equals(""))
			foundMovie.setLength(m.getLength());
		
		em.getTransaction().commit();
		em.close();
	}
	
	public Movie findByMoviename(String moviename) {
		EntityManager em = connection.getEntityManager();
		TypedQuery<Movie> query = em.createNamedQuery("movie.findByMoviename", Movie.class);
		query.setParameter("mname", moviename);
		//User user = query.getSingleResult();
		List<Movie> movies = query.getResultList();
		em.close();
		if (movies != null && movies.size() == 1) {
			return movies.get(0);
		}
		
		return null;
	}
}

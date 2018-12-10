package com.fdmgroup.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.fdmgroup.model.User;

public class UserDao {
	
	private DbConnection connection = null;

	public UserDao() {
		super();
		connection = DbConnection.getInstance();
	}

	public void create(User user) {
		EntityManager em = connection.getEntityManager();
		em.getTransaction().begin();

		em.persist(user);

		em.getTransaction().commit();
		em.close();
	}
	
	public User findById(int id) {
		EntityManager em = connection.getEntityManager();
		User foundUser = em.find(User.class, id);
		em.close();
		return foundUser;
	}
	
	public List<User> findAll() {
		EntityManager em = connection.getEntityManager();
		TypedQuery<User> query = em.createNamedQuery("user.findAll", User.class);
		List<User> users = query.getResultList();
		em.close();
		
		return users;
	}
	
	public User findByUsername(String username) {
		EntityManager em = connection.getEntityManager();
		TypedQuery<User> query = em.createNamedQuery("user.findByUsername", User.class);
		query.setParameter("uname", username);
		//User user = query.getSingleResult();
		List<User> users = query.getResultList();
		em.close();
		if (users != null && users.size() == 1) {
			return users.get(0);
		}
		
		return null;
	}
	
	public List<User> findByFirstname(String firstname) {
		EntityManager em = connection.getEntityManager();
		TypedQuery<User> query = em.createNamedQuery("user.findByFirstname", User.class);
		query.setParameter("fname", "%" + firstname + "%");
		List<User> users = query.getResultList();
		em.close();
		
		return users;
	}

	public boolean delete(User user) {
		EntityManager em = connection.getEntityManager();
		User foundUser = em.find(User.class, user.getId());
		
		if (foundUser == null) {
			return false;
		}
		
		em.getTransaction().begin();
		em.remove(foundUser);
		em.getTransaction().commit();
		em.close();
		return true;
	}
	
	public void update(User user) {
		System.out.println("update");
		EntityManager em = connection.getEntityManager();
		User foundUser = em.find(User.class, user.getId());
		em.getTransaction().begin();
		
		if (user.getPassword() != null && !user.getPassword().isEmpty()) {
			foundUser.setPassword(user.getPassword());  //Calling a setter will update the database automatically
		}
		if (user.getFirstname() != null && !user.getFirstname().isEmpty()) {
			foundUser.setFirstname(user.getFirstname());  //Calling a setter will update the database automatically
		}
		if (user.getLastname() != null && !user.getLastname().isEmpty()) {
			foundUser.setLastname(user.getLastname());  //Calling a setter will update the database automatically
		}
		
		em.getTransaction().commit();
		em.close();
	}
}



















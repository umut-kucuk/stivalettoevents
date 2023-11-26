package it.generationitaly.events.repository.impl;

import it.generationitaly.events.entity.User;
import it.generationitaly.events.repository.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceException;

public class UserRepositoryImpl extends JpaRepositoryImpl<User, Integer> implements UserRepository {

	@Override
	public User findByUsername(String username) {
		User user = null;
		EntityManager em = null;
		EntityTransaction tx = null;
		try {
			em = emf.createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			user = em.createQuery("select u from User u where u.username=:username ", User.class).setParameter("username", username).getSingleResult();
			tx.commit();
		} catch (PersistenceException e) {
			System.err.println(e.getMessage());
		} finally {
			if (em != null)
				em.close();
		}
		return user;
	}
	

}

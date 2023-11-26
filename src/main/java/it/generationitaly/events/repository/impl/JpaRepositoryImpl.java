package it.generationitaly.events.repository.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import it.generationitaly.events.repository.JpaRepository;
import it.generationitaly.events.repository.PersistenceUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceException;

public abstract class JpaRepositoryImpl<T, K> implements JpaRepository<T, K> {

	protected final EntityManagerFactory emf = PersistenceUtil.createEntityManagerFactory();
	protected final Class<T> clazz;

	public JpaRepositoryImpl() {
		Type type = this.getClass().getGenericSuperclass();
		this.clazz = (Class<T>) ((ParameterizedType) type).getActualTypeArguments()[0];
	}

	@Override
	public void save(T entity) {
		EntityManager em = null;
		EntityTransaction tx = null;
		try {
			em = emf.createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			em.persist(entity);
			tx.commit();
		} catch (PersistenceException e) {
			System.err.println(e.getMessage());
			if (tx != null && tx.isActive())
				tx.rollback();
		} finally {
			if (em != null)
				em.close();
		}
	}

	@Override
	public void update(T entity) {
		EntityManager em = null;
		EntityTransaction tx = null;
		try {
			em = emf.createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			em.merge(entity);
			tx.commit();
		} catch (PersistenceException e) {
			System.err.println(e.getMessage());
			if (tx != null && tx.isActive())
				tx.rollback();
		} finally {
			if (em != null)
				em.close();
		}
	}

	@Override
	public void delete(T entity) {
		EntityManager em = null;
		EntityTransaction tx = null;
		try {
			em = emf.createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			em.remove(em.contains(entity) ? entity : em.merge(entity));
			tx.commit();
		} catch (PersistenceException e) {
			System.err.println(e.getMessage());
			if (tx != null && tx.isActive())
				tx.rollback();
		} finally {
			if (em != null)
				em.close();
		}
	}

	@Override
	public void deleteById(K pk) {
		EntityManager em = null;
		EntityTransaction tx = null;
		try {
			em = emf.createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			T entity = em.find(clazz, pk);
			em.remove(entity);
			tx.commit();
		} catch (PersistenceException e) {
			System.err.println(e.getMessage());
			if (tx != null && tx.isActive())
				tx.rollback();
		} finally {
			if (em != null)
				em.close();
		}
	}

	@Override
	public List<T> findAll() {
		List<T> entities = null;
		EntityManager em = null;
		EntityTransaction tx = null;
		try {
			em = emf.createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			entities = em.createQuery("FROM " + clazz.getSimpleName(), clazz).getResultList();
			tx.commit();
		} catch (PersistenceException e) {
			System.err.println(e.getMessage());
			if (tx != null && tx.isActive())
				tx.rollback();
		} finally {
			if (em != null)
				em.close();
		}
		return entities;
	}

	@Override
	public T findById(K pk) {
		T entity = null;
		EntityManager em = null;
		EntityTransaction tx = null;
		try {
			em = emf.createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			entity = em.find(clazz, pk);
			tx.commit();
		} catch (PersistenceException e) {
			System.err.println(e.getMessage());
			if (tx != null && tx.isActive())
				tx.rollback();
		} finally {
			if (em != null)
				em.close();
		}
		return entity;
	}

	@Override
	public long count() {
		long count = 0;
		EntityManager em = null;
		EntityTransaction tx = null;
		try {
			em = emf.createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			count = em.createQuery("select count(*) from " + clazz.getSimpleName(), Long.class).getSingleResult();
			tx.commit();
		} catch (PersistenceException e) {
			System.err.println(e.getMessage());
		} finally {
			if (em != null)
				em.close();
		}
		return count;
	}
}
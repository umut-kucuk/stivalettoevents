package it.generationitaly.events.repository.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import it.generationitaly.events.entity.Evento;
import it.generationitaly.events.repository.EventoRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.TypedQuery;

public class EventoRepositoryImpl extends JpaRepositoryImpl<Evento, Integer> implements EventoRepository {

	@Override
	public List<Evento> findByCitta(String citta) {
		List<Evento> eventi = null;
		EntityManager em = null;
		EntityTransaction tx = null;
		try {
			em = emf.createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			eventi = em.createQuery("select e from Evento e where e.citta=:citta", Evento.class)
					.setParameter("citta", citta).getResultList();
		} catch (PersistenceException e) {
			System.err.println(e.getMessage());
		} finally {
			if (em != null) {
				em.close();
			}
		}
		return eventi;
	}

	public List<Evento> findByTagId(int id) {
		EntityManager em = null;
		EntityTransaction tx = null;
		List<Evento> eventi = new ArrayList<Evento>();
		try {
			em = emf.createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			eventi = em.createQuery("select e from Evento e join fetch e.tagEvento where e.tagEvento.id = :id",
					Evento.class).setParameter("id", id).getResultList();
			tx.commit();
		} catch (PersistenceException e) {
			if (tx != null && tx.isActive())
				tx.rollback();
			System.err.println(e.getMessage());
		} finally {
			if (em != null) {
				em.close();
			}
		}
		return eventi;

	}

	@Override
	public List<Evento> findByNome(String searchterm) {
		List<Evento> eventi = new ArrayList<Evento>();
		EntityManager em = null;
		EntityTransaction tx = null;
		try {
			em = emf.createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			TypedQuery<Evento> query = em.createQuery("SELECT e FROM Evento e WHERE e.nome LIKE :searchterm", Evento.class);
		    query.setParameter("searchterm", "%" + searchterm + "%");

			eventi = query.getResultList();
			tx.commit();
		} catch (PersistenceException e) {
			if (tx != null && tx.isActive())
				tx.rollback();
			System.err.println(e.getMessage());
		} finally {
			if (em != null) {
				em.close();
			}
		}
		return eventi;
	}

	@Override
	public List<Evento> findByGratuito(boolean gratuito) {
		EntityManager em = null;
		List<Evento> eventi = null;
		try {
			em = emf.createEntityManager();
			eventi = em.createQuery("SELECT e FROM Evento e WHERE e.gratuito = :gratuito", Evento.class)
					.setParameter("gratuito", gratuito).getResultList();
		} catch (PersistenceException e) {
			System.err.println(e.getMessage());
		} finally {
			if (em != null)
				em.close();
		}
		return eventi;
	}

	@Override
	public List<Evento> findByDataBetween(Date date1, Date date2) {
		EntityManager em = null;
		List<Evento> eventi = null;
		try {
			em = emf.createEntityManager();
			eventi = em.createQuery("SELECT e FROM Evento e WHERE e.data BETWEEN :date1 AND :date2 ", Evento.class)
					.setParameter("date1", date1).setParameter("date2", date2).getResultList();
		} catch (PersistenceException e) {
			System.err.println(e.getMessage());
		} finally {
			if (em != null)
				em.close();
		}
		return eventi;

	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Evento> findEventi1(int id, String citta) {
		EntityManager em = null;
		EntityTransaction tx = null;
		List<Evento> eventi = new ArrayList<Evento>();
		try {
			em = emf.createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			eventi = em
					.createQuery(
							"SELECT e FROM Evento e JOIN fetch e.tagEvento t WHERE t.id = :id AND e.citta = :citta")
					.setParameter("id", id).setParameter("citta", citta).getResultList();
			tx.commit();
		} catch (PersistenceException e) {
			if (tx != null && tx.isActive())
				tx.rollback();
			System.err.println(e.getMessage());
		} finally {
			if (em != null) {
				em.close();
			}
		}
		return eventi;

	}

	@Override
	public List<Evento> findByNomeAndCitta(String nome, String citta) {
	    EntityManager em = null;
	    List<Evento> eventi = null;
	    try {
	        em = emf.createEntityManager();
	        eventi = em.createQuery("SELECT e FROM Evento e WHERE e.nome LIKE :nome AND e.citta = :citta", Evento.class)
	                .setParameter("nome", "%" + nome + "%").setParameter("citta", citta).getResultList();
	    } catch (PersistenceException e) {
	        System.err.println(e.getMessage());
	    } finally {
	        if (em != null) {
	            em.close();
	        }
	    }
	    return eventi;
	}

	@Override
	public List<Evento> findByCittaAndGratuito(String citta, boolean gratuito) {
	    EntityManager em = null;
	    List<Evento> eventi = null;
	    try {
	        em = emf.createEntityManager();
	        eventi = em.createQuery("SELECT e FROM Evento e WHERE e.citta = :citta AND e.gratuito = :gratuito", Evento.class)
	                .setParameter("citta", citta)
	                .setParameter("gratuito", gratuito)
	                .getResultList();
	    } catch (PersistenceException e) {
	        System.err.println(e.getMessage());
	    } finally {
	        if (em != null) {
	            em.close();
	        }
	    }
	    return eventi;
	}

	public List<Evento> findByCittaDateBetween(String citta, Date date1, Date date2) {
		EntityManager em = null;
		List<Evento> eventi = null;
		try {
			em = emf.createEntityManager();
			eventi = em.createQuery("SELECT e FROM Evento e WHERE e.citta =:citta and  e.data BETWEEN :date1 AND :date2 ", Evento.class).setParameter("citta", citta)
					.setParameter("date1", date1).setParameter("date2", date2).getResultList();
		} catch (PersistenceException e) {
			System.err.println(e.getMessage());
		} finally {
			if (em != null)
				em.close();
		}
		return eventi;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Evento> findEventi2(int id, String searchTerm) {
		EntityManager em = null;
		EntityTransaction tx = null;
		List<Evento> eventi = new ArrayList<Evento>();
		try {
			em = emf.createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			eventi = em
					.createQuery(
							"SELECT e FROM Evento e JOIN fetch e.tagEvento t WHERE t.id = :id AND e.nome LIKE :searchterm")
					.setParameter("id", id).setParameter("searchTerm", "%" + searchTerm + "%" ).getResultList();
			tx.commit();
		} catch (PersistenceException e) {
			if (tx != null && tx.isActive())
				tx.rollback();
			System.err.println(e.getMessage());
		} finally {
			if (em != null) {
				em.close();
			}
		}
		return eventi;
	}

	@Override
	public List<Evento> findByTagIdAndGratuito(int id, boolean gratuito) {
		EntityManager em = null;
		EntityTransaction tx = null;
		List<Evento> eventi = new ArrayList<Evento>();
		try {
			em = emf.createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			eventi = em.createQuery("SELECT e FROM Evento e JOIN fetch e.tagEvento t WHERE e.gratuito = :gratuito AND e.tagEvento.id = :id", Evento.class)
					.setParameter("gratuito", gratuito)
					.setParameter("id", id)
					.getResultList();
			tx.commit();
		} catch (PersistenceException e) {
			if (tx != null && tx.isActive())
				tx.rollback();
			System.err.println(e.getMessage());
		} finally {
			if (em != null) {
				em.close();
			}
		}
		return eventi;
	}

	@Override
	public List<Evento> findByTagIdAndDataBetween(int id, Date date1, Date date2) {
		EntityManager em = null;
		EntityTransaction tx = null;
		List<Evento> eventi = new ArrayList<Evento>();
		try {
			em = emf.createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			eventi = em.createQuery("SELECT e FROM Evento e JOIN fetch e.tagEvento t WHERE e.tagEvento.id = :id AND e.data BETWEEN :date1 AND :date2", Evento.class)
					.setParameter("id", id)
					.setParameter("date1", date1)
					.setParameter("date2", date2)
					.getResultList();
			tx.commit();
		} catch (PersistenceException e) {
			if (tx != null && tx.isActive())
				tx.rollback();
			System.err.println(e.getMessage());
		} finally {
			if (em != null) {
				em.close();
			}
		}
		return eventi;
	}

	@Override
	public List<Evento> findByNomeAndDataBetween(String searchterm, Date date1, Date date2) {
		EntityManager em = null;
		EntityTransaction tx = null;
		List<Evento> eventi = new ArrayList<Evento>();
		try {
			em = emf.createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			TypedQuery<Evento> query = em.createQuery("SELECT e FROM Evento e WHERE e.nome LIKE :searchterm AND e.data BETWEEN :date1 AND :date2", Evento.class);
			query.setParameter("searchterm", "%" + searchterm + "%");
            query.setParameter("date1", date1);
            query.setParameter("date2", date2);
		    eventi = query.getResultList();
			tx.commit();
		} catch (PersistenceException e) {
			if (tx != null && tx.isActive())
				tx.rollback();
			System.err.println(e.getMessage());
		} finally {
			if (em != null) {
				em.close();
			}
		}
		return eventi;
	}

	@Override
	public List<Evento> findByNomeAndTagIdAndCittaAndGratuitoAndDataBetween(String searchterm, int id, String citta,
			boolean gratuito, Date date1, Date date2) {
		EntityManager em = null;
		EntityTransaction tx = null;
		List<Evento> eventi = new ArrayList<Evento>();
		try {
			em = emf.createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			TypedQuery<Evento> query = em.createQuery("SELECT e FROM Evento e JOIN fetch e.tagEvento t WHERE e.nome LIKE :searchterm AND e.tagEvento.id = :id AND e.citta = :citta AND e.gratuito = :gratuito AND e.data BETWEEN :date1 AND :date2", Evento.class);
			query.setParameter("searchterm", "%" + searchterm + "%");
			query.setParameter("id", id);
			query.setParameter("citta", citta);
			query.setParameter("gratuito", gratuito);
            query.setParameter("date1", date1);
            query.setParameter("date2", date2);
		    eventi = query.getResultList();
			tx.commit();
		} catch (PersistenceException e) {
			if (tx != null && tx.isActive())
				tx.rollback();
			System.err.println(e.getMessage());
		} finally {
			if (em != null) {
				em.close();
			}
		}
		return eventi;
	}
	
	
	@Override
	public List<Evento> findByCittaAndTagEventoAndDataBetween(String citta, int id, Date date1, Date date2) {
	    EntityManager em = null;
	    List<Evento> eventi = null;
	    try {
	        em = emf.createEntityManager();
	        eventi = em.createQuery("SELECT e FROM Evento e WHERE e.citta = :citta AND e.tagEvento.id = :id AND e.data BETWEEN :date1 AND :date2", Evento.class)
	                .setParameter("citta", citta)
	                .setParameter("id", id)
	                .setParameter("date1", date1)
	                .setParameter("date2", date2)
	                .getResultList();
	    } catch (PersistenceException e) {
	        System.err.println(e.getMessage());
	    } finally {
	        if (em != null) {
	            em.close();
	        }
	    }
	    return eventi;
	}
}

package it.generationitaly.events.repository;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class PersistenceUtil {
	private static EntityManagerFactory emf;

	public static EntityManagerFactory createEntityManagerFactory() {
		if (emf == null)
			emf = Persistence.createEntityManagerFactory("persistence");

		return emf;
	}
}

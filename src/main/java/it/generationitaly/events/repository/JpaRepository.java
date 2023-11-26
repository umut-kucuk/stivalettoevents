package it.generationitaly.events.repository;

import java.util.List;

public interface JpaRepository<T, K> {

	void save(T entity);

	void update(T entity);

	void delete(T entity);

	void deleteById(K pk);

	List<T> findAll();

	T findById(K pk);

	long count();

}

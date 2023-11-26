package it.generationitaly.events.repository;

import it.generationitaly.events.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	User findByUsername (String username);

}

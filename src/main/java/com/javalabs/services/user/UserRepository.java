package com.javalabs.services.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

	//@Query("SELECT u FROM User u WHERE u.status = 1") // Exmple with JPQL, non-native

	@Query(
			value = "SELECT * FROM person p WHERE p.email = :email",
			nativeQuery = true)
	UserEntity findByEmail(String email);
}

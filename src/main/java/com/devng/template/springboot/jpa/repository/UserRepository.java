package com.devng.template.springboot.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devng.template.springboot.jpa.domain.User;

/**
 * For Spring Data JPA query methods see: http://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods
 */
public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);

	List<User> findByLastNameStartingWithIgnoreCase(String lastName);

}

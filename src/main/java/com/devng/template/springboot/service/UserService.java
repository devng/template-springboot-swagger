package com.devng.template.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.devng.template.springboot.jpa.domain.User;
import com.devng.template.springboot.jpa.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User saveUser(User user) {
		Assert.notNull(user);
		return userRepository.saveAndFlush(user);
	}

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public List<User> findByLastName(String lastName) {
		Assert.hasText(lastName);
		lastName = lastName.trim();
		return userRepository.findByLastNameStartingWithIgnoreCase(lastName);
	}

	public User findOne(Long id) {
		Assert.notNull(id);
		return userRepository.findOne(id);
	}

	public User findByEmail(String email) {
		Assert.hasLength(email);
		return userRepository.findByEmail(email);
	}

}

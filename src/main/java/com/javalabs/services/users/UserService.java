package com.javalabs.services.users;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<UserEntity> getAllUsers() {
		return userRepository.findAll();
	}

	public UserEntity addUser(UserEntity user) {
		return userRepository.save(user);
	}

	public UserEntity findByEmail(String email) {
		return userRepository.findByEmail(email);
	}
}

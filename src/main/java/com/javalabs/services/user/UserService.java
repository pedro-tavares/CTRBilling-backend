package com.javalabs.services.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public UserEntity login(UserEntity user) throws Exception {
		UserEntity foundUser = this.findByEmail(user.getEmail());
		if (foundUser != null) {
			return foundUser;
		}
		throw new Exception("User NOT Found!");
	}

	public UserEntity add(UserEntity user) {
		return userRepository.save(user);
	}

	public UserEntity findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	public List<UserEntity> getAll() {
		return userRepository.findAll();
	}
}

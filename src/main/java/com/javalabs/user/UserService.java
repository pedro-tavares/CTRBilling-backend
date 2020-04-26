package com.javalabs.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	private Logger LOG = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserRepository userRepository;

	public UserEntity login(UserEntity user) throws Exception {
		LOG.debug("\nUserService LOGIN, user:\n" + user.getEmail());

		UserEntity foundUser = this.findByEmail(user.getEmail());
		if (foundUser != null) {
			return foundUser;
		}
		LOG.debug("\nUser NOT Found!\n");
		return null;
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

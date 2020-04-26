package com.javalabs.user;

import java.util.List;

import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.javalabs.dto.User;

@RestController
@CrossOrigin
@RequestMapping(path = "/user")
public class UserController {

	private Logger LOG = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserService service;

	@Autowired
	DozerBeanMapper mapper;

	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public User login(@RequestBody User user) throws Exception {
		UserEntity entity = service.login(new UserEntity(user));
		if (entity != null) {

			LOG.debug(
					"\nUserController LOGIN, user email:" + user.getEmail() +
					", password:" + user.getPassword()
			);

			if (!user.getPassword().equals("password"/*entity.getThePassword()*/)) {
				throw new Exception("INVALID Credentials. Please check your password.");
			}
			return mapper.map(entity, User.class);
		}
		throw new Exception("User NOT Found.");
	}

	@RequestMapping(path = "/save", method = RequestMethod.POST)
	public User save(@RequestBody User user) {
		UserEntity entity = service.add(new UserEntity(user));
		return mapper.map(entity, User.class);
	}

	@RequestMapping(path = "/getAll", method = RequestMethod.GET)
	public List<UserEntity> getAll() {
		return service.getAll();
	}

}

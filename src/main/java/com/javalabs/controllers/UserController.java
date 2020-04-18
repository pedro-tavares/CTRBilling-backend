package com.javalabs.controllers;

import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.javalabs.dto.User;
import com.javalabs.services.user.UserEntity;
import com.javalabs.services.user.UserService;

@RestController
@CrossOrigin
@RequestMapping(path = "/user")
public class UserController {

	@Autowired
	UserService service;

	@Autowired
	DozerBeanMapper mapper;

	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public User login(@RequestBody User user) throws Exception {
		UserEntity entity = service.login(new UserEntity(user));
		return mapper.map(entity, User.class);
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

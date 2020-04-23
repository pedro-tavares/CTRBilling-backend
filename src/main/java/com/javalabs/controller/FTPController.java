package com.javalabs.controller;

import com.javalabs.dto.Server;
import com.javalabs.service.ftp.FTPService;
import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(path = "/ftp")
public class FTPController {

	private Logger LOG = LoggerFactory.getLogger(FTPController.class);

	@Autowired
	FTPService service;

	@Autowired
	DozerBeanMapper mapper;

	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public String login(@RequestBody Server server) throws Exception {
		LOG.debug(
				"\nFTPController LOGIN, server:" + server.getName()
		);

		return service.login(server);
	}

}

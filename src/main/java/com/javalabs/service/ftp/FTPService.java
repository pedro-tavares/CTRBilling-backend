package com.javalabs.service.ftp;

import com.javalabs.dto.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class FTPService {

	private Logger LOG = LoggerFactory.getLogger(FTPService.class);
/*
	@Autowired
	private UserRepository userRepository;
*/
	public String login(Server server) throws Exception {
		LOG.debug("\nFTPService LOGIN, server:\n" + server.getName());

		return ResponseEntity.ok().toString();
	}
}

package com.javalabs.controller;

import com.javalabs.dto.DowloadFTPFileInfo;
import com.javalabs.dto.FTPFileInfo;
import com.javalabs.dto.Server;
import com.javalabs.service.ftp.FTPService;

import java.util.List;

import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(path = "/ftp")
public class FTPController {

	private Logger LOG = LoggerFactory.getLogger(FTPController.class);

	@Autowired
	FTPService ftpService;

	@Autowired
	DozerBeanMapper mapper;

	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public ResponseEntity<String> login(@RequestBody Server server) throws Exception {
		LOG.debug(
				"\nFTPController LOGIN, server:" + server.getName() + ", user:" +server.getUsername()
		);

		if (ftpService.login(server)) {
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
	}

	@RequestMapping(path = "/dir", method = RequestMethod.POST)
	public ResponseEntity<List<FTPFileInfo>> dir(@RequestBody Server server) throws Exception {
		LOG.debug(
				"\nFTPController DIR, server:" + server.getName() + ", user:" +server.getUsername()
		);

		List<FTPFileInfo> fileInfoList = ftpService.dir(server);
		
		return ResponseEntity.ok(fileInfoList);
	}
	
	@RequestMapping(path = "/download_file", method = RequestMethod.POST)
	public ResponseEntity<String> downloadFile(@RequestBody DowloadFTPFileInfo fileInfo) throws Exception {
		LOG.debug(
				"\nFTPController DOWNLOAD_FILE, server:" + fileInfo.getServer().getName() 
				+ ", user:" + fileInfo.getServer().getUsername()
				+ ", fileName:" + fileInfo.getFileName()
		);

		if (ftpService.download(fileInfo)) {
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
	}

	@RequestMapping(path = "/process_file", method = RequestMethod.POST)
	public ResponseEntity<String> processFile(@RequestBody DowloadFTPFileInfo fileInfo) throws Exception {
		LOG.debug(
				"\nFTPController PROCESS_FILE, server:" + fileInfo.getServer().getName() 
				+ ", user:" + fileInfo.getServer().getUsername()
				+ ", fileName:" + fileInfo.getFileName()
		);

		if (ftpService.download(fileInfo)) {
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).build();
	}
	
}

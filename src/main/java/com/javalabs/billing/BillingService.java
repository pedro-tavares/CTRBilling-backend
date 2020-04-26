package com.javalabs.billing;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javalabs.dto.DowloadFTPFileInfo;
import com.javalabs.service.ftp.FTPService;

@Service
public class BillingService {
	
	private static Logger LOG = LoggerFactory.getLogger(BillingService.class);

	@Autowired
	FTPService ftpService;
	
	@Autowired
	CSVReaderComponent csvReader;
	
	public boolean process(DowloadFTPFileInfo fileInfo) throws Exception {
		LOG.debug(
				"\nBillingService PROCESS, server:" + fileInfo.getServer().getName() 
				+ ", fileName:" + fileInfo.getFileName()
		);

		File downloadFile = new File(fileInfo.getServer().getName());
		if (!downloadFile.exists()) {
			LOG.debug(
					"\nBillingService PROCESS, file " + fileInfo.getFileName()
					+ " NOT exists. Downloading..."
			);
		
			ftpService.download(fileInfo);
			if (!downloadFile.exists()) {
				LOG.debug(".");
			}
			LOG.debug("File " + fileInfo.getFileName() + " DOWNLOADED.");
		}
		
		return csvReader.process(fileInfo);
	}

}

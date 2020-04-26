package com.javalabs.billing;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javalabs.dto.DowloadFTPFileInfo;
import com.javalabs.ftp.FTPService;

@Service
public class BillingService {
	
	private static Logger LOG = LoggerFactory.getLogger(BillingService.class);

	@Autowired
	FTPService ftpService;
	
	@Autowired
	CSVReaderComponent csvReader;
	
	@Autowired
	BillingRecordRepository billingRecordRepository;
	
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
		
		List<BillingRecordEntity> billingRecordEntityList = csvReader.process(fileInfo);
		
		LOG.debug("Saving " + billingRecordEntityList.size() + " records...");
		billingRecordRepository.saveAll(billingRecordEntityList);
		
		return true;
	}

}

package com.javalabs.billing;

import java.io.File;
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

	@Autowired
	BillingFileLogRepository billingFileLogRepository;
	
	public boolean process(DowloadFTPFileInfo fileInfo) throws Exception {
		LOG.debug(
				"\nBillingService PROCESS, server:" + fileInfo.getServer().getName() 
				+ ", fileName:" + fileInfo.getFileName()
		);

		// Check if file already processed
		if (billingFileLogRepository.findByFileName(fileInfo.getFileName()) != null) {
			LOG.debug("\nBillingService PROCESS, file " + fileInfo.getFileName() + " has already been processed.");
			
			return true;
		}
		
		// Download file and Process
		
		File downloadFile = new File(fileInfo.getServer().getName());
		if (!downloadFile.exists()) {
			LOG.debug("\nBillingService PROCESS, file " + fileInfo.getFileName() + " NOT exists. Downloading...");
		
			ftpService.download(fileInfo);
			if (!downloadFile.exists()) {
				LOG.debug(".");
			}
			LOG.debug("File " + fileInfo.getFileName() + " DOWNLOADED.");
		}
		
		List<BillingRecordEntity> billingRecordEntityList = csvReader.process(fileInfo);
				
		billingRecordRepository.saveAll(billingRecordEntityList);
		LOG.debug("SAVED " + billingRecordEntityList.size() + " records...");
		
		//log
		BillingFileLogEntity logEntry = new BillingFileLogEntity(fileInfo.getFileName());
		billingFileLogRepository.save(logEntry);
		
		return true;
	}

	public List<BillingRecordEntity> getBillingRecords(String fileName) throws Exception {
		LOG.debug(
				"\nBillingService GET_BILLING_RECORDS " + 
				", fileName:" + fileName
		);
		
		return billingRecordRepository.findByFileName(fileName);
	}
}

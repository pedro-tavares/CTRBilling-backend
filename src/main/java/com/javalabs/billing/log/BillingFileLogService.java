package com.javalabs.billing.log;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillingFileLogService {
	
	private static Logger LOG = LoggerFactory.getLogger(BillingFileLogService.class);

	@Autowired
	BillingFileLogRepository billingFileLogRepository;

	public BillingFileLogEntity getBillingFileLogRecord(String fileName) throws Exception {
		LOG.debug(
				"\nBillinFileLogService GET_BILLING_FILE_LOG_RECORD " + 
				", fileName:" + fileName
		);
		
		return billingFileLogRepository.findByFileName(fileName);
	}
}

package com.javalabs.service.billing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.javalabs.dto.DowloadFTPFileInfo;

@Service
public class BillingService {
	
	private static Logger LOG = LoggerFactory.getLogger(BillingService.class);

	public boolean process(DowloadFTPFileInfo fileInfo) throws Exception {
		return true;
	}

}

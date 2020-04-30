package com.javalabs.billing.log;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.javalabs.dto.BillingFileLog;
import com.javalabs.dto.BillingRecord;
import com.javalabs.dto.DowloadFTPFileInfo;

@RestController
@CrossOrigin
@RequestMapping(path = "/billing")
public class BillingFileLogController {

	private static Logger LOG = LoggerFactory.getLogger(BillingFileLogController.class);
	
	@Autowired
	BillingFileLogService billingFileLogService;

	@Autowired
	DozerBeanMapper mapper;

	@RequestMapping(path = "/get_billing_file_log_records", method = RequestMethod.POST)
	public ResponseEntity<BillingFileLog> getBillingFileLogRecords(@RequestBody String fileName) throws Exception {
		LOG.debug(
				"\nBillingController GET_BILLING_FILE_LOG_RECORDS " + 
				", fileName:" + fileName
		);

		BillingFileLogEntity billingFileLogEntity = billingFileLogService.getBillingFileLogRecord(fileName);
		BillingFileLog billingFileLog = new BillingFileLog();

		BeanUtils.copyProperties(billingFileLogEntity, billingFileLog);
		
		return ResponseEntity.ok(billingFileLog);
	}
	
}

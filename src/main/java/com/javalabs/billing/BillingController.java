package com.javalabs.billing;

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

import com.javalabs.dto.BillingRecord;
import com.javalabs.dto.DowloadFTPFileInfo;

@RestController
@CrossOrigin
@RequestMapping(path = "/billing")
public class BillingController {

	private static Logger LOG = LoggerFactory.getLogger(BillingController.class);
	
	@Autowired
	BillingService billingService;

	@Autowired
	DozerBeanMapper mapper;

	@RequestMapping(path = "/process_file", method = RequestMethod.POST)
	public ResponseEntity<String> processFile(@RequestBody DowloadFTPFileInfo fileInfo) throws Exception {
		LOG.debug(
				"\nBillingController PROCESS_FILE, server:" + fileInfo.getServer().getName() 
				+ ", user:" + fileInfo.getServer().getUsername()
				+ ", fileName:" + fileInfo.getFileName()
		);

		if (billingService.process(fileInfo)) {
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).build();
	}

	@RequestMapping(path = "/get_billing_records", method = RequestMethod.POST)
	public ResponseEntity<List<BillingRecord>> getBillingRecords(@RequestBody String fileName) throws Exception {
		LOG.debug(
				"\nBillingController GET_BILLING_RECORDS " + 
				", fileName:" + fileName
		);

		List<BillingRecordEntity> billingRecordEntityList = billingService.getBillingRecords(fileName);
		List<BillingRecord> billingRecordList = new ArrayList<BillingRecord>();

		int i=0;
		for (BillingRecordEntity billingRecordEntity: billingRecordEntityList) {
			if (i > 0) { // skip header
				BillingRecord billingRecord = new BillingRecord();
				BeanUtils.copyProperties(billingRecordEntity, billingRecord);
				billingRecordList.add(billingRecord);
			}
			i++;			
		}
		
		return ResponseEntity.ok(billingRecordList);
	}
	
}

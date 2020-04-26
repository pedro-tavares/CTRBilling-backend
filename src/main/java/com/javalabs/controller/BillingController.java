package com.javalabs.controller;

import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javalabs.service.billing.BillingService;

@RestController
@CrossOrigin
@RequestMapping(path = "/billing")
public class BillingController {

	private static Logger LOG = LoggerFactory.getLogger(BillingController.class);
	
	@Autowired
	BillingService billingService;

	@Autowired
	DozerBeanMapper mapper;

}

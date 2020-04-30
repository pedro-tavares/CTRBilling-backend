package com.javalabs.config.supplier;

import java.io.File;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javalabs.billing.log.BillingFileLogEntity;
import com.javalabs.billing.log.BillingFileLogRepository;
import com.javalabs.dto.DowloadFTPFileInfo;
import com.javalabs.dto.Supplier;
import com.javalabs.ftp.FTPService;

@Service
public class SupplierService {
	
	private static Logger LOG = LoggerFactory.getLogger(SupplierService.class);

	@Autowired
	SupplierRepository supplierRepository;

	public boolean save(Supplier supplier) throws Exception {
		LOG.debug(
				"\nSupplierService SAVE, supplier:" + supplier.getName() 
				+ ", email:" + supplier.getEmail()
		);

		supplierRepository.save(new SupplierEntity(supplier));

		return true;
	}

	public List<SupplierEntity> getSuppliers() throws Exception {
		LOG.debug(
				"\nSupplierService GET_SUPPLIERS"
		);
		
		return supplierRepository.findAll();
	}
}

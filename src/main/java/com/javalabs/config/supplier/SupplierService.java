package com.javalabs.config.supplier;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javalabs.dto.Supplier;

@Service
public class SupplierService {
	
	private static Logger LOG = LoggerFactory.getLogger(SupplierService.class);

	@Autowired
	SupplierRepository supplierRepository;

	//@PostConstruct // Only run once, ref table
	private void init() {
		List<SupplierEntity> supplierList = new ArrayList<SupplierEntity>();
		supplierList.add(new SupplierEntity("UBOSS", ""));
		supplierList.add(new SupplierEntity("ICUK", ""));
		supplierList.add(new SupplierEntity("Voicehost", ""));
		supplierList.add(new SupplierEntity("Daisy", ""));
		
		supplierRepository.saveAll(supplierList);
	}
	
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

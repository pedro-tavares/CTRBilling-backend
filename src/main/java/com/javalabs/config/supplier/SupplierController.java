package com.javalabs.config.supplier;

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
import com.javalabs.dto.Supplier;

@RestController
@CrossOrigin
@RequestMapping(path = "/supplier")
public class SupplierController {

	private static Logger LOG = LoggerFactory.getLogger(SupplierController.class);
	
	@Autowired
	SupplierService supplierService;

	@Autowired
	DozerBeanMapper mapper;

	@RequestMapping(path = "/save", method = RequestMethod.POST)
	public ResponseEntity<String> save(@RequestBody Supplier supplier) throws Exception {
		LOG.debug(
				"\nSupplierController SAVE, supplier:" + supplier.getName() 
		);

		if (supplierService.save(supplier)) {
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).build();
	}

	@RequestMapping(path = "/get_suppliers", method = RequestMethod.POST)
	public ResponseEntity<List<Supplier>> getSuppliers() throws Exception {
		LOG.debug(
				"\nSupplierController GET_SUPPLIERS"  
		);

		List<SupplierEntity> supplierEntityList = supplierService.getSuppliers();
		List<Supplier> supplierList = new ArrayList<Supplier>();

		for (SupplierEntity supplierEntity: supplierEntityList) {
			Supplier supplier = new Supplier();
			BeanUtils.copyProperties(supplierEntity, supplier);
			supplierList.add(supplier);
		}
		
		return ResponseEntity.ok(supplierList);
	}
	
}

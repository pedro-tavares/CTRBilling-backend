package com.javalabs.config.supplier;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.beanutils.BeanUtils;

import com.javalabs.dto.Supplier;

@Entity
@Table(name = "supplier")
public class SupplierEntity {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String email;
	private Date timestamp;
	
	public SupplierEntity() {}

	public SupplierEntity(Long id, String name, String email) {
		super();
		
		this.id = id;
		this.name = name;
		this.email = email;
		this.timestamp = new Date();
	}

	public SupplierEntity(Supplier supplier) throws Exception {
		BeanUtils.copyProperties(this, supplier);
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	
}

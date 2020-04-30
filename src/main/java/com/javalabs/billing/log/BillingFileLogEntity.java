package com.javalabs.billing.log;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "billing_file_log")
public class BillingFileLogEntity {
	
	@Id
	@GeneratedValue
	private Long id;	
	String fileName;
	Date timestamp;
	String type; //TODO: create enum DOWNLOAD, UPLOAD
	
	public BillingFileLogEntity() {}
	
	public BillingFileLogEntity(String fileName, String type) {
		super();
		
		this.fileName = fileName;
		this.type = type;
		this.timestamp = new Date();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}	

}

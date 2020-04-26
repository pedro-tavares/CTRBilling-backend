package com.javalabs.config;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ConfigFactory {
	
	private static Logger LOG = LoggerFactory.getLogger(ConfigFactory.class);

	public static Date parseDate(String date) {
		try {
			return new SimpleDateFormat("dd/MM/yyyy").parse(date);
		} catch (ParseException e) {
			LOG.debug(e.getMessage());
		}
		return null;
	}

	public static Date parseTime(String date) {
		try {
			return new SimpleDateFormat("HH:mm:ss").parse(date);
		} catch (ParseException e) {
			LOG.debug(e.getMessage());
		}
		return null;
	}

}

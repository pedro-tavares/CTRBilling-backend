package com.javalabs.service.billing;

import com.javalabs.constants.IConstants;
import com.javalabs.dto.DowloadFTPFileInfo;
import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CSVReaderComponent {
	
	private static Logger LOG = LoggerFactory.getLogger(CSVReaderComponent.class);

	public boolean process(DowloadFTPFileInfo fileInfo) {

        String csvFile = IConstants.DOWNLOADS_DIR + fileInfo.getFileName();
        
		LOG.debug(
				"\nCSVReaderComponent PROCESS, server:" + fileInfo.getServer().getName() 
				+ ", csvFile:" + csvFile
		);        

        CSVReader reader = null;
        try {
            reader = new CSVReader(new FileReader(csvFile));
            String[] line;
            while ((line = reader.readNext()) != null) {
                LOG.debug("BillingRecord [" + 
                		"Call Type=" + line[0] + 
                		", Call Cause=" + line[1] + 
                		", Customer Identifier=" + line[2] + "]"
                );
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return true;
    }

}
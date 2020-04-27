package com.javalabs.billing;

import com.javalabs.constants.IConstants;
import com.javalabs.dto.DowloadFTPFileInfo;
import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CSVReaderComponent {
	
	private static Logger LOG = LoggerFactory.getLogger(CSVReaderComponent.class);

	public List<BillingRecordEntity> process(DowloadFTPFileInfo fileInfo) {

        String csvFile = IConstants.DOWNLOADS_DIR + fileInfo.getFileName();
        
		LOG.debug(
				"\nCSVReaderComponent PROCESS, server:" + fileInfo.getServer().getName() 
				+ ", csvFile:" + csvFile
		); 
		
		List<BillingRecordEntity> billingRecordEntityList = new ArrayList<BillingRecordEntity>(); 

        CSVReader reader = null;
        try {
            reader = new CSVReader(new FileReader(csvFile));
            String[] line;
            while ((line = reader.readNext()) != null) {
            	
                LOG.debug("BillingRecord [" + 
                		"Call Type=" + line[0] + 
                		", Call Cause=" + line[1] + 
                		", Customer Identifier=" + line[2] +
                		", Telephone Number Dialled=" + line[3] +
                		", Call Date=" + line[4] +
                		", Call Time=" + line[5] +
                		", Duration=" + line[6] +
                		", Bytes Transmitted=" + line[7] +
                		", Bytes Received=" + line[8] +
                		", Description=" + line[9] +
                		", Chargecode=" + line[10] +
                		", Time Band=" + line[11] +
                		", Salesprice=" + line[12] +
                		", Salesprice (pre-bundle)=" + line[13] +
                		", Extension=" + line[14] +
                		", DDI=" + line[15] +
                		", Grouping ID=" + line[16] +
                		", Call Class=" + line[17] +
                		", Carrier=" + line[18] +
                		", Recording=" + line[19] +
                		", VAT=" + line[20] +
                		", Country of Origin=" + line[21] +
                		", Network=" + line[22] +
                		", Retail tariff code=" + line[23] +
                		", Remote Network=" + line[24] +
                		", APN=" + line[25] +
                		", Diverted Number=" + line[26] +
                		", Ring time=" + line[27] +
                		", RecordID=" + line[28] +
                		", Currency=" + line[29] +
                		", Presentation Number=" + line[30] +
                		", Network Access Reference=" + line[31] +
                		", NGCS Access Charge=" + line[32] +
                		", NGCS Service Charge=" + line[33] +
                		", Total Bytes Transferred=" + line[34] +
                		", User ID=" + line[35] +
                		", Onward Billing Reference=" + line[36] +
                		", Contract Name=" + line[37] +
                		", Bundle Name=" + line[38] +
                		", Bundle Allowance=" + line[39] +
                		", Discount Reference=" + line[40] +
                		", Routing Code=" + line[41] +
                		"]"
                );
                
                BillingRecordEntity billingRecord = new BillingRecordEntity(
                		null,
                		fileInfo.getFileName(),
                		new Date(),
                		line[0],
                		line[1],
                		line[2],
                		line[3],
                		line[4],
                		line[5],
                		line[6],
                		line[7],
                		line[8],
                		line[9],
                		line[10],
                		line[11],
                		line[12],
                		line[13],
                		line[14],
                		line[15],
                		line[16],
                		line[17],
                		line[18],
                		line[19],
                		line[20],
                		line[21],
                		line[22],
                		line[23],
                		line[24],
                		line[25],
                		line[26],
                		line[27],
                		line[28],
                		line[29],
                		line[30],
                		line[31],
                		line[32],
                		line[33],
                		line[34],
                		line[35],
                		line[36],
                		line[37],
                		line[38],
                		line[39],
                		line[40],
                		line[41]
                );
                billingRecordEntityList.add(billingRecord);
            }
                                  
        } catch (IOException e) {
            e.printStackTrace();
        }

        return billingRecordEntityList;
    }

}
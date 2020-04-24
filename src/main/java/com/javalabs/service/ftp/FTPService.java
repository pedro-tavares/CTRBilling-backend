package com.javalabs.service.ftp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.javalabs.dto.Server;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

@Service
public class FTPService {

	private static Logger LOG = LoggerFactory.getLogger(FTPService.class);

	@SuppressWarnings("finally")
	public boolean login(Server theServer) throws Exception {
		LOG.debug("\nFTPService LOGIN, server:\n" + 
				theServer.getName() + ", " + 
				theServer.getIpAddress() + ", " + 
				theServer.getPort() + ", " +
				theServer.getUsername() + ", " +
				theServer.getPassword()
		);
		
		String server = theServer.getIpAddress();
        int port = theServer.getPort();
        String path = theServer.getPath();
        String user = theServer.getUsername();
        String pass = theServer.getPassword();
 
        FTPClient ftpClient = new FTPClient();
 
        try {
 
            ftpClient.connect(server, port);
            ftpClient.login(user, pass);
            ftpClient.enterLocalPassiveMode();
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

            // APPROACH #1: using retrieveFile(String, OutputStream)
            String fileName = "Daily_Calls_CTR001_01012018_43_20_ALL_V3.txt";
            String remoteFile1 = path + "/" + fileName;
            File downloadFile1 = new File(
            		"/home/spiro-admin/java_labs/CTRBilling-backend/target/downloads/" + 
            		fileName
            );
            OutputStream outputStream1 = new BufferedOutputStream(new FileOutputStream(downloadFile1));
            boolean success = ftpClient.retrieveFile(remoteFile1, outputStream1);
            outputStream1.close();
 
            if (success) {
                System.out.println("File " + fileName + " has been downloaded successfully.");
            }            
 
        } catch (Exception ex) {
        	LOG.debug("\nOOOPS! Something wrong happened.\n");
            ex.printStackTrace();
        } finally {
            // logs out and disconnects from server
            try {
                if (ftpClient.isConnected()) {
                    ftpClient.logout();
                    ftpClient.disconnect();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
                return false;
            }
            
            return true;
        }
		
	}
	
}

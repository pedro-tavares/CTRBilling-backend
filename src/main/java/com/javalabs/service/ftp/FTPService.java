package com.javalabs.service.ftp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.javalabs.dto.Server;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

@Service
public class FTPService {

	private static Logger LOG = LoggerFactory.getLogger(FTPService.class);

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
        String user = theServer.getUsername();
        String pass = theServer.getPassword();
 
        FTPClient ftpClient = new FTPClient();
 
        try {
 
            ftpClient.connect(server, port);
            showServerReply(ftpClient);
 
            int replyCode = ftpClient.getReplyCode();
            if (!FTPReply.isPositiveCompletion(replyCode)) {
                LOG.debug("\nConnect failed!\n");
                return false;
            }
 
            boolean success = ftpClient.login(user, pass);
            showServerReply(ftpClient);
 
            if (!success) {
                LOG.debug("\nCould not login to the server.\n");
                return false;
            }
 
            // Lists files and directories
            FTPFile[] files1 = ftpClient.listFiles("/public_ftp");
            printFileDetails(files1);
 
            // uses simpler methods
            String[] files2 = ftpClient.listNames();
            printNames(files2);
 
 
        } catch (IOException ex) {
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
            }
        }
		
		return true;
		
	}
	
    private static void printFileDetails(FTPFile[] files) {
        DateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (FTPFile file : files) {
            String details = file.getName();
            if (file.isDirectory()) {
                details = "[" + details + "]";
            }
            details += "\t\t" + file.getSize();
            details += "\t\t" + dateFormater.format(file.getTimestamp().getTime());
 
            System.out.println(details);
            LOG.debug("\nFile details:\n" + details);
        }
    }
 
    private static void printNames(String files[]) {
        if (files != null && files.length > 0) {
            for (String aFile: files) {
            	LOG.debug(aFile);
            }
        }
    }
 
    private static void showServerReply(FTPClient ftpClient) {
        String[] replies = ftpClient.getReplyStrings();
        if (replies != null && replies.length > 0) {
            for (String aReply : replies) {
                LOG.debug("showServerReply:" + aReply);
            }
        }
    }
    
}

package com.javalabs.ftp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.javalabs.constants.IConstants;
import com.javalabs.dto.DowloadFTPFileInfo;
import com.javalabs.dto.FTPFileInfo;
import com.javalabs.dto.Server;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

@Service
public class FTPService {

	private static Logger LOG = LoggerFactory.getLogger(FTPService.class);

	private FTPClient ftpClient;
	private String server;
	private int port;
	private String path;
	private String user;
	private String pass;
	
	public boolean login(Server theServer) throws Exception {
		LOG.debug("\nFTPService LOGIN, server:\n" + 
				theServer.getName() + ", " + 
				theServer.getIpAddress() + ", " +
				theServer.getPath() + ", " +				
				theServer.getPort() + ", " +
				theServer.getUsername() + ", " +
				theServer.getPassword()
		);
		
		server = theServer.getIpAddress();
        port = theServer.getPort();
        path = theServer.getPath();
        user = theServer.getUsername();
        pass = theServer.getPassword();
 
        ftpClient = new FTPClient();
        
        try {
            ftpClient.connect(server, port);
            ftpClient.login(user, pass);
        	
	    } catch (Exception ex) {
	    	LOG.debug("\nOOOPS! Something wrong happened.\n");
	        ex.printStackTrace();
	        return false;
	    }
        
        return true;
	}

	public List<FTPFileInfo> dir(Server theServer) throws Exception {
		List<FTPFileInfo> fileInfoList = new ArrayList<FTPFileInfo>();
 
        try {

        	this.login(theServer);
            ftpClient.enterLocalPassiveMode();
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
            
            FTPFile[] files = ftpClient.listFiles(theServer.getPath());
            
            if (files != null && files.length > 0) {
                for (FTPFile aFile : files) {
                    String currentFileName = aFile.getName();
                    if (currentFileName.equals(".") || currentFileName.equals("..")) {
                        // skip parent directory and the directory itself
                        continue;
                    }
     
                    if (aFile.isFile()) {
                    	FTPFileInfo fileInfo = new FTPFileInfo(aFile.getName(), aFile.getTimestamp().getTime());
                    	LOG.debug("Adding fileInfo:" + fileInfo.getName() + "," + fileInfo.getDate());
                    	
                    	fileInfoList.add(fileInfo);
                    }
                }
            }            
        } catch (Exception ex) {
        	LOG.debug("\nOOOPS! Something wrong happened.\n");
            ex.printStackTrace();
        } finally {
            try {
                if (ftpClient.isConnected()) {
                    ftpClient.logout();
                    ftpClient.disconnect();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        
        return fileInfoList;
	}
	
	@SuppressWarnings("finally")	
	public boolean download(DowloadFTPFileInfo fileInfo) throws Exception {
 
        try {

        	this.login(fileInfo.getServer());
            ftpClient.enterLocalPassiveMode();
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

            String remoteFile1 = path + "/" + fileInfo.getFileName();
            File downloadFile1 = new File(IConstants.DOWNLOADS_DIR + fileInfo.getFileName());
            OutputStream outputStream1 = new BufferedOutputStream(new FileOutputStream(downloadFile1));
            boolean success = ftpClient.retrieveFile(remoteFile1, outputStream1);
            outputStream1.close();
 
            if (success) {
            	LOG.debug("File " + fileInfo.getFileName() + " has been downloaded successfully.");
            }            
 
        } catch (Exception ex) {
        	LOG.debug("\nOOOPS! Something wrong happened.\n");
            ex.printStackTrace();
        } finally {
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

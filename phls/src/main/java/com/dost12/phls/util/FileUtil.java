package com.dost12.phls.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

public class FileUtil {

	private static final String ABS_PATH = "C:/Users/DOSTXII_LP2/Desktop/Developers Files Thanks/pnhlhsc github/pnhlhsc/phls/src/main/webapp/assets/images/";
	
	private static final String ABS_PATH2 = "C:/Users/DOSTXII_LP2/Desktop/Developers Files Thanks/pnhlhsc github/pnhlhsc/phls/src/main/webapp/assets/files/";
	
	
	private static String REAL_PATH = null;
	
	private static String REAL_PATH2 = null;
	
	private static final Logger logger = LoggerFactory.getLogger(FileUtil.class);
	
	public static boolean uploadFile(HttpServletRequest request, MultipartFile file, String code) 
	{				
		// get the real server path
		REAL_PATH = request.getSession().getServletContext().getRealPath("/assets/images/");
		
		logger.info(REAL_PATH);					
		// create the directories if it does not exist
		
		if(!new File(REAL_PATH).exists()) {
			new File(REAL_PATH).mkdirs();
		}
		
		if(!new File(ABS_PATH).exists()) {
			new File(ABS_PATH).mkdirs();
		}
		
		try {
			//transfer the file to both the location
			file.transferTo(new File(REAL_PATH + code + ".png"));
			file.transferTo(new File(ABS_PATH + code + ".png"));
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
		return true;
	}
	
	public static void uploadNoImage(HttpServletRequest request, String code) {
		// get the real server path
		REAL_PATH = request.getSession().getServletContext().getRealPath("/assets/images/");
	
		String imageURL = "http://placehold.it/640X480?text=No Image";
		String destinationServerFile = REAL_PATH + code + ".png";
		String destinationProjectFile = REAL_PATH + code + ".png";
				
		try {
			URL url = new URL(imageURL);				
			try (	
					InputStream is = url.openStream();
					OutputStream osREAL_PATH = new FileOutputStream(destinationServerFile);
					OutputStream osABS_PATH = new FileOutputStream(destinationProjectFile);
				){
			
				byte[] b = new byte[2048];
				int length;
				while((length = is.read(b))!= -1) {
					osREAL_PATH.write(b, 0, length);
					osABS_PATH.write(b, 0, length);
				}
			}			
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public static boolean uploadDoc(HttpServletRequest request, MultipartFile file, String code) 
	{				
		// get the real server path
		REAL_PATH2 = request.getSession().getServletContext().getRealPath("/assets/files/");
		
		logger.info(REAL_PATH2);					
		// create the directories if it does not exist
		
		if(!new File(REAL_PATH2).exists()) {
			new File(REAL_PATH2).mkdirs();
		}
		
		if(!new File(ABS_PATH2).exists()) {
			new File(ABS_PATH2).mkdirs();
		}
		
		try {
			//transfer the file to both the location
			file.transferTo(new File(REAL_PATH2 + code + ".pdf"));
			file.transferTo(new File(ABS_PATH2 + code + ".pdf"));
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
		return true;
	}
	
	
}

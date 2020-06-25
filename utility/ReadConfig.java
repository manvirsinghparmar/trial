package com.ecom.utility;

import java.io.File;
import java.io.FileInputStream;

import java.util.Properties;

public class ReadConfig {
	
	Properties pro;
	
	public ReadConfig() {
		
		File src = new File("./Configurations/config.properties");
	    try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
	    } catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("exception is : "+e);
		}
	
	}
	
	public String getApplicationURL() {
		return ( pro.getProperty("baseUrl"));
	}
	
	public String getUserName() {
		return ( pro.getProperty("userName"));
	}
	
	public String getPassword() {
		return ( pro.getProperty("password"));
	}
	
	public String getChromePath() {
		return ( pro.getProperty("chromePath"));
	}
	
	public String getIePath() {
		return ( pro.getProperty("iePath"));
	}
	
	public String getLoginDataFilePath() {
		return ( pro.getProperty("loginDataFile"));
	}
	
	
	

}

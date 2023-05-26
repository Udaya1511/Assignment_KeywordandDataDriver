package com.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {
	
	Properties pro;
	
	
	public ConfigDataProvider() {
		File src = new File("C:\\Users\\UD20461958\\Selenium\\Assignement_Data-KeyWordDriven\\Configuration\\configg.properties");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
			
		} catch (Exception e) {
			System.out.println("Unable to load properties file " + e.getMessage());
		}
	}

	public String getBrowser() {
		return pro.getProperty("Browser");

	}
	
	public String getAppUrl() {
		return pro.getProperty("AppUrl");

	}
}

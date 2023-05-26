package com.Utilities;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class BaseClassTest {
	public WebDriver driver;
	ExcelDataReader excel;
	ConfigDataProvider configg;
	BrowserFactory bf;
	BaseClass bc;
	BaseClassTest bs;
	
	
	
	
	@BeforeSuite
	public void setUp() throws Exception {
		excel = new ExcelDataReader();
		configg = new ConfigDataProvider();
		
	}
	
	@BeforeClass
	public void BrowserTest() {
		bf = new BrowserFactory();
		driver = bf.browserOptions(driver, configg.getBrowser(), configg.getAppUrl());
		

	}
	
	
	public void tearDwon() {
		driver = bf.quitBrowser(driver);

	}
	
	@AfterMethod
	public void tearDownMehtod(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			bc = new BaseClass(driver);
			bc.capturedScreenShot(driver);
		}

	}

}

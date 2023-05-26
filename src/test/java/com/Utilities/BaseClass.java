package com.Utilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;

public class BaseClass {
	
	public WebDriver driver;
	
	public BaseClass(WebDriver driver) {
		this.driver = driver;
		
		
	}
	
	public WebDriver browserLaunch(String browser) {
		
		
		if(browser.equalsIgnoreCase("Google Chrome") || (browser.equalsIgnoreCase("Chrome"))) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\UD20461958\\Selenium\\Locators\\SeleniumWebDriver\\chromedriver.exe");
			driver = new ChromeDriver();
			
		} else if (browser.equalsIgnoreCase("Microsoft Edge") || (browser.equalsIgnoreCase("edge"))) {
			System.setProperty("webdriver.edge.driver", "C:\\Users\\UD20461958\\Selenium\\Locators\\SeleniumWebDriver\\msedgedriver.exe");
			driver = new EdgeDriver();
			
		} else {
			System.out.println("Sorry!!!! -- Browser Not Supported");
		}
		return driver;
		
	}
	
	public static void closeBrowser(WebDriver driver) {
		driver.quit();

	}
	
	public String titleVerify(String expectedtit) {

		String expectedTitle = expectedtit;
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		return actualTitle;


	}
	
	public String VerifyText(String expectedtxt, String actualTitle) {
		String expectedTitle = expectedtxt;
		Assert.assertEquals(actualTitle, expectedTitle);
		return actualTitle;

	}
	
	public void capturedScreenShot(WebDriver driver) {


		try {
			TakesScreenshot ts = (TakesScreenshot)driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			File des = new File("C:\\Users\\UD20461958\\Selenium\\DataDrivenKeyWordDriven\\ScreenShots\\EasyCall" + getCurrentDateTime() + ".png");
			FileHandler.copy(src, des);
			System.out.println("Captured Screenshot - By Selenium");
		} catch (IOException e){
			System.out.println("Something Went Wrong while copying the file " + e.getMessage());
		}

	}
	
	public String getCurrentDateTime() {
		DateFormat customFormat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currentdat = new Date();
		return customFormat.format(currentdat);
	}
	
	
}

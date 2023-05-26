package com.Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class BrowserFactory {

	static WebDriver driver;
	
	
	public WebDriver browserOptions(WebDriver driver, String browser, String AppUrl) {


		if(browser.equalsIgnoreCase("Google Chrome") || (browser.equalsIgnoreCase("Chrome"))) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\UD20461958\\Selenium\\Locators\\SeleniumWebDriver\\chromedriver.exe");
			driver = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("Microsoft Edge") || (browser.equalsIgnoreCase("edge"))) {
			System.setProperty("webdriver.edge.driver", "C:\\Users\\UD20461958\\Selenium\\Locators\\SeleniumWebDriver\\msedgedriver.exe");
			driver = new EdgeDriver();

		} else {
			
			System.out.println("System not support this browser");
		}

		driver.manage().window().maximize();
		driver.get(AppUrl);
		return driver;

	}
	
	public WebDriver quitBrowser(WebDriver driver) {
		driver.quit();
		return driver;

	}

}

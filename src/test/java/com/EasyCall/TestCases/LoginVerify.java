package com.EasyCall.TestCases;

import java.io.FileNotFoundException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.EasyCal.Pages.Login_Page;
import com.Utilities.BaseClass;
import com.Utilities.BaseClassTest;
import com.Utilities.ExcelDataReader;

public class LoginVerify extends BaseClassTest {
	
	
	@Test
	public void loginApp() throws FileNotFoundException{
		
		ExcelDataReader excel = new ExcelDataReader();
		Login_Page loginTest = new Login_Page(driver);
//		loginTest.login_EasyCal(excel.getStringData(0, 0, 0), excel.getStringData(0, 0, 1));
		loginTest.login_EasyCal(excel.getStringData(0, 0, 0), excel.getStringData(0, 0, 1),excel.getStringData(0, 0, 2) ,excel.getStringData(0, 0, 3), excel.getStringData(0, 0, 4));
		
	}

}

package com.EasyCal.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Utilities.BaseClass;

public class Login_Page {
	WebDriver driver;
	BaseClass bc = new BaseClass(driver);
	
	
	public Login_Page(WebDriver driver) {
//		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(xpath = "//button[text()='Manage cookies']")
	private WebElement cookie;
	@FindBy(id = "firstName")
	private WebElement firsname;
	@FindBy(id = "lastName")
	private WebElement lastname;
	@FindBy(id = "email")
	private WebElement email;
	@FindBy(id = "password")
	private WebElement password;
	@FindBy(id = "confirmPassword")
	private WebElement password2;
	@FindBy(name = "terms")
	private WebElement terms;
	@FindBy(xpath = "//button[text()='Create an account']")
	private WebElement loginbtn;
	@FindBy(xpath = "//h4[text()='Account created']")
	private WebElement vertext;
	
	
	public void login_EasyCal(String fis,String las, String username, String pass2, String pass) {
		
		if(cookie.isDisplayed()) {
			cookie.click();
		} else {
			System.out.println("cookie not present");
		}
		firsname.sendKeys(fis);
		lastname.sendKeys(las);
		email.sendKeys(username);
		password.sendKeys(pass);
		password2.sendKeys(pass2);
		terms.click();
		loginbtn.click();
		String text = vertext.getText();
		bc.VerifyText(text, "Account created");
	}

}

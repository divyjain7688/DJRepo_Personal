package com.crm.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class LoginPage extends TestBase{
	
	//Page Factory - OR:
	@FindBy(xpath="//input[@name=\"email\"]")
	WebElement username;
	
	@FindBy(xpath="//input[@name=\"password\"]")
	WebElement password;
	
	@FindBy(xpath="//div[@class=\"ui fluid large blue submit button\"]")
	WebElement loginBtn;
	
	@FindBy(xpath="//a[@class=\"btn btn-primary btn-xs-2 btn-shadow btn-rect btn-icon btn-icon-left\"]")
	WebElement loginBtnHeader;
	
	@FindBy(xpath="//button[contains(text(),'Sign Up')]")
	WebElement signUpBtn;
	
	@FindBy(xpath="//div[@class=\"rd-navbar-wrap\"]//div[@class=\"rd-navbar-brand\"]")
	WebElement crmLogo;
	
	//Initializing the Page Objects:
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	public boolean validateCRMImage(){
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(String un, String pwd) 
	{
		loginBtnHeader.click();
		TestUtil.waitForElement(driver, username);
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		   /* 	JavascriptExecutor js = (JavascriptExecutor)driver;
		    	js.executeScript("arguments[0].click();", loginBtn);*/
		 
		return new HomePage();
	}
	
}

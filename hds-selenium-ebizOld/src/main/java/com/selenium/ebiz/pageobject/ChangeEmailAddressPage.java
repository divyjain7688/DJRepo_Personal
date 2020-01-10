package com.selenium.ebiz.pageobject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.selenium.ebiz.tools.WaitTool;

public class ChangeEmailAddressPage {

	WebDriver driver;
	public ChangeEmailAddressPage(WebDriver driver) 	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(changeEmailAddressHeader));
	}
	
	// Change email address header
		@FindBy(xpath= "//h2")
		WebElement changeEmailAddressHeader;
		
		@FindBy(xpath= "//input[@id='email1']")
		WebElement newMailField;
		
		@FindBy(xpath= "//input[@id='verifyEmail']")
		WebElement confirmNewMailField;	
		
		@FindBy(xpath= "//button[@class='btn btn--hollow']")
		WebElement updateButton;	
		
		public MyAccountPage updateNewEmailAddress(String newMailAddress) {
			newMailField.sendKeys(newMailAddress);	
			confirmNewMailField.sendKeys(newMailAddress);
			updateButton.click();
			driver.manage().timeouts().pageLoadTimeout(WaitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			return new MyAccountPage(driver);
		}
		
		

}

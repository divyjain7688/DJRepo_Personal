package com.selenium.ebiz.pageobject;

import com.selenium.ebiz.tools.WaitTool;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class ChangeEmailAddressPage {

	private  WebDriver driver; private WaitTool   waitTool;

	public ChangeEmailAddressPage(WebDriver driver)
	{
		this.driver = driver;  this.waitTool = new WaitTool();
		PageFactory.initElements(driver, this);

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
			driver.manage().timeouts().pageLoadTimeout(waitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			return new MyAccountPage(driver);
		}
		
		

}

package com.selenium.ebiz.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.selenium.ebiz.baseclass.BaseClass;
import com.selenium.ebiz.tools.WaitTool;

public class SignInOrRegisterPage extends BaseClass {
	
	public SignInOrRegisterPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.visibilityOf((userNameEdit)));
	}
	
		@FindBy(id = "WC_AccountDisplay_FormInput_logonId_In_Logon_1")  
		WebElement userNameEdit;

		@FindBy(id = "WC_AccountDisplay_FormInput_logonPassword_In_Logon_1")     
		WebElement passwordEdit;

		@FindBy(css = "button.btn.sign-in__submit--full") 
		WebElement signInButton;
		
		@FindBy(xpath = "//div[@data-hds-tag='account-retrieval-sign-in__error']") 
		WebElement userNamePasswordErrorMessage;
		
		@FindBy(xpath = "//button[@class=\"btn btn--hollow sign-in__submit--full\"]") 
		WebElement registerButton;
		
		
		/**
		 * Enter username
		 * @param username
		 */
		public void enterUserName(String username) {
			userNameEdit.clear();
			userNameEdit.sendKeys(username);
		}

		/**
		 * Enter Password
		 * @param password
		 */
		public void enterPassword(String password) {
			passwordEdit.clear();
			passwordEdit.sendKeys(password);
		}

		/**
		 * Click on Sign In button
		 */
		public void clickSignInButton() {
			signInButton.click();
			//WaitTool.waitFor(driver, true);
		}
		
		public QuickOrderPage loginToFromQO(String username, String password) {
			enterUserName(username);
			enterPassword(password);
			clickSignInButton();
			return new QuickOrderPage(driver);
		}
		
		/**
		 * For guest user ,Click on my qccount quick links on utility bar should ask user to login and this method to login from that page
		 * @param username
		 * @param password
		 */
		public void loginToFromBrowsePage(String username, String password) {
			enterUserName(username);
			enterPassword(password);
			clickSignInButton();
			WaitTool.waitFor(driver, true);
		}
		
		public Boolean isUserNamePasswordErrorMessageDisplayed()
		{
			return userNamePasswordErrorMessage.isDisplayed();
		}
		
		public RegisterForAnAccountPage clickOnRegisterButton()
		{
			registerButton.click();
			return new RegisterForAnAccountPage(driver);
		}
}

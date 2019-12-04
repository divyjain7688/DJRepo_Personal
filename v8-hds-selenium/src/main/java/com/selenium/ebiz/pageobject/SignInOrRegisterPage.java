package com.selenium.ebiz.pageobject;

import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.WaitTool;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInOrRegisterPage {
	private  WebDriver driver;
	private WaitTool   waitTool;
	private PageManager pageManager;
	
	public SignInOrRegisterPage(WebDriver driver){
		this.driver = driver;
		this.waitTool = new WaitTool();
		this.pageManager = new PageManager(driver);
		PageFactory.initElements(driver, this);
	}
	
		@FindBy(id = "WC_AccountDisplay_FormInput_logonId_In_Logon_1")  
		public WebElement userNameEdit;

		@FindBy(id = "WC_AccountDisplay_FormInput_logonPassword_In_Logon_1")     
		WebElement passwordEdit;

		@FindBy(css = "button.btn.sign-in__submit--full") 
		WebElement signInButton;
		
		@FindBy(xpath = "//div[@data-hds-tag='account-retrieval-sign-in__error']") 
		WebElement userNamePasswordErrorMessage;
		
		@FindBy(xpath = "//button[@class='btn btn--hollow sign-in__submit--full']") 
		WebElement registerButton;
		
		@FindBy(xpath = "//h1[@data-hds-tag='account-retrieval-sign-in__heading']")
		public WebElement signInOrRegisterTitle;
		
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
			//waitTool.waitFor(driver, true);
		}
		
		public QuickOrderPage loginToFromQO(String username, String password) {
			enterUserName(username);
			enterPassword(password);
			clickSignInButton();
			return new QuickOrderPage(driver);
		}
		
		/**
		 * For guest user ,Click on my qccount quick links on utility bar should ask user to login and this method to login from that page
		 * @param Username
		 * @param Password
		 */
		public void loginToFromBrowsePage(String Username, String Password) {
			enterUserName(Username);
			enterPassword(Password);
			clickSignInButton();
			waitTool.waitFor(driver, true);
		}
		
		public Boolean isUserNamePasswordErrorMessageDisplayed()
		{
			waitTool.waitForElement(driver, userNamePasswordErrorMessage);
			pageManager.common().scrolltoViewElement(userNamePasswordErrorMessage, driver);
			return userNamePasswordErrorMessage.isDisplayed();
		}
		
		public void clickOnRegisterButton()
		{
			registerButton.click();

		}
		
		public Boolean isSignInOrRegisterTitleDisplayed()
		{
			waitTool.waitForElement(driver, signInOrRegisterTitle);
			return signInOrRegisterTitle.isDisplayed();
		}
}

package com.selenium.ebiz.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.selenium.ebiz.baseclass.BaseClass;
import com.selenium.ebiz.tools.WaitTool;

public class AccountRetrievalPage extends BaseClass{
	WebDriver driver;
	public AccountRetrievalPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf((AccountRetrievalPageHeadingText)));
	}
	
	//Account Retrieval Page heading text
	@FindBy(xpath = "//div[@id='page']//h1[contains(text(),'Account Retrieval')]")
	WebElement AccountRetrievalPageHeadingText;
	
	//username
	@FindBy(id = "username")  
	WebElement usernameEdit;

	//Email Address
	@FindBy(id = "emailaddress")     
	WebElement emailAddressEdit;
	// Email Edit
	@FindBy(xpath=" //input[@id='emailaddress']")
	WebElement emailEdit;
	
	@FindBy(xpath="//form[@id='ForgotUsernameForm']//span[contains(text(),'My email is my username')]/../span[1]")
	WebElement userNameCheckbox;
		
	/**
	 * Select userName me checkbox
	 */
	public void selectUserNameCheckbox() {
		userNameCheckbox.click();
	}

	//Email Address
	@FindBy(xpath = "//form[@id='ForgotUsernameForm']/fieldset/label/span[1]")     
	WebElement myEmailIsMyUsernameCheckbox;
	
	//Submit button
	@FindBy(xpath = "//form[@id='ForgotUsernameForm']//button[text()='Submit']")
	WebElement submitButton;
	
	//Account Retrieval page success message
	
	@FindBy(xpath ="//*[@id=\"page\"]/div[3]/div/div/div/div/div[1]/div/div[1]/h3")
	WebElement AccountRetrievalCredentialsSendSuccesPage;
	
	// Check box of email my username
	@FindBy(xpath ="//input[@name='cboxusername']")
	WebElement emailUsernameCheckbox;
	
	
	
	
	/**
	 * @return true if Account Retrieval Page has form fields for username and email Address otherwise false
	 */
	public boolean isDisplayedAccountRetrievalPageFormFields() {
		return usernameEdit.isDisplayed() && emailAddressEdit.isDisplayed();

	}
	
	/**
	 * @return true if Account Retrieval Page heading text is displayed otherwise false
	 */
	public boolean isDisplayedAccountRetrievalPage() {
		WaitTool.waitFor(driver, true);
		return AccountRetrievalPageHeadingText.isDisplayed();

	}
	
	/**
	 * Select My email is my username checkbox
	 */
	public void selectMyEmailIsMyUsernameCheckbox() {
		myEmailIsMyUsernameCheckbox.click();
	}
	
	
	public void enterEmailAddress(String emailID) {
		emailAddressEdit.clear();
//		emailAddressEdit.sendKeys("neha.dev@hdsupply.com");
		emailAddressEdit.sendKeys(emailID);
	}
	
	public void enterEmailEdit(String emailID) {
		emailEdit.clear();
		emailEdit.sendKeys(emailID);
	}
	/**
	 * Click on Submit button
	 */
	public void clickSubmitButton() {
		submitButton.click();
	}
	
	public String AccountRetrievalCredentialsSendSuccesPage() {
		 return AccountRetrievalCredentialsSendSuccesPage.getText();
		
	}
	
	/**
	 * Click on Email my Username
	 */
	public void clickEmailUsernameCheckbox() {
		emailUsernameCheckbox.click();
	}
	// Getting the attributes of UserName
	public String getEmailUserNameAttribute() {
		 return usernameEdit.getAttribute("value");
		
	}
	
	/**
	 * @return true if Account Retrieval Page heading text is displayed otherwise false
	 */
	public boolean isEmailUserNameUnChecked() {
		WaitTool.waitFor(driver, true);
		return emailUsernameCheckbox.isSelected();

	}
	
	
}


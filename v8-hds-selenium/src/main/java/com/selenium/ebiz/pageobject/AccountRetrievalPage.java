package com.selenium.ebiz.pageobject;

import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.WaitTool;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountRetrievalPage {

	private WebDriver driver;
	private WaitTool waitTool;
	private PageManager pageManager;

	public AccountRetrievalPage(WebDriver driver) {
		this.driver = driver;
		this.waitTool = new WaitTool();
		this.pageManager=new PageManager(driver);
		PageFactory.initElements(driver, this);

	}

	// Account Retrieval Page heading text
	@FindBy(xpath = "//div[@id='page']//h1[contains(text(),'Account Retrieval')]")
	public WebElement AccountRetrievalPageHeadingText;

	// username
	@FindBy(id = "username")
	WebElement usernameEdit;

	// Email Address
	@FindBy(id = "emailaddress")
	WebElement emailAddressEdit;

	// Email Address
	@FindBy(xpath = "//form[@id='ForgotUsernameForm']/fieldset/label/span[1]")
	public WebElement myEmailIsMyUsernameCheckbox;

	// Submit button
	@FindBy(xpath = "//form[@id='ForgotUsernameForm']//button[text()='Submit']")
	public WebElement submitButton;

	// Account Retrieval page success message
	@FindBy(xpath = "//*[@id=\"page\"]/div[3]/div/div/div/div/div[1]/div/div[1]/h3")
	WebElement AccountRetrievalCredentialsSendSuccesPage;

	/**
	 * @return true if Account Retrieval Page has form fields for username and email
	 *         Address otherwise false
	 */
	public boolean isDisplayedAccountRetrievalPageFormFields() {
		return usernameEdit.isDisplayed() && emailAddressEdit.isDisplayed();
	}

	public void enterEmailAddress(String emailID) {
		waitTool.waitForElement(driver, emailAddressEdit);
		emailAddressEdit.clear();
		emailAddressEdit.sendKeys(emailID);
	}

	public String AccountRetrievalCredentialsSendSuccesPage() {
		pageManager.common().scrolltoViewElement(AccountRetrievalCredentialsSendSuccesPage, driver);
		waitTool.waitForElement(driver, AccountRetrievalCredentialsSendSuccesPage);
		return AccountRetrievalCredentialsSendSuccesPage.getText();
	}

	// Getting the attributes of UserName
	public String getEmailUserNameAttribute() {
		return usernameEdit.getAttribute("value");
	}
}

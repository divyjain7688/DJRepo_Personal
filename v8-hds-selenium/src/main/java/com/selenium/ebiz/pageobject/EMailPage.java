package com.selenium.ebiz.pageobject;

import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.WaitTool;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EMailPage {


	private  WebDriver driver;
	private WaitTool   waitTool;
	public static String environmentValue;
	private PageManager pageManager;

	public EMailPage(WebDriver driver)
	{
		this.driver = driver;
		this.waitTool = new WaitTool();
		PageFactory.initElements(driver, this);
		this.pageManager=new PageManager(driver);
	}
	
	@FindBy(xpath = "//h1[contains(text(),'Email Page')]")
	public WebElement emailPageTitle;
	
	@FindBy(xpath = "//textarea[@id='emailTo']")
	WebElement toTextFeild;
	
	@FindBy(xpath = "//textarea[@id='emailBody']")
	WebElement messageTextFeild;
	
	@FindBy(xpath = "//button[@data-hds-tag='send-email__send-email']")
	WebElement sendButton;

	public void fillOutEmailFields(String email,String message) {
		pageManager.eMailPage().enterToTextFeild(email);
		pageManager.eMailPage().enterMessageTextFeild(message);
		System.out.println(email +"   "+ message);
		pageManager.eMailPage().clickOnSendButton();
		pageManager.common().acceptPopupMessageBox(driver);
		waitTool.waitFor(driver, true);
	}
	
	public boolean isDisplayedEmailPageTitle(){
		waitTool.waitForElement(driver, emailPageTitle);
		return emailPageTitle.isDisplayed();
	}
	
	public void enterToTextFeild(String email){
		waitTool.waitForElement(driver, toTextFeild);
		toTextFeild.clear();
		toTextFeild.sendKeys(email);	
	}

	public void enterMessageTextFeild(String msg){
		messageTextFeild.clear();
		messageTextFeild.sendKeys(msg);	
	}
	
	public void clickOnSendButton(){
		sendButton.click();	
	}





}
package com.selenium.ebiz.pageobject;

import com.selenium.ebiz.tools.WaitTool;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CommunicationsPreferencesPage
{
	private  WebDriver driver; private WaitTool   waitTool;
	
	public CommunicationsPreferencesPage(WebDriver driver) {
		this.driver = driver;  this.waitTool = new WaitTool();
		PageFactory.initElements(driver, this);

	}
		
		//Communication Preferences Page heading text
		@FindBy (xpath = "//*[@id=\"content\"]/div[2]/h2")
		WebElement CommunicationsPreferencesPageHeadingText;
		
		@FindBy (xpath = "//*[(@name='userProfileField1') and (@value='W')]")
		WebElement onlyMyWebOrdersRadioOption;
		
		@FindBy (xpath = "//*[(@name='userProfileField1') and (@value='A')]")
		WebElement allOrderAtMyPropertyRadioOption;
		
		@FindBy (xpath = "//*[@id=\"Register\"]/div/div[2]/div[2]/button")
		WebElement  updateButton;
		
		/**
		 * Method to update communication preferences
		 */
		public boolean option2Selected;
		public boolean option1Selected;
		
		public MyAccountPage updatePreferences() throws Exception {
			if (onlyMyWebOrdersRadioOption.isSelected()) {
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", allOrderAtMyPropertyRadioOption);
				//waitTool.hardWait();
				option1Selected = onlyMyWebOrdersRadioOption.isSelected();
				updateButton.click();
				return new MyAccountPage(driver);
				
							}
			
			else {	
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", onlyMyWebOrdersRadioOption);
				option2Selected = allOrderAtMyPropertyRadioOption.isSelected();
				updateButton.click();
				return new MyAccountPage(driver);
			}
		
		}
		
		/**
		 * Method to validate updated communication preferences worked
		 */
		public boolean updatedOption2Selected;
		public boolean updatedOption1Selected;
		
		public void communicationsPreferencesCheck() {
			updatedOption1Selected = onlyMyWebOrdersRadioOption.isSelected();
			updatedOption2Selected = allOrderAtMyPropertyRadioOption.isSelected();
		}
		
	}

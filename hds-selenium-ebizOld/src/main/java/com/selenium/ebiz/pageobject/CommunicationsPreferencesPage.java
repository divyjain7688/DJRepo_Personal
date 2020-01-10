package com.selenium.ebiz.pageobject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.selenium.ebiz.baseclass.BaseClass;
import com.selenium.ebiz.tools.WaitTool;

public class CommunicationsPreferencesPage extends BaseClass{
	
	public CommunicationsPreferencesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf((CommunicationsPreferencesPageHeadingText)));
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
				WaitTool.hardWait();
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

package com.selenium.ebiz.pageobject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.selenium.ebiz.baseclass.BaseClass;
import com.selenium.ebiz.tools.WaitTool;

public class SubCategoryElectronicsPage extends BaseClass{

	public SubCategoryElectronicsPage(WebDriver driver) 	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		//WebDriverWait wait = new WebDriverWait(driver, 25);
		
	}
	
	// Sub Categories Mirrors
	@FindBy(linkText = "Mirrors")
	WebElement subCategoryMirrorsLinkText;

	// Sub Categories Video Monitoring Accessories
	@FindBy(linkText = "Video Monitoring Accessories")
	WebElement subCategoryVideoMonitoringAccessoriesLinkText;

	// Sub Categories Ethernet Cables
	@FindBy(linkText = "Ethernet Cables")
	WebElement subCategoryEthernetCablesLinkText;

	// Sub Categories Telephone Cords
	@FindBy(linkText = "Telephone Cords")
	WebElement subCategoryTelephoneCordsLinkText;

	// Sub Categories Two-Way Radios
	@FindBy(linkText = "Two-Way Radios")
	WebElement subCategoryTwoWayRadiosLinkText;

	// Sub Categories Antennas
	@FindBy(linkText = "Antennas")
	WebElement subCategoryAntennasLinkText;

	// Method to Click on Antennas in Sub Categories	
	public void clickSubCategoryAntennasLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryAntennasLinkText);
			subCategoryAntennasLinkText.click();
			driver.manage().timeouts().pageLoadTimeout(WaitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			
		}
	
	// Method to Click on Two-Way Radios in Sub Categories	
	public void clickSubCategoryTwoWayRadiosLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryTwoWayRadiosLinkText);
			subCategoryTwoWayRadiosLinkText.click();
			driver.manage().timeouts().pageLoadTimeout(WaitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			
		}

	// Method to Click on Telephone Cords in Sub Categories	
	public void clickSubCategoryTelephoneCordsLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryTelephoneCordsLinkText);
			subCategoryTelephoneCordsLinkText.click();
			driver.manage().timeouts().pageLoadTimeout(WaitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			
		}
	
	// Method to Click on Ethernet Cables in Sub Categories	
	public void clickSubCategoryEthernetCablesLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryEthernetCablesLinkText);
			subCategoryEthernetCablesLinkText.click();
			driver.manage().timeouts().pageLoadTimeout(WaitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			
		}
	
	// Method to Click on Video Monitoring Accessories in Sub Categories	
	public void clickSubCategoryVideoMonitoringAccessoriesLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryVideoMonitoringAccessoriesLinkText);
			subCategoryVideoMonitoringAccessoriesLinkText.click();
			driver.manage().timeouts().pageLoadTimeout(WaitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			
		}
	
	
	// Method to Click on Mirrors in Sub Categories	
	public void clickSubCategoryMirrorsLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryMirrorsLinkText);
			subCategoryMirrorsLinkText.click();
			driver.manage().timeouts().pageLoadTimeout(WaitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			
		}
	
	
}

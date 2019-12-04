package com.selenium.ebiz.pageobject;

import com.selenium.ebiz.tools.WaitTool;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class SubCategoryElectronicsPage {

	private  WebDriver driver; private WaitTool   waitTool;

	public SubCategoryElectronicsPage(WebDriver driver) 	{
		this.driver = driver;  this.waitTool = new WaitTool();
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
			waitTool.waitForElement(driver, subCategoryAntennasLinkText);
			subCategoryAntennasLinkText.click();
			driver.manage().timeouts().pageLoadTimeout(waitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			
		}
	
	// Method to Click on Two-Way Radios in Sub Categories	
	public void clickSubCategoryTwoWayRadiosLinkText() throws InterruptedException {
			waitTool.waitForElement(driver, subCategoryTwoWayRadiosLinkText);
			subCategoryTwoWayRadiosLinkText.click();
			driver.manage().timeouts().pageLoadTimeout(waitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			
		}

	// Method to Click on Telephone Cords in Sub Categories	
	public void clickSubCategoryTelephoneCordsLinkText() throws InterruptedException {
			waitTool.waitForElement(driver, subCategoryTelephoneCordsLinkText);
			subCategoryTelephoneCordsLinkText.click();
			driver.manage().timeouts().pageLoadTimeout(waitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			
		}
	
	// Method to Click on Ethernet Cables in Sub Categories	
	public void clickSubCategoryEthernetCablesLinkText() throws InterruptedException {
			waitTool.waitForElement(driver, subCategoryEthernetCablesLinkText);
			subCategoryEthernetCablesLinkText.click();
			driver.manage().timeouts().pageLoadTimeout(waitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			
		}
	
	// Method to Click on Video Monitoring Accessories in Sub Categories	
	public void clickSubCategoryVideoMonitoringAccessoriesLinkText() throws InterruptedException {
			waitTool.waitForElement(driver, subCategoryVideoMonitoringAccessoriesLinkText);
			subCategoryVideoMonitoringAccessoriesLinkText.click();
			driver.manage().timeouts().pageLoadTimeout(waitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			
		}
	
	
	// Method to Click on Mirrors in Sub Categories	
	public void clickSubCategoryMirrorsLinkText() throws InterruptedException {
			waitTool.waitForElement(driver, subCategoryMirrorsLinkText);
			subCategoryMirrorsLinkText.click();
			driver.manage().timeouts().pageLoadTimeout(waitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			
		}
	
	
}

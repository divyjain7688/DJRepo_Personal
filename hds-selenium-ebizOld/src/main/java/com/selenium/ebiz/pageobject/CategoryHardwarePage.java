package com.selenium.ebiz.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.selenium.ebiz.baseclass.BaseClass;
import com.selenium.ebiz.tools.WaitTool;

public class CategoryHardwarePage extends BaseClass{

	// Constructor
	public CategoryHardwarePage(WebDriver driver) 	{
		PageFactory.initElements(driver, this);
		
	}

	/* Element identifiers. */

	// Top Categories Storm Door Hardware
	@FindBy(linkText = "Storm Door Hardware")
	WebElement topCategoryStormDoorHardwareLinkText;

	// Top Categories Door & Wall Protection
	@FindBy(linkText = "Door & Wall Protection")
	WebElement topCategoryDoorWallProtectionLinkText;

	// Top Categories Weatherization
	@FindBy(linkText = "Weatherization")
	WebElement topCategoryWeatherizationLinkText;

	// Top Categories Cabinet & Drawer Hardware
	@FindBy(linkText = "Cabinet & Drawer Hardware")
	WebElement topCategoryCabinetDrawerHardwareLinkText;

	// Top Categories Bypass & Bi-Fold Door Hardware
	@FindBy(linkText = "Bypass & Bi-Fold Door Hardware")
	WebElement topCategoryBypassBiFoldDoorHardwareLinkText;

	// Top Categories Connecting & Fastening Hardware
	@FindBy(linkText = "Connecting & Fastening Hardware")
	WebElement topCategoryConnectingFasteningHardwareLinkText;
	
	// Top Categories Fireplace
	@FindBy(linkText = "Fireplace")
	WebElement topCategoryFireplaceLinkText;

	// Top Categories Bath Accessories & Hardware
	@FindBy(linkText = "Bath Accessories & Hardware")
	WebElement topCategoryBathAccessoriesHardwareLinkText;

	// Top Categories Garage Door Hardware
	@FindBy(linkText = "Garage Door Hardware")
	WebElement topCategoryGarageDoorHardwareLinkText;

	// Top Categories Gate Hardware
	@FindBy(linkText = "Gate Hardware")
	WebElement topCategoryGateHardwareLinkText;
	
	// Top Categories Glass Door Hardware
	@FindBy(linkText = "Glass Door Hardware")
	WebElement topCategoryGlassDoorHardwareLinkText;

	// Top Categories Keys & Accessories
	@FindBy(linkText = "Keys & Accessories")
	WebElement topCategoryKeysAccessoriesLinkText;

	// Top Categories Mailboxes & Accessories
	@FindBy(linkText = "Mailboxes & Accessories")
	WebElement topCategoryMailboxesAccessoriesLinkText;

	// Top Categories Padlocks & Key Cables
	@FindBy(linkText = "Padlocks & Key Cables")
	WebElement topCategoryPadlocksKeyCablesLinkText;

	// Top Categories Screen Door Hardware
	@FindBy(linkText = "Screen Door Hardware")
	WebElement topCategoryScreenDoorHardwareLinkText;
	
	// Top Categories Screening & Accessories
	@FindBy(linkText = "Screening & Accessories")
	WebElement topCategoryScreeningAccessoriesLinkText;

	// Top Categories Window Hardware
	@FindBy(linkText = "Window Hardware")
	WebElement topCategoryWindowHardwareLinkText;

	// Top Categories Bungees, Tie-Downs & Straps
	@FindBy(linkText = "Bungees, Tie-Downs & Straps")
	WebElement topCategoryBungeesTieDownsStrapsLinkText;

	// Top Categories Fasteners
	@FindBy(linkText = "Fasteners")
	WebElement topCategoryFastenersLinkText;

	// Top Categories Chain & Cable
	@FindBy(linkText = "Chain & Cable")
	WebElement topCategoryChainCableLinkText;

	// Top Categories Commercial Exit/Entry
	@FindBy(linkText = "Commercial Exit/Entry")
	WebElement topCategoryCommercialExitEntryLinkText;
	
	// Top Categories FOB & Key Reader Systems
	@FindBy(linkText = "FOB & Key Reader Systems")
	WebElement topCategoryFOBKeyReaderSystemsLinkText;
	
	// Top Categories Door Hinges And Closers
	@FindBy(linkText = "Door Hinges And Closers")
	WebElement topCategoryDoorHingesAndClosersLinkText;

	// Top Categories Door Security
	@FindBy(linkText = "Door Security")
	WebElement topCategoryDoorSecurityLinkText;

	// Top Categories Locks & Accessories
	@FindBy(linkText = "Locks & Accessories")
	WebElement topCategoryLocksAccessoriesLinkText;

	// Top Categories Safes
	@FindBy(linkText = "Safes")
	WebElement topCategorySafesLinkText;
	
	//To home page link
	@FindBy(xpath = "//*[@id='WC_BreadCrumb_Link_1_1_-3028_40453']")
	WebElement categoryHomeLinkText;

	//To Verify for the top category
	@FindBy(xpath = "//*[@id='PageHeading_2_-3001_40466']/h1")
	WebElement topCategoryPageHeadingText;
		
	// To Get the Text from the Page Heading
	public String getCategoryPageHeadingText() {
		return topCategoryPageHeadingText.getText().trim();
		}
	
	// Navigate to Previous Page
	public void navigateBackToPage() {
		driver.navigate().back();
	}
	
	// Method to Click on Storm Door Hardware in Top Categories
	public SubCategoryHardwarePage clickTopCategoryStormDoorHardwareLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, topCategoryStormDoorHardwareLinkText);
			topCategoryStormDoorHardwareLinkText.click();
			WaitTool.waitFor(driver,true) ;
			return new SubCategoryHardwarePage(driver);
		}
	// Method to Click on Door Wall Protection in Top Categories
	public SubCategoryHardwarePage clickTopCategoryDoorWallProtectionLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, topCategoryDoorWallProtectionLinkText);
			topCategoryDoorWallProtectionLinkText.click();
			WaitTool.waitFor(driver,true) ;
			return new SubCategoryHardwarePage(driver);
		}
	// Method to Click on Weatherization in Top Categories
	public SubCategoryHardwarePage clickTopCategoryWeatherizationLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, topCategoryWeatherizationLinkText);
			topCategoryWeatherizationLinkText.click();
			WaitTool.waitFor(driver,true) ;
			return new SubCategoryHardwarePage(driver);
		}
	// Method to Click on Cabinet & Drawer Hardware in Top Categories
	public SubCategoryHardwarePage clickTopCategoryCabinetDrawerHardwareLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, topCategoryCabinetDrawerHardwareLinkText);
			topCategoryCabinetDrawerHardwareLinkText.click();
			WaitTool.waitFor(driver,true) ;
			return new SubCategoryHardwarePage(driver);
		}
	// Method to Click on Bypass & Bi-Fold Door Hardware in Top Categories
	public SubCategoryHardwarePage clickTopCategoryBypassBiFoldDoorHardwareLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, topCategoryBypassBiFoldDoorHardwareLinkText);
			topCategoryBypassBiFoldDoorHardwareLinkText.click();
			WaitTool.waitFor(driver,true) ;
			return new SubCategoryHardwarePage(driver);
		}
	// Method to Click on Connecting & Fastening Hardware in Top Categories
	public SubCategoryHardwarePage clickTopCategoryConnectingFasteningHardwareLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, topCategoryConnectingFasteningHardwareLinkText);
			topCategoryConnectingFasteningHardwareLinkText.click();
			WaitTool.waitFor(driver,true) ;
			return new SubCategoryHardwarePage(driver);
		}
	// Method to Click on Fireplace in Top Categories
	public SubCategoryHardwarePage clickTopCategoryFireplaceLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, topCategoryFireplaceLinkText);
			topCategoryFireplaceLinkText.click();
			WaitTool.waitFor(driver,true) ;
			return new SubCategoryHardwarePage(driver);
		}
	// Method to Click on Bath Accessories & Hardware in Top Categories
	public SubCategoryHardwarePage clickTopCategoryBathAccessoriesHardwareLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, topCategoryBathAccessoriesHardwareLinkText);
			topCategoryBathAccessoriesHardwareLinkText.click();
			WaitTool.waitFor(driver,true) ;
			return new SubCategoryHardwarePage(driver);
		}
	// Method to Click on Garage Door Hardware in Top Categories
	public SubCategoryHardwarePage clickTopCategoryGarageDoorHardwareLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, topCategoryGarageDoorHardwareLinkText);
			topCategoryGarageDoorHardwareLinkText.click();
			WaitTool.waitFor(driver,true) ;
			return new SubCategoryHardwarePage(driver);
		}
	// Method to Click on Gate Hardware in Top Categories
	public SubCategoryHardwarePage clickTopCategoryGateHardwareLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, topCategoryGateHardwareLinkText);
			topCategoryGateHardwareLinkText.click();
			WaitTool.waitFor(driver,true) ;
			return new SubCategoryHardwarePage(driver);
		}
	// Method to Click on Glass Door Hardware in Top Categories
	public SubCategoryHardwarePage clickTopCategoryGlassDoorHardwareLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, topCategoryGlassDoorHardwareLinkText);
			topCategoryGlassDoorHardwareLinkText.click();
			WaitTool.waitFor(driver,true) ;
			return new SubCategoryHardwarePage(driver);
		}
	// Method to Click on Keys & Accessories in Top Categories
	public SubCategoryHardwarePage clickTopCategoryKeysAccessoriesLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, topCategoryKeysAccessoriesLinkText);
			topCategoryKeysAccessoriesLinkText.click();
			WaitTool.waitFor(driver,true) ;
			return new SubCategoryHardwarePage(driver);
		}
	// Method to Click on Mailboxes & Accessories in Top Categories
	public SubCategoryHardwarePage clickTopCategoryMailboxesAccessoriesLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, topCategoryMailboxesAccessoriesLinkText);
			topCategoryMailboxesAccessoriesLinkText.click();
			WaitTool.waitFor(driver,true) ;
			return new SubCategoryHardwarePage(driver);
		}
	// Method to Click on Padlocks & Key Cables in Top Categories
	public SubCategoryHardwarePage clickTopCategoryPadlocksKeyCablesLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, topCategoryPadlocksKeyCablesLinkText);
			topCategoryPadlocksKeyCablesLinkText.click();
			WaitTool.waitFor(driver,true) ;
			return new SubCategoryHardwarePage(driver);
		}
	// Method to Click on Screen Door Hardware in Top Categories
	public SubCategoryHardwarePage clickTopCategoryScreenDoorHardwareLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, topCategoryScreenDoorHardwareLinkText);
			topCategoryScreenDoorHardwareLinkText.click();
			WaitTool.waitFor(driver,true) ;
			return new SubCategoryHardwarePage(driver);
		}
	// Method to Click on Screening & Accessories in Top Categories
	public SubCategoryHardwarePage clickTopCategoryScreeningAccessoriesLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, topCategoryScreeningAccessoriesLinkText);
			topCategoryScreeningAccessoriesLinkText.click();
			WaitTool.waitFor(driver,true) ;
			return new SubCategoryHardwarePage(driver);
		}
	// Method to Click on Window Hardware in Top Categories
	public SubCategoryHardwarePage clickTopCategoryWindowHardwareLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, topCategoryWindowHardwareLinkText);
			topCategoryWindowHardwareLinkText.click();
			WaitTool.waitFor(driver,true) ;
			return new SubCategoryHardwarePage(driver);
		}
	// Method to Click on Bungees, Tie-Downs & Straps in Top Categories
	public SubCategoryHardwarePage clickTopCategoryBungeesTieDownsStrapsLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, topCategoryBungeesTieDownsStrapsLinkText);
			topCategoryBungeesTieDownsStrapsLinkText.click();
			WaitTool.waitFor(driver,true) ;
			return new SubCategoryHardwarePage(driver);
		}
	// Method to Click on Fasteners in Top Categories
	public SubCategoryHardwarePage clickTopCategoryFastenersLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, topCategoryFastenersLinkText);
			topCategoryFastenersLinkText.click();
			WaitTool.waitFor(driver,true) ;
			return new SubCategoryHardwarePage(driver);
		}
	// Method to Click on Chain & Cable in Top Categories
	public SubCategoryHardwarePage clickTopCategoryChainCableLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, topCategoryChainCableLinkText);
			topCategoryChainCableLinkText.click();
			WaitTool.waitFor(driver,true) ;
			return new SubCategoryHardwarePage(driver);
		}
	// Method to Click on Commercial Exit/Entry in Top Categories
	public SubCategoryHardwarePage clickTopCategoryCommercialExitEntryLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, topCategoryCommercialExitEntryLinkText);
			topCategoryCommercialExitEntryLinkText.click();
			WaitTool.waitFor(driver,true) ;
			return new SubCategoryHardwarePage(driver);
		}
	// Method to Click on FOB & Key Reader Systems in Top Categories
	public SubCategoryHardwarePage clickTopCategoryFOBKeyReaderSystemsLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, topCategoryFOBKeyReaderSystemsLinkText);
			topCategoryFOBKeyReaderSystemsLinkText.click();
			WaitTool.waitFor(driver,true) ;
			return new SubCategoryHardwarePage(driver);
		}
	// Method to Click on Door Hinges And Closers in Top Categories
	public SubCategoryHardwarePage clickTopCategoryDoorHingesAndClosersLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, topCategoryDoorHingesAndClosersLinkText);
			topCategoryDoorHingesAndClosersLinkText.click();
			WaitTool.waitFor(driver,true) ;
			return new SubCategoryHardwarePage(driver);
		}
	// Method to Click on Door Security in Top Categories
	public SubCategoryHardwarePage clickTopCategoryDoorSecurityLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, topCategoryDoorSecurityLinkText);
			topCategoryDoorSecurityLinkText.click();
			WaitTool.waitFor(driver,true) ;
			return new SubCategoryHardwarePage(driver);
		}
	// Method to Click on Locks & Accessories in Top Categories
	public SubCategoryHardwarePage clickTopCategoryLocksAccessoriesLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, topCategoryLocksAccessoriesLinkText);
			topCategoryLocksAccessoriesLinkText.click();
			WaitTool.waitFor(driver,true) ;
			return new SubCategoryHardwarePage(driver);
		}
	
	// Method to Click on Safes in Top Categories
	public SubCategoryHardwarePage clickTopCategorySafesLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, topCategorySafesLinkText);
			topCategorySafesLinkText.click();
			WaitTool.waitFor(driver,true) ;
			return new SubCategoryHardwarePage(driver);
		}
	// Method to Click on home in Top Categories	
	public SubCategoryHardwarePage clickCategoryHomeLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, categoryHomeLinkText);
			categoryHomeLinkText.click();
			WaitTool.waitFor(driver,true) ;
			return new SubCategoryHardwarePage(driver);
		}

	
}

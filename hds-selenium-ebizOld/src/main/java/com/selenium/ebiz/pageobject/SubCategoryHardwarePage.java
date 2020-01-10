package com.selenium.ebiz.pageobject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.selenium.ebiz.baseclass.BaseClass;
import com.selenium.ebiz.tools.WaitTool;

public class SubCategoryHardwarePage extends BaseClass{

	public SubCategoryHardwarePage(WebDriver driver) 	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		//WebDriverWait wait = new WebDriverWait(driver, 25);

	}

	// sub Categories Sliding Windows
	@FindBy(linkText = "Sliding Windows")
	WebElement subCategorySlidingWindowsLinkText;


	// sub Categories Swinging Windows
	@FindBy(linkText = "Swinging Windows")
	WebElement subCategorySwingingWindowsLinkText;

	// sub Categories Fasteners
	@FindBy(linkText = "Fasteners")
	WebElement subCategoryFastenersLinkText;

	// sub Categories ShowerRodsAccessories
	@FindBy(linkText = "Shower Rods & Accessories")
	WebElement subCategoryShowerRodsAccessoriesLinkText;

	// sub Categories Tub & Shower Seats
	@FindBy(linkText = "Tub & Shower Seats")
	WebElement subCategoryTubShowerSeatsLinkText;

	// sub CategoriesDoor Openers
	@FindBy(linkText = "Door Openers")
	WebElement subCategoryDoorOpenersLinkText;

	// sub Categories Locks
	@FindBy(linkText = "Locks")
	WebElement subCategoryLocksLinkText;

	// sub Categories Handles
	@FindBy(linkText = "Handles")
	WebElement subCategoryHandlesLinkText;

	// sub Categories Closers
	@FindBy(linkText = "Closers")
	WebElement subCategoryClosersLinkText;

	// sub Categories Splash Guards
	@FindBy(linkText = "Splash Guards")
	WebElement subCategorySplashGuardsLinkText;

	// sub Categories Wall Corner Protectors
	@FindBy(linkText = "Wall Corner Protectors")
	WebElement subCategoryWallCornerProtectorsLinkText;

	// sub Categories Ramps
	@FindBy(linkText = "Ramps")
	WebElement subCategoryRampsLinkText;

	// sub Categories Thresholds
	@FindBy(linkText = "Thresholds")
	WebElement subCategoryThresholdsLinkText;

	// sub Categories Catches, Anchors & Screws
	@FindBy(linkText = "Catches, Anchors & Screws")
	WebElement subCategoryCatchesAnchorsScrewsLinkText;

	// sub Categories Door Bumpers
	@FindBy(linkText = "Door Bumpers")
	WebElement subCategoryDoorBumpersLinkText;

	// sub Categories Caps & Covers
	@FindBy(linkText = "Caps & Covers")
	WebElement subCategoryCapsCoversLinkText;

	// sub Categories ClosetHooks
	@FindBy(linkText = "Closet Hooks")
	WebElement subCategoryClosetHooksLinkText;

	// sub Categories Springs
	@FindBy(linkText = "Springs")
	WebElement subCategorySpringsLinkText;

	// sub Categories Kits
	@FindBy(linkText = "Kits")
	WebElement subCategoryKitsLinkText;

	// sub Categories Locks & Security Hardware
	@FindBy(linkText = "Locks & Security Hardware")
	WebElement subCategoryLockSecurityHardwareLinkText;

	// sub Categories Rollers
	@FindBy(linkText = "Rollers")
	WebElement subCategoryRollersLinkText;

	// sub Categories Key Kits & Pins
	@FindBy(linkText = "Key Kits & Pins")
	WebElement subCategoryKeyKitsPinsLinkText;

	// sub Categories Key Blanks
	@FindBy(linkText = "Key Blanks")
	WebElement subCategoryKeyBlanksLinkText;

	// sub Categories Collection Boxes
	@FindBy(linkText = "Collection Boxes")
	WebElement subCategoryCollectionBoxesLinkText;

	// sub Categories Mailbox Locks
	@FindBy(linkText = "Mailbox Locks")
	WebElement subCategoryMailboxLocksLinkText;

	// sub Categories Padlocks
	@FindBy(linkText = "Padlocks")
	WebElement subCategoryPadlocksLinkText;

	// sub Categories Key Cables
	@FindBy(linkText = "Key Cables")
	WebElement subCategoryKeyCablesLinkText;

	// sub Categories Grilles
	@FindBy(linkText = "Grilles")
	WebElement subCategoryGrillesLinkText;

	// sub Categories Closers1
	@FindBy(linkText = "Closers")
	WebElement subCategoryClosers1LinkText;

	// sub Categories Screen Frame
	@FindBy(linkText = "Screen Frame")
	WebElement subCategoryScreenFrameLinkText;

	// sub Categories Screen Kit
	@FindBy(linkText = "Screen Kit")
	WebElement subCategoryScreenKitLinkText;

	// sub Categories Bolts
	@FindBy(linkText = "Bolts")
	WebElement subCategoryBoltsLinkText;

	// sub Categories Brackets
	@FindBy(linkText = "Brackets")
	WebElement subCategoryBracketsLinkText;

	// sub Categories Ferrules
	@FindBy(linkText = "Ferrules")
	WebElement subCategoryFerrulesLinkText;

	// sub Categories Cable
	@FindBy(linkText = "Cable")
	WebElement subCategoryCableLinkText;

	// sub Categories Keypads
	@FindBy(linkText = "Keypads")
	WebElement subCategoryKeypadsLinkText;

	// sub Categories Door Coordinator
	@FindBy(linkText = "Door Coordinator")
	WebElement subCategoryDoorCoordinatorLinkText;

	// sub Categories Key FOBs
	@FindBy(linkText = "Key FOBs")
	WebElement subCategoryKeyFOBsLinkText;

	// sub Categories Accessorie
	@FindBy(linkText = "Accessories")
	WebElement subCategoryAccessoriesLinkText;

	// sub Categories Door Hinges
	@FindBy(linkText = "Door Hinges")
	WebElement subCategoryDoorHingesLinkText;

	// sub Categories Door Closers
	@FindBy(linkText = "Door Closers")
	WebElement subCategoryDoorClosersLinkText;


	@FindBy(linkText = "Chain Locks")
	WebElement subCategoryChainLocksLinkText;

	// sub Categories Slide Locks
	@FindBy(linkText = "Slide Locks")
	WebElement subCategorySlideLocksLinkText;

	// sub Categories Latches
	@FindBy(linkText = "Latches")
	WebElement subCategoryLatchesLinkText;

	// sub Categories Strike Plates
	@FindBy(linkText = "Strike Plates")
	WebElement subCategoryStrikePlatesLinkText;

	// sub Categories Hotel Safes
	@FindBy(linkText = "Hotel Safes")
	WebElement subCategoryHotelSafesLinkText;

	// sub Categories Fire Safes
	@FindBy(linkText = "Fire Safes")
	WebElement subCategoryFireSafesLinkText;

	public void clickSubCategoryHotelSafesLinkText() throws InterruptedException {

		WaitTool.waitForElement(driver,	subCategoryHotelSafesLinkText);
		subCategoryHotelSafesLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(WaitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}

	public void clickSubCategoryFireSafesLinkText() throws InterruptedException {

		WaitTool.waitForElement(driver,	subCategoryFireSafesLinkText);
		subCategoryFireSafesLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(WaitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}



	public void clickSubCategoryChainLocksLinkText() throws InterruptedException {

		WaitTool.waitForElement(driver,	subCategoryChainLocksLinkText);
		subCategoryChainLocksLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(WaitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}

	public void clickSubCategoryLatchesLinkText() throws InterruptedException {

		WaitTool.waitForElement(driver,	subCategoryLatchesLinkText);
		subCategoryLatchesLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(WaitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}

	public void clickSubCategoryStrikePlatesLinkText() throws InterruptedException {

		WaitTool.waitForElement(driver,	subCategoryStrikePlatesLinkText);
		subCategoryStrikePlatesLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(WaitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}

	public void clickSubCategoryDoorHingesLinkText() throws InterruptedException {

		WaitTool.waitForElement(driver,	subCategoryDoorHingesLinkText);
		subCategoryDoorHingesLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(WaitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}

	public void clickSubCategoryDoorClosersLinkText() throws InterruptedException {

		WaitTool.waitForElement(driver,	subCategoryDoorClosersLinkText);
		subCategoryDoorClosersLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(WaitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}

	public void clickSubCategoryKeyFOBsLinkText() throws InterruptedException {

		WaitTool.waitForElement(driver,	subCategoryKeyFOBsLinkText);
		subCategoryKeyFOBsLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(WaitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}

	public void clickSubCategoryAccessoriesLinkText() throws InterruptedException {

		WaitTool.waitForElement(driver,	subCategoryAccessoriesLinkText);
		subCategoryAccessoriesLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(WaitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}

	public void clickSubCategoryKeypadsLinkText() throws InterruptedException {

		WaitTool.waitForElement(driver,	subCategoryKeypadsLinkText);
		subCategoryKeypadsLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(WaitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}

	public void clickSubCategoryDoorCoordinatorLinkText() throws InterruptedException {

		WaitTool.waitForElement(driver,	subCategoryDoorCoordinatorLinkText);
		subCategoryDoorCoordinatorLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(WaitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}

	public void clickSubCategoryFerrulesLinkText() throws InterruptedException {

		WaitTool.waitForElement(driver,	subCategoryFerrulesLinkText);
		subCategoryFerrulesLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(WaitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}

	public void clickSubCategoryCableLinkText() throws InterruptedException {

		WaitTool.waitForElement(driver,	subCategoryCableLinkText);
		subCategoryCableLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(WaitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}

	public void clickSubCategoryBoltsLinkText() throws InterruptedException {

		WaitTool.waitForElement(driver,	subCategoryBoltsLinkText);
		subCategoryBoltsLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(WaitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}

	public void clickSubCategoryBracketsLinkText() throws InterruptedException {

		WaitTool.waitForElement(driver,	subCategoryBracketsLinkText);
		subCategoryBracketsLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(WaitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}

	public void clickSubCategoryScreenFrameLinkText() throws InterruptedException {

		WaitTool.waitForElement(driver,	subCategoryScreenFrameLinkText);
		subCategoryScreenFrameLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(WaitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}

	public void clickSubCategoryScreenKitLinkText() throws InterruptedException {

		WaitTool.waitForElement(driver,	subCategoryScreenKitLinkText);
		subCategoryScreenKitLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(WaitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}

	public void clickSubCategoryGrillesLinkText() throws InterruptedException {

		WaitTool.waitForElement(driver,	subCategoryGrillesLinkText);
		subCategoryGrillesLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(WaitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}

	public void clickSubCategoryClosers1LinkText() throws InterruptedException {

		WaitTool.waitForElement(driver,	subCategoryClosers1LinkText);
		subCategoryClosers1LinkText.click();

		driver.manage().timeouts().pageLoadTimeout(WaitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}

	public void clickSubCategoryPadlocksLinkText() throws InterruptedException {

		WaitTool.waitForElement(driver,	subCategoryPadlocksLinkText);
		subCategoryPadlocksLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(WaitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}

	public void clickSubCategoryKeyCablesLinkText() throws InterruptedException {

		WaitTool.waitForElement(driver,	subCategoryKeyCablesLinkText);
		subCategoryKeyCablesLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(WaitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}

	public void clickSubCategoryCollectionBoxesLinkText() throws InterruptedException {

		WaitTool.waitForElement(driver,	subCategoryCollectionBoxesLinkText);
		subCategoryCollectionBoxesLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(WaitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}

	public void clickSubCategoryMailboxLocksLinkText() throws InterruptedException {

		WaitTool.waitForElement(driver,	subCategoryMailboxLocksLinkText);
		subCategoryMailboxLocksLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(WaitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}

	public void clickSubCategoryKeyKitsPinsLinkText() throws InterruptedException {

		WaitTool.waitForElement(driver,	subCategoryKeyKitsPinsLinkText);
		subCategoryKeyKitsPinsLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(WaitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}

	public void clickSubCategoryKeyBlanksLinkText() throws InterruptedException {

		WaitTool.waitForElement(driver,	subCategoryKeyBlanksLinkText);
		subCategoryKeyBlanksLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(WaitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}

	public void clickSubCategoryRollersLinkText() throws InterruptedException {

		WaitTool.waitForElement(driver,	subCategoryRollersLinkText);
		subCategoryRollersLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(WaitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}

	public void clickSubCategoryLockSecurityHardwareLinkText() throws InterruptedException {

		WaitTool.waitForElement(driver,	subCategoryLockSecurityHardwareLinkText);
		subCategoryLockSecurityHardwareLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(WaitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}


	public void clickSubCategoryKitsLinkText() throws InterruptedException {

		WaitTool.waitForElement(driver,	subCategoryKitsLinkText);
		subCategoryKitsLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(WaitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}

	public void clickSubCategorySpringsLinkText() throws InterruptedException {

		WaitTool.waitForElement(driver,	subCategorySpringsLinkText);
		subCategorySpringsLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(WaitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}

	public void clickSubCategoryClosetHooksLinkText() throws InterruptedException {

		WaitTool.waitForElement(driver,	subCategoryClosetHooksLinkText);
		subCategoryClosetHooksLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(WaitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}

	public void clickSubCategoryCapsCoversLinkText() throws InterruptedException {

		WaitTool.waitForElement(driver,	subCategoryCapsCoversLinkText);
		subCategoryCapsCoversLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(WaitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}


	public void clickSubCategoryDoorBumpersLinkText() throws InterruptedException {

		WaitTool.waitForElement(driver,	subCategoryDoorBumpersLinkText);
		subCategoryDoorBumpersLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(WaitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}


	public void clickSubCategoryCatchesAnchorsScrewsLinkText() throws InterruptedException {

		WaitTool.waitForElement(driver,	subCategoryCatchesAnchorsScrewsLinkText);
		subCategoryCatchesAnchorsScrewsLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(WaitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}

	public void clickSubCategoryRampsLinkText() throws InterruptedException {

		WaitTool.waitForElement(driver,	subCategoryRampsLinkText);
		subCategoryRampsLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(WaitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}

	public void clickSubCategoryWallCornerProtectorsLinkText() throws InterruptedException {

		WaitTool.waitForElement(driver,	subCategoryWallCornerProtectorsLinkText);
		subCategoryWallCornerProtectorsLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(WaitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}



	public void clickSubCategorySplashGuardsLinkText() throws InterruptedException {

		WaitTool.waitForElement(driver,	subCategorySplashGuardsLinkText);
		subCategorySplashGuardsLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(WaitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}

	public void clickSubCategoryClosersLinkText() throws InterruptedException {

		WaitTool.waitForElement(driver,	subCategoryClosersLinkText);
		subCategoryClosersLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(WaitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}


	public void clickSubCategoryHandlesLinkText() throws InterruptedException {

		WaitTool.waitForElement(driver,	subCategoryHandlesLinkText);
		subCategoryHandlesLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(WaitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}



	public void clickSubCategoryLocksLinkText() throws InterruptedException {

		WaitTool.waitForElement(driver,	subCategoryLocksLinkText);
		subCategoryLocksLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(WaitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}


	public void clickSubCategoryDoorOpenersLinkText() throws InterruptedException {

		WaitTool.waitForElement(driver,	subCategoryDoorOpenersLinkText);
		subCategoryDoorOpenersLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(WaitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}


	public void clickSubCategoryTubShowerSeatsLinkText() throws InterruptedException {

		WaitTool.waitForElement(driver,	subCategoryTubShowerSeatsLinkText);
		subCategoryTubShowerSeatsLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(WaitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}


	public void clickSubCategoryShowerRodsAccessoriesLinkText() throws InterruptedException {

		WaitTool.waitForElement(driver,	subCategoryShowerRodsAccessoriesLinkText);
		subCategoryShowerRodsAccessoriesLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(WaitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}

	public void clickSubCategorySlidingWindowsLinkText() throws InterruptedException {

		WaitTool.waitForElement(driver,	subCategorySlidingWindowsLinkText);
		subCategorySlidingWindowsLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(WaitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}

	public void clickSubCategorySwingingWindowsLinkText() throws InterruptedException {

		WaitTool.waitForElement(driver,	subCategorySwingingWindowsLinkText);
		subCategorySwingingWindowsLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(WaitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}

	public void clickSubCategoryFastenersLinkText() throws InterruptedException {

		WaitTool.waitForElement(driver,	subCategoryFastenersLinkText);
		subCategoryFastenersLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(WaitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}


}






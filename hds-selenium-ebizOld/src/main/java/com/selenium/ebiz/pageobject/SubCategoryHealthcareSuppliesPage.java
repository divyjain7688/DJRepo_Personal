package com.selenium.ebiz.pageobject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.selenium.ebiz.baseclass.BaseClass;
import com.selenium.ebiz.tools.WaitTool;

public class SubCategoryHealthcareSuppliesPage extends BaseClass {

	public SubCategoryHealthcareSuppliesPage(WebDriver driver) 	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		//WebDriverWait wait = new WebDriverWait(driver, 25);

	}

	// sub Categories Toilet Safety
	@FindBy(linkText = "Toilet Safety")
	WebElement subCategoryToiletSafetyLinkText;

	// sub Categories Bath Safety
	@FindBy(linkText = "Bath Safety")
	WebElement subCategoryBathSafetyLinkText;

	// sub Categories Wall Desks
	@FindBy(linkText = "Wall Desks")
	WebElement subCategoryWallDesksLinkText;

	// sub Categories Work Stations
	@FindBy(linkText = "Work Stations")
	WebElement subCategoryWorkStationsLinkText;

	// sub Categories Isolation Stations
	@FindBy(linkText = "Isolation Stations")
	WebElement subCategoryIsolationStationsLinkText;

	// sub Categories Biohazard Containment
	@FindBy(linkText = "Biohazard Containment")
	WebElement subCategoryBiohazardContainmentLinkText;

	// sub Categories Fall Protection
	@FindBy(linkText = "Fall Protection")
	WebElement subCategoryFallProtectionLinkText;

	// sub Categories Fall Prevention
	@FindBy(linkText = "Fall Prevention")
	WebElement subCategoryFallPreventionLinkText;

	// sub Categories Furniture
	@FindBy(linkText = "Furniture")
	WebElement subCategoryFurnitureLinkText;

	// sub Categories Memory Boxes
	@FindBy(linkText = "Memory Boxes")
	WebElement subCategoryMemoryBoxesLinkText;

	// sub Categories Briefs
	@FindBy(linkText = "Briefs")
	WebElement subCategoryBriefsLinkText;

	// sub Categories Underpads
	@FindBy(linkText = "Underpads")
	WebElement subCategoryUnderpadsLinkText;

	// sub Categories Staff
	@FindBy(linkText = "Staff")
	WebElement subCategoryStaffLinkText;

	// sub Categories Patient
	@FindBy(linkText = "Patient")
	WebElement subCategoryPatientLinkText;

	// sub Categories Emergency Stations
	@FindBy(linkText = "Emergency Stations")
	WebElement subCategoryEmergencyStationsLinkText;

	// sub Categories Corridor Light Fixtures
	@FindBy(linkText = "Corridor Light Fixtures")
	WebElement subCategoryCorridorLightFixturesLinkText;

	// sub Categories Ice Cart & Accessories
	@FindBy(linkText = "Ice Cart & Accessories")
	WebElement subCategoryIceCartLinkText;

	// sub Categories Disposable Gloves
	@FindBy(linkText = "Disposable Gloves")
	WebElement subCategoryDisposableGlovesLinkText;

	// sub Categories Pulleys
	@FindBy(linkText = "Pulleys")
	WebElement subCategoryPulleysLinkText;

	// sub Categories Exercise Bars
	@FindBy(linkText = "Exercise Bars")
	WebElement subCategoryExerciseBarsLinkText;

	// sub Categories Nebulizers
	@FindBy(linkText = "Nebulizers")
	WebElement subCategoryNebulizersLinkText;

	// sub Categories Concentrators
	@FindBy(linkText = "Concentrators")
	WebElement subCategoryConcentratorsLinkText;

	// sub Categories Locking Cabinets
	@FindBy(linkText = "Locking Cabinets")
	WebElement subCategoryLockingCabinetsLinkText;

	// sub Categories Box Holders
	@FindBy(linkText = "Box Holders")
	WebElement subCategoryBoxHoldersLinkText;

	// sub Categories Wheelchair Ramps
	@FindBy(linkText = "Wheelchair Ramps")
	WebElement subCategoryWheelchairRampsLinkText;

	// sub Categories Wheelchair Repair
	@FindBy(linkText = "Wheelchair Repair")
	WebElement subCategoryWheelchairRepairLinkText;

	public void clickSubCategoryWheelchairRampsLinkText() throws InterruptedException {

		WaitTool.waitForElement(driver,	subCategoryWheelchairRampsLinkText);
		subCategoryWheelchairRampsLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(WaitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}

	public void clickSubCategoryWheelchairRepairLinkText() throws InterruptedException {

		WaitTool.waitForElement(driver,	subCategoryWheelchairRepairLinkText);
		subCategoryWheelchairRepairLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(WaitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}

	public void clickSubCategoryBoxHolderLinkText() throws InterruptedException {

		WaitTool.waitForElement(driver,	subCategoryBoxHoldersLinkText);
		subCategoryBoxHoldersLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(WaitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}


	public void clickSubCategoryNebulizersLinkText() throws InterruptedException {

		WaitTool.waitForElement(driver,	subCategoryNebulizersLinkText);
		subCategoryNebulizersLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(WaitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}

	public void clickSubCategoryConcentratorsLinkText() throws InterruptedException {

		WaitTool.waitForElement(driver,	subCategoryConcentratorsLinkText);
		subCategoryConcentratorsLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(WaitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}






	public void clickSubCategoryPulleysLinkText() throws InterruptedException {

		WaitTool.waitForElement(driver,	subCategoryPulleysLinkText);
		subCategoryPulleysLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(WaitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}

	public void clickSubCategoryExerciseBarsLinkText() throws InterruptedException {

		WaitTool.waitForElement(driver,	subCategoryExerciseBarsLinkText);
		subCategoryExerciseBarsLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(WaitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}

	public void clickSubCategoryIceCartLinkText() throws InterruptedException {

		WaitTool.waitForElement(driver,	subCategoryIceCartLinkText);
		subCategoryIceCartLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(WaitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}

	//Method to click on DisposableGloves in sub categories.
	public void clickSubCategoryDisposableGlovesLinkText() throws InterruptedException {

		WaitTool.waitForElement(driver,	subCategoryDisposableGlovesLinkText);
		subCategoryDisposableGlovesLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(WaitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}

	public void clickSubCategoryEmergencyStationsLinkText() throws InterruptedException {

		WaitTool.waitForElement(driver,	subCategoryEmergencyStationsLinkText);
		subCategoryEmergencyStationsLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(WaitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}

	public void clickSubCategoryCorridorLightFixturesLinkText() throws InterruptedException {

		WaitTool.waitForElement(driver,	subCategoryCorridorLightFixturesLinkText);
		subCategoryCorridorLightFixturesLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(WaitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}




	public void clickSubCategoryBriefsLinkText() throws InterruptedException {

		WaitTool.waitForElement(driver,	subCategoryBriefsLinkText);
		subCategoryBriefsLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(WaitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}

	public void clickSubCategoryStaffLinkText() throws InterruptedException {

		WaitTool.waitForElement(driver,	subCategoryStaffLinkText);
		subCategoryStaffLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(WaitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}

	public void clickSubCategoryPatientLinkText() throws InterruptedException {

		WaitTool.waitForElement(driver,	subCategoryPatientLinkText);
		subCategoryPatientLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(WaitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}



	public void clickSubCategoryFurnitureLinkText() throws InterruptedException {

		WaitTool.waitForElement(driver,	subCategoryFurnitureLinkText);
		subCategoryFurnitureLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(WaitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}

	public void clickSubCategoryMemoryBoxesLinkText() throws InterruptedException {

		WaitTool.waitForElement(driver,	subCategoryMemoryBoxesLinkText);
		subCategoryMemoryBoxesLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(WaitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}

	public void clickSubCategoryToiletSafetyLinkText() throws InterruptedException {

		WaitTool.waitForElement(driver,	subCategoryToiletSafetyLinkText);
		subCategoryToiletSafetyLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(WaitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}

	public void clickSubCategoryBathSafetyLinkText() throws InterruptedException {

		WaitTool.waitForElement(driver,	subCategoryBathSafetyLinkText);
		subCategoryBathSafetyLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(WaitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}

	public void clickSubCategoryWallDesksLinkText() throws InterruptedException {

		WaitTool.waitForElement(driver,	subCategoryWallDesksLinkText);
		subCategoryWallDesksLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(WaitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}

	public void clickSubCategoryWorkStationsLinkText() throws InterruptedException {

		WaitTool.waitForElement(driver,	subCategoryWorkStationsLinkText);
		subCategoryWorkStationsLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(WaitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}

	public void clickSubCategoryIsolationStationsLinkText() throws InterruptedException {

		WaitTool.waitForElement(driver,	subCategoryIsolationStationsLinkText);
		subCategoryIsolationStationsLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(WaitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}

	public void clickSubCategoryBiohazardContainmentLinkText() throws InterruptedException {

		WaitTool.waitForElement(driver,	subCategoryBiohazardContainmentLinkText);
		subCategoryBiohazardContainmentLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(WaitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}

	public void clickSubCategoryFallProtectionLinkText() throws InterruptedException {

		WaitTool.waitForElement(driver,	subCategoryFallProtectionLinkText);
		subCategoryFallProtectionLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(WaitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}

	public void clickSubCategoryFallPreventionLinkText() throws InterruptedException {

		WaitTool.waitForElement(driver,	subCategoryFallPreventionLinkText);
		subCategoryFallPreventionLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(WaitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}














}

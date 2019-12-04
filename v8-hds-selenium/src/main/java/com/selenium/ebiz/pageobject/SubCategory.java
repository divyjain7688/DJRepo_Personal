package com.selenium.ebiz.pageobject;

import com.selenium.ebiz.tools.WaitTool;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SubCategory  {
	private  WebDriver driver; private WaitTool   waitTool;

	public SubCategory(WebDriver driver) 	{
		this.driver = driver;  this.waitTool = new WaitTool();
		PageFactory.initElements(driver, this);
		//WebDriverWait wait = new WebDriverWait(driver, 25);
		//wait.until(ExpectedConditions.visibilityOf(()));
	}

	@FindBy(xpath = "//div[@class='modal__inner']")
	public WebElement customizeItemModal;	

	@FindBy(xpath = "//a[@class='modal__close jq-close-modal']")
	WebElement closeCustomizeItemModal;	

	@FindBy(xpath = "//div[starts-with(@id,'container_')]/div[6]/div[2]/div[4]/section[1]/div[6]/div[2]/div/a")
	public WebElement CustomizeThisItemLinkText;			

	@FindAll(@FindBy(xpath="//div[@class='cart-actions__availability-and-customize']"))
	List<WebElement> customiseItemLinkText;

	@FindAll(@FindBy(xpath="//div[starts-with(@id,'8710198671111101021051035')]"))
	List<WebElement> customiseItemCheckBox;

	@FindBy(xpath = "//div[starts-with(@id,'section_ads_f10518_ntk_cs_10_-3004_')]/a")
	WebElement subCategoryWebConfigLink;

	@FindBy(linkText = "Kitchen Countertops & Accessories")
	WebElement subCategoryKitchenCountertopsAccessoriesLinkText;

	@FindBy(linkText = "Bath Vanity Tops")
	WebElement subCategoryBathVanityTopsLinkText;

	@FindBy(linkText = "Cabinet Molding")
	WebElement subCategoryCabinetMoldingLinkText;

	@FindBy(linkText = "Cabinet Shelves")
	WebElement subCategoryCabinetShelvesLinkText;

	@FindBy(linkText = "Dishwasher End Panel")
	WebElement subCategoryDishwasherEndPanelLinkText;

	@FindBy(linkText = "Fillers, Toe Kicks, & Skins")
	WebElement subCategoryFillersToeKicksSkinsLinkText;

	@FindBy(linkText = "Pantries")
	WebElement subCategoryPantriesLinkText;

	@FindBy(linkText = "Wall Cabinets")
	WebElement subCategoryWallCabinetsLinkText;

	@FindBy(linkText = "Base Cabinets")
	WebElement subCategoryBaseCabinetsLinkText;

	@FindBy(linkText = "Medicine Cabinets & Accessories")
	WebElement subCategoryMedicineCabinetsAccessoriesLinkText;

	@FindBy(linkText = "Cosmetic Boxes & Accessories")
	WebElement subCategoryCosmeticBoxesAccessoriesLinkText;

	@FindBy(linkText = "Vanity Cabinets")
	WebElement subCategoryVanityCabinetsLinkText;

	@FindBy(linkText = "Vanity Combos")
	WebElement subCategoryVanityCombosLinkText;

	@FindBy(linkText = "Wheelchair Accessible")
	WebElement subCategoryWheelchairAccessibleLinkText;

	@FindBy(linkText = "Over the John")
	WebElement subCategoryOvertheJohnLinkText;

	@FindBy(linkText = "Interior")
	WebElement subCategoryInteriorLinkText;

	@FindBy(linkText = "Exterior")
	WebElement subCategoryExteriorLinkText;

	@FindBy(linkText = "Casing")
	WebElement subCategoryCasingLinkText;

	@FindBy(linkText = "Closet Rods")
	WebElement subCategoryClosetRodsLinkText;

	@FindBy(linkText = "Floor Boxes")
	WebElement subCategoryFloorBoxesLinkText;

	@FindBy(linkText = "Electrical Boxes")
	WebElement subCategoryElectricalBoxesLinkText;

	@FindBy(linkText = "Fuse Pullers")
	WebElement subCategoryFusePullersLinkText;

	@FindBy(linkText = "Insulated & Voltage Sensing Hand Tools")
	WebElement subCategoryInsulatedVoltageSensingHandToolsLinkText;

	@FindBy(linkText = "Combination Smoke & CO Alarms")
	WebElement subCategoryCombinationSmokeCOAlarmsLinkText;

	@FindBy(linkText = "Fire Alarms & Accessories")
	WebElement subCategoryFireAlarmsAccessoriesLinkText;

	@FindBy(linkText = "Recycling Kits")
	WebElement subCategoryRecyclingKitsLinkText;

	@FindBy(linkText = "AAAA Batteries")
	WebElement subCategoryAAAABatteriesLinkText;

	@FindBy(linkText = "Extension Cords")
	WebElement subCategoryExtensionCordsLinkText;

	@FindBy(linkText = "Power Adapters")
	WebElement subCategoryPowerAdaptersLinkText;

	@FindBy(linkText = "Timers")
	WebElement subCategoryTimersLinkText;

	@FindBy(linkText = "Timer Accessories")
	WebElement subCategoryTimerAccessoriesLinkText;

	@FindBy(linkText = "Receptacle Plates")
	WebElement subCategoryReceptaclePlatesLinkText;

	@FindBy(linkText = "Speciality Plates")
	WebElement subCategorySpecialityPlatesLinkText;

	@FindBy(linkText = "Switches")
	WebElement subCategorySwitchesLinkText;

	@FindBy(linkText = "Wall Outlets")
	WebElement subCategoryWallOutletsLinkText;

	@FindBy(linkText = "Electrical Tape")
	WebElement subCategoryElectricalTapeLinkText;

	@FindBy(linkText = "Electrical Wire")
	WebElement subCategoryElectricalWireLinkText;

	@FindBy(linkText = "Phone Chargers")
	WebElement subCategoryPhoneChargersLinkText;

	@FindBy(linkText = "Power Stations")
	WebElement subCategoryPowerStationsLinkText;

	@FindBy(linkText = "Fuses")
	WebElement subCategoryFusesLinkText;

	@FindBy(linkText = "Load Centers")
	WebElement subCategoryLoadCentersLinkText;

	@FindBy(linkText = "Raceway")
	WebElement subCategoryRacewayLinkText;

	@FindBy(linkText = "Conduit")
	WebElement subCategoryConduitLinkText;

	@FindBy(linkText = "Door Chimes")
	WebElement subCategoryDoorChimesLinkText;

	@FindBy(linkText = "Intercom Systems & Accessories")
	WebElement subCategoryIntercomSystemsAccessoriesLinkText;

	@FindBy(linkText = "Mirrors")
	WebElement subCategoryMirrorsLinkText;

	@FindBy(linkText = "Video Monitoring Accessories")
	WebElement subCategoryVideoMonitoringAccessoriesLinkText;

	@FindBy(linkText = "Ethernet Cables")
	WebElement subCategoryEthernetCablesLinkText;

	@FindBy(linkText = "Telephone Cords")
	WebElement subCategoryTelephoneCordsLinkText;

	@FindBy(linkText = "Two-Way Radios")
	WebElement subCategoryTwoWayRadiosLinkText;

	@FindBy(linkText = "Antennas")
	WebElement subCategoryAntennasLinkText;

	@FindBy(linkText = "Exercise Bars")
	WebElement subCategoryExerciseBarsLinkText;

	@FindBy(linkText = "Hand Exercisers")
	WebElement subCategoryHandExercisersLinkText;

	@FindBy(linkText = "Bikes & Pedal Exercisers")
	WebElement subCategoryBikesPedalExercisersLinkText;

	@FindBy(linkText = "Ellipticals")
	WebElement subCategoryEllipticalsLinkText;

	@FindBy(linkText = "Gait Belts")
	WebElement subCategoryGaitBeltsLinkText;

	@FindBy(linkText = "Mat Platforms")
	WebElement subCategoryMatPlatformsLinkText;

	@FindBy(linkText = "Hand Weights")
	WebElement subCategoryHandWeightsLinkText;

	@FindBy(linkText = "Weight Bars")
	WebElement subCategoryWeightBarsLinkText;

	@FindBy(linkText = "Grout & Repair")
	WebElement subCategoryGroutRepairLinkText;

	@FindBy(linkText = "Tile Adhesive")
	WebElement subCategoryTileAdhesiveLinkText;

	@FindBy(linkText = "Carpet Tiles")
	WebElement subCategoryCarpetTilesLinkText;

	@FindBy(linkText = "Flooring Accessories")
	WebElement subCategoryFlooringAccessoriesLinkText;

	@FindBy(linkText = "Carpet Tools")
	WebElement subCategoryCarpetToolsLinkText;

	@FindBy(linkText = "Grout Tools")
	WebElement subCategoryGroutToolsLinkText;

	@FindBy(linkText = "Ceiling Tiles & Panels")
	WebElement subCategoryCeilingTilesPanelsLinkText;

	@FindBy(linkText = "Suspended Frames")
	WebElement subCategorySuspendedFramesLinkText;

	@FindBy(linkText = "Salt & Pepper Shakers")
	WebElement subCategorySaltPepperShakersLinkText;

	@FindBy(linkText = "Syrup")
	WebElement subCategorySyrupLinkText;

	@FindBy(linkText = "Cutlery Holders")
	WebElement subCategoryCutleryHoldersLinkText;

	@FindBy(linkText = "Napkin Holders")
	WebElement subCategoryNapkinHoldersLinkText;

	@FindBy(linkText = "Flatware")
	WebElement subCategoryFlatwareLinkText;

	@FindBy(linkText = "Food Containers")
	WebElement subCategoryFoodContainersLinkText;

	@FindBy(linkText = "Granola Bars")
	WebElement subCategoryGranolaBarsLinkText;

	@FindBy(linkText = "Condiment Kits")
	WebElement subCategoryCondimentKitsLinkText;

	@FindBy(linkText = "Cups & Lids")
	WebElement subCategoryCupsLidsLinkText;

	@FindBy(linkText = "Decanters & Pitchers")
	WebElement subCategoryDecantersPitchersLinkText;

	@FindBy(linkText = "Can Openers")
	WebElement subCategoryCanOpenersLinkText;

	@FindBy(linkText = "Colanders")
	WebElement subCategoryColandersLinkText;

	@FindBy(linkText = "Mattresses")
	WebElement subCategoryMattressesLinkText;

	@FindBy(linkText = "Rollaway Beds")
	WebElement subCategoryRollawayBedsLinkText;

	@FindBy(linkText = "Desk Chairs")
	WebElement subCategoryDeskChairsLinkText;

	@FindBy(linkText = "Desks")
	WebElement subCategoryDesksLinkText;

	@FindBy(linkText = "Wall Mirrors & Frames")
	WebElement subCategoryWallMirrorsFramesLinkText;

	@FindBy(linkText = "Vanity Mirrors")
	WebElement subCategoryVanityMirrorsLinkText;

	@FindBy(linkText = "Recliners")
	WebElement subCategoryReclinersLinkText;

	@FindBy(linkText = "Ottomans")
	WebElement subCategoryOttomansLinkText;

	@FindBy(linkText = "Catering Tables")
	WebElement subCategoryCateringTablesLinkText;

	@FindBy(linkText = "Cocktail Tables")
	WebElement subCategoryCocktailTablesLinkText;

	@FindBy(linkText = "Risers")
	WebElement subCategoryRisersLinkText;
	
	@FindBy(linkText = "Shades & Roller Shades")
	WebElement subCategoryShadesAndRollerShadesLinkText;

	@FindBy(linkText = "Steps & Guardrails")
	WebElement subCategoryStepsGuardrailsLinkText;
	
	public void clickSubCategoryShadesAndRollerShadesLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, subCategoryShadesAndRollerShadesLinkText);
		subCategoryShadesAndRollerShadesLinkText.click();
		waitTool.waitFor(driver, true);
	}

	public void clickSubCategoryOvertheJohnLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, subCategoryOvertheJohnLinkText);
		subCategoryOvertheJohnLinkText.click();
		waitTool.waitFor(driver, true);
	}

	public void clickSubCategoryWheelchairAccessibleLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, subCategoryWheelchairAccessibleLinkText);
		subCategoryWheelchairAccessibleLinkText.click();
		waitTool.waitFor(driver, true);
	}

	/**
	 *  Method to Click on Vanity Combos in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryVanityCombosLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, subCategoryVanityCombosLinkText);
		subCategoryVanityCombosLinkText.click();
		waitTool.waitFor(driver, true);
	}

	/**
	 *  Method to Click on Vanity Cabinets in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryVanityCabinetsLinkText() throws InterruptedException {

		waitTool.waitForElement(driver, subCategoryVanityCabinetsLinkText);
		subCategoryVanityCabinetsLinkText.click();

		waitTool.waitFor(driver, true);

	}

	/**
	 *  Method to Click on Cosmetic Boxes & Accessories in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryCosmeticBoxesAccessoriesLinkText() throws InterruptedException {

		waitTool.waitForElement(driver, subCategoryCosmeticBoxesAccessoriesLinkText);
		subCategoryCosmeticBoxesAccessoriesLinkText.click();
		waitTool.waitFor(driver, true);
	}

	/**
	 *  Method to Click on Medicine Cabinets & Accessories in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryMedicineCabinetsAccessoriesLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, subCategoryMedicineCabinetsAccessoriesLinkText);
		subCategoryMedicineCabinetsAccessoriesLinkText.click();
		waitTool.waitFor(driver, true);
	}

	/**
	 *  Method to Click on Base Cabinets in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryBaseCabinetsLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, subCategoryBaseCabinetsLinkText);
		subCategoryBaseCabinetsLinkText.click();
		waitTool.waitFor(driver, true);
	}

	/**
	 * Method to Click on Wall Cabinets in Sub Categories	
	 */
	public void clickSubCategoryWallCabinetsLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, subCategoryWallCabinetsLinkText);
		subCategoryWallCabinetsLinkText.click();
		waitTool.waitFor(driver, true);
	}

	/**
	 *  Method to Click on Pantries in Sub Categories	
	 */
	public void clickSubCategoryPantriesLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, subCategoryPantriesLinkText);
		subCategoryPantriesLinkText.click();
		waitTool.waitFor(driver, true);
	}

	/**
	 *  Method to Click on Fillers, Toe Kicks, & Skins in Sub Categories	
	 */
	public void clickSubCategoryFillersToeKicksSkinsLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, subCategoryFillersToeKicksSkinsLinkText);
		subCategoryFillersToeKicksSkinsLinkText.click();
		waitTool.waitFor(driver, true);
	}


	/**
	 *  Method to Click on Dishwasher End Panel in Sub Categories	
	 */
	public void clickSubCategoryDishwasherEndPanelLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, subCategoryDishwasherEndPanelLinkText);
		subCategoryDishwasherEndPanelLinkText.click();
		waitTool.waitFor(driver, true);
	}

	/**
	 *  Method to Click on Cabinet Shelves in Sub Categories	
	 */
	public void clickSubCategoryCabinetShelvesLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, subCategoryCabinetShelvesLinkText);
		subCategoryCabinetShelvesLinkText.click();
		waitTool.waitFor(driver, true);
	}

	/**
	 *  Method to Click on Cabinet Molding in Sub Categories	
	 */
	public void clickSubCategoryCabinetMoldingLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, subCategoryCabinetMoldingLinkText);
		subCategoryCabinetMoldingLinkText.click();
		waitTool.waitFor(driver, true);
	}

	/**
	 *  Method to Click on Bath Vanity Tops in Sub Categories	
	 */
	public void clickSubCategoryBathVanityTopsLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, subCategoryBathVanityTopsLinkText);
		subCategoryBathVanityTopsLinkText.click();
		waitTool.waitFor(driver, true);
	}

	/**
	 *  Method to Click on Kitchen Countertops & Accessories in Sub Categories	
	 */
	public void clickSubCategoryKitchenCountertopsAccessoriesLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, subCategoryKitchenCountertopsAccessoriesLinkText);
		subCategoryKitchenCountertopsAccessoriesLinkText.click();
		waitTool.waitFor(driver, true);
	}

	/**
	 *  Method to Click on Closet Rods in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryClosetRodsLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, subCategoryClosetRodsLinkText);
		subCategoryClosetRodsLinkText.click();
		waitTool.waitFor(driver, true);
	}

	/**
	 *  Method to Click on Casing in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryCasingLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, subCategoryCasingLinkText);
		subCategoryCasingLinkText.click();
		waitTool.waitFor(driver, true);
	}

	/**
	 *  Method to Click on Exterior in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryExteriorLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, subCategoryExteriorLinkText);
		subCategoryExteriorLinkText.click();
		waitTool.waitFor(driver, true);
	}

	/**
	 *  Method to Click on Interior in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryInteriorLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, subCategoryInteriorLinkText);
		subCategoryInteriorLinkText.click();
		waitTool.waitFor(driver, true);
	}

	/**
	 *  Method to Click on Steps & Guardrails in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryStepsGuardrailsLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, subCategoryStepsGuardrailsLinkText);
		subCategoryStepsGuardrailsLinkText.click();
		waitTool.waitFor(driver, true);
	}

	/**
	 *  Method to Click on Risers in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryRisersLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, subCategoryRisersLinkText);
		subCategoryRisersLinkText.click();
		waitTool.waitFor(driver, true);
	}

	/**
	 *  Method to Click on Cocktail Tables in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryCocktailTablesLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, subCategoryCocktailTablesLinkText);
		subCategoryCocktailTablesLinkText.click();
		waitTool.waitFor(driver, true);
	}

	/**
	 *  Method to Click on Catering Tables in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryCateringTablesLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, subCategoryCateringTablesLinkText);
		subCategoryCateringTablesLinkText.click();
		waitTool.waitFor(driver, true);
	}

	/**
	 *  Method to Click on Ottomans in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryOttomansLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, subCategoryOttomansLinkText);
		subCategoryOttomansLinkText.click();
		waitTool.waitFor(driver, true);
	}

	/**
	 *  Method to Click on Recliners in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryReclinersLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, subCategoryReclinersLinkText);
		subCategoryReclinersLinkText.click();
		waitTool.waitFor(driver, true);
	}

	/**
	 *  Method to Click on Vanity Mirrors in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryVanityMirrorsLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, subCategoryVanityMirrorsLinkText);
		subCategoryVanityMirrorsLinkText.click();
		waitTool.waitFor(driver, true);
	}

	/**
	 *  Method to Click on Wall Mirrors & Frames in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryWallMirrorsFramesLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, subCategoryWallMirrorsFramesLinkText);
		subCategoryWallMirrorsFramesLinkText.click();
		waitTool.waitFor(driver, true);
	}

	/**
	 *  Method to Click on Desks in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryDesksLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, subCategoryDesksLinkText);
		subCategoryDesksLinkText.click();
		waitTool.waitFor(driver, true);
	}

	/**
	 *  Method to Click on Desk Chairs in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryDeskChairsLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, subCategoryDeskChairsLinkText);
		subCategoryDeskChairsLinkText.click();
		waitTool.waitFor(driver, true);
	}

	/**
	 *  Method to Click on Rollaway Beds in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryRollawayBedsLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, subCategoryRollawayBedsLinkText);
		subCategoryRollawayBedsLinkText.click();
		waitTool.waitFor(driver, true);
	}

	/**
	 *  Method to Click on Mattresses in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryMattressesLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, subCategoryMattressesLinkText);
		subCategoryMattressesLinkText.click();
		waitTool.waitFor(driver, true);
	}

	/**
	 *  Method to Click on Colanders in Sub Categories	
	 */
	public void clickSubCategoryColandersLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, subCategoryColandersLinkText);
		subCategoryColandersLinkText.click();
		waitTool.waitFor(driver, true);
	}

	/**
	 *  Method to Click on Can Openers in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryCanOpenersLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, subCategoryCanOpenersLinkText);
		subCategoryCanOpenersLinkText.click();
		waitTool.waitFor(driver, true);
	}

	/**
	 *  Method to Click on Decanters & Pitchers in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryDecantersPitchersLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, subCategoryDecantersPitchersLinkText);
		subCategoryDecantersPitchersLinkText.click();
		waitTool.waitFor(driver, true);
	}

	/**
	 *  Method to Click on Cups & Lids in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryCupsLidsLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, subCategoryCupsLidsLinkText);
		subCategoryCupsLidsLinkText.click();
		waitTool.waitFor(driver, true);
	}

	/**
	 *  Method to Click on Condiment Kits in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryCondimentKitsLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, subCategoryCondimentKitsLinkText);
		subCategoryCondimentKitsLinkText.click();
		waitTool.waitFor(driver, true);
	}

	/**
	 *  Method to Click on Granola Bars in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryGranolaBarsLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, subCategoryGranolaBarsLinkText);
		subCategoryGranolaBarsLinkText.click();
		waitTool.waitFor(driver, true);
	}

	/**
	 *  Method to Click on Food Containers in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryFoodContainersLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, subCategoryFoodContainersLinkText);
		subCategoryFoodContainersLinkText.click();
		waitTool.waitFor(driver, true);
	}

	/**
	 *  Method to Click on Flatware in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryFlatwareLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, subCategoryFlatwareLinkText);
		subCategoryFlatwareLinkText.click();
		waitTool.waitFor(driver, true);
	}

	/**
	 *  Method to Click on Napkin Holders in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryNapkinHoldersLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, subCategoryNapkinHoldersLinkText);
		subCategoryNapkinHoldersLinkText.click();
		waitTool.waitFor(driver, true);
	}

	/**
	 *  Method to Click on Cutlery Holders in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryCutleryHoldersLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, subCategoryCutleryHoldersLinkText);
		subCategoryCutleryHoldersLinkText.click();
		waitTool.waitFor(driver, true);
	}

	/**
	 *  Method to Click on Syrup in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategorySyrupLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, subCategorySyrupLinkText);
		subCategorySyrupLinkText.click();
		waitTool.waitFor(driver, true);
	}

	/**
	 *  Method to Click on Salt & Pepper Shakers in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategorySaltPepperShakersLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, subCategorySaltPepperShakersLinkText);
		subCategorySaltPepperShakersLinkText.click();
		waitTool.waitFor(driver, true);
	}

	/**
	 *  Method to Click on Suspended Frames in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategorySuspendedFramesLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, subCategorySuspendedFramesLinkText);
		subCategorySuspendedFramesLinkText.click();
		waitTool.waitFor(driver, true);
	}

	/**
	 *  Method to Click on Ceiling Tiles & Panels in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryCeilingTilesPanelsLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, subCategoryCeilingTilesPanelsLinkText);
		subCategoryCeilingTilesPanelsLinkText.click();
		waitTool.waitFor(driver, true);
	}

	/**
	 *  Method to Click on Grout Tools in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryGroutToolsLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, subCategoryGroutToolsLinkText);
		subCategoryGroutToolsLinkText.click();
		waitTool.waitFor(driver, true);
	}

	/**
	 *  Method to Click on Carpet Tools in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryCarpetToolsLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, subCategoryCarpetToolsLinkText);
		subCategoryCarpetToolsLinkText.click();
		waitTool.waitFor(driver, true);
	}

	/**
	 *  Method to Click on Flooring Accessories in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryFlooringAccessoriesLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, subCategoryFlooringAccessoriesLinkText);
		subCategoryFlooringAccessoriesLinkText.click();
		waitTool.waitFor(driver, true);
	}

	/**
	 *  Method to Click on Carpet Tiles in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryCarpetTilesLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, subCategoryCarpetTilesLinkText);
		subCategoryCarpetTilesLinkText.click();
		waitTool.waitFor(driver, true);
	}

	/**
	 *  Method to Click on Tile Adhesive in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryTileAdhesiveLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, subCategoryTileAdhesiveLinkText);
		subCategoryTileAdhesiveLinkText.click();
		waitTool.waitFor(driver, true);
	}

	/**
	 *  Method to Click on Grout & Repair in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryGroutRepairLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, subCategoryGroutRepairLinkText);
		subCategoryGroutRepairLinkText.click();
		waitTool.waitFor(driver, true);
	}

	/**
	 *  Method to Click on Weight Bars in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryWeightBarsLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, subCategoryWeightBarsLinkText);
		subCategoryWeightBarsLinkText.click();
		waitTool.waitFor(driver, true);
	}

	/**
	 *  Method to Click on Hand Weights in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryHandWeightsLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, subCategoryHandWeightsLinkText);
		subCategoryHandWeightsLinkText.click();
		waitTool.waitFor(driver, true);
	}

	/**
	 *  Method to Click on Mat Platforms in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryMatPlatformsLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, subCategoryMatPlatformsLinkText);
		subCategoryMatPlatformsLinkText.click();
		waitTool.waitFor(driver, true);
	}

	/**
	 *  Method to Click on Gait Belts in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryGaitBeltsLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, subCategoryGaitBeltsLinkText);
		subCategoryGaitBeltsLinkText.click();
		waitTool.waitFor(driver, true);
	}

	/**
	 *  Method to Click on Ellipticals in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryEllipticalsLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, subCategoryEllipticalsLinkText);
		subCategoryEllipticalsLinkText.click();
		waitTool.waitFor(driver, true);
	}

	/**
	 *  Method to Click on Bikes & Pedal Exercisers in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryBikesPedalExercisersLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, subCategoryBikesPedalExercisersLinkText);
		subCategoryBikesPedalExercisersLinkText.click();
		waitTool.waitFor(driver, true);
	}

	/**
	 *  Method to Click on Hand Exercisers in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryHandExercisersLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, subCategoryHandExercisersLinkText);
		subCategoryHandExercisersLinkText.click();
		waitTool.waitFor(driver, true);
	}

	/**
	 *  Method to Click on Exercise Bars in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryExerciseBarsLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, subCategoryExerciseBarsLinkText);
		subCategoryExerciseBarsLinkText.click();
		waitTool.waitFor(driver, true);

	}

	/**
	 *  Method to Click on Antennas in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryAntennasLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, subCategoryAntennasLinkText);
		subCategoryAntennasLinkText.click();
		waitTool.waitFor(driver, true);
	}

	/**
	 *  Method to Click on Two-Way Radios in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryTwoWayRadiosLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, subCategoryTwoWayRadiosLinkText);
		subCategoryTwoWayRadiosLinkText.click();

		waitTool.waitFor(driver, true);

	}

	/**
	 *  Method to Click on Telephone Cords in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryTelephoneCordsLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, subCategoryTelephoneCordsLinkText);
		subCategoryTelephoneCordsLinkText.click();
		waitTool.waitFor(driver, true);
	}

	/**
	 *  Method to Click on Ethernet Cables in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryEthernetCablesLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, subCategoryEthernetCablesLinkText);
		subCategoryEthernetCablesLinkText.click();
		waitTool.waitFor(driver, true);
	}

	/**
	 *  Method to Click on Video Monitoring Accessories in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryVideoMonitoringAccessoriesLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, subCategoryVideoMonitoringAccessoriesLinkText);
		subCategoryVideoMonitoringAccessoriesLinkText.click();
		waitTool.waitFor(driver, true);
	}

	/**
	 *  Method to Click on Mirrors in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryMirrorsLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, subCategoryMirrorsLinkText);
		subCategoryMirrorsLinkText.click();
		waitTool.waitFor(driver, true);
	}

	/**
	 *  Method to Click on Intercom Systems & Accessories in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryIntercomSystemsAccessoriesLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, subCategoryIntercomSystemsAccessoriesLinkText);
		subCategoryIntercomSystemsAccessoriesLinkText.click();
		waitTool.waitFor(driver, true);
	}

	/**
	 *  Method to Click on Door Chimes in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryDoorChimesLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, subCategoryDoorChimesLinkText);
		subCategoryDoorChimesLinkText.click();
		waitTool.waitFor(driver, true);
	}

	/**
	 *  Method to Click on Conduit in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryConduitLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, subCategoryConduitLinkText);
		subCategoryConduitLinkText.click();
		waitTool.waitFor(driver, true);
	}

	/**
	 *  Method to Click on Raceway in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryRacewayLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, subCategoryRacewayLinkText);
		subCategoryRacewayLinkText.click();
		waitTool.waitFor(driver, true);
	}

	/**
	 *  Method to Click on Load Centers in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryLoadCentersLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, subCategoryLoadCentersLinkText);
		subCategoryLoadCentersLinkText.click();
		waitTool.waitFor(driver, true);
	}

	/**
	 *  Method to Click on Fuses in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryFusesLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, subCategoryFusesLinkText);
		subCategoryFusesLinkText.click();
		waitTool.waitFor(driver, true);
	}

	/**
	 *  Method to Click on Power Stations in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryPowerStationsLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, subCategoryPowerStationsLinkText);
		subCategoryPowerStationsLinkText.click();
		waitTool.waitFor(driver, true);
	}

	/**
	 *  Method to Click on Phone Chargers in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryPhoneChargersLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, subCategoryPhoneChargersLinkText);
		subCategoryPhoneChargersLinkText.click();
		waitTool.waitFor(driver, true);
	}

	/**
	 *  Method to Click on Electrical Wire in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryElectricalWireLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, subCategoryElectricalWireLinkText);
		subCategoryElectricalWireLinkText.click();
		waitTool.waitFor(driver, true);
	}

	/**
	 *  Method to Click on Electrical Tape in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryElectricalTapeLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, subCategoryElectricalTapeLinkText);
		subCategoryElectricalTapeLinkText.click();
		waitTool.waitFor(driver, true);
	}

	/**
	 *  Method to Click on Wall Outlets in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryWallOutletsLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, subCategoryWallOutletsLinkText);
		subCategoryWallOutletsLinkText.click();
		waitTool.waitFor(driver, true);
	}

	/**
	 *  Method to Click on Switches in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategorySwitchesLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, subCategorySwitchesLinkText);
		subCategorySwitchesLinkText.click();
		waitTool.waitFor(driver, true);
	}

	/**
	 *  Method to Click on Speciality Plates in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategorySpecialityPlatesLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, subCategorySpecialityPlatesLinkText);
		subCategorySpecialityPlatesLinkText.click();
		waitTool.waitFor(driver, true);
	}

	/**
	 *  Method to Click on Receptacle Plates in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryReceptaclePlatesLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, subCategoryReceptaclePlatesLinkText);
		subCategoryReceptaclePlatesLinkText.click();
		waitTool.waitFor(driver, true);
	}

	/**
	 *  Method to Click on Timer Accessories in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryTimerAccessoriesLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, subCategoryTimerAccessoriesLinkText);
		subCategoryTimerAccessoriesLinkText.click();
		waitTool.waitFor(driver, true);
	}

	/**
	 *  Method to Click on Timers in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryTimersLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, subCategoryTimersLinkText);
		subCategoryTimersLinkText.click();
		waitTool.waitFor(driver, true);
	}

	/**
	 *  Method to Click on Power Adapters in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryPowerAdaptersLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, subCategoryPowerAdaptersLinkText);
		subCategoryPowerAdaptersLinkText.click();
		waitTool.waitFor(driver, true);
	}

	/**
	 *  Method to Click on Extension Cords in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryExtensionCordsLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, subCategoryExtensionCordsLinkText);
		subCategoryExtensionCordsLinkText.click();
		waitTool.waitFor(driver, true);
	}

	/**
	 *  Method to Click on AAAA Batteries in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryAAAABatteriesLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, subCategoryAAAABatteriesLinkText);
		subCategoryAAAABatteriesLinkText.click();
		waitTool.waitFor(driver, true);
	}

	/**
	 *  Method to Click on Recycling Kits in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryRecyclingKitsLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, subCategoryRecyclingKitsLinkText);
		subCategoryRecyclingKitsLinkText.click();
		waitTool.waitFor(driver, true);
	}

	/**
	 *  Method to Click on Fire Alarms & Accessories in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryFireAlarmsAccessoriesLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, subCategoryFireAlarmsAccessoriesLinkText);
		subCategoryFireAlarmsAccessoriesLinkText.click();
		waitTool.waitFor(driver, true);
	}

	/**
	 *  Method to Click on Combination Smoke & CO Alarms in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryCombinationSmokeCOAlarmsLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, subCategoryCombinationSmokeCOAlarmsLinkText);
		subCategoryCombinationSmokeCOAlarmsLinkText.click();
		waitTool.waitFor(driver, true);
	}

	/**
	 *  Method to Click on Insulated & Voltage Sensing Hand Tools in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryInsulatedVoltageSensingHandToolsLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, subCategoryInsulatedVoltageSensingHandToolsLinkText);
		subCategoryInsulatedVoltageSensingHandToolsLinkText.click();
		waitTool.waitFor(driver, true);
	}

	/**
	 *  Method to Click on Fuse Pullers in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryFusePullersLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, subCategoryFusePullersLinkText);
		subCategoryFusePullersLinkText.click();
		waitTool.waitFor(driver, true);
	}

	/**
	 *  Method to Click on Electrical Boxes in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryElectricalBoxesLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, subCategoryElectricalBoxesLinkText);
		subCategoryElectricalBoxesLinkText.click();
		waitTool.waitFor(driver, true);
	}

	/**
	 *  Method to Click on Floor Boxes in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryFloorBoxesLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, subCategoryFloorBoxesLinkText);
		subCategoryFloorBoxesLinkText.click();
		waitTool.waitFor(driver, true);
	}

	/**
	 *  Method to get checkbox of customize link
	 * @return
	 * @throws InterruptedException
	 */
	public List<WebElement> getWebConfigCheckBox() throws InterruptedException {
		waitTool.waitFor(driver,true) ;	
		return customiseItemCheckBox;
	}	

	/**
	 *  Click on WebConfig
	 * @throws InterruptedException
	 */
	public void clickSubCategoryWebConfigLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, subCategoryWebConfigLink);
		subCategoryWebConfigLink.click();
		waitTool.waitFor(driver, true);
	}

	/**
	 *  Method to get Customise Item Link
	 * @return
	 * @throws InterruptedException
	 */
	public List<WebElement> getCustomizeItemLinkText() throws InterruptedException {
		waitTool.waitFor(driver,true) ;	
		return customiseItemLinkText;
	}

	/**
	 *  Method to Verify for Customize Item Modal
	 * @return
	 */
/*	public boolean isDisplayedCustomizeItemModal(){
		return .isElementPresent(customizeItemModal);
	}*/

	/**
	 *  method to Close the Modal of Customize Item
	 * @throws InterruptedException
	 */
	public void clickCloseCustomizeItemModal() throws InterruptedException {
		waitTool.waitForElement(driver, closeCustomizeItemModal);
		closeCustomizeItemModal.click();
		waitTool.waitFor(driver, true);
	}

	/**
	 *  Method to Verify for that Customize This Item is not displayed
	 * @return
	 */
	/*public boolean isNotDisplayedCustomizeThisItem(){
		return .isElementPresent(CustomizeThisItemLinkText);
	}*/

}

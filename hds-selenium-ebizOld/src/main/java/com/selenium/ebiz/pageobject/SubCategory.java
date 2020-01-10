package com.selenium.ebiz.pageobject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.selenium.ebiz.baseclass.BaseClass;
import com.selenium.ebiz.tools.CommonFunctions;
import com.selenium.ebiz.tools.WaitTool;

public class SubCategory  extends BaseClass{

	public SubCategory(WebDriver driver) 	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		//WebDriverWait wait = new WebDriverWait(driver, 25);
		//wait.until(ExpectedConditions.visibilityOf(()));
	}

	@FindBy(xpath = "/html/body/div[8]/div")
	WebElement customizeItemModal;	

	@FindBy(xpath = "/html/body/div[8]/div/a")
	WebElement closeCustomizeItemModal;	
	
	@FindBy(xpath = "//div[starts-with(@id,'container_')]/div[6]/div[2]/div[4]/section[1]/div[6]/div[2]/div/a")
	WebElement CustomizeThisItemLinkText;			

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

	@FindBy(linkText = "Steps & Guardrails")
	WebElement subCategoryStepsGuardrailsLinkText;

	public void clickSubCategoryOvertheJohnLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryOvertheJohnLinkText);
			subCategoryOvertheJohnLinkText.click();
			WaitTool.waitFor(driver, true);
		}
	
	public void clickSubCategoryWheelchairAccessibleLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryWheelchairAccessibleLinkText);
			subCategoryWheelchairAccessibleLinkText.click();
			WaitTool.waitFor(driver, true);
		}
	
	/**
	 *  Method to Click on Vanity Combos in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryVanityCombosLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryVanityCombosLinkText);
			subCategoryVanityCombosLinkText.click();
			WaitTool.waitFor(driver, true);
		}

	/**
	 *  Method to Click on Vanity Cabinets in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryVanityCabinetsLinkText() throws InterruptedException {
		 
			WaitTool.waitForElement(driver, subCategoryVanityCabinetsLinkText);
			subCategoryVanityCabinetsLinkText.click();
			
			WaitTool.waitFor(driver, true);
			
		}

	/**
	 *  Method to Click on Cosmetic Boxes & Accessories in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryCosmeticBoxesAccessoriesLinkText() throws InterruptedException {
		 
			WaitTool.waitForElement(driver, subCategoryCosmeticBoxesAccessoriesLinkText);
			subCategoryCosmeticBoxesAccessoriesLinkText.click();
			WaitTool.waitFor(driver, true);
		}

	/**
	 *  Method to Click on Medicine Cabinets & Accessories in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryMedicineCabinetsAccessoriesLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryMedicineCabinetsAccessoriesLinkText);
			subCategoryMedicineCabinetsAccessoriesLinkText.click();
			WaitTool.waitFor(driver, true);
		}

	/**
	 *  Method to Click on Base Cabinets in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryBaseCabinetsLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryBaseCabinetsLinkText);
			subCategoryBaseCabinetsLinkText.click();
			WaitTool.waitFor(driver, true);
		}
	
	/**
	 * Method to Click on Wall Cabinets in Sub Categories	
	 */
	public void clickSubCategoryWallCabinetsLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryWallCabinetsLinkText);
			subCategoryWallCabinetsLinkText.click();
			WaitTool.waitFor(driver, true);
		}

	/**
	 *  Method to Click on Pantries in Sub Categories	
	 */
	public void clickSubCategoryPantriesLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryPantriesLinkText);
			subCategoryPantriesLinkText.click();
			WaitTool.waitFor(driver, true);
		}
	
	/**
	 *  Method to Click on Fillers, Toe Kicks, & Skins in Sub Categories	
	 */
	public void clickSubCategoryFillersToeKicksSkinsLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryFillersToeKicksSkinsLinkText);
			subCategoryFillersToeKicksSkinsLinkText.click();
			WaitTool.waitFor(driver, true);
		}

	
	/**
	 *  Method to Click on Dishwasher End Panel in Sub Categories	
	 */
	public void clickSubCategoryDishwasherEndPanelLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryDishwasherEndPanelLinkText);
			subCategoryDishwasherEndPanelLinkText.click();
			WaitTool.waitFor(driver, true);
		}

	/**
	 *  Method to Click on Cabinet Shelves in Sub Categories	
	 */
	public void clickSubCategoryCabinetShelvesLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryCabinetShelvesLinkText);
			subCategoryCabinetShelvesLinkText.click();
			WaitTool.waitFor(driver, true);
		}
	
	/**
	 *  Method to Click on Cabinet Molding in Sub Categories	
	 */
	public void clickSubCategoryCabinetMoldingLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryCabinetMoldingLinkText);
			subCategoryCabinetMoldingLinkText.click();
			WaitTool.waitFor(driver, true);
		}
	
	/**
	 *  Method to Click on Bath Vanity Tops in Sub Categories	
	 */
	public void clickSubCategoryBathVanityTopsLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryBathVanityTopsLinkText);
			subCategoryBathVanityTopsLinkText.click();
			WaitTool.waitFor(driver, true);
		}
	
	/**
	 *  Method to Click on Kitchen Countertops & Accessories in Sub Categories	
	 */
	public void clickSubCategoryKitchenCountertopsAccessoriesLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryKitchenCountertopsAccessoriesLinkText);
			subCategoryKitchenCountertopsAccessoriesLinkText.click();
			WaitTool.waitFor(driver, true);
		}

	/**
	 *  Method to Click on Closet Rods in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryClosetRodsLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryClosetRodsLinkText);
			subCategoryClosetRodsLinkText.click();
			WaitTool.waitFor(driver, true);
		}
	
	/**
	 *  Method to Click on Casing in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryCasingLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryCasingLinkText);
			subCategoryCasingLinkText.click();
			WaitTool.waitFor(driver, true);
		}
	
	/**
	 *  Method to Click on Exterior in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryExteriorLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryExteriorLinkText);
			subCategoryExteriorLinkText.click();
			WaitTool.waitFor(driver, true);
		}
	
	/**
	 *  Method to Click on Interior in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryInteriorLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryInteriorLinkText);
			subCategoryInteriorLinkText.click();
			WaitTool.waitFor(driver, true);
		}

	/**
	 *  Method to Click on Steps & Guardrails in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryStepsGuardrailsLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryStepsGuardrailsLinkText);
			subCategoryStepsGuardrailsLinkText.click();
			WaitTool.waitFor(driver, true);
		}
	
	/**
	 *  Method to Click on Risers in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryRisersLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryRisersLinkText);
			subCategoryRisersLinkText.click();
			WaitTool.waitFor(driver, true);
		}
	
	/**
	 *  Method to Click on Cocktail Tables in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryCocktailTablesLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryCocktailTablesLinkText);
			subCategoryCocktailTablesLinkText.click();
			WaitTool.waitFor(driver, true);
		}
	
	/**
	 *  Method to Click on Catering Tables in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryCateringTablesLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryCateringTablesLinkText);
			subCategoryCateringTablesLinkText.click();
			WaitTool.waitFor(driver, true);
		}
	
	/**
	 *  Method to Click on Ottomans in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryOttomansLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryOttomansLinkText);
			subCategoryOttomansLinkText.click();
			WaitTool.waitFor(driver, true);
		}
	
	/**
	 *  Method to Click on Recliners in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryReclinersLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryReclinersLinkText);
			subCategoryReclinersLinkText.click();
			WaitTool.waitFor(driver, true);
		}
	
	/**
	 *  Method to Click on Vanity Mirrors in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryVanityMirrorsLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryVanityMirrorsLinkText);
			subCategoryVanityMirrorsLinkText.click();
			WaitTool.waitFor(driver, true);
		}
	
	/**
	 *  Method to Click on Wall Mirrors & Frames in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryWallMirrorsFramesLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryWallMirrorsFramesLinkText);
			subCategoryWallMirrorsFramesLinkText.click();
			WaitTool.waitFor(driver, true);
		}
	
	/**
	 *  Method to Click on Desks in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryDesksLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryDesksLinkText);
			subCategoryDesksLinkText.click();
			WaitTool.waitFor(driver, true);
		}

	/**
	 *  Method to Click on Desk Chairs in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryDeskChairsLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryDeskChairsLinkText);
			subCategoryDeskChairsLinkText.click();
			WaitTool.waitFor(driver, true);
		}
	
	/**
	 *  Method to Click on Rollaway Beds in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryRollawayBedsLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryRollawayBedsLinkText);
			subCategoryRollawayBedsLinkText.click();
			WaitTool.waitFor(driver, true);
		}
	
	/**
	 *  Method to Click on Mattresses in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryMattressesLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryMattressesLinkText);
			subCategoryMattressesLinkText.click();
			WaitTool.waitFor(driver, true);
		}
	
	/**
	 *  Method to Click on Colanders in Sub Categories	
	 */
	public void clickSubCategoryColandersLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryColandersLinkText);
			subCategoryColandersLinkText.click();
			WaitTool.waitFor(driver, true);
		}
	
	/**
	 *  Method to Click on Can Openers in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryCanOpenersLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryCanOpenersLinkText);
			subCategoryCanOpenersLinkText.click();
			WaitTool.waitFor(driver, true);
		}
	
	/**
	 *  Method to Click on Decanters & Pitchers in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryDecantersPitchersLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryDecantersPitchersLinkText);
			subCategoryDecantersPitchersLinkText.click();
			WaitTool.waitFor(driver, true);
		}
	
	/**
	 *  Method to Click on Cups & Lids in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryCupsLidsLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryCupsLidsLinkText);
			subCategoryCupsLidsLinkText.click();
			WaitTool.waitFor(driver, true);
		}
	
	/**
	 *  Method to Click on Condiment Kits in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryCondimentKitsLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryCondimentKitsLinkText);
			subCategoryCondimentKitsLinkText.click();
			WaitTool.waitFor(driver, true);
		}

	/**
	 *  Method to Click on Granola Bars in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryGranolaBarsLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryGranolaBarsLinkText);
			subCategoryGranolaBarsLinkText.click();
			WaitTool.waitFor(driver, true);
		}
	
	/**
	 *  Method to Click on Food Containers in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryFoodContainersLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryFoodContainersLinkText);
			subCategoryFoodContainersLinkText.click();
			WaitTool.waitFor(driver, true);
		}
	
	/**
	 *  Method to Click on Flatware in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryFlatwareLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryFlatwareLinkText);
			subCategoryFlatwareLinkText.click();
			WaitTool.waitFor(driver, true);
		}
	
	/**
	 *  Method to Click on Napkin Holders in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryNapkinHoldersLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryNapkinHoldersLinkText);
			subCategoryNapkinHoldersLinkText.click();
			WaitTool.waitFor(driver, true);
		}
	
	/**
	 *  Method to Click on Cutlery Holders in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryCutleryHoldersLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryCutleryHoldersLinkText);
			subCategoryCutleryHoldersLinkText.click();
			WaitTool.waitFor(driver, true);
		}
	
	/**
	 *  Method to Click on Syrup in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategorySyrupLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategorySyrupLinkText);
			subCategorySyrupLinkText.click();
			WaitTool.waitFor(driver, true);
		}
	
	/**
	 *  Method to Click on Salt & Pepper Shakers in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategorySaltPepperShakersLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategorySaltPepperShakersLinkText);
			subCategorySaltPepperShakersLinkText.click();
			WaitTool.waitFor(driver, true);
		}
	
	/**
	 *  Method to Click on Suspended Frames in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategorySuspendedFramesLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategorySuspendedFramesLinkText);
			subCategorySuspendedFramesLinkText.click();
			WaitTool.waitFor(driver, true);
		}
	
	/**
	 *  Method to Click on Ceiling Tiles & Panels in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryCeilingTilesPanelsLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryCeilingTilesPanelsLinkText);
			subCategoryCeilingTilesPanelsLinkText.click();
			WaitTool.waitFor(driver, true);
		}
	
	/**
	 *  Method to Click on Grout Tools in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryGroutToolsLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryGroutToolsLinkText);
			subCategoryGroutToolsLinkText.click();
			WaitTool.waitFor(driver, true);
		}
	
	/**
	 *  Method to Click on Carpet Tools in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryCarpetToolsLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryCarpetToolsLinkText);
			subCategoryCarpetToolsLinkText.click();
			WaitTool.waitFor(driver, true);
		}
	
	/**
	 *  Method to Click on Flooring Accessories in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryFlooringAccessoriesLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryFlooringAccessoriesLinkText);
			subCategoryFlooringAccessoriesLinkText.click();
			WaitTool.waitFor(driver, true);
		}
	
	/**
	 *  Method to Click on Carpet Tiles in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryCarpetTilesLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryCarpetTilesLinkText);
			subCategoryCarpetTilesLinkText.click();
			WaitTool.waitFor(driver, true);
		}
	
	/**
	 *  Method to Click on Tile Adhesive in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryTileAdhesiveLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryTileAdhesiveLinkText);
			subCategoryTileAdhesiveLinkText.click();
			WaitTool.waitFor(driver, true);
		}

	/**
	 *  Method to Click on Grout & Repair in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryGroutRepairLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryGroutRepairLinkText);
			subCategoryGroutRepairLinkText.click();
			WaitTool.waitFor(driver, true);
		}

	/**
	 *  Method to Click on Weight Bars in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryWeightBarsLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryWeightBarsLinkText);
			subCategoryWeightBarsLinkText.click();
			WaitTool.waitFor(driver, true);
		}

	/**
	 *  Method to Click on Hand Weights in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryHandWeightsLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryHandWeightsLinkText);
			subCategoryHandWeightsLinkText.click();
			WaitTool.waitFor(driver, true);
		}
	
	/**
	 *  Method to Click on Mat Platforms in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryMatPlatformsLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryMatPlatformsLinkText);
			subCategoryMatPlatformsLinkText.click();
			WaitTool.waitFor(driver, true);
		}

	/**
	 *  Method to Click on Gait Belts in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryGaitBeltsLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryGaitBeltsLinkText);
			subCategoryGaitBeltsLinkText.click();
			WaitTool.waitFor(driver, true);
		}

	/**
	 *  Method to Click on Ellipticals in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryEllipticalsLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryEllipticalsLinkText);
			subCategoryEllipticalsLinkText.click();
			WaitTool.waitFor(driver, true);
		}

	/**
	 *  Method to Click on Bikes & Pedal Exercisers in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryBikesPedalExercisersLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryBikesPedalExercisersLinkText);
			subCategoryBikesPedalExercisersLinkText.click();
			WaitTool.waitFor(driver, true);
		}
	
	/**
	 *  Method to Click on Hand Exercisers in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryHandExercisersLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryHandExercisersLinkText);
			subCategoryHandExercisersLinkText.click();
			WaitTool.waitFor(driver, true);
		}
	
	/**
	 *  Method to Click on Exercise Bars in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryExerciseBarsLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryExerciseBarsLinkText);
			subCategoryExerciseBarsLinkText.click();
			WaitTool.waitFor(driver, true);
			
		}
	
	/**
	 *  Method to Click on Antennas in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryAntennasLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryAntennasLinkText);
			subCategoryAntennasLinkText.click();
			WaitTool.waitFor(driver, true);
		}
	
	/**
	 *  Method to Click on Two-Way Radios in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryTwoWayRadiosLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryTwoWayRadiosLinkText);
			subCategoryTwoWayRadiosLinkText.click();
			
			WaitTool.waitFor(driver, true);
			
		}

	/**
	 *  Method to Click on Telephone Cords in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryTelephoneCordsLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryTelephoneCordsLinkText);
			subCategoryTelephoneCordsLinkText.click();
			WaitTool.waitFor(driver, true);
		}
	
	/**
	 *  Method to Click on Ethernet Cables in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryEthernetCablesLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryEthernetCablesLinkText);
			subCategoryEthernetCablesLinkText.click();
			WaitTool.waitFor(driver, true);
		}
	
	/**
	 *  Method to Click on Video Monitoring Accessories in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryVideoMonitoringAccessoriesLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryVideoMonitoringAccessoriesLinkText);
			subCategoryVideoMonitoringAccessoriesLinkText.click();
			WaitTool.waitFor(driver, true);
		}
	
	/**
	 *  Method to Click on Mirrors in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryMirrorsLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryMirrorsLinkText);
			subCategoryMirrorsLinkText.click();
			WaitTool.waitFor(driver, true);
		}
	
	/**
	 *  Method to Click on Intercom Systems & Accessories in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryIntercomSystemsAccessoriesLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryIntercomSystemsAccessoriesLinkText);
			subCategoryIntercomSystemsAccessoriesLinkText.click();
			WaitTool.waitFor(driver, true);
		}
	
	/**
	 *  Method to Click on Door Chimes in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryDoorChimesLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryDoorChimesLinkText);
			subCategoryDoorChimesLinkText.click();
			WaitTool.waitFor(driver, true);
		}
	
	/**
	 *  Method to Click on Conduit in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryConduitLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryConduitLinkText);
			subCategoryConduitLinkText.click();
			WaitTool.waitFor(driver, true);
		}
	
	/**
	 *  Method to Click on Raceway in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryRacewayLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryRacewayLinkText);
			subCategoryRacewayLinkText.click();
			WaitTool.waitFor(driver, true);
		}
	
	/**
	 *  Method to Click on Load Centers in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryLoadCentersLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryLoadCentersLinkText);
			subCategoryLoadCentersLinkText.click();
			WaitTool.waitFor(driver, true);
		}
	
	/**
	 *  Method to Click on Fuses in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryFusesLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryFusesLinkText);
			subCategoryFusesLinkText.click();
			WaitTool.waitFor(driver, true);
		}

	/**
	 *  Method to Click on Power Stations in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryPowerStationsLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryPowerStationsLinkText);
			subCategoryPowerStationsLinkText.click();
			WaitTool.waitFor(driver, true);
		}
	
	/**
	 *  Method to Click on Phone Chargers in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryPhoneChargersLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryPhoneChargersLinkText);
			subCategoryPhoneChargersLinkText.click();
			WaitTool.waitFor(driver, true);
		}

	/**
	 *  Method to Click on Electrical Wire in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryElectricalWireLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryElectricalWireLinkText);
			subCategoryElectricalWireLinkText.click();
			WaitTool.waitFor(driver, true);
		}
	
	/**
	 *  Method to Click on Electrical Tape in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryElectricalTapeLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryElectricalTapeLinkText);
			subCategoryElectricalTapeLinkText.click();
			WaitTool.waitFor(driver, true);
		}
	
	/**
	 *  Method to Click on Wall Outlets in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryWallOutletsLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryWallOutletsLinkText);
			subCategoryWallOutletsLinkText.click();
			WaitTool.waitFor(driver, true);
		}
	
	/**
	 *  Method to Click on Switches in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategorySwitchesLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategorySwitchesLinkText);
			subCategorySwitchesLinkText.click();
			WaitTool.waitFor(driver, true);
		}
	
	/**
	 *  Method to Click on Speciality Plates in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategorySpecialityPlatesLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategorySpecialityPlatesLinkText);
			subCategorySpecialityPlatesLinkText.click();
			WaitTool.waitFor(driver, true);
		}
	
	/**
	 *  Method to Click on Receptacle Plates in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryReceptaclePlatesLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryReceptaclePlatesLinkText);
			subCategoryReceptaclePlatesLinkText.click();
			WaitTool.waitFor(driver, true);
		}
	
	/**
	 *  Method to Click on Timer Accessories in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryTimerAccessoriesLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryTimerAccessoriesLinkText);
			subCategoryTimerAccessoriesLinkText.click();
			WaitTool.waitFor(driver, true);
		}

	/**
	 *  Method to Click on Timers in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryTimersLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryTimersLinkText);
			subCategoryTimersLinkText.click();
			WaitTool.waitFor(driver, true);
		}
	
	/**
	 *  Method to Click on Power Adapters in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryPowerAdaptersLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryPowerAdaptersLinkText);
			subCategoryPowerAdaptersLinkText.click();
			WaitTool.waitFor(driver, true);
		}

	/**
	 *  Method to Click on Extension Cords in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryExtensionCordsLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryExtensionCordsLinkText);
			subCategoryExtensionCordsLinkText.click();
			WaitTool.waitFor(driver, true);
		}
	
	/**
	 *  Method to Click on AAAA Batteries in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryAAAABatteriesLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryAAAABatteriesLinkText);
			subCategoryAAAABatteriesLinkText.click();
			WaitTool.waitFor(driver, true);
		}
	
	/**
	 *  Method to Click on Recycling Kits in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryRecyclingKitsLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryRecyclingKitsLinkText);
			subCategoryRecyclingKitsLinkText.click();
			WaitTool.waitFor(driver, true);
		}
	
	/**
	 *  Method to Click on Fire Alarms & Accessories in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryFireAlarmsAccessoriesLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryFireAlarmsAccessoriesLinkText);
			subCategoryFireAlarmsAccessoriesLinkText.click();
			WaitTool.waitFor(driver, true);
		}
	
	/**
	 *  Method to Click on Combination Smoke & CO Alarms in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryCombinationSmokeCOAlarmsLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryCombinationSmokeCOAlarmsLinkText);
			subCategoryCombinationSmokeCOAlarmsLinkText.click();
			WaitTool.waitFor(driver, true);
		}
	
	/**
	 *  Method to Click on Insulated & Voltage Sensing Hand Tools in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryInsulatedVoltageSensingHandToolsLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryInsulatedVoltageSensingHandToolsLinkText);
			subCategoryInsulatedVoltageSensingHandToolsLinkText.click();
			WaitTool.waitFor(driver, true);
		}
	
	/**
	 *  Method to Click on Fuse Pullers in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryFusePullersLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryFusePullersLinkText);
			subCategoryFusePullersLinkText.click();
			WaitTool.waitFor(driver, true);
		}
	
	/**
	 *  Method to Click on Electrical Boxes in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryElectricalBoxesLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryElectricalBoxesLinkText);
			subCategoryElectricalBoxesLinkText.click();
			WaitTool.waitFor(driver, true);
		}
	
	/**
	 *  Method to Click on Floor Boxes in Sub Categories	
	 * @throws InterruptedException
	 */
	public void clickSubCategoryFloorBoxesLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryFloorBoxesLinkText);
			subCategoryFloorBoxesLinkText.click();
			WaitTool.waitFor(driver, true);
		}
	
	/**
	 *  Method to get checkbox of customize link
	 * @return
	 * @throws InterruptedException
	 */
	public List<WebElement> getWebConfigCheckBox() throws InterruptedException {
		WaitTool.waitFor(driver,true) ;	
		return customiseItemCheckBox;
	}	
	
	/**
	 *  Click on WebConfig
	 * @throws InterruptedException
	 */
	public void clickSubCategoryWebConfigLinkText() throws InterruptedException {
		WaitTool.waitForElement(driver, subCategoryWebConfigLink);
		subCategoryWebConfigLink.click();
		WaitTool.waitFor(driver, true);
	}
	
	/**
	 *  Method to get Customise Item Link
	 * @return
	 * @throws InterruptedException
	 */
	public List<WebElement> getCustomizeItemLinkText() throws InterruptedException {
		WaitTool.waitFor(driver,true) ;	
		return customiseItemLinkText;
	}
	
	/**
	 *  Method to Verify for Customize Item Modal
	 * @return
	 */
	public boolean isDisplayedCustomizeItemModal(){
		return CommonFunctions.isElementPresent(customizeItemModal);
	}

	/**
	 *  method to Close the Modal of Customize Item
	 * @throws InterruptedException
	 */
	public void clickCloseCustomizeItemModal() throws InterruptedException {
		WaitTool.waitForElement(driver, closeCustomizeItemModal);
		closeCustomizeItemModal.click();
		WaitTool.waitFor(driver, true);
	}
	
	/**
	 *  Method to Verify for that Customize This Item is not displayed
	 * @return
	 */
	public boolean isNotDisplayedCustomizeThisItem(){
		return CommonFunctions.isElementPresent(CustomizeThisItemLinkText);
	}

}

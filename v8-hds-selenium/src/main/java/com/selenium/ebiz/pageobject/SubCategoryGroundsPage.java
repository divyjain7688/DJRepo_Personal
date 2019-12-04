package com.selenium.ebiz.pageobject;

import com.selenium.ebiz.tools.WaitTool;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class SubCategoryGroundsPage {
	private  WebDriver driver; private WaitTool   waitTool;

	public SubCategoryGroundsPage(WebDriver driver) 	{
		this.driver = driver;  this.waitTool = new WaitTool();
		PageFactory.initElements(driver, this);
		//WebDriverWait wait = new WebDriverWait(driver, 25);
	}

	// Top Categories Outdoor Furniture
	@FindBy(linkText = "Outdoor Furniture")
	WebElement topCategoryOutdoorFurnitureLinkText;


	// Top Categories Pest Control
	@FindBy(linkText = "Pest Control")
	WebElement topCategoryPestControlLinkText;

	//SubCategories for Pest Control
	@FindBy(linkText = "Animal Traps")
	WebElement subCategoryAnimalTrapsLinkText;

	@FindBy(linkText = "Pesticides & Poisons")
	WebElement subCategoryPesticidesPoisonsLinkText;

	// Top Categories Entrance Mats
	@FindBy(linkText = "Entrance Mats")
	WebElement topCategoryEntranceMatsLinkText;

	//SubCategories for Entrance Mats
	@FindBy(linkText = "Indoor Scraper Mats")
	WebElement subCategoryIndoorScraperMatsLinkText;

	// Top Categories Weed Control & Fertilizer
	@FindBy(linkText = "Weed Control & Fertilizer")
	WebElement topCategoryWeedControlFertilizerLinkText;

	//subcategories
	@FindBy(linkText = "Weed Control")
	WebElement subCategoryWeedControlLinkText;

	@FindBy(linkText = "Plant Food & Fertilizer")
	WebElement subCategoryPlantFoodFertilizerLinkText;	

	// Top Categories Irrigation
	@FindBy(linkText = "Irrigation")
	WebElement topCategoryIrrigationLinkText;


	@FindBy(linkText = "Irrigation Systems")
	WebElement subCategoryIrrigationSystemsLinkText;

	@FindBy(linkText = "Garden Hoses & Accessories")
	WebElement subCategoryGardenHosesAccessoriesLinkText;

	// Top Categories Grills & Accessories
	@FindBy(linkText = "Grills & Accessories")
	WebElement topCategoryGrillsAccessoriesLinkText;

	//Subcategories.
	@FindBy(linkText = "Grill Accessories")
	WebElement subCategoryGrillAccessoriesLinkText;

	@FindBy(linkText = "Grills")
	WebElement subCategoryGrillsLinkText;

	// Top Categories Patio Heaters
	@FindBy(linkText = "Patio Heaters")
	WebElement topCategoryPatioHeatersLinkText;

	// Top Categories Playground Equipment
	@FindBy(linkText = "Playground Equipment")
	WebElement topCategoryPlaygroundEquipmentLinkText;

	// Top Categories Flags & Poles
	@FindBy(linkText = "Flags & Poles")
	WebElement topCategoryFlagsPolesLinkText;
	//subcategories
	@FindBy(linkText = "Flag Cases")
	WebElement subCategoryFlagCasesLinkText;

	@FindBy(linkText = "Religious Flags")
	WebElement subCategoryReligiousFlagsLinkText;


	// Top Categories Bicycle Racks
	@FindBy(linkText = "Bicycle Racks")
	WebElement topCategoryBicycleRacksLinkText;

	// Top Categories Outdoor Heating
	@FindBy(linkText = "Outdoor Heating")
	WebElement topCategoryOutdoorHeatingLinkText;

	//subcategories
	@FindBy(linkText = "Fire Pits & Covers")
	WebElement subCategoryFirePitsCoversLinkText;

	@FindBy(linkText = "Patio Heaters & Covers")
	WebElement subCategoryPatioHeatersCoversLinkText;


	// Top Categories Fencing
	@FindBy(linkText = "Fencing")
	WebElement topCategoryFencingLinkText;

	// Top Categories De-Icing Tools
	@FindBy(linkText = "De-Icing Tools")
	WebElement topCategoryDeIcingToolsLinkText;

	//subcategories
	@FindBy(linkText = "Ice Melting Compounds")
	WebElement subCategoryIceMeltingCompoundsLinkText;

	@FindBy(linkText = "Shovels & Scrapers")
	WebElement subCategoryShovelsScrapersLinkText;

	// Top Categories Bicycle Permits
	@FindBy(linkText = "Bicycle Permits")
	WebElement topCategoryBicyclePermitsLinkText;

	// Top Categories Parking Permits
	@FindBy(linkText = "Parking Permits")
	WebElement topCategoryParkingPermitsLinkText;

	//subcategories
	@FindBy(linkText = "Punch-Out Permits")
	WebElement subCategoryPunchOutPermitsLinkText;

	@FindBy(linkText = "Sticker Permits")
	WebElement subCategoryStickerPermitsLinkText;

	// Top Categories Valet Tickets
	@FindBy(linkText = "Valet Tickets")
	WebElement topCategoryValetTicketsLinkText;

	// Top Categories Traffic Control
	@FindBy(linkText = "Traffic Control")
	WebElement topCategoryTrafficControlLinkText;

	//subcategories
	@FindBy(linkText = "Violation Tags")
	WebElement subCategoryViolationTagsLinkText;

	@FindBy(linkText = "Tire Marking Chalk")
	WebElement subCategoryTireMarkingChalkLinkText;

	// Top Categories Traffic Safety Supplies
	@FindBy(linkText = "Traffic Safety Supplies")
	WebElement topCategoryTrafficSafetySuppliesLinkText;

	// Top Categories Parking Violations
	@FindBy(linkText = "Parking Violations")
	WebElement topCategoryParkingViolationsLinkText;

	//subcategories
	@FindBy(linkText = "Bollards & Sleeves")
	WebElement subCategoryBollardsSleevesLinkText;

	@FindBy(linkText = "Curb Stops")
	WebElement subCategoryCurbStopsLinkText;

	// Top Categories Asphalt Maintenance
	@FindBy(linkText = "Asphalt Maintenance")
	WebElement topCategoryAsphaltMaintenanceLinkText;

	//subcategories
	@FindBy(linkText = "Asphalt Patch")
	WebElement subCategoryAsphaltPatchLinkText;

	@FindBy(linkText = "Asphalt Sealers")
	WebElement subCategoryAsphaltSealersLinkText;

	// Top Categories Parking Lot Stencils
	@FindBy(linkText = "Parking Lot Stencils")
	WebElement topCategoryParkingLotStencilsLinkText;

	// Top Categories Dog Park Equipment
	@FindBy(linkText = "Dog Park Equipment")
	WebElement topCategoryDogParkEquipmentLinkText;

	// Top Categories Outdoor Recycling Containers & Lids
	@FindBy(linkText = "Outdoor Recycling Containers & Lids")
	WebElement topCategoryOutdoorRecyclingContainersLidsLinkText;

	// Top Categories Smoking Control
	@FindBy(linkText = "Smoking Control")
	WebElement topCategorySmokingControlLinkText;

	//Subcategories
	@FindBy(linkText = "Cigarette Receptacles")
	WebElement subCategoryCigaretteReceptaclesLinkText;

	@FindBy(linkText = "Tabletop Ashtrays")
	WebElement subCategoryTabletopAshtraysLinkText;	

	// Top Categories Outdoor Trash Receptacles
	@FindBy(linkText = "Outdoor Trash Receptacles")
	WebElement topCategoryOutdoorTrashReceptaclesLinkText;

	// Top Categories Pet Waste Stations & Bags
	@FindBy(linkText = "Pet Waste Stations & Bags")
	WebElement topCategoryPetWasteStationsBagsLinkText;
	//subcategories
	@FindBy(linkText = "Pet Waste Stations & Dispensers")
	WebElement subCategoryPetWasteStationsDispensersLinkText;

	@FindBy(linkText = "Pet Waste Tools")
	WebElement subCategoryPetWasteToolsLinkText;

	// Top Categories Planters
	@FindBy(linkText = "Planters")
	WebElement topCategoryPlantersLinkText;

	// Navigate to Previous Page
	public void navigateBackToPage() {

		driver.navigate().back();
	}

	// Method to Click on Outdoor Furniture in Top Categories
	public void clickTopCategoryOutdoorFurnitureLinkText() throws InterruptedException {

		waitTool.waitForElement(driver, topCategoryOutdoorFurnitureLinkText);
		topCategoryOutdoorFurnitureLinkText.click();
		driver.manage().timeouts().pageLoadTimeout(waitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}	
	// Method to Click on Pest Control in Top Categories
	public void clickTopCategoryPestControlLinkText() throws InterruptedException {

		waitTool.waitForElement(driver, topCategoryPestControlLinkText);
		topCategoryPestControlLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(waitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}	
	// Method to Click on Entrance Mats in Top Categories
	public void clickTopCategoryEntranceMatsLinkText() throws InterruptedException {

		waitTool.waitForElement(driver, topCategoryEntranceMatsLinkText);
		topCategoryEntranceMatsLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(waitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}	
	// Method to Click on Weed Control & Fertilizer in Top Categories
	public void clickTopCategoryWeedControlFertilizerLinkText() throws InterruptedException {

		waitTool.waitForElement(driver, topCategoryWeedControlFertilizerLinkText);
		topCategoryWeedControlFertilizerLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(waitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}	
	// Method to Click on Irrigation in Top Categories
	public void clickTopCategoryIrrigationLinkText() throws InterruptedException {

		waitTool.waitForElement(driver, topCategoryIrrigationLinkText);
		topCategoryIrrigationLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(waitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}	
	// Method to Click on Grills & Accessories in Top Categories
	public void clickTopCategoryGrillsAccessoriesLinkText() throws InterruptedException {

		waitTool.waitForElement(driver, topCategoryGrillsAccessoriesLinkText);
		topCategoryGrillsAccessoriesLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(waitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}	
	// Method to Click on Patio Heaters in Top Categories
	public void clickTopCategoryPatioHeatersLinkText() throws InterruptedException {

		waitTool.waitForElement(driver, topCategoryPatioHeatersLinkText);
		topCategoryPatioHeatersLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(waitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}	
	// Method to Click on Playground Equipment in Top Categories
	public void clickTopCategoryPlaygroundEquipmentLinkText() throws InterruptedException {

		waitTool.waitForElement(driver, topCategoryPlaygroundEquipmentLinkText);
		topCategoryPlaygroundEquipmentLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(waitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}	
	// Method to Click on Flags & Poles in Top Categories
	public void clickTopCategoryFlagsPolesLinkText() throws InterruptedException {

		waitTool.waitForElement(driver, topCategoryFlagsPolesLinkText);
		topCategoryFlagsPolesLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(waitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}	
	// Method to Click on Bicycle Racks in Top Categories
	public void clickTopCategoryBicycleRacksLinkText() throws InterruptedException {

		waitTool.waitForElement(driver, topCategoryBicycleRacksLinkText);
		topCategoryBicycleRacksLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(waitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}	
	// Method to Click on Outdoor Heating in Top Categories
	public void clickTopCategoryOutdoorHeatingLinkText() throws InterruptedException {

		waitTool.waitForElement(driver, topCategoryOutdoorHeatingLinkText);
		topCategoryOutdoorHeatingLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(waitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}	
	// Method to Click on Fencing in Top Categories
	public void clickTopCategoryFencingLinkText() throws InterruptedException {

		waitTool.waitForElement(driver, topCategoryFencingLinkText);
		topCategoryFencingLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(waitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}	
	// Method to Click on De-Icing Tools in Top Categories
	public void clickTopCategorDeIcingToolsLinkText() throws InterruptedException {

		waitTool.waitForElement(driver, topCategoryDeIcingToolsLinkText);
		topCategoryDeIcingToolsLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(waitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}	
	// Method to Click on Bicycle Permits in Top Categories
	public void clickTopCategorBicyclePermitsLinkText() throws InterruptedException {

		waitTool.waitForElement(driver, topCategoryBicyclePermitsLinkText);
		topCategoryBicyclePermitsLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(waitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}	
	// Method to Click on Parking Permits in Top Categories
	public void clickTopCategorParkingPermitsLinkText() throws InterruptedException {

		waitTool.waitForElement(driver, topCategoryParkingPermitsLinkText);
		topCategoryParkingPermitsLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(waitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}	
	// Method to Click on Valet Tickets in Top Categories
	public void clickTopCategorValetTicketsLinkText() throws InterruptedException {

		waitTool.waitForElement(driver, topCategoryValetTicketsLinkText);
		topCategoryValetTicketsLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(waitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}	
	// Method to Click on Traffic Control in Top Categories
	public void clickTopCategorTrafficControlLinkText() throws InterruptedException {

		waitTool.waitForElement(driver, topCategoryTrafficControlLinkText);
		topCategoryTrafficControlLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(waitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}	
	// Method to Click on Traffic Safety Supplies in Top Categories
	public void clickTopCategorTrafficSafetySuppliesLinkText() throws InterruptedException {

		waitTool.waitForElement(driver, topCategoryTrafficSafetySuppliesLinkText);
		topCategoryTrafficSafetySuppliesLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(waitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}	
	// Method to Click on Parking Violations in Top Categories
	public void clickTopCategorParkingViolationsLinkText() throws InterruptedException {

		waitTool.waitForElement(driver, topCategoryParkingViolationsLinkText);
		topCategoryParkingViolationsLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(waitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}	
	// Method to Click on Asphalt Maintenance in Top Categories
	public void clickTopCategorAsphaltMaintenanceLinkText() throws InterruptedException {

		waitTool.waitForElement(driver, topCategoryAsphaltMaintenanceLinkText);
		topCategoryAsphaltMaintenanceLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(waitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}	
	// Method to Click on Parking Lot Stencils in Top Categories
	public void clickTopCategorParkingLotStencilsLinkText() throws InterruptedException {

		waitTool.waitForElement(driver, topCategoryParkingLotStencilsLinkText);
		topCategoryParkingLotStencilsLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(waitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}	
	// Method to Click on Dog Park Equipment in Top Categories
	public void clickTopCategorDogParkEquipmentLinkText() throws InterruptedException {

		waitTool.waitForElement(driver, topCategoryDogParkEquipmentLinkText);
		topCategoryDogParkEquipmentLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(waitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}	
	// Method to Click on Outdoor Recycling Containers & Lids in Top Categories
	public void clickTopCategorOutdoorRecyclingContainersLidsLinkText() throws InterruptedException {

		waitTool.waitForElement(driver, topCategoryOutdoorRecyclingContainersLidsLinkText);
		topCategoryOutdoorRecyclingContainersLidsLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(waitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}	
	// Method to Click on Smoking Control in Top Categories
	public void clickTopCategorSmokingControlLinkText() throws InterruptedException {

		waitTool.waitForElement(driver, topCategorySmokingControlLinkText);
		topCategorySmokingControlLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(waitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}	
	// Method to Click on Outdoor Trash Receptacles in Top Categories
	public void clickTopCategorOutdoorTrashReceptaclesLinkText() throws InterruptedException {

		waitTool.waitForElement(driver, topCategoryOutdoorTrashReceptaclesLinkText);
		topCategoryOutdoorTrashReceptaclesLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(waitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}	
	// Method to Click on Pet Waste Stations & Bags in Top Categories
	public void clickTopCategorPetWasteStationsBagsLinkText() throws InterruptedException {

		waitTool.waitForElement(driver, topCategoryPetWasteStationsBagsLinkText);
		topCategoryPetWasteStationsBagsLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(waitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}	
	// Method to Click on Planters in Top Categories
	public void clickTopCategorPlantersLinkText() throws InterruptedException {

		waitTool.waitForElement(driver, topCategoryPlantersLinkText);
		topCategoryPlantersLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(waitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}	

	//Methods to click on sub categories under category - grounds.=======================================
	/*
		public void clickSubPatioCushionsLinkText() throws InterruptedException {

				waitTool.waitForElement(driver, subCategoryPatioCushionsLinkText);
				subCategoryPatioCushionsLinkText.click();

				driver.manage().timeouts().pageLoadTimeout(waitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

			}*/

	/*public void clickSubTablesChairsLinkText() throws InterruptedException {

				waitTool.waitForElement(driver, subCategoryTablesChairsLinkText);
				subCategoryTablesChairsLinkText.click();

				driver.manage().timeouts().pageLoadTimeout(waitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

			}*/

	public void clickSubAnimalTrapsLinkText() throws InterruptedException {

		waitTool.waitForElement(driver, subCategoryAnimalTrapsLinkText);
		subCategoryAnimalTrapsLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(waitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}

	public void clickSubyPesticidesPoisonsLinkText() throws InterruptedException {

		waitTool.waitForElement(driver, subCategoryPesticidesPoisonsLinkText);
		subCategoryPesticidesPoisonsLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(waitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}

	public void clickSubIndoorScraperMatsLinkText() throws InterruptedException {

		waitTool.waitForElement(driver, subCategoryIndoorScraperMatsLinkText);
		subCategoryIndoorScraperMatsLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(waitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}

	public void clickSubWeedControlLinkText() throws InterruptedException {

		waitTool.waitForElement(driver, subCategoryWeedControlLinkText);
		subCategoryWeedControlLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(waitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}

	public void clickSubGardenHosesAccessoriesLinkText() throws InterruptedException {

		waitTool.waitForElement(driver, subCategoryGardenHosesAccessoriesLinkText);
		subCategoryGardenHosesAccessoriesLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(waitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}

	public void clickSubPlantFoodFertilizerLinkText() throws InterruptedException {

		waitTool.waitForElement(driver, subCategoryPlantFoodFertilizerLinkText);
		subCategoryPlantFoodFertilizerLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(waitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}


	public void clickSubGrillAccessoriesLinkText() throws InterruptedException {

		waitTool.waitForElement(driver, subCategoryGrillAccessoriesLinkText);
		subCategoryGrillAccessoriesLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(waitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}

	public void clickSubGrillsLinkText() throws InterruptedException {

		waitTool.waitForElement(driver, subCategoryGrillsLinkText);
		subCategoryGrillsLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(waitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}

	public void clickSubFlagCasesLinkText() throws InterruptedException {

		waitTool.waitForElement(driver,	subCategoryFlagCasesLinkText);
		subCategoryFlagCasesLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(waitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}

	public void clickSubReligiousFlagsLinkText() throws InterruptedException {

		waitTool.waitForElement(driver,	subCategoryReligiousFlagsLinkText);
		subCategoryReligiousFlagsLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(waitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}

	public void clickSubFirePitsCoversLinkText() throws InterruptedException {

		waitTool.waitForElement(driver,	subCategoryFirePitsCoversLinkText);
		subCategoryFirePitsCoversLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(waitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}

	public void clickSubPatioHeatersCoverLinkText() throws InterruptedException {

		waitTool.waitForElement(driver,	subCategoryPatioHeatersCoversLinkText);
		subCategoryPatioHeatersCoversLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(waitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}


	public void clickSubIceMeltingCompoundLinkText() throws InterruptedException {

		waitTool.waitForElement(driver,	subCategoryIceMeltingCompoundsLinkText);
		subCategoryIceMeltingCompoundsLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(waitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}

	public void clickSubShovelsScrapersLinkText() throws InterruptedException {

		waitTool.waitForElement(driver,	subCategoryShovelsScrapersLinkText);
		subCategoryShovelsScrapersLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(waitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}

	public void clickSubPunchOutPermitsLinkText() throws InterruptedException {

		waitTool.waitForElement(driver,	subCategoryPunchOutPermitsLinkText);
		subCategoryPunchOutPermitsLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(waitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}

	public void clickSubStickerPermitsLinkText() throws InterruptedException {

		waitTool.waitForElement(driver,	subCategoryStickerPermitsLinkText);
		subCategoryStickerPermitsLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(waitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}

	public void clickSubViolationTagsLinkText() throws InterruptedException {

		waitTool.waitForElement(driver,	subCategoryViolationTagsLinkText);
		subCategoryViolationTagsLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(waitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}


	public void clickSubTireMarkingChalkLinkText() throws InterruptedException {

		waitTool.waitForElement(driver,	subCategoryTireMarkingChalkLinkText);
		subCategoryTireMarkingChalkLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(waitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}

	public void clickSubBollardsSleevesLinkText() throws InterruptedException {

		waitTool.waitForElement(driver,	subCategoryBollardsSleevesLinkText);
		subCategoryBollardsSleevesLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(waitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}

	public void clickSubCurbStopsLinkText() throws InterruptedException {

		waitTool.waitForElement(driver,	subCategoryCurbStopsLinkText);
		subCategoryCurbStopsLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(waitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}


	public void clickSubAsphaltPatchLinkText() throws InterruptedException {

		waitTool.waitForElement(driver,	subCategoryAsphaltPatchLinkText);
		subCategoryAsphaltPatchLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(waitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}

	public void clickSubAsphaltSealersLinkText() throws InterruptedException {

		waitTool.waitForElement(driver,	subCategoryAsphaltSealersLinkText);
		subCategoryAsphaltSealersLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(waitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}


	public void clickSubCigaretteReceptaclesLinkText() throws InterruptedException {

		waitTool.waitForElement(driver,	subCategoryCigaretteReceptaclesLinkText);
		subCategoryCigaretteReceptaclesLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(waitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}

	public void clickSubTabletopAshtraysLinkText() throws InterruptedException {		 
		waitTool.waitForElement(driver,	subCategoryTabletopAshtraysLinkText);
		subCategoryTabletopAshtraysLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(waitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}

	public void clickSubPetWasteStationsDispensersLinkText() throws InterruptedException {

		waitTool.waitForElement(driver,	subCategoryPetWasteStationsDispensersLinkText);
		subCategoryPetWasteStationsDispensersLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(waitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}

	public void clickSubPetWasteToolsLinkText() throws InterruptedException {

		waitTool.waitForElement(driver,	subCategoryPetWasteToolsLinkText);
		subCategoryPetWasteToolsLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(waitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}

}




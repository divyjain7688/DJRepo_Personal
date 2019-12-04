package com.selenium.ebiz.pageobject;

import com.selenium.ebiz.tools.WaitTool;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SubCategoryElectricalPage {

	private  WebDriver driver; private WaitTool   waitTool;

	public SubCategoryElectricalPage(WebDriver driver) 	{
		this.driver = driver;  this.waitTool = new WaitTool();
		PageFactory.initElements(driver, this);
		//WebDriverWait wait = new WebDriverWait(driver, 25);
		//wait.until(ExpectedConditions.visibilityOf(subCategoryFloorBoxesLinkText));	
	}
	
	// This is for Part Number Search Page
	@FindBy(xpath = "//div[@class='subcat-grid-tile__header type--caption input-group compare_target']/span")
	public WebElement searchPartNumberText;
	
	// Sub Categories Floor Boxes
	@FindBy(linkText = "Floor Boxes")
	WebElement subCategoryFloorBoxesLinkText;

	// Sub Categories Electrical Boxes
	@FindBy(linkText = "Electrical Boxes")
	WebElement subCategoryElectricalBoxesLinkText;

	// Sub Categories Fuse Pullers
	@FindBy(linkText = "Fuse Pullers")
	WebElement subCategoryFusePullersLinkText;

	// Sub Categories Insulated & Voltage Sensing Hand Tools
	@FindBy(linkText = "Insulated & Voltage Sensing Hand Tools")
	WebElement subCategoryInsulatedVoltageSensingHandToolsLinkText;

	// Sub Categories Combination Smoke & CO Alarms
	@FindBy(linkText = "Combination Smoke & CO Alarms")
	WebElement subCategoryCombinationSmokeCOAlarmsLinkText;

	// Sub Categories Fire Alarms & Accessories
	@FindBy(linkText = "Fire Alarms & Accessories")
	WebElement subCategoryFireAlarmsAccessoriesLinkText;

	// Sub Categories Recycling Kits
	@FindBy(linkText = "Recycling Kits")
	WebElement subCategoryRecyclingKitsLinkText;

	// Sub Categories AAAA Batteries
	@FindBy(linkText = "AAAA Batteries")
	WebElement subCategoryAAAABatteriesLinkText;

	// Sub Categories Extension Cords
	@FindBy(linkText = "Extension Cords")
	WebElement subCategoryExtensionCordsLinkText;

	// Sub Categories Power Adapters
	@FindBy(linkText = "Power Adapters")
	WebElement subCategoryPowerAdaptersLinkText;

	// Sub Categories Timers
	@FindBy(linkText = "Timers")
	WebElement subCategoryTimersLinkText;

	// Sub Categories Timer Accessories
	@FindBy(linkText = "Timer Accessories")
	WebElement subCategoryTimerAccessoriesLinkText;

	// Sub Categories Receptacle Plates
	@FindBy(linkText = "Receptacle Plates")
	WebElement subCategoryReceptaclePlatesLinkText;

	// Sub Categories Speciality Plates
	@FindBy(linkText = "Speciality Plates")
	WebElement subCategorySpecialityPlatesLinkText;

	// Sub Categories Switches
	@FindBy(linkText = "Switches")
	WebElement subCategorySwitchesLinkText;

	// Sub Categories Wall Outlets
	@FindBy(linkText = "Wall Outlets")
	WebElement subCategoryWallOutletsLinkText;

	// Sub Categories Electrical Tape
	@FindBy(linkText = "Electrical Tape")
	WebElement subCategoryElectricalTapeLinkText;

	// Sub Categories Electrical Wire
	@FindBy(linkText = "Electrical Wire")
	WebElement subCategoryElectricalWireLinkText;

	// Sub Categories Phone Chargers
	@FindBy(linkText = "Phone Chargers")
	WebElement subCategoryPhoneChargersLinkText;

	// Sub Categories Power Stations
	@FindBy(linkText = "Power Stations")
	WebElement subCategoryPowerStationsLinkText;

	// Sub Categories Fuses
	@FindBy(linkText = "Fuses")
	WebElement subCategoryFusesLinkText;

	// Sub Categories Load Centers
	@FindBy(linkText = "Load Centers")
	WebElement subCategoryLoadCentersLinkText;

	// Sub Categories Raceway
	@FindBy(linkText = "Raceway")
	WebElement subCategoryRacewayLinkText;

	// Sub Categories Conduit
	@FindBy(linkText = "Conduit")
	WebElement subCategoryConduitLinkText;

	// Sub Categories Door Chimes
	@FindBy(linkText = "Door Chimes")
	WebElement subCategoryDoorChimesLinkText;

	// Sub Categories Intercom Systems & Accessories
	@FindBy(linkText = "Intercom Systems & Accessories")
	WebElement subCategoryIntercomSystemsAccessoriesLinkText;

	// Method to Click on Intercom Systems & Accessories in Sub Categories	
	public void clickSubCategoryIntercomSystemsAccessoriesLinkText() throws InterruptedException {
		 	waitTool.waitForElement(driver, subCategoryIntercomSystemsAccessoriesLinkText);
			subCategoryIntercomSystemsAccessoriesLinkText.click();
			waitTool.waitFor(driver,true) ;
			
		}
	
	// Method to Click on Door Chimes in Sub Categories	
	public void clickSubCategoryDoorChimesLinkText() throws InterruptedException {
			waitTool.waitForElement(driver, subCategoryDoorChimesLinkText);
			subCategoryDoorChimesLinkText.click();
			waitTool.waitFor(driver,true) ;
			
		}
	
	// Method to Click on Conduit in Sub Categories	
	public void clickSubCategoryConduitLinkText() throws InterruptedException {
			waitTool.waitForElement(driver, subCategoryConduitLinkText);
			subCategoryConduitLinkText.click();
			waitTool.waitFor(driver,true) ;
			
		}
	
	// Method to Click on Raceway in Sub Categories	
	public void clickSubCategoryRacewayLinkText() throws InterruptedException {
			waitTool.waitForElement(driver, subCategoryRacewayLinkText);
			subCategoryRacewayLinkText.click();
			waitTool.waitFor(driver,true) ;
			
		}
	
	// Method to Click on Load Centers in Sub Categories	
	public void clickSubCategoryLoadCentersLinkText() throws InterruptedException {
			waitTool.waitForElement(driver, subCategoryLoadCentersLinkText);
			subCategoryLoadCentersLinkText.click();
			waitTool.waitFor(driver,true) ;
			
		}
	
	// Method to Click on Fuses in Sub Categories	
	public void clickSubCategoryFusesLinkText() throws InterruptedException {
			waitTool.waitForElement(driver, subCategoryFusesLinkText);
			subCategoryFusesLinkText.click();
			waitTool.waitFor(driver,true) ;
			
		}

	// Method to Click on Power Stations in Sub Categories	
	public void clickSubCategoryPowerStationsLinkText() throws InterruptedException {
			waitTool.waitForElement(driver, subCategoryPowerStationsLinkText);
			subCategoryPowerStationsLinkText.click();
			waitTool.waitFor(driver,true) ;
			
		}
	
	// Method to Click on Phone Chargers in Sub Categories	
	public void clickSubCategoryPhoneChargersLinkText() throws InterruptedException {
			waitTool.waitForElement(driver, subCategoryPhoneChargersLinkText);
			subCategoryPhoneChargersLinkText.click();
			waitTool.waitFor(driver,true) ;
			
		}

	// Method to Click on Electrical Wire in Sub Categories	
	public void clickSubCategoryElectricalWireLinkText() throws InterruptedException {
			waitTool.waitForElement(driver, subCategoryElectricalWireLinkText);
			subCategoryElectricalWireLinkText.click();
			waitTool.waitFor(driver,true) ;
			
		}
	
	// Method to Click on Electrical Tape in Sub Categories	
	public void clickSubCategoryElectricalTapeLinkText() throws InterruptedException {
			waitTool.waitForElement(driver, subCategoryElectricalTapeLinkText);
			subCategoryElectricalTapeLinkText.click();
			waitTool.waitFor(driver,true) ;
			
		}
	
	// Method to Click on Wall Outlets in Sub Categories	
	public void clickSubCategoryWallOutletsLinkText() throws InterruptedException {
			waitTool.waitForElement(driver, subCategoryWallOutletsLinkText);
			subCategoryWallOutletsLinkText.click();
			waitTool.waitFor(driver,true) ;
			
		}
	
	// Method to Click on Switches in Sub Categories	
	public void clickSubCategorySwitchesLinkText() throws InterruptedException {
			waitTool.waitForElement(driver, subCategorySwitchesLinkText);
			subCategorySwitchesLinkText.click();
			waitTool.waitFor(driver,true) ;
			
		}
	
	// Method to Click on Speciality Plates in Sub Categories	
	public void clickSubCategorySpecialityPlatesLinkText() throws InterruptedException {
			waitTool.waitForElement(driver, subCategorySpecialityPlatesLinkText);
			subCategorySpecialityPlatesLinkText.click();
			waitTool.waitFor(driver,true) ;
			
		}
	
	// Method to Click on Receptacle Plates in Sub Categories	
	public void clickSubCategoryReceptaclePlatesLinkText() throws InterruptedException {
			waitTool.waitForElement(driver, subCategoryReceptaclePlatesLinkText);
			subCategoryReceptaclePlatesLinkText.click();
			waitTool.waitFor(driver,true) ;
			
		}
	
	// Method to Click on Timer Accessories in Sub Categories	
	public void clickSubCategoryTimerAccessoriesLinkText() throws InterruptedException {
			waitTool.waitForElement(driver, subCategoryTimerAccessoriesLinkText);
			subCategoryTimerAccessoriesLinkText.click();
			waitTool.waitFor(driver,true) ;
			
		}

	
	// Method to Click on Timers in Sub Categories	
	public void clickSubCategoryTimersLinkText() throws InterruptedException {
			waitTool.waitForElement(driver, subCategoryTimersLinkText);
			subCategoryTimersLinkText.click();
			waitTool.waitFor(driver,true) ;
			
		}
	
	// Method to Click on Power Adapters in Sub Categories	
	public void clickSubCategoryPowerAdaptersLinkText() throws InterruptedException {
			waitTool.waitForElement(driver, subCategoryPowerAdaptersLinkText);
			subCategoryPowerAdaptersLinkText.click();
			waitTool.waitFor(driver,true) ;
			
		}

	// Method to Click on Extension Cords in Sub Categories	
	public void clickSubCategoryExtensionCordsLinkText() throws InterruptedException {
			waitTool.waitForElement(driver, subCategoryExtensionCordsLinkText);
			subCategoryExtensionCordsLinkText.click();
			waitTool.waitFor(driver,true) ;
			
		}
	
	// Method to Click on AAAA Batteries in Sub Categories	
	public void clickSubCategoryAAAABatteriesLinkText() throws InterruptedException {
			waitTool.waitForElement(driver, subCategoryAAAABatteriesLinkText);
			subCategoryAAAABatteriesLinkText.click();
			waitTool.waitFor(driver,true) ;
			
		}
	
	// Method to Click on Recycling Kits in Sub Categories	
	public void clickSubCategoryRecyclingKitsLinkText() throws InterruptedException {
			waitTool.waitForElement(driver, subCategoryRecyclingKitsLinkText);
			subCategoryRecyclingKitsLinkText.click();
			waitTool.waitFor(driver,true) ;
			
		}
	
	// Method to Click on Fire Alarms & Accessories in Sub Categories	
	public void clickSubCategoryFireAlarmsAccessoriesLinkText() throws InterruptedException {
			waitTool.waitForElement(driver, subCategoryFireAlarmsAccessoriesLinkText);
			subCategoryFireAlarmsAccessoriesLinkText.click();
			waitTool.waitFor(driver,true) ;
			
		}
	
	// Method to Click on Combination Smoke & CO Alarms in Sub Categories	
	public void clickSubCategoryCombinationSmokeCOAlarmsLinkText() throws InterruptedException {
			waitTool.waitForElement(driver, subCategoryCombinationSmokeCOAlarmsLinkText);
			subCategoryCombinationSmokeCOAlarmsLinkText.click();
			waitTool.waitFor(driver,true) ;
			
		}
	
	// Method to Click on Insulated & Voltage Sensing Hand Tools in Sub Categories	
	public void clickSubCategoryInsulatedVoltageSensingHandToolsLinkText() throws InterruptedException {
			waitTool.waitForElement(driver, subCategoryInsulatedVoltageSensingHandToolsLinkText);
			subCategoryInsulatedVoltageSensingHandToolsLinkText.click();
			waitTool.waitFor(driver,true) ;
			
		}
	
	
	// Method to Click on Fuse Pullers in Sub Categories	
	public void clickSubCategoryFusePullersLinkText() throws InterruptedException {
			waitTool.waitForElement(driver, subCategoryFusePullersLinkText);
			subCategoryFusePullersLinkText.click();
			waitTool.waitFor(driver,true) ;
			
		}
	
	
	// Method to Click on Electrical Boxes in Sub Categories	
	public void clickSubCategoryElectricalBoxesLinkText() throws InterruptedException {
			waitTool.waitForElement(driver, subCategoryElectricalBoxesLinkText);
			subCategoryElectricalBoxesLinkText.click();
			waitTool.waitFor(driver,true) ;
			
		}
	
	// Method to Click on Floor Boxes in Sub Categories	
	public void clickSubCategoryFloorBoxesLinkText() throws InterruptedException {
			waitTool.waitForElement(driver, subCategoryFloorBoxesLinkText);
			subCategoryFloorBoxesLinkText.click();
			waitTool.waitFor(driver,true) ;
			
		}
	
	// Method to get Searched Part Numbers
/*	public String getSearchPartNumberText() throws InterruptedException {
		return searchPartNumberText.getText().trim();
	}
	*/
	
}

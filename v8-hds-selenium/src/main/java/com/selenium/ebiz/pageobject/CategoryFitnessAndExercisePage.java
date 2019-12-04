package com.selenium.ebiz.pageobject;

import com.selenium.ebiz.tools.WaitTool;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CategoryFitnessAndExercisePage{

	private  WebDriver driver; private WaitTool   waitTool;

	public CategoryFitnessAndExercisePage(WebDriver driver) 	{
		this.driver = driver;  this.waitTool = new WaitTool();
		PageFactory.initElements(driver, this);
		
	}
	
	// Top Categories Fitness Accessories
	@FindBy(linkText = "Fitness Accessories")
	WebElement topCategoryFitnessAccessoriesLinkText;
	
	// Top Categories Fitness Equipment
	@FindBy(linkText = "Fitness Equipment")
	WebElement topCategoryFitnessEquipmentLinkText;

	// Top Categories Physical Therapy Equipment
	@FindBy(linkText = "Physical Therapy Equipment")
	WebElement topCategoryPhysicalTherapyEquipmentLinkText;

	// Top Categories Weights & Storage
	@FindBy(linkText = "Weights & Storage")
	WebElement topCategoryWeightsStorageLinkText;

	// Top Categories Cleaning Supplies
	@FindBy(linkText = "Cleaning Supplies")
	WebElement topCategoryCleaningSuppliesLinkText;

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

	
	// To Navigate to back Page
		public void navigateBackToPage() {
			driver.navigate().back();
		}

		// Method to Click on Dishwashers Repair in Top Categories	
		public SubCategoryFitnessExercisePage clickTopCategoryFitnessAccessoriesLinkText() throws InterruptedException {
				waitTool.waitForElement(driver, topCategoryFitnessAccessoriesLinkText);
				topCategoryFitnessAccessoriesLinkText.click();
				waitTool.waitFor(driver,true) ;
				return new SubCategoryFitnessExercisePage(driver);
			}
		// Method to Click on Fitness Equipment in Top Categories	
		public SubCategoryFitnessExercisePage clickTopCategoryFitnessEquipmentLinkText() throws InterruptedException {
				waitTool.waitForElement(driver, topCategoryFitnessEquipmentLinkText);
				topCategoryFitnessEquipmentLinkText.click();
				waitTool.waitFor(driver,true) ;
				return new SubCategoryFitnessExercisePage(driver);
			}
		// Method to Click on Physical Therapy Equipment in Top Categories	
		public SubCategoryFitnessExercisePage clickTopCategoryPhysicalTherapyEquipmentLinkText() throws InterruptedException {
				waitTool.waitForElement(driver, topCategoryPhysicalTherapyEquipmentLinkText);
				topCategoryPhysicalTherapyEquipmentLinkText.click();
				waitTool.waitFor(driver,true) ;
				return new SubCategoryFitnessExercisePage(driver);
			}
		// Method to Click on Weights & Storage in Top Categories	
		public SubCategoryFitnessExercisePage clickTopCategoryWeightsStorageLinkText() throws InterruptedException {
				waitTool.waitForElement(driver, topCategoryWeightsStorageLinkText);
				topCategoryWeightsStorageLinkText.click();
				waitTool.waitFor(driver,true) ;
				return new SubCategoryFitnessExercisePage(driver);
			}
		// Method to Click on Cleaning Supplies in Top Categories	
		public SubCategoryFitnessExercisePage clickTopCategoryCleaningSuppliesLinkText() throws InterruptedException {
				waitTool.waitForElement(driver, topCategoryCleaningSuppliesLinkText);
				topCategoryCleaningSuppliesLinkText.click();
				waitTool.waitFor(driver,true) ;
				return new SubCategoryFitnessExercisePage(driver);
			}
		// Method to Click on home in Top Categories	
		public SubCategoryFitnessExercisePage clickCategoryHomeLinkText() throws InterruptedException {
				waitTool.waitForElement(driver, categoryHomeLinkText);
				categoryHomeLinkText.click();
				waitTool.waitFor(driver,true) ;
				return new SubCategoryFitnessExercisePage(driver);
			}		

}

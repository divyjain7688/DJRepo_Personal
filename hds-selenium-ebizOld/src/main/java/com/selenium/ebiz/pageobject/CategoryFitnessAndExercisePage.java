package com.selenium.ebiz.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.selenium.ebiz.baseclass.BaseClass;
import com.selenium.ebiz.tools.WaitTool;

public class CategoryFitnessAndExercisePage extends BaseClass{

	WebDriver driver;
	public CategoryFitnessAndExercisePage(WebDriver driver) 	{
		this.driver = driver;
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
				WaitTool.waitForElement(driver, topCategoryFitnessAccessoriesLinkText);
				topCategoryFitnessAccessoriesLinkText.click();
				WaitTool.waitFor(driver,true) ;
				return new SubCategoryFitnessExercisePage(driver);
			}
		// Method to Click on Fitness Equipment in Top Categories	
		public SubCategoryFitnessExercisePage clickTopCategoryFitnessEquipmentLinkText() throws InterruptedException {
				WaitTool.waitForElement(driver, topCategoryFitnessEquipmentLinkText);
				topCategoryFitnessEquipmentLinkText.click();
				WaitTool.waitFor(driver,true) ;
				return new SubCategoryFitnessExercisePage(driver);
			}
		// Method to Click on Physical Therapy Equipment in Top Categories	
		public SubCategoryFitnessExercisePage clickTopCategoryPhysicalTherapyEquipmentLinkText() throws InterruptedException {
				WaitTool.waitForElement(driver, topCategoryPhysicalTherapyEquipmentLinkText);
				topCategoryPhysicalTherapyEquipmentLinkText.click();
				WaitTool.waitFor(driver,true) ;
				return new SubCategoryFitnessExercisePage(driver);
			}
		// Method to Click on Weights & Storage in Top Categories	
		public SubCategoryFitnessExercisePage clickTopCategoryWeightsStorageLinkText() throws InterruptedException {
				WaitTool.waitForElement(driver, topCategoryWeightsStorageLinkText);
				topCategoryWeightsStorageLinkText.click();
				WaitTool.waitFor(driver,true) ;
				return new SubCategoryFitnessExercisePage(driver);
			}
		// Method to Click on Cleaning Supplies in Top Categories	
		public SubCategoryFitnessExercisePage clickTopCategoryCleaningSuppliesLinkText() throws InterruptedException {
				WaitTool.waitForElement(driver, topCategoryCleaningSuppliesLinkText);
				topCategoryCleaningSuppliesLinkText.click();
				WaitTool.waitFor(driver,true) ;
				return new SubCategoryFitnessExercisePage(driver);
			}
		// Method to Click on home in Top Categories	
		public SubCategoryFitnessExercisePage clickCategoryHomeLinkText() throws InterruptedException {
				WaitTool.waitForElement(driver, categoryHomeLinkText);
				categoryHomeLinkText.click();
				WaitTool.waitFor(driver,true) ;
				return new SubCategoryFitnessExercisePage(driver);
			}		

}

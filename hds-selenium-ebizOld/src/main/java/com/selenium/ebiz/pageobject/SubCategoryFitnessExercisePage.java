package com.selenium.ebiz.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.selenium.ebiz.baseclass.BaseClass;
import com.selenium.ebiz.tools.WaitTool;

public class SubCategoryFitnessExercisePage extends BaseClass{

	public SubCategoryFitnessExercisePage(WebDriver driver) 	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		//WebDriverWait wait = new WebDriverWait(driver, 25);
		
	}
	
	// Sub Categories Exercise Bars
	@FindBy(linkText = "Exercise Bars")
	WebElement subCategoryExerciseBarsLinkText;

	// Sub Categories Hand Exercisers
	@FindBy(linkText = "Hand Exercisers")
	WebElement subCategoryHandExercisersLinkText;

	// Sub Categories Bikes & Pedal Exercisers
	@FindBy(linkText = "Bikes & Pedal Exercisers")
	WebElement subCategoryBikesPedalExercisersLinkText;

	// Sub Categories Ellipticals
	@FindBy(linkText = "Ellipticals")
	WebElement subCategoryEllipticalsLinkText;

	// Sub Categories Gait Belts
	@FindBy(linkText = "Gait Belts")
	WebElement subCategoryGaitBeltsLinkText;

	// Sub Categories Mat Platforms
	@FindBy(linkText = "Mat Platforms")
	WebElement subCategoryMatPlatformsLinkText;

	// Sub Categories Hand Weights
	@FindBy(linkText = "Hand Weights")
	WebElement subCategoryHandWeightsLinkText;

	// Sub Categories Weight Bars
	@FindBy(linkText = "Weight Bars")
	WebElement subCategoryWeightBarsLinkText;

	// Method to Click on Weight Bars in Sub Categories	
	public void clickSubCategoryWeightBarsLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryWeightBarsLinkText);
			subCategoryWeightBarsLinkText.click();
			WaitTool.waitFor(driver,true) ;
			
		}

	// Method to Click on Hand Weights in Sub Categories	
	public void clickSubCategoryHandWeightsLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryHandWeightsLinkText);
			subCategoryHandWeightsLinkText.click();
			WaitTool.waitFor(driver,true) ;
			
		}
	
	// Method to Click on Mat Platforms in Sub Categories	
	public void clickSubCategoryMatPlatformsLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryMatPlatformsLinkText);
			subCategoryMatPlatformsLinkText.click();
			WaitTool.waitFor(driver,true) ;
			
		}

	// Method to Click on Gait Belts in Sub Categories	
	public void clickSubCategoryGaitBeltsLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryGaitBeltsLinkText);
			subCategoryGaitBeltsLinkText.click();
			WaitTool.waitFor(driver,true) ;
			
		}

	// Method to Click on Ellipticals in Sub Categories	
	public void clickSubCategoryEllipticalsLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryEllipticalsLinkText);
			subCategoryEllipticalsLinkText.click();
			WaitTool.waitFor(driver,true) ;
			
		}

	// Method to Click on Bikes & Pedal Exercisers in Sub Categories	
	public void clickSubCategoryBikesPedalExercisersLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryBikesPedalExercisersLinkText);
			subCategoryBikesPedalExercisersLinkText.click();
			WaitTool.waitFor(driver,true) ;
			
		}
	
	// Method to Click on Hand Exercisers in Sub Categories	
	public void clickSubCategoryHandExercisersLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryHandExercisersLinkText);
			subCategoryHandExercisersLinkText.click();
			WaitTool.waitFor(driver,true) ;
			
		}
	
	// Method to Click on Exercise Bars in Sub Categories	
	public void clickSubCategoryExerciseBarsLinkText() throws InterruptedException {
			WaitTool.waitForElement(driver, subCategoryExerciseBarsLinkText);
			subCategoryExerciseBarsLinkText.click();
			WaitTool.waitFor(driver,true) ;
			
		}
	

	
}

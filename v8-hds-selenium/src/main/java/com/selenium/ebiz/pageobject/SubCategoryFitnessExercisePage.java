package com.selenium.ebiz.pageobject;

import com.selenium.ebiz.tools.WaitTool;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SubCategoryFitnessExercisePage {

	private  WebDriver driver; private WaitTool   waitTool;

	public SubCategoryFitnessExercisePage(WebDriver driver) 	{
		this.driver = driver;  this.waitTool = new WaitTool();
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
			waitTool.waitForElement(driver, subCategoryWeightBarsLinkText);
			subCategoryWeightBarsLinkText.click();
			waitTool.waitFor(driver,true) ;
			
		}

	// Method to Click on Hand Weights in Sub Categories	
	public void clickSubCategoryHandWeightsLinkText() throws InterruptedException {
			waitTool.waitForElement(driver, subCategoryHandWeightsLinkText);
			subCategoryHandWeightsLinkText.click();
			waitTool.waitFor(driver,true) ;
			
		}
	
	// Method to Click on Mat Platforms in Sub Categories	
	public void clickSubCategoryMatPlatformsLinkText() throws InterruptedException {
			waitTool.waitForElement(driver, subCategoryMatPlatformsLinkText);
			subCategoryMatPlatformsLinkText.click();
			waitTool.waitFor(driver,true) ;
			
		}

	// Method to Click on Gait Belts in Sub Categories	
	public void clickSubCategoryGaitBeltsLinkText() throws InterruptedException {
			waitTool.waitForElement(driver, subCategoryGaitBeltsLinkText);
			subCategoryGaitBeltsLinkText.click();
			waitTool.waitFor(driver,true) ;
			
		}

	// Method to Click on Ellipticals in Sub Categories	
	public void clickSubCategoryEllipticalsLinkText() throws InterruptedException {
			waitTool.waitForElement(driver, subCategoryEllipticalsLinkText);
			subCategoryEllipticalsLinkText.click();
			waitTool.waitFor(driver,true) ;
			
		}

	// Method to Click on Bikes & Pedal Exercisers in Sub Categories	
	public void clickSubCategoryBikesPedalExercisersLinkText() throws InterruptedException {
			waitTool.waitForElement(driver, subCategoryBikesPedalExercisersLinkText);
			subCategoryBikesPedalExercisersLinkText.click();
			waitTool.waitFor(driver,true) ;
			
		}
	
	// Method to Click on Hand Exercisers in Sub Categories	
	public void clickSubCategoryHandExercisersLinkText() throws InterruptedException {
			waitTool.waitForElement(driver, subCategoryHandExercisersLinkText);
			subCategoryHandExercisersLinkText.click();
			waitTool.waitFor(driver,true) ;
			
		}
	
	// Method to Click on Exercise Bars in Sub Categories	
	public void clickSubCategoryExerciseBarsLinkText() throws InterruptedException {
			waitTool.waitForElement(driver, subCategoryExerciseBarsLinkText);
			subCategoryExerciseBarsLinkText.click();
			waitTool.waitFor(driver,true) ;
			
		}
	

	
}

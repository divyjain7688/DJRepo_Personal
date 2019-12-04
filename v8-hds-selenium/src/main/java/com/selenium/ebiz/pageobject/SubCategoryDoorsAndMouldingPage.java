package com.selenium.ebiz.pageobject;

import com.selenium.ebiz.tools.WaitTool;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SubCategoryDoorsAndMouldingPage {
	private  WebDriver driver; private WaitTool   waitTool;

	public SubCategoryDoorsAndMouldingPage(WebDriver driver) 	{
		this.driver = driver;  this.waitTool = new WaitTool();
		PageFactory.initElements(driver, this);
		//WebDriverWait wait = new WebDriverWait(driver, 25);
	}
	
// Sub Categories Interior
@FindBy(linkText = "Interior")
WebElement subCategoryInteriorLinkText;

// Sub Categories Exterior
@FindBy(linkText = "Exterior")
WebElement subCategoryExteriorLinkText;

// Sub Categories Casing
@FindBy(linkText = "Casing")
WebElement subCategoryCasingLinkText;

// Sub Categories Closet Rods
@FindBy(linkText = "Closet Rods")
WebElement subCategoryClosetRodsLinkText;

// Method to Click on Closet Rods in Sub Categories	
public void clickSubCategoryClosetRodsLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, subCategoryClosetRodsLinkText);
		subCategoryClosetRodsLinkText.click();
		waitTool.waitFor(driver,true) ;
}

// Method to Click on Casing in Sub Categories	
public void clickSubCategoryCasingLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, subCategoryCasingLinkText);
		subCategoryCasingLinkText.click();	
		waitTool.waitFor(driver,true) ;
}

// Method to Click on Exterior in Sub Categories	
public void clickSubCategoryExteriorLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, subCategoryExteriorLinkText);
		subCategoryExteriorLinkText.click();
		waitTool.waitFor(driver,true) ;

}

// Method to Click on Interior in Sub Categories	
public void clickSubCategoryInteriorLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, subCategoryInteriorLinkText);
		subCategoryInteriorLinkText.click();
		waitTool.waitFor(driver,true) ;

}


}

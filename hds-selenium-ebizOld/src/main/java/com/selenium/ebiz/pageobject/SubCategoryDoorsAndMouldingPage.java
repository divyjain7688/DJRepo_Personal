package com.selenium.ebiz.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.selenium.ebiz.baseclass.BaseClass;
import com.selenium.ebiz.tools.WaitTool;

public class SubCategoryDoorsAndMouldingPage extends BaseClass{

	public SubCategoryDoorsAndMouldingPage(WebDriver driver) 	{
		this.driver = driver;
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
		WaitTool.waitForElement(driver, subCategoryClosetRodsLinkText);
		subCategoryClosetRodsLinkText.click();
		WaitTool.waitFor(driver,true) ;

}

// Method to Click on Casing in Sub Categories	
public void clickSubCategoryCasingLinkText() throws InterruptedException {
		WaitTool.waitForElement(driver, subCategoryCasingLinkText);
		subCategoryCasingLinkText.click();	
		WaitTool.waitFor(driver,true) ;
}

// Method to Click on Exterior in Sub Categories	
public void clickSubCategoryExteriorLinkText() throws InterruptedException {
		WaitTool.waitForElement(driver, subCategoryExteriorLinkText);
		subCategoryExteriorLinkText.click();
		WaitTool.waitFor(driver,true) ;

}

// Method to Click on Interior in Sub Categories	
public void clickSubCategoryInteriorLinkText() throws InterruptedException {
		WaitTool.waitForElement(driver, subCategoryInteriorLinkText);
		subCategoryInteriorLinkText.click();
		WaitTool.waitFor(driver,true) ;

}


}

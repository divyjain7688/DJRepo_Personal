package com.selenium.ebiz.pageobject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.selenium.ebiz.baseclass.BaseClass;
import com.selenium.ebiz.tools.WaitTool;

public class SubcategoryHospitalitySuppliesPage extends BaseClass {

	public SubcategoryHospitalitySuppliesPage(WebDriver driver) 	{
		PageFactory.initElements(driver, this);

	}

	// sub Categories AmericInn
	@FindBy(linkText = "AmericInn")
	WebElement subCategoryAmericInnLinkText;

	// sub Categories Hilton
	@FindBy(linkText = "Hilton")
	WebElement subCategoryHiltonLinkText;

	// sub Categories Pens
	@FindBy(linkText = "Pens")
	WebElement subCategoryPensLinkText;

	// sub Categories Casegoods
	@FindBy(linkText = "Casegoods")
	WebElement subCategoryCasegoodsLinkText;

	// sub Categories Forms
	@FindBy(linkText = "Forms")
	WebElement subCategoryFormsLinkText;


	// sub Categories Valet Stands
	@FindBy(linkText = "Valet Stands")
	WebElement subCategoryValetStandsLinkText;

	// sub Categories Hair Dryers & Accessories
	@FindBy(linkText = "Hair Dryers & Accessories")
	WebElement subCategoryHairDryersAccessoriesLinkText;

	// sub Categories Laundry Bags
	@FindBy(linkText = "Laundry Bags")
	WebElement subCategoryLaundryBagsLinkText;

	// sub Categories Luggage Racks
	@FindBy(linkText = "Luggage Racks")
	WebElement subCategoryLuggageRacksLinkText;

	// sub Categories Sprinkler
	@FindBy(linkText = "Sprinkler")
	WebElement subCategorySprinklerLinkText;

	// sub Categories Sign Holder
	@FindBy(linkText = "Sign Holder")
	WebElement subCategorySignHolderLinkText;

	// sub Categories Hair Care
	@FindBy(linkText = "Hair Care")
	WebElement subCategoryHairCareLinkText;

	// sub Categories Dental Care
	@FindBy(linkText = "Dental Care")
	WebElement subCategoryDentalCareLinkText;

	public void clickSubCategoryHairCareLinkText() throws InterruptedException {

		WaitTool.waitForElement(driver,	subCategoryHairCareLinkText);
		subCategoryHairCareLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(WaitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);			
	}

	public void clickSubCategoryDentalCareLinkText() throws InterruptedException {

		WaitTool.waitForElement(driver,	subCategoryDentalCareLinkText);
		subCategoryDentalCareLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(WaitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);			
	}

	public void clickSubCategorySprinklerLinkText() throws InterruptedException {

		WaitTool.waitForElement(driver,	subCategorySprinklerLinkText);
		subCategorySprinklerLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(WaitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);			
	}

	public void clickSubCategorySignHolderLinkText() throws InterruptedException {

		WaitTool.waitForElement(driver,	subCategorySignHolderLinkText);
		subCategorySignHolderLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(WaitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);			
	}

	public void clickSubCategoryLaundryBagsLinkText() throws InterruptedException {

		WaitTool.waitForElement(driver,	subCategoryLaundryBagsLinkText);
		subCategoryLaundryBagsLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(WaitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);			
	}

	public void clickSubCategoryLuggageRacksLinkText() throws InterruptedException {

		WaitTool.waitForElement(driver,	subCategoryLuggageRacksLinkText);
		subCategoryLuggageRacksLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(WaitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);			
	}

	public void clickSubCategoryValetStandsLinkText() throws InterruptedException {

		WaitTool.waitForElement(driver,	subCategoryValetStandsLinkText);
		subCategoryValetStandsLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(WaitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);			
	}

	public void clickSubCategoryHairDryersAccessoriesLinkText() throws InterruptedException {

		WaitTool.waitForElement(driver,	subCategoryHairDryersAccessoriesLinkText);
		subCategoryHairDryersAccessoriesLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(WaitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);			
	}


	public void clickSubCategoryCasegoodsLinkText() throws InterruptedException {

		WaitTool.waitForElement(driver,	subCategoryCasegoodsLinkText);
		subCategoryCasegoodsLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(WaitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);			
	}

	public void clickSubCategoryPensLinkText() throws InterruptedException {

		WaitTool.waitForElement(driver,	subCategoryPensLinkText);
		subCategoryPensLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(WaitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);			
	}

	public void clickSubCategoryFormsLinkText() throws InterruptedException {

		WaitTool.waitForElement(driver,	subCategoryFormsLinkText);
		subCategoryFormsLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(WaitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);			
	}

	public void clickSubCategoryAmericInnLinkText() throws InterruptedException {

		WaitTool.waitForElement(driver,	subCategoryAmericInnLinkText);
		subCategoryAmericInnLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(WaitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);			
	}

	public void clickSubCategoryHiltonLinkText() throws InterruptedException {

		WaitTool.waitForElement(driver,	subCategoryHiltonLinkText);
		subCategoryHiltonLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(WaitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);			
	}


}

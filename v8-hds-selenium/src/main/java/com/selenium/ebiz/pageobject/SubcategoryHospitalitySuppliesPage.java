package com.selenium.ebiz.pageobject;

import com.selenium.ebiz.tools.WaitTool;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class SubcategoryHospitalitySuppliesPage {

	private  WebDriver driver; private WaitTool   waitTool;

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

		waitTool.waitForElement(driver,	subCategoryHairCareLinkText);
		subCategoryHairCareLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(waitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);			
	}

	public void clickSubCategoryDentalCareLinkText() throws InterruptedException {

		waitTool.waitForElement(driver,	subCategoryDentalCareLinkText);
		subCategoryDentalCareLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(waitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);			
	}

	public void clickSubCategorySprinklerLinkText() throws InterruptedException {

		waitTool.waitForElement(driver,	subCategorySprinklerLinkText);
		subCategorySprinklerLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(waitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);			
	}

	public void clickSubCategorySignHolderLinkText() throws InterruptedException {

		waitTool.waitForElement(driver,	subCategorySignHolderLinkText);
		subCategorySignHolderLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(waitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);			
	}

	public void clickSubCategoryLaundryBagsLinkText() throws InterruptedException {

		waitTool.waitForElement(driver,	subCategoryLaundryBagsLinkText);
		subCategoryLaundryBagsLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(waitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);			
	}

	public void clickSubCategoryLuggageRacksLinkText() throws InterruptedException {

		waitTool.waitForElement(driver,	subCategoryLuggageRacksLinkText);
		subCategoryLuggageRacksLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(waitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);			
	}

	public void clickSubCategoryValetStandsLinkText() throws InterruptedException {

		waitTool.waitForElement(driver,	subCategoryValetStandsLinkText);
		subCategoryValetStandsLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(waitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);			
	}

	public void clickSubCategoryHairDryersAccessoriesLinkText() throws InterruptedException {

		waitTool.waitForElement(driver,	subCategoryHairDryersAccessoriesLinkText);
		subCategoryHairDryersAccessoriesLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(waitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);			
	}


	public void clickSubCategoryCasegoodsLinkText() throws InterruptedException {

		waitTool.waitForElement(driver,	subCategoryCasegoodsLinkText);
		subCategoryCasegoodsLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(waitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);			
	}

	public void clickSubCategoryPensLinkText() throws InterruptedException {

		waitTool.waitForElement(driver,	subCategoryPensLinkText);
		subCategoryPensLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(waitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);			
	}

	public void clickSubCategoryFormsLinkText() throws InterruptedException {

		waitTool.waitForElement(driver,	subCategoryFormsLinkText);
		subCategoryFormsLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(waitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);			
	}

	public void clickSubCategoryAmericInnLinkText() throws InterruptedException {

		waitTool.waitForElement(driver,	subCategoryAmericInnLinkText);
		subCategoryAmericInnLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(waitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);			
	}

	public void clickSubCategoryHiltonLinkText() throws InterruptedException {

		waitTool.waitForElement(driver,	subCategoryHiltonLinkText);
		subCategoryHiltonLinkText.click();

		driver.manage().timeouts().pageLoadTimeout(waitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);			
	}


}

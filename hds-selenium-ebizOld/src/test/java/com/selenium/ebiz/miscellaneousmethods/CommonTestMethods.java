package com.selenium.ebiz.miscellaneousmethods;

import org.openqa.selenium.WebDriver;

import com.selenium.ebiz.baseclass.BaseClass;
import com.selenium.ebiz.pageobject.HomePage;
import com.selenium.ebiz.pageobject.ProductDetailsPage;
import com.selenium.ebiz.pageobject.SearchPage;
import com.selenium.ebiz.tools.WaitTool;


public class CommonTestMethods extends BaseClass {

	public HomePage clickAddToCart(WebDriver driver, String partNumber, HomePage homePage) throws Exception{
		System.out.println(partNumber);
		SearchPage searchPage = homePage.searchByKeywordOrPartNumber(partNumber);
		Thread.sleep(5000);
		ProductDetailsPage productDetailsPage = searchPage.clickOnProduct();
		productDetailsPage.clickAddToCartButton();
		WaitTool.hardWait();
		productDetailsPage.clickOnCloseAddtocartSuccessPopup();
		WaitTool.hardWait();
		homePage = productDetailsPage.clickOnHDSupplyLogoInHeader();
		return new HomePage(driver);
	}

	public HomePage clickAddToCartGuestUser(WebDriver driver, String partNumber, HomePage homePage) throws Exception{
		System.out.println(partNumber);
		//		homePage.enterDataForSearch(partNumber);
		//		ProductDetailsPage productDetailsPage = homePage.clickSearchButtonInHomePage();
		//		// search result displayed for the data entered
		//		productDetailsPage.clickAddToCartButton();
		//		WaitTool.hardWait();
		SearchPage searchPage = homePage.searchByKeywordOrPartNumber(partNumber);
		Thread.sleep(5000);
		ProductDetailsPage productDetailsPage = searchPage.clickOnProduct();
		productDetailsPage.clickAddToCartButton();
		WaitTool.hardWait();
		productDetailsPage.clickOnCloseAddtocartSuccessPopup();
		WaitTool.hardWait();
		homePage = productDetailsPage.clickOnHDSupplyLogoInHeader();
		return new HomePage(driver);
	}
}

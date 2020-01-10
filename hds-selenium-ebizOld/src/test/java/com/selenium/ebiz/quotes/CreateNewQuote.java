package com.selenium.ebiz.quotes;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.selenium.ebiz.baseclass.BaseClass;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.dbcon.DBCon;
import com.selenium.ebiz.pageobject.Appliances;
import com.selenium.ebiz.pageobject.HomePage;
import com.selenium.ebiz.pageobject.LoginPage;
import com.selenium.ebiz.pageobject.ProductDetailsPage;
import com.selenium.ebiz.pageobject.ProductListingPage;
import com.selenium.ebiz.pageobject.QuickOrderPad;
import com.selenium.ebiz.pageobject.QuickOrderPage;
import com.selenium.ebiz.pageobject.QuotesPage;
import com.selenium.ebiz.pageobject.SubCategoryAppliancesPage;
import com.selenium.ebiz.tools.WaitTool;

public class CreateNewQuote extends BaseClass {
	LoginPage loginPage ;
	HomePage homePage;
	SubCategoryAppliancesPage subCategoryAppliancesPage;
	ProductListingPage productListingPage;
	ProductDetailsPage productDetailsPage;

	ArrayList<UsersListBean> usersList;
	DBCon dbConnection = new DBCon();

	@BeforeMethod
	public void driverSetup() throws Exception {
		driver = initialize();
		loginPage = new LoginPage(driver);
		homePage = loginPage.loginToHdSupplySite(prop.getProperty("username"), prop.getProperty("password"));
		WaitTool.hardWait();
		//usersList = dbConnection.loadDataFromExcel("loginForQuotes", "LoginTestData");
		//homePage = loginPage.loginToHdSupplySite(usersList.get(0).getuserName(), usersList.get(0).getpassword());
	}

	/*
	 * Creating a new quote from PLP
	 */
	@Test(priority = 0)
	public void createNewQuoteFromPLP() throws Exception{
		//WaitTool.hardWait2sec();
		Assert.assertTrue(homePage.isDisplayedLeftNavgation());
		WaitTool.hardWait();
		// Clicking on the Header Shop By Category
		homePage.clickHeaderShopByCategoryLinkText();
		WaitTool.hardWait();
		// click on the Appliances
		Appliances appliances = homePage.clickCategoryAppliancesLinkText();
		// click on the DishWashers Repair
		//appliances.clickTopCategorySmallAppliancesLinkText();
		subCategoryAppliancesPage = appliances.clickTopCategoryDishwashersRepairLinkText();
		// click on the Dishwashers link
		ProductListingPage productListingPage = subCategoryAppliancesPage.clickSubCategoryDishwashersLink();
		productListingPage.clickAddToQuoteButton();
		WaitTool.hardWait();
		Assert.assertTrue(productListingPage.isDisplayedNewTab());
		productListingPage.clickNewTab();
		Assert.assertTrue(productListingPage.isDisplayedCreateQuoteButton());
		productListingPage.enterQuoteName("Quote1");
		productListingPage.clickCreateQuoteButton();
		Thread.sleep(15000);
		Assert.assertTrue(productListingPage.isDisplayedQuoteSuccessPopup());
		productListingPage.clickCloseQuoteSuccessPopupIcon();
		homePage = productListingPage.clickOnHDSupplyLogoInHeader();
		QuotesPage quotesPage = homePage.clickQuotesUtilityBar();
		Assert.assertTrue(quotesPage.isDisplayedQuotesPageHeadingText());
		System.out.println(quotesPage.getQuotesPageHeadingText());;

	}

	/*
	 * Creating a new quote from PDP
	 */
	@Test(priority = 1)
	public void createNewQuoteFromPDP() throws Exception{
		productListingPage=homePage.moveToSubCategoryPage();
		productDetailsPage = productListingPage.clickOnFirstProduct();

		Assert.assertTrue(productDetailsPage.isAddToQuoteButtonDisplayed());
		productDetailsPage.clickAddToQuoteButton();
		WaitTool.hardWait();
		Assert.assertTrue(productDetailsPage.isDisplayedNewTab());
		productDetailsPage.clickNewTab();
		Assert.assertTrue(productDetailsPage.isDisplayedCreateQuoteButton());
		productDetailsPage.enterQuoteName("Quote2");
		productDetailsPage.clickCreateQuoteButton();
		WaitTool.hardWait();
		WaitTool.hardWait();
		WaitTool.hardWait();
		Assert.assertTrue(productDetailsPage.isDisplayedQuoteSuccessPopup());
		productDetailsPage.clickCloseQuoteSuccessPopupIcon();
		homePage = productDetailsPage.clickOnHDSupplyLogoInHeader();
		QuotesPage quotesPage = homePage.clickQuotesUtilityBar();
		Assert.assertTrue(quotesPage.isDisplayedQuotesPageHeadingText());
		System.out.println(quotesPage.getQuotesPageHeadingText());
	}

	/*
	 * Creating a new quote from Quick Order Header
	 */
	@Test(priority = 2)
	public void createNewQuoteFromQuickOrderHeader() throws Exception{
		QuickOrderPad quickOrderPad=homePage.clickOnQuickOrderLink();
		Assert.assertTrue(quickOrderPad.isDisplayedDefaultSixRowsInQuickOrderPad());
		Assert.assertTrue(quickOrderPad.isAddToQuoteButtonDisplayed());
		usersList = dbConnection.loadDataFromExcel("addProductsUsingQuickOrder","QuickOrder");
		System.out.println("usersList.get(0).getPartNumber1()"+usersList.get(0).getPartNumber1());
		System.out.println("usersList.get(0).getQuantity1()"+usersList.get(0).getQuantity1());
		quickOrderPad.fillFirstPartNumberTextBox(usersList.get(0).getPartNumber1());
		quickOrderPad.fillFirstQuantityTextBox(usersList.get(0).getQuantity1());
		WaitTool.hardWait2sec();
		quickOrderPad.clickAddToQuoteButton();
		Assert.assertTrue(quickOrderPad.isDisplayedNewTab());
		quickOrderPad.clickNewTab();
		Assert.assertTrue(quickOrderPad.isDisplayedCreateQuoteButton());
		quickOrderPad.enterQuoteName("Quote2");
		quickOrderPad.clickCreateQuoteButton();
		WaitTool.hardWait();
		WaitTool.hardWait();
		WaitTool.hardWait();
		Assert.assertTrue(quickOrderPad.isDisplayedQuoteSuccessPopup());
		homePage = quickOrderPad.clickCloseQuoteSuccessPopupIcon();
		WaitTool.hardWait();
		QuotesPage quotesPage = homePage.clickQuotesUtilityBar();
		Assert.assertTrue(quotesPage.isDisplayedQuotesPageHeadingText());
		System.out.println(quotesPage.getQuotesPageHeadingText());
		//Assert.assertTrue(quotesPage.isDisplayedQuoteNameInTable());
	}

	/*
	 * Creating a new quote from Quick Order Detail Page
	 */
	@Test(priority = 3)
	public void createNewQuoteFromQuickOrderDetailPage() throws Exception{
		//WaitTool.hardWait2sec();
		QuickOrderPad quickOrderPad=homePage.clickOnQuickOrderLink();
		Assert.assertTrue(quickOrderPad.isDisplayedDefaultSixRowsInQuickOrderPad());
		Assert.assertTrue(quickOrderPad.isAddToQuoteButtonDisplayed());
		Assert.assertTrue(quickOrderPad.isDisplayedAddMoreRowsFirstTime());
		Thread.sleep(5000);
		quickOrderPad.clickAddMoreRowsFirstTime();
		Assert.assertTrue(quickOrderPad.isDisplayedTwelveRowsInQuickOrderPad());
		QuickOrderPage quickOrderPage = quickOrderPad.clickAddMoreRowsSecondTime();
		Assert.assertTrue(quickOrderPage.isDisplayedQuickOrderPageHeadingText());
		System.out.println(quickOrderPage.isDisplayedQuickOrderPageHeadingText());
		usersList = dbConnection.loadDataFromExcel("addProductsUsingQuickOrder","QuickOrder");
		System.out.println("usersList.get(0).getPartNumber1()"+usersList.get(0).getPartNumber1());
		System.out.println("usersList.get(0).getQuantity1()"+usersList.get(0).getQuantity1());
		quickOrderPage.fillFirstPartNumberTextBox(usersList.get(0).getPartNumber1());
		quickOrderPage.fillFirstQuantityTextBox(usersList.get(0).getQuantity1());
		Assert.assertTrue(quickOrderPage.isDisplayedAddToCartButton());
		quickOrderPage.clickAddToQuoteButton();
		Assert.assertTrue(quickOrderPage.isDisplayedNewTab());
		quickOrderPage.clickNewTab();
		Assert.assertTrue(quickOrderPage.isDisplayedCreateQuoteButton());
		quickOrderPage.enterQuoteName("Quote2");
		quickOrderPage.clickCreateQuoteButton();
		WaitTool.hardWait();
		WaitTool.hardWait();
		WaitTool.hardWait();
		Assert.assertTrue(quickOrderPage.isDisplayedQuoteSuccessPopup());
		quickOrderPage.clickCloseQuoteSuccessPopupIcon();
		homePage = quickOrderPage.clickOnHDSupplyLogoInHeader();
		WaitTool.hardWait();
		QuotesPage quotesPage = homePage.clickQuotesUtilityBar();
		Assert.assertTrue(quotesPage.isDisplayedQuotesPageHeadingText());
		System.out.println(quotesPage.getQuotesPageHeadingText());
		//Assert.assertTrue(quotesPage.isDisplayedQuoteNameInTable());
	}


}

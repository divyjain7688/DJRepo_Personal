package com.selenium.ebiz.header;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.selenium.ebiz.baseclass.BaseClass;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.dbcon.DBCon;
import com.selenium.ebiz.pageobject.Appliances;
import com.selenium.ebiz.pageobject.FrequentlyPurchasedPage;
import com.selenium.ebiz.pageobject.HomePage;
import com.selenium.ebiz.pageobject.LoginPage;
import com.selenium.ebiz.pageobject.MinicartPage;
import com.selenium.ebiz.pageobject.MyAccountPage;
import com.selenium.ebiz.pageobject.OrderHistoryAndStatusPage;
import com.selenium.ebiz.pageobject.ProductDetailsPage;
import com.selenium.ebiz.pageobject.ProductPage;
import com.selenium.ebiz.pageobject.QuotesPage;
import com.selenium.ebiz.pageobject.SavedListsPage;
import com.selenium.ebiz.pageobject.ShoppingCartPage;
import com.selenium.ebiz.pageobject.SubCategoryAppliancesPage;
import com.selenium.ebiz.pageobject.SubscriptionsPage;
import com.selenium.ebiz.tools.WaitTool;

public class DisplayStaticWebsiteHelpInUtilityBar_WORKING extends BaseClass{
	ArrayList<UsersListBean> usersList;
	DBCon dbConnection = new DBCon();
	LoginPage loginPage;
	HomePage homePage;
	Appliances appliances;
	QuotesPage quotesPage;
	SavedListsPage savedListsPage;
	FrequentlyPurchasedPage frequentlyPurchasedPage;
	OrderHistoryAndStatusPage orderHistoryAndStatusPage;
	SubscriptionsPage subscriptionsPage;
	MyAccountPage myAccountPage;
	ProductPage productPage;
	SubCategoryAppliancesPage subcategoryAppPage;
	ProductDetailsPage productDetailsPage;
	ShoppingCartPage shoppingCartPage;
	MinicartPage minicartPage;

	@BeforeMethod
	public void driverSetup() throws Exception {
		usersList = dbConnection.loadDataFromExcel("loginWithValidCredentialAndLogoutTest", "LoginTestData");
		driver = initialize();
		loginPage = new LoginPage(driver);
		homePage = loginPage.loginToHdSupplySite(usersList.get(0).getuserName(), usersList.get(0).getpassword());

	}

	/**
	 * 
	 * @author Smitha
	 * Validating the Static Website Help Phone number and Hours should be displayed in Utility bar On Homepage,Category and Subcategory page
	 * 
	 * This Test script is mapped to US-Cat-981
	 * 
	 */

	@Test
	public void DisplayStaticWebsiteHelpInUtilityBarAllPagesTest() throws Exception {
		WaitTool.hardWait();
		Assert.assertTrue(homePage.isDisplayedStaticWebsiteHelpLabel() && homePage.isDisplayedStaticWebsiteHelpPhoneNumber() && homePage.isDisplayedStaticWebsiteHelpTime());	

		//Click On Category from Homepage should redirect to category page
		appliances = homePage.clickCategoryAppliancesLinkText();
		Assert.assertTrue(homePage.getCategoryPageHeadingText().equalsIgnoreCase("Appliances"));
		Assert.assertTrue(homePage.isDisplayedStaticWebsiteHelpLabel() && homePage.isDisplayedStaticWebsiteHelpPhoneNumber() && homePage.isDisplayedStaticWebsiteHelpTime());

		//Click on Top category should redirect to subcategory page
		appliances.clickTopCategoryDishwashersRepairLinkText();
		Assert.assertTrue(homePage.getCategoryPageHeadingText().equalsIgnoreCase("Dishwashers & Repair"));	
		Assert.assertTrue(homePage.isDisplayedStaticWebsiteHelpLabel() && homePage.isDisplayedStaticWebsiteHelpPhoneNumber() && homePage.isDisplayedStaticWebsiteHelpTime());

		//Verify in Quotes page
		/*	quotesPage = homePage.clickMyAccountQuotesQuickLink();  ........Commented because Quotes page is not implemented
		Assert.assertTrue(quotesPage.getQuotesPageHeadingText().equalsIgnoreCase("Quotes"));
		Assert.assertTrue(homePage.isDisplayedStaticWebsiteHelpLabel() && homePage.isDisplayedStaticWebsiteHelpPhoneNumber() && homePage.isDisplayedStaticWebsiteHelpTime());
		 */

		//Veirfy in Subscriptions page
		subscriptionsPage = homePage.clickMyAccountSubscriptionsQuickLink();
		Assert.assertTrue(subscriptionsPage.getSubscriptionspageHeadingText().equalsIgnoreCase("Subscriptions"));
		Assert.assertTrue(homePage.isDisplayedStaticWebsiteHelpLabel() && homePage.isDisplayedStaticWebsiteHelpPhoneNumber() && homePage.isDisplayedStaticWebsiteHelpTime());

		//Verify in Saved Lists page
		savedListsPage = homePage.clickMyAccountSavedListsQuickLink();
		Assert.assertTrue(savedListsPage.getSavedListspageHeadingText().equalsIgnoreCase("Saved Lists"));
		Assert.assertTrue(homePage.isDisplayedStaticWebsiteHelpLabel() && homePage.isDisplayedStaticWebsiteHelpPhoneNumber() && homePage.isDisplayedStaticWebsiteHelpTime());

		//Verify in order history page
		orderHistoryAndStatusPage = homePage.clickMyAccountOrderHistoryAndStatusQuickLink();
		Assert.assertTrue(orderHistoryAndStatusPage.getOrderspageHeadingText().equalsIgnoreCase("Orders"));
		Assert.assertTrue(homePage.isDisplayedStaticWebsiteHelpLabel() && homePage.isDisplayedStaticWebsiteHelpPhoneNumber() && homePage.isDisplayedStaticWebsiteHelpTime());

		//Veirfy in Frequently purchased page
		frequentlyPurchasedPage = homePage.clickMyAccountFrequentlyPurchasedQuickLink();
		Assert.assertTrue(frequentlyPurchasedPage.getFrequentlyPurchasedpageHeadingText().equalsIgnoreCase("Frequently Purchased"));
		Assert.assertTrue(homePage.isDisplayedStaticWebsiteHelpLabel() && homePage.isDisplayedStaticWebsiteHelpPhoneNumber() && homePage.isDisplayedStaticWebsiteHelpTime());

		//Veirfy in My account page
		myAccountPage = homePage.moveToMyAccountPage();

		//Navigate to product details page and verify Website help in PDP page
		homePage.clickHeaderShopByCategoryLinkText();
		WaitTool.hardWait();
		appliances = homePage.clickCategoryAppliancesLinkText();
		subcategoryAppPage = appliances.clickTopCategoryWashersDryersLinkText();
		productPage = subcategoryAppPage.clickSubCategoryDryersLinkText();
		Assert.assertTrue(productPage.verifyProductsDisplayed());
		productDetailsPage = productPage.clickFirstProductInProductList();
		Assert.assertTrue(productDetailsPage.isDisplayedproductDetailsHeader());
		Assert.assertTrue(homePage.isDisplayedStaticWebsiteHelpLabel() && homePage.isDisplayedStaticWebsiteHelpPhoneNumber() && homePage.isDisplayedStaticWebsiteHelpTime());

		//Verify in Shopping cart page
		shoppingCartPage = loginPage.clickShoppingCartIcon();
		Assert.assertTrue(shoppingCartPage.isDisplayedShoppingCartPage());
		Assert.assertTrue(homePage.isDisplayedStaticWebsiteHelpLabel() && homePage.isDisplayedStaticWebsiteHelpPhoneNumber() && homePage.isDisplayedStaticWebsiteHelpTime());
	}

}

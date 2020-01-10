/**
 * 
 * @author suresh
 * 
 * This test will verify the headers in the application after login
 * 
 * This TestScript is Mapped to the US-CAT-960
 * 
 * 
 * 
 */

package com.selenium.ebiz.header;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.selenium.ebiz.baseclass.BaseClass;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.dbcon.DBCon;
import com.selenium.ebiz.pageobject.HeaderServicesPage;
import com.selenium.ebiz.pageobject.HomePage;
import com.selenium.ebiz.pageobject.LoginPage;
import com.selenium.ebiz.tools.WaitTool;


public class HeaderServiceFlyout_WORKING extends BaseClass{
	ArrayList<UsersListBean> usersList;
	DBCon dbConnection = new DBCon();
	LoginPage loginPage;
	HomePage homePage;
	HeaderServicesPage headerServicesPage;

	/*
	 *  Launching of the Browser and login with Valid Credentials
	 */

	@BeforeMethod
	public void driverSetup() throws Exception {
		driver = initialize();
		loginPage = new LoginPage(driver);
		headerServicesPage = new HeaderServicesPage(driver);
		homePage = loginPage.loginToHdSupplySite(prop.getProperty("username"), prop.getProperty("password"));

	}

	/**
	 *  Verify the Headers and click on the Services to Check the flyout
	 */	
	@Test
	public void verifyHeadersandServicesFlyoutTest() throws Exception{
		// Verifying the left Navigation Page
		Assert.assertTrue(homePage.isDisplayedLeftNavgation());
		// Verifying the Header Shop By Category
		Assert.assertTrue(headerServicesPage.isDisplayedShopByCategoryLinkText());
		// Verifying the Header Services
		Assert.assertTrue(headerServicesPage.isDisplayedServicessLinkText());
		// Verifying the Header Resources
		Assert.assertTrue(headerServicesPage.isDisplayedResourcesLinkText());
		WaitTool.hardWait();
		// Verifying the Header Offers
		Assert.assertTrue(headerServicesPage.isDisplayedOffersLinkText());
		WaitTool.hardWait();
		// Verifying the Header eCatalogs
		Assert.assertTrue(headerServicesPage.isDisplayedeCatalogsLinkText());
		WaitTool.hardWait();
		// Click on the header Services
		headerServicesPage.clickHeaderServicesLinkText();
		WaitTool.hardWait();
		// Verifying the L1 Flyout of Services
		Assert.assertTrue(headerServicesPage.isDisplayedL1FlyoutServices());
		WaitTool.hardWait();
		// Click on the Custom products link
		headerServicesPage.clickHeaderServicesCustomProductsLinkText();
		WaitTool.hardWait();
		// Verifying the L2 Flyout Services
		Assert.assertTrue(headerServicesPage.isDisplayedL2FlyoutServices());
		WaitTool.hardWait();
		// clicking on the Order Forms
		headerServicesPage.clickHeaderServicesOrderFormsLinkText();
		// Functionality is not implemented to check the page

	}
	
}	


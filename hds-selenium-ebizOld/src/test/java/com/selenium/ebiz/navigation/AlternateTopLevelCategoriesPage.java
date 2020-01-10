/**
 * 
 * @author suresh
 * 
 * This test will verify about the Sub Categories in the L2 Category
 * 
 * This TestScript is Mapped to the US-Cat-261
 * 
 * 
 * 
 */

package com.selenium.ebiz.navigation;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.selenium.ebiz.baseclass.BaseClass;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.dbcon.DBCon;
import com.selenium.ebiz.pageobject.CategoryAppliancesPage;
import com.selenium.ebiz.pageobject.CategoryCabinetsAndCounterTopsPage;
import com.selenium.ebiz.pageobject.HomePage;
import com.selenium.ebiz.pageobject.LoginPage;
import com.selenium.ebiz.pageobject.SubCategoryCabinetsAndCounterTopsPage;
import com.selenium.ebiz.tools.WaitTool;


public class AlternateTopLevelCategoriesPage extends BaseClass{
	ArrayList<UsersListBean> usersList;
	DBCon dbConnection = new DBCon();
	LoginPage loginPage;
	HomePage homePage;
	CategoryAppliancesPage categoryAppliancesPage;
	SubCategoryCabinetsAndCounterTopsPage subCategoryCabinetsAndCounterTopsPage;
	CategoryCabinetsAndCounterTopsPage categoryCabinetsAndCounterTopsPage;
	/*
	 *  Launching of the Browser and login with Valid Credentials
	 */

	@BeforeMethod
	public void driverSetup() throws Exception {
		usersList = dbConnection.loadDataFromExcel("loginWithValidCredentialAndLogoutTest", "LoginTestData");
		driver = initialize();
		loginPage = new LoginPage(driver);
		homePage = loginPage.loginToHdSupplySite(usersList.get(0).getuserName(), usersList.get(0).getpassword());
	}

	/**
	 *  Moves from Shop by category to the Sub Category Pages and clicks on the BreadCrumb of Category
	 *  and verifies if the L3 Categories are present under L2 Categories
	 */	
	@Test(priority=0)
	public void verifyL3CategoriesAlternatelyAuthenticateUserTest() throws Exception{
		// click on the Shop by Category
		homePage.clickHeaderShopByCategoryLinkText();
		WaitTool.hardWait();
		// clicking on the Cabinets Counter Tops
		subCategoryCabinetsAndCounterTopsPage = homePage.clickCategoryCabinetsCountertopsLink();
		// click on the Kitchen Cabinets
		String l2categry = subCategoryCabinetsAndCounterTopsPage.clickSubCategoryKitchenCabinetsLinkText();
		// Click on the Cabinet Shelves
		subCategoryCabinetsAndCounterTopsPage.clickSubCategoryCabinetShelvesLinkText();
		// click on the BreadCrumb of Cabinets Counter tops
		categoryCabinetsAndCounterTopsPage = subCategoryCabinetsAndCounterTopsPage.clickCabinetAndCounterTopsFromBreadCrumbLink();

		Assert.assertTrue(categoryCabinetsAndCounterTopsPage.isSelectedL2CategoryDisplayed(l2categry));

		// Getting all the products of L3 and verify if the L3 are displaying under the respective L2

		/*List<WebElement> isubCategoryLinks = categoryAppliancesPage.getSubCategoryLinkText();	
        for(int i=1 ; i<isubCategoryLinks.size() ; i++)
		{
        	// comparing from the inputsheet and from the list
	    	Assert.assertTrue(categoryAppliancesPage.isL3CategoriesDisplayed(i));
	    	System.out.println(categoryAppliancesPage.isL3CategoriesDisplayed(i));
	    }*/


	}

	@Test(priority=1)
	public void verifyL3CategoriesAlternatelyGuestUserTest() throws Exception{
		// click on the Shop by Category
		loginPage.clickHeaderShopByCategoryLinkText();
		WaitTool.hardWait();
		// clicking on the Cabinets Counter Tops
		subCategoryCabinetsAndCounterTopsPage = loginPage.clickCategoryCabinetsCountertopsLink();
		// click on the Kitchen Cabinets
		String l2categry = subCategoryCabinetsAndCounterTopsPage.clickSubCategoryKitchenCabinetsLinkText();
		// Click on the Cabinet Shelves
		subCategoryCabinetsAndCounterTopsPage.clickSubCategoryCabinetShelvesLinkText();
		// click on the BreadCrumb of Cabinets Counter tops
		categoryCabinetsAndCounterTopsPage = subCategoryCabinetsAndCounterTopsPage.clickCabinetAndCounterTopsFromBreadCrumbLink();

		Assert.assertTrue(categoryCabinetsAndCounterTopsPage.isSelectedL2CategoryDisplayed(l2categry));
	}
	
	
}	



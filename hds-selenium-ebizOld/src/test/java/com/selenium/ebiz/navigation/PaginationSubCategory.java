/**
 * 
 * @author suresh
 * 
 * This test will verify Pages for Forward and Backward and provided the Page no will take to the respective Page in the Sub Category Page
 * 
 * This Test Script is mapped to US-CAT-278
 * 
 * 
 * 
 */
package com.selenium.ebiz.navigation;

import java.net.MalformedURLException;
import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.selenium.ebiz.baseclass.BaseClass;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.dbcon.DBCon;
import com.selenium.ebiz.pageobject.CategoryAppliancesPage;
import com.selenium.ebiz.pageobject.HomePage;
import com.selenium.ebiz.pageobject.LoginPage;
import com.selenium.ebiz.pageobject.SubCategoryAppliancesPage;
import com.selenium.ebiz.tools.WaitTool;

public class PaginationSubCategory extends BaseClass{
	ArrayList<UsersListBean> usersList;
	DBCon dbConnection = new DBCon();
	LoginPage loginPage;
	HomePage homePage;
	CategoryAppliancesPage categoryAppliancesPage;
	SubCategoryAppliancesPage subCategoryAppliancesPage;

	/*
	 *  Launching of the Browser and login with Valid Credentials
	 */

	@BeforeMethod
	public void driverSetup() throws MalformedURLException {
		driver = initialize();
		loginPage = new LoginPage(driver);
		//homePage = loginPage.loginToHdSupplySite(prop.getProperty("username"), prop.getProperty("password"));

	}

	/**
	 *  Verifying the pages in the subcategory that it should have more than 2 pages and view  foward and backward button
	 */

	@Test(priority=0)
	public void paginationSubCategoryAuthenticateUserTest() throws Exception{
		homePage = loginPage.loginToHdSupplySite(prop.getProperty("username"), prop.getProperty("password"));
		// Verifying the Left Navigation 
		Assert.assertTrue(homePage.isDisplayedLeftNavgation());
		WaitTool.hardWait();
		// Clicking on the Header Shop By Category
			//homePage.clickHeaderShopByCategoryLinkText();
		WaitTool.hardWait();
		// click on the Appliances
		categoryAppliancesPage = homePage.clickCategoryAppliancessLinkText();
		// click on the DishWashers Repair
		subCategoryAppliancesPage=categoryAppliancesPage.clickTopCategoryDishwashersRepairLinkText();
		// click on the Dishwashers link
			//subCategoryAppliancesPage.clickSubCategoryDishwashersLinkText();
		// click on the List View
		subCategoryAppliancesPage.clickSubCategoryListViewLinkText();
		// To get the total number of pages and verify the same.
		int iPageNumber= Integer.parseInt(subCategoryAppliancesPage.getSubCategoryTotalPageNumbers());
		if (iPageNumber>2) {
			/// Verifying pages more than one
			Assert.assertTrue(subCategoryAppliancesPage.isDisplayedMorePages());
		}
		WaitTool.hardWait();
		// clicking the forward button
		subCategoryAppliancesPage.clickSubCategoryForwardPageButton();
		WaitTool.hardWait();
		// Verifying the Forward Button in the Sub Category page
		Assert.assertTrue(subCategoryAppliancesPage.isDisplayedForwardPages());
		int ifwdPage = Integer.parseInt(subCategoryAppliancesPage.getPageNumberEdit());
		System.out.println("foward Page"+ifwdPage);
		if (ifwdPage>1) {
			// Verifying the Backward Button in the Sub Category Page
			Assert.assertTrue(subCategoryAppliancesPage.isDisplayedBackwardPages());
			// Verifying the Edit page number in the Sub Category Page
			Assert.assertTrue(subCategoryAppliancesPage.isDisplayedEditField());

			// clicking the forward button
			subCategoryAppliancesPage.clickSubCategoryForwardPageButton();
			WaitTool.hardWait();
			Assert.assertTrue(subCategoryAppliancesPage.isDisplayedForwardPages());
			// clicking the forward button
			subCategoryAppliancesPage.clickSubCategoryForwardPageButton();
			WaitTool.hardWait();
			// clicking the forward button
			subCategoryAppliancesPage.clickSubCategoryForwardPageButton();
			WaitTool.hardWait();   
		}
		int ibacPage = Integer.parseInt(subCategoryAppliancesPage.getPageNumberEdit());
		System.out.println("Backward Page"+ibacPage);
		if (ibacPage<4) {
			// Clicking the backward Button   
			subCategoryAppliancesPage.clickSubCategoryBackwardPageButton();
			// Verifying the Backward Button in the Sub Category Page
			Assert.assertTrue(subCategoryAppliancesPage.isDisplayedBackwardPages());   
			// Clicking the backward Button   
			subCategoryAppliancesPage.clickSubCategoryBackwardPageButton();
			Assert.assertTrue(subCategoryAppliancesPage.isDisplayedBackwardPages());    
		}

	}

	@Test(priority=1)
	public void paginationSubCategoryGuestUserTest() throws Exception{
		// Verifying the Left Navigation 

		// Clicking on the Header Shop By Category
		//loginPage.clickHeaderShopByCategoryLinkText();
		WaitTool.hardWait();
		// click on the Appliances
		categoryAppliancesPage = loginPage.clickCategoryAppliancessLinkText();
		// click on the DishWashers Repair
		subCategoryAppliancesPage=categoryAppliancesPage.clickTopCategoryDishwashersRepairLinkText();
		// click on the Dishwashers link
		//subCategoryAppliancesPage.clickSubCategoryDishwashersLinkText();
		// click on the List View
		subCategoryAppliancesPage.clickSubCategoryListViewLinkText();
		// To get the total number of pages and verify the same.
		int iPageNumber= Integer.parseInt(subCategoryAppliancesPage.getSubCategoryTotalPageNumbers());
		if (iPageNumber>2) {
			/// Verifying pages more than one
			Assert.assertTrue(subCategoryAppliancesPage.isDisplayedMorePages());
		}
		// clicking the forward button
		subCategoryAppliancesPage.clickSubCategoryForwardPageButton();
		WaitTool.hardWait();
		// Verifying the Forward Button in the Sub Category page
		Assert.assertTrue(subCategoryAppliancesPage.isDisplayedForwardPages());
		int ifwdPage = Integer.parseInt(subCategoryAppliancesPage.getPageNumberEdit());
		System.out.println("foward Page"+ifwdPage);
		if (ifwdPage>1) {
			// Verifying the Backward Button in the Sub Category Page
			Assert.assertTrue(subCategoryAppliancesPage.isDisplayedBackwardPages());
			// Verifying the Edit page number in the Sub Category Page
			Assert.assertTrue(subCategoryAppliancesPage.isDisplayedEditField());

			// clicking the forward button
			subCategoryAppliancesPage.clickSubCategoryForwardPageButton();
			WaitTool.hardWait();
			Assert.assertTrue(subCategoryAppliancesPage.isDisplayedForwardPages());
			// clicking the forward button
			subCategoryAppliancesPage.clickSubCategoryForwardPageButton();
			WaitTool.hardWait();
			// clicking the forward button
			subCategoryAppliancesPage.clickSubCategoryForwardPageButton();
			WaitTool.hardWait();   
		}
		int ibacPage = Integer.parseInt(subCategoryAppliancesPage.getPageNumberEdit());
		System.out.println("Backward Page"+ibacPage);
		if (ibacPage<4) {
			// Clicking the backward Button   
			subCategoryAppliancesPage.clickSubCategoryBackwardPageButton();
			// Verifying the Backward Button in the Sub Category Page
			Assert.assertTrue(subCategoryAppliancesPage.isDisplayedBackwardPages());   
			// Clicking the backward Button   
			subCategoryAppliancesPage.clickSubCategoryBackwardPageButton();
			Assert.assertTrue(subCategoryAppliancesPage.isDisplayedBackwardPages());    
		}

	}

}

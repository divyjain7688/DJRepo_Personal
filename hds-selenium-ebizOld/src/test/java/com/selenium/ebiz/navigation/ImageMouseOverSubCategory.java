/**
 * 
 * @author suresh
 * 
 * This test will verify Product of the Mouse Hover of Image in the Sub Category Page
 * 
 * This Test Script is mapped to US-CAT-275
 * 
 * 
 * 
 */
package com.selenium.ebiz.navigation;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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


public class ImageMouseOverSubCategory extends BaseClass{
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
	 *  Verifying the Image to Zoom in the Sub Category pages
	 */

	@Test(priority=0)
	public void imageMouseOverZoomAuthenticateUserTest() throws Exception{

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
		subCategoryAppliancesPage = categoryAppliancesPage.clickTopCategoryDishwashersRepairLinkText();
		// click on the Dishwashers link
	//	subCategoryAppliancesPage.clickSubCategoryDishwashersLinkText();
		// Selecting the first Image in the Sub Category
		List<WebElement> firstRow = (List<WebElement>) subCategoryAppliancesPage.getSubCategoryLinkText();

		firstRow.get(0).click();


		// Assert.assertTrue(subCategoryAppliancesPage.isDisplayedZoomImage());
		Actions actions = new Actions(driver);
		//subCategoryAppliancesPage.getZoomImage();
		// Getting the data before Zoom
		String mainMenu = subCategoryAppliancesPage.getZoomImage();
		mainMenu = mainMenu.substring(mainMenu.indexOf("-"),mainMenu.indexOf("p"));
		double dmainMenu = Double.parseDouble(mainMenu); 

		// performing the action
		actions.moveToElement(subCategoryAppliancesPage.viewImage).build().perform();
		// Getting the data of zoom after action
		mainMenu = subCategoryAppliancesPage.getZoomImage();
		double zoomMenu = Double.parseDouble(mainMenu.substring(mainMenu.indexOf("-"),mainMenu.indexOf("p")));
		// Verifying the zoom against the normal image
		Assert.assertTrue(dmainMenu>zoomMenu,"Image zoom successfull");


	}

	@Test(priority=1)
	public void imageMouseOverZoomGuestUserTest() throws Exception{

		loginPage.clickHeaderShopByCategoryLinkText();
		WaitTool.hardWait();
		// click on the Appliances
		categoryAppliancesPage = loginPage.clickCategoryAppliancessLinkText();
		// click on the DishWashers loginPage
		subCategoryAppliancesPage = categoryAppliancesPage.clickTopCategoryDishwashersRepairLinkText();
		// click on the Dishwashers link
		//subCategoryAppliancesPage.clickSubCategoryDishwashersLinkText();
		// Selecting the first Image in the Sub Category
		List<WebElement> firstRow = (List<WebElement>) subCategoryAppliancesPage.getSubCategoryLinkText();

		firstRow.get(0).click();
		WaitTool.hardWait();
		Actions actions = new Actions(driver);
		//subCategoryAppliancesPage.getZoomImage();
		// Getting the data before Zoom
		String mainMenu = subCategoryAppliancesPage.getZoomImage();
		mainMenu = mainMenu.substring(mainMenu.indexOf("-"),mainMenu.indexOf("p"));
		double dmainMenu = Double.parseDouble(mainMenu); 

		// performing the action
		actions.moveToElement(subCategoryAppliancesPage.viewImage).build().perform();
		// Getting the data of zoom after action
		mainMenu = subCategoryAppliancesPage.getZoomImage();
		double zoomMenu = Double.parseDouble(mainMenu.substring(mainMenu.indexOf("-"),mainMenu.indexOf("p")));
		// Verifying the zoom against the normal image
		Assert.assertTrue(dmainMenu>zoomMenu,"Image zoom successfull");


	}

}

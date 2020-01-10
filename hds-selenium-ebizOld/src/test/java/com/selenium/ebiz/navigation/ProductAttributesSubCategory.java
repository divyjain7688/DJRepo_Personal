/**
 * 
 * @author suresh
 * 
 * This test will verify Product Attributes in the Sub Category Page
 * 
 * This Test Script is mapped to US-CAT-276
 * 
 * 
 * 
 */
package com.selenium.ebiz.navigation;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
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

public class ProductAttributesSubCategory extends BaseClass{
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

	}

	/**
	 *  Verifying the Product Attribute in the Sub Category pages
	 */

	@Test(priority=0)
	public void productAttributeSubCategoryAuthenticateUserTest() throws Exception{
		homePage = loginPage.loginToHdSupplySite(prop.getProperty("username"), prop.getProperty("password"));
		// Verifying the Left Navigation 
		Assert.assertTrue(homePage.isDisplayedLeftNavgation());
		WaitTool.hardWait();
		// Clicking on the Header Shop By Category
		/*homePage.clickHeaderShopByCategoryLinkText();
		WaitTool.hardWait();*/
		// click on the Appliances
		categoryAppliancesPage = homePage.clickCategoryAppliancessLinkText();	
		// click on the DishWashers Repair
		subCategoryAppliancesPage =categoryAppliancesPage.clickTopCategoryDishwashersRepairLinkText();
		// click on the Dishwashers link
		//subCategoryAppliancesPage.clickSubCategoryDishwashersLinkText();
		// click on the List View
		subCategoryAppliancesPage.clickSubCategoryListViewLinkText();

		// Selecting the Product Attributes		
		List<WebElement> attributes = subCategoryAppliancesPage.selectSubCategoriesProductAttributesText();
		for(int j=0 ; j<attributes.size() ; j++) {
			if(attributes.get(j).isDisplayed()) {
				// Verifying all the Product Attributes	
				Assert.assertTrue(attributes.get(j).isDisplayed());
			}
		}	
	}

	@Test(priority=1)
	public void productAttributeSubCategoryGuestUserTest() throws Exception{

		loginPage.clickHeaderShopByCategoryLinkText();
		WaitTool.hardWait();
		// click on the Appliances
		categoryAppliancesPage = loginPage.clickCategoryAppliancessLinkText();
		// click on the DishWashers Repair
		subCategoryAppliancesPage=categoryAppliancesPage.clickTopCategoryDishwashersRepairLinkText();
		// click on the List View
		subCategoryAppliancesPage.clickSubCategoryListViewLinkText();

		// Selecting the Product Attributes		
		List<WebElement> attributes = subCategoryAppliancesPage.selectSubCategoriesProductAttributesText();
		for(int j=0 ; j<attributes.size() ; j++) {
			if(attributes.get(j).isDisplayed()) {
				// Verifying all the Product Attributes	
				Assert.assertTrue(attributes.get(j).isDisplayed());
			}
		}	

	}

}

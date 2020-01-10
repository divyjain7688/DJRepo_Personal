/**
 * 
 * @author suresh
 * 
 * This test will verify about the customize Item link
 * 
 * This TestScript is Mapped to the US-Cat-274
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
import com.selenium.ebiz.pageobject.CategoryPage;
import com.selenium.ebiz.pageobject.HomePage;
import com.selenium.ebiz.pageobject.LoginPage;
import com.selenium.ebiz.pageobject.SubCategory;
import com.selenium.ebiz.tools.WaitTool;


public class CustomizeThisItemSubCategory extends BaseClass{
	ArrayList<UsersListBean> usersList;
	DBCon dbConnection = new DBCon();
	LoginPage loginPage;
	HomePage homePage;
	CategoryPage categoryPage;
	SubCategory subCategory;

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
	 *  Moves from Shop by category to the Sub Category Pages and clicks on the Web Config 1 to check for customize link
	 *  Checks 0 in webConfig as Customize link will not appear
	 */	
	@Test(priority=0)
	public void verifyCustomizeThisItemSubCategoryAuthenticateUserTest() throws Exception{

		usersList = dbConnection.loadDataFromExcel("loginWithValidCredentialAndLogoutTest", "LoginTestData");
		WaitTool.hardWait();
		homePage = loginPage.loginToHdSupplySite(usersList.get(0).getuserName(), usersList.get(0).getpassword());
		/*	// Verifying the left Navigation Page
		Assert.assertTrue(homePage.isDisplayedLeftNavgation());
		WaitTool.hardWait();*/
		// click on the Shop by Category
		homePage.clickHeaderShopByCategoryLinkText();
		WaitTool.hardWait();
		// clicking on the Window coverings
		categoryPage = homePage.clickWindowCoveringsLinkText();
		// click on Blinds and Accessories
		categoryPage.clickCategoryBlindsAndAccessoriesLinkText();
		// Click on the Blinds
		subCategory=categoryPage.clickCategoryBlindsLinkText();
		// Clicking on the WebConfig Link
		subCategory.clickSubCategoryWebConfigLinkText();
		WaitTool.hardWait();
		//subCategory.getWebConfigCheckBox();
		// Selecting the Checkbox for clicking on the Customize Check Box
		List<WebElement> webCheckBox = subCategory.getWebConfigCheckBox();	
		webCheckBox.get(0).click();
		WaitTool.hardWait();
		// Clicking on the customize This link
		List<WebElement> customizeLink = subCategory.getCustomizeItemLinkText();
		customizeLink.get(0).click();
		WaitTool.hardWait();
		// Verifying if Customize this link modal is displaying or not
		Assert.assertTrue(subCategory.isDisplayedCustomizeItemModal());
		// Closing the Modal
		subCategory.clickCloseCustomizeItemModal();
		WaitTool.hardWait();
		// Deselect the checkbox of Customize this link
		webCheckBox.get(0).click();
		WaitTool.hardWait();
		// Clicking on the Web Config link
		subCategory.clickSubCategoryWebConfigLinkText();
		WaitTool.hardWait();
		//subCategory.getWebConfigCheckBox();
		// Clicking on the checkbox where Customize This item is not there
		webCheckBox = subCategory.getWebConfigCheckBox();
		webCheckBox.get(1).click();
		WaitTool.hardWait();
		// Customize This Item link is not displayed
		Assert.assertFalse(subCategory.isNotDisplayedCustomizeThisItem());		
	}

	/// NEED TO Validate

	@Test(priority=1)
	public void verifyCustomizeThisItemSubCategoryGuestUserTest() throws Exception{
		homePage = new HomePage(driver);
		// Verifying the left Navigation Page
		Assert.assertTrue(homePage.isDisplayedLeftNavgation());
		WaitTool.hardWait();
		// click on the Shop by Category
		homePage.clickHeaderShopByCategoryLinkText();
		WaitTool.hardWait();
		// clicking on the Window coverings
		categoryPage = homePage.clickWindowCoveringsLinkText();
		// click on Blinds and Accessories
		categoryPage.clickCategoryBlindsAndAccessoriesLinkText();
		// Click on the Blinds
		subCategory=categoryPage.clickCategoryBlindsLinkText();
		// Clicking on the WebConfig Link
		subCategory.clickSubCategoryWebConfigLinkText();
		WaitTool.hardWait();
		//subCategory.getWebConfigCheckBox();
		// Selecting the Checkbox for clicking on the Customize Check Box
		List<WebElement> webCheckBox = subCategory.getWebConfigCheckBox();	
		webCheckBox.get(0).click();
		WaitTool.hardWait();
		// Clicking on the customize This link
		List<WebElement> customizeLink = subCategory.getCustomizeItemLinkText();
		customizeLink.get(0).click();
		WaitTool.hardWait();
		// Verifying if Customize this link modal is displaying or not
		Assert.assertTrue(subCategory.isDisplayedCustomizeItemModal());
		// Closing the Modal
		subCategory.clickCloseCustomizeItemModal();
		WaitTool.hardWait();
		// Deselect the checkbox of Customize this link
		webCheckBox.get(0).click();
		WaitTool.hardWait();
		// Clicking on the Web Config link
		subCategory.clickSubCategoryWebConfigLinkText();
		WaitTool.hardWait();
		//subCategory.getWebConfigCheckBox();
		// Clicking on the checkbox where Customize This item is not there
		webCheckBox = subCategory.getWebConfigCheckBox();
		webCheckBox.get(1).click();
		WaitTool.hardWait();
		// Customize This Item link is not displayed
		Assert.assertFalse(subCategory.isNotDisplayedCustomizeThisItem());		
	}
}	




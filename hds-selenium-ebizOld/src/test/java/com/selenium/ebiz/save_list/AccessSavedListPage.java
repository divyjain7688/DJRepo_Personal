package com.selenium.ebiz.save_list;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.selenium.ebiz.baseclass.BaseClass;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.dbcon.DBCon;
import com.selenium.ebiz.pageobject.Appliances;
import com.selenium.ebiz.pageobject.CreateNewSavedListPage;
import com.selenium.ebiz.pageobject.HomePage;
import com.selenium.ebiz.pageobject.LoginPage;
import com.selenium.ebiz.pageobject.ProductListingPage;
import com.selenium.ebiz.pageobject.SavedListsPage;
import com.selenium.ebiz.tools.CommonFunctions;
import com.selenium.ebiz.tools.WaitTool;

public class AccessSavedListPage extends BaseClass{
	ArrayList<UsersListBean> usersList;
	HomePage homePage;
	CommonFunctions commonFunctions;
	DBCon dbConnection;
	LoginPage loginPage;
	SavedListsPage savedListPage;
	Appliances subCategoryAppliancesPage;
	ProductListingPage productListingPage;
	CreateNewSavedListPage createNewSavedListPage;


	@BeforeMethod	
	public void driverSetup() throws Exception {
		initialize();	
		//homePage = new HomePage(driver);
		commonFunctions = new CommonFunctions();
		dbConnection = new DBCon();
		loginPage = new LoginPage(driver);
		homePage = loginPage.loginToHdSupplySite(prop.getProperty("username"), prop.getProperty("password"));
	}


	/**
	 * To verify when clicked on Saved List link from the account highlights, User should be taken to Saved List Page
	 * US-cat-235
	 */

	@Test
	public void verifySavedListLink() throws Exception { 
		usersList = dbConnection.loadDataFromExcel("verifyBreadCrumbForCurrentPageUnautheticateduser","Categories");
		//To verify all utility bar links.
		Assert.assertTrue(homePage.isDisplayedtopHeadersavedlistLinkText());
		savedListPage = homePage.clickMyAccountSavedListsQuickLink();
		homePage =savedListPage.clickHeaderHDLogoImage();
		//savedListPage = homePage.clickSavedListUtilityBar();	
		String newPrivateSavedListName = CommonFunctions.getRandomString(10);
		String newSharedSavedListName = CommonFunctions.getRandomString(10);
		/*CreateNewSavedListPage createNewSavedListPage = savedListPage.clickOnCreateNewList();
		String newSavedListName = CommonFunctions.getRandomString(10);
		createNewSavedListPage.createPrivateSavedList(newSavedListName);
		createNewSavedListPage = savedListPage.clickOnCreateNewList();

		createNewSavedListPage.createPrivateSavedList(newSavedListName);
		String newSavedListName1 = CommonFunctions.getRandomString(10);
		createNewSavedListPage.createSharedSavedList(newSavedListName1);*/
		//homePage = createNewSavedListPage.clickHeaderHDLogoImage();
		/*WaitTool.hardWait();
		homePage.clickHeaderShopByCategoryLinkText();
		WaitTool.hardWait();*/
		//productListingPage = homePage.clickonCategoriesToreachProductList(driver, usersList.get(0).getCategory(), usersList.get(0).getL1SubCategory(), usersList.get(0).getL2SubCategory());
		//homePage.clickHeaderHDLogoImage();
		//WaitTool.hardWait();
		homePage.clickHeaderShopByCategoryLinkText();
		WaitTool.hardWait();
		homePage.clickOnCategoryOrSubcategory(driver, usersList.get(0).getCategory(), true);
		Assert.assertTrue(homePage.isDisplayedtopHeadersavedlistLinkText());
		homePage.clickOnCategoryOrSubcategory(driver, usersList.get(0).getL1SubCategory(), true);
		Assert.assertTrue(homePage.isDisplayedtopHeadersavedlistLinkText());
		homePage.clickOnCategoryOrSubcategory(driver, usersList.get(0).getL2SubCategory(), true);
		Assert.assertTrue(homePage.isDisplayedtopHeadersavedlistLinkText());
		//homePage.clickHeaderHDLogoImage();
		homePage.clickHeaderShopByCategoryLinkText();
		WaitTool.hardWait();
		productListingPage = homePage.clickonCategoriesToreachProductList(driver, usersList.get(0).getCategory(), usersList.get(0).getL1SubCategory(), usersList.get(0).getL2SubCategory());

		Assert.assertTrue(productListingPage.isDisplayedtopHeadersavedlistLinkText());
		productListingPage.clickOnListView();
		WaitTool.hardWait();
		/*int totalProducts = productListingPage.getAllProducts();
		for(int i=1;i<=totalProducts;i++){			
			createNewSavedListPage = productListingPage.addAllProductsToAddToList(i);
			productListingPage = createNewSavedListPage.test(newPrivateSavedListName);
			WaitTool.hardWait();			
		}	*/	
		savedListPage = productListingPage.clickSavedListUtilityBar();
		Assert.assertTrue(savedListPage.checkPrivateListSelected());
		Assert.assertTrue(savedListPage.isDisplayedAddListToCart());
		Assert.assertTrue(savedListPage.isDisplayedConvertToSharedList());
		Assert.assertTrue(savedListPage.isDisplayeddelete());
		Assert.assertTrue(savedListPage.isDisplayedaddButton());
		Assert.assertTrue(savedListPage.isDisplayedEmailList());

		savedListPage.paginationVerification();
		savedListPage.clickOnSharedLists();
		Assert.assertTrue(savedListPage.isDisplayedaddButton());
		Assert.assertTrue( savedListPage.isDisplayedAddListToCart());
		Assert.assertTrue(savedListPage.isDisplayedConvertToPrivateList());
		Assert.assertTrue(savedListPage.isDisplayeddelete());
		Assert.assertTrue(savedListPage.isDisplayedEmailList());

	}


}

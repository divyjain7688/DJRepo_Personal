package com.selenium.ebiz.save_list;

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
import com.selenium.ebiz.pageobject.ProductPage;
import com.selenium.ebiz.pageobject.SavedListsPage;
import com.selenium.ebiz.pageobject.SubCategoryAppliancesPage;
import com.selenium.ebiz.tools.WaitTool;

public class AddPartsToExistingList_PDP_WORKING extends BaseClass {
	ArrayList<UsersListBean> usersList;
	DBCon dbConnection = new DBCon();
	HomePage homePage;
	LoginPage loginPage;
	Appliances appliances;
	ProductPage productPage;
	SubCategoryAppliancesPage subcategoryAppPage;
	ProductDetailsPage productDetailsPage;
	SavedListsPage savedListsPage;
	ProductListingPage productListingPage;

	@BeforeMethod	
	public void driverSetup() throws Exception {

		driver = initialize();
		loginPage = new LoginPage(driver);
		usersList = dbConnection.loadDataFromExcel("loginWithValidCredentialAndLogoutTest", "LoginTestData");
		homePage = loginPage.loginToHdSupplySite(usersList.get(0).getuserName(), usersList.get(0).getpassword());
	}

	/**
	 * @author Smitha
	 * This test will verify Add an item to Existing list when on PDP page
	 * This TestScript is Mapped to the US-Acct-720
	 */
	@Test
	public void verifyAddPartsToExistingListOnPDPpage() throws Exception 
	{ 
		homePage.clickHeaderShopByCategoryLinkText();
		WaitTool.hardWait();
		appliances = homePage.clickCategoryAppliancesLinkText();
		subcategoryAppPage = appliances.clickTopCategoryWashersDryersLinkText();
		productPage = subcategoryAppPage.clickSubCategoryDryersLinkText();
		Assert.assertTrue(productPage.verifyProductsDisplayed());
		productDetailsPage = productPage.clickFirstProductInProductList();
		Assert.assertTrue(productDetailsPage.isDisplayedproductDetailsHeader());
		String partNumber = productDetailsPage.getPartNumber();
		String productDescription = productDetailsPage.getProductDescription();
		System.out.println("partNumber is "+ partNumber);
		System.out.println("productDescription is "+ productDescription);

		productDetailsPage.clickAddToListButton();
		Assert.assertEquals(productDetailsPage.getAddToListModalTitleText(), productDetailsPage.getProductNameText());
		Assert.assertTrue(productDetailsPage.isAddToExistingOrCreateNewListTitleTextDisplayed());
		Assert.assertTrue(productDetailsPage.isDisplayedExistingOrNewTabsOnAddToListModal());

		Assert.assertTrue(productDetailsPage.isDisplayedDefaultTabSelectedCorrectly());
		productDetailsPage.addItemToExistingList();	
		WaitTool.hardWait();
		homePage=productDetailsPage.clickOnHDSupplyLogoInHeader();
		savedListsPage = homePage.clickMyAccountSavedListsQuickLink();
		savedListsPage.clickOnExistingFirstSavedList();
		Assert.assertTrue(savedListsPage.isAddedPartDisplayedInSavedList(partNumber));
		savedListsPage.clickOnExistingFirstSavedList();
		savedListsPage.removeNewlyAddedPartFromExistingList(productDescription);

		//savedListsPage.removeProductsFromExistingList();

		/*String displayedPartNumber = savedListsPage.displayedAddedItemInExistingList();
		System.out.println("displayedPartNumber is "+ displayedPartNumber+ "partNumber is"+ partNumber);
		Assert.assertTrue(displayedPartNumber.contains(partNumber));

		//Cleanup
		savedListsPage.clickDeleteLinkText();
		WaitTool.hardWait();

		savedListsPage.deleteTheNewlyCreatedList();
		WaitTool.hardWait();
		 */
	}

}

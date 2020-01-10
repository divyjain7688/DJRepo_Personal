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

public class AddPartsToNewList_PDP_WORKING extends BaseClass {
	ArrayList<UsersListBean> usersList;
	DBCon dbConnection = new DBCon();
	
	LoginPage loginPage;
	HomePage homePage;
	Appliances appliances;
	ProductPage productPage;
	SubCategoryAppliancesPage subcategoryAppPage;
	ProductDetailsPage productDetailsPage;
	SavedListsPage savedListsPage;
	ProductListingPage productListingPage;
	
	public String newListName;
		
	@BeforeMethod
	public void driverSetup() throws Exception {
		
		driver = initialize();
		usersList = dbConnection.loadDataFromExcel("loginWithValidCredentialAndLogoutTest", "LoginTestData");
		loginPage = new LoginPage(driver);
		homePage = loginPage.loginToHdSupplySite(usersList.get(0).getuserName(), usersList.get(0).getpassword());
		newListName = "List_";
	}
	
	/**
	 * @author Smitha
	 * This test will verify Add an item to New list when on PDP page
	 * This TestScript is Mapped to the US-Acct-720
	 */
	@Test
	public void verifyAddPartsToNewListOnPDPpage() throws Exception 
	{ 
		productListingPage =homePage.moveToSubCategoryPage();
		productDetailsPage = productListingPage.clickOnFirstProduct();
		productDetailsPage.clickAddToListButton();
		Assert.assertTrue(productDetailsPage.getProductNameText().contains(productDetailsPage.getAddToListModalTitleText()));
		Assert.assertTrue(productDetailsPage.isAddToExistingOrCreateNewListTitleTextDisplayed());
		Assert.assertTrue(productDetailsPage.isDisplayedExistingOrNewTabsOnAddToListModal());
		
		Assert.assertTrue(productDetailsPage.isDisplayedDefaultTabSelectedCorrectly());
		/* Below code should be uncommented once W80-2299 issue is resolved and should add assert condition
		productDetailsPage.addItemToNewList("");
		Assert.assertTrue();
		*/		
		String newlistcreated = productDetailsPage.addItemToNewList(newListName);
		WaitTool.hardWait();
		savedListsPage = homePage.clickMyAccountSavedListsQuickLink();
		String newlistdisplayed = savedListsPage.getNewlyCreatedList();
		System.out.println("newlistdisplayed is "+ newlistdisplayed);
		System.out.println("newlistcreated is "+ newlistcreated);
		Assert.assertTrue(newlistcreated.equals(newlistdisplayed));

		productListingPage =homePage.moveToSubCategoryPage();
		productDetailsPage = productListingPage.clickOnFirstProduct();
		productDetailsPage.clickAddToListButton();
		productDetailsPage.addItemToNewListWithSameName(newlistcreated);		
		Assert.assertTrue(productDetailsPage.isAlreadyExistsListNameErrorDisplayed());
		
		productDetailsPage.closeSavedListModalWindow();
		WaitTool.hardWait();
		savedListsPage = homePage.clickMyAccountSavedListsQuickLink();
		savedListsPage.deleteTheNewlyCreatedList();
		WaitTool.hardWait();
		String latestListDisplayed = savedListsPage.getNewlyCreatedList();
		System.out.println("newlistcreated is " + newlistcreated);
		System.out.println("latestListDisplayed is " + latestListDisplayed);
		Assert.assertFalse(newlistcreated.equals(latestListDisplayed));
	}
		
}

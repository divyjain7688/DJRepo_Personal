/**
 * 
 * @author suresh
 * 
 * This test will Create the list 
 * 
 * This Test Script is mapped to US-Acct-680
 * 
 * 
 * 
 */
package com.selenium.ebiz.save_list;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.selenium.ebiz.baseclass.BaseClass;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.dbcon.DBCon;
import com.selenium.ebiz.pageobject.CreateNewSavedListPage;
import com.selenium.ebiz.pageobject.HomePage;
import com.selenium.ebiz.pageobject.LoginPage;
import com.selenium.ebiz.pageobject.SavedListsPage;
import com.selenium.ebiz.tools.WaitTool;

public class CreateNewList extends BaseClass {

	HomePage homePage;
	LoginPage loginPage;
	SavedListsPage savedListsPage;
	ArrayList<UsersListBean> usersList;
	DBCon dbConnection = new DBCon();
	CreateNewSavedListPage createNewSavedListPage;

	@BeforeMethod	
	public void driverSetup() throws Exception {
		driver = initialize();
		loginPage = new LoginPage(driver);
		homePage = loginPage.loginToHdSupplySite(prop.getProperty("username"), prop.getProperty("password"));

	}

	/**
	 * To verify when clicked on Create new List
	 * @author Suresh
	 * US-Acct-680
	 */

	@Test
	public void verifyCreateNewListAuthenticateUser() throws Exception {
		WaitTool.hardWait();
		//click on saved lists.
		savedListsPage =homePage.clickSavedListUtilityBar();
		// clicking on the Create New List Button
		createNewSavedListPage = savedListsPage.clickOnCreateNewList();
		WaitTool.hardWait();
		// Verifing the name list
		Assert.assertTrue(createNewSavedListPage.isDisplayedNameListEdit());
		// Verifying the part number edit
		Assert.assertTrue(createNewSavedListPage.isDisplayedPartNumber1Edit());
		//Verifying the Quantity Edit
		Assert.assertTrue(createNewSavedListPage.isDisplayedPartQuantity1Edit());
		// Verifying See all lists link
		Assert.assertTrue(createNewSavedListPage.isDisplayedSeeAllListsLink());
		// Click on See All Lists
		savedListsPage = createNewSavedListPage.clickSeeAllListsLink();
		WaitTool.hardWait();
		// Click on Create New List
		createNewSavedListPage = savedListsPage.clickOnCreateNewList();
		WaitTool.hardWait();
		// Verifying the Pirvate Button
		Assert.assertTrue(createNewSavedListPage.isDisplayedPrivateRadioButton());
		// Verifying Shared Button
		Assert.assertTrue(createNewSavedListPage.isDisplayedSharedRadioButton());
		// Verifying part number
		Assert.assertTrue(createNewSavedListPage.isDisplayedPartNumber1Edit());
		// Verifying Quantity
		Assert.assertTrue(createNewSavedListPage.isDisplayedPartQuantity1Edit());

		String listName = createNewSavedListPage.enterListName();
		usersList = dbConnection.loadDataFromExcel("addProductsUsingQuickOrder","QuickOrder");

		createNewSavedListPage.enterPartNumber1(usersList.get(0).getPartNumber1());
		createNewSavedListPage.enterQuantity1(usersList.get(0).getQuantity1());
		createNewSavedListPage.clickClickNewList();
		WaitTool.hardWait();

		String latestListDisplayed = savedListsPage.getNewlyCreatedList();
		System.out.println("listName is"+ listName + "latestListDisplayed is "+ latestListDisplayed );
		Assert.assertEquals(listName, latestListDisplayed);
		savedListsPage.deleteTheNewlyCreatedList();
		WaitTool.hardWait();


	}

}

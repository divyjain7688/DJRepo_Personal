/**
 * 
 * @author suresh
 * 
 * This test will remove the list from the save lists
 * 
 * This Test Script is mapped to US-Acct-710
 * 
 * 
 * 
 */
package com.selenium.ebiz.save_list;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

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
import com.selenium.ebiz.pageobject.SavedListsPage;
import com.selenium.ebiz.pageobject.SubCategoryAppliancesPage;
import com.selenium.ebiz.tools.WaitTool;


public class RemovePartFromList extends BaseClass {

	HomePage homePage;
	DBCon dbConnection;
	LoginPage loginPage;
	SavedListsPage savedListPage;
	Appliances appliances;
	SubCategoryAppliancesPage subCategoryAppliancesPage;
	ProductDetailsPage productDetailsPage;
	ArrayList<UsersListBean> usersList;
	public String newListName;	

	@BeforeMethod	
	public void driverSetup() throws Exception {
		driver = initialize();
		loginPage = new LoginPage(driver);
		homePage = loginPage.loginToHdSupplySite(prop.getProperty("username"), prop.getProperty("password"));
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		newListName = "List_"+formater.format(calendar.getTime());

	}

	/**
	 * To verify when clicked on Saved List link from the account highlights, User should be taken to Saved List Page and then remove the saved list 
	 * @author Suresh
	 * US-Acct-710
	 */

	@Test
	public void verifyRemovePartFromListAuthenticateUser() throws Exception 
	{
		savedListPage =homePage.clickSavedListUtilityBar();
		Assert.assertTrue(savedListPage.getSavedListspageHeadingText().equalsIgnoreCase("SAVED LISTS"));
		Assert.assertTrue(savedListPage.isDisplayedListOnLeftPage());
		savedListPage.clickListNameLinkText();
		Assert.assertTrue(savedListPage.isDisplayedRemoveFromListLink());
		String sBeforeRemove = savedListPage.getSaveListTotalNumberText();
		int iBeforeRemove = Integer.parseInt(sBeforeRemove);

		savedListPage.clickRemoveFromListLinkText();
		driver.switchTo().alert().accept();	
		WaitTool.hardWait();
		driver.switchTo().alert().accept();	
		WaitTool.hardWait();
		String sAfterRemove = savedListPage.getSaveListTotalNumberText();
		int iAfterRemove = Integer.parseInt(sAfterRemove);
		Assert.assertEquals(iBeforeRemove-1, iAfterRemove);
	}
}


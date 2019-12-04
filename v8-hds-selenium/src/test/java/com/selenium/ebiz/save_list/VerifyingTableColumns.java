/**
 * @author Bhavani
 * W80-5081 / FMQAECOMM-372 Verifying Table columns
 */
package com.selenium.ebiz.save_list;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;

public class VerifyingTableColumns extends BaseClassV8_ParallelGrid {

	@Test(dataProvider = "browsers")
	public void savedList_VerifySaveListPage(String browser, String version, String os, Method method) throws Exception {

		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);

		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
		pageManager.homePage().clickMyAccountSavedListsQuickLink();

		Assert.assertTrue(pageManager.savedListsPage().isDisplayedSavedListspageHeadingText());
		Assert.assertTrue(pageManager.savedListsPage().isDisplayedDownLoadTemplateLinkText());
		Assert.assertTrue(pageManager.savedListsPage().isDisplayedUpLoadTemplateLinkText());
		Assert.assertTrue(pageManager.savedListsPage().isDisplayedPrivateListsTab());
		Assert.assertTrue(pageManager.savedListsPage().isDisplayedSharedListsTab());
		Assert.assertTrue(pageManager.savedListsPage().isDisplayedsortByText());
		Assert.assertTrue(pageManager.savedListsPage().isDisplayedNumberOfListText());
		Assert.assertTrue(pageManager.savedListsPage().isShowXXPerPageTextDisplayed());
		Assert.assertTrue(pageManager.savedListsPage().isDisplayedCreateNewListButton());
		Assert.assertTrue(pageManager.savedListsPage().isDisplayedTableOfLists());
		if(pageManager.savedListsPage().getNumberOfListTextDisplayed() > 24){
			Assert.assertTrue(pageManager.savedListsPage().isDisplayedPagination());	
		}
	}
	
		@Test(dataProvider = "browsers")
		public void savedList_VerifySaveListPage_ListTable(String browser, String version, String os, Method method) throws Exception {

			this.createDriver(browser, version, os, method.getName());
			WebDriver driver = this.getWebDriver();
			PageManager pageManager = new PageManager(driver);

			pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
			pageManager.homePage().clickMyAccountSavedListsQuickLink();

			Assert.assertTrue(pageManager.savedListsPage().isDisplayedTableHeaderListNameText());
			Assert.assertTrue(pageManager.savedListsPage().isDisplayedTableHeaderItemsText());
			Assert.assertTrue(pageManager.savedListsPage().isDisplayedTableHeaderLastUpdatedText());
			Assert.assertTrue(pageManager.savedListsPage().isDisplayedTableHeaderListNotesText());
			Assert.assertTrue(pageManager.savedListsPage().isDisplayedAddListToCart());
			Assert.assertTrue(pageManager.savedListsPage().verifyAddListToCartButtonOnEachList());
			
			pageManager.savedListsPage().clickOnAddListToCartButton();
			Assert.assertTrue(pageManager.shoppingCartPage().isDisplayedShoppingCartTitle());
			

		}
	}

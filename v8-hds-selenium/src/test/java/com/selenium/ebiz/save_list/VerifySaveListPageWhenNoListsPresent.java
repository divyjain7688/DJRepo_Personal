/**
 * @author Bhavani
 * W80-5344 / FMQAECOMM-374 Verify Save list page when no lists present
 */
package com.selenium.ebiz.save_list;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;

public class VerifySaveListPageWhenNoListsPresent extends BaseClassV8_ParallelGrid {
	int zero = 0;
	@Test(dataProvider = "browsers")
	public void savedList_VerifySaveListPageNoLists(String browser, String version, String os, Method method) throws Exception {

		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);

		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
		pageManager.homePage().clickMyAccountSavedListsQuickLink();

		Assert.assertTrue(pageManager.savedListsPage().isDisplayedSavedListspageHeadingText());
		Assert.assertTrue(pageManager.savedListsPage().isDisplayedCreateNewListButton());
		pageManager.savedListsPage().deleteListWithZeroProducts();
		if(pageManager.savedListsPage().getNumberOfListTextDisplayed()== zero){
			Assert.assertEquals(pageManager.savedListsPage().getNumberOfListTextDisplayed(),0);
			Assert.assertTrue(pageManager.savedListsPage().isDisplayedMsgToAddNewList());
		}else{
			System.out.println("Save List is not empty skip the test ");
		}

		
	}


}

/**
 * @author Bhavani
 * W80-5096 / FMQAECOMM-371 Verifying Saved list Detail page
 */
package com.selenium.ebiz.save_list;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;

public class VerifyingSavedListDetailPage extends BaseClassV8_ParallelGrid {

	@Test(dataProvider = "browsers")
	public void savedList_VerifySavedListDetailPage(String browser, String version, String os, Method method) throws Exception {

		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);

		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
		pageManager.homePage().clickMyAccountSavedListsQuickLink();
		pageManager.savedListsPage().clickOnExistingFirstSavedList();

		pageManager.savedListsDetailPage().isSavedListDetailPageTitle();
		Assert.assertTrue(pageManager.savedListsDetailPage().listNameText.isDisplayed());
		Assert.assertTrue(pageManager.savedListsDetailPage().lastUpdatedText.isDisplayed());
		Assert.assertTrue(pageManager.savedListsDetailPage().notesText.isDisplayed());
		Assert.assertTrue(pageManager.savedListsDetailPage().addListToCartButton.isDisplayed());
		Assert.assertTrue(pageManager.savedListsDetailPage().addPartsToListFeature.isDisplayed());
		Assert.assertTrue(pageManager.savedListsDetailPage().printBinLabelsLink.isDisplayed());
		Assert.assertTrue(pageManager.savedListsDetailPage().convertToSharedListLink.isDisplayed());
		Assert.assertTrue(pageManager.savedListsDetailPage().emailListLink.isDisplayed());
		Assert.assertTrue(pageManager.savedListsDetailPage().downloadTemplateLink.isDisplayed());
		Assert.assertTrue(pageManager.savedListsDetailPage().uploadTemplateLink.isDisplayed());
		Assert.assertTrue(pageManager.savedListsDetailPage().deleteLink.isDisplayed());

	}
}

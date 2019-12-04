package com.selenium.ebiz.save_list;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

/**
 * @author dj073227
 * W80-5412 W80-5079/FMQAECOMM-360
 */
public class VerifySaveListDetailsPageWhenNoListsPresent extends BaseClassV8_ParallelGrid {
    int totalNumberOfListTextDisplayed;

    @Test(dataProvider = "browsers", enabled = false)
    public void savedList_VerifySaveListDetailsPageWhenNoListsPresent(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);

        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        pageManager.homePage().moveToSubCategoryPage();
        pageManager.productListingPage().clickOnProductListingPageFirstProductName();
        pageManager.productDetailsPage().clickAddToListButton();
        pageManager.addToExistingORCreateNewList_modal().createNewListInAddToListModal();
        pageManager.savedListsPage().navigateToSavedListPageAndClickOnRecentlyUpdatedList();
        pageManager.savedListsPage().clickOnExistingFirstSavedList();
        //pageManager.savedListsPage().removeProductsFromExistingList();
        pageManager.savedListsDetailPage().removeAllProducts();
        Assert.assertTrue(pageManager.savedListsDetailPage().zeroItemsInListText.isDisplayed());
        Assert.assertTrue(pageManager.savedListsDetailPage().addPartsToYourListText.isDisplayed());
        Assert.assertTrue(pageManager.savedListsDetailPage().listNameText.isDisplayed());
        Assert.assertTrue(pageManager.savedListsDetailPage().lastUpdatedText.isDisplayed());
        Assert.assertTrue(pageManager.savedListsDetailPage().notesText.isDisplayed());
        Assert.assertTrue(pageManager.savedListsDetailPage().addPartsToListFeature.isDisplayed());
        Assert.assertTrue(pageManager.savedListsDetailPage().manageListText.isDisplayed());

    }
}
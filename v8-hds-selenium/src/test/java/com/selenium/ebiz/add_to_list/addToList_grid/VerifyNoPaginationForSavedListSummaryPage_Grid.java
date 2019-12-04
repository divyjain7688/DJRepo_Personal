package com.selenium.ebiz.add_to_list.addToList_grid;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;


/**
 * @author Divy Jain
 * <p>
 * FMQA-2368 Verify Pagination - No Pagination for Saved List Summary Page
 * <p>
 * ALM Test Instance ID: 649218
 * <p>
 * Modified: Iuliia
 */

public class VerifyNoPaginationForSavedListSummaryPage_Grid extends BaseClassV8_ParallelGrid {
    public int numbertOfListTextDisplayed, numbertOfListDisplayed;

    @Test(dataProvider = "browsers")
            //, description = "Verify No Pagination On Shared Saved Lists
    public void addtolist_verifyNoPaginationOnSharedSavedLists(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);

        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        //pageManager.loginPage().loggedAccountNumberText.isDisplayed();
        pageManager.homePage().clickSavedListUtilityBar();
        pageManager.savedListsPage().checkPrivateListSelected();
        pageManager.savedListsPage().clickOnPrivateLists();
        numbertOfListTextDisplayed = pageManager.savedListsPage().getNumberOfListTextDisplayed();
        numbertOfListDisplayed = pageManager.savedListsPage().getNumberOfListDisplayed();
        System.out.println("numbertOfListTextDisplayed " + numbertOfListTextDisplayed + "numbertOfListDisplayed " + numbertOfListDisplayed);
        Assert.assertEquals(numbertOfListTextDisplayed, numbertOfListDisplayed);
        pageManager.savedListsPage().clickOnSharedLists();
        numbertOfListTextDisplayed = pageManager.savedListsPage().getNumberOfListTextDisplayed();
        numbertOfListDisplayed = pageManager.savedListsPage().getNumberOfListDisplayed();
        System.out.println("numbertOfListTextDisplayed " + numbertOfListTextDisplayed + "numbertOfListDisplayed " + numbertOfListDisplayed);
        Assert.assertEquals(numbertOfListTextDisplayed, numbertOfListDisplayed);
    }
}

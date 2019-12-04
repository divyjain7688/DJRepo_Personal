package com.selenium.ebiz.add_to_list.addToList_nonParallelTests;

import com.selenium.ebiz.baseclass.BaseClassV8_Parallel;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.testng.Assert;
import org.testng.annotations.Test;


/**
 * @author Divy Jain
 * <p>
 * FMQA-2368 Verify Pagination - No Pagination for Saved List Summary Page
 * <p>
 * ALM Test Instance ID: 649218
 */

public class VerifyNoPaginationForSavedListSummaryPage extends BaseClassV8_Parallel {
    public int numbertOfListTextDisplayed, numbertOfListDisplayed;

    @Test(description = "Login")
    public void testLogin() {
        LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        Assert.assertTrue(pageManager.loginPage().loggedAccountNumberText.isDisplayed());
    }

    @Test(dependsOnMethods = {"testLogin"}, description = "Navigate To Saved Lists")
    public void test_navigateToPrivateSavedLists() throws InterruptedException {
        pageManager.homePage().clickSavedListUtilityBar();
        Assert.assertTrue(pageManager.savedListsPage().checkPrivateListSelected());
    }

    @Test(dependsOnMethods = {"test_navigateToPrivateSavedLists"}, description = "Verify No Pagination On Private Saved Lists")
    public void test_verifyNoPaginationOnPrivateSavedLists() throws InterruptedException {
        pageManager.savedListsPage().clickOnPrivateLists();
        numbertOfListTextDisplayed = pageManager.savedListsPage().getNumberOfListTextDisplayed();
        numbertOfListDisplayed = pageManager.savedListsPage().getNumberOfListDisplayed();
        Assert.assertEquals(numbertOfListTextDisplayed, numbertOfListDisplayed);
    }

    @Test(dependsOnMethods = {"test_verifyNoPaginationOnPrivateSavedLists"}, description = "Verify No Pagination On Private Saved Lists")
    public void test_verifyNoPaginationOnSharedSavedLists() throws InterruptedException {
        pageManager.savedListsPage().clickOnSharedLists();
        numbertOfListTextDisplayed = pageManager.savedListsPage().getNumberOfListTextDisplayed();
        numbertOfListDisplayed = pageManager.savedListsPage().getNumberOfListDisplayed();
        Assert.assertEquals(numbertOfListTextDisplayed, numbertOfListDisplayed);
    }
}

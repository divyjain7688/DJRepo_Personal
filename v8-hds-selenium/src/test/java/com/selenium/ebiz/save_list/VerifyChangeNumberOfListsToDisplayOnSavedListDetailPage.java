package com.selenium.ebiz.save_list;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.Arrays;

public class VerifyChangeNumberOfListsToDisplayOnSavedListDetailPage extends BaseClassV8_ParallelGrid {

    /**
     * @author dj073227
     * W80-4847 :01/FMQAECOMM-359
     */
    @Test(dataProvider = "browsers")
    public void savedList_VerifyChangeNumberOfListsToDisplayOnSavedListDetailPage(String browser, String version, String os, Method method) throws Exception {
        int expecteddropdownValues[] = {24, 48, 72, 96, 120};
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);
        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        pageManager.homePage().clickMyAccountSavedListsQuickLink();
        pageManager.savedListsPage().clickFirstSavedListNameLinkText();
        pageManager.savedListsDetailPage().addPartsToListIfListIsEmpty();
        pageManager.savedListsDetailPage().isShowXXPerPageTextDisplayed();
		/*	pageManager.savedListsPage().selectListNameAToZFromSortByDropdown();
		pageManager.savedListsPage().isListNameDisplayedInAscendingOrder();*/
        pageManager.savedListsPage().VerifyTheListGetSortedBy("List Name A-Z");
        pageManager.savedListsDetailPage().getDefaultValueFromShowPerPageDropdown().equals("24");
        int actualdropdownValues[] = pageManager.savedListsDetailPage().getAllOptionsFromShowPerPageDropdown();
        Assert.assertTrue(Arrays.equals(expecteddropdownValues, actualdropdownValues));
    }
}

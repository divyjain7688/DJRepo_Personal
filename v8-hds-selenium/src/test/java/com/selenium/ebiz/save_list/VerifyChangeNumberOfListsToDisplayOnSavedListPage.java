package com.selenium.ebiz.save_list;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.Arrays;

public class VerifyChangeNumberOfListsToDisplayOnSavedListPage extends BaseClassV8_ParallelGrid {

    /**
     * @author dj073227
     * W80-4832:01/FMQAECOMM-362
     */
    @Test(dataProvider = "browsers")
    public void savedList_VerifyChangeNumberOfListsToDisplayOnSavedListPage(String browser, String version, String os, Method method) throws Exception {
        int expecteddropdownValues[] = {24, 48, 72, 96, 120};
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);
        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        pageManager.homePage().clickMyAccountSavedListsQuickLink();
        pageManager.savedListsPage().isShowXXPerPageTextDisplayed();
	/*	pageManager.savedListsPage().selectListNameAToZFromSortByDropdown();
		pageManager.savedListsPage().isListNameDisplayedInAscendingOrder();*/
        pageManager.savedListsPage().VerifyTheListGetSortedBy("List Name A-Z");
        pageManager.savedListsPage().getDefaultValueFromShowPerPageDropdown().equals("24");
        int actualdropdownValues[] = pageManager.savedListsPage().getAllOptionsFromShowPerPageDropdown();
        Assert.assertTrue(Arrays.equals(expecteddropdownValues, actualdropdownValues));
    }
}
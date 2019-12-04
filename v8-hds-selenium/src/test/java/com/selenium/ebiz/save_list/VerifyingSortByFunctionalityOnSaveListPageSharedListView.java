package com.selenium.ebiz.save_list;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class VerifyingSortByFunctionalityOnSaveListPageSharedListView extends BaseClassV8_ParallelGrid {
    /*
    Designed by: Divy Jain
    W80-5341 W80-4817:03/ FMQAECOMM-363
     */


    @Test(dataProvider = "browsers")
    public void savedList_VerifyingSortByFunctionalityOnSaveListPageSharedListView(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);
        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        pageManager.homePage().clickMyAccountSavedListsQuickLink();
        pageManager.savedListsPage().clickOnSharedLists();
        pageManager.savedListsPage().VerifyTheListGetSortedBy("List Name Z-A");
        pageManager.savedListsPage().VerifyTheListGetSortedBy("List Name A-Z");
        pageManager.savedListsPage().VerifyTheListGetSortedBy("Recently Updated");
    }
}

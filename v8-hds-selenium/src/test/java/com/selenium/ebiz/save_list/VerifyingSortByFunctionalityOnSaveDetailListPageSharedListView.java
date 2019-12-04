package com.selenium.ebiz.save_list;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class VerifyingSortByFunctionalityOnSaveDetailListPageSharedListView extends BaseClassV8_ParallelGrid {

    /*
    Designed by: Iuliia
    W80-5340 /  FMQAECOMM-364
     */


    @Test(dataProvider = "browsers")

    public void savedList_VerifyingSortByFunctionalityOnSaveDetailListPageSharedListView(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);

        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        pageManager.homePage().clickMyAccountSavedListsQuickLink();

        pageManager.savedListsPage().clickOnSharedLists();
        pageManager.savedListsPage().clickOnExistingFirstSavedList();
        pageManager.savedListsDetailPage().isSavedListDetailPageTitle();
        pageManager.savedListsDetailPage().VerifyTheListGetSortedBy("Product Name Z-A");
        pageManager.savedListsDetailPage().VerifyTheListGetSortedBy("Product Name A-Z");
        pageManager.savedListsDetailPage().VerifyTheListGetSortedBy("Recently Updated");

    }
}

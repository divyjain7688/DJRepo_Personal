package com.selenium.ebiz.save_list;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
/*
@Author: Iuliia
FMQAECOMM-369 / W80-5100
 */

public class VerifyingSortByFunctionalityOnSaveListDetailPage extends BaseClassV8_ParallelGrid {

    @Test(dataProvider = "browsers")
    public void savedList_VerifyingSortByFunctionalityOnSaveListDetailPage(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);

        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        pageManager.homePage().clickMyAccountSavedListsQuickLink();
        pageManager.savedListsPage().clickOnExistingFirstSavedList();
        pageManager.savedListsDetailPage().isSavedListDetailPageTitle();
        pageManager.savedListsDetailPage().VerifyTheListGetSortedBy("Product Name Z-A");
        pageManager.savedListsDetailPage().VerifyTheListGetSortedBy("Product Name A-Z");
        pageManager.savedListsDetailPage().VerifyTheListGetSortedBy("Recently Updated");
    }
}

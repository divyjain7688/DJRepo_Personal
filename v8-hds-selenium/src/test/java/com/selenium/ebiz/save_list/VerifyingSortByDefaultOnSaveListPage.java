package com.selenium.ebiz.save_list;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class VerifyingSortByDefaultOnSaveListPage extends BaseClassV8_ParallelGrid {
    /*
    Designed by: Iuliia
    W80-5326 / FMQAECOMM-365
     */
    @Test(dataProvider = "browsers")

    public void savedList_VerifyingSortByDefaultOnSaveListPage(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);

        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        pageManager.homePage().clickMyAccountSavedListsQuickLink();
        Assert.assertTrue(pageManager.savedListsPage().recentlyUpdatedLink.isDisplayed());

    }
}

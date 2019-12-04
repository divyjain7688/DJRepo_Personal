package com.selenium.ebiz.save_list;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class VerifyChangeTheNumberOfListsFunctionalityOnSavedListPage extends BaseClassV8_ParallelGrid {

    /**
     * @author dj073227
     * W80-5343 W80-4832 :02/FMQAECOMM-361
     */
    @Test(dataProvider = "browsers")
    public void savedList_VerifyChangeTheNumberOfListsFunctionalityOnSavedListPage(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);
        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        pageManager.homePage().clickMyAccountSavedListsQuickLink();
        pageManager.savedListsPage().isShowXXPerPageTextDisplayed();
        pageManager.savedListsPage().verifyPaginationWhenOptionIsSelectedFromDropdown("24");
        pageManager.savedListsPage().verifyPaginationWhenOptionIsSelectedFromDropdown("48");
        pageManager.savedListsPage().verifyPaginationWhenOptionIsSelectedFromDropdown("72");
        pageManager.savedListsPage().verifyPaginationWhenOptionIsSelectedFromDropdown("96");
        pageManager.savedListsPage().verifyPaginationWhenOptionIsSelectedFromDropdown("120");
        pageManager.savedListsPage().verifyNumberOfListDisplayed("24");
        pageManager.savedListsPage().verifyNumberOfListDisplayed("48");
        pageManager.savedListsPage().verifyNumberOfListDisplayed("72");
        pageManager.savedListsPage().verifyNumberOfListDisplayed("96");
        pageManager.savedListsPage().verifyNumberOfListDisplayed("120");
    }

}

package com.selenium.ebiz.save_list;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class VerifyChangeTheNumberOfListsFunctionalityOnSavedListDetailsPageOnPagination extends BaseClassV8_ParallelGrid {
    /**
     * @author dj073227
     * W80-5424 W80-4847 :02/FMQAECOMM-358
     */
    @Test(dataProvider = "browsers")
    public void savedList_VerifyChangeTheNumberOfListsFunctionalityOnSavedListDetailsPageOnPagination(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);
        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        pageManager.homePage().clickMyAccountSavedListsQuickLink();
        pageManager.savedListsPage().isShowXXPerPageTextDisplayed();
        pageManager.savedListsPage().clickFirstSavedListNameLinkText();
        pageManager.savedListsDetailPage().addPartsToListIfListIsEmpty();
        pageManager.savedListsDetailPage().isShowXXPerPageTextDisplayed();
        pageManager.savedListsDetailPage().verifyPaginationWhenOptionIsSelectedFromDropdown("24");
        pageManager.savedListsDetailPage().verifyPaginationWhenOptionIsSelectedFromDropdown("48");
        pageManager.savedListsDetailPage().verifyPaginationWhenOptionIsSelectedFromDropdown("72");
        pageManager.savedListsDetailPage().verifyPaginationWhenOptionIsSelectedFromDropdown("96");
        pageManager.savedListsDetailPage().verifyPaginationWhenOptionIsSelectedFromDropdown("120");
        pageManager.savedListsDetailPage().verifyNumberOFItemDisplayed("24");
        pageManager.savedListsDetailPage().verifyNumberOFItemDisplayed("48");
        pageManager.savedListsDetailPage().verifyNumberOFItemDisplayed("72");
        pageManager.savedListsDetailPage().verifyNumberOFItemDisplayed("96");
        pageManager.savedListsDetailPage().verifyNumberOFItemDisplayed("120");
    }
    
    /**
     * @author bm071260
     * This test case is mapped with FMQAECOMM-357
     */
    @Test(dataProvider = "browsers")
    public void savedList_VerifyChangeTheNumberOfListsFunctionalityOnSavedListDetailsPageFromSecondPage(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);
        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
       
        pageManager.homePage().clickMyAccountSavedListsQuickLink();
        pageManager.savedListsPage().isShowXXPerPageTextDisplayed();
        pageManager.savedListsPage().clickFirstSavedListNameLinkText();

        pageManager.savedListsDetailPage().verifyPaginationWhenOptionIsSelectedFromDropdownInNextPage("48");
        pageManager.savedListsDetailPage().verifyPaginationWhenOptionIsSelectedFromDropdownInNextPage("72");
        pageManager.savedListsDetailPage().verifyPaginationWhenOptionIsSelectedFromDropdownInNextPage("96");
        pageManager.savedListsDetailPage().verifyPaginationWhenOptionIsSelectedFromDropdownInNextPage("120");
       
    }
}

package com.selenium.ebiz.peachtree;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class FlashPeachtreeFunctionality extends BaseClassV8_ParallelGrid {
    ArrayList<UsersListBean> usersList;

    /**
     * - dj073227
     * FMQAECOMM-116 - eComm Discover how to automate Flash Peachtree functionality
     */
    @Test(description = "Verify Flash Peachtree Functionality", dataProvider = "browsers")
    public void VerifyFlashPeachtreeFunctionality(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);
        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        usersList = pageManager.dBCon().loadDataFromExcel("searchForCustomSign", "Search");
        pageManager.homePage().searchByKeywordOrPartNumber(usersList.get(0).getSearchProductKeyword());
        pageManager.productListingPage().clickOnFirstCustomizeThisItemLinks();
        pageManager.customizeConfigModal().clickOngetAdobeFlashPlayer();
        pageManager.productListingPage().clickOnFirstCustomizeThisItemLinks();
        pageManager.common().scrollDown(driver);
        pageManager.customizeConfigModal().isflashContentDispalyed();

    }
}

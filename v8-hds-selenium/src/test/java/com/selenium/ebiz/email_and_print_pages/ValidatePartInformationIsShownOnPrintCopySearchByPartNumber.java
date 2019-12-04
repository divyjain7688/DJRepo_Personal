package com.selenium.ebiz.email_and_print_pages;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class ValidatePartInformationIsShownOnPrintCopySearchByPartNumber extends BaseClassV8_ParallelGrid {
    /*
    designed by Iuliia: W80-6974
    search by Part number, click Shop Parts on PDP.
     */

    private ArrayList<UsersListBean> usersList;

    @Test(dataProvider = "browsers")
    public void printPageAndEmail_ValidatePartInformationIsShownOnPrintCopySearchByPartNumber(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);
        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        usersList = pageManager.dBCon().loadDataFromExcel("searchByShopPartsProductType", "Search");
        Log.info("search model:  " + usersList.get(0).getSearchProductPartNumber());
        pageManager.homePage().searchByKeywordOrPartNumber(usersList.get(0).getSearchProductPartNumber());
        pageManager.productDetailsPage().isProductDetailsTitleDisplayed();
        pageManager.productDetailsPage().shopPartsLink.click();
        pageManager.partsLinkPage().maytagModelNumber.isDisplayed();
        pageManager.partsLinkPage().listProdDiagramOpenButtons.get(1).click();
        Assert.assertTrue(pageManager.partsLinkPage().selectedPartHeaderTitle.isDisplayed());
        Assert.assertTrue(pageManager.commonPageObjects().printIconReparePartPage.isDisplayed());
        Assert.assertTrue(pageManager.commonPageObjects().emailPageLinkReparePartPage.isDisplayed());

    }
}

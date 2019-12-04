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

public class ValidatePartInformationIsShownOnPrintCopySearchByModelNumber extends BaseClassV8_ParallelGrid {
    /*
    designed by Iuliia: W80-6971
    Search model number on parts link page, open one product and validate print and email icons
     */

    private ArrayList<UsersListBean> usersList;

    @Test(dataProvider = "browsers")
    public void printPageAndEmail_VerifyPrintAndEmailIconsOnSearchedModelNumber(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);
        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        pageManager.homePage().headerPartsLink.click();
        usersList = pageManager.dBCon().loadDataFromExcel("searchByPartsLinkModel", "Search");
        Log.info("search model:  " + usersList.get(0).getSearchProductPartNumber());
        pageManager.partsLinkPage().searchByInputOnPartsLinkPage(usersList.get(0).getSearchProductPartNumber());
        pageManager.partsLinkPage().maytagModelNumber.isDisplayed();
        pageManager.partsLinkPage().listProdDiagramOpenButtons.get(1).click();
        Assert.assertTrue(pageManager.partsLinkPage().selectedPartHeaderTitle.isDisplayed());
        Assert.assertTrue(pageManager.commonPageObjects().printIconReparePartPage.isDisplayed());
        Assert.assertTrue(pageManager.commonPageObjects().emailPageLinkReparePartPage.isDisplayed());

    }
}

package com.selenium.ebiz.shoppingCart_UI;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class VerifyCreateOrEditSavedList extends BaseClassV8_ParallelGrid {
    /*
    designed by: Iuliia
    mapped with ALM test id:660538
    JIRA story: FMQAECOMM-444
     */

    private ArrayList<UsersListBean> usersList;

    @Test(dataProvider = "browsers")
    public void shoppingcartUI_VerifyCreateOrEditSavedList(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);
        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        usersList = pageManager.dBCon().loadDataFromExcel("searchByKeywordOrPartNumber", "Search");
        pageManager.homePage().searchByKeywordOrPartNumber(usersList.get(0).getSearchProductPartNumber());
        pageManager.productDetailsPage().addToCartPDP();
        pageManager.homePage().clickOnShoppingCartIcon();
        pageManager.shoppingCartPage().isAddToListBtnAtProductListDisplayed();
        pageManager.shoppingCartPage().clickCreateOrEditSavedList();
        Assert.assertTrue(pageManager.addToExistingORCreateNewList_modal().isDisplayedExistingOrNewTabsOnAddToListModal());
    }
}

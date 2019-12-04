/**
 * @author Bhavani
 * <p>
 * Naveed provided test scenarios via email
 */
package com.selenium.ebiz.search;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;


public class VerifyIfItemCanBeSearchedByEnteringIntoSearch extends BaseClassV8_ParallelGrid {
    int tiles = 24;
    public String searchKey, searchKey1;

    private ArrayList<UsersListBean> usersList;

    @Test(dataProvider = "browsers", enabled = true)
    public void search_VerifyIfItemCanBeSearchedByEnteringIntoSearch
            (String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);

        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());

        //pageManager.homePage().searchByKeywordOrPartNumber("yellow");
        usersList = pageManager.dBCon().loadDataFromExcel("searchByYellow", "Search");
        searchKey = usersList.get(0).getSearchProductKeyword();
        pageManager.homePage().searchByKeywordOrPartNumber(searchKey);

        pageManager.productListingPage().plpHeadingText.isDisplayed();

        pageManager.productListingPage().isDisplayedRightPagination();
        pageManager.productListingPage().rightPagination.click();

        Assert.assertEquals(pageManager.productListingPage().getNoOfTiles(), tiles);

    }

    @Test(dataProvider = "browsers",enabled = true)
    public void search_VerifyIfItemCanBeSearchedByEnteringIntoSearchByDesc
            (String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);

        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());

        //pageManager.homePage().searchByKeywordOrPartNumber("black");
        usersList = pageManager.dBCon().loadDataFromExcel("searchByBlack", "Search");
        searchKey1 = usersList.get(0).getSearchProductKeyword();
        pageManager.homePage().searchByKeywordOrPartNumber(searchKey1);
        pageManager.productListingPage().plpHeadingText.isDisplayed();

        pageManager.productListingPage().isDisplayedRightPagination();
        pageManager.productListingPage().rightPagination.click();
        Assert.assertEquals(pageManager.productListingPage().getNoOfTiles(), tiles);

    }


}

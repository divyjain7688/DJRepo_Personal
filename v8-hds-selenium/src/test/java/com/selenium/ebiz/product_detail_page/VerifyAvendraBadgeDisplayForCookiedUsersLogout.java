package com.selenium.ebiz.product_detail_page;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class VerifyAvendraBadgeDisplayForCookiedUsersLogout extends BaseClassV8_ParallelGrid {

    /*
    designed by: Iuliia
    mapped with: W80-6763
     */

    private ArrayList<UsersListBean> usersList;

    @Test(dataProvider = "browsers")
    public void pdp_VerifyAvendraBadgeDisplayForCookiedUsersLogout(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);
     //   driver.manage().getCookies();
        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.avendraUser.pop(),configread.getPassword());
        usersList = pageManager.dBCon().loadDataFromExcel("discontinuedPart", "Search");
        pageManager.homePage().searchByKeywordOrPartNumber(usersList.get(0).getSearchProductKeyword());
        pageManager.productDetailsPage().isProductDetailsTitleDisplayed();
        pageManager.productDetailsPage().isPriceDisplayed();
        pageManager.productDetailsPage().isDiscontinuedPriceDisplayed();
        pageManager.productDetailsPage().isImageThumbnailsDisplayed();
        pageManager.loginPage().logoutOfApplication();
        pageManager.homePage().searchByKeywordOrPartNumber(usersList.get(0).getSearchProductKeyword());
        pageManager.productDetailsPage().isProductDetailsTitleDisplayed();
        pageManager.productDetailsPage().isPriceDisplayed();
        pageManager.productDetailsPage().isDiscontinuedPriceDisplayed();
        pageManager.productDetailsPage().isImageThumbnailsDisplayed();
    }
}

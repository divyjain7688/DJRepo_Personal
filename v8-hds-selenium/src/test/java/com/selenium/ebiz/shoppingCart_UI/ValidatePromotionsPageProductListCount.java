package com.selenium.ebiz.shoppingCart_UI;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class ValidatePromotionsPageProductListCount extends BaseClassV8_ParallelGrid {

    @Test(dataProvider = "browsers")

    public void shoppingcartUI_ValidatePromotionsPageProductListCount(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);
        pageManager.homePage().clickOfferLink();
        pageManager.offerPage().offersPageTitleText.isDisplayed();
        pageManager.offerPage().clickOnTheOfferDetail(1);
        int prelogin = pageManager.offerPage().getNumberOfAllListedProducts();
        Log.info(prelogin);
        pageManager.commonLogin().LoginToHDSFromAnyPage(RandomAccountSelect.users.pop(),configread.getPassword());
        int postlogin = pageManager.offerPage().getNumberOfAllListedProducts();
        Log.info(postlogin);
        Assert.assertEquals(prelogin,postlogin);

    }
}

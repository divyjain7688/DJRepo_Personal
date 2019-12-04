package com.selenium.ebiz.shoppingCart_management;
/**
 * @author Bhavani
 * FMQAECOMM-184 [1]Access to Shopping Cart Page directly_Post Login
 * ALM Test Instance ID: 657860
 */

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class AccessToShoppingCartPageDirectly_PostLogin extends BaseClassV8_ParallelGrid {

    @Test(dataProvider = "browsers")
    public void shopCartManagement_AccessToShoppingCartPageDirectly_PostLogin(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);

        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        pageManager.homePage().clickOnShoppingCartIcon();

        pageManager.shoppingCartPage().checkCartEmptyOrPartsDisplayed();

        Assert.assertTrue(pageManager.shoppingCartPage().isDisplayedShoppingCartTitle());


    }
}

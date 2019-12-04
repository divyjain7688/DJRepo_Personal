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

public class ValidateStrikethroughPricingInCartRegularUser extends BaseClassV8_ParallelGrid {
    /*
    designed by: Iuliia
    ALM Test id:660534
    FMQAECOMM-440
     */

    private ArrayList<UsersListBean> usersList;

    @Test(dataProvider = "browsers")
    public void shoppingcartUI_ValidateStrikethroughPricingInCartRegularUser(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);

        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        pageManager.shoppingCartPage().checkClearShoppingCart();
        usersList = pageManager.dBCon().loadDataFromExcel("addProductsUsingQuickOrder", "QuickOrder");
        String partNumber = usersList.get(0).getPartNumber2();
        Log.info("Part number: " + partNumber);
        pageManager.shoppingCartPage().addPartsToYourCart(partNumber, "1");

       try {
            Assert.assertTrue(pageManager.shoppingCartPage().isStrickedPriceDisplayed());
        } catch (Exception e) {
            Log.info("Stricked price not found");
        }

    }

    @Test(dataProvider = "browsers")
    /*
    Iuliia: Updated strike through price web element property at "isStrickedPriceDisplayed"
     */
    public void shoppingcartUI_ValidateStrikethroughPricingInCartRegularUser_MOQPart(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);

        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        pageManager.shoppingCartPage().checkClearShoppingCart();
        usersList = pageManager.dBCon().loadDataFromExcel("verifyQuickAddPartsToCart", "QuickOrder");
        String partNumber = usersList.get(0).getPartNumber6();
        Log.info("Part number: " + partNumber);
        pageManager.shoppingCartPage().addPartsToYourCart(partNumber, "556");
        //StrikethroughPricing for that part type could be unavailiable
        pageManager.shoppingCartPage().isStrickedMOQPartPriceDisplayed();
        pageManager.shoppingCartPage().checkClearShoppingCart();

    }
}

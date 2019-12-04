/**
 * @author Bhavani
 * <p>
 * FMQA-2362 08_To Verify if item can be added to the cart from Shopping Cart Page
 * <p>
 * ALM Test Instance ID: 649222
 */
package com.selenium.ebiz.add_to_cart.addToCart_grid;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;


public class VerifyIfItemCanBeAddedToTheCartFromShoppingCartPage_Grid extends BaseClassV8_ParallelGrid {

    /**
     *  Verifying the add to Cart from PLP List View
     * @throws Exception
     *
     * added driver.navigate().refresh() - 4/1/2019
     * Commented line 45 as each time counter value is increased by 1 when executed 10 times - 08/06/2019 - Bhavani
     */

    int productAddedToCart = 1, displayedShoppingCartProductCount;
    private ArrayList<UsersListBean> usersList;

    @Test(dataProvider = "browsers", enabled = true)
    public void addtocart_verifyPartNumberOfItemAddedToCart(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);
        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        pageManager.shoppingCartPage().checkClearShoppingCart();
        usersList = pageManager.dBCon().loadDataFromExcel("verifyQuickAddPartsToCart", "QuickOrder");
        pageManager.shoppingCartPage().addPartsToYourCart(usersList.get(0).getPartNumber1(), usersList.get(0).getQuantity1());
        driver.navigate().refresh();
        //productAddedToCart = pageManager.homePage().counterIncrease(productAddedToCart);
        Log.info("productAddedToCart is " + productAddedToCart);
        displayedShoppingCartProductCount = pageManager.homePage().getShoppingCartProductCount();
        Log.info("displayedShoppingCartProductCount is " + displayedShoppingCartProductCount);
        String part = "PART " + usersList.get(0).getPartNumber1();
        Log.info(pageManager.shoppingCartPage().partNumberDisplayed_text.getText());
        Assert.assertEquals(productAddedToCart, displayedShoppingCartProductCount);
        Assert.assertEquals(pageManager.shoppingCartPage().partNumberDisplayed_text.getText(), part);


    }

}

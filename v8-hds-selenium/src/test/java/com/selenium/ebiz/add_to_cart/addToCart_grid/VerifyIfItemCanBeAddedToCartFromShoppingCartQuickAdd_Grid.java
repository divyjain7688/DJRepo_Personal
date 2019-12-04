/**
 * @author Bhavani
 * <p>
 * FMQA-2352 Add to cart [1]To Verify if item can be added to cart from Shopping Cart Quick Add
 * <p>
 * ALM Test Instance ID: 649230
 * <p>
 * modified: Iuliia
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

import static org.testng.Assert.assertNotEquals;


public class VerifyIfItemCanBeAddedToCartFromShoppingCartQuickAdd_Grid extends BaseClassV8_ParallelGrid {

    String priceOnSCP;
    private ArrayList<UsersListBean> usersList;
    /*
            7/29/2019 Bhavani: Updated data in InputExcel Sheet to "9270912"
    */
    @Test(dataProvider = "browsers")
    public void addtocart_EnterInvalidPartNumbersToTheShoppingCart(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);

        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        Log.info("Login");
        pageManager.shoppingCartPage().checkClearShoppingCart();
        Log.info("Clear the cart");
        usersList = pageManager.dBCon().loadDataFromExcel("invalidPartNumber", "QuickOrder");
        String partNumInvalid = usersList.get(0).getPartNumber1();
        Log.info(" ******* partNumInvalid: " + partNumInvalid);
        pageManager.shoppingCartPage().enterPartNumber(partNumInvalid);
        String partNumValid = pageManager.shoppingCartPage().getPartNumber();
        Log.info(" ******* partNumValid: " + partNumValid);
        assertNotEquals(partNumValid, partNumInvalid);
    }

    @Test(dataProvider = "browsers")
    public void addtocart_EnterInvalidQtyToTheShoppingCart(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);

        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        Log.info("Login");
        pageManager.shoppingCartPage().checkClearShoppingCart();
        Log.info("Clear the cart");

        usersList = pageManager.dBCon().loadDataFromExcel("invalidPartNumber", "QuickOrder");
        String qtyInvalid = usersList.get(0).getQuantity1();
        Log.info(" ******* qtyInvalid: " + qtyInvalid);
        pageManager.shoppingCartPage().enterQuantity((qtyInvalid));
        Log.info("Enter invalid quantity");
        String qtyValid = pageManager.shoppingCartPage().getQty();
        Log.info(" ******* qtyValid: " + qtyValid);
        assertNotEquals(qtyValid, qtyInvalid);

    }

    @Test(dataProvider = "browsers", enabled = true)
    /*
		8/09/2019 Bhavani: No Issues Noticed 
     */
    public void addtocart_VerifyAddedPartIsDisplayedInSCP(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);

        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        pageManager.shoppingCartPage().checkClearShoppingCart();
        usersList = pageManager.dBCon().loadDataFromExcel("verifyQuickAddPartsToCart", "QuickOrder");
        String part = "PART " + usersList.get(0).getPartNumber1();
        Log.info(" added part: " + part);
        pageManager.shoppingCartPage().addPartsToYourCart(part, usersList.get(0).getQuantity2());
        pageManager.common().refresh();
        String displayedShoppingCartProductCount = pageManager.shoppingCartPage().getCount();
        Log.info("displayedShoppingCartProductCount is " + displayedShoppingCartProductCount);
        Log.info(pageManager.shoppingCartPage().getPartNumberText());
        Assert.assertEquals(pageManager.shoppingCartPage().getPartNumberText(), part);
    }

    @Test(dataProvider = "browsers",enabled = true)
    /*
    	8/09/2019 Bhavani: No Issues Noticed 
     */

    public void addtocart_VerifyPricesInSCPANDPDP(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);

        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        Log.info("Login");
        pageManager.shoppingCartPage().checkClearShoppingCart();
        Log.info("Clear the cart");
        usersList = pageManager.dBCon().loadDataFromExcel("verifyQuickAddPartsToCart", "QuickOrder");
        pageManager.shoppingCartPage().addPartsToYourCart(usersList.get(0).getPartNumber3(), usersList.get(0).getQuantity3());
        driver.navigate().refresh();
        priceOnSCP = pageManager.shoppingCartPage().getProductPrice();
        Log.info(priceOnSCP);
        pageManager.shoppingCartPage().clickProductImage();
        pageManager.productDetailsPage().productDetailsModuleTitle.isDisplayed();
        String priceOnPDP = pageManager.productDetailsPage().getProductPrice();
        Log.info("priceOnSCP: " + priceOnSCP + "          " + "priceOnPDP: " + priceOnPDP);
        Assert.assertEquals(priceOnSCP, priceOnPDP);
    }

}	

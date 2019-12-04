/**
 * @author Bhavani
 * <p>
 * FMQA-2447 Verify If Item Can Be Added To Cart From Order History Detail Page - All items
 * <p>
 * ALM Test Instance ID: 649410
 * <p>
 * Modifies: Iuliia
 */
package com.selenium.ebiz.add_to_cart.addToCart_grid;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.List;

/*
8/07/2019 Bhavani: Updated product price xpath in PDP from line 70
*/
public class VerifyIfItemCanBeAddedToCartFromOrderHistoryDetailPageAllitems_Grid extends BaseClassV8_ParallelGrid {

    List<String> OHDPParts, OHDPPrice;
    List<String> SCPParts, SCPPrice;


    @Test(dataProvider = "browsers", enabled = false)

    public void addtocart_VerifyIfItemCanBeAddedToCartFromOrderHistoryDetailPageAllitems
            (String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);

        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        Log.info("Login");

        pageManager.shoppingCartPage().checkClearShoppingCart();
        Log.info("Clear the cart");

        pageManager.homePage().clickTopHeaderOrderHistoryStatusLink();
        Log.info("Navigate to Order History Status");
        pageManager.ordersPage().isDisplayedOrderspageHeading();

        pageManager.ordersPage().clickOnFirstOrderNumberInOrdersPage();
        Log.info("Select first order number in orders page");

        pageManager.ordersHistoryDetailsPage().isDisplayedOrderHistoryDetailsTitle();
        Log.info("Order History Details page title is displayed");
        pageManager.ordersHistoryDetailsPage().clickOnShowItems();
        Log.info("Click on Show items");
        OHDPParts = pageManager.ordersHistoryDetailsPage().getAllPartNumbers();
        Log.info("Get all the part numbers in OHDP: " + OHDPParts);
		/*OHDPPrice = pageManager.ordersHistoryDetailsPage().getAllProductPrice();
		Log.info("Get the price of all part numbers in OHDP: " + OHDPPrice);*/
        pageManager.ordersHistoryDetailsPage().clickOnAddAllToCartButton();
        Log.info("Click Add All to cart");

        pageManager.shoppingCartPage().isDisplayedShoppingCartTitle();
        Log.info("Verify SC page is displayed");
        SCPParts = pageManager.shoppingCartPage().getAllPartNumbers();
        Log.info("Get all part numbers in SC page");

        pageManager.shoppingCartPage().compareParts(OHDPParts, SCPParts);
        Log.info("Compare Parts OHDP and SCP");

        pageManager.shoppingCartPage().compareSCPPricePDPPrice();
        Log.info("Compare Prices SCP and PDP");
		
		/*SCPPrice = pageManager.shoppingCartPage().getAllProductPrice();
		Log.info("Get all product price in SC page");
		Assert.assertTrue(pageManager.shoppingCartPage().compareParts(OHDPPrice, SCPPrice));
		Log.info("Compare Prices OHDPPrice and SCPPrice");
		*/
    }


}

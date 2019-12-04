/**
 * @author Bhavani
 * <p>
 * FMQA-2445 Verify If Item Can Be Added To Cart From Order History Detail Page - Individual items
 * <p>
 * ALM Test Instance ID: 649407
 */
package com.selenium.ebiz.add_to_cart.addToCart_grid;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class VerifyIfItemCanBeAddedToCartFromOrderHistoryDetailPageIndividualitems_Grid extends BaseClassV8_ParallelGrid {
    //WebDriver driver = this.getDriver();

    /**
     *  Verifying the add to Cart from PLP List View
     * @throws Exception
     */

    String partNumberFromOHDP, partNumberFromSCP;
    String productPriceFromPDP, productPriceFromSCP;

    @Test(dataProvider = "browsers", enabled=false)
    public void addtocart_VerifyItemFromOrderHistoryPageCanBeAddedToCS(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);

        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        //pageManager.commonLogin().LoginToHDS(configread.getUserName(),configread.getPassword());
        pageManager.shoppingCartPage().checkClearShoppingCart();

        pageManager.homePage().clickTopHeaderOrderHistoryStatusLink();
        pageManager.ordersPage().isDisplayedOrderspageHeading();
        pageManager.ordersPage().clickOnFirstOrderNumberInOrdersPage();

        pageManager.ordersHistoryDetailsPage().isDisplayedOrderHistoryDetailsTitle();
        partNumberFromOHDP = pageManager.ordersHistoryDetailsPage().getFirstPartNumber();
        //productPriceFromOHDP = pageManager.ordersHistoryDetailsPage().getFirstProductPrice();
        pageManager.ordersHistoryDetailsPage().clickOnFirstAddToCartButton();

        pageManager.homePage().shoppingCartIcon.click();
        partNumberFromSCP = pageManager.shoppingCartPage().getPartNumberText().substring(5);
        productPriceFromSCP = pageManager.shoppingCartPage().getProductPrice();
        pageManager.shoppingCartPage().clickProductImage();

        pageManager.productDetailsPage().isDisplayedproductDetailsHeader();
        productPriceFromPDP = pageManager.productDetailsPage().getProductPrice();

        Log.info("partNumberFromSCP: " + partNumberFromSCP + "    " + "partNumberFromOHDP: " + partNumberFromOHDP);
        Log.info("productPriceFromSCP: " + productPriceFromSCP + "    " + "productPriceFromPDP: " + productPriceFromPDP);

        Assert.assertEquals(partNumberFromSCP, partNumberFromOHDP);
        Assert.assertEquals(productPriceFromSCP, productPriceFromPDP);
    }


}

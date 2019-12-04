/**
 * @author Bhavani
 * <p>
 * FMQAECOMM-121 [1]Verify Rich Relevance Recommendation section
 * <p>
 * ALM Test Instance ID: 649560
 */
package com.selenium.ebiz.product_listing_page.plp_grid;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class VerifyRichRelevanceRecommendationSectionAddToCart extends BaseClassV8_ParallelGrid {

    private ArrayList<UsersListBean> usersList;

    @Test(dataProvider = "browsers", enabled = false)
    public void plp_VerifyRichRelevanceRecommendationSectionAddToCart(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);

        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        //pageManager.loginPage().loggedAccountNumberText.isDisplayed();
        Log.info("Passed Test Login");

        pageManager.shoppingCartPage().checkClearShoppingCart();
        Log.info("Shopping cart was checked and cleared");

        int displayedShoppingCartProductCountBeforeAddToCart = pageManager.homePage().getShoppingCartProductCount();
        pageManager.homePage().moveToSubCategoryPage();
        pageManager.productListingPage().isRichRelevanceDisplayed();

        pageManager.productListingPage().isPriceUnderRichRelevanceDisplayed();
        pageManager.productListingPage().isAddToCartUnderRichRelevanceDisplayed();

        pageManager.productListingPage().clickAddToCartButtonUnderRichRelevance();
        int displayedShoppingCartProductCountAfterAddToCart = pageManager.homePage().getShoppingCartProductCount();

        Log.info("displayedShoppingCartProductCountAfterAddToCart is " + displayedShoppingCartProductCountAfterAddToCart);
        Assert.assertNotEquals(displayedShoppingCartProductCountBeforeAddToCart, displayedShoppingCartProductCountAfterAddToCart);
    }

}

package com.selenium.ebiz.order_history.orderHistory_grid;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * @author Iuliia
 * <p>
 * FMQAECOMM-20 : Order History - Verify Error On Part After Clicking On It In The ShoppingCart
 * <p>
 * ALM Test Instance ID: 649217
 */

public class VerifyErrorOnPartAfterClickingOnItInTheShoppingCart_Grid extends BaseClassV8_ParallelGrid {

    private String firstProductNumber, secondPN, thirdPN, fourthPN, partNumberOnFrequentlyPurchased;
    private String newListName = "List_";
    private ArrayList<UsersListBean> usersList;


    @Test(dataProvider = "browsers")
    public void orderHistory_isAddedPartDisplayedInShoppingCart(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);

        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        pageManager.shoppingCartPage().checkClearShoppingCart();
        pageManager.homePage().clickOnQuickOrderLink();
        pageManager.quickOrderPad().isDisplayedDefaultSixRowsInQuickOrderPad();
        usersList = pageManager.dBCon().loadDataFromExcel("addProductsUsingQuickOrder", "QuickOrder");
        firstProductNumber = usersList.get(0).getPartNumber1();
     //   thirdPN = usersList.get(0).getPartNumber3();
        pageManager.quickOrderPad().fillFirstPartNumberTextBox(firstProductNumber);
        pageManager.quickOrderPad().clickOnAddToCartButton();
        pageManager.shoppingCartPage().isAddedPartDisplayedInShoppingCart(firstProductNumber);
        pageManager.shoppingCartPage().productsImages.get(0).click();
        pageManager.productDetailsPage().isDisplayedproductDetailsHeader();
        Assert.assertTrue(pageManager.productDetailsPage().getDisplayedPartNumber().contains(firstProductNumber));
    }


    @Test(dataProvider = "browsers")
    public void orderHistory_isAddedThirdPartDisplayedInPDPWithoutError(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);
        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        pageManager.shoppingCartPage().checkClearShoppingCart();
        pageManager.homePage().clickOnQuickOrderLink();
        usersList = pageManager.dBCon().loadDataFromExcel("addProductsUsingQuickOrder", "QuickOrder");
        thirdPN = usersList.get(0).getPartNumber3();
        pageManager.quickOrderPad().fillFirstPartNumberTextBox(thirdPN);
        pageManager.quickOrderPad().clickAddTolist();
        pageManager.addToExistingORCreateNewList_modal().addItemToNewList(newListName);
        pageManager.savedListsPage().navigateToSavedListPageAndClickOnRecentlyUpdatedList();
        pageManager.savedListsPage().isDisplayedSavedListspageHeadingText();
        pageManager.savedListsPage().clickOnExistingFirstSavedList();
        pageManager.savedListsDetailPage().isAddedPartDisplayedInSavedList(thirdPN);
        pageManager.savedListsDetailPage().clickonFirstAddToCartbtn();
        pageManager.homePage().clickOnShoppingCartIcon();
        pageManager.shoppingCartPage().isAddedPartDisplayedInShoppingCart(thirdPN);
        pageManager.shoppingCartPage().productsImages.get(0).click();
        pageManager.productDetailsPage().isDisplayedproductDetailsHeader();
        Assert.assertTrue(pageManager.productDetailsPage().getDisplayedPartNumber().contains(thirdPN));

    }

    @Test(dataProvider = "browsers")

    public void orderHistory_VerifyPartIsDisplayedInPDPWithoutErrorAddedPartFromOHDP(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);

        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        pageManager.shoppingCartPage().checkClearShoppingCart();
        pageManager.homePage().clickTopHeaderOrderHistoryStatusLink();
        pageManager.ordersPage().isDisplayedOrderspageHeading();
        pageManager.ordersPage().clickOnFirstOrderNumberInOrdersPage();
        fourthPN = pageManager.ordersHistoryDetailsPage().getFirstPartNumber();
        Log.info("fourthPN: " + fourthPN);
        pageManager.ordersHistoryDetailsPage().clickOnFirstAddToCartButton();
        pageManager.homePage().clickOnShoppingCartIcon();
        pageManager.shoppingCartPage().isAddedPartDisplayedInShoppingCart(fourthPN);
        pageManager.shoppingCartPage().productsImages.get(0).click();
        Assert.assertTrue(pageManager.productDetailsPage().getDisplayedPartNumber().contains(fourthPN));

    }

    @Test(dataProvider = "browsers")
    public void orderHistory_AddPartFromFrequentlyPurchasedPageToPDP(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);

        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        pageManager.homePage().clickFrePurchasedUtilityBar();
        pageManager.frequentlyPurchasedPage().isFrequentlyPurchasedPageHeadingTextDisplayed();
        partNumberOnFrequentlyPurchased = pageManager.frequentlyPurchasedPage().listProductPartNumbers.get(0).getText();
        pageManager.frequentlyPurchasedPage().clickOnFirstProductDisplayed();
        Assert.assertTrue(pageManager.productDetailsPage().getDisplayedPartNumber().contains(partNumberOnFrequentlyPurchased));
    }


}

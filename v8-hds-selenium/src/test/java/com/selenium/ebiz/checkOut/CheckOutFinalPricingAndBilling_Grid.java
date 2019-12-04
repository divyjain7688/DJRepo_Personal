package com.selenium.ebiz.checkOut;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class CheckOutFinalPricingAndBilling_Grid extends BaseClassV8_ParallelGrid {
    private ArrayList<UsersListBean> usersList;
    /**
     *
     * US-Ord-211 -this story is to verify the final pricing and billing before I submit my order
     *
     **/

    /**
     * Launching of the Browser and login with Valid Credentials
     * Select the Property
     */
    @Test(dataProvider = "browsers", enabled = false)
    public void checkout_VerifyFinalBillingPageElements(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);

        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        pageManager.shoppingCartPage().checkClearShoppingCart();
        usersList = pageManager.dBCon().loadDataFromExcel("verifyQuickAddPartsToCart", "QuickOrder");
        pageManager.shoppingCartPage().addPartsToYourCart(usersList.get(0).getPartNumber1(), usersList.get(0).getQuantity1());
        //Assert.assertTrue(shoppingCartPage.isSuccessMessageDisplayed());
        driver.navigate().refresh();
        pageManager.shoppingCartPage().continueShoppingBreadCrumbLink.isDisplayed();
        pageManager.shoppingCartPage().isAddedPartDisplayedInShoppingCart(usersList.get(0).getPartNumber1());
        // Select check out button
        pageManager.shoppingCartPage().clickonCheckOutButton();
        // Verify that Shipping Address is displayed on Final Pricing and Billing page
        pageManager.paymentAndCheckOutPage().isPageTitleDisplayed();
        pageManager.paymentAndCheckOutPage().isDisplayedShippingAddressOnPaymentAndCheckOutPage();
        // Verify that the Shipping Address is editable
        pageManager.paymentAndCheckOutPage().isEnabledditAddressLink();
        // Verify that Billing Method radio button options to either charge their HD Supply Account or Charge their credit card are displayed"
        pageManager.paymentAndCheckOutPage().isDisplayedRadioButtonForChargeMyHDSupplyAccount();
        // Verify that text box form fields appear for the user to add their credit card and billing details when Charge Credit card option is selected
        pageManager.paymentAndCheckOutPage().clickRadioButtonForChargeMyCreditCard();
        pageManager.paymentAndCheckOutPage().isDisplayedtextBoxFormChargeMyCreditCard();
        pageManager.paymentAndCheckOutPage().isDisplayedYourOrderExpectedDeliveryDates();
        // Verify that "Edit Items in Cart" link is seen on top of Your Order -Expected Delivery Dates section
        pageManager.paymentAndCheckOutPage().isDisplayedEditItemsInCartText();
        // Verify that Order Notes text field is seen below Your Order-Expected Delivery Dates section
        pageManager.paymentAndCheckOutPage().isDisplayedTextAreaBox();
        // Verify that user can type notes regarding the order in Order Notes text field and this field autosaves the text entered
        pageManager.paymentAndCheckOutPage().editInTextAreaBox();
        Assert.assertTrue(pageManager.paymentAndCheckOutPage().isDisplayedTextAreaBox());
        // Verify that "Submit Secure Order" button  appears on the top right of the page above the Final Pricing section, and it appears Under the P.O number field.
        Assert.assertTrue(pageManager.paymentAndCheckOutPage().isDisplayedSubmitSecureOrder1());
        Assert.assertTrue(pageManager.paymentAndCheckOutPage().isDisplayedSubmitSecureOrder2());
        Assert.assertTrue(pageManager.paymentAndCheckOutPage().isDisplayedSubmitSecureOrder3());
        // Verify that clicking on ""Return Policy"" link is displayed which takes user to the as-is return policy page."
        Assert.assertTrue(pageManager.paymentAndCheckOutPage().isDisplayedReturnPolicyLink());
        // Verify that Final Pricing section on the right side of the page shows the cart summary (subtotal, shipping, taxes, fees, discounts, total order
        Assert.assertTrue(pageManager.paymentAndCheckOutPage().isDisplayedCartSummaryText());
        Assert.assertTrue(pageManager.paymentAndCheckOutPage().isDisplayedSubTotalText());
        Assert.assertTrue(pageManager.paymentAndCheckOutPage().isDisplayedShippingText());
        Assert.assertTrue(pageManager.paymentAndCheckOutPage().isDisplayedTotalText());
        // Verify that Category Spend text is visible
        Assert.assertTrue(pageManager.paymentAndCheckOutPage().isDisplayedCategorySpendText());
        // Verify that PO number is displayed on Final Pricing and Billing page if PO number is added on Shopping Cart page
        Assert.assertTrue(pageManager.paymentAndCheckOutPage().isDisplayedPONumberText());
    }
}





/**
 * @author Bhavani
 * <p>
 * FMQAECOMM-3 : Order History - Order History Summary - Verify Order History Summary page displays correct total
 * <p>
 * ALM Test Instance ID: 649213
 */
package com.selenium.ebiz.order_history.orderHistory_NonParallelTests;

import com.selenium.ebiz.baseclass.BaseClassV8_Parallel;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.testng.Assert;
import org.testng.annotations.Test;


public class VerifyOrderHistorySummaryPageDisplaysCorrectTotal extends BaseClassV8_Parallel {

    String orderNumber, totalFromPaymentAndCheckoutPage, sumofSubTotalAndTax, totalFromOHDP;


    /**
     *  Verifying the add to Cart from PLP List View
     * @throws Exception
     */

    @Test(description = "Login")
    public void Login() throws Exception {
        //LoginToHDS(configread.getUserName1(),configread.getPassword());
        LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
    }

    @Test(dependsOnMethods = {"Login"}, description = "Clear Cart")
    public void clearCart() throws Exception {
        pageManager.shoppingCartPage().checkClearShoppingCart();
        Assert.assertTrue(pageManager.shoppingCartPage().isDisplayedShoppingCartTitle());
    }

    @Test(dependsOnMethods = {"clearCart"}, description = " Item added to cart from SCP")
    public void ItemAddedToCartFromSCP() throws Exception {
        GetUserList("partNumberHandlingFee", "QuickOrder");
        pageManager.shoppingCartPage().addPartsToYourCart(usersList.get(0).getPartNumber1(), usersList.get(0).getQuantity1());

    }

    @Test(dependsOnMethods = {"ItemAddedToCartFromSCP"}, description = "Add Payment and Checkout Page")
    public void addPaymentAndCheckoutPage() throws Exception {
        pageManager.shoppingCartPage().clickOnCheckOutButton();
        Log.info("Clicked Checkout btn on SC page");
        pageManager.paymentAndCheckOutPage().VerifyPNAValuesIsDisplayed();
        totalFromPaymentAndCheckoutPage = pageManager.paymentAndCheckOutPage().displayedTotalValue();
        Log.info("totalFromPaymentAndCheckoutPage: " + totalFromPaymentAndCheckoutPage);
        Log.info("Handling Fee: " + pageManager.paymentAndCheckOutPage().getHandlingFeeText());
        sumofSubTotalAndTax = pageManager.paymentAndCheckOutPage().sumOfSubTotalAndTax();
        Log.info("sumofSubTotalAndTax: " + sumofSubTotalAndTax);
        Assert.assertTrue(pageManager.paymentAndCheckOutPage().handlingFeeText.isDisplayed());
    }

    //@Test(dependsOnMethods ={"addPaymentAndCheckoutPage"}, description="Enter Credit Card Details In Add Payment and Checkout Page")
    public void enterCreditCardDetailsInAddPaymentAndCheckoutPage() throws Exception {
        GetUserList("enterCreditCardDetails", "CreditCard");
        pageManager.paymentAndCheckOutPage().clickOnCardType();
        pageManager.paymentAndCheckOutPage().enterCardNumberTextBox(usersList.get(0).getCardNum());
        pageManager.paymentAndCheckOutPage().clickOnCardExpiryMonthDropDown();
        pageManager.paymentAndCheckOutPage().clickOncardExpiryYearDropDown();
        pageManager.paymentAndCheckOutPage().enterCardSecurityIDText();
        pageManager.paymentAndCheckOutPage().enterCardHolderName(usersList.get(0).getCardHolderName());
        pageManager.paymentAndCheckOutPage().enterPinNumberText(usersList.get(0).getPin());
        Assert.assertTrue(pageManager.paymentAndCheckOutPage().isDisplayedPONumberText());
    }


    @Test(dependsOnMethods = {"addPaymentAndCheckoutPage"}, description = "Place web order")
    public void test_placeWebOrder() throws Exception {
        pageManager.paymentAndCheckOutPage().insertPONumber();
        Log.info("*******Inserted PO number**********");
        pageManager.paymentAndCheckOutPage().clickOnSubmitSecureOrder();
/*		Log.info("Clicked submit secure order button");
		Log.info(pageManager.orderConfirmationPage().storeOrderNumber());
		orderNumber = pageManager.orderConfirmationPage().storeOrderNumber();
		Assert.assertTrue(pageManager.orderConfirmationPage().isDisplayedOrderConfirmationPageTitle());*/

    }

    @Test(dependsOnMethods = {"test_placeWebOrder"}, description = "Verify Orders Page")
    public void verifyOrdersPage() throws Exception {
        pageManager.homePage().clickTopHeaderOrderHistoryStatusLink();
        Assert.assertTrue(pageManager.ordersPage().isDisplayedOrderspageHeading());
    }

    @Test(dependsOnMethods = {"verifyOrdersPage"}, description = " Verify Order History Details Page Total ")
    public void verifyOrderHistoryDetailsPage() throws Exception {
        pageManager.ordersPage().clickOnCreatedOrderNumberInOrdersPage(orderNumber);
        Assert.assertTrue(pageManager.ordersHistoryDetailsPage().isDisplayedTotalValue());
    }

    @Test(dependsOnMethods = {"verifyOrderHistoryDetailsPage"}, description = " Verify Order History Details Page Total Value")
    public void verifyOrderHistoryDetailsPageTotalValue() throws Exception {
        totalFromOHDP = pageManager.ordersHistoryDetailsPage().getTotalValue().substring(1);
        Log.info("SumofSubTotalAndTax: " + sumofSubTotalAndTax + "     " + "totalFromOHDP: " + totalFromOHDP);
        Assert.assertEquals(totalFromOHDP, sumofSubTotalAndTax);
    }

    @Test(dependsOnMethods = {"verifyOrderHistoryDetailsPageTotalValue"}, description = "Logout")
    public void testLogout() throws Exception {
        pageManager.loginPage().logoutOfApplication();

    }

}

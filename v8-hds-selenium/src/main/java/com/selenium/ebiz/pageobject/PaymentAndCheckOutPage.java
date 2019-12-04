package com.selenium.ebiz.pageobject;

import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.WaitTool;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.ArrayList;

public class PaymentAndCheckOutPage {
    String orderNumber;
    public PaymentAndCheckOutPage(WebDriver driver) {
        this.driver = driver;
        this.waitTool = new WaitTool();
        PageFactory.initElements(driver, this);
        this.pageManager = new PageManager(driver);

    }


    @FindBy(xpath = "//h1[contains(text(),'Add payment and checkout')]")
    public WebElement addPaymentAndCheckoutText;
    @FindBy(xpath = "//div[@data-hds-tag='cart-summary__shipping-charge']//span[text()='SHIPPING']")
    public WebElement displayedShippingAttribute;
    @FindBy(xpath = "//div[@data-hds-tag='cart-summary__shipping-charge']//div[@class='tooltip-box__content']")
    public WebElement displayedShippingQuestionMarkAttribute;
    @FindBy(xpath = "//p[contains(text(),'Most orders of $50 or more are delivered FREE')]")
    public WebElement displayedShippingToolTip;
    @FindBy(xpath = "//input[@id='poNumber']")
    public
    WebElement enterPONumber;
    @FindBy(xpath = "//div[contains(text(),'Charge my HD Supply Account')]/../span")
    public
    WebElement chargeHDSupplyAccountRadioButton;
    @FindBy(xpath = "//div[@class='checkout__header']//button[contains(text(),'Submit secure order')][1]")
    public
    WebElement submitSecureOrder1;

    //Radio buttons
    @FindBy(xpath = "//div[@class='checkout__footer-submit-order rule--light']//button[contains(text(),'Submit secure order')][1]")
    public
    WebElement submitSecureOrder2;
    
    @FindBy(xpath = "//div[@class='checkout__right-rail']//button[contains(text(),'Submit secure order')][1]")
    public WebElement submitSecureOrder3;
    
    @FindBy(xpath = "//span[contains(text(),'TAX')]/../span[2]")
    public WebElement displayedTaxValue;
    
    @FindBy(xpath = "//div[@data-hds-tag='cart-summary__indent']")
    public WebElement handlingFeeText;

    @FindBy(xpath = "//*[@data-hds-tag='cart-summary__totals']//div[6]")
    public WebElement serviceFee;

    @FindBy(xpath = "//*[@data-hds-tag='cart-summary__totals']//div[6]//*[@class='tooltip-box__content']")
    public WebElement serviceFeeToolTip;

    @FindBy(name = "orderComment")
    public WebElement orderNotes;

    @FindBy(xpath = "//div[@class='header__address']")
    WebElement shippingAddressOnPaymentAndCheckOutPage;

    @FindBy(xpath = "//div[@class='checkout__billing-method rule--light']//div[contains(text(),'Charge my HD Supply Account')]/../input")
    WebElement radioButtonForChargeMyHDSupplyAccount;

    @FindBy(xpath = "//div[text()='Charge my credit card']/../span")
    WebElement radioButtonForChargeMyCreditCard;
    // check Text Box form when user select charge my credit card
    @FindBy(xpath = "//div[@class='checkout__credit-card-form']")
    WebElement textBoxFormChargeMyCreditCard;
    //edit shipping address link
    @FindBy(xpath = "//a[text()='Edit address in cart']")
    WebElement editAddressLink;
    //"Your Order - Expected Delivery Dates" text
    @FindBy(xpath = "//div[contains(text(),'Your Order - Expected Delivery Dates')]")
    WebElement yourOrderExpectedDeliveryDates;
    
    @FindBy(xpath = "//span[@class='widget-wrapper__header-text-checkout--green']")
    public WebElement deliveryDateInMMDDYYYY;
    
    //toggle colapse
    @FindBy(xpath = "//svg[@class='icon icon--minus']")
    WebElement toggleCollapse;
    @FindBy(linkText = "RETURN POLICY")
    WebElement returnPolicyLink;
    @FindBy(linkText = "TOP")
    WebElement topLink;
    @FindBy(xpath = "//select[@id='cardBrand']")
    WebElement cardTypeDropdown;
    @FindBy(id = "cardNumber")
    WebElement cardNumber;
    @FindBy(id = "cardExpiryMonth")
    WebElement cardExpiryMonthDropDown;
    @FindBy(id = "cardExpiryYear")
    WebElement cardExpiryYearDropDown;
    @FindBy(xpath = "//input[@data-hds-tag='checkout__cardVerificationCode']")
    WebElement cardSecurityIDText;
    @FindBy(xpath = "//input[@data-hds-tag='checkout__cardHolderName']")
    WebElement cardHolderName;
    @FindBy(xpath = "//input[@data-hds-tag='checkout__procurement-pin']")
    WebElement pinNumberText;
    // Secure to Order
    @FindBy(xpath = "//div[@class='checkout__header']/div/button[@class='btn btn--full']")
    WebElement secureToOrderButton;
    // Price in the checkout
    @FindBy(xpath = "//form[@id='OrderProcessForm']/div/div/div/div/div/div[1]/span[2]")
    WebElement finalPriceText;
    // Sub Total Amount Text
    @FindBy(xpath = "//form[@id='OrderProcessForm']/div/div/div/div/div/div[1]/span[2]")
    WebElement subTotalAmountText;
    // Shipping Amount Text
    @FindBy(xpath = "//form[@id='OrderProcessForm']/div/div/div/div/div/div[2]/span[2]")
    WebElement shippingAmountText;
    // Tax Amount Text
    @FindBy(xpath = "//form[@id='OrderProcessForm']/div/div/div/div/div/div[3]/span[2]")
    WebElement taxAmountText;
    // Discount Amount Text
    @FindBy(xpath = "//form[@id='OrderProcessForm']/div/div/div/div/div/div[4]/span[2]")
    WebElement discountAmountText;

    //*[@id="OrderProcessForm"]/div[2]/div[1]/div[3]/div/div[1]/a/span[2]/svg/g/path
    //WebElement toggleCollapse;
    // Total Amount Text
    @FindBy(xpath = "//form[@id='OrderProcessForm']/div/div/div/div/div/div[5]/span[2]")
    WebElement totalAmountText;
    @FindBy(xpath = "//a[text()='Edit items in cart']")
    WebElement editItemsInCartText;
    @FindBy(xpath = "//spam[@class='icon icon--plus']")
    WebElement toggleExpand;
    @FindBy(xpath = "//textarea[@placeholder='Example: This order is for apartment #28F']")
    WebElement textAreaBox;
    @FindBy(xpath = "//div[contains(text(),'CART SUMMARY')]")
    WebElement cartSummaryText;
    @FindBy(xpath = "//span[contains(text(),'SUBTOTAL')]")
    WebElement subTotalText;
    @FindBy(xpath = "//span[contains(text(),'SHIPPING')]")
    WebElement shippingText;
    @FindBy(xpath = "//span[contains(text(),'TAX')]")
    WebElement taxText;
    @FindBy(xpath = "//span[contains(text(),'TOTAL')]")
    WebElement totalText;
    @FindBy(xpath = "//div[contains(text(),'CATEGORY SPEND')]")
    WebElement categorySpendText;
    @FindBy(xpath = "//span[contains(text(),'P.O. Number')]")
    WebElement PONumberText;
    @FindBy(xpath = "//span[contains(text(),'SUBTOTAL')]/../span[2]")
    WebElement displayedSubtotalValue;
    @FindBy(xpath = "//span[contains(text(),'SHIPPING')]/../../span")
    WebElement displayShippingValue;
    @FindBy(xpath = "//span[contains(text(),'DISCOUNTS')]/../span[2]")
    WebElement displayedDiscountsValue;
    @FindBy(xpath = "//div[@class='cart-summary__total type--bold']/span[2]")
    public
    WebElement displayedTotalValue;
    @FindBy(xpath = "//span[text()='Electrical']/../span[2]")
    WebElement displayedElectricalCategorySpendValue;
    @FindBy(xpath = "//div[@class='checkout__right-rail']//button[contains(text(),'Submit secure order')]")
    WebElement submitSecureOrder;
    @FindBy(xpath = "//div[@data-hds-tag='cart-summary__total']/span[@class='cart-summary__price type--body-x-large']")
    public WebElement totalValue;

    //	@FindBy(xpath="//span[text()='Furniture & D�cor']/../span[2]")
    //	WebElement displayedFurnitureAndDecorsCategorySpendValue;
    @FindBy(xpath = "//button[@id='quoteSubmitBtn3']")
    WebElement submitSecureQuote;
    @FindBy(xpath = "//input[@name='PONumber']")
    WebElement pONumber;
    private WebDriver driver;
    private WaitTool waitTool;
    private PageManager pageManager;
    private ArrayList<UsersListBean> usersList;



    /**
     * @name getShoppingCartPaymentText
     * @description Method to verify presence of shipping address below checkout.
     */
	/* public String getShoppingCartPaymentText(){
        //System.out.println(shippingToDropdown.getText());
        return paymentAndCheckoutPageHeadingText.getText().trim() ;
    }*/
    public boolean isPageTitleDisplayed() {
        waitTool.waitForElement(driver, addPaymentAndCheckoutText);
        return addPaymentAndCheckoutText.isDisplayed();
    }


    /**
     * @name getFinalPriceText
     * @description Method to get the price
     */
    public String getFinalPriceText() {
        return finalPriceText.getText().trim();
    }


    /**
     * @name getSubTotalAmountText
     * @description Method to get the Sub Total Amount
     */
    public String getSubTotalAmountText() {
        return subTotalAmountText.getText().trim();
    }


    /**
     * @name getShippingAmountText
     * @description Method to get the Shipping Amount
     */
    public String getShippingAmountText() {
        return shippingAmountText.getText().trim();
    }


    /**
     * @name getTaxAmountText
     * @description Method to get the Tax Amount
     */
    public String getTaxAmountText() {
        return taxAmountText.getText().trim();
    }

    /**
     * @name getDiscountAmountText
     * @description Method to get the Discount Amount
     */
    public String getDiscountAmountText() {
        return discountAmountText.getText().trim();
    }


    /**
     * @name getTotalAmountText
     * @description Method to get the Total Amount
     */
    public String getTotalAmountText() {
        return totalAmountText.getText().trim();
    }


    /**
     * click on Secure To Order Button
     */
    public void clickSecureToOrderButton() {
        secureToOrderButton.click();
        waitTool.waitFor(driver, true);
        //  return new OrderConfirmationPage(driver);
    }


    public boolean isDisplayedTopLink() {
        return pageManager.common().isElementPresent(topLink);
    }

    public void clickOnTopLink() {
        topLink.click();
    }

    public void clickOnReturnPolicy() {
        returnPolicyLink.click();
    }

    public boolean isDisplayedReturnPolicyLink() {
        return pageManager.common().isElementPresent(returnPolicyLink);
    }


    public boolean isDisplayedTextAreaBox() {
        waitTool.waitForElement(driver, textAreaBox);
        pageManager.common().scrolltoViewElement(textAreaBox, driver);
        return pageManager.common().isElementPresent(textAreaBox);
    }

    public void clickToggleCollapse() {
        toggleCollapse.click();
    }

    public void clickToggleExpand() {
        toggleExpand.click();
    }

    public boolean isDisplayedEditItemsInCartText() {
        return pageManager.common().isElementPresent(editItemsInCartText);
    }


    public boolean isDisplayedPONumberText() {
        return pageManager.common().isElementPresent(PONumberText);
    }


    public boolean isDisplayedCategorySpendText() {
        return pageManager.common().isElementPresent(categorySpendText);
    }

    public boolean isDisplayedCartSummaryText() {
        return pageManager.common().isElementPresent(cartSummaryText);
    }

    public boolean isDisplayedSubTotalText() {
        return pageManager.common().isElementPresent(subTotalText);
    }

    public boolean isDisplayedShippingText() {
        return pageManager.common().isElementPresent(shippingText);
    }

    public boolean isDisplayedTaxText() {
        return pageManager.common().isElementPresent(taxText);
    }

    public boolean isDisplayedTotalText() {
        return pageManager.common().isElementPresent(totalText);
    }

    public boolean isDisplayedAddPaymentAndCheckoutTitle() {
        waitTool.waitForElement(driver, addPaymentAndCheckoutText);
        return pageManager.common().isElementPresent(addPaymentAndCheckoutText);
    }

    public boolean isDisplayedSubmitSecureOrder1() {
        pageManager.common().scrolltoViewElement(submitSecureOrder1, driver);
        return pageManager.common().isElementPresent(submitSecureOrder1);
    }


    public void clickOnSubmitSecureOrder1() {
        waitTool.waitForElement(driver, submitSecureOrder1);
        submitSecureOrder1.click();
        //  return new OrderConfirmationPage(driver);
    }

    public boolean isDisplayedSubmitSecureOrder2() {
        pageManager.common().scrolltoViewElement(submitSecureOrder2, driver);
        return pageManager.common().isElementPresent(submitSecureOrder2);
    }

    public boolean isDisplayedSubmitSecureOrder3() {
        pageManager.common().scrolltoViewElement(submitSecureOrder3, driver);
        return pageManager.common().isElementPresent(submitSecureOrder3);
    }

    public void editInTextAreaBox() {
        textAreaBox.clear();
        textAreaBox.sendKeys("HDSupply");
    }


    public boolean isDisplayedShippingAddressOnPaymentAndCheckOutPage() {
        return pageManager.common().isElementPresent(shippingAddressOnPaymentAndCheckOutPage);

    }

    public boolean isDisplayedRadioButtonForChargeMyHDSupplyAccount() {
        pageManager.common().scrolltoViewElement(radioButtonForChargeMyHDSupplyAccount, driver);
        return pageManager.common().isElementPresent(radioButtonForChargeMyHDSupplyAccount);
    }

    public boolean isDisplayedtextBoxFormChargeMyCreditCard() {

        pageManager.common().scrolltoViewElement(textBoxFormChargeMyCreditCard, driver);
        return pageManager.common().isElementPresent(textBoxFormChargeMyCreditCard);
    }

    public boolean isDisplayedRadioButtonForChargeMyCreditCard() {
        pageManager.common().scrolltoViewElement(radioButtonForChargeMyCreditCard, driver);
        return pageManager.common().isElementPresent(radioButtonForChargeMyCreditCard);
    }

    public void clickRadioButtonForChargeMyHDSupplyAccount() {
        pageManager.common().scrolltoViewElement(radioButtonForChargeMyHDSupplyAccount, driver);
        radioButtonForChargeMyHDSupplyAccount.click();
    }

    public void clickRadioButtonForChargeMyCreditCard() {
    	waitTool.waitForElement(driver, radioButtonForChargeMyCreditCard);
        pageManager.common().scrolltoViewElement(radioButtonForChargeMyCreditCard, driver);
        radioButtonForChargeMyCreditCard.click();
    }

    public boolean isSelectedRadioButtonForChargeMyHDSupplyAccount() {
        pageManager.common().scrolltoViewElement(radioButtonForChargeMyHDSupplyAccount, driver);

        return radioButtonForChargeMyHDSupplyAccount.isSelected();
    }

    public void isSelectedRadioButtonForChargeMyCreditCard() {
        pageManager.common().scrolltoViewElement(radioButtonForChargeMyCreditCard, driver);
        radioButtonForChargeMyCreditCard.click();
    }


    public void isDisplayededitAddressLink() {
        pageManager.common().isElementPresent(editAddressLink);
    }

    public boolean isEnabledditAddressLink() {
        return editAddressLink.isEnabled();
    }

    public void VerifyPNAValuesIsDisplayed() {
        waitTool.waitForElement(driver, addPaymentAndCheckoutText);
        String[] pna = {"Subtotal value is: " + displayedSubtotalValue(),
                "Shipping value is: " + displayShippingValuealValue()
                        + "  Tax value: " + displayedTaxValue()
                        + "  Total value: " + displayedTotalValue()
        };

        for (String l : pna) {
            System.out.println("pna values " + l);
        }
    }

    public Double convertSubTotalToInt() {
        String subtotal = displayedSubtotalValue().substring(1);
        return Double.parseDouble(subtotal);
    }

    public Double convertTaxToInt() {
        String tax = displayedTaxValue().substring(1);
        return Double.parseDouble(tax);
    }

    public String sumOfSubTotalAndTax() {
        Double subTotal = convertSubTotalToInt();
        System.out.println("********subTotal: " + subTotal);
        Double Tax = convertTaxToInt();
        System.out.println("********Tax: " + Tax);
        System.out.println("subTotal + Tax:  " + String.format("%.2f", subTotal + Tax));
        return String.format("%.2f", subTotal + Tax);
    }

    public String displayedSubtotalValue() {
        waitTool.waitForElement(driver, displayedSubtotalValue);
        pageManager.common().scrolltoViewElement(displayedSubtotalValue, driver);
        return displayedSubtotalValue.getText();
    }


    public String displayShippingValuealValue() {
        waitTool.waitForElement(driver, displayShippingValue);
        pageManager.common().scrolltoViewElement(displayShippingValue, driver);
        return displayShippingValue.getText();
    }


    public String displayedTaxValue() {
        waitTool.waitForElement(driver, displayedTaxValue);
        pageManager.common().scrolltoViewElement(displayedTaxValue, driver);
        return displayedTaxValue.getText();
    }

    public String displayedDiscountsValue() {
        return displayedDiscountsValue.getText();
    }

    public String getHandlingFeeText() {
		/*String subtotal = displayedSubtotalValue();
    	if(subtotal() < 50){

    	}*/
        return handlingFeeText.getText().trim();
    }
    
    public Boolean isDisplayedHandlingFeeText() {
    	return pageManager.common().isElementPresent(handlingFeeText);
    }

    public String displayedTotalValue() {
        waitTool.waitForElement(driver, displayedTotalValue);
        pageManager.common().scrolltoViewElement(displayedTotalValue, driver);
        return displayedTotalValue.getText();
    }

    public String displayedElectricalCategorySpendValue() {
        return displayedElectricalCategorySpendValue.getText();
    }

	/*	public String displayedFurnitureAndDecorsCategorySpendValue()
	{
		return displayedFurnitureAndDecorsCategorySpendValue.getText();
	}*/

    public void clickOnSubmitSecureOrder() throws Exception {
        waitTool.waitForElement(driver, submitSecureOrder);
        pageManager.common().scrolltoViewElement(submitSecureOrder, driver);
        int totalValue = getTotalValue();
        if (totalValue <= 100) {
            submitSecureOrder.click();
            orderNumber = pageManager.orderConfirmationPage().storeOrderNumber();
            System.out.println("orderNumber is " + orderNumber);
            Assert.assertTrue(pageManager.orderConfirmationPage().orderNumber.isDisplayed());
            saveOrderNumberInTextFile();
        } else {
            System.out.println("total value is more than 100 so not placing the order");
        }

    }
    
    public String clickOnSubmitSecureOrder(String actualEnv) throws Exception {
    	String envProd = "beta";
    	waitTool.waitForElement(driver, submitSecureOrder);
        pageManager.common().scrolltoViewElement(submitSecureOrder, driver);
    	int totalValue = getTotalValue();
    	if(actualEnv.equals(envProd)){
    		System.out.println("We are in Production with Total Value: " + totalValue );
    		if (totalValue <= 100) {
    			System.out.println("About to click Submit Button" );
    			submitSecureOrder.click();
    			orderNumber = pageManager.orderConfirmationPage().storeOrderNumber();
    			System.out.println("orderNumber is " + orderNumber);
    			Assert.assertTrue(pageManager.orderConfirmationPage().orderNumber.isDisplayed());
    			saveOrderNumberInTextFile();
    		} else {
    			System.out.println("total value is more than 100 so not placing the order");
    		}
    	}else{
    	System.out.println("We are in Lower Env with Total Value: " + totalValue );
    	submitSecureOrder.click();
    	orderNumber = pageManager.orderConfirmationPage().storeOrderNumber();
    	System.out.println("orderNumber is " + orderNumber);
    	Assert.assertTrue(pageManager.orderConfirmationPage().orderNumber.isDisplayed());
    	saveOrderNumberInTextFile();
    	}
    	return orderNumber;

    }

    public void saveOrderNumberInTextFile() throws InterruptedException {
        pageManager.common().saveStringInTextFile(driver, orderNumber);
        System.out.println("saved order number " + orderNumber + " to the orderNumberRecord text file");
    }

    public int getTotalValue() {
        String total = totalValue.getText();
        total = total.substring(1);
        System.out.println("total value is " + total);
        int totalValue = (int) Float.parseFloat(total);
        return totalValue;
    }

    public void clickOnSubmitSecureQuote() throws Exception {
        submitSecureQuote.click();
    }

    public String insertPONumber() throws Exception {
        String pONumber = pageManager.common().getRandomNumber();
        waitTool.waitForElement(driver, addPaymentAndCheckoutText);
        waitTool.waitForElement(driver, enterPONumber);
        enterPONumber.sendKeys(pONumber);
        System.out.println("po number issss" + pONumber);
        return pONumber;
    }

    public boolean isDisplayedYourOrderExpectedDeliveryDates() {
        return pageManager.common().isElementPresent(yourOrderExpectedDeliveryDates);
    }
    
    public boolean isDisplayedDeliveryDateInMMDDYYYY() {
        return pageManager.common().isElementPresent(deliveryDateInMMDDYYYY);
    }

    public boolean isChargeMyHDSupplyAccountIsDisplayed() {
        return chargeHDSupplyAccountRadioButton.isDisplayed();
    }

    public void clickOnChargeHDSupplyAccountRadioButton() throws Exception {
        waitTool.waitForElement(driver, chargeHDSupplyAccountRadioButton);
        chargeHDSupplyAccountRadioButton.click();
    }

    public void clickOnCardType() {
        pageManager.common().scrolltoViewElement(cardTypeDropdown, driver);
        pageManager.common().selectByIndex(cardTypeDropdown, 1);
    }

    public void clickOnCardExpiryMonthDropDown() {
        pageManager.common().selectByVisibleTextFromDropdown(cardExpiryMonthDropDown, "12");
    }


    public void clickOncardExpiryYearDropDown() {
        pageManager.common().selectByVisibleTextFromDropdown(cardExpiryYearDropDown, "19");
    }

    public void enterCardNumberTextBox(String cardNum) {
        pageManager.common().scrolltoViewElement(cardNumber, driver);
        cardNumber.sendKeys(cardNum);
    }

    public void enterCardSecurityIDText() {
        String random = pageManager.common().getRandomNumber();
        cardSecurityIDText.sendKeys(random);
    }

    public void enterCardHolderName(String name) {
        cardHolderName.sendKeys(name);
    }

    public void enterPinNumberText(String pin) {
        pinNumberText.sendKeys(pin);
    }

    public void enterCCDetailsInAddPaymentAndCheckoutPage() throws Exception {
        usersList = pageManager.dBCon().loadDataFromExcel("enterCardDetails", "CreditCard");
        pageManager.paymentAndCheckOutPage().clickOnCardType();
        pageManager.paymentAndCheckOutPage().enterCardNumberTextBox(usersList.get(0).getCardNum());
        pageManager.paymentAndCheckOutPage().clickOnCardExpiryMonthDropDown();
        pageManager.paymentAndCheckOutPage().clickOncardExpiryYearDropDown();
        pageManager.paymentAndCheckOutPage().enterCardSecurityIDText();
        pageManager.paymentAndCheckOutPage().enterCardHolderName(usersList.get(0).getCardHolderName());
        pageManager.paymentAndCheckOutPage().enterPinNumberText(usersList.get(0).getPin());
        Assert.assertTrue(pageManager.paymentAndCheckOutPage().isDisplayedPONumberText());
    }

    public boolean isShippingToolTipMessageDisplayed() {
        pageManager.common().mouseHover(driver, displayedShippingQuestionMarkAttribute);

        waitTool.waitForElement(driver, displayedShippingQuestionMarkAttribute);
        pageManager.common().scrolltoViewElement(displayedShippingQuestionMarkAttribute, driver);
        displayedShippingQuestionMarkAttribute.click();
        waitTool.waitForElement(driver, displayedShippingToolTip);
        pageManager.common().scrolltoViewElement(displayedShippingToolTip, driver);
        return displayedShippingToolTip.isDisplayed();

    }
/* Order notes was removed in 1.11 release
    public void enterTheOrderNotes(String notes) {
        waitTool.waitForElement(driver, orderNotes);
        orderNotes.sendKeys(notes);
    }
*/
    public Boolean isServiseFeeToolTipDisplayed(){
        waitTool.waitForElement(driver,serviceFeeToolTip);
        return serviceFeeToolTip.isDisplayed();
    }


}

package com.selenium.ebiz.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.selenium.ebiz.baseclass.BaseClass;
import com.selenium.ebiz.tools.CommonFunctions;
import com.selenium.ebiz.tools.WaitTool;

public class PaymentAndCheckOutPage extends BaseClass {

	public PaymentAndCheckOutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		WebDriverWait wait = new WebDriverWait(driver, 10000);
		wait.until(ExpectedConditions.visibilityOf((addPaymentAndCheckoutText)));
	}


	@FindBy(xpath = "//div[@class='header__address']")
	WebElement ShippingAddressOnPaymentAndCheckOutPage;

	//Radio buttons

	@FindBy(xpath = "//div[@class='checkout__billing-method rule--light']//div[contains(text(),'Charge my HD Supply Account')]/../input")
	WebElement radioButtonForChargeMyHDSupplyAccount;

	@FindBy(xpath = "//div[@class='checkout__billing-method rule--light']//div[contains(text(),'Charge my credit card')]/../span")
	WebElement radioButtonForChargeMyCreditCard;

	// check Text Box form when user select charge my credit card
	@FindBy(xpath ="//div[@class='checkout__credit-card-form']")
	WebElement textBoxFormChargeMyCreditCard;

	//edit shipping address link
	@FindBy(xpath ="//a[text()='Edit address in cart']")
	WebElement editAddressLink;

	//"Your Order - Expected Delivery Dates" text
	@FindBy(xpath ="//div[contains(text(),'Your Order - Expected Delivery Dates')]")
	WebElement yourOrderExpectedDeliveryDates;

	@FindBy(xpath = "//h1[contains(text(),'Add payment and checkout')]")
	WebElement addPaymentAndCheckoutText;

	// heading text
	@FindBy(xpath = "//section[@class='checkout']/h1")
	public WebElement paymentAndCheckoutPageHeadingText;

	//toggle colapse
	@FindBy(xpath ="//svg[@class='icon icon--minus']")
	WebElement toggleCollapse;
	
	@FindBy(linkText= "RETURN POLICY")
	WebElement returnPolicyLink;

	@FindBy(linkText= "TOP")
	WebElement topLink;


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

	// Total Amount Text
	@FindBy(xpath = "//form[@id='OrderProcessForm']/div/div/div/div/div/div[5]/span[2]")
	WebElement totalAmountText;

	@FindBy(xpath="//input[@id='poNumber']")
	WebElement enterPONumber;
	
	@FindBy(xpath="//div[contains(text(),'Charge my HD Supply Account')]/../span")
	WebElement chargeHDSupplyAccountRadioButton;
	
	@FindBy(xpath = "//a[text()='Edit items in cart']")
	WebElement editItemsInCartText;

	//*[@id="OrderProcessForm"]/div[2]/div[1]/div[3]/div/div[1]/a/span[2]/svg/g/path
	//WebElement toggleCollapse;

	@FindBy(xpath ="//spam[@class='icon icon--plus']")
	WebElement toggleExpand;

	@FindBy(xpath = "//textarea[@placeholder='Example: This order is for apartment #28F']")
	WebElement textAreaBox;

	@FindBy(xpath = "//div[@class='checkout__header']//button[contains(text(),'Submit secure order')][1]")
	WebElement submitSecureOrder1;

	@FindBy(xpath = "//div[@class='checkout__footer-submit-order rule--light']//button[contains(text(),'Submit secure order')][1]")
	WebElement submitSecureOrder2;


	@FindBy(xpath = "//div[@class='checkout__right-rail']//button[contains(text(),'Submit secure order')][1]")
	WebElement submitSecureOrder3;
	
	@FindBy(xpath ="//div[contains(text(),'Cart Summary')]")
	WebElement cartSummaryText;

	@FindBy(xpath ="//span[contains(text(),'SUBTOTAL')]")
	WebElement subTotalText;

	@FindBy(xpath ="//span[contains(text(),'SHIPPING')]")
	WebElement shippingText;

	@FindBy(xpath ="//span[contains(text(),'TAX')]")
	WebElement taxText;

	@FindBy(xpath ="//span[contains(text(),'TOTAL')]")
	WebElement totalText;

	@FindBy(xpath ="//div[contains(text(),'CATEGORY SPEND')]")
	WebElement categorySpendText;

	@FindBy(xpath ="//span[contains(text(),'P.O. Number')]")
	WebElement PONumberText;

	@FindBy(xpath="//span[contains(text(),'SUBTOTAL')]/../span[2]")
	WebElement displayedSubtotalValue;

	@FindBy(xpath="//span[contains(text(),'SHIPPING')]/../span[2]")
	WebElement displayedShippingValue;

	@FindBy(xpath="//span[contains(text(),'SHIPPING')]/../../span")
	WebElement displayShippingValue;
	
	@FindBy(xpath="//span[contains(text(),'TAX')]/../span[2]")
	WebElement displayedTaxValue;

	@FindBy(xpath="//span[contains(text(),'DISCOUNTS')]/../span[2]")
	WebElement displayedDiscountsValue;

	@FindBy(xpath="//div[@class='cart-summary__total type--bold']/span[2]")
	WebElement displayedTotalValue;

	@FindBy(xpath="//span[text()='Electrical']/../span[2]")
	WebElement displayedElectricalCategorySpendValue;

//	@FindBy(xpath="//span[text()='Furniture & D�cor']/../span[2]")
//	WebElement displayedFurnitureAndDecorsCategorySpendValue;

	@FindBy(xpath = "//div[@class='checkout__right-rail']//button[contains(text(),'Submit secure order')]")
	WebElement submitSecureOrder;
	
	@FindBy(xpath = "//button[@id=\"quoteSubmitBtn3\"]")
	WebElement submitSecureQuote;
	
	@FindBy(xpath = "//input[@name='PONumber']")
	WebElement pONumber;


	/**
	 * @name getShoppingCartPaymentText
	 * @description Method to verify presence of shipping address below checkout.
	 */	
	public String getShoppingCartPaymentText(){
		//System.out.println(shippingToDropdown.getText());
		return paymentAndCheckoutPageHeadingText.getText().trim() ;	
	}



	/**
	 * @name getFinalPriceText
	 * @description Method to get the price
	 */	
	public String getFinalPriceText(){
		return finalPriceText.getText().trim() ;	
	}



	/**
	 * @name getSubTotalAmountText
	 * @description Method to get the Sub Total Amount
	 */	
	public String getSubTotalAmountText(){
		return subTotalAmountText.getText().trim() ;	
	}


	/**
	 * @name getShippingAmountText 
	 * @description Method to get the Shipping Amount
	 */	
	public String getShippingAmountText(){
		return shippingAmountText.getText().trim() ;	
	}


	/**
	 * @name getTaxAmountText
	 * @description Method to get the Tax Amount
	 */	
	public String getTaxAmountText(){
		return taxAmountText.getText().trim() ;	
	}



	/**
	 * @name getDiscountAmountText
	 * @description Method to get the Discount Amount
	 */	
	public String getDiscountAmountText(){
		return discountAmountText.getText().trim() ;	
	}


	/**
	 * @name getTotalAmountText
	 * @description Method to get the Total Amount
	 */	
	public String getTotalAmountText(){
		return totalAmountText.getText().trim() ;	
	}



	/**
	 * click on Secure To Order Button
	 * 
	 */
	public OrderConfirmationPage clickSecureToOrderButton() {
		secureToOrderButton.click();
		WaitTool.waitFor(driver, true);
		return new OrderConfirmationPage(driver);
	}


	public void enterPONumberInTextBox(String poNumber) {
		enterPONumber.clear();
		enterPONumber.sendKeys(poNumber);    	
	}



	public boolean isDisplayedTopLink() {
		return CommonFunctions.isElementPresent(topLink); 
	}

	public void clickOnTopLink() {
		topLink.click();
	}

	public void clickOnReturnPolicy() {
		returnPolicyLink.click();
	}

	public boolean isDisplayedReturnPolicyLink() {
		return CommonFunctions.isElementPresent(returnPolicyLink);
	}


	public boolean  isDisplayedTextAreaBox() {
		return CommonFunctions.isElementPresent(textAreaBox);
	}

	public void clickToggleCollapse() {
		toggleCollapse.click();
	}

	public void clickToggleExpand() {
		toggleExpand.click();
	}

	public boolean isDisplayedEditItemsInCartText() {
		return CommonFunctions.isElementPresent(editItemsInCartText);
	}

	public void enterPONumberInTextBox() {
		enterPONumber.clear();
		enterPONumber.sendKeys("123");    	
	}

	public boolean isDisplayedPONumberText() {
		return CommonFunctions.isElementPresent(PONumberText);
	}

	public void enterPONumber() {

	}
	public boolean isDisplayedCategorySpendText() {
		return CommonFunctions.isElementPresent(categorySpendText);
	}
	public boolean isDisplayedCartSummaryText() {
		return CommonFunctions.isElementPresent(cartSummaryText); 
	}
	public boolean isDisplayedSubTotalText() {
		return CommonFunctions.isElementPresent(subTotalText); 
	}
	public boolean isDisplayedShippingText() {
		return CommonFunctions.isElementPresent(shippingText); 
	}
	public boolean isDisplayedTaxText() {
		return CommonFunctions.isElementPresent(taxText); 
	}
	public boolean isDisplayedTotalText() {
		return CommonFunctions.isElementPresent(totalText); 
	}






	public boolean isDisplayedSubmitSecureOrder1(){
		CommonFunctions.scrolltoViewElement(submitSecureOrder1, driver);
		return CommonFunctions.isElementPresent(submitSecureOrder1);
	}

	public OrderConfirmationPage clickOnSubmitSecureOrder1() {
		submitSecureOrder1.click();
		return new OrderConfirmationPage(driver);
	}

	public boolean isDisplayedSubmitSecureOrder2(){
		CommonFunctions.scrolltoViewElement(submitSecureOrder2, driver);

		return CommonFunctions.isElementPresent(submitSecureOrder2);
	}

	public boolean isDisplayedSubmitSecureOrder3(){
		CommonFunctions.scrolltoViewElement(submitSecureOrder3, driver);

		return CommonFunctions.isElementPresent(submitSecureOrder3);
	}

	public void editInTextAreaBox() {
		textAreaBox.clear();
		textAreaBox.sendKeys("HDSupply");


	}


	public boolean isDisplayedShippingAddressOnPaymentAndCheckOutPage () {
		return CommonFunctions.isElementPresent(ShippingAddressOnPaymentAndCheckOutPage);

	}


	public boolean isDisplayedRadioButtonForChargeMyHDSupplyAccount () {
		CommonFunctions.scrolltoViewElement(radioButtonForChargeMyHDSupplyAccount, driver);
		return CommonFunctions.isElementPresent(radioButtonForChargeMyHDSupplyAccount);
	}




	public boolean isDisplayedtextBoxFormChargeMyCreditCard () {
		
		CommonFunctions.scrolltoViewElement(textBoxFormChargeMyCreditCard, driver);

		return CommonFunctions.isElementPresent(textBoxFormChargeMyCreditCard);
	}


	public boolean isDisplayedRadioButtonForChargeMyCreditCard () {
		CommonFunctions.scrolltoViewElement(radioButtonForChargeMyCreditCard, driver);
		return CommonFunctions.isElementPresent(radioButtonForChargeMyCreditCard);
	}


	public void clickRadioButtonForChargeMyHDSupplyAccount() {
		CommonFunctions.scrolltoViewElement(radioButtonForChargeMyHDSupplyAccount, driver);

		radioButtonForChargeMyHDSupplyAccount.click();
	}

	public void clickRadioButtonForChargeMyCreditCard() {
		CommonFunctions.scrolltoViewElement(radioButtonForChargeMyCreditCard, driver);
		radioButtonForChargeMyCreditCard.click();
	}

	public boolean isSelectedRadioButtonForChargeMyHDSupplyAccount() {
		CommonFunctions.scrolltoViewElement(radioButtonForChargeMyHDSupplyAccount, driver);

		return radioButtonForChargeMyHDSupplyAccount.isSelected();
	}

	public void isSelectedRadioButtonForChargeMyCreditCard() {
		CommonFunctions.scrolltoViewElement(radioButtonForChargeMyCreditCard, driver);

		radioButtonForChargeMyCreditCard.click();
	}	


	public void isDisplayededitAddressLink() {
		CommonFunctions.isElementPresent(editAddressLink);

	}
	public boolean isEnabledditAddressLink() {
		return editAddressLink.isEnabled();
	}

	public String displayedSubtotalValue()
	{
		return displayedSubtotalValue.getText();
	}

	public String displayedShippingValuealValue()
	{
		return displayedShippingValue.getText();
	}

	public String displayShippingValuealValue()
	{
		return displayShippingValue.getText();
	}

	
	public String displayedTaxValue()
	{
		return displayedTaxValue.getText();
	}

	public String displayedDiscountsValue()
	{
		return displayedDiscountsValue.getText();
	}

	public String displayedTotalValue()
	{
		return displayedTotalValue.getText();
	}

	public String displayedElectricalCategorySpendValue()
	{
		return displayedElectricalCategorySpendValue.getText();
	}

/*	public String displayedFurnitureAndDecorsCategorySpendValue()
	{
		return displayedFurnitureAndDecorsCategorySpendValue.getText();
	}*/

	public OrderConfirmationPage clickOnSubmitSecureOrder() throws Exception {
		CommonFunctions.scrolltoViewElement(submitSecureOrder, driver);
		submitSecureOrder.click();
		WaitTool.hardWait();
		return new OrderConfirmationPage(driver);
	}
	
	public OrderConfirmationPage clickOnSubmitSecureQuote() throws Exception {
		submitSecureQuote.click();
		WaitTool.hardWait();
		return new OrderConfirmationPage(driver);
	}
	
	public void insertPONumber() throws Exception
	{
		WaitTool.hardWait();
		String pONumber = CommonFunctions.getRandomNumber();
		enterPONumber.clear();
		enterPONumber.sendKeys(pONumber);  
	}

	
	public boolean isDisplayedYourOrderExpectedDeliveryDates(){
		return CommonFunctions.isElementPresent(yourOrderExpectedDeliveryDates);
	} 

	public void clickOnChargeHDSupplyAccountRadioButton() throws Exception
	{
        WaitTool.waitForElement(driver, chargeHDSupplyAccountRadioButton);
		chargeHDSupplyAccountRadioButton.click();
		WaitTool.hardWait();
	}
}





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
import java.util.List;

public class QuickOrderPad {

	private WebDriver driver;
	protected PageManager pageManager;
	private WaitTool waitTool;
	private ArrayList<UsersListBean> usersList;

	public QuickOrderPad(WebDriver driver) {
		this.driver = driver;
		this.waitTool = new WaitTool();
		PageFactory.initElements(driver, this);
		this.pageManager = new PageManager(driver);

	}

	// Quick Order form
	@FindBy(xpath = "//div[@class='header-quick-order activated']")
	WebElement quickOrderPadModal;


	// Header HD Logo
	/*
	 * @FindBy(xpath =
	 * "//div[@class='header__main']//div[@id='ci_espot__HdsHeaderLogoESpot']")
	 * WebElement headerHDLogoImage;
	 */

	// All Part number text box in quick order form
	/*
	 * @FindBy(xpath = "//input[starts-with(@id,'partNumber_')]") List<WebElement>
	 * AllpartNumbersEdit;
	 */

	@FindBy(xpath = "//div[starts-with(@id,'WC_QuickOrderForm_div_11')]/div[@class='parts__part-row']/div[2]/input")
	// @FindBy(xpath="//div[starts-with(@id,'WC_QuickOrderForm_div_11')]/div[@class='parts__part-row']/div//input[@data-hds-tag='header-quick-order__qty-field']")
	List<WebElement> firstSixpartNumberTextBox;

	/*
	 * @FindBy(xpath =
	 * "//div[starts-with(@id,'WC_QuickOrderForm_div_11')]/div[@class='parts__add-more']/div[@class='parts__part-row']//input[@type='text']")
	 */
	@FindBy(xpath = "//div[@class='header-quick-order__parts']//div[@class='parts__add-more']/..//input[@data-hds-tag='header-quick-order__partnumber-field']")
	public
	List<WebElement> lastSixpartNumberTextBox;

	@FindBy(xpath = "//div[starts-with(@id,'WC_QuickOrderForm_div_11')]/div[@class='parts__part-row']/div/section/input")
	List<WebElement> firstSixquantityBox;

	@FindBy(xpath = "//div[@class='header-quick-order__parts']//div[@class='parts__add-more']/..//input[@data-hds-tag='header-quick-order__qty-field']")
	List<WebElement> lastSixquantityBox;

	@FindBy(xpath = "//div[@class='header-quick-order__footer']//button[contains(text(),'Add to cart')]")
	public WebElement addToCartButton;

	@FindBy(xpath = "//div[@class='quick-order__checkout']")
	WebElement checkoutButton;

	@FindBy(xpath = "//div[@class='quotes-add__new-input']//input[@class='jq-quote-add--input']")
	WebElement quoteNameEdit;

	@FindBy(xpath = "//div[@class='header-quick-order__footer']//a[@data-hds-tag='quick-order__add-more-rows']")
	WebElement addMoreRowsButton;

	@FindBy(xpath = "//div[starts-with(@id,'WC_QuickOrderForm_div_11')][1]/div[@class='parts__part-row']//input[@type='text'][@class='part-row__part-number partNumbersList']")
	WebElement firstpartNumberTextBox;

	@FindBy(xpath = "//div[starts-with(@id,'WC_QuickOrderForm_div_11')][1]/div[@class='parts__part-row']//input[@type='text'][@id='quantity_1']")
	WebElement firstQuantityTextBox;

	@FindBy(xpath = "//*[@id='partNumber_6']")
	WebElement sixPartNumberTextBox;

	@FindBy(xpath = "//*[contains(text(),'Add to list')]")
	public
	WebElement quickOrderAddToList;
	
	@FindBy(xpath = "//button[@class=\"btn btn--large btn--hollow btn--quick-order__checkout jq--quick-order-quick-checkout\"]")
	public WebElement quickCheckoutButton;

	@FindBy(xpath = "//a[contains(text(),'ADD TO QUOTE')]")
	WebElement addToQuoteButton;

	@FindBy(xpath = "//div[@class='tabs__bar']//a[@class='tabs__tab jq-tabs--toggle']")
	WebElement newTab;

	@FindBy(xpath = "//div[@class='quote-add__footer']//button[@id='createNewQuoteBtn']")
	WebElement createQuoteButton;

	@FindBy(xpath = "//div[@id='msgpopup_content_wrapper']")
	WebElement quoteSuccessPopup;

	@FindBy(xpath = "//div[@class='close_icon']")
	WebElement closeQuoteSuccessPopupIcon;

	@FindBy(xpath = "//div[@class='quickordermodal activated']")
	WebElement quickOrderSection;

	@FindBy(xpath = "//div[@id='ShopCartDisplay']//h1[contains(text(),'SHOPPING CART')]")
	WebElement shoppingCartPage;

	/**
	 * @return True if quick order display default six rows otherwise False
	 */
	public boolean isDisplayedDefaultSixRowsInQuickOrderPad() {
		System.out.println("6partNumberTextBox" + firstSixpartNumberTextBox.size());
		System.out.println("6quantityBox" + firstSixquantityBox.size());
		if (firstSixpartNumberTextBox.size() == 6 && firstSixquantityBox.size() == 6) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isDisplayedAddMoreRowsFirstTime() {
		return addMoreRowsButton.isDisplayed();

	}

	public void clickAddMoreRowsFirstTime() {
		pageManager.common().scrolltoViewElement(addMoreRowsButton, driver);
		addMoreRowsButton.click();
	}

	public void clickAddMoreRowsSecondTime() {
		waitTool.waitForElement(driver, addMoreRowsButton);
		pageManager.common().scrolltoViewElement(addMoreRowsButton, driver);
		addMoreRowsButton.click();
		//	return new QuickOrderPage(driver);

	}

	/**
	 * @return True if quick order display Twelve rows when user clicks on Add More
	 *         rows first time otherwise False
	 */
	public boolean isDisplayedTwelveRowsInQuickOrderPad() {
		if (firstSixpartNumberTextBox.size() == 6 && firstSixquantityBox.size() == 6
				&& lastSixpartNumberTextBox.size() == 6 && lastSixquantityBox.size() == 6) {
			return true;
		} else {
			return false;
		}
	}

	public void fillFirstSixPartNumberTextBox(String partNumber1, String partNumber2, String partNumber3,
			String partNumber4, String partNumber5, String partNumber6) 
	{
		waitTool.waitForElement(driver,firstpartNumberTextBox);
		pageManager.common().scrolltoViewElement(firstpartNumberTextBox,driver);
		String partnumber[] = { partNumber1, partNumber2, partNumber3, partNumber4, partNumber5, partNumber6 };
		int i = 0;
		for (WebElement we : firstSixpartNumberTextBox) {
			pageManager.common().scrolltoViewElement(we, driver);
			we.clear();
			we.sendKeys(partnumber[i]);
			i++;
		}
		firstSixpartNumberTextBox.get(0).click();
	}
	
	
	public void fillFirstTwoPartNumberTextBox(String partNumber1, String partNumber2) throws Exception{
		waitTool.waitForElement(driver,firstpartNumberTextBox);
		pageManager.common().scrolltoViewElement(firstpartNumberTextBox,driver);
		String partnumber[] = { partNumber1, partNumber2 };
		int i = 0;
		for (WebElement we : firstSixpartNumberTextBox) {
			if(i<2)
			{
			we.clear();
			we.sendKeys(partnumber[i]);
			i++;
			System.out.println("value of is is"+ i );
			
			}
		}

	}

	public void fillFirstSixQuantityTextBox(String quantity1, String quantity2, String quantity3, String quantity4,
			String quantity5, String quantity6) {
		String quantity[] = { quantity1, quantity2, quantity3, quantity4, quantity5, quantity6 };
		int i = 0;
		for (WebElement we : firstSixquantityBox) {
			we.clear();
			we.sendKeys(quantity[i]);
			i++;
		}

	}
	public void addTwoDifferentProductsUsingQuickOrder() throws Exception {
		pageManager.quickOrderPad().isDisplayedDefaultSixRowsInQuickOrderPad();
		usersList=pageManager.dBCon().loadDataFromExcel("addProductsUsingQuickOrder", "QuickOrder");
		pageManager.quickOrderPad().fillFirstTwoPartNumberTextBox(usersList.get(0).getPartNumber1(), usersList.get(0).getPartNumber2());
		Assert.assertEquals(usersList.get(0).getPartNumber1(), pageManager.quickOrderPad().firstPartNumberTextBoxFilledValue());
	//	Assert.assertEquals(usersList.get(0).getPartNumber6(), pageManager.quickOrderPad()._lastPartNumberTextBoxFilledValue());
	}



	public void fillFirstPartNumberTextBox(String partNumber1) throws Exception {
		waitTool.waitForElement(driver, firstpartNumberTextBox);
		pageManager.common().scrolltoViewElement(firstpartNumberTextBox, driver);
		firstpartNumberTextBox.clear();
		firstpartNumberTextBox.sendKeys(partNumber1);
	}

	public void fillFirstQuantityTextBox(String quantity1) {
		waitTool.waitForElement(driver, firstQuantityTextBox);
		pageManager.common().scrolltoViewElement(firstQuantityTextBox, driver);
		firstQuantityTextBox.clear();
		firstQuantityTextBox.sendKeys(quantity1);

	}
	public void fillFirstPartAndQuantityQuickOrderPad(String partNumber, String qty) throws Exception {
		//	usersList = pageManager.dBCon().loadDataFromExcel("addProductsUsingQuickOrder", "QuickOrder");
		pageManager.quickOrderPad().isDisplayedDefaultSixRowsInQuickOrderPad();
		System.out.println("usersList getPartNumber1: " + partNumber + " usersList getQuantity1: " + qty);
		pageManager.quickOrderPad().fillFirstPartNumberTextBox(partNumber);
		pageManager.quickOrderPad().fillFirstQuantityTextBox(qty);
		String firstPartNumberTextBoxValue = pageManager.quickOrderPad().firstPartNumberTextBoxFilledValue();
		String firstQuantityrTextBoxValue = pageManager.quickOrderPad().firstQuantityTextBoxFilledValue();
		System.out.println("firstPartNumberTextBoxValue is:_ " + firstPartNumberTextBoxValue + "firstQuantityrTextBoxValue is:_ " + firstQuantityrTextBoxValue);
		Assert.assertEquals(partNumber, firstPartNumberTextBoxValue);
		Assert.assertEquals(qty, firstQuantityrTextBoxValue);
	}


	public String firstPartNumberTextBoxFilledValue() throws Exception {
		return firstpartNumberTextBox.getAttribute("value") + "";
	}

	public String firstQuantityTextBoxFilledValue() throws Exception {
		System.out.println("value in firstQuantityTextBox" + firstQuantityTextBox);
		return firstQuantityTextBox.getAttribute("value") + "";
	}

	public String _lastPartNumberTextBoxFilledValue() throws Exception {
		return sixPartNumberTextBox.getAttribute("value") + "";
	}


	public void clickOnAddToCartButton(){
/*		int displayedShoppingCartProductCountBeforeAddToCart=pageManager.homePage().getShoppingCartProductCount();
		System.out.println("displayedShoppingCartProductCountBeforeAddToCart   "+ displayedShoppingCartProductCountBeforeAddToCart);
		waitTool.waitFor(driver, true);
		waitTool.waitForElement(driver, addToCartButton);
		.scrolltoViewElement(addToCartButton, driver);
		waitTool.waitFor(driver, true);
		addToCartButton.click();
		waitTool.waitFor(driver, true);
		int displayedShoppingCartProductCountAfterAddToCart=pageManager.homePage().getShoppingCartProductCount();
		System.out.println("displayedShoppingCartProductCountAfterAddToCart is "+ displayedShoppingCartProductCountAfterAddToCart);
		Assert.assertNotEquals(displayedShoppingCartProductCountBeforeAddToCart,displayedShoppingCartProductCountAfterAddToCart);*/
		

		//int displayedShoppingCartProductCountBeforeAddToCart=pageManager.homePage().getShoppingCartProductCount();
		//System.out.println("displayedShoppingCartProductCountBeforeAddToCart   "+ displayedShoppingCartProductCountBeforeAddToCart);
		waitTool.waitForElement(driver, addToCartButton);
		//pageManager.common().scrolltoViewElement(addToCartButton, driver);
		addToCartButton.click();
		waitTool.waitFor(driver, true);
	/*	int displayedShoppingCartProductCountAfterAddToCart=pageManager.homePage().getShoppingCartProductCount();
		while(displayedShoppingCartProductCountAfterAddToCart==displayedShoppingCartProductCountBeforeAddToCart)
		{
			displayedShoppingCartProductCountAfterAddToCart=pageManager.homePage().getShoppingCartProductCount();
		}
		System.out.println("displayedShoppingCartProductCountAfterAddToCart is "+ displayedShoppingCartProductCountAfterAddToCart);
		Assert.assertTrue(displayedShoppingCartProductCountBeforeAddToCart<displayedShoppingCartProductCountAfterAddToCart);
	*/
	}


	/**
	 * @name isDisplayedquickOrderSection
	 * @description Method to verify the presence of quick order section after
	 *              clicking.
	 * @return String value
	 */
	public boolean isDisplayedquickOrderSection() {
		return pageManager.common().isElementPresent(quickOrderSection);
	}

	public void clickCheckoutButton() {
		waitTool.waitForElement(driver, checkoutButton);
		pageManager.common().scrolltoViewElement(checkoutButton, driver);
		checkoutButton.click();

	}

	public boolean shoppingCartPageDispalyed() {
		return pageManager.common().isElementPresent(shoppingCartPage);

	}

	public void clickAddToQuoteButton() {
		pageManager.common().scrolltoViewElement(addToQuoteButton, driver);
		addToQuoteButton.click();
	}

	public Boolean isAddToQuoteButtonDisplayed() {
		return addToQuoteButton.isDisplayed();
	}

	public boolean isDisplayedNewTab() {
		return newTab.isDisplayed();
	}

	public void clickNewTab() {
		newTab.click();
	}

	public void enterQuoteName(String quote) {
		quoteNameEdit.sendKeys(quote);
	}

	public boolean isDisplayedCreateQuoteButton() {
		return createQuoteButton.isDisplayed();
	}

	public void clickCreateQuoteButton() {
		createQuoteButton.click();
	}

	public Boolean isDisplayedQuoteSuccessPopup() {
		return quoteSuccessPopup.isDisplayed();
	}

	public void clickCloseQuoteSuccessPopupIcon() {
		closeQuoteSuccessPopupIcon.click();
		//return new HomePage(driver);
	}

	public void clickAddTolist(){
		waitTool.waitForElement(driver,quickOrderAddToList);
		pageManager.common().scrolltoViewElement(quickOrderAddToList, driver);
		quickOrderAddToList.click();
	}
}



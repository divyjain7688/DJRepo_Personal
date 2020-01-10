package com.selenium.ebiz.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.selenium.ebiz.baseclass.BaseClass;
import com.selenium.ebiz.tools.CommonFunctions;
import com.selenium.ebiz.tools.WaitTool;

public class ShoppingCartPage extends BaseClass{

	public ShoppingCartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		WebDriverWait wait = new WebDriverWait(driver, 5000);
		wait.until(ExpectedConditions.visibilityOf((shoppingCartPageHeadingText)));
	}

	@FindBy(xpath = "//*[text()='FLAT OR ASSEMBLED:']/../../td[2]/input")
	WebElement flatOrAssembledTextBox;

	@FindBy(xpath = "//*[text()='LABEL FORMAT:']/../../td[2]/input")
	WebElement labelFormatTextBox;

	@FindBy(xpath = "//*[text()='COLOR:']/../../td[2]/input")
	WebElement colorTextBox;

	@FindBy(xpath = "//*[text()='STYLE (CASE ?):']/../../td[2]/input")
	WebElement styleTextBox;

	@FindBy(xpath = "//*[text()='IMPRINT LINE 1:']/../../td[2]/input")
	WebElement imprintLine1TextBox;

	@FindBy(xpath = "//*[text()='IMPRINT LINE 2:']/../../td[2]/input")
	WebElement imprintLine2TextBox;

	@FindBy(xpath = "//*[text()='IMPRINT LINE 3:']/../../td[2]/input")
	WebElement imprintLine3TextBox;

	@FindBy(xpath = "//div[@class=\"modal__inner\"]")
	WebElement addToListModalWindow;

	@FindBy(xpath = "//*[text()='IMPRINT LINE 4:']/../../td[2]/input")
	WebElement imprintLine4TextBox;

	@FindBy(xpath = "//*[text()='IMPRINT LINE 5:']/../../td[2]/input")
	WebElement imprintLine5TextBox;

	@FindBy(xpath = "//*[text()='IMPRINT LINE 6:']/../../td[2]/input")
	WebElement imprintLine6TextBox;

	@FindBy(xpath = "//*[text()='IMPRINT LINE 7:']/../../td[2]/input")
	WebElement imprintLine7TextBox;

	@FindBy(xpath = "//*[text()='COMMENTS:']/../../td[2]/input")
	WebElement commentsTextBox;

	@FindBy(xpath = "//div[@class='save']")
	WebElement plusCartButton;

	@FindBy(xpath = "//input[@value='Approve']")
	WebElement approveButton;

	@FindBy(xpath = "//div[@class=\"tabs\"]//a[contains(text(),'New')]")
	WebElement newListTab;

	@FindBy(xpath = "//div[contains(text(),'Shared')]/../span")
	WebElement sharedListRadioButton;

	@FindBy(xpath = "//input[@id=\"name\"]")
	WebElement listNameTextbox;

	@FindBy(xpath = "//button[contains(text(),'Create List')]")
	WebElement newLsitButton;

	@FindBy(xpath = "//a[contains(text(),'Customize This Item')]")
	WebElement customizeThisItemLink;

	@FindBy(xpath = "//a[contains(text(),'ve customized this item')]")
	WebElement youHaveCutomizedLink;

	@FindBy(xpath = "//div[@class='modal modal--visible']")
	WebElement pTConfiguratorModalWindow;

	@FindBy(xpath = "//div[@id='msgpopup_content_wrapper']")
	WebElement successMessageAfterAddToQuote;

	@FindBy(xpath = "//div[@id='msgpopup_content_wrapper']//div[@class='close_icon']")
	WebElement closeButtonOnAddToQuoteSuccessMessage;

	@FindBy(xpath = "//button[contains(text(),'Add To Quote')]")
	WebElement addToQuoteButtonOnQuoteModal;

	@FindBy(xpath = "//tbody[@id='addToExistingRecord']/tr[1]")
	WebElement firstExistingQuote;

	@FindBy(xpath = "//div[text()='Close']")
	WebElement closePopup;

	@FindBy(xpath = "//h1")
	WebElement shoppingCartOrderProcessText;

	@FindBy(xpath = "//div[@class='header__main']//div[@id='contentRecommendationWidget_HdsHeaderLogoESpot']")
	WebElement hDSupplyLogoInHeader;

	@FindBy(xpath="//input[@id='SimpleSearchForm_SearchTerm']")
	WebElement searchBox;

	@FindBy(xpath="//*[@id='searchBox']/a/*[name()='svg']/*[name()='g']/*[name()='circle']")
	WebElement searchButton;

	@FindBy(xpath="//div[@class='shopping-cart__address type--caption']")
	WebElement defaultShippingAddress;

	@FindBy(xpath="//div[@class='content__description type--caption']")
	WebElement deliveryMessage;

	@FindBy(css = "a#Header_GlobalLogin_signInQuickLink")
	WebElement headerRegisterOrSignInLinkText;

	@FindBy(id = "Header_GlobalLogin_WC_AccountDisplay_FormInput_logonId_In_Logon_1")  
	WebElement userNameEdit;

	//password
	@FindBy(id = "Header_GlobalLogin_WC_AccountDisplay_FormInput_logonPassword_In_Logon_1")     
	WebElement passwordEdit;

	//Sign in button
	@FindBy(id = "Header_GlobalLogin_WC_AccountDisplay_links_2") 
	WebElement signInButton;

	@FindBy(xpath="//div[contains(text(),'must be customized. Please click Customize This Item or call')]")
	WebElement mustBeCustomizedMessage;

	@FindBy(className = "cart__quantity")
	WebElement miniCartCount;

	@FindBy(xpath = "//div[@class='tooltip-box']//span[contains(text(),'source code')]")
	WebElement sourceCode;

	@FindBy(xpath="//input[@id='promoCode']")
	WebElement enterSourceCode;

	@FindBy(xpath="//div[@class='content__description type--caption']") // /div[contains(text(),'Sorry')]")
	WebElement unavailablePartNumber;

	@FindBy(xpath="//a[text()='Add new address']") 
	WebElement addNewAddressLink;

	@FindBy(xpath="//div[@class='modal__inner']") 
	WebElement addNewAddressModalWindow;

	@FindBy(xpath="//input[@name='nickName']") 
	WebElement shippingAddressNameTextBox;

	@FindBy(xpath="//input[@name='organizationName']") 
	WebElement companyPropertyNameTextBox;

	@FindBy(xpath="//input[@name='shipTo_address1']") 
	WebElement addressTextBox;

	@FindBy(xpath="//input[@name='city']") 
	WebElement cityTextBox;

	@FindBy(xpath="//select[@name='state']")
	WebElement 	stateDropdown;

	@FindBy(xpath="//a[contains(text(),'Create new address')]")
	WebElement 	createNewAddressButton;

	@FindBy(xpath="//input[@name='address2']")
	WebElement 	floorOrSuiteTextBox;

	@FindBy (xpath="//input[@name='zipCode']")
	WebElement zipCodeTextBox;

	@FindBy (xpath="//input[@name='phone1']")
	WebElement phoneNumberTextBox;

	@FindBy(xpath="//a[@id='GotoCartButton1']")
	WebElement modalViewCartButton;

	@FindBy(xpath="//a[contains(text(),'Checkout')]")
	List<WebElement> checkOutButtons;

	@FindBy(xpath="//div[@class='quick-order__label']/span[text()='Quick Order']")
	WebElement headerQuickOrderLink;

	@FindBy(xpath = "//div[@class='checkout__header']/div/button[@class='btn btn--full']")
	WebElement secureToOrderButton;

	@FindBy(xpath = "//div[@id='mainContent']/section/h1")
	WebElement shoppingCartPaymentText;

	@FindBy(xpath = "//div[@class='cart-added__name-price']//div[1]/span[1]")
	WebElement modalShoppingCartPriceText;

	@FindAll(@FindBy(xpath="//button[starts-with(@id,'removeItem_')]"))
	List<WebElement> miniCartRemoveButton;

	@FindBy(xpath = "//div[@id='ShopCartPagingDisplay']/div[2]/section/div[3]/div[2]/div[1]/span")
	WebElement shoppingCartPriceText;

	@FindBy(xpath = "//div[@id='ShopCartPagingDisplay']/div[2]/section/div[3]/div[4]/button[1]")
	WebElement shoppingCartAddToListButton;

	@FindBy(xpath = "//div[@id='ShopCartPagingDisplay']/div[2]/section/div[3]/div[4]/button[2]")
	WebElement shoppingCartAddToQuoteButton;

	@FindAll(@FindBy(xpath="//button[starts-with(@id,'removeItem_')]"))
	WebElement shoppingCartRemoveButton;

	@FindBy(xpath = "//div[@class='items-footer__btns']/a[@data-hds-tag='shopping-cart__item-footer-checkout-btn']")
	WebElement shoppingCartCheckOutButton;

	@FindBy(xpath = "//a[@data-hds-tag='shopping-cart__item-footer-checkout-btn']")
	WebElement checkOutButton;

	@FindBy(xpath = "//div[@id='ShopCartDisplay']/section/div/div[2]/div[2]/div[2]")
	WebElement shoppingAddressText;

		@FindBy(xpath = "//div[@id='ShopCartDisplay']//h1[contains(text(),'SHOPPING CART')]")
	WebElement shoppingCartPageHeadingText;

	@FindBy(xpath = "//div[@class='breadcrumbs']//div/*[@class='icon icon--carat-left']")
	WebElement continueShoppingBreadCrumbLink;
	
	@FindBy(xpath = "//div[@class='parts__part-row']/div/input[@id='partNumber_1']")
	WebElement quickOrderPartNumberEdit;

	@FindBy(xpath = "//section[@class='number-stepper']//input[@id='quantity_1']")
	WebElement quickOrderQuantityEdit;

	@FindBy(xpath = "//*[contains(text(),'ADD PARTS to YOUR CART')]")
	WebElement addPartsToYourCartText;

	@FindBy(xpath = "//div[@class='add-parts-cart__row']//input[@id='partNumber_1']")
	WebElement partNumberEdit;

	@FindBy(xpath="//div[@class='add-parts-cart__row']//input[@id='quantity_1']")
	WebElement quantityEdit;

	@FindBy(xpath = "//span[text()='ADD']")
	WebElement addButton;	

	@FindAll({
		@FindBy(how = How.XPATH  , using = "//div[@id='ShopCartPagingDisplay']//section[@class='shopping-cart__list-item']")
	})
	public List<WebElement> shoppingCartListItems;

	@FindBy(xpath = "//button[contains(text(),'Save as quote')]")
	WebElement saveAsQuoteButton;

	@FindBy(xpath = "//a[@data-hds-tag='shopping-cart__item-footer-links-clearcart-btn'][contains(text(),'EMPTY CART')]")
	WebElement emptyCartLink;

	@FindBy(xpath = "//p[@class='content--empty']")
	WebElement shoppingCartEmptyMessage;

	@FindBy(xpath = "//a[text()='VIEW SAVED QUOTES']")
	WebElement viewSavedQuotesLink;

	@FindBy(xpath = "//a[text()='RETURN POLICY']")
	WebElement returnPolicyLink;

	@FindBy(xpath = "//h1[text()='Return Policy']")
	WebElement returnPolicyText;

	@FindBy(xpath = "//div[@class='items-footer__links--top']//a[@data-hds-tag='shopping-cart__item-footer-links-scroll-to-top-btn']")
	WebElement footerTopLink;

	@FindBy(xpath = "//div[@class='shopping-cart__address type--caption']")
	WebElement shipToAddressText;

	@FindBy(xpath = "//div[@class='shopping-cart__address type--caption']/div[1]")
	WebElement shipToAddressLine1Text;

	@FindBy(xpath = "//div[@class='shopping-cart__address type--caption']/div[2]")
	WebElement shipToAddressLine2Text;

	@FindBy(xpath = "//div[@class='shopping-cart__address type--caption']/div[3]")
	WebElement shipToAddressLine3Text;

	@FindBy(xpath = "//div[@class='shopping-cart__shipping']//select")
	WebElement shippingToDropdown;

	@FindBy(id = "ErrorMessageText")
	WebElement successOrErrorMessageText;	

	@FindBy(xpath = "//div[@id='msgpopup_content_wrapper']//span[text()='The item has been successfully added to your current order']")
	WebElement successMessageText;	

	@FindBy(xpath = "//div[@id='msgpopup_content_wrapper']")
	WebElement errorMessageText;	

	@FindBy(xpath = "//a[@id='clickableErrorMessageImg']")
	WebElement closeSuccessOrErrorMessagePopup;	

	@FindBy(xpath = "//div[@class='list-item__quantity']//input")
	List<WebElement> allItemsQuantityList;

	@FindBy(xpath = "//div[contains(text(),'Delivery date')]/span")
	List<WebElement> deliveryDates;

	@FindBy(xpath = "//div[@class='cart-summary__total type--bold']/span[@class='cart-summary__price type--body-x-large']")
	WebElement cartTotalAmountText;

	@FindBy(xpath = "//div[@data-hds-tag='shopping-cart__item-list-actions-partnumber']")
	List<WebElement> partNumberDisplayed;

	@FindBy(xpath = "//div[@class='list-item__quantity']")
	List<WebElement> quantityStepperDisplayed;

	@FindBy(xpath = "//span[@data-hds-tag='shopping-cart__item-list-actions-price-value']")
	List<WebElement> productPriceDisplayed;

	@FindBy(xpath = "//button[contains(text(),'Add to List')]")
	List<WebElement> addToListButtonDisplayed;

	@FindBy(xpath = "//button[contains(text(),'Add to Quote')]")
	List<WebElement> addToQuoteButtonDisplayed;

	@FindBy(xpath = "//div[@id='add_to_quote_modal']")
	WebElement addToQuoteModal;

	@FindBy(xpath = "//div[@class='quick-order__label']")
	WebElement headerQuickOrderLinkText;

	@FindBy(xpath = "html/body/div[18]//div[@class='list-add']/h2")
	WebElement addToListModalTitleText;

	@FindBy(xpath = "//a[text()='Existing']")
	WebElement addToListExistingTab;

	@FindBy(xpath = "//div[@class='tabs__bar']//a[contains(text(),'New')]")
	WebElement addToListNewTab;

	@FindBy(xpath="//button[contains(text(),'Add to List')]")
	WebElement addToListButton;

	@FindBy(xpath = "//div[@class='product-detail__description']/span")
	WebElement productNameText;

	@FindBy(xpath = "//div[@class='widget-wrapper__header']//h3[contains(text(),'Add to existing or Create new list')]")
	WebElement addToExistingOrCreateNewListText;

	@FindBy(xpath = "//a[text()='Existing']")
	WebElement defaultTabselected;

	@FindBy(xpath = "//ul[@class='list-add__list']/li[1]")
	WebElement firstSavedListText;

	@FindBy(xpath = "//a[@data-hds-tag='shopping-cart__actions__add-all-to-list'][contains(text(),'CREATE / EDIT SAVED LIST')]")
	WebElement createOrEditSavedListButton;

	@FindBy(xpath = "//div[@class='header__enter-name']//input[@id='name']")
	WebElement newListNameEdit;

	@FindBy(xpath = "//div[@class='listCreate']//button[contains(text(),'Create List')]")
	WebElement createListButton;

	@FindBy(xpath="//div[@class='quick-info__quick-links type--body-small']//a[text()='Saved Lists']")
	WebElement myAccountSavedListsQuickLink;

	@FindBy(xpath="//span[contains(text(),'SUBTOTAL')]/../span[2]")
	WebElement displayedSubtotalValue;

	@FindBy(xpath="//span[contains(text(),'SHIPPING')]/../span[2]")
	WebElement displayedShippingValue;

	@FindBy(xpath="//span[contains(text(),'TAX')]/../span[2]")
	WebElement displayedTaxValue;

	@FindBy(xpath="//span[contains(text(),'DISCOUNTS')]/../span[2]")
	WebElement displayedDiscountsValue;

	@FindBy(xpath="//div[@class='cart-summary__total type--bold']/span[2]")
	WebElement displayedTotalValue;
	
	@FindBy (id = "partNumber_1")
	WebElement partNumberTextBox;

	@FindBy (xpath = "//*[@class='shopping-cart__add-parts-btn']/a")
	WebElement addButton1;

	@FindBy (xpath = "//div[contains(text(),'UNAVAILABLE')]")
	WebElement unavailableWarningMessageHeadingText;

	@FindBy ( xpath = "//div[contains(@class, 'alert-box--cart-unavailable')]")
	WebElement unavailableErrorText;

	@FindBy(xpath = "//*[@class='shopping-cart__add-parts-btn']//button[@data-hds-tag='shopping-cart__add-parts-btn'] | //*[@class='add-parts-cart__add-btn']//a[@data-hds-tag='shopping-cart-empty__add-part-button']")
	WebElement addButtonHeader;

	public String unavailableErrorTextMessage;

	/**
	 * To write dynamic xpaths. Xpath is passed as a string argument to findelement.
	 */
	String xpath = "//div[@id='ShopCartPagingDisplay']//section[@class='shopping-cart__list-item']";
	String brand ="//div[@class='list-item__attributes type--caption']/div[1]";
	String origin = "//div[@class='list-item__attributes type--caption']/div[2]";
	String mfgPart = "//div[@class='list-item__attributes type--caption']/div[3]";
	String shipping = "//div[@class='list-item__attributes type--caption']/div[3]";
	String quantityStepper = "//div[@class='number-stepper']";
	String partNo = "//div[@class='list-item__part-number']";
	String addToListbtn ="//div[@class='list-item__add-to-x']/button[1]";
	String addToQuotebtn = "//div[@class='list-item__add-to-x']/button[2]";
	String removebtn = "//div[@class='list-item__add-to-x']/button[3]";

	/**
	 * This method is to get the xpath for each attribute passed as a parameter
	 * @return String 
	 * @parameter String attribute
	 */

	public String selectTheAttribute(String attribute) {
		String xpaths = null;	
		switch (attribute.toUpperCase()) {
		case "BRAND":
			xpaths=brand;
			break;
		case "ORIGIN":
			xpaths=origin;
			break;
		case "MFGPART":
			xpaths=mfgPart;
			break;
		case "SHIPPING":
			xpaths=shipping;
			break;
		case "QUANTITYSTEPPER":
			xpaths=quantityStepper;
			break;
		case "PARTNO":
			xpaths=partNo;
			break;
		case "ADDTOLIST":
			xpaths=addToListbtn;
			break;
		case "ADDTOQUOTE":
			xpaths=addToQuotebtn;
			break;
		case "REMOVE":
			xpaths=removebtn;
			break;
		}		
		return xpaths;
	}

	/**
	 * Verify the visibility of attribute within each item section.
	 * @return boolean
	 * @parameter String attribute
	 */

	public boolean visibilityOfAttribute(String attribute) {
		boolean status = false;String xpaths = selectTheAttribute(attribute);		
		for (int i=1;i<=shoppingCartListItems.size();i++) {
			if (CommonFunctions.isElementPresent(driver.findElement(By.xpath(xpath + "["+ i +"]" + xpaths))))
				status = true;
		}
		//System.out.println(status);
		return status;
	}
	
	public boolean isDisplayedCheckOutButton(){
		return CommonFunctions.isElementPresent(shoppingCartCheckOutButton);
	}
	
	/**
	 *  Methods to Verify Shopping Address
	 * @return
	 */
	public boolean isDisplayedShoppingAddressText(){
		return CommonFunctions.isElementPresent(shoppingAddressText);
	}

	/**
	 * click on Checkout Button
	 * @return 
	 * Updated by bm071260
	 * @throws Exception 
	 */
	public PaymentAndCheckOutPage clickShoppingCartCheckOutButton() throws Exception {
		CommonFunctions.scrolltoViewElement(shoppingCartCheckOutButton, driver);
		//WebDriverWait wait = new WebDriverWait(driver, 15000);
		//wait.until(ExpectedConditions.visibilityOf((shoppingCartCheckOutButton)));
		Thread.sleep(9000);
		shoppingCartCheckOutButton.click();
		return new PaymentAndCheckOutPage(driver);
	}

	public SignInOrRegisterPage clickShoppingCartCheckOutButtonAsGuestUser() {
		CommonFunctions.scrolltoViewElement(shoppingCartCheckOutButton, driver);
		shoppingCartCheckOutButton.click();
		return new SignInOrRegisterPage(driver);
	}

	public SignInOrRegisterPage clickOnShoppingCartCheckOutButton() {
		checkOutButton.click();
		return new SignInOrRegisterPage(driver);
	}



	/**
	 * Method to click on the attribute which is passed as a parameter from the first section or the first product displayed in shopping cart.
	 * @return boolean
	 * @param String attribute
	 */
	public void clickOnItemsAttributeButton(String attribute) throws Exception {
		String xpaths = selectTheAttribute(attribute);
		int i = shoppingCartListItems.size()-(shoppingCartListItems.size()-1); 
		if(shoppingCartListItems.size()>0)
			WaitTool.hardWait();
		driver.findElement(By.xpath(xpath + "["+ i +"]" + xpaths)).click();
		WaitTool.waitFor(driver, true);				
	}		

	/**
	 * @name removeItemShoppingCart
	 * @description Method to remove an item from shopping cart.
	 * @return boolean
	 */	
	public boolean removeItemShoppingCart() throws Exception{
		int size = shoppingCartListItems.size();
		clickOnItemsAttributeButton("remove");
		WaitTool.waitFor(driver, true);
		WaitTool.hardWait();
		if (shoppingCartListItems.size()==size-1)
			return true;
		else
			return false;		
	}

	/**
	 * @name removeItemShoppingCart
	 * @description Method to remove all item from shopping cart.
	 * @return boolean
	 */	

	public boolean removeAllItemShoppingCart() throws Exception{
		int size = shoppingCartListItems.size();
		boolean flag=false;		
		for (int i=1;i<=shoppingCartListItems.size();i++) {
			if(!(shoppingCartListItems.size()==size-1)){
				clickOnItemsAttributeButton("remove");
				WaitTool.waitFor(driver, true);
				WaitTool.hardWait();
			}else
				flag=true;
			break;		
		}
		return flag;
	}

	/**
	 * @name isDisplayedSaveAsQuoteButton
	 * @description Method to verify presence of saveAsQuoteButton .
	 * @param 
	 * @return 
	 * 
	 */	
	public boolean isDisplayedSaveAsQuoteButton(){
		return CommonFunctions.isElementPresent(saveAsQuoteButton);		
	}

	public void clickOnSaveAsQuoteButton()
	{
		saveAsQuoteButton.click();
	}

	public QuotesPage clickOnViewSavedQuotesLink()
	{
		viewSavedQuotesLink.click();
		return new QuotesPage(driver);
	}

	/**
	 * @name isDisplayedEmptyCartLink
	 * @description Method to verify presence of emptyCartLink .
	 * @param 
	 * @return 
	 * 
	 */	
	public boolean isDisplayedEmptyCartLink(){
		return CommonFunctions.isElementPresent(emptyCartLink);		
	}

	/**
	 * @name isDisplayedViewSavedQuotesLink
	 * @description Method to verify presence of viewSavedQuotesLink .
	 * @param 
	 * @return 
	 * 
	 */	
	public boolean isDisplayedViewSavedQuotesLink(){
		return CommonFunctions.isElementPresent(viewSavedQuotesLink);		
	}


	/**
	 * @name isDisplayedReturnPolicyLink
	 * @description Method to verify presence of returnPolicyLink .
	 */	
	public boolean isDisplayedReturnPolicyLink(){
		return CommonFunctions.isElementPresent(returnPolicyLink);		
	}

	public void clickOnReturnPolicyLink()
	{
		returnPolicyLink.click();
	}

	/**
	 * @name isDisplayedFooterTopLink
	 * @description Method to verify presence of footerTopLink .
	 */	
	public boolean isDisplayedFooterTopLink(){
		return CommonFunctions.isElementPresent(footerTopLink);		
	}

	/**
	 * @name isDisplayedShippingAddressText
	 * @description Method to verify presence of shipping address below checkout.
	 */	
	public boolean isDisplayedShippingAddressText(){
		return CommonFunctions.isElementPresent(shipToAddressText);			
	}

	public String getShippingAddressLine1Text()
	{
		System.out.println("shipToAddressLine1Text.getText() is " + shipToAddressLine1Text.getText() );
		return shipToAddressLine1Text.getText();

	}

	public String getShippingAddressLine2Text()
	{
		System.out.println("shipToAddressLine2Text.getText() is " + shipToAddressLine2Text.getText() );
		return shipToAddressLine2Text.getText();

	}

	public String getShippingAddressLine3Text()
	{
		System.out.println("shipToAddressLine3Text.getText() is " + shipToAddressLine3Text.getText() );
		return shipToAddressLine3Text.getText();

	}
	/**
	 * @name getFirstSelectedOptionFromShippingToDrpDown
	 * @description Method to get the selection option in shipping to dropdown
	 * @return String value
	 */
	public String getFirstSelectedOptionFromShippingToDrpDown(){
		Select select = new Select(shippingToDropdown);
		System.out.println(select.getFirstSelectedOption());
		return select.getFirstSelectedOption().getText();		
	}

	/**
	 * @name isDisplayedShippingAddressText
	 * @description Method to verify presence of shipping address below checkout.
	 */	
	public boolean isDisplayedShippingToDropDown(){
		//System.out.println(shippingToDropdown.getText());
		return CommonFunctions.isElementPresent(shippingToDropdown);			
	}


	/**
	 * @name getSuccessOrErrorMessageText
	 * @description Method to get success or error message text displayed after performing actions like Remove item,Add item to cart etc..
	 */	
	public String getSuccessOrErrorMessageText(){
		//System.out.println(shippingToDropdown.getText());
		return successOrErrorMessageText.getText() ;	
	}

	public Boolean isSuccessMessageDisplayed(){
		//System.out.println(shippingToDropdown.getText());
		return successMessageText.isDisplayed();	
	}



	/**
	 * @return true if shopping cart page heading text is displayed otherwise false
	 */
	public boolean isDisplayedShoppingCartPage() {
		WaitTool.waitFor(driver, true);
		return shoppingCartPageHeadingText.isDisplayed();

	}

	/**
	 * @return true if Continue Shopping breadcrumb is displayed in shopping cart page otherwise false
	 */
	public boolean isDisplayedcontinueShoppingBreadCrumbLink() {
		return continueShoppingBreadCrumbLink.isDisplayed();

	}

	/**
	 * click on Continue Shopping breadcrumb
	 * @return the driver to homepage
	 */
	public HomePage ClickContinueShoppingBreadcrumbLink() {
		continueShoppingBreadCrumbLink.click();
		WaitTool.waitFor(driver, true);
		return new HomePage(driver);
	}

	/**
	 * Is displayed Part Number Edit Box  
	 */
	public boolean isDisplayedAddPartsToYourCart() {	
		return addPartsToYourCartText.isDisplayed();
	}

	/**
	 * Enter Part number
	 * @param partNumber
	 */
	public void enterPartNumber(String partNumber) {	
		partNumberEdit.clear();
		partNumberEdit.sendKeys(partNumber);		
	}

	/**
	 * Is displayed Part Number Edit Box  
	 */
	public boolean isDisplayedPartNumber() {	
		return partNumberEdit.isDisplayed();
	}

	/**
	 * Enter quantity
	 * @param quantity
	 */
	public void enterQuantity(String quantity) {
		quantityEdit.clear();
		quantityEdit.sendKeys(quantity);
	}

	/**
	 * Is displayed Quantity Edit   
	 */
	public boolean isDisplayedQuantity() {	
		return quantityEdit.isDisplayed();
	}

	/**
	 * Click on Add button
	 */
	public void clickAddButton() {
		addButton.click();

	}

	/**
	 * @name getModalShoppingCartPriceText
	 * @description Method to verify presence of shipping address below checkout.
	 */	
	public String getModalShoppingCartPriceText(){
		//System.out.println(shippingToDropdown.getText());
		return modalShoppingCartPriceText.getText().trim() ;	
	}


	// Method to Verify the Price 
	public boolean isDisplayedPriceText(){
		return CommonFunctions.isElementPresent(shoppingCartPriceText);
	}

	/**
	 * @name isDisplayedShippingAddressText
	 * @description Method to verify presence of shipping address below checkout.
	 */	
	public String getShoppingCartPriceText(){
		//System.out.println(shippingToDropdown.getText());
		return shoppingCartPriceText.getText().trim() ;	
	}


	/**
	 * click on Add to List button
	 * @return 
	 * 
	 */
	public ProductDetailsPage clickShoppingCartAddToListButton() {
		shoppingCartAddToListButton.click();
		WaitTool.waitFor(driver, true);
		return new ProductDetailsPage(driver);
	}

	// Method to Verify Add To List
	public boolean isDisplayedAddToListButton(){
		return CommonFunctions.isElementPresent(shoppingCartAddToListButton);
	}



	// Method to Verify Add To Quote
	public boolean isDisplayedAddToQuote(){
		return CommonFunctions.isElementPresent(shoppingCartAddToQuoteButton);
	}



	// Method to Verify Remove Button
	public boolean isDisplayedRemoveButton(){
		return CommonFunctions.isElementPresent(shoppingCartRemoveButton);
	}

	/**
	 * Quick Add Parts to Cart in the shopping cart page and click on Add button
	 * @param partNumber
	 * @param quantity
	 * @throws Exception 
	 */
	public void addPartsToYourCart(String partNumber, String quantity) throws Exception {		
		enterPartNumber(partNumber);
		enterQuantity(quantity);
		clickAddButton();
		WaitTool.hardWait();
		closePopup.click();
	}

	/**
	 * Get quantity of added item into cart
	 * @return quantity value
	 */
	public String getQuantityOfAddedItemInCart() {
		return allItemsQuantityList.get(allItemsQuantityList.size()-1).getAttribute("value");

	}

	/**
	 * Clear Cart
	 * @throws Exception 
	 * 
	 */
	public void clearCart() throws Exception {
		if(isDisplayedEmptyCartLink()) {
			//emptyCartLink.click(); --Since this link not yet implemented performing below action to clear cart
			emptyCartLink.click(); 
			CommonFunctions.acceptPopupMessageBox(driver);
			/*	List<WebElement> removeButtons = driver.findElements(By.xpath(xpath + removebtn));
			while(removeButtons.size()>0) {
				removeButtons.get(0).click();
				Thread.sleep(10000);
				closeSuccessOrErrorMessagePopup.click();
				removeButtons = driver.findElements(By.xpath(xpath + removebtn));
			}*/
		}
	}

	/**
	 * Clear Cart
	 * @throws Exception 
	 * 
	 */
	public void clearCartReturnsHomePage() throws Exception {
		/*if(isDisplayedEmptyCartLink()) {*/
		WaitTool.hardWait();
		CommonFunctions.scrolltoViewElement(emptyCartLink, driver);
		emptyCartLink.click(); 
		WaitTool.hardWait();
		CommonFunctions.acceptPopupMessageBox(driver);
		//return new HomePage(driver);

		/*--Since this link not yet implemented performing below action to clear cart*/
		/*List<WebElement> removeButtons = driver.findElements(By.xpath(xpath + removebtn));
			while(removeButtons.size()>0) {
				removeButtons.get(0).click();
				Thread.sleep(10000);
				closeSuccessOrErrorMessagePopup.click();
				removeButtons = driver.findElements(By.xpath(xpath + removebtn));
			}*/
		/*}*/
	}

	public LoginPage clearCartReturnsLoginPage() throws Exception {
		/*if(isDisplayedEmptyCartLink()) {*/
		WaitTool.hardWait();
		emptyCartLink.click(); 
		CommonFunctions.acceptPopupMessageBox(driver);
		return new LoginPage(driver); 
	}

	public void validateUnavailableMessage(String part) throws Exception {
		WaitTool.hardWait();
		//partNumberTextBox.clear();
		int x = driver.findElements(By.id("partNumber_1")).size();
		driver.findElements(By.id("partNumber_1")).get(x-1).sendKeys(part);
		WaitTool.hardWait2sec();
		//driver.findElement(By.xpath("//*[@class='shopping-cart__add-parts-btn']/a")).click();
		addButtonHeader.click();
		WaitTool.hardWait2sec();
		/*//CommonFunctions.cancelPopupMessageBox(driver);
		driver.findElement(By.id("clickableErrorMessageImg")).click();
		WebDriverWait wait = new WebDriverWait(driver, 15);
		unavailableErrorTextMessage = unavailableErrorText.getAttribute("textContent");
		 */
	}

	//get all checkout buttons in shopping cart page
	@FindAll(@FindBy(xpath= "//a[contains(text(),'Check Out')]"))
	List <WebElement> allCheckOutButtons;
	// Pop up of Remove button
	@FindBy(xpath="//a[@id='clickableErrorMessageImg']/div[@class='close_icon']")
	WebElement popupCloseButton;

	//Shopping cart section for unavailable items.
	@FindBy(xpath = "//div[contains(text(),'DELIVERY date - Unavailable')]")
	WebElement productUnavailableMessage;

	//Shipping to dropdown
	@FindBy(id = "ErrorMessageText")
	WebElement itemRemovalTextMessage;

	//checkout button below ADD PARTS TO CART
	/*	@FindBy(xpath = "//div[@class='shopping-cart__checkout-btn']/a[contains(text(),'Check Out')]")
	WebElement checkOutButton;*/

	/**
	 * click on top link in shopping cart page.
	 */
	public void ClickTopLink() {
		CommonFunctions.scrolltoViewElement(footerTopLink, driver);
		footerTopLink.click();
		WaitTool.waitFor(driver, true);
	}

	/**
	 *get all checkout button in shopping cart page.
	 *@return 
	 */
	public int getNumberofCheckoutBtn() {
		return allCheckOutButtons.size();
	}

	/**
	 * @name isDisplayedShippingAddressText
	 * @description Method to verify presence of shipping address below checkout.
	 */	
	public String getItemRemovedfromCartMessage(){
		//System.out.println(shippingToDropdown.getText());
		return itemRemovalTextMessage.getText();	
	}

	public boolean isDisplayedCheckoutButton(){
		return CommonFunctions.isElementPresent(checkOutButton);		
	}
	/**
	 * click on empty cart link Shopping breadcrumb
	 */
	public HomePage ClickEmptyCartLink() {
		emptyCartLink.click();
		CommonFunctions.acceptPopupMessageBox(driver);
		return new HomePage(driver);
	}

	public void ClickEmptyCartLinkAndCancel() {
		emptyCartLink.click();
		CommonFunctions.cancelPopupMessageBox(driver);
	}

	public PaymentAndCheckOutPage clickonCheckOutButton() throws Exception {
		//Thread.sleep(3000);
		System.out.println("*******Before clicking checkout button from Shopping cart page**********");
		WaitTool.waitForElement(driver, checkOutButton);
		CommonFunctions.scrolltoViewElement(checkOutButton, driver);
		checkOutButton.click();
		//WaitTool.waitFor(driver, true);
		System.out.println("*******After clicking checkout button**********");
		return new PaymentAndCheckOutPage(driver);
	}

	/*
	 * Search By Keyword Or PartNumber
	 */

	public SearchPage searchByKeywordOrPartNumber(String keyword)
	{
		searchBox.sendKeys(keyword);
		searchButton.click();
		return new SearchPage(driver);		
	}

	/**
	 * @name getFirstSelectedOptionFromShippingToDrpDown
	 * @description Method to get the selection option in shipping to dropdown
	 * @return String value
	 */
	public String getFirstSelectedOptionFromShippingtoDrpDown(){
		Select select = new Select(shippingToDropdown);
		select.selectByIndex(0);
		System.out.println("select.getFirstSelectedOption().getText() is"+ select.getFirstSelectedOption().getText());
		return select.getFirstSelectedOption().getText();		
	}

	public void getAlternateOptionFromShippingtoDrpDown(){
		Select select = new Select(shippingToDropdown);
		List<WebElement> dropdownOptions = select.getOptions();
		for(WebElement dropdownOption : dropdownOptions)
		{
			if(dropdownOption.getText().contains("Alternate"))
			{
				System.out.println("dropdownOption.getText() iss" + dropdownOption.getText());
				dropdownOption.click();
				break;
			}

		}		
	}

	public void selectDefaultOptionFromShippingDropdown() throws InterruptedException
	{
		CommonFunctions.scrolltoViewElement(shippingToDropdown, driver);
		Select select = new Select(shippingToDropdown);
		List<WebElement> options = select.getOptions();
		for(WebElement option : options)
		{
			System.out.println("option.gettext()"+ option.getText());
			if(option.getText().equals("Default"))
			{
				System.out.println("default selected");
				option.click();
				Thread.sleep(5000);
				break;
			}
		}
	}

	public void selectNonDefaultOptionFromShippingDropdown()
	{
		Select select = new Select(shippingToDropdown);
		List<WebElement> options = select.getOptions();
		for(WebElement option : options)
		{
			System.out.println("option.gettext()"+ option.getText());
			if(!option.getText().equals("Default"))
			{
				option.click();
				System.out.println("non default selected" + option.getText());
				break;
			}
		}

	}

	/**
	 * @name selectShippingtoAddressApartfromDefaultaddress
	 * @description Method to select the address other than default or the already select address
	 * @param 
	 * @return boolean
	 * 
	 */	
	public boolean selectShippingtoAddressApartfromDefaultaddress() throws Exception{
		String address = getFirstSelectedOptionFromShippingtoDrpDown();
		Boolean flag = false;
		Select select = new Select(shippingToDropdown);
		if(select.getOptions().size()>1) {
			for (int i =0;i<select.getOptions().size();i++) {
				if(!(select.getOptions().get(i).getText().equals(address))) {
					select.selectByVisibleText(select.getOptions().get(i).getText());
					flag = true;
					break;
				}	
			}				
		}
		return flag;			
	}

	/**
	 * @name isDisplayedUnavailabesection
	 * @description Method to verify presence of unavailable items section.
	 * @param 
	 * @return 
	 * 
	 */	
	public boolean isProductUnavailableMessageDisplayed(){
		return productUnavailableMessage.isDisplayed();
	}

	/**
	 * @return the Cart subtotal displayed in the Shopping cart page
	 * @throws Exception
	 */
	public String getCartSubtotal() throws Exception {
		WaitTool.hardWait();
		System.out.println("cart subtotal" +cartTotalAmountText.getText());
		return cartTotalAmountText.getText();			
	}

	/**
	 * @return the Items count in shopping cart page
	 * @throws Exception
	 */
	public String getItemsCountFromCart() throws Exception {
		List<WebElement> allItems = driver.findElements(By.xpath(xpath));	
		System.out.println("Items count in cart"+allItems.size());
		return Integer.toString(allItems.size());
	}

	public void clickMiniCartViewCartButton() throws InterruptedException {
		WaitTool.waitForElement(driver, modalViewCartButton);
		modalViewCartButton.click();
		WaitTool.waitFor(driver,true) ;
		//	return new SubCategoryAppliancesPage(driver);

	}

	// Method to Remove the Cart is shopping cart page.
	public List<WebElement> getMiniCartRemoveButton() throws InterruptedException {
		return miniCartRemoveButton;
	}

	// Method to Click on checkout in Modal	
	public void clickPopupCloseButton() throws InterruptedException {
		WaitTool.waitForElement(driver, popupCloseButton);
		popupCloseButton.click();
		WaitTool.waitFor(driver,true) ;
	}


	public Boolean isDefaultShippingAddressDisplayed()
	{
		CommonFunctions.scrolltoViewElement(defaultShippingAddress, driver);
		return defaultShippingAddress.isDisplayed();
	}

	public Boolean isDeliveryMessageDisplayed()
	{
		return deliveryMessage.isDisplayed();
	}

	//Method to check whether the Shopping Cart is empty or not
	public Boolean isShoppingCartEmptyMessageDisplayed()
	{

		try{
			return shoppingCartEmptyMessage.isDisplayed();
		}
		catch(Exception e){
			System.out.println("Cart is not Empty");
			return false;
		}

	}

	public Boolean isDisplayedSourceCode()
	{
		try{
			return sourceCode.isDisplayed();
		}
		catch(Exception e){
			System.out.println("Source Code is not Displayed");
			return false;
		}

	}

	public LoginPage clickOnHDSupplyLogo()
	{
		hDSupplyLogoInHeader.click();
		return new LoginPage(driver);

	}

	public HomePage clickOnHDSupplyLogoInHeader() throws Exception
	{
		CommonFunctions.scrolltoViewElement(hDSupplyLogoInHeader, driver);
		WaitTool.hardWait2sec();
		hDSupplyLogoInHeader.click();
		System.out.println("waited and clicked on clickOnHDSupplyLogoInHeader");
		return new HomePage(driver);
		
	}

	public HomePage clickOnContinueShoppingBreadCrumbLink() throws Exception
	{
		CommonFunctions.scrolltoViewElement(continueShoppingBreadCrumbLink, driver);
		WaitTool.hardWait();
		System.out.println("waited for continueShoppingBreadCrumbLink");
		continueShoppingBreadCrumbLink.click();
		return new HomePage(driver);	
	}


	public int displyedPartNumberText()
	{
		return partNumberDisplayed.size();
	}

	public int displayedQuantityStepperText()
	{
		return quantityStepperDisplayed.size();
	}

	public int displayedProductPriceText()
	{
		return productPriceDisplayed.size();
	}

	public int isAddToQuoteButtonDisplayed()
	{
		return addToQuoteButtonDisplayed.size();
	}

	public int isAddToListButtonDisplayed()
	{
		return addToListButtonDisplayed.size();
	}

	public void insertSourceCode()
	{
		String sourceCode = CommonFunctions.getRandomNumber();
		enterSourceCode.clear();
		enterSourceCode.sendKeys(sourceCode);  
	}

	public void clickOnAddNewAddressLink()
	{
		addNewAddressLink.click();
	}

	public Boolean isAddNewAddressModalWindowDisplayed()
	{
		CommonFunctions.scrolltoViewElement(addNewAddressModalWindow, driver);
		return addNewAddressModalWindow.isDisplayed();
	}

	public void clearAllFieldsinAddressBook()
	{
		shippingAddressNameTextBox.clear();
		addressTextBox.clear();
		//floorOrSuiteTextBox.clear();
		cityTextBox.clear();
		CommonFunctions.selectDropdown(stateDropdown, "Select a State");
		zipCodeTextBox.clear();
		phoneNumberTextBox.clear();
		companyPropertyNameTextBox.clear();
	}

	public void createNewAddress(String shippingAddress,String cpname, String address,String city, String state,String zipcode,String phnumber) throws Exception
	{
		phnumber = phnumber.replace("'", "");
		zipcode = zipcode.replace("'", "");
		shippingAddressNameTextBox.sendKeys(shippingAddress);
		addressTextBox.sendKeys(address);
		cityTextBox.sendKeys(city);
		zipCodeTextBox.sendKeys(zipcode);
		CommonFunctions.selectDropdown(stateDropdown, state);
		phoneNumberTextBox.sendKeys(phnumber);
		companyPropertyNameTextBox.sendKeys(cpname);
		WaitTool.hardWait();
		CommonFunctions.scrolltoViewElement(createNewAddressButton, driver);
		createNewAddressButton.click();
	}

	public String getUnavailableMessage(){
		System.out.println(unavailablePartNumber.getText());
		return unavailablePartNumber.getText();
	}

	public SubCategoryAppliancesPage clickModalViewCartButton() throws InterruptedException {
		WaitTool.waitForElement(driver, modalViewCartButton);
		modalViewCartButton.click();
		WaitTool.waitFor(driver,true) ;
		return new SubCategoryAppliancesPage(driver);

	}

	/**
	 * @name getShoppingCartPaymentText
	 * @description Method to verify presence of shipping address below checkout.
	 */	
	public String getShoppingCartPaymentText(){
		//System.out.println(shippingToDropdown.getText());
		return shoppingCartPaymentText.getText().trim() ;	
	}

	/**
	 * click on Secure To Order Button
	 * 
	 */
	public void clickSecureToOrderButton() {
		secureToOrderButton.click();
		WaitTool.waitFor(driver, true);
	}

	public Boolean isDeliverDatesSorted()
	{
		Boolean flag = true;
		String deliveryDatesMMDDYYYY[] = new String[deliveryDates.size()];
		String deliveryDatesDD[] = new String[deliveryDates.size()];
		String deliveryDatesMM[] = new String[deliveryDates.size()];
		String deliveryDatesYYYY[] = new String[deliveryDates.size()];
		String deliveryDatesYYYYMMDD[] = new String[deliveryDates.size()];
		int deliveryDatesIntYYYYMMDD[] = new int[deliveryDates.size()];
		for(WebElement deliveryDate : deliveryDates)
		{
			int i=0;
			int j=0;
			deliveryDatesMMDDYYYY[i]=deliveryDate.getText();
			deliveryDatesMMDDYYYY[i]=deliveryDatesMMDDYYYY[i].replace("/", "");

			deliveryDatesDD[i]= deliveryDatesMMDDYYYY[i].substring(2, 4);

			deliveryDatesMM[i]= deliveryDatesMMDDYYYY[i].substring(0, 2);

			deliveryDatesYYYY[i]= deliveryDatesMMDDYYYY[i].substring(4, 8);

			deliveryDatesYYYYMMDD[i] = deliveryDatesYYYY[i]+deliveryDatesMM[i]+deliveryDatesDD[i];
			System.out.println("deliveryDatesYYYYMMDD is-----------------" + deliveryDatesYYYYMMDD[i]);

			deliveryDatesIntYYYYMMDD[j]=(int)Integer.parseInt(deliveryDatesYYYYMMDD[i]);
			System.out.println("converted to integer" + deliveryDatesIntYYYYMMDD[j]);
			j++;
			i++;
		}

		System.out.println("deliveryDatesIntYYYYMMDD.length issssssss"+ deliveryDatesIntYYYYMMDD.length);

		for(int j=0; j<deliveryDatesIntYYYYMMDD.length;j++)
		{

			System.out.println("deliveryDatesIntYYYYMMDD "+ j +" " + deliveryDatesIntYYYYMMDD[j]);
			/*if (deliveryDatesIntYYYYMMDD[j] < deliveryDatesIntYYYYMMDD[j+1]) 
			{
				System.out.println("flag value is still true");
			} 
			else 
			{
				System.out.println("flag value is now false");
				flag=false;
				break;
			}*/
		}
		return flag;
	}

	public Boolean isAddToQuoteModalDisplayed()
	{
		return addToQuoteModal.isDisplayed();
	}

	public void clickFirstExistingQuote()
	{
		firstExistingQuote.click();
	}

	public void clickAddToQuoteButtonOnQuoteModal()
	{
		addToQuoteButtonOnQuoteModal.click();
	}

	public void clickCloseButtonOnAddToQuoteSuccessMessage()
	{
		closeButtonOnAddToQuoteSuccessMessage.click();
	}

	public Boolean isSuccessMessageAfterAddToQuoteDisplayed()
	{
		return successMessageAfterAddToQuote.isDisplayed();
	}


	public Boolean areThreeCheckOutButtonsDisplayed()
	{
		Boolean flag;
		if(checkOutButtons.size()==3)
		{
			flag=true;
		}
		else
		{
			flag=false;
		}
		return flag;
	}


	public Boolean isReturnPolicyTextDisplayed()
	{
		return returnPolicyText.isDisplayed();
	}

	public QuickOrderPad clickOnQuickOrderLink() 
	{
		//WaitTool.waitVisibility(driver, headerQuickOrderLinkText, 5);
		WebDriverWait wait = new WebDriverWait(driver, 15000);
		wait.until(ExpectedConditions.visibilityOf((headerQuickOrderLinkText)));
		headerQuickOrderLinkText.click();
		return new QuickOrderPad(driver);		
	}

	/*List<WebElement> addToListButton = driver.findElements(By.xpath(xpath + removebtn));
	while(addToListButton.size()>0) {
		addToListButton.get(0).click();
		Thread.sleep(10000);
		closeSuccessOrErrorMessagePopup.click();
		addToListButton = driver.findElements(By.xpath(xpath + removebtn));
	}*/

	/**
	 * click on Add to List button
	 */
	public void clickAddToListButton() {
		addToListButton.click();
	}

	/**
	 * @return product name displayed as Title on Add to list modal window
	 */
	public String getAddToListModalTitleText() {
		return addToListModalTitleText.getText();
	}

	/**
	 * @return product name displayed on Product details page
	 */
	public String getProductNameText() {
		return productNameText.getText();
	}

	/**
	 * @return Add to Existing Or Create New List title text
	 * @throws Exception 
	 */
	public Boolean isAddToExistingOrCreateNewListTitleTextDisplayed() throws Exception {
		/*WebDriverWait wait = new WebDriverWait(driver, 5000);
		wait.until(ExpectedConditions.visibilityOf((addToExistingOrCreateNewListText)));*/
		Thread.sleep(10000);
		return addToExistingOrCreateNewListText.isDisplayed();
	}

	/**
	 * @return true if New Tab is displayed in Add to List Modal otherwise false
	 */
	public boolean isDisplayedExistingOrNewTabsOnAddToListModal() {
		return addToListExistingTab.isDisplayed() && addToListNewTab.isDisplayed();

	}

	/**
	 * @return true if Existing tab is selected by default for user having previously saved lists otherwise New tab should be selected by default
	 */
	public boolean isDisplayedDefaultTabSelectedCorrectly() {
		System.out.println("default tab "+defaultTabselected.getText() );
		return ((defaultTabselected.getText().equalsIgnoreCase("Existing") && CommonFunctions.isElementPresent(firstSavedListText)));
	}


	public void clickCreateOrEditSavedList() throws InterruptedException{
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 5000);
		wait.until(ExpectedConditions.visibilityOf((createOrEditSavedListButton)));
		CommonFunctions.scrolltoViewElement(createOrEditSavedListButton, driver);
		CommonFunctions.mouseHover(driver, createOrEditSavedListButton);
		createOrEditSavedListButton.click();
	}

	/**
	 * Add product item to New List
	 * @throws Exception 
	 */
	public String addItemToNewList(String newListName) throws Exception {
		Thread.sleep(3000);
		addToListNewTab.click();
		String random = CommonFunctions.getRandomString(4);
		newListName = newListName + random;
		newListNameEdit.sendKeys(newListName);
		createListButton.click();
		return newListName;
	}

	/**
	 * click on My Account Saved Lists quick link
	 * @return the driver to Saved Lists Page
	 */
	public SavedListsPage clickMyAccountSavedListsQuickLink(){
		WaitTool.waitForElement(driver, myAccountSavedListsQuickLink);
		CommonFunctions.scrolltoViewElement(myAccountSavedListsQuickLink, driver);
		myAccountSavedListsQuickLink.click();
		return new SavedListsPage(driver);
	}

	public Boolean isErrorMessageTextDisplayed()
	{
		return errorMessageText.isDisplayed();
	}

	public String displayedSubtotalValue()
	{
		return displayedSubtotalValue.getText();
	}

	public String displayedShippingValuealValue()
	{
		return displayedShippingValue.getText();
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

	public ProductDetailsPage searchKeywordOrPartNumber(String keyword)
	{
		searchBox.sendKeys(keyword);
		searchButton.click();
		return new ProductDetailsPage(driver);	
	}

	public Boolean isMustBeCustomizedMessageDisplayed()
	{
		return mustBeCustomizedMessage.isDisplayed();
	}

	public Boolean isCustomizeThisItemLinkDisplayed()
	{
		return customizeThisItemLink.isDisplayed();
	}


	public Boolean isYouHaveCustomizeLinkDisplayed()
	{
		return youHaveCutomizedLink.isDisplayed();
	}


	public void clickOnCustomizeThisItemLink()
	{
		WaitTool.waitForElement(driver, customizeThisItemLink);
		CommonFunctions.scrolltoViewElement(customizeThisItemLink, driver);
		customizeThisItemLink.click();
	}


	public Boolean isPTConfiguratorModalWindowDisplayed()
	{
		WaitTool.waitForElement(driver, pTConfiguratorModalWindow);
		CommonFunctions.scrolltoViewElement(pTConfiguratorModalWindow, driver);
		return pTConfiguratorModalWindow.isDisplayed();
	}

	public ShoppingCartPage fillCustomizeItemForm(String flat,String label,String color,String style,
			String imprintLine1,String imprintLine2,String imprintLine3,String imprintLine4,
			String imprintLine5,String imprintLine6,String imprintLine7,String comments) throws Exception
	{
		System.out.println("beore switching window");
		driver.switchTo().frame("peachTreeIFrame");
		System.out.println("after switching window");
		flatOrAssembledTextBox.sendKeys(flat);
		System.out.println("values added in flatOrAssembledTextBox");
		labelFormatTextBox.sendKeys(label);
		colorTextBox.sendKeys(color);
		styleTextBox.sendKeys(style);
		imprintLine1TextBox.sendKeys(imprintLine1);
		imprintLine2TextBox.sendKeys(imprintLine2);
		imprintLine3TextBox.sendKeys(imprintLine3);
		imprintLine4TextBox.sendKeys(imprintLine4);
		imprintLine5TextBox.sendKeys(imprintLine5);
		imprintLine6TextBox.sendKeys(imprintLine6);
		imprintLine7TextBox.sendKeys(imprintLine7);
		commentsTextBox.sendKeys(comments);
		WaitTool.hardWait();
		plusCartButton.click();
		WaitTool.hardWait();

		approveButton.click();
		WaitTool.hardWait();
		return new ShoppingCartPage(driver);


	}

	public void enterUserName(String username) {
		WebDriverWait wait = new WebDriverWait(driver, 1500);
		wait.until(ExpectedConditions.visibilityOf((userNameEdit)));
		userNameEdit.clear();
		userNameEdit.sendKeys(username);
	}

	/**
	 * Enter Password
	 * @param password
	 */
	public void enterPassword(String password) {
		passwordEdit.clear();
		passwordEdit.sendKeys(password);
	}

	/**
	 * Click on Sign In button
	 * @return the driver to HomePage
	 */
	public HomePage clickSignInButton() {
		signInButton.click();
		WaitTool.waitFor(driver, true);
		return new HomePage(driver);
	}


	public ShoppingCartPage loginToHDS() throws Exception {
		String user = null;
		String[] envArray = null;
		if(prop.getProperty("testEnv").equalsIgnoreCase("remote")){
			System.out.println(" ***** Display BaseUrl from Remote :"+ baseUrl);
			envArray = baseUrl.substring(8).split("\\.");

		}else if (prop.getProperty("testEnv").equalsIgnoreCase("local")){
			System.out.println("Display URL :"+ prop.getProperty("url"));
			envArray = prop.getProperty("url").substring(8).split("\\.");
		}
		environmentValue = envArray[0];
		System.out.println("Display Environment :"+environmentValue);

		if (environmentValue.equals("qa1")){
			user = prop.getProperty("username_qa1");
		}else if (environmentValue.equals("qa2")){
			user = prop.getProperty("username_qa2");
		}else if (environmentValue.equals("dev1")){
			user = prop.getProperty("username_dev1");
		}else if (environmentValue.equals("dev2")){
			user = prop.getProperty("username_dev2");
		}else if (environmentValue.equals("dev3")){
			user = prop.getProperty("username_dev3");
		}else if (environmentValue.equals("stg")){
			user = prop.getProperty("username_stg");
		}else if (environmentValue.equals("beta")){
			user = prop.getProperty("username_beta");
		}
		System.out.println("Display Username : " + user);
		headerRegisterOrSignInLinkText.click();
		WaitTool.hardWait();
		enterUserName(user);
		WaitTool.hardWait();
		enterPassword(prop.getProperty("password"));
		WaitTool.hardWait();
		signInButton.click();
		WaitTool.hardWait();	
		return new ShoppingCartPage(driver);
	}

	public Boolean isAddToListModalWindowDisplayed()
	{
		WaitTool.waitForElement(driver, addToListModalWindow);
		CommonFunctions.scrolltoViewElement(addToListModalWindow, driver);
		return addToListModalWindow.isDisplayed();
	}

	public ShoppingCartPage createNewList(String newlist)
	{
		newListTab.click();
		sharedListRadioButton.click();
		String random = CommonFunctions.getRandomString(4);
		newlist = newlist + random;
		System.out.println("newlist is "+ newlist);
		listNameTextbox.sendKeys(newlist);
		newLsitButton.click();
		return new ShoppingCartPage(driver);

	}
}

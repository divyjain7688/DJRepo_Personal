package com.selenium.ebiz.pageobject;

import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.WaitTool;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartPage{

	private WebDriver driver;
	private WaitTool waitTool;
	private PageManager pageManager;

	public ShoppingCartPage(WebDriver driver) {
		this.driver = driver;
		this.waitTool = new WaitTool();
		PageFactory.initElements(driver, this);
		this.pageManager = new PageManager(driver);
	}
	//div[@data-hds-tag="shopping-cart__item-list-actions-partnumber"]
	@FindBy(xpath = "//*[@class='main_content']/div[2]//img")
	public WebElement bMediaBannerSCP;

	@FindBy(xpath = "//div[@data-hds-tag='shopping-cart__item-list-actions-partnumber']")
	public WebElement displayedPartNumber;

	@FindBy(xpath = "//span[@class=\"list-item__details-description\"]")
	public WebElement displayedProductDescription;
	
	@FindBy(xpath = "//div[@data-hds-tag='cart-summary__totals']/div/span[@class='type--body-x-large']")
	WebElement displayedPriceCartSummary;

	@FindBy(xpath = "//div[@class='modal__inner']")
	WebElement addToListModalWindow;

	@FindBy(xpath = "//*[@data-hds-tag='shopping-cart__item-list-actions-add-to-list-btn']")
	WebElement addToListButtonOnProductList;

	@FindBy(xpath = "//a[contains(text(),'Customize This Item')]")
	public
	WebElement customizeThisItemLink;

	@FindBy(xpath = "//*[contains(text(),'customized this item')]")
	public WebElement youHaveCutomizedLink;

	@FindBy(xpath = "//div[@id='msgpopup_content_wrapper']")
	public WebElement successMessageAfterAddToQuote;

	@FindBy(xpath = "//div[@id='msgpopup_content_wrapper']//div[@class='close_icon']")
	public WebElement closeButtonOnAddToQuoteSuccessMessage;

	@FindBy(xpath = "//button[contains(text(),'Add To Quote')]")
	public WebElement addToQuoteButtonOnQuoteModal;

	@FindBy(xpath = "//tbody[@id='addToExistingRecord']/tr[1]")
	public WebElement firstExistingQuote;

	@FindBy(xpath = "//div[@id=\"msgpopup_content_wrapper\"]/a")
	WebElement closePopup;

	@FindBy(xpath = "//*[@class='btn confirm-btn']")
	public WebElement oboEmptyCartAlert;

	@FindBy(xpath="//div[@class='shopping-cart__address type--caption']")
	WebElement defaultShippingAddress;

	@FindBy(xpath="//div[@class='content__description type--caption']")
	WebElement deliveryMessage;

	//Sign in button
	@FindBy(id = "Header_GlobalLogin_WC_AccountDisplay_links_2")
	WebElement signInButton;

	@FindBy(xpath="//div[contains(text(),'must be customized. Please click Customize This Item or call')]")
	public
	WebElement mustBeCustomizedMessage;

	@FindBy(xpath = "//div[@class='tooltip-box']//span[contains(text(),'source code')]")
	WebElement tooltipSourceCode;

	@FindBy(xpath="//input[@id='promoCode']")
	WebElement enterSourceCode;

	@FindBy(id="applyPromoCode")
	WebElement applySourceCode;

	@FindBy(xpath="//div[@class='content__description type--caption']") // /div[contains(text(),'Sorry')]")
	WebElement unavailablePartNumber;

	@FindBy(xpath="//a[text()='Add new address']")
	public WebElement addNewAddressLink;

	@FindBy(xpath="//div[@class='modal__inner']")
	WebElement addNewAddressModalWindow;

	@FindBy(xpath="//div[@class='modal__inner']//input[@name='nickName']")
	WebElement shippingAddressNameTextBox;

	@FindBy(xpath="//div[@data-hds-tag='shopping-cart__orderitem-messages-alert-box-content']")
	WebElement productFDMessage;

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

	/*@FindBy(xpath = "//div[@class='items-footer__btns']/a[@data-hds-tag='shopping-cart__item-footer-checkout-btn']")
	public WebElement shoppingCartCheckOutButton;*/

	@FindBy(xpath = "//a[@data-hds-tag='shopping-cart__item-footer-checkout-btn']")
	public WebElement checkOutButton;

	@FindBy(xpath = "//div[@id='ShopCartDisplay']/section/div/div[2]/div[2]/div[2]")
	WebElement shoppingAddressText;

	@FindBy(xpath = "//div[@id='ShopCartDisplay']//h1[contains(text(),'SHOPPING CART')]")
	public WebElement shoppingCartPageHeadingText;

	@FindBy(xpath = "//div[@class='breadcrumbs']//div/*[@class='icon icon--carat-left']")
	public WebElement continueShoppingBreadCrumbLink;

	@FindBy(xpath = "//div[@class='parts__part-row']/div/input[@id='partNumber_1']")
	WebElement quickOrderPartNumberEdit;

	@FindBy(xpath = "//section[@class='number-stepper']//input[@id='quantity_1']")
	WebElement quickOrderQuantityEdit;

	@FindBy(xpath = "//*[contains(text(),'ADD PARTS to YOUR CART')]")
	public WebElement addPartsToYourCartText;

	//label/input[@id='partNumber_1']
	//@FindBy(xpath = "//div[@class='add-parts-cart__row']//input[@id='partNumber_1']")
	//@FindBy(id = "partNumber_1" )
	@FindBy(xpath = "//input[@data-hds-tag='shopping-cart-empty__add-part__part-number']")
	public WebElement partNumberEdit;

	@FindBy(xpath="//div[@class='add-parts-cart__row']//input[@id='quantity_1']")
	//@FindBy(xpath = "//div[@data-hds-tag='shopping-cart__add-parts-number-stepper']//input[@id='quantity_1']")
	WebElement quantityEdit;

	@FindBy(xpath = "//*[@data-hds-tag='shopping-cart__item-list-actions-quantity-stepper']/input")
	List<WebElement> shoppingcartListEnterQuantity;

	@FindBy(xpath = "//*[@data-hds-tag='link-shopping-cart__item-list-actions-quantity-value']")
	WebElement updateQuantityInTheList;
	
	//@FindBy(xpath = "//div[@data-hds-tag='shopping-cart__add-parts-fields']//input[@id='partNumber_1']")
	@FindBy(xpath = "//div[@data-hds-tag='shopping-cart__add-parts-fields']/label/input[@id='cart_partNumber_1']")
	public WebElement partNumberTextBoxUnderAddPartsToYourCart;
	
	@FindBy(xpath = "//div[@class=\"shopping-cart__add-parts-btn\"]/button")
	public WebElement addButtonUnderAddPartsToYourCart;
	
	@FindBy(xpath = "//div[@data-hds-tag='shopping-cart__add-parts-number-stepper']//input[@id='quantity_1']")
	public WebElement quantityStepperUnderAddPartsToYourCart;
		
	@FindBy(xpath = "//span[text()='ADD']")
	WebElement addButton;

	@FindAll({
		@FindBy(how = How.XPATH  , using = "//div[@id='ShopCartPagingDisplay']//section[@class='shopping-cart__list-item']")
	})
	public List<WebElement> shoppingCartListItems;

	@FindBy(xpath = "//button[contains(text(),'Save as quote')]")
	public WebElement saveAsQuoteButton;

	@FindBy(xpath = "//button[@data-hds-tag='shopping-cart__item-list-actions-remove-item']")
	public List<WebElement> removebutton;

	@FindBy(xpath = "//a[@data-hds-tag='shopping-cart__item-footer-links-clearcart-btn']")
	public WebElement emptyCartLink;

	@FindBy(xpath = "//p[@class='content--empty']")
	public WebElement shoppingCartEmptyMessage;

	@FindBy(xpath = "//a[text()='VIEW SAVED QUOTES']")
	WebElement viewSavedQuotesLink;

	@FindBy(xpath = "//a[text()='RETURN POLICY']")
	WebElement returnPolicyLink;
	
	@FindBy(xpath = "//div[@data-hds-tag='shopping-cart__item-footer-links']//a[text()='RETURN POLICY']")
	WebElement returnPolicyLinkInFooter;
	
	@FindBy(xpath = "//h3[@class=\"mobile-padding-top-1em\"][contains(text(),'e developed our Return Policy to make returns as easy as possible for you')]")
	public WebElement returnPolicyMesssage;

	@FindBy(xpath = "//h1[text()='Return Policy']")
	WebElement returnPolicyText;

	@FindBy(xpath = "//div[@class='items-footer__links--top']//a[@data-hds-tag='shopping-cart__item-footer-links-scroll-to-top-btn']")
	WebElement footerTopLink;

	@FindBy(xpath = "//div[@class='shopping-cart__address type--caption']")
	public
	WebElement shipToAddressText;

	@FindBy(xpath = "//div[@class='shopping-cart__address type--caption']/div[1]")
	WebElement shipToAddressLine1Text;

	@FindBy(xpath = "//div[@class='shopping-cart__address type--caption']/div[2]")
	WebElement shipToAddressLine2Text;

	@FindBy(xpath = "//div[@class='shopping-cart__address type--caption']/div[3]")
	WebElement shipToAddressLine3Text;

	@FindBy(xpath = "//div[@class='rich-relevance__block cart_page_new_rr2']")
	public WebElement richRelevanceSection;

	@FindBy(xpath = "//div[@class='shopping-cart__shipping']//select")
	public WebElement shippingToDropdown;

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
	//@FindBy(xpath ="//*[@class='list-item__part-number']")
	public List<WebElement> partNumbersDisplayed;

	@FindBy(xpath = "//div[@data-hds-tag='shopping-cart__item-list-actions-partnumber']")
	public WebElement partNumberDisplayed_text;

	@FindBy(xpath = "//div[@class='list-item__quantity']")
	List<WebElement> quantityStepperDisplayed;

	@FindBy(xpath = "//span[@data-hds-tag='shopping-cart__item-list-actions-price-value']")
	public List<WebElement> productPriceDisplayed;

	@FindBy(xpath = "//button[contains(text(),'Add to List')]")
	List<WebElement> addToListButtonDisplayed;

	@FindBy(xpath = "//button[contains(text(),'Add to Quote')]")
	List<WebElement> addToQuoteButtonDisplayed;

	@FindBy(xpath = "//div[@id='add_to_quote_modal']")
	public WebElement addToQuoteModal;

	@FindBy(xpath = "//div[@class='quick-order__label']")
	WebElement headerQuickOrderLinkText;

	@FindBy(xpath = "html/body/div[18]//div[@class='list-add']/h2")
	WebElement addToListModalTitleText;

	@FindBy(xpath = "//a[text()='Existing']")
	public	WebElement addToListExistingTab;

	@FindBy(xpath = "//div[@class='tabs__bar']//a[contains(text(),'New')]")
	WebElement addToListNewTab;

	@FindBy(xpath = "//li[@class='list-add__list-item jq-list-add--select']/strong[text()=''+listname+'']")
	WebElement latestListCreated;

	@FindBy(xpath="//button[contains(text(),'Add to List')]")
	public WebElement addToListButton;

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

	@FindBy(xpath = "//*[@class='enter-name--list jq-list-add--input']")
	WebElement newListNameEdit;

	@FindBy(xpath = "//*[@class='btn btn--hollow jq-list-add--add']")
	WebElement addToListFromSavedListModal;

	@FindBy(xpath = "//div[@class='listCreate']//button[contains(text(),'Create List')]")
	WebElement createListButton;

	@FindBy(xpath="//div[@class='quick-info__quick-links type--body-small']//a[text()='Saved Lists']")
	WebElement myAccountSavedListsQuickLink;

	@FindBy(xpath="//span[contains(text(),'SUBTOTAL')]/../span[2]")
	public
	WebElement displayedSubtotalValue;

	@FindBy(xpath="//div[@data-hds-tag='cart-summary__shipping-charge']//span[contains(text(),'FREE')]")
	public
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

	@FindBy ( xpath = "//span[contains(text(),'Account #')]")
	public WebElement accountText;

	@FindBy(xpath = "//div[@data-hds-tag='shopping-cart__order-messages-alert-box-content']")
	public WebElement availabilityCheckAlert;

	@FindBy(xpath = "//span[@data-hds-tag='shopping-cart__item-list-actions-price-value']")
	WebElement productPrice;
	
    @FindBy(xpath = "//*[@class='type--semi-bold']//*[@data-hds-tag=\"price--strikethrough\"]")
    public WebElement strikedPriceInShopCartList;

	@FindBy(xpath = "//*[@class='type--semi-bold price--strikethrough']")
	public WebElement strikedPriceMOQPart;


	//@FindBy(xpath = "//span[@class='price--highlight'] | //div[@data-hds-tag='shopping-cart__item-list-actions-price']/div[2]/p/span")
    @FindBy(xpath = "//span[@class='price--highlight type--semi-bold'] | //div[@data-hds-tag='shopping-cart__item-list-actions-price']/div[2]/p/span")
    WebElement eachproductPrice;

    @FindBy(xpath = "//span[@data-hds-tag='shopping-cart__item-list-actions-price-value']")
	List<WebElement> productsPrice;

	@FindBy(xpath = "//img[@id='productThumbNailImage_']")
	public WebElement productImage;

	@FindBy(xpath = "//img[@id='productThumbNailImage_']")
	public
	List<WebElement> productsImages;

	@FindBy(xpath = "//button[starts-with(@id,'removeItem')]")
	List<WebElement> removeItemButtons;

	//@FindBy(xpath = "//span[@id='ErrorMessageText']")
	@FindBy(xpath = "//span[text()='The item was removed from the Current Order.']")
	WebElement removeMessage;

	@FindBy(xpath = "//div[@class='shopping-cart__address type--caption']/div[1]")
	public WebElement displayedShippingToAddress1;
	
	@FindBy(xpath = "//div[@class='shopping-cart__address type--caption']/div[2]")
	public WebElement displayedShippingToAddress2;
	
	@FindBy(xpath = "//div[@class='shopping-cart__address type--caption']/div[3]")
	public WebElement displayedShippingToAddress3;
	
	@FindBy(xpath = "//div[contains(text(),'Delivery date')]/span")
	public WebElement deliveryDateText;
	
	@FindBy(xpath = "//div[@class='shopping-cart__cart-details']")
	public WebElement cartSummarySection;
	
	@FindBy(xpath = "//div[@class='shopping-cart__cart-details']//span[text()='SUBTOTAL']")
	public WebElement subTotalInCartSummarySection;
	
	@FindBy(xpath = "//div[text()='This item is currently out of stock. Please see \"Back-order Options\" below or remove the item from your cart.']")
	public WebElement outOfOrderMessageText;
	
	@FindBy(xpath = "//div[text()='The quantity requested is not currently available.']")
	public WebElement quantityNotAvailable;
	
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
			if (pageManager.common().isElementPresent(driver.findElement(By.xpath(xpath + "["+ i +"]" + xpaths))))
				status = true;
		}
		//System.out.println(status);
		return status;
	}

	public boolean isDisplayedProductFDMessage(){
		waitTool.waitForElement(driver, productFDMessage);
		return productFDMessage.isDisplayed();
	}

	/**
	 * click on Checkout Button
	 * @return
	 * Updated by bm071260
	 * @throws Exception
	 */
	public void clickShoppingCartCheckOutButton() throws Exception {
		pageManager.common().scrolltoViewElement(checkOutButton, driver);
	//	waitTool.waitForElement(driver,checkOutButton);
		checkOutButton.click();

	}

	public void clickShoppingCartCheckOutButtonAsGuestUser() {
		pageManager.common().scrolltoViewElement(checkOutButton, driver);
		checkOutButton.click();
	}


	/**
	 * Method to click on the attribute which is passed as a parameter from the first section or the first product displayed in shopping cart.
	 * @return boolean
	 * param String attribute
	 */
	public void clickOnItemsAttributeButton(String attribute) throws Exception {
		String xpaths = selectTheAttribute(attribute);
		int i = shoppingCartListItems.size()-(shoppingCartListItems.size()-1);
		if(shoppingCartListItems.size()>0)
			driver.findElement(By.xpath(xpath + "["+ i +"]" + xpaths)).click();
		waitTool.waitFor(driver, true);
	}

	/**
	 * @name removeItemShoppingCart
	 * @description Method to remove an item from shopping cart.
	 * @return boolean
	 */
	public boolean removeItemShoppingCart() throws Exception{
		int size = shoppingCartListItems.size();
		clickOnItemsAttributeButton("remove");
		waitTool.waitFor(driver, true);
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

	/*  public boolean removeAllItemShoppingCart() throws Exception{
    int size = shoppingCartListItems.size();
    boolean flag=false;
    for (int i=1;i<=shoppingCartListItems.size();i++) {
      if(!(shoppingCartListItems.size()==size-1)){
        clickOnItemsAttributeButton("remove");
        waitTool.waitFor(driver, true);
      }else
        flag=true;
      break;
    }
    return flag;
  }*/

	/* public boolean removeAllItemShoppingCart() throws Exception{
  int size = shoppingCartListItems.size();
  boolean flag=false;
  for (int i=1;i<=shoppingCartListItems.size();i++) {
    if(!(shoppingCartListItems.size()==size-1)){
     // clickOnItemsAttributeButton("remove");

      waitTool.waitFor(driver, true);
    }else
      flag=true;
    break;
  }
  return flag;
}*/

	/*public void removeAllItemShoppingCart() throws Exception{
	   for(WebElement element:removeItemButtons){
		   refresh();
		   driver.findElements(By.xpath("//button[starts-with(@id,'removeItem')]")).get(0).getSize();
		   driver.findElements(By.xpath("//button[starts-with(@id,'removeItem')]")).get(0).getLocation();
		   driver.findElements(By.xpath("//button[starts-with(@id,'removeItem')]")).get(0).click();
		   System.out.println("Close PopUp");
		   waitTool.setImplicitWait(driver, 5);
		    //waitTool.ElementToBeClickable(driver, closePopup, 5);
		    waitTool.waitForElement(driver,closePopup);
		    .scrollUp(driver);
		    //Thread.sleep(5000);
		    //closePopup.getText();
		    closePopup.getLocation();
		    closePopup.getSize();
		    ((JavascriptExecutor)driver).executeScript("window.scrollTo(0,"+closePopup.getLocation().x+")");
		    closePopup.click();
		    //Thread.sleep(5000);

		    driver.findElements(By.xpath("//button[starts-with(@id,'removeItem')]")).get(0).click();
			   System.out.println("Close PopUp");
			    waitTool.waitForElement(driver,closePopup);
			    //Thread.sleep(5000);
			    closePopup.click();
			    Thread.sleep(5000);

	   }
	  }*/

	public void removeAllItemShoppingCart() throws Exception{
		for(WebElement element:removeItemButtons){
			driver.findElements(By.xpath("//button[starts-with(@id,'removeItem')]")).get(0).click();

			//waitTool.setImplicity(driver, 10);
			waitTool.waitForElement(driver,removeMessage);
			System.out.println("removeMessage: "+ removeMessage.isDisplayed());

			//waitTool.waitFor(driver, true);
			//driver.findElement(By.xpath("//div[text()='Close']")).getSize();
			System.out.println("Close PopUp");
			pageManager.common().mouseHover(driver, closePopup);
			pageManager.common().mouseHoverAndClick(driver, closePopup);
			refresh();


			/*	driver.findElements(By.xpath("//button[starts-with(@id,'removeItem')]")).get(0).click();
			System.out.println("Close PopUp");

			waitTool.setImplicity(driver, 10);
			waitTool.waitForElement(driver,removeMessage);
			System.out.println("removeMessage: "+ removeMessage.isDisplayed());

			waitTool.waitFor(driver, true);
			//driver.findElement(By.xpath("//div[text()='Close']")).getSize();

			.mouseHover(driver, closePopup);
			.mouseHoverAndClick(driver, closePopup);

			Thread.sleep(3000);*/

			/*driver.findElements(By.xpath("//button[starts-with(@id,'removeItem')]")).get(0).click();
			System.out.println("Close PopUp");
			waitTool.waitForElement(driver,closePopup);
			Thread.sleep(5000);
			closePopup.click();
			Thread.sleep(5000);*/


		}
	}

	/**
	 * @name isDisplayedSaveAsQuoteButton
	 * @description Method to verify presence of saveAsQuoteButton .
	 * @param
	 * @return
	 *
	 */
	/*public boolean isDisplayedSaveAsQuoteButton(){
		return .isElementPresent(saveAsQuoteButton);
	}*/

	/*public void clickOnSaveAsQuoteButton()
	{
		saveAsQuoteButton.click();
	}*/

	public QuoteListsPage clickOnViewSavedQuotesLink()
	{
		viewSavedQuotesLink.click();
		return new QuoteListsPage(driver);
	}

	/**
	 * @name isDisplayedEmptyCartLink
	 * @description Method to verify presence of emptyCartLink .
	 * @param
	 * @return
	 *
	 */
	/*public boolean isDisplayedEmptyCartLink(){
		return .isElementPresent(emptyCartLink);
	}*/

	/**
	 * @name isDisplayedViewSavedQuotesLink
	 * @description Method to verify presence of viewSavedQuotesLink .
	 * @param
	 * @return
	 *
	 */
	public boolean isDisplayedViewSavedQuotesLink(){
		return pageManager.common().isElementPresent(viewSavedQuotesLink);
	}


	/**
	 * @name isDisplayedReturnPolicyLink
	 * @description Method to verify presence of returnPolicyLink .
	 */
	public boolean isDisplayedReturnPolicyLink(){
		return pageManager.common().isElementPresent(returnPolicyLink);
	}

	public void clickOnReturnPolicyLink()
	{
		returnPolicyLink.click();
	}

	public void clickOnReturnPolicyLinkInFooter()
	{
		returnPolicyLinkInFooter.click();
		waitTool.waitForElement(driver, returnPolicyMesssage);
	}
	/**
	 * @name isDisplayedFooterTopLink
	 * @description Method to verify presence of footerTopLink .
	 */
	public boolean isDisplayedFooterTopLink(){
		return pageManager.common().isElementPresent(footerTopLink);
	}

	/**
	 * @name isDisplayedShippingAddressText
	 * @description Method to verify presence of shipping address below checkout.
	 */
	public boolean isDisplayedShippingAddressText(){
		return pageManager.common().isElementPresent(shipToAddressText);
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

	public String getFirstPartNumber(){
		pageManager.common().refresh();
		waitTool.waitForElement(driver, partNumbersDisplayed.get(0));
		System.out.println(partNumbersDisplayed.get(0).getText());
		return partNumbersDisplayed.get(0).getText();
	}

	public void clickFirstRemoveButton(){
		System.out.println("Click On Remove Button");
		removebutton.get(0).click();
		System.out.println("Close PopUp");
		waitTool.waitForElement(driver,closePopup);
		pageManager.common().scrolltoViewElement(closePopup, driver);
		pageManager.common().refresh();
	}

	/**
	 * @name isDisplayedShippingAddressText
	 * @description Method to verify presence of shipping address below checkout.
	 */
	public boolean isDisplayedShippingToDropDown(){
		//System.out.println(shippingToDropdown.getText());
		return pageManager.common().isElementPresent(shippingToDropdown);
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

	public boolean isDisplayedShoppingCartTitle() {
		//WaitTool.waitFor(driver, true);
		waitTool.waitForElement(driver, shoppingCartPageHeadingText);
		pageManager.common().scrolltoViewElement(shoppingCartPageHeadingText, driver);
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
	public void clickContinueShoppingBreadcrumbLink() {
		continueShoppingBreadCrumbLink.click();
		waitTool.waitFor(driver, true);
		// return new HomePage(driver);
	}

	/**
	 * Enter Part number
	 * @param partNumber
	 */
	public void enterPartNumber(String partNumber) {
		waitTool.waitForElement(driver,partNumberEdit);
		pageManager.common().scrolltoViewElement(partNumberEdit, driver);
		partNumberEdit.clear();
		partNumberEdit.sendKeys(partNumber);
	}

	public String getPartNumber() {
		return partNumberEdit.getAttribute("value");
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

	public void enterQuantityInTheList(String quantity, int index) {
		shoppingcartListEnterQuantity.clear();
		shoppingcartListEnterQuantity.get(index).sendKeys(quantity);
		waitTool.waitForElement(driver,updateQuantityInTheList);
		updateQuantityInTheList.click();

	}

	/**
	 * Is displayed Quantity Edit
	 */
	public boolean isDisplayedQuantity() {
		return quantityEdit.isDisplayed();
	}

	public String getQty() {
		return quantityEdit.getAttribute("value");
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


	// Method to Verify the Price Text
	public boolean isDisplayedPriceText(){
		return pageManager.common().isElementPresent(shoppingCartPriceText);
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
	public void clickShoppingCartAddToListButton() {
		shoppingCartAddToListButton.click();
		waitTool.waitFor(driver, true);
		// return new ProductDetailsPage(driver);
	}

	// Method to Verify Add To List
	public boolean isDisplayedAddToListButton(){
		return pageManager.common().isElementPresent(shoppingCartAddToListButton);
	}



	// Method to Verify Add To Quote
	public boolean isDisplayedAddToQuote(){
		return pageManager.common().isElementPresent(shoppingCartAddToQuoteButton);
	}



	// Method to Verify Remove Button
	public boolean isDisplayedRemoveButton(){
		return pageManager.common().isElementPresent(shoppingCartRemoveButton);
	}

	/**
	 * Quick Add Parts to Cart in the shopping cart page and click on Add button
	 * @param partNumber
	 * @param quantity
	 * @throws Exception
	 */
	public void addPartsToYourCart(String partNumber, String quantity) throws Exception {
		enterPartNumber(partNumber);
		waitTool.waitFor(driver,true);
		enterQuantity(quantity);
		waitTool.waitFor(driver,true);
		/*
		Added take screenshot to make driver wait the part number popup to disappear
		 */
		//clickAddButton();
		pageManager.common().scrolltoClickElement(addButton, driver);
		waitTool.waitForElement(driver,closePopup);

		closePopup.click();
		waitTool.waitFor(driver,true);
	}

	public void addPartsToYourCartAsOBOUser(String partNumber, String quantity) throws Exception {
		enterPartNumber(partNumber);
		waitTool.waitFor(driver,true);
		enterQuantity(quantity);
		waitTool.waitFor(driver,true);

		pageManager.common().scrolltoClickElement(addButton, driver);
		pageManager.common().acceptPopupMessageBox(driver);
		waitTool.waitForElement(driver,closePopup);
		closePopup.click();
		waitTool.waitFor(driver,true);

	}

	public void addDiscontinuedPartsToYourCart(String partNumber, String quantity) throws Exception {
		enterPartNumber(partNumber);
		enterQuantity(quantity);
		clickAddButton();

	}

	public String getErrorMessageText(){
		waitTool.waitForElement(driver,successOrErrorMessageText); 
		return successOrErrorMessageText.getText();
	}

	public void closePopup(){
		waitTool.waitForElement(driver,closePopup);
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
		if(emptyCartLink.isDisplayed()) {
			//emptyCartLink.click(); --Since this link not yet implemented performing below action to clear cart
			waitTool.waitForElement(driver, emptyCartLink);
			pageManager.common().scrolltoViewElement(emptyCartLink, driver);
			emptyCartLink.click();
			pageManager.common().acceptPopupMessageBox(driver);
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
	 * Removed commented lines and updated the method name from clearCartReturnHomePage
	 */
	public void clearShoppingCart(){

		//wait.until(ExpectedConditions.visibilityOf(emptyCartLink));
		waitTool.waitForElement(driver, emptyCartLink);
		pageManager.common().scrolltoViewElement(emptyCartLink, driver);
		emptyCartLink.click();
		System.out.println("Empty cart link clicked");
		waitTool.waitForAlert(driver);
		driver.switchTo().alert().accept();
		pageManager.common().refresh();

	}
	public void clearShoppingCartOBOUser(){

		//wait.until(ExpectedConditions.visibilityOf(emptyCartLink));
		waitTool.waitForElement(driver, emptyCartLink);
		pageManager.common().scrolltoViewElement(emptyCartLink, driver);
		emptyCartLink.click();
		System.out.println("Empty cart link clicked with OBO user");

		waitTool.waitForElement(driver, oboEmptyCartAlert);
		oboEmptyCartAlert.click();
		pageManager.common().refresh();
		//	.acceptPopupMessageBox(driver);
	}
	
	public String clearShoppingCartAncCancel(){

		//wait.until(ExpectedConditions.visibilityOf(emptyCartLink));
		waitTool.waitForElement(driver, emptyCartLink);
		pageManager.common().scrolltoViewElement(emptyCartLink, driver);
		emptyCartLink.click();
		String msg = driver.switchTo().alert().getText();
		driver.switchTo().alert().dismiss();
		return msg;
	}

	public void clearCartReturnsLoginPage() throws Exception {
		waitTool.waitForElement(driver, emptyCartLink);
		emptyCartLink.click();
		pageManager.common().acceptPopupMessageBox(driver);
		//  return new LoginPage(driver);
	}

	public void validateUnavailableMessage(String part) throws Exception {
		//partNumberTextBox.clear();
		int x = driver.findElements(By.id("partNumber_1")).size();
		driver.findElements(By.id("partNumber_1")).get(x-1).sendKeys(part);
		waitTool.waitForElement(driver, addButtonHeader);
		addButtonHeader.click();
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
		pageManager.common().scrolltoViewElement(footerTopLink, driver);
		footerTopLink.click();
		waitTool.waitFor(driver, true);
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
	/*public String getItemRemovedfromCartMessage(){
		//System.out.println(shippingToDropdown.getText());
		return itemRemovalTextMessage.getText();
	}*/

	public boolean isDisplayedCheckoutButton(){
		return pageManager.common().isElementPresent(checkOutButton);
	}
	/**
	 * click on empty cart link Shopping breadcrumb
	 */
	public void ClickEmptyCartLink() {
		emptyCartLink.click();
		pageManager.common().acceptPopupMessageBox(driver);
		// return new HomePage(driver);
	}

	public void ClickEmptyCartLinkAndCancel() {
		emptyCartLink.click();
		pageManager.common().cancelPopupMessageBox(driver);
	}

	public void clickonCheckOutButton() throws Exception {
		System.out.println("*******Before clicking checkout button from Shopping cart page**********");
		waitTool.waitForElement(driver, checkOutButton);
		pageManager.common().scrolltoViewElement(checkOutButton, driver);
		checkOutButton.click();
		System.out.println("*******After clicking checkout button**********");
		pageManager.common().acceptPopupIfDisplayed(driver);

	}

	/*
	 * Search By Keyword Or PartNumber
	 */

	/*public SearchPage searchByKeywordOrPartNumber(String keyword)
	{
		searchBox.sendKeys(keyword);
		searchButton.click();
		return new SearchPage(driver);
	}*/

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
		pageManager.common().scrolltoViewElement(shippingToDropdown, driver);
		Select select = new Select(shippingToDropdown);
		List<WebElement> options = select.getOptions();
		for(WebElement option : options)
		{
			System.out.println("option.gettext()"+ option.getText());
			if(option.getText().equals("Default"))
			{
				System.out.println("default selected");
				option.click();
				//	break;
			}
			break;
		}
	}

	public String getNewlyAddValueFromShippingDropdown() throws InterruptedException
	{
		String optionValue=null;
		pageManager.common().scrolltoViewElement(shippingToDropdown, driver);
		Select select = new Select(shippingToDropdown);
		List<WebElement> options = select.getOptions();
		for(WebElement option : options)
		{
			System.out.println("option.gettext()"+ option.getText());
			if(!option.getText().equals("Default"))
			{
				optionValue=option.getText();
				System.out.println("non default selected" + optionValue);
				break;
			}
		}
		return optionValue;
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
		waitTool.waitForElement(driver, displayedShippingToAddress1);
	}
	
	public void selectSpecificOptionFromShippingDropdown(String optionValue) throws InterruptedException
	{
		System.out.println("optionValue is "+ optionValue);
		waitTool.waitForElement(driver, shippingToDropdown);
		Select select = new Select(shippingToDropdown);
		select.selectByVisibleText(optionValue);
		waitTool.waitFor(driver, true);
		pageManager.common().refresh();
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
		waitTool.waitForElement(driver, cartTotalAmountText);

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
		waitTool.waitForElement(driver, modalViewCartButton);
		modalViewCartButton.click();
		waitTool.waitFor(driver,true) ;
	}

	// Method to Remove the Cart is shopping cart page.
	public List<WebElement> getMiniCartRemoveButton() throws InterruptedException {
		return miniCartRemoveButton;
	}

	// Method to Click on checkout in Modal
	public void clickPopupCloseButton() throws InterruptedException {
		waitTool.waitForElement(driver, popupCloseButton);
		popupCloseButton.click();
		waitTool.waitFor(driver,true) ;
	}

	public void refresh(){
		pageManager.common().refresh();
	}

	public Boolean isDefaultShippingAddressDisplayed()
	{

		try{
			pageManager.common().scrolltoViewElement(defaultShippingAddress, driver);
			return defaultShippingAddress.isDisplayed();
		}
		catch(Exception e){
			System.out.println("Address block is not Displayed");
			return false;
		}
	}

	public Boolean isDeliveryMessageDisplayed()
	{
		waitTool.waitForElement(driver,deliveryMessage);
		System.out.println("deliveryMessage.isDisplayed() is: " + deliveryMessage.getText());
		return deliveryMessage.isDisplayed();
	}

	//Method to check whether the Shopping Cart is empty or not
	public Boolean isShoppingCartEmptyMessageDisplayed()
	{

		try{
			waitTool.waitForElement(driver, shoppingCartEmptyMessage);

			pageManager.common().scrolltoViewElement(shoppingCartEmptyMessage, driver);
			return shoppingCartEmptyMessage.isDisplayed();
		}
		catch(Exception e){
			System.out.println("Cart is not Empty");
			return false;
		}

	}

	public Boolean isDisplayedSourceCode()
	{
		return pageManager.common().isElementPresent(tooltipSourceCode);
	}

	public Boolean isDisplayedAvailabilityCheckAlert()
	{
		try{
			return availabilityCheckAlert.isDisplayed();
		}
		catch(Exception e){
			System.out.println("Source Code is not Displayed");
			return false;
		}

	}

	/*public LoginPage clickOnHDSupplyLogo()
	{
		wait.until(ExpectedConditions.visibilityOf(hDSupplyLogoInHeader));
		//waitTool.waitForElement(driver, hDSupplyLogoInHeader);
		.scrolltoViewElement(hDSupplyLogoInHeader, driver);
		hDSupplyLogoInHeader.click();
		return new LoginPage(driver);

	}*/

	public void clickOnHDSupplyLogoInHeader() throws Exception
	{
		waitTool.waitForElement(driver,pageManager.homePage().hDSupplyLogoInHeader);
		pageManager.common().scrolltoViewElement(pageManager.homePage().hDSupplyLogoInHeader, driver);

		//	WaitTool.waitForElement(driver, hDSupplyLogoInHeader);

		pageManager.homePage().hDSupplyLogoInHeader.click();
		System.out.println("waited and clicked on clickOnHDSupplyLogoInHeader");
		//  return new HomePage(driver);

	}

	public void clickOnContinueShoppingBreadCrumbLink() throws Exception
	{

		System.out.println("waited for continueShoppingBreadCrumbLink");
		waitTool.waitForElement(driver, continueShoppingBreadCrumbLink);
		pageManager.common().scrolltoViewElement(continueShoppingBreadCrumbLink, driver);
		continueShoppingBreadCrumbLink.click();
		//  return new HomePage(driver);
	}


	public int displyedPartNumberText()
	{

		return partNumbersDisplayed.size();
	}

	public String getPartNumberText()
	{
		waitTool.waitForElement(driver, partNumberDisplayed_text);
		System.out.println("Part Number From SCP: " + partNumberDisplayed_text.getText() );
		return partNumberDisplayed_text.getText();
	}

	public int displayedQuantityStepperText()
	{
		return quantityStepperDisplayed.size();
	}

	public int displayedProductPriceText()
	{
		return productPriceDisplayed.size();
	}

	public String getProductPrice()
	{
		// System.out.println("productPrice: " + productPrice.getText());
		waitTool.waitForElement(driver,productPrice);
	//	System.out.println("Product Price From SCP: " + productPrice.getText());
		return productPrice.getText();
	}

	public String getEachProductPrice()
	{
		System.out.println("EachproductPrice: " + eachproductPrice.getText());

		return eachproductPrice.getText().substring(1, 7).trim();
	}


	public void collectionYY(){
		String[] coll = {productPrice.getText()};
		for (String l: coll){
			System.out.println("prices from collection " + l);
		}
	}
	public void getDisplayedPrices (){


		for (WebElement prices : productPriceDisplayed) {
			//productPriceDisplayed.get(0);
			System.out.println("Price is:  " + prices.getText());
		}

	}




	public void clickProductImage()
	{
		waitTool.waitForElement(driver,productImage);
		productImage.click();
	}

	public Boolean isDisplayedProductImage()
	{
		waitTool.waitForElement(driver, productImage);
		return productImage.isDisplayed();
	}


	public int isAddToQuoteButtonDisplayed()
	{
		return addToQuoteButtonDisplayed.size();
	}

	public int isAddToListButtonDisplayed()
	{
		return addToListButtonDisplayed.size();
	}

	public void insertSourceCode(String sourceCode)
	{
		//String sourceCode = .getRandomNumber();
		enterSourceCode.clear();
		enterSourceCode.sendKeys(sourceCode);
		applySourceCode.click();
		waitTool.waitForElement(driver,availabilityCheckAlert);
		availabilityCheckAlert.isDisplayed();
		driver.navigate().refresh();
	}
	
	public String insertSourceCodeValue()
	{
		String sourceCode = pageManager.common().getRandomNumber();
		enterSourceCode.clear();
		enterSourceCode.sendKeys(sourceCode);
		return sourceCode;
	}
	
	public String deletingOneCharFromString() throws InterruptedException 
	{
		enterSourceCode.sendKeys(Keys.END);
		enterSourceCode.sendKeys(Keys.BACK_SPACE);
		return enterSourceCode.getAttribute("value");
	}

	public void clickOnAddNewAddressLink()
	{
		waitTool.waitForElement(driver, addNewAddressLink);
		pageManager.common().scrolltoViewElement(addNewAddressLink, driver);
		addNewAddressLink.click();
		waitTool.waitForElement(driver, addNewAddressModalWindow);
	}
	
	public void selectStateDropdown(String state)
	{
		waitTool.waitForElement(driver, stateDropdown);
		pageManager.common().selectByVisibleTextFromDropdown(stateDropdown, state);
	}
	
	public String getTextFromStateDropdown()
	{	
		System.out.println(pageManager.common().getSelectedDropdownOption(driver, stateDropdown));
		return pageManager.common().getSelectedDropdownOption(driver, stateDropdown);
	}
	
	



	public Boolean isAddNewAddressModalWindowDisplayed()
	{
		pageManager.common().scrolltoViewElement(addNewAddressModalWindow, driver);
		return addNewAddressModalWindow.isDisplayed();
	}

	public void clearAllFieldsinAddressBook()
	{
		shippingAddressNameTextBox.clear();
		addressTextBox.clear();
		//floorOrSuiteTextBox.clear();
		cityTextBox.clear();
		pageManager.common().selectByVisibleTextFromDropdown(stateDropdown, "Select a State");
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
		pageManager.common().selectByVisibleTextFromDropdown(stateDropdown, state);
		phoneNumberTextBox.sendKeys(phnumber);
		companyPropertyNameTextBox.sendKeys(cpname);
		waitTool.waitForElement(driver, createNewAddressButton);

		pageManager.common().scrolltoViewElement(createNewAddressButton, driver);
		createNewAddressButton.click();
	}

	public void createInvalidAddress(String shippingAddress,String cpname, String address,String city, String state,String zipcode,String phnumber) throws Exception
	{
		phnumber = phnumber.replace("'", "");
		zipcode = zipcode.replace("'", "");
		waitTool.waitForElement(driver, shippingAddressNameTextBox);
		shippingAddressNameTextBox.sendKeys(shippingAddress);
		addressTextBox.sendKeys(address);
		cityTextBox.sendKeys(city);
		zipCodeTextBox.sendKeys(zipcode);
		pageManager.common().selectByVisibleTextFromDropdown(stateDropdown, state);
		phoneNumberTextBox.sendKeys(phnumber);
		companyPropertyNameTextBox.sendKeys(cpname);
		waitTool.waitForElement(driver, createNewAddressButton);
		pageManager.common().scrolltoViewElement(createNewAddressButton, driver);
		createNewAddressButton.click();
		waitTool.waitFor(driver, true);
		//waitTool.waitForElement(driver, checkOutButton);
		pageManager.common().refresh();
	}
	public String getUnavailableMessage(){
		System.out.println(unavailablePartNumber.getText());
		return unavailablePartNumber.getText();
	}

	public void clickModalViewCartButton() throws InterruptedException {
		waitTool.waitForElement(driver, modalViewCartButton);
		modalViewCartButton.click();
		waitTool.waitFor(driver,true) ;
		// return new SubCategoryAppliancesPage(driver);

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
		waitTool.waitFor(driver, true);
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

	/*public Boolean isAddToQuoteModalDisplayed()
	{
		return addToQuoteModal.isDisplayed();
	}*/

	/*public void clickFirstExistingQuote()
	{
		firstExistingQuote.click();
	}*/

	/*public void clickAddToQuoteButtonOnQuoteModal()
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
	}*/


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

	public void clickOnCheckOutButton() throws Exception {
		pageManager.common().refresh();
		clickonCheckOutButton();
	}

	public Boolean isReturnPolicyTextDisplayed()
	{
		return returnPolicyText.isDisplayed();
	}

	public void clickOnQuickOrderLink()
	{
		waitTool.waitForElement(driver,headerQuickOrderLinkText);
		pageManager.common().scrolltoViewElement(headerQuickOrderLinkText, driver);
		headerQuickOrderLinkText.click();

	}

	/**
	 * click on Add to List button
	 */
	public void clickAddToListButton() {
		waitTool.waitForElement(driver, accountText);
		waitTool.waitForElement(driver, addToListButton);
		pageManager.common().scrolltoViewElement(addToListButton, driver);
		addToListButton.click();
	}

	/**
	 * return product name displayed as Title on Add to list modal window
	 */
	public String getAddToListModalTitleText() {

		return addToListModalTitleText.getText();
	}

	/**
	 * return product name displayed on Product details page
	 */
	public String getProductNameText() {
		return productNameText.getText();
	}

	public String getCount() {
		return pageManager.homePage().miniCartCount.getText();
	}

	/**
	 * return Add to Existing Or Create New List title text
	 * throws Exception
	 */
	public Boolean isAddToExistingOrCreateNewListTitleTextDisplayed() throws Exception {

		//	WaitTool.waitForElement(driver,addToExistingOrCreateNewListText);


		//	wait.until(ExpectedConditions.visibilityOf((addToExistingOrCreateNewListText)));
		return addToExistingOrCreateNewListText.isDisplayed();
	}

	/**
	 * @return true if New Tab is displayed in Add to List Modal otherwise false
	 */
	public boolean isDisplayedExistingOrNewTabsOnAddToListModal() {
		waitTool.waitForElement(driver,addToListExistingTab);
		return addToListExistingTab.isDisplayed() && addToListNewTab.isDisplayed();

	}

	/**
	 * @return true if Existing tab is selected by default for user having previously saved lists otherwise New tab should be selected by default
	 */
	public boolean isDisplayedDefaultTabSelectedCorrectly() {
		System.out.println("default tab "+defaultTabselected.getText() );
		return ((defaultTabselected.getText().equalsIgnoreCase("Existing") && pageManager.common().isElementPresent(firstSavedListText)));
	}

	public void clickCreateOrEditSavedList() {
		waitTool.waitForElement(driver, createOrEditSavedListButton);
		System.out.println("createOrEditSavedListButton is displayed 1 :"+ createOrEditSavedListButton.isDisplayed());
		pageManager.common().scrolltoViewElement(createOrEditSavedListButton, driver);
		createOrEditSavedListButton.click();
		waitTool.waitForElement(driver,addToExistingOrCreateNewListText);
		//System.out.println("createOrEditSavedListButton is displayed 1 :"+ createOrEditSavedListButton.isDisplayed());
	}

	/*	public void addItemToExistingList(String existingListName) throws Exception {

      waitTool.waitForElement(driver, addToListExistingTab);
      addToListExistingTab.click();
      .scrolltoViewAndClickElement(driver.findElement(By.xpath("//li[@class='list-add__list-item jq-list-add--select']/strong[contains(text(),'"+existingListName+"')]")), driver);
      addToListButtonOnListPopup.click();
  }*/
	public void addItemToExistingList() throws Exception {

		waitTool.waitForElement(driver, addToListNewTab);
		addToListExistingTab.click();
		firstSavedListText.click();
		addToListFromSavedListModal.click();
	}



	/** Duplicated item
	 * click on My Account Saved Lists quick link
	 * @return the driver to Saved Lists Page
	 */
	public void clickMyAccountSavedListsQuickLink(){
		driver.navigate().refresh();
		waitTool.waitForElement(driver, myAccountSavedListsQuickLink);
		//	.scrolltoViewElement(myAccountSavedListsQuickLink, driver);

		driver.navigate().refresh();

		myAccountSavedListsQuickLink.click();
		//  return new SavedListsPage(driver);
	}

	public Boolean isErrorMessageTextDisplayed()
	{
		return errorMessageText.isDisplayed();
	}

	public String displayedSubtotalValue()
	{
		return displayedSubtotalValue.getText();
	}

	public String displayedShippingValue()
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

	public Boolean isMustBeCustomizedMessageDisplayed()
	{
		return mustBeCustomizedMessage.isDisplayed();
	}

	public Boolean isCustomizeThisItemLinkDisplayed()
	{
		waitTool.waitForElement(driver, customizeThisItemLink);
		pageManager.common().scrolltoViewElement(customizeThisItemLink, driver);
		return customizeThisItemLink.isDisplayed();
	}


	public Boolean isYouHaveCustomizeLinkDisplayed()
	{
		waitTool.waitForElement(driver, youHaveCutomizedLink);
		pageManager.common().scrolltoViewElement(youHaveCutomizedLink,driver);
		return youHaveCutomizedLink.isDisplayed();
	}


	public void clickOnCustomizeThisItemLink()
	{
		waitTool.waitForElement(driver, customizeThisItemLink);
		//.scrolltoViewElement(customizeThisItemLink, driver);
		customizeThisItemLink.click();
	}

	/**
	 * Click on Sign In button
	 * @return the driver to HomePage
	 */
	public void clickSignInButton() {
		signInButton.click();
		waitTool.waitFor(driver, true);
		//  return new HomePage(driver);
	}
	/* Duplicate
  public ShoppingCartPage loginToHdSupplySite(String username, String password)
  {
      headerRegisterOrSignInLinkText.getSize();
      headerRegisterOrSignInLinkText.click();
      waitTool.waitFor(driver, true);
      enterUserName(username);
      enterPassword(password);
      signInButton.click();
      waitTool.pageLoadDone(driver);
      return new ShoppingCartPage(driver);
  }

	 */
	public Boolean isAddToListModalWindowDisplayed()
	{
		waitTool.waitForElement(driver, addToListModalWindow);
		pageManager.common().scrolltoViewElement(addToListModalWindow, driver);
		return addToListModalWindow.isDisplayed();
	}


	public void checkClearShoppingCart() throws Exception {
		pageManager.homePage().clickOnShoppingCartIcon();

		try {
			shoppingCartEmptyMessage.isDisplayed();
			System.out.println("Cart is Empty :"+ isShoppingCartEmptyMessageDisplayed());
			//	waitTool.waitForElement(driver, shoppingCartPageHeadingText);
		} catch (Exception e) {
			clearShoppingCart();
			System.out.println("Clear the cart");
		}
	}

	public void checkClearShoppingCartOBOUser() throws Exception {
		pageManager.homePage().clickOnShoppingCartIcon();

		try {
			shoppingCartEmptyMessage.isDisplayed();
			System.out.println("Cart is Empty :"+ isShoppingCartEmptyMessageDisplayed());
			//	waitTool.waitForElement(driver, shoppingCartPageHeadingText);
		} catch (Exception e) {
			clearShoppingCartOBOUser();
			System.out.println("Clear the cart");
		}
	}





	public void checkPartsAddedToShoppingCart(String part, String qty, String UserNameTemp, String password) throws Exception {
		pageManager.homePage().clickOnShoppingCartIcon();

		//if (isShoppingCartEmptyMessageDisplayed()){
		try{
			if(checkShoppingCartEmptyMessageDisplayed()){
				//System.out.println("Cart is Empty :"+ isShoppingCartEmptyMessageDisplayed());
				waitTool.waitForElement(driver, shoppingCartPageHeadingText);
				addPartsToYourCart(part,qty);
				refresh();
				System.out.println("Before Logout");
				pageManager.loginPage().logoutOfApplication();
				System.out.println("After Logout");
				pageManager.commonLogin().LoginToHDS(UserNameTemp,password);
				System.out.println("After Login");
				pageManager.homePage().clickOnShoppingCartIcon();
			}
		}	catch(Exception e){
			System.out.println("Cart is not empty");
		}
	}

	public Boolean checkShoppingCartEmptyMessageDisplayed()
	{

		try{
			return shoppingCartEmptyMessage.isDisplayed();
		}
		catch(Exception e){
			System.out.println("Cart is not Empty");
			return false;
		}

	}


	public String getDisplayedPartNumber()
	{
		System.out.println("displayedPartNumber.getText()  "  + displayedPartNumber.getText());
		return displayedPartNumber.getText().trim();
	}



	public String getDisplayedPrice()
	{
		System.out.println("displayedPriceCartSummary.getText()  "  + displayedPriceCartSummary.getText());
		return displayedPriceCartSummary.getText();
	}

	public String getDisplayedPriceFromProductByInt(int getint)
	{
		System.out.println("displayedPriceCartSummary.getText()  "  + productPriceDisplayed.get(getint).getText());
		return productPriceDisplayed.get(0).getText();
	}


	public Boolean isAddedPartPriceIsSameInShoppingCart(String pPrice)
	{
		//pageManager = new PageManager(driver);
		Boolean flag=false;
		System.out.println("pnumber is " + pPrice);
		for(WebElement displayedPprice : productPriceDisplayed)
		{
			System.out.println("SCP displayed price: " + displayedPprice.getText());
		}

		for(WebElement displayedPprice : productPriceDisplayed)
		{
			if(displayedPprice.getText().contains(pPrice))
			{
				flag=true;
				System.out.println("flag updated to true");
				//String displayedShoppingCartProductPrice=pageManager.shoppingCartPage().getProductPrice();
				//System.out.println("price"   + displayedShoppingCartProductPrice);
				//Assert.assertEquals(pageManager.savedListsPage().getdisplayedPrice(),displayedShoppingCartProductPrice);
				// Assert.assertTrue(pageManager.shoppingCartPage().isDisplayedProductImage());

				break;
			}
		}
		return flag;
	}

	public Boolean isAddedPartDisplayedInShoppingCart(String partNumber)
	{

		waitTool.waitForElement(driver,partNumberDisplayed_text);
		Boolean flag=false;
		System.out.println("pnumber is " + partNumber);
		for(WebElement displayedPnumber : partNumbersDisplayed)
		{
			System.out.println("SCP displayedPnumber: " + displayedPnumber.getText());
		}

		for(WebElement displayedPnumber : partNumbersDisplayed)
		{
			if(displayedPnumber.getText().contains(partNumber))
			{
				flag=true;
				System.out.println("flag updated to true");
				break;
			}
		}
		return flag;
	}

	public Boolean isAddedPartRemovedFromShoppingCart(String part)
	{
		Boolean flag=true;
		System.out.println("pnumber is " + part);
		try{
			if(partNumbersDisplayed.isEmpty()){
				flag=false;
				System.out.println("flag updated to false: Part Removed");

			}else{
				for(WebElement displayedParts : partNumbersDisplayed)
				{
					System.out.println("SCP displayed parts: " + displayedParts.getText());
				}

				for(WebElement displayedParts : partNumbersDisplayed)
				{
					if(displayedParts.getText().contains(part))
					{
						flag=false;
						System.out.println("flag updated to false: Part Removed");
						break;
					}
				}
			}
		}catch (Exception e){
			System.out.println("Flag True: Failed");

		}
		return flag;
	}

	public Boolean isAddedPartsRemovedFromShoppingCart(List<String> part)
	{
		Boolean flag=false;
		System.out.println("pnumber is " + part);
		try{
			if(partNumbersDisplayed.isEmpty()){
				flag=true;
				System.out.println("flag updated to True: Parts Removed");

			}else{
				for(WebElement displayedParts : partNumbersDisplayed)
				{
					System.out.println("SCP displayed parts: " + displayedParts.getText());
				}

				for(WebElement displayedParts : partNumbersDisplayed)
				{
					if(displayedParts.getText().contains((CharSequence) part))
					{
						flag=false;
						System.out.println("flag updated to False: Part Not Removed");
						break;
					}
				}
			}
		}catch (Exception e){
			System.out.println("Flag False: Failed");

		}
		return flag;
	}


	public void checkCartEmptyOrPartsDisplayed()
	{
		try{
			shoppingCartEmptyMessage.isDisplayed();
			System.out.println("Cart is Empty : "+ isShoppingCartEmptyMessageDisplayed());
		//	waitTool.waitForElement(driver, shoppingCartPageHeadingText);

		}catch (Exception e){

			for(WebElement displayedParts : partNumbersDisplayed)
			{
				System.out.println("Cart is not Empty. " + "SCP displayed parts: " + displayedParts.getText());
			}
		}
	}


	/**
	 * Click on Sign In button
	 * @return the driver to HomePage
	 */

	/* Duplicate
	public ShoppingCartPage loginToHdSupplySite(String username, String password)
	{
		headerRegisterOrSignInLinkText.getSize();
		headerRegisterOrSignInLinkText.click();
		waitTool.waitFor(driver, true);
		enterUserName(username);
		enterPassword(password);
		signInButton.click();
		waitTool.pageLoadDone(driver);
		return new ShoppingCartPage(driver);
	}


	public Boolean isAddToListModalWindowDisplayed()
	{
		waitTool.waitForElement(driver, addToListModalWindow);
		.scrolltoViewElement(addToListModalWindow, driver);
		return addToListModalWindow.isDisplayed();
	}




	public void checkClearShoppingCart() throws Exception {
		pageManager = new PageManager(driver);
		pageManager.homePage().clickOnShoppingCartIcon();

		try {
			shoppingCartEmptyMessage.isDisplayed();
			System.out.println("Cart is Empty :"+ isShoppingCartEmptyMessageDisplayed());
			waitTool.waitForElement(driver, shoppingCartPageHeadingText);
		} catch (Exception e) {
			clearShoppingCart();
			System.out.println("Clear the cart");
		}
	}


	public String getDisplayedPartNumber()
	{
		System.out.println("displayedPartNumber.getText()  "  + displayedPartNumber.getText());
		return displayedPartNumber.getText();
	}

	public String getDisplayedPrice()
	{
		System.out.println("displayedPriceCartSummary.getText()  "  + displayedPriceCartSummary.getText());
		return displayedPriceCartSummary.getText();
	}

	public Boolean isAddedPartPriceIsSameInShoppingCart(String pnumber)
	{
		pageManager = new PageManager(driver);
		Boolean flag=false;
	    System.out.println("pnumber is " + pnumber);
		for(WebElement displayedPnumber : partNumberDisplayed)
		{
			System.out.println(displayedPnumber.getText());
		}

		for(WebElement displayedPnumber : partNumberDisplayed)
		{
			if(displayedPnumber.getText().contains(pnumber))
			{
				flag=true;
				String displayedShoppingCartProductPrice=pageManager.shoppingCartPage().getProductPrice();
				System.out.println("price"   + displayedShoppingCartProductPrice);
				Assert.assertEquals(pageManager.savedListsPage().getdisplayedPrice(),displayedShoppingCartProductPrice);
				Assert.assertTrue(pageManager.shoppingCartPage().isDisplayedProductImage());

				break;
			}
		}
		return flag;
		}

	public Boolean isAddedPartDisplayedInShoppingCart(String pnumber)
	{
		Boolean flag=false;
		System.out.println("pnumber is " + pnumber);
		for(WebElement displayedPnumber : partNumberDisplayed)
		{
			System.out.println(displayedPnumber.getText());
		}

		for(WebElement displayedPnumber : partNumberDisplayed)
		{
			if(displayedPnumber.getText().contains(pnumber))
			{
				flag=true;
				System.out.println("flag updated to true");
				break;
			}
		}
		return flag;
	}
	 */
	
	public void compareSCPPricePDPPrice() {
		for(int i=0; i<partNumbersDisplayed.size(); i++){
			String scpPrice = productPriceDisplayed.get(i).getText();
			productsImages.get(i).click();
			String pdpPrice = pageManager.productDetailsPage().getProductPrice();
			System.out.println("SCPPrice: " + scpPrice +"PDPPrice: " +  pdpPrice);
			Assert.assertEquals(scpPrice, pdpPrice);
			driver.navigate().back();
		}
		
	}
	
	public List<String> getAllPartNumbers() {
		List<String> all_SCP_partNum=new ArrayList<>();
		for(int i=0; i<partNumbersDisplayed.size(); i++){
			all_SCP_partNum.add(partNumbersDisplayed.get(i).getText().trim().substring(5));
			System.out.println(partNumbersDisplayed.get(i).getText().trim().substring(5));

		}
		return all_SCP_partNum;
	}

	public List<String> getAllProductPrice() {
		List<String> all_SCP_productPrice=new ArrayList<>();
		for(int i=0; i<productPriceDisplayed.size(); i++){
			all_SCP_productPrice.add(productPriceDisplayed.get(i).getText());
			System.out.println(productPriceDisplayed.get(i).getText());

		}
		return all_SCP_productPrice;
	}

	public boolean compareParts(List<String> list1, List<String> list2){
		return pageManager.common().comparePartsAdded(list1, list2);
	}



	/* public  boolean comparePartsAdded(List<String> OHDP, List<String> SCP){
    System.out.println("OHDP Before Sort:" + OHDP);
    System.out.println("SCP Before Sort:" + SCP);

    OHDP = new ArrayList<String>(OHDP);
    SCP = new ArrayList<String>(SCP);

    Collections.sort(OHDP);
    Collections.sort(SCP);

    System.out.println("OHDP After Sort:" + OHDP);
    System.out.println("SCP After Sort:" + SCP);

    return OHDP.equals(SCP);
  }

  public  boolean comparePrice(List<String> OHDPPrice, List<String> SCPPrice){
    System.out.println("OHDP Before Sort:" + OHDPPrice);
    System.out.println("SCP Before Sort:" + SCPPrice);

    OHDPPrice = new ArrayList<String>(OHDPPrice);
    SCPPrice = new ArrayList<String>(SCPPrice);

    Collections.sort(OHDPPrice);
    Collections.sort(SCPPrice);

    System.out.println("OHDP After Sort:" + OHDPPrice);
    System.out.println("SCP After Sort:" + SCPPrice);

    return OHDPPrice.equals(SCPPrice);
  }*/


	public boolean isBMediaBannerDisplayedInSCP(){
		waitTool.waitForElement(driver,bMediaBannerSCP);
		return bMediaBannerSCP.isDisplayed();
	}

	public String getpartNumberDisplayed()
	{
		waitTool.waitForElement(driver, partNumbersDisplayed.get(0));
		pageManager.common().scrolltoViewElement(partNumbersDisplayed.get(0), driver);
		return partNumbersDisplayed.get(0).getText();
	}

	public Boolean isRichRelevanceSectionDisplayed()
	{
		//waitTool.waitForElement(driver, richRelevanceSection);
		return richRelevanceSection.isDisplayed();
	}

	public Boolean isStrickedPriceDisplayed(){
		waitTool.waitForElement(driver, strikedPriceInShopCartList);
		return strikedPriceInShopCartList.isDisplayed();
        }

     public Boolean isStrickedMOQPartPriceDisplayed(){
		waitTool.waitForElement(driver, strikedPriceMOQPart);
		return strikedPriceMOQPart.isDisplayed();
	}



	
	public Boolean isDeliveryDateTextDisplayed()
	{
		waitTool.waitForElement(driver, deliveryDateText);
		return deliveryDateText.isDisplayed();
	}
	

	public Boolean isOutOfOrderMessageTextDisplayed()
	{
		Boolean flag=false;
		try
		{
			if(outOfOrderMessageText.isDisplayed() || quantityNotAvailable.isDisplayed())
			{
				flag=true;
			}
		}
		catch(Exception e)
		{
			System.out.println("outOfOrderMessageText or quantityNotAvailable not displayed " + e);
		}
		return flag;
	}


	public boolean isAddToListBtnAtProductListDisplayed(){
		waitTool.waitForElement(driver,addToListButtonOnProductList);
		return addToListButtonOnProductList.isDisplayed();
	}
}
   





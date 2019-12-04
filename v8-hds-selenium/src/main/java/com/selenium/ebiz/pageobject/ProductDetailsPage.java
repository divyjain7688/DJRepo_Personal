package com.selenium.ebiz.pageobject;

import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.WaitTool;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ProductDetailsPage {
	private  WebDriver driver;
	private WaitTool waitTool;
	private PageManager pageManager;

	public ProductDetailsPage(WebDriver driver)
	{
		this.driver = driver;
		this.waitTool = new WaitTool();
		PageFactory.initElements(driver, this);
		this.pageManager = new PageManager(driver);

	}
	@FindBy(xpath = "//*[@class='rich-relevance__block item_page_engage_banner2_new_rr1']")
	public WebElement bMediaBannerPDP;
	
	@FindBy(xpath = "//div[@data-hds-tag='product-detail__price']//span[@data-hds-tag='price--offerprice']")
	public WebElement displayedPrice;

	@FindBy(xpath = "//div[@data-hds-tag='product-detail__price']//span[@data-hds-tag='price--strikethrough']")
	public WebElement displayedDiscontinuedProductPrice;

	@FindBy(xpath = "//*[text()='ADDED']")
	public WebElement addedGreenButton;
	
	@FindBy(xpath = "//div[@data-hds-tag='product-detail__manufacturer-name']")
	WebElement peachTreedText;

	@FindBy(xpath = "//div[@id='message'][text()='The list name you entered already exists']")
	WebElement alreadyExistsListNameError;

	@FindBy(xpath = "//div[@data-hds-tag='product-detail__part-number']")
	WebElement displayedPartNumber;

	@FindBy(xpath = "//div[@class='cart-added']//div[@class='type--caption']")
	WebElement displayedPartNumberOnPopup;

    // Bhavani: Updated savedListsDetailPageTitle xpath for 1.16 STG Build
	//@FindBy(xpath = "//div[@class='number-stepper el--margin-right-1']//input")
	@FindBy(xpath = "//input[@data-hds-tag='product-details__quantity']")
	WebElement displayedQuantity;


	@FindBy(xpath = "//h3[text()='Add to existing or Create new list']")
	WebElement addToExistingOrCreateNewList;

	// Product details header
	@FindBy(xpath = "//h4[@class='widget-wrapper__header-text montserrat'][text()='Product Details']")
	WebElement productDetailsHeader;

	//Clearance badge under price

	@FindBy(xpath = "//*[@class='product-badge product-badge--red']")
	public WebElement clearanceBadge;

	//Limited stock badge under price

	@FindBy(xpath = "//*[text()='Limited Stock']")
	public WebElement limitedStock;

	//Product Details
	@FindBy(xpath = "//div[starts-with(@id,'container_')]/div/div/section/ul")
	WebElement productListText;

	@FindBy(xpath = "//a[text()='Quotes']")
	WebElement quotesLink;

	@FindBy(xpath = "//*[text()='SHOP PARTS']")
	public WebElement shopPartsLink;

	//Add To Cart
	//@FindBy(xpath = "//a[@id='add2CartBtn']")
	@FindBy(xpath = "//a[@data-hds-tag='product-details__add-to-cart']//span[text()='Add to cart']")
	public WebElement addToCartButton;

	//closeAddtocartSuccessPopup
	@FindBy(xpath = "//div[@class='modal__inner']//a[@class='modal__close jq-close-modal']")
	WebElement closeAddtocartSuccessPopup;
	
	@FindBy(xpath = "//div[text()='$0.00']")
	public WebElement zeroValueOnCart;
	
	@FindBy(xpath = "//*[@data-hds-tag='customize-product__PeachTree_Link']")
	public WebElement customizeButton;

	@FindBy(xpath = "//*[text()='The item has been successfully added to your current order']")
	public WebElement customizationIsSuccrssfullPopUp;

	@FindBy(xpath = "//div[text()='Close']")
	public WebElement closePeachtreeSuccessAlert;

	@FindBy(xpath = "//input[@id='newQuoteName']")
	WebElement quoteNameTextBox;

	@FindBy(xpath="//div[@class='breadcrumbs']/a")  
	WebElement breadcrumb;

	@FindBy(xpath="//div[@class='image-viewer__thumbs']")  
	WebElement productImageThumbnails;
	
	@FindBy(xpath="//div[@class='thumbnail-carousel__container']/a")  
	List<WebElement> listofproductImageThumbnails;
	
	@FindBy(xpath="//div[@class='image-viewer__zoom jq-image-viewer--zoom']")  
	public WebElement zoomedImageDisplayed;


	//@FindBy(xpath="//div[@class='product-detail__attributes type--body-small type--caps']//span[text()='Part']/..")  
	@FindBy(xpath="//div[@data-hds-tag='product-detail__part-number']")
	WebElement partNumber;
	
	@FindBy(xpath="//ul[@class='type--caption']/li")  
	public List<WebElement> productAttributesAndMaketingBullets;
	
	@FindBy(xpath="//div[@class='product-detail__description']")
	public WebElement productDescription;

	@FindBy(xpath="//span[text()='Brand']/..")  
	WebElement brandName;
	
	@FindBy(xpath="//div[@class='product-detail__notes type--body-small']//div[contains(text(),'Shipping')]/..")  
	WebElement shippingCharges;

	@FindBy(xpath="//div[@class='product-detail__notes type--body-small']//div[contains(text(),' R')]/..")  
	WebElement returns;

	@FindBy(xpath="//div[@class='product-detail__notes type--body-small']//div[contains(text(),'DAY')]/..")  
	WebElement deliveryDay;

	@FindBy(xpath="//div[@class='number-stepper']")  
	WebElement quantityStepper;

	@FindBy(xpath="//a[contains(text(),'Add to Quote')]")  
	WebElement addToQuoteButton;

	@FindBy(xpath = "//div[@class='quote-add__footer']//button[@id='createNewQuoteBtn']")
	WebElement createQuoteButton;

	@FindBy(xpath = "//div[@class='tabs__bar']//a[@class='tabs__tab jq-tabs--toggle']")
	WebElement newTab;

	@FindBy(xpath = "//div[@id='msgpopup_content_wrapper']")
	WebElement quoteSuccessPopup;

	@FindBy(xpath="//a[@id='quickCheckoutBtn']")
	public WebElement quickCheckOutButton;

	@FindBy(xpath = "//section[@data-hds-tag='product-details']/div[1]")
	public WebElement productDetailsModuleTitle;

	@FindBy(xpath="//section[@class='product-specs']")  
	WebElement productSpecification;

	@FindBy(xpath = "//div[@class='header__main']//div[@id='contentRecommendationWidget_HdsHeaderLogoESpot']")
	//@FindBy(xpath = "//div[@class='header__main']//div[@id='contentRecommendationWidget_HdsHeaderLogoESpot']")
	WebElement hDSupplyLogoInHeader;

	@FindBy(xpath = "//div[@class='quotes-add__new-input']//input[@class='jq-quote-add--input']")
	WebElement quoteNameEdit;

	@FindBy(xpath = "//div[@class='close_icon']")
	WebElement closeQuoteSuccessPopupIcon;

	@FindBy(xpath="//a[contains(text(),'Add to List')]")
	public WebElement addToListButtonAsGuest;

	@FindBy(xpath="//button[contains(text(),'Add to List')]")
	public WebElement addToListButton;

	@FindBy(xpath="//a[@id='clickableErrorMessageImg']/div[@class='close_text']")
	WebElement closeButtonOnSuccessQuoteMessage;

	@FindBy(xpath="//div[text()='WARRANTY']/../../../../../div[@class='product-resource__text']//a")
	public WebElement warrantyLink;

	@FindBy(xpath="//div[text()='SPECIFICATIONS']/../../../../..//div[@class='product-resource__text']//a")
	public WebElement specificationsLink;
	
	@FindBy(xpath="//th[text()='Packaging Dimensions']/../../..")
	public WebElement packagingDimensionsSection;
	
	@FindBy(xpath="//th[text()='Make & Model']/../../..")
	public WebElement makeAndModelSection;
	
	@FindBy(xpath="//th[text()='Specifications']/../../..")
	public WebElement specificationsSection;
	
	@FindBy(xpath="//th[text()='Product Features']/../../..")
	public WebElement productFeaturesSection;

	@FindBy(xpath="//th[text()='Certifications & Standards']/../../..")
	public WebElement certificationsAndStandardsSection;
	
	@FindBy(xpath="//td[text()='Country of Origin']")
	public WebElement countryOfOriginText;
	
	@FindBy(xpath="//td[text()='Country of Origin']/../td[2]")
	public WebElement countryOfOriginValueText;
	
	@FindBy(xpath="//td[text()='Made in the USA']")
	public WebElement madeInUSAText;

	@FindBy(xpath="//td[text()='Made in the USA']/../td[2]")
	public WebElement madeInUSAValueText;
	
	@FindBy(xpath="//div[@class='rich-relevance__block item_page_new_related_parts']")
	public WebElement richRelevanceSection;
	
	@FindBy(xpath="//h4[text()='Product Details']/../..")
	public WebElement productDetailsSection;
	
	@FindBy(xpath="//h4[text()='Related Products']/../../..")
	public WebElement relatedProductsSection;
	
	@FindBy(xpath="//div[@class='titleItems'][contains(text(),'Repair Parts')]/../../../../../div[@class='carouselWrapper']//div[@class='part-number-container']")
	public List<WebElement> repairParts;
	
	@FindBy(xpath="//th[text()='Certifications & Standards']")
	public WebElement certificationsAndStandards;
	
	@FindBy(xpath="//td[text()='Made in the USA']")
	public WebElement madeInTheUSA;
	
	@FindBy(xpath="//td[text()='GSA Approved']")
	public WebElement gsaApproved;
	
	@FindBy(css="#catalogEntryRecommendationWidget_8_14052_28954 .owl-item:nth-child(2) .link--regular")
	public WebElement relatedPartsAndAccessories128001;

	@FindBy(css="#catalogEntryRecommendationWidget_8_14052_28955 .link--regular")
	public WebElement collections128001;

	@FindBy(xpath="(//a[@id='tileViewAdd2Cart_17287']/button/span)[2]")
	public WebElement addToCartCollectionsPart128001;

	

	/**
	 * @description: Method to verify presence of  productDetailsHeader
	 * @return true if productDetailsHeader is displayed.
	 */
	public boolean isDisplayedproductDetailsHeader(){
		waitTool.waitForElement(driver, productDetailsHeader);
		pageManager.common().scrolltoViewElement(productDetailsHeader, driver);
		return pageManager.common().isElementPresent(productDetailsHeader);
	}


	/**
	 * click on Add to cart button
	 * @throws Exception 
	 */
	public void clickAddToCartButton() throws Exception {
		int displayedShoppingCartProductCountBeforeAddToCart=pageManager.homePage().getShoppingCartProductCount();
		System.out.println("displayedShoppingCartProductCountBeforeAddToCart   "+ displayedShoppingCartProductCountBeforeAddToCart);
		waitTool.waitForElement(driver, addToCartButton);
		pageManager.common().scrolltoViewElement(addToCartButton, driver);
		addToCartButton.click();
		waitTool.waitFor(driver, true);
	//	pageManager.common().scrolltoViewElement(pageManager.homePage().shoppingCartProductCount, driver);
		int displayedShoppingCartProductCountAfterAddToCart=pageManager.homePage().getShoppingCartProductCount();
		while(displayedShoppingCartProductCountAfterAddToCart==displayedShoppingCartProductCountBeforeAddToCart)
		{
			displayedShoppingCartProductCountAfterAddToCart=pageManager.homePage().getShoppingCartProductCount();
		}
		System.out.println("displayedShoppingCartProductCountAfterAddToCart is "+ displayedShoppingCartProductCountAfterAddToCart);
		Assert.assertTrue(displayedShoppingCartProductCountBeforeAddToCart<displayedShoppingCartProductCountAfterAddToCart);
	}

	public void addToCartPDP() {
		addToCartButton.click();
		waitTool.waitForElement(driver, productDetailsModuleTitle);
		waitTool.waitFor(driver,true);

	}


	public void clickOnCloseAddtocartSuccessPopup()
	{
		
		waitTool.waitForElement(driver,closeAddtocartSuccessPopup);
		closeAddtocartSuccessPopup.click();
//		wait.until(ExpectedConditions.visibilityOf(productDetailsHeader));
	}

	public void clickOnHDSupplyLogoInHeader() throws Exception
	{
		waitTool.waitForElement(driver, hDSupplyLogoInHeader);
		pageManager.common().scrolltoViewElement(hDSupplyLogoInHeader, driver);
		hDSupplyLogoInHeader.click();

	}

	public void addItemToNewQuote(String newQuoteName) throws Exception {
		waitTool.waitForElement(driver, addToQuoteButton);
		addToQuoteButton.click();
		String random = pageManager.common().getRandomString(4);
		newQuoteName = newQuoteName + random;
		System.out.println("newQuoteName is"+newQuoteName  );
		quoteNameEdit.sendKeys(newQuoteName);
		createQuoteButton.click();	
		waitTool.waitForElement(driver, closeButtonOnSuccessQuoteMessage);
		pageManager.common().scrolltoViewElement(closeButtonOnSuccessQuoteMessage, driver);
		closeButtonOnSuccessQuoteMessage.click();
		pageManager.common().refresh();
		waitTool.waitForElement(driver, productDetailsHeader);

	}


	public Boolean isBreadcrumbDisplayed()
	{
		return breadcrumb.isDisplayed();
	}

	public Boolean clickOnBreadcrumb()
	{
		return breadcrumb.isDisplayed();
	}
	
	public Boolean isImageThumbnailsDisplayed()
	{
		return productImageThumbnails.isDisplayed();
	}

	public Boolean isProductNameDisplayed()
	{
		return productDescription.isDisplayed();
	}

	public Boolean isPartNumberDisplayed()
	{
		return partNumber.isDisplayed();
	}

	public String getPartNumber()
	{
		waitTool.waitForElement(driver, partNumber);
		return partNumber.getText().trim().substring(5);
	}

	public Boolean isShippingChargesDisplayed()
	{
		return shippingCharges.isDisplayed();
	}

	public Boolean isPriceDisplayed()
	{
		return displayedPrice.isDisplayed();
	}
	public Boolean isDiscontinuedPriceDisplayed() {
		return displayedDiscontinuedProductPrice.isDisplayed();
	}
	
	public String getProductPrice()
	{
		waitTool.waitForElement(driver,displayedPrice);
		return displayedPrice.getText();
	}

	public void PageNavigateBack()
	{
		driver.navigate().back();
	}

	public Boolean isReturnsDisplayed()
	{
		return returns.isDisplayed();
	}

	public Boolean isDeliveryDayDisplayed()
	{
		return deliveryDay.isDisplayed();
	}

	public Boolean isQuantityStepperDisplayed()
	{
		return quantityStepper.isDisplayed();
	}

	public Boolean isBrandNameDisplayed()
	{
		waitTool.waitForElement(driver, brandName);
		return brandName.isDisplayed();
	}

	public Boolean isAddToCartButtonDisplayed()
	{
		return addToCartButton.isDisplayed();
	}

	public Boolean isAddToQuoteButtonDisplayed()
	{
		return addToQuoteButton.isDisplayed();
	}

	public void clickAddToQuoteButton()
	{
		waitTool.waitForElement(driver, addToQuoteButton);
		pageManager.common().scrolltoViewElement(addToQuoteButton, driver);
		addToQuoteButton.click();
	}

	public boolean isDisplayedCreateQuoteButton(){
		return createQuoteButton.isDisplayed();
	}

	public void clickCreateQuoteButton(){
		createQuoteButton.click();
	}

	public boolean isDisplayedNewTab(){
		return newTab.isDisplayed();
	}

	public void enterQuoteName(String quote){
		quoteNameEdit.sendKeys(quote);
	}

	public Boolean isQuickCheckOutButtonDisplayed()
	{
		return quickCheckOutButton.isDisplayed();
	}

	public void clickAddToListButton() {
		waitTool.waitForElement(driver, addToListButton);
		addToListButton.click();
	}

	public void clickAddToListButtonAsGuest() {
		waitTool.waitForElement(driver, addToListButtonAsGuest);
		addToListButtonAsGuest.click();
	}
	
	public Boolean isProductDetailsTitleDisplayed(){
		waitTool.waitForElement(driver, productDetailsModuleTitle);
		return productDetailsModuleTitle.isDisplayed();
	}

	public Boolean isProductSpecificationDisplayed()
	{
		return productSpecification.isDisplayed();
	}

	public Boolean isPeachTreedTextIdisplayed()
	{
		return peachTreedText.isDisplayed();
	}

	public Boolean isAlreadyExistsListNameErrorDisplayed()
	{
		return alreadyExistsListNameError.isDisplayed();
	}


	public void navigateToQuotesPage() throws Exception
	{
		waitTool.waitForElement(driver, quotesLink);
		pageManager.common().scrolltoViewElement(quotesLink, driver);
		quotesLink.click();

	}

	public String getDisplayedPartNumber()
	{
        waitTool.waitForElement(driver, displayedPartNumber);
		pageManager.common().scrolltoViewElement(displayedPartNumber, driver);
		System.out.println("getDisplayedPartNumber"+  displayedPartNumber.getText());
		return displayedPartNumber.getText().trim();	
	}

	public String getDisplayedQuantity()
	{
		pageManager.common().scrolltoViewElement(displayedQuantity, driver);
		System.out.println("getDisplayedQuantity"+ displayedQuantity.getAttribute("value"));
		return displayedQuantity.getAttribute("value").trim();
	}

	public void enterQuantity(String quantity){
		displayedQuantity.clear();
		displayedQuantity.sendKeys(quantity);
	}


	
	public Boolean isAddedGreenButtonDisplayed()
	{
		String button = addedGreenButton.getText();
		System.out.println("button is " + button);
        waitTool.waitForElement(driver, addedGreenButton);
		pageManager.common().scrolltoViewElement(addedGreenButton, driver);
		System.out.println("addedGreenButton");
		return addedGreenButton.isDisplayed();	
	}
	
	public String getDisplayedPrice()
	{
		System.out.println("displayedPriceCartSummary.getText()  "  + displayedPrice.getText());
		return displayedPrice.getText();
	}

    public void isCustomizeThisItemLinkDisplayed() {
		waitTool.waitForElement(driver,customizeButton);
		customizeButton.isDisplayed();
    }

	public void clickOnCustomizeThisItemLink() {
		customizeButton.click();
	}

	public boolean isDisplayedCustomizationIsSuccrssfullPopUp(){
	    waitTool.waitForElement(driver,customizationIsSuccrssfullPopUp);
		pageManager.common().scrolltoViewElement(customizationIsSuccrssfullPopUp, driver);
        System.out.println("customizationIsSuccrssfullPopUp is displayed");
        return customizationIsSuccrssfullPopUp.isDisplayed();

	}

    public void closeCustomizationIsSuccrssfullPopUp() {
        closePeachtreeSuccessAlert.click();
        System.out.println("Close alert");
    }

	public boolean isBMediaBannerDisplayedInPDP(){
		waitTool.waitForElement(driver,bMediaBannerPDP);
		return bMediaBannerPDP.isDisplayed();
	}
	
	
/*	public void test(String order) throws InterruptedException
	{
		pageManager.common().saveStringInTextFile(driver,order);
		System.out.println("test order number " + order + " to the orderNumberRecord text file");

	}
*/
	public Boolean isProductAttributesAndMaketingBulletsDisplayed()
	{
		Boolean flag=false;
	   int size = productAttributesAndMaketingBullets.size();
	   if(size>0)
	   {
		   flag=true;
	   }
	   return flag;
	}
	
	public void clickOnWarrantyLink()
	{
		String oldhandle = pageManager.common().moveToNewWindowAndGetHandle(driver);
		warrantyLink.click();
		String newhandle = pageManager.common().moveToNewWindowAndGetHandle(driver);
		Assert.assertNotEquals(oldhandle, newhandle);
		pageManager.common().closecurrentBrowser(driver);
		pageManager.common().moveToNewWindow(driver);
	}
	
	public Boolean isCountryOfOriginValueTextNotNull()
	{
		Boolean flag=false;
		if(countryOfOriginValueText.getText().equals(null))
		{
			flag=false;
		}
		else 
		{
			flag=true;
		}
		System.out.println("falg  in isCountryOfOriginValueTextNotNull is "+ flag);
		return flag;
	}
	
	public Boolean isMadeInUSAValueYesOrNo()
	{
		Boolean flag=false;
		if(madeInUSAValueText.getText().equals("Yes") || madeInUSAValueText.getText().equals("No") )
		{
			flag=true;
		}
		System.out.println("falg  in isMadeInUSAValueYesOrNo is "+ flag);
		return flag;
	}
	
	public Boolean isImageThumbnailDisplayed()
	{
		Boolean flag = false;
		if(listofproductImageThumbnails.size()>0)
		{
			flag=true;
		}
		return flag;
	}
	
	public Boolean isPDPSectionsDisplayed()
	{
	    waitTool.waitForElement(driver, productDetailsSection);
		Boolean flag = false;
		List<WebElement> elements= new ArrayList<WebElement>();
		elements.add(countryOfOriginText);
		elements.add(madeInUSAText);
		elements.add(richRelevanceSection);
		elements.add(productDetailsSection);
		elements.add(relatedProductsSection);
		for(WebElement element : elements)
		{
			if(element.isDisplayed())
			{
				flag=true;
			}
			else
			{
				flag=false;
				break;
			}
		}
		return flag;
	}
	
	
	public Boolean isPDPDescriptionButtonsPrizeDisplayed()
	{
	    waitTool.waitForElement(driver, productDescription);
	    Boolean flag = false;
		List<WebElement> elements= new ArrayList<WebElement>();
		elements.add(productDescription);
		elements.add(addToCartButton);
		elements.add(displayedPrice);
		for(WebElement element : elements)
		{
			if(element.isDisplayed())
			{
				flag=true;
			}
			else
			{
				flag=false;
				break;
			}
		}
		return flag;
	}
	
	public Boolean isCertificationsAndStandardsElementsDisplayed()
	{
	    waitTool.waitForElement(driver, certificationsAndStandards);
	    Boolean flag = false;
		List<WebElement> elements= new ArrayList<WebElement>();
		elements.add(certificationsAndStandards);
		elements.add(madeInTheUSA);
		elements.add(gsaApproved);
		for(WebElement element : elements)
		{
			if(element.isDisplayed())
			{
				flag=true;
			}
			else
			{
				flag=false;
				break;
			}
		}
		return flag;
	}
	
	
	public int isRepairPartsDisplayed()
	{
		int i=0;
		if(repairParts.size()>0)
		{
			i=repairParts.size();
		}
		else
		{
			System.out.println("repair parts not displayed");
		}
		return i;
		
	}
	
	
	public void clickOnOneRepairPart()
	{
		repairParts.get(0).click();
	}
	
	public void clickOnQuickCheckOutButton()
	{
		waitTool.waitForElement(driver, quickCheckOutButton);
		quickCheckOutButton.click();
	}
	
	public Boolean isDisplayedRelatedPartsAndAccessories128001()
	{
	   waitTool.waitForElement(driver,relatedPartsAndAccessories128001);
	pageManager.common().scrolltoViewElement(relatedPartsAndAccessories128001, driver);
	return relatedPartsAndAccessories128001.isDisplayed();
	}

	public Boolean isDisplayedcollections128001()
	{
	   waitTool.waitForElement(driver,collections128001);
	pageManager.common().scrolltoViewElement(collections128001, driver);
	return collections128001.isDisplayed();
	}

	public void clickOnAddToCartFromCollectionsPart128001() throws Exception {
	int displayedShoppingCartProductCountBeforeAddToCart=pageManager.homePage().getShoppingCartProductCount();
	System.out.println("displayedShoppingCartProductCountBeforeAddToCart   "+ displayedShoppingCartProductCountBeforeAddToCart);
	waitTool.waitForElement(driver, addToCartCollectionsPart128001);
	pageManager.common().scrolltoViewElement(addToCartCollectionsPart128001, driver);
	addToCartCollectionsPart128001.click();
	waitTool.waitFor(driver, true);

	int displayedShoppingCartProductCountAfterAddToCart=pageManager.homePage().getShoppingCartProductCount();
	while(displayedShoppingCartProductCountAfterAddToCart==displayedShoppingCartProductCountBeforeAddToCart)
	{
	displayedShoppingCartProductCountAfterAddToCart=pageManager.homePage().getShoppingCartProductCount();
	}
	System.out.println("displayedShoppingCartProductCountAfterAddToCart is "+ displayedShoppingCartProductCountAfterAddToCart);
	Assert.assertTrue(displayedShoppingCartProductCountBeforeAddToCart<displayedShoppingCartProductCountAfterAddToCart);
	}
}

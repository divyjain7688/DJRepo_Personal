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

public class ProductDetailsPage extends BaseClass{

	public ProductDetailsPage(WebDriver driver) 	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		WebDriverWait wait = new WebDriverWait(driver, 5000);
		wait.until(ExpectedConditions.visibilityOf(productDetailsHeader));

	}

	@FindBy(xpath = "//div[@data-hds-tag='product-detail__manufacturer-name']")
	WebElement peachTreedText;

	@FindBy(xpath = "//div[@id='message'][text()='The list name you entered already exists']")
	WebElement alreadyExistsListNameError;

	@FindBy(xpath = "//div[@data-hds-tag=\"product-detail__part-number\"]")
	WebElement displayedPartNumber;

	@FindBy(xpath = "//div[@class=\"cart-added\"]//div[@class=\"type--caption\"]")
	WebElement displayedPartNumberOnPopup;

	@FindBy(xpath = "//div[@class=\"number-stepper\"]//input")
	WebElement displayedQuantity;

	@FindBy(xpath = "//p[@class=\"type--caption\"]/strong")
	WebElement displayedQuantityOnPopup;


	@FindBy(xpath = "//h3[text()='Add to existing or Create new list']")
	WebElement addToExistingOrCreateNewList;

	// Product details header
	@FindBy(xpath = "//h4[@class='widget-wrapper__header-text montserrat'][text()='Product Details']")
	WebElement productDetailsHeader;
	//Product Details
	@FindBy(xpath = "//div[starts-with(@id,'container_')]/div/div/section/ul")
	WebElement productListText;

	@FindBy(xpath = "//a[text()='Quotes']")
	WebElement quotesLink;

	//Add To Cart
	@FindBy(xpath = "//a[@id='add2CartBtn']")
	WebElement addToCartButton;


	@FindBy(xpath="//div[@class='modal__inner']/a[@class='modal__close jq-close-modal']")
	WebElement closeSavedListModalWindow;

	//Add To List
	@FindBy(xpath="//button[contains(text(),'Add to List')]")
	WebElement addToListButton;

	@FindBy(xpath = "html/body/div[18]//div[@class='list-add']/div/h3")
	WebElement addToExistingOrCreateNewListText;

	@FindBy(xpath = "//div[@class='product-detail__description']/span")
	WebElement productNameText;

	@FindBy(xpath = "html/body/div[18]//div[@class='list-add']/h2")
	WebElement addToListModalTitleText;

	@FindBy(xpath = "//a[text()='Existing']")
	WebElement addToListExistingTab;


	@FindBy(xpath = "//a[text()='Existing']")
	WebElement defaultTabselected;

	@FindBy(xpath = "//ul[@class='list-add__list']/li[1]")
	WebElement firstSavedListText;


	@FindBy(xpath = "//ul[@class='list-add__list']/li[1]")
	//@FindBy(xpath = "html/body/div[18]//ul[@class='list-add__list']/li/strong[starts-with(text(),'List_')]")
	//@FindBy(xpath = "html/body/div[18]//ul[@class='list-add__list']/li/strong[starts-with(text(),'')]")
	WebElement existingFirstSavedList;

	@FindBy(xpath = "//a[text()='New']")
	WebElement addToListNewTab;

	@FindBy(xpath = "html/body/div[18]//input[@id='name']")
	WebElement newListNameEdit;

	@FindBy(xpath = "//input[@id='newQuoteName']")
	WebElement quoteNameTextBox;

	@FindBy(xpath = "//div[@class='listCreate']//button[contains(text(),'Create List')]")
	WebElement createListButton;

	@FindBy(xpath = "//button[contains(text(),'Add To List')]")
	WebElement addToListButtonOnModal;

	// Mini Shopping Cart
	@FindBy(xpath="//div[@class='main__cart']/a[@id='widget_minishopcart']")
	WebElement miniCartButton;

	// View Cart
	@FindBy(xpath="//a[@id='GotoCartButton1']")
	WebElement modalViewCartButton;

	//Minicart widget
	@FindBy(xpath="//div[@class='main__cart-info']//a[@id='widget_minishopcart'][@role='button']")  
	WebElement shoppingCartIcon;

	@FindBy(xpath="//div[@class='breadcrumbs']")  
	WebElement breadcrumb;

	@FindBy(xpath="//div[@class='image-viewer__thumbs']")  
	WebElement imageThumbnails;

	@FindBy(xpath="//div[@class='product-detail__description']/span[@class='type--body-medium']")  
	WebElement productName;

	@FindBy(xpath="//div[@class='product-detail__attributes type--body-small type--caps']//span[text()='Part']/..")  
	WebElement partNumber;

	@FindBy(xpath="//div[@class='product-detail__description']/span")  
	WebElement productDescription;


	@FindBy(xpath="//div[@class='subcat-list-tile__details']/div[1][contains(text(),'GE 24' Built-In Dishwasher White 5 Cycle 2 Option')]/../../..//button[contains(text(),'REMOVE FROM LIST')]")  
	WebElement removeFromListButtonForNewlyAddedProduct;

	@FindBy(xpath="//div[@class='product-detail__attributes type--body-small type--caps']//span[text()='Brand']/..")  
	WebElement brandName;

	@FindBy(xpath="//div[@class='product-detail__description']/div")  
	WebElement price;

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

	@FindBy(xpath="//a[contains(text(),'Quick checkout')]")  
	WebElement quickCheckOutButton;

	@FindBy(xpath="//section[@class='product-details']")  
	WebElement productDetails;

	@FindBy(xpath="//section[@class='product-specs']")  
	WebElement productSpecification;

	@FindBy(xpath = "//div[@class='header__main']//div[@id='contentRecommendationWidget_HdsHeaderLogoESpot']")
	//@FindBy(xpath = "//div[@class='header__main']//div[@id='contentRecommendationWidget_HdsHeaderLogoESpot']")
	WebElement hDSupplyLogoInHeader;

	@FindBy(xpath = "//div[@class='quotes-add__new-input']//input[@class='jq-quote-add--input']")
	WebElement quoteNameEdit;

	@FindBy(xpath = "//div[@class='close_icon']")
	WebElement closeQuoteSuccessPopupIcon;

	@FindBy(xpath="//input[@id='SimpleSearchForm_SearchTerm']")
	WebElement searchBox;

	@FindBy(xpath="//a[@id='clickableErrorMessageImg']/div[@class='close_text']")
	WebElement closeButtonOnSuccessQuoteMessage;

	// Searchbox button
	@FindBy(xpath="//*[@id='searchBox']/a/*[name()='svg']/*[name()='g']/*[name()='circle']")
	WebElement searchButton;

	public ShoppingCartPage clickOnShoppingCartIcon() throws Exception {
		WaitTool.hardWait();
		shoppingCartIcon.click();
		return new ShoppingCartPage(driver);
	}

	public WebElement getShoppingCartIconWebElement(){
		return shoppingCartIcon;
	}

	/**
	 * @description: Method to verify presence of  productDetailsHeader
	 * @return true if productDetailsHeader is displayed.
	 */
	public boolean isDisplayedproductDetailsHeader(){
		return CommonFunctions.isElementPresent(productDetailsHeader);
	}

	public boolean isDisplayedProductListText(){
		return CommonFunctions.isElementPresent(productListText);
	}
	/**
	 * click on Add to cart button
	 * @throws Exception 
	 */
	public void clickAddToCartButton() throws Exception {
		WaitTool.waitForElement(driver, addToCartButton);
		addToCartButton.click();
		//WaitTool.waitFor(driver, true);

	}

	//closeAddtocartSuccessPopup
	@FindBy(xpath = "//div[@class='modal__inner']//a[@class='modal__close jq-close-modal']")
	WebElement closeAddtocartSuccessPopup;


	/**Method to close the success pop up of add to cart.
	 * @return to homepage.
	 */
	public HomePage clickcloseAddtocartSuccessPopup() {
		closeAddtocartSuccessPopup.click();
		WaitTool.waitFor(driver, true);
		return new HomePage(driver);

	}

	public void clickOnCloseAddtocartSuccessPopup()
	{
		WaitTool.waitForElement(driver, closeAddtocartSuccessPopup);
		closeAddtocartSuccessPopup.click();
		WaitTool.waitForElement(driver, productDetailsHeader);
	}

	public HomePage clickOnHDSupplyLogoInHeader() throws Exception
	{
		WaitTool.hardWait();
		WaitTool.waitForElement(driver, hDSupplyLogoInHeader);
		CommonFunctions.scrolltoViewElement(hDSupplyLogoInHeader, driver);
		System.out.println("before clicking");
		hDSupplyLogoInHeader.click();
		return new HomePage(driver);
	}

	public LoginPage clickOnHDSupplyLogoInHeaderAsGuestUser()
	{
		hDSupplyLogoInHeader.click();
		return new LoginPage(driver);
	}

	/**
	 * click on Add to List button
	 */
	public void clickAddToListButton() {
        WaitTool.waitForElement(driver, addToListButton);
		addToListButton.click();
	}

	/**
	 * @return Add to Existing Or Create New List title text
	 */
	public Boolean isAddToExistingOrCreateNewListTitleTextDisplayed() {
		return addToExistingOrCreateNewListText.isDisplayed();
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

	/**
	 * Add product item to New List
	 */
	public String addItemToNewList(String newListName) {
		WaitTool.waitForElement(driver, addToListNewTab);
		CommonFunctions.scrolltoViewElement(addToListNewTab, driver);
		addToListNewTab.click();
		String random = CommonFunctions.getRandomString(4);
		newListName = newListName + random;
		newListNameEdit.sendKeys(newListName);
		createListButton.click();
        WaitTool.waitForElement(driver, productDetailsHeader);
		return newListName;
	}

	public void addItemToNewQuote(String newQuoteName) throws Exception {
		
		addToListNewTab.click();
		String random = CommonFunctions.getRandomString(4);
		newQuoteName = newQuoteName + random;
		System.out.println("newQuoteName is"+newQuoteName  );
		quoteNameEdit.sendKeys(newQuoteName);
		createQuoteButton.click();	
		WaitTool.waitForElement(driver, closeButtonOnSuccessQuoteMessage);
		CommonFunctions.scrolltoViewElement(closeButtonOnSuccessQuoteMessage, driver);
		closeButtonOnSuccessQuoteMessage.click();
		/*WaitTool.hardWait();
		CommonFunctions.refresh(driver);
		WaitTool.hardWait();*/
		CommonFunctions.refresh(driver);
		WaitTool.waitForElement(driver, productDetailsHeader);

	}

	public void addItemToNewListWithSameName(String newListName) {
		addToListNewTab.click();
		newListNameEdit.sendKeys(newListName);
		createListButton.click();
	}

	public void closeSavedListModalWindow()
	{
		closeSavedListModalWindow.click();

	}
	/**
	 * Add product item to existing List
	 */
	public void addItemToExistingList() {
		addToListExistingTab.click();
		existingFirstSavedList.click();
		addToListButtonOnModal.click();
	}


	// Method to Click on Shopping Cart	
	public void clickMiniCartButton() throws InterruptedException {
		WaitTool.waitForElement(driver, miniCartButton);
		miniCartButton.click();
		WaitTool.waitFor(driver,true) ;

	}

	public void clickMiniCartViewCartButton() throws InterruptedException {
		WaitTool.waitForElement(driver, modalViewCartButton);
		modalViewCartButton.click();
		WaitTool.waitFor(driver,true);
	}

	public Boolean isDisplayedAddToCartSuccessPopup()
	{
		WaitTool.waitForElement(driver, closeAddtocartSuccessPopup);
		return closeAddtocartSuccessPopup.isDisplayed();
	}

	public void refreshPage() throws Exception
	{
		CommonFunctions.refresh(driver);
		WaitTool.hardWait();
	}

	public Boolean isBreadcrumbDisplayed()
	{
		return breadcrumb.isDisplayed();
	}

	public Boolean isImageThumbnailsDisplayed()
	{
		return imageThumbnails.isDisplayed();
	}

	public Boolean isProductNameDisplayed()
	{
		return productName.isDisplayed();
	}

	public Boolean isPartNumberDisplayed()
	{
		return partNumber.isDisplayed();
	}

	public String getPartNumber()
	{
		return partNumber.getText();
	}

	public Boolean isShippingChargesDisplayed()
	{
		return shippingCharges.isDisplayed();
	}

	public Boolean isPriceDisplayed()
	{
		return price.isDisplayed();
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
		WaitTool.waitForElement(driver, addToQuoteButton);
		CommonFunctions.scrolltoViewElement(addToQuoteButton, driver);
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

	public void clickNewTab(){
		newTab.click();
	}

	public void enterQuoteName(String quote){
		quoteNameEdit.sendKeys(quote);
	}

	public Boolean isQuickCheckOutButtonDisplayed()
	{
		return quickCheckOutButton.isDisplayed();
	}

	public Boolean isAddToLisButtonDisplayed()
	{
		return addToListButton.isDisplayed();
	}

	public Boolean isProductDescriptionDisplayed()
	{
		return productDetails.isDisplayed();
	}

	public Boolean isProductSpecificationDisplayed()
	{
		return productSpecification.isDisplayed();
	}

	public Boolean isPeachTreedTextIdisplayed()
	{
		return peachTreedText.isDisplayed();
	}

	public Boolean isDisplayedQuoteSuccessPopup()
	{
		return quoteSuccessPopup.isDisplayed();
	}

	public Boolean isAlreadyExistsListNameErrorDisplayed()
	{
		return alreadyExistsListNameError.isDisplayed();
	}


	public void clickCloseQuoteSuccessPopupIcon(){
		closeQuoteSuccessPopupIcon.click();
		//return new HomePage(driver);
	}

	public String getProductDescription()
	{
		return productDescription.getText();
	}

	public SearchPage searchByKeywordOrPartNumber(String keyword)
	{
		WaitTool.waitForElement(driver, searchBox);
		searchBox.sendKeys(keyword);
		searchButton.click();
		return new SearchPage(driver);		
	}

	public QuotesPage navigateToQuotesPage() throws Exception
	{
		WaitTool.waitForElement(driver, quotesLink);
		CommonFunctions.scrolltoViewElement(quotesLink, driver);
		quotesLink.click();
		return new QuotesPage(driver);
	}

	public String getDisplayedPartNumber()
	{
        WaitTool.waitForElement(driver, displayedPartNumber);
		CommonFunctions.scrolltoViewElement(displayedPartNumber, driver);
		System.out.println("getDisplayedPartNumber"+  displayedPartNumber.getText());
		return displayedPartNumber.getText().trim();	
	}

	public String getDisplayedQuantity()
	{
		CommonFunctions.scrolltoViewElement(displayedQuantity, driver);
		System.out.println("getDisplayedQuantity"+ displayedQuantity.getAttribute("value"));
		return displayedQuantity.getAttribute("value").trim();
	}

	public String getDisplayedPartNumberFromPopup()
	{
        WaitTool.waitForElement(driver, displayedPartNumberOnPopup);
		CommonFunctions.scrolltoViewElement(displayedPartNumberOnPopup, driver);
		System.out.println("getDisplayedPartNumberFromPopup" +  displayedPartNumberOnPopup.getText());
		return displayedPartNumberOnPopup.getText();	
	}

	public String getDisplayedQuantityFromPopup()
	{		
		CommonFunctions.scrolltoViewElement(displayedQuantityOnPopup, driver);
		System.out.println("getDisplayedQuantityFromPopup"+ displayedQuantityOnPopup.getText() /*getAttribute("value")*/);
		return displayedQuantityOnPopup.getText().trim();
	}


}

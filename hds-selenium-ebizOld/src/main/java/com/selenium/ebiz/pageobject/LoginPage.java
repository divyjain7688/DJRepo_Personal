/**
 * @author Bhavani Manthri <Bhavani.Manthri@hdsupply.com>
 */

package com.selenium.ebiz.pageobject;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.selenium.ebiz.baseclass.BaseClass;
import com.selenium.ebiz.tools.CommonFunctions;
import com.selenium.ebiz.tools.WaitTool;

public class LoginPage extends BaseClass{

	WebDriver driver;
	int i;
	
	
	public LoginPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		WebDriverWait wait = new WebDriverWait(driver, 15000);
		wait.until(ExpectedConditions.visibilityOf((headerRegisterOrSignInLinkText)));
	}
	
	//  Home in BreadCrumbs
	@FindBy(xpath = "//div[@data-hds-tag='breadcrumbs']//a[contains(text(),'Home')]")
	WebElement breadCrumbHomeLinkText;
	
	// Shop by Category L1
	@FindBy(xpath="//nav[@class='flyout-nav flyout-nav--dynamic flyout-nav--visible']")
	WebElement flyoutShopByCategoryL1Image;

	// Shop by Category L2
	@FindBy(xpath="//nav[@class='flyout-nav flyout-nav--dynamic flyout-nav--visible']//li[@class='flyout-nav__li--selected']/div")
	WebElement flyoutShopByCategoryL2Image;

	// Shop by Category L3
	@FindBy(xpath="//nav[@class='flyout-nav flyout-nav--dynamic flyout-nav--visible']//li[@class='flyout-nav__li--selected']//li[@class='flyout-nav__li--selected']/div")
	WebElement flyoutShopByCategoryL3Image;
	
	@FindBy(id = "suggestedProductsHeader")
	WebElement searchSuggestedProductsHeader;

	@FindBy(linkText = "Cabinets & Countertops")
	WebElement categoryCabinetsCountertopsLinkText;
	
	@FindBy(xpath="//h4[@class='widget-wrapper__header-text montserrat']")
	WebElement orderAgainLabel;

	@FindBy(xpath = "//button[@class='btn'][text()='VIEW ORDER HISTORY']")
	WebElement viewOrderHistoryButton;

	//@FindBy(xpath = "//li[@id='autoSuggestAdvancedSearch']")
	@FindBy(xpath = "//div[@id=\"suggestedProductsResults\"]")
	WebElement searchAdvanceSearch;

	@FindBy(xpath="//strong[@class='type--caps']")
	List<WebElement> eightPartNumbersInsideOrderOnceSection;

	@FindBy(xpath="//h4[@class='widget-wrapper__header-text montserrat'][text()='Order Again']/../../..//img")
	List<WebElement> eightImagesInsideOrderOnceSection;

	@FindBy(xpath="//h4[@class='widget-wrapper__header-text montserrat'][text()='Order Again']/../../..//div[@class='product-description']")
	List<WebElement> eightProductDescriptionsInsideOrderOnceSection;

	@FindBy(xpath="//h4[@class='widget-wrapper__header-text montserrat'][text()='Order Again']/../../..//div[@class='product_price']")
	List<WebElement> eightPricesInsideOrderOnceSection;

	@FindBy(xpath="//h4[@class='widget-wrapper__header-text montserrat'][text()='Order Again']/../../..//div[@class='product-button']")
	List<WebElement> eightAddToCartButtonInsideOrderOnceSection;

	@FindBy(xpath="//div[@class='catalogEntryRecommendationWidget carousel clip-true background-false border-false']")
	WebElement fourProductVisibleAtATimeInOrderOnceSection;

	@FindBy(xpath="//h4[contains(text(),'Order Again')]/../../..//a[@class='prevPageButton']")
	WebElement backwardKeyInsideOrdereOnceSection;

	@FindBy(xpath="//h4[contains(text(),'Order Again')]/../../..//a[@class='nextPageButton']")
	WebElement forwardKeyInsideOrdereOnceSection;

	@FindBy(xpath = "//h2[@data-hds-tag='rich-relevance__block--header'][contains(text(),'Customers Who Viewed Items You Browsed Ultimately Purchased')]/../..")
	WebElement trendingProducts;

	@FindBy(xpath = "//div[@class='quick-order__label']")
	WebElement headerQuickOrderLinkText;
	//Register or signIn	
	@FindBy(id = "Header_GlobalLogin_signInQuickLink")
	WebElement registerOrSignInLinkText;

	@FindBy(xpath = "//div[@class='header__main']/preceding-sibling::div/descendant::div[@class=\'quick-info__help\']")
	WebElement headerWebsitehelpLinkText;

	@FindBy(xpath="//a[@class='btn btn--large btn--hollow header-sign-in__button--style']")
	WebElement registerForAnAccountButton;	

	@FindBy(xpath = "//*[@id='SimpleSearchForm_SearchTerm']")
	WebElement searchBoxText;
	
	@FindBy(id = "suggestedProductsResults")
	WebElement suggestedProductsResultsBlock;
	
	//  Left Nav 
	@FindBy(xpath = "//div[@class=\"left-nav\"]")
	WebElement leftNavigationImage;
	
//  Left Nav 
	@FindBy(xpath = "//div[@class=\"left-nav\"]//a[contains(text(),'Appliances')]")
	WebElement firstCategoryInleftNavigationImage;
	
	@FindBy(xpath = "//h1[contains(text(),'Appliances')]")
	WebElement appliancesText;

	@FindBy(xpath = "//div[@class='header__main']//div[@id='ci_espot__HdsHeaderLogoESpot']")
	WebElement headerHDLogoImage;

	@FindBy(xpath="//div[@class='footer-nav__footer-menu']//div[text()='ABOUT US']")
	WebElement aboutusLink;	

	@FindBy(xpath="//div[@class='footer-nav__footer-menu']//div[text()='HELP']")
	WebElement helpLink;	

	@FindBy(xpath="//div[@class='footer-nav__footer-menu']//div[text()='RETURNS']")
	WebElement returnsLink;	

	@FindBy(xpath="//div[@class='footer-nav__footer-menu']//div[text()='TERMS & POLICIES']")
	WebElement termsAndPoliciesLink;

	//Account icon
	@FindBy(xpath = "//a[@id='Header_GlobalLogin_signOutQuickLink']")
	WebElement accountIcon;

	//PromotionalContent
	@FindBy (xpath ="//div[@class ='pageControl dot']")
	WebElement promotionalContent;

	//Sign Out link
	@FindBy(xpath = "//a[@id='Header_GlobalLogin_loggedInDropdown_SignOut']/div/span[contains(text(), 'SIGN OUT')]")
	WebElement signOutLinkText;

	@FindBy(xpath = "//*[text()='Learn Something New']")
	WebElement contentWidgetLearnSomethingNewTitleText;

	@FindBy(xpath = "//div[starts-with(@id,'categoryRecommendationWidget_')]//h4")
	WebElement categoryRecommendationTitleText;

	@FindBy(xpath = "//a[starts-with(@id, 'SBN_Appliances_')]")
	WebElement CategoryApplianceLeftNavigationLinkText;

	//My Account link
	@FindBy(xpath = "//a[@id='Header_GlobalLogin_loggedInDropdown_SignOut']/div/span[contains(text(), 'ACCOUNT')]")
	WebElement accountLinkText;

	@FindBy(className = "shop-by-category__label")
	WebElement shopByCategory;

	@FindBy(className = "jq-flyout-nav--toggle")
	WebElement servicesLink;

	@FindBy(className = "jq-flyout-nav--drilldown")
	WebElement menuItem1Link;

	@FindBy(className = "jq-flyout-nav--toggle")
	WebElement resourcesLink;

	@FindBy(className= "jq-flyout-nav--toggle")
	WebElement offersLink;

	@FindBy(className = "jq-flyout-nav--toggle")
	WebElement ecatalogsLink;

	@FindBy(className = "quick-order__label")
	WebElement quickOrderLinkText;

	@FindBy(id = "SBN_Cabinets & Countertops_1_13054_148485")
	WebElement cabinetsAndCounterTopsLink;

	@FindBy(id = "SBN_Doors & Molding_1_13054_148485")
	WebElement doorsAndMolding;

	@FindBy(xpath="//span[@class='shop-by-category__label']")
	WebElement headerShopByCategoryLinkText;

	//Register or Sign in quick link
	//@FindBy(id = "Header_GlobalLogin_signInQuickLink")
	//@FindBy(xpath="//a[@id='Header_GlobalLogin_signInQuickLink']")
	@FindBy(css = "a#Header_GlobalLogin_signInQuickLink")
	WebElement headerRegisterOrSignInLinkText;

	//username
	@FindBy(id = "Header_GlobalLogin_WC_AccountDisplay_FormInput_logonId_In_Logon_1")  
	WebElement userNameEdit;

	//password
	@FindBy(id = "Header_GlobalLogin_WC_AccountDisplay_FormInput_logonPassword_In_Logon_1")     
	WebElement passwordEdit;

	//Sign in button
	@FindBy(id = "Header_GlobalLogin_WC_AccountDisplay_links_2") 
	WebElement signInButton;

	// Categories in Left Navigation
	@FindBy(linkText = "Appliances")
	WebElement categoryAppliancesLinkText;

	@FindBy (xpath= "//div[@class='footer__copyright type--white type--body-small']")
	WebElement copyrighMessage;

	@FindBy (xpath="//a[text()='Register OR Sign in']")
	WebElement signInOrRegister;

	@FindBy (xpath="//input[@name='logonId']")
	WebElement userName;

	@FindBy (xpath="//input[@name='logonPassword']")
	WebElement password;

	@FindBy (xpath="//div[@id='Header_GlobalLogin_inlinelogonErrorMessage_GL_logonPassword']//div[contains(.,'Please type a valid password')]")
	WebElement passwordErrorMessage;

	@FindBy (xpath="//div[@id='Header_GlobalLogin_inlineLogonErrorMessage_GL_logonId']/div[contains(.,'Please type a valid')]")
	WebElement userNameErrorMessage;

	//Forgot username and password
	@FindBy(id = "Header_GlobalLogin_WC_AccountDisplay_links_1")
	WebElement forgotUsernameAndPasswordLinkText;

	//Minicart widget
	@FindBy(id = "widget_minishopcart")  
	WebElement shoppingCartIcon;

	//Remember Me checkbox
	@FindBy(id = "Header_GlobalLogin_WC_AccountDisplay_div_10")
	WebElement rememberMeCheckbox;

	@FindBy(id  = "Header_GlobalLogin_logonErrorMessage_GL")
	WebElement invalidUserNameOrPasswordMessage;

	@FindBy(xpath = "//div[@id='Header_GlobalLogin_inlineLogonErrorMessage_GL_logonId']/div")
	WebElement emptyUserNameMessage;

	@FindBy(xpath = "//div[@id='Header_GlobalLogin_inlinelogonErrorMessage_GL_logonPassword']/div")
	WebElement emptyPasswordMessage;

	@FindBy(xpath="//*[@id='searchBox']/a/*[name()='svg']/*[name()='g']/*[name()='circle']")
	WebElement searchButton;

	@FindBy(xpath="//input[@id='SimpleSearchForm_SearchTerm']")
	WebElement searchBox;


	//My Account Quotes quick link in utility bar
	@FindBy(linkText = "Quotes")
	WebElement myAccountQuotesQuickLink;

	//My Account Subscriptions quick link in utility bar
	@FindBy(linkText = "Subscriptions")
	WebElement myAccountSubscriptionsQuickLink;

	//My Account Saved Lists quick link in utility bar
	@FindBy(linkText = "Saved Lists")
	WebElement myAccountSavedListsQuickLink;

	@FindAll(@FindBy(xpath= "//div[@id='suggestedProductsResults']//div[@class='list_section']//li"))
	List <WebElement> suggestedProductsResultsList;	

	//My Account Frequent Orders quick link in utility bar
	@FindBy(linkText = "Frequently Purchased")
	WebElement myAccountFrequentlyPurchasedQuickLink;

	//My Account Order History quick link in utility bar
	@FindBy(linkText = "Order History & Status")
	WebElement myAccountOrderHistoryAndStatusQuickLink;
	
	@FindBy(xpath = "//span[@class='shop-by-category__label']")
	WebElement shopByCategoryLinkText;

	@FindBy(linkText = "RESOURCES")
	WebElement headerresourcesLinkText;

	@FindBy(linkText = "OFFERS")
	WebElement headeroffersLinkText;

	@FindBy(linkText = "SERVICES")
	WebElement headerservicesLinkText;

	@FindBy(linkText = "eCATALOGS")
	WebElement headerecatalogsLinkText;

	@FindBy(linkText = "Saved Lists")
	WebElement topHeadersavedlistLinkText;

	@FindBy(linkText = "Order History & Status")
	WebElement topHeaderorderHisStatusLinkText;

	@FindBy(linkText = "Frequently Purchased")
	WebElement topHeaderfreqPurchasedLinkText;	

	@FindBy(xpath="//span[@class='shop-by-category__label']")
	WebElement shopByCategoryLink;

	@FindBy(xpath="//nav[@class='flyout-nav flyout-nav--dynamic flyout-nav--visible']/div[@class='flyout-menu__page']/div[@class='flyout-nav__list-container']/ul/li/a[text()='Appliances']")
	WebElement listFirstOption;

	@FindBy(xpath="//nav[@class='flyout-nav flyout-nav--dynamic flyout-nav--visible']/div[@class='flyout-menu__page']/div[@class='flyout-nav__list-container']/ul/li/div/div[@class='flyout-nav__list-container']/ul/li/a[text()='Washers & Dryers']")
	WebElement categoryListFirstOption;

	@FindBy(xpath="//nav[@class='flyout-nav flyout-nav--dynamic flyout-nav--visible']/div[@class='flyout-menu__page']/div[@class='flyout-nav__list-container']/ul/li/div/div[@class='flyout-nav__list-container']/ul/li/div/div[@class='flyout-nav__list-container']/ul/li/a[text()='Washer & Dryer Repair']")
	WebElement subCategoryListFirstOption;

	@FindBy(xpath = "//a[@data-hds-tag='shopping-cart__item-footer-links-clearcart-btn']")
	WebElement emptyCartLink;
	// Welcome Note
	@FindBy(xpath = "//div[@class='account-snapshot__welcome-inner']/span[contains(text(),'Hi')]")
	WebElement welcomeText;

	@FindBy(id = "widget_minishopcart")
	WebElement headerMyCartLinkText;

	@FindBy(css = "span.type--light")
	WebElement createAnAccountText;

	@FindBy(xpath = ".//*[@id='searchBox']/a[@class='submitButton searchButton']")
	WebElement searchBoxButton;

	@FindBy(xpath = "//a[contains(text(),'Quotes')]")
	WebElement topHeaderquotesLinkText;

	@FindBy (xpath="//h4[contains(text(),'Categories')]/../../..")
	WebElement yourTopCategoriesCarouselSection;

	//Content Heros
	@FindBy(xpath = "//div[@name='content_delivery-hero']//div[@class='marketing-espot marketing-espot--hero']")
	WebElement contentHeros1;

	@FindBy(xpath="//div[@id='content_HeroContentBottomLeft']//h3[@class='type--marketing-hero-large']")
	WebElement contentHeros2;

	@FindBy(xpath="//div[@id='content_HeroContentBottomRight']//h3[@class='type--marketing-hero-large']")
	WebElement contentHeros3;

	@FindBy (xpath = "//div[@data-slot-id='11']")
	WebElement videoESpot1;

	@FindBy (xpath = "//div[@data-slot-id='12']")
	WebElement videoESpot2;

	@FindBy (xpath = "//div[@class='widget-wrapper__header']//*[contains(text(),'Your Top Categories')]")
	WebElement yourTopCategoriesTitle;

	// HeroContent Small Blocks
	@FindBy (xpath = "//div[(@class='col4 acol12')and(@data-slot-id='4')]")
	WebElement heroContentSmallBlock1;

	@FindBy (xpath = "//div[(@class='col4 acol12')and(@data-slot-id='5')]")
	WebElement heroContentSmallBlock2;

	@FindBy (xpath = "//div[(@class='col4 acol12')and(@data-slot-id='6')]")
	WebElement heroContentSmallBlock3;

	@FindBy (xpath = "//h4[@class='widget-wrapper__header-text montserrat'][contains(text(),'Your Top Categories')]/../../..")
	WebElement topCategoriesCarouselSection;

	@FindBy(xpath="//*[@id='content_HeroContentBottomLeft']")
	WebElement learnSomethingNewLeftBlock;

	@FindBy(xpath="//*[@id='content_HeroContentBottomRight']")
	WebElement learnSomethingNewRightBlock;

	@FindBy(xpath="//*[@class='widget-wrapper__header-text montserrat'][contains(text(),'Learn Something New')]")
	WebElement learnSomethingNew;

	public boolean learnSomethingNew()
	{
		return learnSomethingNew.isDisplayed();
	}

	public boolean learnSomethingNewLeftBlock()
	{
		return learnSomethingNewLeftBlock.isDisplayed();
	}

	public boolean learnSomethingNewRightBlock()
	{
		return learnSomethingNewRightBlock.isDisplayed();
	}

	public boolean isDisplayedtopCategoriesCarouselSection() 
	{

		CommonFunctions.scrolltoViewElement(topCategoriesCarouselSection, driver);
		return topCategoriesCarouselSection.isDisplayed();

	}

	public boolean isDisplayedContentHeroSmallBlock1() 
	{
		return heroContentSmallBlock1.isDisplayed();
	}

	public boolean isDisplayedContentHeroSmallBlock2() 
	{
		return heroContentSmallBlock2.isDisplayed();
	}

	public boolean isDisplayedContentHeroSmallBlock3() 
	{
		return heroContentSmallBlock3.isDisplayed();
	}

	public SearchPage searchByKeywordOrPartNumber(String keyword)
	{
		searchBox.sendKeys(keyword);
		searchButton.click();
		return new SearchPage(driver);		
	}
	
	public ProductDetailsPage searchKeywordOrPartNumber(String keyword)
	{
		searchBox.sendKeys(keyword);
		searchButton.click();
		return new ProductDetailsPage(driver);		
	}

	public SearchResultPage clickOnSearchButton() throws InterruptedException{
		searchButton.click();
		return new SearchResultPage(driver);
	}

	public boolean isDisplayedSearchBox(){
		return CommonFunctions.isElementPresent(searchBox);
	}

	//Method to enter items in Search box
	public void enterSearchEdit(String partNumber) {
		searchBox.clear();
		searchBox.sendKeys(partNumber);
	}

	public String isCopyrightMessageDisplayed() 
	{
		CommonFunctions.scrolltoViewElement(copyrighMessage, driver);
		copyrighMessage.isDisplayed();
		String copyrightMessageText = copyrighMessage.getText();
		System.out.println("copyrightMessageText is "+ copyrightMessageText);
		return copyrightMessageText;
	}


	public void clickOnRegisterOrSignIn()
	{
		signInOrRegister.click();
	}

	public HomePage signInToApplication(String username,String pwd) throws Exception
	{
		enterUserName(username);
		enterPassword(pwd);
		signInButton.click();
		WaitTool.hardWait();
		return new HomePage(driver);
	}

	public void signInToApplicationWithIncorrectPassword(String username,String pwd) throws Exception
	{
		enterUserName(username);
		enterPassword(pwd);
		signInButton.click();
		WaitTool.hardWait();
	}

	public Boolean signInToApplicationwithoutPassword(String username)
	{
		signInOrRegister.click();
		enterUserName(username);
		signInButton.click();
		userName.clear();
		return passwordErrorMessage.isDisplayed();
	}

	public Boolean signInToApplicationwithoutUsername(String pwd)
	{
		enterPassword(pwd);
		signInButton.click();
		password.clear();
		return userNameErrorMessage.isDisplayed();
	}

	public LoginPage clearCartReturnsLoginPage() throws Exception {
		/*if(isDisplayedEmptyCartLink()) {*/
		WaitTool.hardWait();
		emptyCartLink.click(); 
		CommonFunctions.acceptPopupMessageBox(driver);
		return new LoginPage(driver); 
	}

	//
	public void clickShopByCategory(){
		shopByCategory.click();
	}

	public boolean isDisplayedShopByCategory(){
		return shopByCategory.isDisplayed();
	}

	public void clickServicesLink(){
		servicesLink.click();
	}

	public void clickMenuItem1Link(){
		menuItem1Link.click();
	}

	public void clickResourcesLink(){
		resourcesLink.click();
	}

	public void clickOffersLink(){
		offersLink.click();
	}

	public void clickeCatalogsLink(){
		ecatalogsLink.click();
	}

	public void clickCabinetsAndCounterTopsLink(){
		cabinetsAndCounterTopsLink.click();
	}

	public void clickDoorsAndMolding(){
		doorsAndMolding.click();
	}


	/**
	 * Click on Header Register Or Sign Link
	 * @return 
	 */

	public  void clickHeaderRegisterOrSignInLinkText() {
		headerRegisterOrSignInLinkText.click();

	}
	public AccountRetrievalPage clickForgotUsernameOrPassword() {
		forgotUsernameAndPasswordLinkText.click();
		return new AccountRetrievalPage(driver) ;
	}
	/**
	 * Enter username
	 * @param username
	 */
	public void enterUserName(String username) {
		WebDriverWait wait = new WebDriverWait(driver, 5000);
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

	/**
	 * Login to the HD Supply site with specified username and password
	 * @param username
	 * @param password
	 * @return the driver to click on sign In button method
	 * @throws Exception 
	 */
	public HomePage loginToHdSupplySite(String username, String password) throws Exception
	{
		clickHeaderRegisterOrSignInLinkText();
		WaitTool.waitFor(driver, true);
		enterUserName(username);
		WaitTool.waitFor(driver, true);
		enterPassword(password);
		WaitTool.waitFor(driver, true);
		//return clickSignInButton();
			signInButton.click();
		WaitTool.hardWait();	
		return new HomePage(driver);
	}

	public ProductPage loginToHdSupplySiteFromProductPage(String username, String password)
	{
		clickHeaderRegisterOrSignInLinkText();
		enterUserName(username);
		enterPassword(password);
		//	return clickSignInButton();
		signInButton.click();
		return new ProductPage(driver);
	}

	/**
	 * Login to the HD Supply site with specified  password
	 * @param password
	 * @return the driver to click on sign In button method
	 */
	public HomePage loginToHdSupplySite(String password) {
		enterPassword(password);
		return clickSignInButton();
	}

	/**
	 * Click on Sign out quick link on Header
	 */
	public void clickLogoutLinkText() {
		WaitTool.waitFor(driver, true);
		clickAccountIcon();
		WaitTool.waitForElement(driver, signOutLinkText);
		signOutLinkText.click();

	}

	/**
	 * Method to logout of application
	 */
	public void logoutOfApplication() {
		clickLogoutLinkText();
		CommonFunctions.acceptPopupMessageBox(driver);
	}

	/**
	 * @return true if Register Or Sign In link is present on the Homepage otherwise false
	 */
	public boolean isDisplayedRegisterOrSignInLinkText() {
		return CommonFunctions.isElementPresent(headerRegisterOrSignInLinkText);
	}
	/**
	 * 
	 * @return true if forgot Username And Password Link is present
	 */
	public boolean isDisplayedforgotUsernameOrPasswordLinkText() {
		return CommonFunctions.isElementPresent(forgotUsernameAndPasswordLinkText);
	}

	/**
	 * click on shopping cart icon on Header
	 * @return the driver to Minicart page
	 */
	public MinicartPage clickOnShoppingCartIcon(){
		shoppingCartIcon.click();
		return new MinicartPage(driver);
	}
	public ShoppingCartPage clickShoppingCartIcon()
	{
		shoppingCartIcon.click();
		return new ShoppingCartPage(driver);
	}


	/**
	 * Select Remember me checkbox
	 */
	public void selectRememberMeCheckbox() {
		rememberMeCheckbox.click();
	}

	/**
	 * Click on Account Icon
	 *
	 */
	public void clickAccountIcon() {
		CommonFunctions.scrolltoViewElement(accountIcon, driver);
		accountIcon.click();

	}

	/**
	 * Click on Account link on Header
	 * @return the driver to My Account Page
	 */
	public MyAccountPage clickAccountLinkText() {
		clickAccountIcon();
		WaitTool.waitForElement(driver, accountLinkText);
		return new MyAccountPage(driver);

	}

	/**
	 * Click on Forgot username and password link from Sign In modal window
	 * @return the driver to Account Retrieval Page
	 */
	public AccountRetrievalPage clickForgotUsernameAndPasswordLinkText() {
		forgotUsernameAndPasswordLinkText.click();
		WaitTool.waitFor(driver, true);
		return new AccountRetrievalPage(driver);


	}

	/**
	 * click on quick order on header
	 */
	public QuickOrderPad clickQuickOrderLink() {
		quickOrderLinkText.click();
		return new QuickOrderPad(driver);

	}

	public Boolean isAboutUsDisplayed()
	{
		return aboutusLink.isDisplayed();
	}

	public Boolean isHelpLinkDisplayed()
	{
		return helpLink.isDisplayed();
	}

	public Boolean isReturnsLinkDisplayed()
	{
		return returnsLink.isDisplayed();
	}

	public Boolean isTermsAndPoliciesLinkDisplayed()
	{
		return termsAndPoliciesLink.isDisplayed();
	}

	public void clearDatainSearchBox(){
		searchBoxText.clear();					
	}

	public boolean isDisplayedsearchAdvanceSearch(){
		return CommonFunctions.isElementPresent(searchAdvanceSearch);		

	}

	
	public String invalidUserNameOrPasswordMessageText()
	{
		return invalidUserNameOrPasswordMessage.getText();
	}

	public String emptyUserNameMessageText()
	{
		return emptyUserNameMessage.getText();
	}

	/**
	 * Login to the HD Supply site with specified username and password by selecting Remember Me checkbox
	 * @param username
	 * @param password
	 * @return the driver to click on sign In button method which returns homepage
	 */
	public HomePage selectRememberMeCheckboxAndloginToHdSupplySite(String username, String password) {
		clickHeaderRegisterOrSignInLinkText();
		enterUserName(username);
		enterPassword(password);
		selectRememberMeCheckbox();
		return clickSignInButton();
	}

	/**
	 * @return the prepopulated username if rememeber me checkbox is selected in previous login otherwise return empty value
	 */
	public String getUsernamePrepopulatedValue() {
		System.out.println("username propopualated value = "+userNameEdit.getAttribute("value"));
		return userNameEdit.getAttribute("value");
	}

	public RegisterForAnAccountPage clickOnRegisterForAnAccountButton()
	{
		registerForAnAccountButton.click();
		return new RegisterForAnAccountPage(driver);
	}

	public ProductListingPage moveToSubCategoryPage() throws Exception 
	{
		WaitTool.waitForElement(driver, headerRegisterOrSignInLinkText);
		CommonFunctions.scrolltoViewElement(headerRegisterOrSignInLinkText, driver);
		shopByCategoryLink.click();
		listFirstOption.click();
		categoryListFirstOption.click();
		subCategoryListFirstOption.click();
		return new ProductListingPage(driver);	
	}


	public QuickOrderPad clickOnQuickOrderLink() 
	{
		headerQuickOrderLinkText.click();
		return new QuickOrderPad(driver);		
	}

	/**
	 * @return the welcome note text
	 */
	public String getWelcomeNote() {
		return welcomeText.getText().trim();
	}

	/**
	 * @return the Create An Account text
	 */
	public String getTextCreateAnAccount() {
		System.out.println(createAnAccountText.getText());
		return createAnAccountText.getText().trim();
	}

	/**
	 * Is displayed Create An Account text
	 */
	public boolean IsDisplayedCreateAnAccount() {
		return CommonFunctions.isElementPresent(createAnAccountText);
	}


	//Method to Click on Quotes in utility bar
	public QuotesPage clickQuotesUtilityBar() throws InterruptedException {
		WaitTool.waitForElement(driver,	topHeaderquotesLinkText);
		topHeaderquotesLinkText.click();
		WaitTool.waitFor(driver, true);
		return new QuotesPage(driver);
	}

	public Boolean isContentHero1Displayed()
	{
		System.out.println("	return contentHeros1.isDisplayed();");
		CommonFunctions.scrolltoViewElement(contentHeros1, driver);
		return contentHeros1.isDisplayed();
	}

	public Boolean isYourTopCategoriesCarouselSection()
	{
		return yourTopCategoriesCarouselSection.isDisplayed();
	}

	public Boolean isContentHero2Displayed()
	{
		return contentHeros2.isDisplayed();
	}

	public Boolean isContentHero3Displayed()
	{
		return contentHeros3.isDisplayed();
	}

	public boolean isDisplayedVideoeSpot1() 
	{
		System.out.println("videoESpot1.isDisplayed();");
		return videoESpot1.isDisplayed();
	}

	public Appliances clickCategoryAppliancesLinkText() throws Exception {
		WaitTool.waitForElement(driver,	categoryAppliancesLinkText);
		//WaitTool.hardWait();
		this.categoryAppliancesLinkText.click();
		WaitTool.waitFor(driver, true);
		return new Appliances(driver);
	} 

	public boolean isDisplayedVideoeSpot2() 
	{
		return videoESpot2.isDisplayed();
	}

	public boolean isTrendingProductsDisplayed() 
	{
		return trendingProducts.isDisplayed();
	}

	public boolean isDisplayedCategoryleftNavigation() {
		return CommonFunctions.isElementPresent(CategoryApplianceLeftNavigationLinkText);
	}

	public String getCategoryRecommendationTitleText() {
		return categoryRecommendationTitleText.getText().trim();
	}

	public boolean isDisplayedContentHeros()
	{
		CommonFunctions.scrolltoViewElement(contentHeros1, driver);
		return contentHeros1.isEnabled();

	}

	public boolean IsDisplayedContentWidgetLearnSomethingNewTitleText() {
		return contentWidgetLearnSomethingNewTitleText.isDisplayed();
	}

	// Method to Click on Shop By Category in Header	
	public void clickHeaderShopByCategoryLinkText() throws InterruptedException {
		WaitTool.waitForElement(driver, headerShopByCategoryLinkText);
		headerShopByCategoryLinkText.click();
		WaitTool.waitFor(driver,true);
	}

	public Boolean isYourTopCategoriesTitleDisplayed()
	{
		return yourTopCategoriesTitle.isDisplayed();
	}

	public Boolean isOrderAgainDisplayed()
	{
		CommonFunctions.scrollDown(driver);
		return orderAgainLabel.isDisplayed();
	}

	public Boolean isViewOrderHistoryButtonDisplayed()
	{
		CommonFunctions.scrollDown(driver);
		return viewOrderHistoryButton.isDisplayed();
	}

	public Integer isEightPartNumbersInsideOrderOnceSectionDisplayed()
	{
		int i = 0;
		Iterator iterator = eightPartNumbersInsideOrderOnceSection.iterator();
		while (iterator.hasNext())
		{
			iterator.next();
			i=i+1; 
		}
		System.out.println("value of i is " + i);
		return i;
	}

	public Integer isEightImagesInsideOrderOnceSectionDisplayed()
	{
		i = 0;
		Iterator iterator = eightImagesInsideOrderOnceSection.iterator();
		while (iterator.hasNext())
		{
			iterator.next();
			i=i+1; 
		}
		return i;
	}

	public Integer isEightProductDescriptionsInsideOrderOnceSectionDisplayed()
	{
		i = 0;
		Iterator iterator = eightProductDescriptionsInsideOrderOnceSection.iterator();
		while (iterator.hasNext())
		{
			iterator.next();
			i=i+1; 
		}
		return i;
	}

	public Integer isEightPricesInsideOrderOnceSectionDisplayed()
	{
		i = 0;
		Iterator iterator = eightPricesInsideOrderOnceSection.iterator();
		while (iterator.hasNext())
		{
			iterator.next();
			i=i+1; 
		}
		return i;
	}

	public Integer isEightAddToCartButtonsInsideOrderOnceSectionDisplayed()
	{
		i = 0;
		Iterator iterator = eightAddToCartButtonInsideOrderOnceSection.iterator();
		while (iterator.hasNext())
		{
			iterator.next();
			i=i+1; 
		}
		return i;
	}

	public Boolean isFourProductVisibleInsideOrderOnceSection()
	{
		return fourProductVisibleAtATimeInOrderOnceSection.isDisplayed();
	}

	public void clickForwardKeyInsideOrderOnceSection()
	{
		CommonFunctions.scrolltoViewElement(forwardKeyInsideOrdereOnceSection, driver);
		forwardKeyInsideOrdereOnceSection.click();
	}

	public void clickBackwardKeyInsideOrderOnceSection()
	{
		CommonFunctions.scrolltoViewElement(backwardKeyInsideOrdereOnceSection, driver);
		backwardKeyInsideOrdereOnceSection.click();
	}

	public void navigateBack()
	{
		CommonFunctions.navigateBack(driver);
	}

	public void enterDataForSearch(String searchData) {
		searchBoxText.sendKeys(searchData);		
	}

	public boolean isDisplayedsearchSuggestedProducts(){
		return CommonFunctions.isElementPresent(searchSuggestedProductsHeader);		
	}
	
	public boolean isDisplayedsearchSuggestedProducts(String searchData) throws Exception{
		boolean status = false;
		WaitTool.hardWait();
		if(CommonFunctions.isElementPresent(suggestedProductsResultsBlock)) {
			for (int i=0;i<suggestedProductsResultsList.size();i++) {
				if(suggestedProductsResultsList.get(i).getText().contains(searchData)) {
					status = true;
				}else
					break;
			}
		}
		return status;
	}

	//Method to click on search button
	public SearchResultPage clickSearchButton() throws InterruptedException {
		WaitTool.waitForElement(driver,	searchBoxButton);
		searchBoxButton.click();
		WaitTool.waitFor(driver, true);
		return new SearchResultPage(driver);
	}

	
	public boolean isDisplayedPromotionalContent() {

		return CommonFunctions.isElementPresent(promotionalContent);
	}
	

	public boolean isDisplayedshopByCategoryLinkText(){
		return CommonFunctions.isElementPresent(shopByCategoryLinkText);
	}

	public boolean isDisplayedheaderoffersLinkText(){
		return CommonFunctions.isElementPresent(headeroffersLinkText);
	}

	public boolean isDisplayedheaderservicesLinkText(){
		return CommonFunctions.isElementPresent(headerservicesLinkText);
	}

	public boolean isDisplayedtopHeaderquotesLinkText(){
		return CommonFunctions.isElementPresent(topHeaderquotesLinkText);
	}

	public OrderHistoryAndStatusPage clickOnViewOrderHistoryButton() 
	{
		viewOrderHistoryButton.click();
		return new OrderHistoryAndStatusPage(driver);
	}

	public boolean isDisplayedtopHeaderorderHisStatusLinkText(){
		return CommonFunctions.isElementPresent(topHeaderorderHisStatusLinkText);
	}

	public boolean isDisplayedtopHeadersavedlistLinkText(){
		return CommonFunctions.isElementPresent(topHeadersavedlistLinkText);
	}

	public boolean isDisplayedtopHeaderfrequentlyPurchasedLinkText(){
		return CommonFunctions.isElementPresent(topHeaderfreqPurchasedLinkText);
	}

	public boolean isDisplayedheaderMyCartLinkText(){
		return CommonFunctions.isElementPresent(headerMyCartLinkText);
	}


	public boolean isDisplayedheaderQuickOrderLinkText(){
		return CommonFunctions.isElementPresent(headerQuickOrderLinkText);
	}

	public boolean isDisplayedHeaderResourcesLinkText(){
		return CommonFunctions.isElementPresent(headerresourcesLinkText);
	}

	public boolean isDisplayedHeaderOffersLinkText(){
		return CommonFunctions.isElementPresent(headeroffersLinkText);
	}


	//Method to verify presence of header order again.
	public boolean isDisplayedHeaderecatalogsLinktext(){
		return CommonFunctions.isElementPresent(headerecatalogsLinkText);
	}

	//Method to verify presence of header services
	public boolean isDisplayedHeaderServicesLinkText(){
		return CommonFunctions.isElementPresent(headerservicesLinkText);
	}


	//Method to verify presence of headerWebsitehelp
	public boolean isDisplayedheaderWebsitehelpEdit(){
		return CommonFunctions.isElementPresent(headerWebsitehelpLinkText);
	}

	public boolean isDisplayedheaderWebsitehelpLinkText(){
		return CommonFunctions.isElementPresent(headerWebsitehelpLinkText);
	}


	// Method to click on HDLogo in any of the Pages
	public void clickHeaderHDLogoImage() throws InterruptedException {
		headerHDLogoImage.click();
	}        
	
	public boolean isDisplayedMyAccountFrequentlyPurchasedQuickLinkInUtilityBar(){
		return myAccountFrequentlyPurchasedQuickLink.isDisplayed();
	}
	
	public boolean isDisplayedMyAccountOrderHistoryQuickLinkInUtilityBar(){
		return myAccountOrderHistoryAndStatusQuickLink.isDisplayed();
	}
	
	public boolean isDisplayedMyAccountSubscriptionsQuickLinkInUtilityBar(){
		return myAccountSubscriptionsQuickLink.isDisplayed();
	}
	
	public boolean isDisplayedMyAccountSavedListsQuickLinkInUtilityBar(){
		return myAccountSavedListsQuickLink.isDisplayed();
	}

	// Method to Verify for Left Navigation
	public boolean isDisplayedLeftNavigation(){
		return CommonFunctions.isElementPresent(leftNavigationImage);
	}

	//Method to verify presence of RegisterOrSignIn	
	public boolean isDisplayedRegisterOrSignIn(){
		return CommonFunctions.isElementPresent(registerOrSignInLinkText);
	}

	//Method to verify presence of Search box in header
	public boolean isDisplayedSearchBoxText(){
		return CommonFunctions.isElementPresent(searchBoxText);
	}


	public ProductDetailsPage clickOnSuggestedSearchResult() throws Exception{
		WaitTool.hardWait();
		suggestedProductsResultsList.get(0).click();
		WaitTool.waitFor(driver, true);
		return new ProductDetailsPage(driver);		
	}

	
	
	public CategoryAppliancesPage clickCategoryAppliancessLinkText() throws Exception {
		WaitTool.waitForElement(driver,	categoryAppliancesLinkText);
		//WaitTool.hardWait();
		categoryAppliancesLinkText.click();
		WaitTool.waitFor(driver, true);
		return new CategoryAppliancesPage(driver);
	} 

	// Method to Verify for L1 ShopBy Category
		public boolean isDisplayedShopByCategoryL1(){
			return CommonFunctions.isElementPresent(flyoutShopByCategoryL1Image);
		}
		// Method to Verify for L2 ShopBy Category
		public boolean isDisplayedShopByCategoryL2(){
			return CommonFunctions.isElementPresent(flyoutShopByCategoryL2Image);
		}
		// Method to Verify for L3 ShopBy Category
		public boolean isDisplayedShopByCategoryL3(){
			return CommonFunctions.isElementPresent(flyoutShopByCategoryL3Image);
		}
		
		public LoginPage clickBreadCrumbHomeLinkText() throws InterruptedException {
			breadCrumbHomeLinkText.click();
			return new LoginPage(driver);
		}

		public void clickOnFirstCategoryInleftNavigationImage()
		{
			firstCategoryInleftNavigationImage.click();
		}
		
		public Boolean isAppliancesTextDisplayed()
		{
			return appliancesText.isDisplayed();
		}

		public SubCategoryCabinetsAndCounterTopsPage clickCategoryCabinetsCountertopsLink() throws InterruptedException {
			WaitTool.waitForElement(driver, categoryCabinetsCountertopsLinkText);
			categoryCabinetsCountertopsLinkText.click();
			driver.manage().timeouts().pageLoadTimeout(WaitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			return new SubCategoryCabinetsAndCounterTopsPage(driver);
		} 
		
		public HomePage loginToHDS() throws Exception {
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
			
			clickHeaderRegisterOrSignInLinkText();
			WaitTool.waitFor(driver, true);
			enterUserName(user);
			WaitTool.waitFor(driver, true);
			enterPassword(prop.getProperty("password"));
			WaitTool.waitFor(driver, true);
			signInButton.click();
			WaitTool.hardWait();	
			return new HomePage(driver);
		}
		
		public HomePage loginToHDSMultiBrowser() throws Exception {
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
			
			//****************
			System.out.println("****************************************************************************");
			Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		    String browserName = cap.getBrowserName().toLowerCase();
		    System.out.println("Display browserName in Login Page :"+browserName);
		    
						
			if (environmentValue.equals("qa1")){
				if (browserName.equals("internet explorer")){
					System.out.println("IE Block");
					user = prop.getProperty("username_qa1_ie");
				}else if (browserName.equals("chrome")){
					System.out.println("chrome Block");
					user = prop.getProperty("username_qa1_chrome");	
				}else if (browserName.equals("firefox")){
					System.out.println("Firefox Block");
					user = prop.getProperty("username_qa1_ff");	
				}
			}else if (environmentValue.equals("qa2")){
				if (browserName.equals("internet explorer")){
					System.out.println("IE Block");
					user = prop.getProperty("username_qa2_ie");
				}else if (browserName.equals("chrome")){
					System.out.println("chrome Block");
					user = prop.getProperty("username_qa2_chrome");	
				}else if (browserName.equals("firefox")){
					System.out.println("Firefox Block");
					user = prop.getProperty("username_qa2_ff");	
				}
			}else if (environmentValue.equals("dev1")){
				if (browserName.equals("internet explorer")){
					System.out.println("IE Block");
					user = prop.getProperty("username_dev1_ie");
				}else if (browserName.equals("chrome")){
					System.out.println("chrome Block");
					user = prop.getProperty("username_dev1_chrome");	
				}else if (browserName.equals("firefox")){
					System.out.println("Firefox Block");
					user = prop.getProperty("username_dev1_ff");	
				}
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
			
			clickHeaderRegisterOrSignInLinkText();
			WaitTool.waitFor(driver, true);
			enterUserName(user);
			WaitTool.waitFor(driver, true);
			enterPassword(prop.getProperty("password"));
			WaitTool.waitFor(driver, true);
			signInButton.click();
			WaitTool.hardWait();	
			return new HomePage(driver);
		}
		
}


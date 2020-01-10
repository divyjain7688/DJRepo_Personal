package com.selenium.ebiz.pageobject;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.WordUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.selenium.ebiz.baseclass.BaseClass;
import com.selenium.ebiz.tools.CommonFunctions;
import com.selenium.ebiz.tools.WaitTool;

public class HomePage extends BaseClass {
	int i;
	WebDriver driver;	
	public HomePage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		WebDriverWait wait = new WebDriverWait(driver,20000);
		wait.until(ExpectedConditions.visibilityOf(welcomeText));

	}

	@FindBy(xpath = "//div[@class='content__description type--caption'][contains(text(),'Replacement for discontinued Part# 20610')]")
	WebElement replacementPartText;
	
	@FindBy(xpath ="//a[text()='Frequently Purchased']")
	WebElement frequentlyPurchasedLink;
	
	@FindBy(xpath ="//*[@class='search_page_new_rr1_results']")
	WebElement richrelevance;

	@FindBy(xpath = "//*[@class='searchresult'][1]/P[1][contains(text(), 'Check your spelling or use different keywords and try again.')]")
	WebElement noResultPagePara1;

	@FindBy(xpath =" //*[@class='searchresult'][1]/P[2][contains(text(), 'The item you are looking for may be discontinued or available by calling us at 1.800.431.3000.')]")
	WebElement noResultPagePara2;

	@FindBy(xpath = "//*[@class='montserrat type--body-x-large'][contains(text(), 'We're sorry, we couldn't find any results for')]")
	WebElement noResultPageTitle;

	@FindBy(xpath = "//*[@class='montserrat type--body-x-large']/strong")
	WebElement noResultSearchText;


	@FindBy (id = "GotoCartButton1")
	WebElement viewCartButton;

	//Below two elements to make Shopping cart script work
	@FindBy (id = "widget_minishopcart")
	WebElement miniCartIcon;

	//Minicart widget
	@FindBy(xpath="//div[@class='main__cart-info']//a[@id='widget_minishopcart'][@role='button']")  
	WebElement shoppingCartIcon;

	@FindBy(xpath="//div[@class='footer-nav__footer-menu']//a")
	List<WebElement> allFooterLinks;

	//Header HD Logo
	@FindBy(xpath = "//div[@class='header__main']//div[@id='ci_espot__HdsHeaderLogoESpot']")
	public WebElement headerHDLogoImage;

	@FindBy(xpath = "//span[text()='Quick Order']")
	WebElement quickOrderLink;

	@FindBy(xpath = "//h1[text()='Custom Products Order Forms & Videos']")
	WebElement customProductsText;

	@FindBy (xpath = "//div[@class='widget-wrapper__header']//*[contains(text(),'Your Top Categories')]")
	WebElement yourTopCategoriesTitle;

	@FindBy(xpath = "//div[@class='account__info type--body-small']/div//span")
	WebElement accountUnderUser;

	@FindBy(xpath = "//div[@class='modal__inner']")
	WebElement accountUnderUserModal;

	@FindBy(xpath = "//td[text()='0012482415']/../td[1]")
	WebElement account0012482415UnderUserModal;

	@FindBy(xpath = "//tr[@class='property-selector']//td[contains(text(),'0012482411')]")
	WebElement account0012482411UnderUserModal;

	// Mini Shopping Cart
	@FindBy(xpath="//div[@class='main__cart']/a[@id='widget_minishopcart']")
	WebElement shoppingCartCheckOutButton;

	@FindBy(xpath="//a[text()='OFFERS']")
	WebElement offerLink;

	@FindBy(xpath="//a[text()='RESOURCES']")
	WebElement resourcesLink;

	@FindBy(xpath="//a[text()='RESOURCES']/../div")
	WebElement resourcesFlyout;

	@FindBy(xpath="//a[contains(text(),'eCATALOGS')]")
	WebElement eCatalogLink;

	//Cobrand Logo
	@FindBy(xpath = "//div[@id='headerRow1']/div[@class='header__main']/section/a/div/div/div/*[@viewBox='0 0 420 90.83']//*[@fill='#fff'][last()]")
	WebElement headerCobrandLogo;

	//Category Recommendation
	@FindBy(xpath = "//div[starts-with(@id,'categoryRecommendationWidget_')]//h4")
	WebElement categoryRecommendationTitleText;

	@FindBy(xpath = "//div[starts-with(@id,'catalogEntryRecommendationWidget_')]//h4")
	WebElement YourCompanysProductsTitleText;

	//Content widget Learn something new
	@FindBy(xpath = "//*[text()='Learn Something New']")
	WebElement contentWidgetLearnSomethingNewTitleText;

	//Search box in header
	@FindBy(xpath = "//*[@id='SimpleSearchForm_SearchTerm']")
	WebElement searchBoxText;

	@FindBy(xpath="//input[@id='SimpleSearchForm_SearchTerm']")
	WebElement searchBox;

	@FindBy(xpath = "//li[@id='autoSuggestAdvancedSearch']")
	WebElement searchAdvanceSearch;

	// Searchbox button
	@FindBy(xpath="//*[@id='searchBox']/a/*[name()='svg']/*[name()='g']/*[name()='circle']")
	WebElement searchButton;

	// Entering Values inside the search EditBox
	@FindBy(xpath="//input[@id='SimpleSearchForm_SearchTerm']")
	WebElement searchEdit;

	//Signed In User Name
	@FindBy(xpath = "//div[@class='account__info type--body-small']/span[1]")
	WebElement userSignedInUserText;

	//User Account number
	@FindBy(xpath = "//div[@class='account__info type--body-small']/span[2]")
	WebElement userAccountNumberText;

	//User Account Name
	@FindBy(xpath = "//div[@class='account__info type--body-small']/span[1]//following::a[1]/span")
	WebElement propertyDropdown;

	//Static Website help label
	@FindBy(xpath = "//div[@class='quick-info__help']/span[contains(text(), 'Website Help')]")
	WebElement WebsiteHelpLabel;

	//Static Website help Phone number
	@FindBy(xpath = "//div[@class='quick-info__help']/span[contains(text(), '1.877.694.4932')]")
	WebElement WebsiteHelpPhoneNumberText;

	//Static Website help Timings
	@FindBy(xpath = "//div[@class='quick-info__help']/span[contains(text(), '(8 a.m. - 8 p.m. EST)')]")
	WebElement WebsiteHelpTimeText;

	//My Account Quotes quick link in utility bar
	@FindBy(linkText = "Quotes")
	WebElement myAccountQuotesQuickLink;

	//My Account Subscriptions quick link in utility bar
	@FindBy(linkText = "Subscriptions")
	WebElement myAccountSubscriptionsQuickLink;

	//My Account Saved Lists quick link in utility bar
	@FindBy(xpath="//div[@class='quick-info__quick-links type--body-small']//a[text()='Saved Lists']")
	WebElement myAccountSavedListsQuickLink;

	//My Account Frequent Orders quick link in utility bar
	@FindBy(linkText = "Frequently Purchased")
	WebElement myAccountFrequentlyPurchasedQuickLink;

	//My Account Order History quick link in utility bar
	@FindBy(linkText = "Order History & Status")
	WebElement myAccountOrderHistoryAndStatusQuickLink;

	//Content Heros
	@FindBy(xpath = "//div[@id='content_delivery-hero']")
	WebElement contentHeros1;

	//@FindBy(xpath = "//div[@id='content_HeroContent2_Home']/div/div")
	@FindBy(xpath="//div[@id='content_HeroContentBottomLeft']//h3[@class='type--marketing-hero-large']")
	WebElement contentHeros2;

	//@FindBy(xpath = "//div[@id='content_HeroContent3_Home']/div/div")
	@FindBy(xpath="//div[@id='content_HeroContentBottomRight']//h3[@class='type--marketing-hero-large']")
	WebElement contentHeros3;


	@FindAll(@FindBy(xpath= "//div[@id='suggestedProductsResults']//div[@class='list_section']//li"))
	List <WebElement> suggestedProductsResultsList;	

	@FindBy(id = "suggestedProductsHeader")
	WebElement searchSuggestedProductsHeader;

	//Left navigation Appliance category
	@FindBy(xpath = "//a[starts-with(@id, 'SBN_Appliances_')]")
	WebElement CategoryApplianceLeftNavigationLinkText;

	//  Left Nav 
	@FindBy(xpath = "//ul[starts-with(@id,'categoryFacetList_1')]")
	WebElement leftNavigationImage;

	//PopularProductsCarousel
	@FindBy(className = "home_page_new_rr1")
	WebElement hdsPopularProductsCarousel;

	//Video Content eSpots (Learn More Spots)
	@FindBy (xpath = "//div[@data-slot-id='11']")
	WebElement videoESpot1;

	@FindBy (xpath = "//div[@data-slot-id='12']")
	WebElement videoESpot2;

	@FindBy(xpath="//*[@id='content_HeroContentBottomLeft']")
	WebElement learnSomethingNewLeftBlock;

	@FindBy(xpath="//*[@id='content_HeroContentBottomRight']")
	WebElement learnSomethingNewRightBlock;

	@FindBy(xpath="//*[@class='widget-wrapper__header-text montserrat'][contains(text(),'Learn Something New')]")
	WebElement learnSomethingNew;

	// Categories in Left Navigation
	@FindBy(xpath = "//div[@class='left-nav']//a[contains(text(),'Appliances')]")
	WebElement categoryAppliancesLinkText;

	//  Home in BreadCrumbs
	@FindBy(xpath = "//div[@data-hds-tag='breadcrumbs']//a[contains(text(),'Home')]")
	WebElement breadCrumbHomeLinkText;

	// To Verify the Heading of the Categories	             
	@FindBy(xpath = "//div[starts-with(@id, 'PageHeading_2_-3001_')]/h1")
	WebElement categoryPageHeadingText;

	// Shop by Category
	@FindBy(xpath="//span[@class='shop-by-category__label']")
	WebElement headerShopByCategoryLinkText;

	// Shop by Category L1
	@FindBy(xpath="//nav[@class='flyout-nav flyout-nav--dynamic flyout-nav--visible']")
	WebElement flyoutShopByCategoryL1Image;

	// Shop by Category L2
	@FindBy(xpath="//nav[@class='flyout-nav flyout-nav--dynamic flyout-nav--visible']//li[@class='flyout-nav__li--selected']/div")
	WebElement flyoutShopByCategoryL2Image;

	// Shop by Category L3
	@FindBy(xpath="//nav[@class='flyout-nav flyout-nav--dynamic flyout-nav--visible']//li[@class='flyout-nav__li--selected']//li[@class='flyout-nav__li--selected']/div")
	WebElement flyoutShopByCategoryL3Image;

	// Welcome Note
	@FindBy(xpath = "//div[@class='account-snapshot__welcome-inner']/span")
	WebElement welcomeText;

	// MiniCart
	@FindBy(xpath="//a[@id='widget_minishopcart']")
	WebElement miniShopCart;

	// MiniCart Popup
	@FindBy(xpath="//a[@id='widget_minishopcart' and @class='selected']")
	WebElement miniShopCartPopup;

	// SubTotal
	@FindBy(xpath="//span[@class='type--caps type--caption']")
	WebElement miniShopCartSubTotal;

	// SubTotal Amount
	@FindBy(xpath="//span[@class='type--body-medium']")
	WebElement miniShopCartSubTotalAmount;

	// left Navigation
	@FindBy(xpath="//*[@id='categoryFacetList_1_14554_39471']")
	WebElement leftNavImage;

	// Flyout Services in Header
	@FindBy(xpath="//div[@id='headerRow1']//a[text()='SERVICES']/following-sibling::nav[@class='flyout-nav flyout-nav--visible']")
	WebElement flyoutServicesImage;

	// Flyout Resources in Header
	@FindBy(xpath="//div[@id='headerRow1']//a[text()='RESOURCES']/following-sibling::nav[@class='flyout-nav flyout-nav--visible']")
	WebElement flyoutResourcesImage;

	//Flyout Offers in Header
	@FindBy(xpath="//div[@id='headerRow1']//a[text()='OFFERS']/following-sibling::nav[@class='flyout-nav flyout-nav--visible']")
	WebElement flyoutOffersImage;

	// Flyout Offers in eCatalogs
	@FindBy(xpath="//div[@id='headerRow1']//a[text()='eCATALOGS']/following-sibling::nav[@class='flyout-nav flyout-nav--visible']")
	WebElement flyouteCatalogsImage;

	@FindBy(linkText = "Bed, Bath & Table Linens")
	WebElement categoryBedBathTableLinensLinkText;

	@FindBy(linkText = "Cabinets & Countertops")
	WebElement categoryCabinetsCountertopsLinkText;

	@FindBy(linkText = "Doors & Molding")
	WebElement categoryDoorsMoldingLinkText;

	@FindBy(linkText = "Electrical")
	WebElement categoryElectricalLinkText;	

	@FindBy(linkText = "Electronics")
	WebElement categoryElectronicsLinkText;

	@FindBy(linkText = "Fitness & Exercise")
	WebElement categoryFitnessExerciseLinkText;

	@FindBy(linkText = "Flooring & Ceiling")
	WebElement categoryFlooringCeilingLinkText;

	@FindBy(linkText = "Food Service")
	WebElement categoryFoodServiceLinkText;

	@FindBy(linkText = "Furniture & D�cor")
	WebElement categoryFurnitureDecorLinkText;

	@FindBy(linkText = "Grounds")
	WebElement categoryGroundsLinkText;

	@FindBy(linkText = "Hardware")
	WebElement categoryHardwareLinkText;

	@FindBy(linkText = "Healthcare Supplies")
	WebElement categoryHealthcareSuppliesLinkText;

	@FindBy(linkText = "Hospitality Supplies")
	WebElement categoryHospitalitySuppliesLinkText;

	@FindBy(linkText = "HVAC")
	WebElement categoryHvacLinkText;

	@FindBy(linkText = "Janitorial")
	WebElement categoryJanitorialLinkText;

	@FindBy(linkText = "Lighting")
	WebElement categoryLightingLinkText;

	@FindBy(linkText = "Office Supplies")
	WebElement categoryOfficeSuppliesLinkText;

	@FindBy(linkText = "Paint Supplies")
	WebElement categoryPaintSuppliesLinkText;

	@FindBy(linkText = "Plumbing")
	WebElement categoryPlumbingLinkText;

	@FindBy(linkText = "Pool Supplies")
	WebElement categoryPoolSuppliesLinkText;

	@FindBy(linkText = "Property Marketing")
	WebElement categoryPropertyMarketingLinkText;

	@FindBy(linkText = "Safety")
	WebElement categorySafetyLinkText;

	@FindBy(linkText = "Signs")
	WebElement categorySignsLinkText;

	@FindBy(linkText = "Storage")
	WebElement categoryStorageLinkText;

	@FindBy(linkText = "Tools")
	WebElement categoryToolsLinkText;

	@FindBy(xpath = "//nav[@class='flyout-nav flyout-nav--dynamic flyout-nav--visible']//li/a[contains(text(),'Window Coverings')]")
	WebElement categoryWindowCoveringsLinkText;

	@FindBy(xpath = "//span[@class='type--caption type--extra-bold']")
	WebElement displayedUserName;

	//Footer Page objects
	@FindBy(linkText = "Careers")
	WebElement aboutUsCareersLinkText;

	@FindBy(linkText = "Contact Us")
	WebElement aboutUsContactUsLinkText;

	@FindBy(id = "suggestedProductsResults")
	WebElement suggestedProductsResultsBlock;

	@FindBy(linkText = "En Espa�ol")
	WebElement aboutUsEnEspanolLinkText;

	@FindBy(linkText = "HD Supply Canada")
	WebElement aboutUsHDSupplyCanadalLinkText;

	@FindBy(linkText = "Locations")
	WebElement aboutUsLocationsLinkText;

	@FindBy(linkText = "Our Company")
	WebElement aboutUsOurCompanyLinkText;

	@FindBy(linkText = "Account Change Request")
	WebElement helpAccountChangeRequestLinkText;

	@FindBy(linkText = "Apply for Credit")
	WebElement helpApplyforCreditlLinkText;

	@FindBy(linkText = "FAQ")
	WebElement helpFaqlLinkText;

	@FindBy(linkText = "Forgot Password")
	WebElement helpForgotPasswordLinkText;

	//Forgot username and password
	@FindBy(id = "Header_GlobalLogin_WC_AccountDisplay_links_1")
	WebElement forgotUsernameAndPasswordLinkText;

	@FindBy(linkText = "New Website Features")
	WebElement helpNewWebsiteFeaturesLinkText;

	@FindBy(linkText = "Site Map")
	WebElement helpSiteMapLinkText;

	@FindBy(linkText = "Returns Form")
	WebElement returnsFormLinkText;

	@FindBy(linkText = "Return Policy")
	WebElement returnPolicyLinkText;

	@FindBy(linkText = "California Privacy")
	WebElement termsAndPoliiciesCaliforniaPrivacyLinkText;

	@FindBy(linkText = "Fine Print & Catalog Icons")
	WebElement termsAndPoliiciesFinePrintCatalogIconsLinkText;

	@FindBy(linkText = "Privacy Policy")
	WebElement termsAndPoliiciesPrivacyPolicyLinkText;

	@FindBy(linkText = "Privacy Statement")
	WebElement termsAndPoliiciesPrivacyStatementLinkText;

	@FindBy(linkText = "Terms of Sale")
	WebElement termsAndPoliiciesTermsofSaleLinkText;

	@FindBy(linkText = "Terms Of Use")
	WebElement termsAndPoliiciesTermsOfUseLinkText;

	// Copy Right
	@FindBy(xpath = "//div[@class='footer__copyright type--white type--body-small']")
	WebElement copyRightText;

	//Sign Out link
	//@FindBy(xpath = "//a[@id='Header_GlobalLogin_loggedInDropdown_SignOut']/div/span[contains(text(), 'SIGN OUT')]")
	@FindBy(xpath = "//div[@class='header-sign-in__header header-sign-out']//span[contains(text(),'SIGN OUT')]")

	WebElement signOutLinkText;

	// ************************Headers****************************************

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

	@FindBy(linkText = "Quotes")
	WebElement topHeaderquotesLinkText;

	@FindBy(linkText = "Saved Lists")
	WebElement topHeadersavedlistLinkText;

	@FindBy(linkText = "Order History & Status")
	WebElement topHeaderorderHisStatusLinkText;

	@FindBy(linkText = "Frequently Purchased")
	WebElement topHeaderfreqPurchasedLinkText;

	//@FindBy(id = "widget_minishopcart")
	@FindBy(xpath="//div[@class='main__cart']/a[@id='widget_minishopcart']")
	WebElement headerMyCartLinkText;

	@FindBy(xpath = "//div[@class='quick-order__label']")
	WebElement headerQuickOrderLinkText;	


	@FindBy(xpath = "//a[@class='jq-flyout-nav--toggle type--extra-bold type--caps selected']")
	WebElement shopByCategoryArrow;

	@FindBy(xpath = ".//*[@id='searchBox']/a[@class='submitButton searchButton']")
	WebElement searchBoxButton;

	/*@FindBy(xpath="//*[@class='pageControl dot']/a")*/
	@FindBy(xpath="//div[@class='hero-carousel-container']")
	WebElement heroImageCarousel;

	// added to verify whether search box is above header
	@FindBy(xpath = "//div[@id='headerRow1']/div[3]/section/../preceding-sibling::div[@class='header__main']/descendant::div[@class='main__search']")
	WebElement searchboxAboveHeaderEdit;

	@FindBy(xpath = "//h4[contains(text(),'Order Again')][@class='widget-wrapper__header-text montserrat']")
	WebElement headerOrderAgain;

	@FindBy(xpath = "//button[@class='btn'][text()='VIEW ORDER HISTORY']")
	WebElement viewOrderHistoryButton;

	// added to verify whether search box is above header
	@FindBy(xpath = "//div[@class='header__main']/preceding-sibling::div/descendant::div[@class=\'quick-info__help\']")
	WebElement headerWebsitehelpLinkText;

	//exploreHDSupply DropDown 
	@FindBy(xpath = "//select[@class='jq-select--navigate oswald']")
	WebElement exploreHDSupplyDropDown;

	@FindBy(xpath = "//div[@class='header-mini-cart__empty']")
	WebElement headerMinicartEmpty;	

	//Register or signIn	
	@FindBy(id = "Header_GlobalLogin_signInQuickLink")
	WebElement registerOrSignInLinkText;

	//Content recommendation order again.
	@FindBy(xpath = "//h4[contains(text(),'Order Again')]/../../..")
	WebElement OrderAgainContentRecommandation;

	//Account icon next to account name.
	@FindBy(xpath = "//a[@id='Header_GlobalLogin_signOutQuickLink']")
	//WebElement accountSignOutIcon;
	WebElement accountIcon;

	//My Account link
	@FindBy(xpath = "//a[@id='Header_GlobalLogin_loggedInDropdown_SignOut']/div/span[contains(text(), 'ACCOUNT')]")
	WebElement accountLinkText;

	//account option once we click on icon next to account name
	@FindBy(xpath = "//a[@id='Header_GlobalLogin_loggedInDropdown_SignOut']/div[@class='header-account']")
	WebElement account;


	//	@FindBy(xpath="//*[@class='pageControl dot']/a[1][@class='selected']")
	@FindBy(xpath="//h3[contains(text(),'Multifamily Solutions ')]")
	WebElement heroImageCarouselOne;

	//@FindBy(xpath="//*[@class='pageControl dot']/a[2][@class='selected']")
	@FindBy(xpath="//h3[contains(text(),'Easy Access Anywhere')]")
	WebElement heroImageCarouselTwo;

	//@FindBy(xpath="//*[@class='pageControl dot']/a[3][@class='selected']")
	@FindBy(xpath="//h3[contains(text(),'Free Next-Day')]")	
	WebElement heroImageCarouselThree;

	//Quotes under account highlight section
	@FindBy(xpath = "//div[@class='account-snapshot__steps type--caption']/div[1]")
	public WebElement QuotesUnderAccHighlightSec;

	//SavedList under account highlight section
	@FindBy(xpath = "//div[@class='account-snapshot__steps type--caption']/div[2]")
	public WebElement SavedListUnderAccHighlightSec;

	//Order history under account highlight section
	@FindBy(xpath = "//div[@class='account-snapshot__steps type--caption']/div[3]")
	public WebElement OrderHistoryAccHighlightSec;

	//Frequent order under account highlight section
	@FindBy(xpath = "//div[@class='account-snapshot__steps type--caption']/div[4]")
	public WebElement FreqOrderAccHighlightSec;

	//exploreHDSupply dropdown exactly below left navigation category.
	@FindBy(xpath = "//div[@aria-label='Category']/ancestor::div/following-sibling::div/descendant::div[@class='explore-dropdown oswald']")
	WebElement exploreHDSupplyDropDown1;

	//breadcrum displayed in current page
	@FindBy(xpath = "//span[@class= 'breadcrumbs__link--selected']")
	WebElement currentPagebreadCrumbHomeLinkText;

	@FindBy (xpath= "//div[@class='main__account-info']")
	WebElement myAccountLogo;

	@FindBy(xpath="//div[@class='footer-contact']//div[@class='footer-social-container__social-icons type--caps montserrat type--bold type--white']/span[1]")
	WebElement facebookLink;

	@FindBy(xpath="//div[@class='footer-contact']//div[@class='footer-social-container__social-icons type--caps montserrat type--bold type--white']/span[2]")
	WebElement twitterLink;

	@FindBy(xpath="//div[@class='footer-contact']//div[@class='footer-social-container__social-icons type--caps montserrat type--bold type--white']/span[3]")
	WebElement googleplusLink;

	@FindBy(xpath="//div[@class='footer-contact']//div[@class='footer-social-container__social-icons type--caps montserrat type--bold type--white']/span[4]")
	WebElement linkedinLink;

	@FindBy(xpath="//div[@class='footer-contact']//div[@class='footer-social-container__social-icons type--caps montserrat type--bold type--white']/span[5]")
	WebElement youtubeLink;	

	@FindBy(xpath="//div[@class='footer-nav__footer-menu']//div[text()='ABOUT US']")
	WebElement aboutusLink;	

	@FindBy(xpath="//div[@class='footer-nav__footer-menu']//div[text()='HELP']")
	WebElement helpLink;	

	@FindBy(xpath="//div[@class='footer-nav__footer-menu']//div[text()='RETURNS']")
	WebElement returnsLink;	

	@FindBy(xpath="//div[@class='footer-nav__footer-menu']//div[text()='TERMS & POLICIES']")
	WebElement termsAndPoliciesLink;

	@FindBy(xpath="//span[@class='shop-by-category__label']")
	WebElement shopByCategoryLink;

	@FindBy(xpath="//nav[@class='flyout-nav flyout-nav--dynamic flyout-nav--visible']/div[@class='flyout-menu__page']/div[@class='flyout-nav__list-container']/ul/li/a[text()='Appliances']")
	WebElement listFirstOption;

	@FindBy(xpath="//nav[@class='flyout-nav flyout-nav--dynamic flyout-nav--visible']/div[@class='flyout-menu__page']/div[@class='flyout-nav__list-container']/ul/li/div/div[@class='flyout-nav__list-container']/ul/li/a[text()='Washers & Dryers']")
	WebElement categoryListFirstOption;

	@FindBy(xpath="//nav[@class='flyout-nav flyout-nav--dynamic flyout-nav--visible']/div[@class='flyout-menu__page']/div[@class='flyout-nav__list-container']/ul/li/div/div[@class='flyout-nav__list-container']/ul/li/div/div[@class='flyout-nav__list-container']/ul/li/a[text()='Washer & Dryer Repair']")
	WebElement subCategoryListFirstOption;

	@FindBy(xpath="//div[@class='footer__logo']")
	WebElement hDSupplyLogo;

	@FindBy(xpath="//h4[@class='widget-wrapper__header-text montserrat']")
	WebElement orderAgainLabel;

	@FindBy (xpath="//span[text()='ACCOUNT']")
	WebElement myAccountButton;

	@FindBy (xpath = "//a[@class='panelLinkSelected Header_GlobalLogin_signOutQuickLink_CSR header-select']")
	WebElement logo;

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

	@FindBy(xpath="//h4[@class='widget-wrapper__header-text montserrat'][text()='Order Again']/../../..//div[@class='owl-item'][1]//div[@class='part-number-container']/a")
	WebElement firstProductInsideOrderOnceSection;

	//YourTopCategories Text Header
	@FindBy (className = "home_page_new_rr1")
	WebElement topCategoriesCarouselSection;

	@FindBy (xpath="//h4[contains(text(),'Categories')]/../../..")
	WebElement yourTopCategoriesCarouselSection;

	//TrendingProducts or TopSellers or New Heading (based on user experience it can show any name for same section
	@FindBy (className = "home_page_new_rr1")
	WebElement rrBRCarouselSection;

	// HeroContent Small Blocks
	@FindBy (xpath = "//div[(@class='col4 acol12')and(@data-slot-id='4')]")
	WebElement heroContentSmallBlock1;

	@FindBy (xpath = "//div[(@class='col4 acol12')and(@data-slot-id='5')]")
	WebElement heroContentSmallBlock2;

	@FindBy (xpath = "//div[(@class='col4 acol12')and(@data-slot-id='6')]")
	WebElement heroContentSmallBlock3;


	@FindBy(xpath="//div[@class='subcat-grid-tile-container']//section[@class='subcat-grid-tile'][1]//*[@class='btn btn--full btn--small type--caps']")
	WebElement addToCartButtonOfFirstProduct;

	@FindBy(xpath=" //div[@class='subcat-list-tile-container']//section[@class='subcat-list-tile'][1]//*[@class='btn btn--full btn--small type--caps']")
	WebElement addToCartButtonOfFirstProductListView;

	@FindBy(xpath="/html/body/div[@class='modal modal--visible modal--overflow']")
	WebElement cartOverlay; 

	@FindBy(xpath="//a[@class='btn btn--large btn--full cart-added__checkout-desktop']")
	WebElement cartOverlayCheckoutButton;


	@FindBy(xpath="//*[@id='WC_AccountDisplay_FormInput_logonId_In_Logon_1']")
	WebElement usernameField;

	@FindBy(xpath="//*[@id='WC_AccountDisplay_FormInput_logonPassword_In_Logon_1']")
	WebElement passwordField;

	@FindBy(xpath="//*[@id='WC_AccountDisplay_links_2']/button")
	WebElement signInButton;


	@FindBy(xpath="//*[@class='main_content']/h1[contains(text(),'Sign in or Register')]")
	WebElement signInPage;

	@FindBy(xpath="//*[@id='WC_SearchBasedNavigationResults_pagination_link_grid_categoryResults']")
	WebElement gridViewIcon;

	//PromotionalContent
	@FindBy (xpath ="//div[@class ='pageControl dot']")
	WebElement prpmotionalContent;

	@FindBy (xpath ="//div[@class='sales-rep__authenticated']//span[@class='type--body-large']")
	WebElement salesRepName;

	@FindBy (xpath ="//div[@class='sales-rep__authenticated']//a[text()='Email Me']")
	WebElement salesRepEmail;

	@FindBy (xpath ="//div[@class='sales-rep__authenticated']//span[@class='type--caption']")
	WebElement salesRepNumber;

	@FindBy (xpath ="//div[@class='sales-rep__authenticated']//img")
	WebElement salesRepImage;	

	@FindBy(xpath = "//div[@class='account-snapshot__sales-rep']/div[@class='sales-rep']")
	WebElement salesRepOnHeader;

	@FindBy(xpath = "//div[@class='account-snapshot__sales-rep']/div[@class='sales-rep']/img")
	WebElement salesRepImageOnHeader;

	@FindBy(xpath = "//div[@class='account-snapshot__sales-rep']/div[@class='sales-rep']/div[@class='sales-rep__info']")
	WebElement salesRepInformationOnHeader;

	@FindBy(xpath = "//div[@class='pageControl dot']/a[1]")
	WebElement firstRadioButtonInsidePageControlPanel;

	@FindBy(xpath = "//div[@class='pageControl dot']/a[2]")
	WebElement secondRadioButtonInsidePageControlPanel;

	@FindBy(xpath = "//div[@class='pageControl dot']/a[3]")
	WebElement thirdRadioButtonInsidePageControlPanel;

	//Property For Cobarnd User

	@FindBy(xpath = "//table[@id='sumaList']/tbody/tr/td[text()='SAP Web Test Account - Core Arif']")
	WebElement propertyValueForCobrandUser;

	//Your Properties Heading text
	//@FindBy(xpath = "html/body/div[12]//h4[text()='Your Properties']")
	@FindBy(xpath = "//div[@class='widget-wrapper']//h4[contains(text(),'Your Properties')]")
	WebElement yourPropertiesHeadingText;

	//Table column header 'Name'
	@FindBy(xpath = "html/body/div[12]//table[@id='sumaList']//th[contains(text(),'Name')]")
	WebElement nameTableColumnHeader;

	//Table column header 'Account Number'
	@FindBy(xpath = "html/body/div[12]//table[@id='sumaList']//th[contains(text(),'Account #')]")
	WebElement accountNoTableColumnHeader;

	//Table column header 'City'
	@FindBy(xpath = "html/body/div[12]//table[@id='sumaList']//th[contains(text(),'City')]")
	WebElement cityTableColumnHeader;

	//Table column header 'State'
	@FindBy(xpath = "html/body/div[12]//table[@id='sumaList']//th[contains(text(),'State')]")
	WebElement stateTableColumnHeader;

	//Name List
	@FindBy(xpath = "html/body/div[12]//table[@id='sumaList']/tbody/tr/td[1]")
	List<WebElement> propertyNameList;

	//Account Number List
	@FindBy(xpath = "html/body/div[12]//table[@id='sumaList']/tbody/tr/td[2]")
	List<WebElement> accountNumberList;

	//City List
	@FindBy(xpath = "html/body/div[12]//table[@id='sumaList']/tbody/tr/td[3]")
	List<WebElement> cityList;

	//State List
	@FindBy(xpath = "html/body/div[12]//table[@id='sumaList']/tbody/tr/td[4]")
	List<WebElement> stateList;

	@FindBy(xpath = "//table[@id='sumaList']//tbody//tr[@class='property-selector']//td[contains(text(),'SAP Web Test Account')]")
	WebElement sapWebTestActCoreArif;

	@FindBy(xpath = "//table[@id='sumaList']")
	WebElement propertySelectionListTable;

	@FindBy(xpath = "//tr[@class='property-selector']//td[contains(text(),'0010017688')]")
	WebElement selectAccount;

	@FindBy(xpath = "//h1[contains(text(),'Search result')]")
	WebElement headerSearchResultEdit;


	@FindBy(xpath = "//h1[text()='Contact Us']")
	WebElement contactUsText;

	@FindBy(xpath = "//h1[text()='Spanish']")
	WebElement spanishText;


	@FindBy(xpath = "//h1[text()='Locations']")
	WebElement LocationsText;

	@FindBy(xpath = "//h1[contains(text(),'Our Company')]")
	WebElement ourCompanyText;

	@FindBy(xpath = "//span[text()='Account Change Request']")
	WebElement accountChangeRequestBreadcrumb;

	@FindBy(xpath = "//h1[contains(text(),'Apply for Credit')]")
	WebElement applyForCreditText;

	@FindBy(xpath = "//h1[contains(text(),'Frequently Asked Questions')]")
	WebElement frequentlyAskedQuestionsText;

	@FindBy(xpath = "//h1[contains(text(),'Account Retrieval')]")
	WebElement accountRetrievalText;

	@FindBy(xpath = "//h1[contains(text(),'Website Updates')]")
	WebElement websiteUpdatesText;
	
	@FindBy(xpath = "//h1[contains(text(),'Return Policy')]")
	WebElement returnPolicyText;
	
	@FindBy(xpath = "//h1[contains(text(),'California Privacy')]")
	WebElement californiaPrivacyText;
	
	@FindBy(xpath = "//h1[contains(text(),'Privacy Statement')]")
	WebElement privacyStatementText;
	
	@FindBy(xpath = "//h1[contains(text(),'Terms of Sale')]")
	WebElement termOfSaleText;
	
	@FindBy(xpath = "//h1[contains(text(),'Terms of Use')]")
	WebElement termOfUseText;
	
	@FindBy(xpath = "//h1[contains(text(),'Fine Print & Catalog Icons')]")
	WebElement finePrintAndCatalogIconsText;
	
	@FindBy(xpath = "//h3[contains(text(),'COMPLIANCE')]")
	WebElement privacyComplainceText;
	
	@FindBy(xpath = "//div[text()='Contact us for help.']")
	//@FindBy(xpath = "//h1[text()='Online Return Form']")
	WebElement contactUsForHelpText;
	/**
	 * click on Account from Property dropdown
	 */	
	public void clickOnselectAccount(){
		selectAccount.click();
	}


	public void clickSAPWebTestActCoreArif(){
		sapWebTestActCoreArif.click();
	}

	/**
	 * click on user property from Property Lookup modal
	 */	
	public void clickProperty(String property) {

		for(WebElement we:propertyNameList) {
			if(we.getText().equalsIgnoreCase(property)) {
				we.click();
				WaitTool.waitFor(driver, true);
				break;
			}
		}

	}

	/**
	 *  @return True if properties table sorted by Name otherwise False
	 */
	public boolean IsDisplayedPropertyTableSortedByName() {
		return CommonFunctions.isTableSortedByColumn(nameTableColumnHeader,propertyNameList);

	}

	/**
	 *  @return True if properties table sorted by Account Number otherwise False
	 */
	public boolean IsDisplayedPropertyTableSortedByAccountNumber() {
		return CommonFunctions.isTableSortedByColumn(accountNoTableColumnHeader,accountNumberList);

	}

	/**
	 *  @return True if properties table sorted by City otherwise False
	 */
	public boolean IsDisplayedPropertyTableSortedByCity() {
		return CommonFunctions.isTableSortedByColumn(cityTableColumnHeader,cityList);

	}

	/**
	 *  @return True if properties table sorted by State otherwise False
	 */
	public boolean IsDisplayedPropertyTableSortedByState() {
		return CommonFunctions.isTableSortedByColumn(stateTableColumnHeader,stateList);

	}	

	/**
	 * @return the welcome note text
	 */
	public String getWelcomeNote() {
		WaitTool.waitVisibility(driver, welcomeText, 60);
		return welcomeText.getText().trim();
	}

	/**
	 * @return 'Top Categories' for Unauthenticated user,'Your Top Categories' for Authenticated user 
	 * 
	 */
	public String getCategoryRecommendationTitleText() {
		return categoryRecommendationTitleText.getText().trim();
	}

	/**
	 * @return 'Your Company's Products' text for Cobrand user 
	 * 
	 */
	public String getYourCompanysProductsTitleText() {
		return YourCompanysProductsTitleText.getText().trim();
	}

	/**
	 * @return true if 'Your Company's Products' text is displayed otherwise false 
	 * 
	 */
	public boolean isDisplayedYourCompanysProductsTitleText() {
		return CommonFunctions.isElementPresent(YourCompanysProductsTitleText);
	}

	/**
	 * @return true if content widget Learn Something New Title is displayed on homepage otherwise false
	 */
	public boolean IsDisplayedContentWidgetLearnSomethingNewTitleText() {
		return contentWidgetLearnSomethingNewTitleText.isDisplayed();
	}

	/**
	 * @return true if Cobrand Logo is displayed in the Header otherwise false
	 */
	public boolean IsDisplayedCobrandLogoInHeader() {
		return headerCobrandLogo.isDisplayed();
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

	public Boolean isFacebookLinkDisplayed()
	{

		return facebookLink.isDisplayed();
	}

	public String clickOnFacebookLink()
	{
		facebookLink.click();
		CommonFunctions.moveToNewWindow(driver);
		return CommonFunctions.getTitle(driver);
	}


	public Boolean isTwitterLinkDisplayed()
	{
		return twitterLink.isDisplayed();
	}

	public String clickOnTwitterLink()
	{
		twitterLink.click();
		CommonFunctions.moveToNewWindow(driver);
		return CommonFunctions.getTitle(driver);
	}

	public Boolean isGoogleplusLinkDisplayed()
	{
		return googleplusLink.isDisplayed();
	}

	public String clickOnGoogleplusLink()
	{
		googleplusLink.click();
		CommonFunctions.moveToNewWindow(driver);
		return CommonFunctions.getTitle(driver);
	}

	public Boolean isLinkedinLinkDisplayed()
	{
		return linkedinLink.isDisplayed();
	}

	public String clickOnLinkedinLink()
	{
		linkedinLink.click();
		CommonFunctions.moveToNewWindow(driver);
		return CommonFunctions.getTitle(driver);
	}

	public Boolean isYoutubeLinkDisplayed()
	{
		return youtubeLink.isDisplayed();
	}


	public String clickOnYoutubeLink()
	{
		youtubeLink.click();
		CommonFunctions.moveToNewWindow(driver);
		return CommonFunctions.getTitle(driver);
	}

	public ProductListingPage moveToSubCategoryPage() throws Exception 
	{
		shopByCategoryLink.click();
		listFirstOption.click();
		categoryListFirstOption.click();
		subCategoryListFirstOption.click();
		WaitTool.hardWait();
		return new ProductListingPage(driver);	
	}

	public boolean isHDSupplyLogoDisplayed() 
	{
		CommonFunctions.scrollDown(driver);
		return hDSupplyLogo.isDisplayed();
	}

	public boolean isDisplayedshopByCategoryLinkText(){
		return CommonFunctions.isElementPresent(shopByCategoryLinkText);
	}

	public boolean isDisplayedheaderresourcesLinkText(){
		return CommonFunctions.isElementPresent(headerresourcesLinkText);
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
		CommonFunctions.scrolltoViewElement(viewOrderHistoryButton, driver);
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

	public boolean isDisplayedheaderWebsitehelpLinkText(){
		return CommonFunctions.isElementPresent(headerWebsitehelpLinkText);
	}

	public boolean isDisplayedsearchboxAboveHeaderEdit(){
		return CommonFunctions.isElementPresent(searchboxAboveHeaderEdit);
	}

	public void clickHeaderServiceLinkText() throws InterruptedException {
		//Thread.sleep(20000);
		WaitTool.waitForElement(driver, headerservicesLinkText);
		headerservicesLinkText.click();
		Thread.sleep(20000);
		driver.manage().timeouts().pageLoadTimeout(WaitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}

	public void clickHeaderOffersLinkText() throws InterruptedException {
		Thread.sleep(20000);
		WaitTool.waitForElement(driver, headeroffersLinkText);
		headeroffersLinkText.click();
		Thread.sleep(20000);
		driver.manage().timeouts().pageLoadTimeout(WaitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}

	public void clickHeaderResourcesLinkText() throws InterruptedException {
		Thread.sleep(20000);
		WaitTool.waitForElement(driver, headerresourcesLinkText);
		headerresourcesLinkText.click();
		Thread.sleep(20000);
		driver.manage().timeouts().pageLoadTimeout(WaitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}


	public void navigateBackToHomePage() {		
		driver.navigate().back();		
	}

	// Method to Verify for Left Navigation
	public boolean isDisplayedLeftNavigation(){
		return CommonFunctions.isElementPresent(leftNavImage);
	}

	// Method to Verify for Services
	public boolean isDisplayedServices(){
		return CommonFunctions.isElementPresent(flyoutServicesImage);
	}

	// Method to Verify for Resources
	public boolean isDisplayedResources(){
		return CommonFunctions.isElementPresent(flyoutResourcesImage);
	}

	// Method to Verify for Offers
	public boolean isDisplayedOffers(){
		return CommonFunctions.isElementPresent(flyoutOffersImage);
	}

	// Method to Verify for eCatalogs
	public boolean isDisplayedeCatalogs(){
		return CommonFunctions.isElementPresent(flyouteCatalogsImage);
	}

	//public BedBathTableLinens clickCategoryBedBathTableLinensLinkText() throws InterruptedException {
	public SubCategoryBedBathTableLinensPage clickCategoryBedBathTableLinensLinkText() throws InterruptedException {

		Thread.sleep(20000);
		WaitTool.waitForElement(driver, categoryBedBathTableLinensLinkText);
		categoryBedBathTableLinensLinkText.click();
		Thread.sleep(20000);
		driver.manage().timeouts().pageLoadTimeout(WaitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		return new SubCategoryBedBathTableLinensPage(driver);
	} 

	public SubCategoryCabinetsAndCounterTopsPage clickCategoryCabinetsCountertopsLink() throws InterruptedException {
		WaitTool.waitForElement(driver, categoryCabinetsCountertopsLinkText);
		categoryCabinetsCountertopsLinkText.click();
		driver.manage().timeouts().pageLoadTimeout(WaitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		return new SubCategoryCabinetsAndCounterTopsPage(driver);
	} 

	public CategoryDoorsAndMoldingPage clickCategoryDoorsMoldingLinkText() throws InterruptedException {
		Thread.sleep(20000);
		WaitTool.waitForElement(driver, categoryDoorsMoldingLinkText);
		categoryDoorsMoldingLinkText.click();
		Thread.sleep(20000);
		driver.manage().timeouts().pageLoadTimeout(WaitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		return new CategoryDoorsAndMoldingPage(driver);
	} 

	public CategoryElectricalPage clickCategoryElectricalLinkText() throws InterruptedException {
		Thread.sleep(20000);
		WaitTool.waitForElement(driver, categoryElectricalLinkText);
		categoryElectricalLinkText.click();
		Thread.sleep(20000);
		driver.manage().timeouts().pageLoadTimeout(WaitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		return new CategoryElectricalPage(driver);
	} 

	public CategoryElectronicsPage clickCategoryElectronicsLinkText() throws InterruptedException {
		Thread.sleep(20000);
		WaitTool.waitForElement(driver, categoryElectronicsLinkText);
		categoryElectronicsLinkText.click();
		Thread.sleep(20000);
		driver.manage().timeouts().pageLoadTimeout(WaitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		return new CategoryElectronicsPage(driver);
	} 

	public CategoryFitnessAndExercisePage clickCategoryFitnessExerciseLinkText() throws InterruptedException {
		Thread.sleep(20000);
		WaitTool.waitForElement(driver, categoryFitnessExerciseLinkText);
		categoryFitnessExerciseLinkText.click();
		Thread.sleep(20000);
		driver.manage().timeouts().pageLoadTimeout(WaitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		return new CategoryFitnessAndExercisePage(driver);
	} 


	//get Copy Right text
	public String getCopyRightText() {
		return copyRightText.getText().trim();
	}

	public String returnCopyRightText() {
		return getCopyRightText();
	}


	//Categories Page methods
	public CategoryPage clickHvacLinkText() throws InterruptedException {
		WaitTool.waitForElement(driver, categoryHvacLinkText);
		categoryHvacLinkText.click();
		WaitTool.waitFor(driver, true);
		return new CategoryPage(driver);
	}

	public CategoryPage clickJanitorialLinkText() throws InterruptedException {
		WaitTool.waitForElement(driver, categoryJanitorialLinkText);
		categoryJanitorialLinkText.click();
		WaitTool.waitFor(driver, true);
		return new CategoryPage(driver);

	}

	public CategoryPage clickLightingLinkText() throws InterruptedException {
		WaitTool.waitForElement(driver, categoryLightingLinkText);
		categoryLightingLinkText.click();
		WaitTool.waitFor(driver, true);
		return new CategoryPage(driver);

	}


	public CategoryPage clickOfficeSuppliesLinkText() throws InterruptedException {
		WaitTool.waitForElement(driver, categoryOfficeSuppliesLinkText);
		categoryOfficeSuppliesLinkText.click();
		WaitTool.waitFor(driver, true);
		return new CategoryPage(driver);

	}


	public CategoryPage clickPaintSupplieslLinkText() throws InterruptedException {
		WaitTool.waitForElement(driver, categoryPaintSuppliesLinkText);
		categoryPaintSuppliesLinkText.click();
		WaitTool.waitFor(driver, true);
		return new CategoryPage(driver);

	}


	public CategoryPage clickPlumbingLinkText() throws InterruptedException {
		WaitTool.waitForElement(driver, categoryPlumbingLinkText);
		categoryPlumbingLinkText.click();
		WaitTool.waitFor(driver, true);
		return new CategoryPage(driver);

	}


	public CategoryPage clickPoolSuppliesLinkText() throws InterruptedException {
		WaitTool.waitForElement(driver, categoryPoolSuppliesLinkText);
		categoryPoolSuppliesLinkText.click();
		WaitTool.waitFor(driver, true);
		return new CategoryPage(driver);

	}


	public CategoryPage clickPropertyMarketingLinkText() throws InterruptedException {
		WaitTool.waitForElement(driver, categoryPropertyMarketingLinkText);
		categoryPropertyMarketingLinkText.click();
		WaitTool.waitFor(driver, true);
		return new CategoryPage(driver);

	}


	public CategoryPage clickSafetyLinkLinkText() throws InterruptedException {
		WaitTool.waitForElement(driver, categorySafetyLinkText);
		categorySafetyLinkText.click();
		WaitTool.waitFor(driver, true);
		return new CategoryPage(driver);

	}


	public CategoryPage clickSignsLinkText() throws InterruptedException {
		WaitTool.waitForElement(driver, categorySignsLinkText);
		categorySignsLinkText.click();
		WaitTool.waitFor(driver, true);
		return new CategoryPage(driver);

	}

	public CategoryPage clickStorageLinkText() throws InterruptedException {
		WaitTool.waitForElement(driver, categoryStorageLinkText);
		categoryStorageLinkText.click();
		WaitTool.waitFor(driver, true);
		return new CategoryPage(driver);

	}

	public CategoryPage clickToolsLinkText() throws InterruptedException {
		WaitTool.waitForElement(driver, categoryToolsLinkText);
		categoryToolsLinkText.click();
		WaitTool.waitFor(driver, true);
		return new CategoryPage(driver);

	}

	public CategoryPage clickWindowCoveringsLinkText() throws InterruptedException {
		WaitTool.waitForElement(driver, categoryWindowCoveringsLinkText);
		categoryWindowCoveringsLinkText.click();
		WaitTool.waitFor(driver, true);
		return new CategoryPage(driver);

	}

	//Static Footer Page Methods
	public void clickAboutUsCareersLinkText() {

		WaitTool.waitForElement(driver, aboutUsCareersLinkText);
		aboutUsCareersLinkText.click();
	}

	public boolean isDisplayedAboutUsCareersLinkText(){

		return CommonFunctions.isElementPresent(aboutUsCareersLinkText);


	}

	public void clickAboutUsEnEspanolLinkText() {

		WaitTool.waitForElement(driver, aboutUsEnEspanolLinkText);
		aboutUsEnEspanolLinkText.click();
	}


	public void clickAboutUsContactUsLinkText() {

		WaitTool.waitForElement(driver, aboutUsContactUsLinkText);
		aboutUsContactUsLinkText.click();
	}

	public boolean isDisplayedAboutUsContactUsLinkText(){

		return CommonFunctions.isElementPresent(aboutUsContactUsLinkText);


	}

	public void clickAboutUsHDSupplyCanadalLinkText() {

		WaitTool.waitForElement(driver, aboutUsHDSupplyCanadalLinkText);
		aboutUsHDSupplyCanadalLinkText.click();
	}

	public boolean isDisplayedAboutUsHDSupplyCanadalLinkText(){

		return CommonFunctions.isElementPresent(aboutUsHDSupplyCanadalLinkText);


	}

	public void clickAboutUsLocationsLinkText() {

		WaitTool.waitForElement(driver, aboutUsLocationsLinkText);
		aboutUsLocationsLinkText.click();
	}

	public boolean isDisplayedAboutUsLocationsLinkText(){

		return CommonFunctions.isElementPresent(aboutUsLocationsLinkText);


	}

	public void clickAboutUsOurCompanyLinkText() {

		WaitTool.waitForElement(driver, aboutUsOurCompanyLinkText);
		aboutUsOurCompanyLinkText.click();
	}

	public boolean isDisplayedAboutUsOurCompanyLinkText(){

		return CommonFunctions.isElementPresent(aboutUsOurCompanyLinkText);


	}

	public void clickHelpAccountChangeRequestLinkText() {

		WaitTool.waitForElement(driver, helpAccountChangeRequestLinkText);
		helpAccountChangeRequestLinkText.click();
	}

	public boolean isDisplayedHelpAccountChangeRequestLinkText(){

		return CommonFunctions.isElementPresent(helpAccountChangeRequestLinkText);


	}

	/**
	 * Click on Account Icon
	 *
	 */
	public void clickAccountIcon() {
		accountIcon.click();

	}

	/**
	 * Click on Account link on Header
	 * @return the driver to My Account Page
	 */
	public MyAccountPage clickAccountLinkText() {
		clickAccountIcon();
		WaitTool.waitForElement(driver, accountLinkText);
		accountLinkText.click();
		return new MyAccountPage(driver);

	}

	public void clickLogoutLinkText() {
		//WaitTool.waitFor(driver, true);
		clickAccountIcon();
		WaitTool.waitForElement(driver, signOutLinkText);
		signOutLinkText.click();


	}



	/**
	 * @description: //Method to click on accountSignOutIcon
	 * @return void
	 */
	public void clickAccountSignOutIcon() throws InterruptedException {
		WaitTool.waitForElement(driver, accountIcon);
		accountIcon.click();
		WaitTool.waitFor(driver, true);
		signOutLinkText.click();

	}

	public LoginPage clickOnSignOutIcon() throws Exception {
		WaitTool.waitForElement(driver, accountIcon);
		accountIcon.click();
		WaitTool.waitFor(driver, true);
		signOutLinkText.click();
		CommonFunctions.acceptPopupMessageBox(driver);
		WaitTool.hardWait();
		return new LoginPage(driver);

	}
	
	/**
	 * Method to logout of application
	 * @throws Exception 
	 */
	public void logoutOfApplication() 
	{
		accountIcon.click();
		WaitTool.waitForElement(driver, signOutLinkText);
		signOutLinkText.click();
		CommonFunctions.acceptPopupMessageBox(driver);
	}

	public void clickHelpApplyforCreditlLinkText() {

		WaitTool.waitForElement(driver, helpApplyforCreditlLinkText);
		helpApplyforCreditlLinkText.click();
	}

	public boolean isDisplayedHelpApplyforCreditlLinkText(){

		return CommonFunctions.isElementPresent(helpApplyforCreditlLinkText);


	}

	public void clickHelpFaqlLinkText() {

		WaitTool.waitForElement(driver, helpFaqlLinkText);
		helpFaqlLinkText.click();
	}

	public boolean isDisplayedHelpFaqlLinkText(){

		return CommonFunctions.isElementPresent(helpFaqlLinkText);


	}

	public void clickHelpForgotPasswordLinkText() {

		WaitTool.waitForElement(driver, helpForgotPasswordLinkText);
		helpForgotPasswordLinkText.click();
	}

	public boolean isDisplayedHelpForgotPasswordLinkText(){

		return CommonFunctions.isElementPresent(helpForgotPasswordLinkText);


	}

	public void clickHelpNewWebsiteFeaturesLinkText() {

		WaitTool.waitForElement(driver, helpNewWebsiteFeaturesLinkText);
		helpNewWebsiteFeaturesLinkText.click();
	}

	public boolean isDisplayedHelpNewWebsiteFeaturesLinkText(){

		return CommonFunctions.isElementPresent(helpNewWebsiteFeaturesLinkText);


	}

	public void clickHelpSiteMapLinkText() {

		WaitTool.waitForElement(driver, helpSiteMapLinkText);
		helpSiteMapLinkText.click();
	}


	public boolean isDisplayedHelpSiteMapLinkText(){

		return CommonFunctions.isElementPresent(helpSiteMapLinkText);


	}

	public void clickReturnsFormLinkText() {

		WaitTool.waitForElement(driver, returnsFormLinkText);
		returnsFormLinkText.click();
	}

	public boolean isDisplayedReturnsFormLinkText(){

		return CommonFunctions.isElementPresent(returnsFormLinkText);


	}

	public void clickReturnPolicyLinkText() {

		WaitTool.waitForElement(driver, returnPolicyLinkText);
		returnPolicyLinkText.click();
	}

	public boolean isDisplayedReturnPolicyLinkText(){

		return CommonFunctions.isElementPresent(returnPolicyLinkText);


	}

	public void clickTermsAndPoliiciesCaliforniaPrivacyLinkText() {

		WaitTool.waitForElement(driver, termsAndPoliiciesCaliforniaPrivacyLinkText);
		termsAndPoliiciesCaliforniaPrivacyLinkText.click();
	}

	public boolean isDisplayedTermsAndPoliiciesCaliforniaPrivacyLinkText(){

		return CommonFunctions.isElementPresent(termsAndPoliiciesCaliforniaPrivacyLinkText);


	}

	public void clickTermsAndPoliiciesFinePrintCatalogIconsLinkText() {

		WaitTool.waitForElement(driver, termsAndPoliiciesFinePrintCatalogIconsLinkText);
		termsAndPoliiciesFinePrintCatalogIconsLinkText.click();
	}

	public boolean isDisplayedTermsAndPoliiciesFinePrintCatalogIconsLinkText(){

		return CommonFunctions.isElementPresent(termsAndPoliiciesFinePrintCatalogIconsLinkText);


	}

	public void clickTermsAndPoliiciesPrivacyPolicyLinkText() {

		WaitTool.waitForElement(driver, termsAndPoliiciesPrivacyPolicyLinkText);
		termsAndPoliiciesPrivacyPolicyLinkText.click();
	}

	public boolean isDisplayedTermsAndPoliiciesPrivacyPolicyLinkText(){

		return CommonFunctions.isElementPresent(termsAndPoliiciesPrivacyPolicyLinkText);


	}

	public void clickTermsAndPoliiciesPrivacyStatementLinkText() {

		WaitTool.waitForElement(driver, termsAndPoliiciesPrivacyStatementLinkText);
		termsAndPoliiciesPrivacyStatementLinkText.click();
	}

	public boolean isDisplayedTermsAndPoliiciesPrivacyStatementLinkText(){

		return CommonFunctions.isElementPresent(termsAndPoliiciesPrivacyStatementLinkText);


	}


	public void searchclick(){
		searchBoxButton.click();

	}

	public void clickTermsAndPoliiciesTermsofSaleLink() {

		WaitTool.waitForElement(driver, termsAndPoliiciesTermsofSaleLinkText);
		termsAndPoliiciesTermsofSaleLinkText.click();
	}

	public boolean isDisplayedTermsAndPoliiciesTermsofSaleLinkText(){
		return CommonFunctions.isElementPresent(termsAndPoliiciesTermsofSaleLinkText);
	}



	/**
	 * @name verifyexploreHDSupplyDropDownOptions
	 * @description Method to verify presence of exploreHDSupplyDropDown1 below category left navigation
	 *  @return boolean match
	 */
	public boolean isDisplayedexploreHDSupplyDropDown(){
		return CommonFunctions.isElementPresent(exploreHDSupplyDropDown1);
	}

	public void clickTermsAndPoliiciesTermsOfUseLinkText() {

		WaitTool.waitForElement(driver, termsAndPoliiciesTermsOfUseLinkText);
		termsAndPoliiciesTermsOfUseLinkText.click();
	}

	public boolean isDisplayedTermsAndPoliiciesTermsOfUseLinkText(){

		return CommonFunctions.isElementPresent(termsAndPoliiciesTermsOfUseLinkText);


	}


	public boolean isDisplayedHeaderOrderAgain(){
		return CommonFunctions.isElementPresent(headerOrderAgain);
	}

	//Method to verify presence of header resources
	public boolean isDisplayedHeaderResourcesLinkText(){
		return CommonFunctions.isElementPresent(headerresourcesLinkText);
	}

	//Method to verify presence of header offers
	public boolean isDisplayedHeaderOffersLinkText(){
		return CommonFunctions.isElementPresent(headeroffersLinkText);
	}

	//Method to verify presence of RegisterOrSignIn	
	public boolean isDisplayedRegisterOrSignIn(){
		return CommonFunctions.isElementPresent(registerOrSignInLinkText);
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

	//Method to Click on Quotes in utility bar
	public QuotesPage clickQuotesUtilityBar() throws InterruptedException {
		WaitTool.waitForElement(driver,	topHeaderquotesLinkText);
		topHeaderquotesLinkText.click();
		WaitTool.waitFor(driver, true);
		return new QuotesPage(driver);
	}

	//Method to Click on SavedList in utility bar {once clicked not sure to which its navigated.)
	public SavedListsPage clickSavedListUtilityBar() throws InterruptedException {
		WaitTool.waitForElement(driver,	topHeadersavedlistLinkText);
		topHeadersavedlistLinkText.click();
		WaitTool.waitFor(driver, true);
		return new SavedListsPage(driver);
	}

	/**
	 * Click oon the account in my accounts.
	 * @return the signed in user name text
	 */
	public MyAccountPage clickAccount() throws InterruptedException {
		WaitTool.waitForElement(driver, account);
		account.click();
		WaitTool.waitFor(driver, true);
		return new MyAccountPage(driver);

	}

	/**
	 * @return the signed in user name text
	 */
	public String getUserSignedInUser() {

		return userSignedInUserText.getText().trim();
	}


	/**
	 * @return the Account number of the user
	 */
	public String getUserAccountNumber() {

		return userAccountNumberText.getText().trim();
	}

	/**
	 * @return true if property dropdown is displayed on header otherwise false
	 */
	public Boolean isDisplayedPropertyDropdown() {
		return CommonFunctions.isElementPresent(propertyDropdown);
	}

	/**
	 * click on property dropdown on header
	 * @return the driver to Property lookup page
	 */
	public PropertyLookupPage clickPropertyDropdown() {
		CommonFunctions.scrolltoViewElement(propertyDropdown, driver);
		propertyDropdown.click();
		return new PropertyLookupPage(driver);
	}

	/**
	 * @return the user Account name
	 */
	public String getUserAccountName() {
		return propertyDropdown.getText().trim();
	}

	/**
	 * @return true if Content Heros is present in homepage otherwise false
	 */
	public boolean isDisplayedContentHeros()
	{
		CommonFunctions.scrolltoViewElement(contentHeros1, driver);
		return contentHeros1.isEnabled();

	}

	/** 
	 * @return true if static website help label is present in utility bar otherwise false
	 */
	public Boolean isDisplayedStaticWebsiteHelpLabel() {
		return CommonFunctions.isElementPresent(WebsiteHelpLabel);
	}

	/** 
	 * @return true if static website help Phone number is present in utility bar otherwise false
	 */
	public Boolean isDisplayedStaticWebsiteHelpPhoneNumber() {
		return CommonFunctions.isElementPresent(WebsiteHelpPhoneNumberText);
	}

	/** 
	 * @return true if static website help hours is present in utility bar otherwise false
	 */
	public Boolean isDisplayedStaticWebsiteHelpTime() {
		return CommonFunctions.isElementPresent(WebsiteHelpTimeText);
	}

	/**
	 * click on My Account Quotes quick link
	 * @return the driver to Quotes Page
	 */
	public QuotesPage clickMyAccountQuotesQuickLink(){
		WaitTool.waitForElement(driver, myAccountQuotesQuickLink);
		myAccountQuotesQuickLink.click();
		WaitTool.waitFor(driver, true);
		return new QuotesPage(driver);
	}

	/** 
	 * @return true if My account Quotes quick link is displayed on homepage otherwise false
	 */
	public boolean isDisplayedMyAccountQuotesQuickLinkInUtilityBar(){
		return myAccountQuotesQuickLink.isDisplayed();
	}

	/**
	 * click on My Account Subscriptions quick link
	 * @return the driver to Saved Lists Page
	 */
	public SubscriptionsPage clickMyAccountSubscriptionsQuickLink(){
		WaitTool.waitForElement(driver, myAccountSubscriptionsQuickLink);
		myAccountSubscriptionsQuickLink.click();
		WaitTool.waitFor(driver, true);
		return new SubscriptionsPage(driver);
	}

	/** 
	 * @return true if My account Subscriptions quick link is displayed on homepage otherwise false
	 */
	public boolean isDisplayedMyAccountSubscriptionsQuickLinkInUtilityBar(){
		return myAccountSubscriptionsQuickLink.isDisplayed();
	}

	/**
	 * click on My Account Saved Lists quick link
	 * @return the driver to Saved Lists Page
	 */
	public SavedListsPage clickMyAccountSavedListsQuickLink(){
		CommonFunctions.scrolltoViewElement(myAccountSavedListsQuickLink, driver);
		myAccountSavedListsQuickLink.click();
		return new SavedListsPage(driver);
	}

	/** 
	 * @return true if My account Saved Lists quick link is displayed on homepage otherwise false
	 */
	public boolean isDisplayedMyAccountSavedListsQuickLinkInUtilityBar(){
		return myAccountSavedListsQuickLink.isDisplayed();
	}

	/**
	 * click on My Account Frequently Purchased quick link
	 * @return the driver to Frequently Purchased Page
	 */
	public FrequentlyPurchasedPage clickMyAccountFrequentlyPurchasedQuickLink(){
		WaitTool.waitForElement(driver, myAccountFrequentlyPurchasedQuickLink);
		myAccountFrequentlyPurchasedQuickLink.click();
		WaitTool.waitFor(driver, true);
		return new FrequentlyPurchasedPage(driver);
	}

	/** 
	 * @return true if My account Frequently Purchased quick link is displayed on homepage otherwise false
	 */
	public boolean isDisplayedMyAccountFrequentlyPurchasedQuickLinkInUtilityBar(){
		return myAccountFrequentlyPurchasedQuickLink.isDisplayed();
	}

	/**
	 * click on My Account  Order History & Status quick link
	 * @return the driver to rder History & Status Page
	 */
	public OrderHistoryAndStatusPage clickMyAccountOrderHistoryAndStatusQuickLink(){
		WaitTool.waitForElement(driver, myAccountOrderHistoryAndStatusQuickLink);
		myAccountOrderHistoryAndStatusQuickLink.click();
		WaitTool.waitFor(driver, true);
		return new OrderHistoryAndStatusPage(driver);
	}

	/** 
	 * @return true if My account Order History & Status quick link is displayed on homepage otherwise false
	 */
	public boolean isDisplayedMyAccountOrderHistoryQuickLinkInUtilityBar(){
		return myAccountOrderHistoryAndStatusQuickLink.isDisplayed();
	}

	/**
	 * @return true if Category Left navigation is present on homepage otherwise false
	 */
	public boolean isDisplayedCategoryleftNavigation() {
		return CommonFunctions.isElementPresent(CategoryApplianceLeftNavigationLinkText);
	}

	//Method to verify presence of Search box in header
	public boolean isDisplayedSearchBoxText(){
		return CommonFunctions.isElementPresent(searchBoxText);
	}

	//Method to enter items in Search box
	public void enterSearchEdit(String partNumber) {
		searchEdit.clear();
		searchEdit.sendKeys(partNumber);
	}

	public Boolean isOrderAgainDisplayed()
	{
		CommonFunctions.scrollDown(driver);
		return orderAgainLabel.isDisplayed();
	}


	/**clickHeaderMyCartLinkTextAfterAddTocart
	 * click on my cart link test
	 *
	 */
	public void clickHeaderMyCartLinkTextAfterAddTocart() throws Exception {
		WaitTool.waitForElement(driver, headerMyCartLinkText);
		headerMyCartLinkText.click();
		WaitTool.waitFor(driver, true);
		//return new MinicartPage();
	}

	public Boolean isViewOrderHistoryButtonDisplayed()
	{
		CommonFunctions.scrollDown(driver);
		return viewOrderHistoryButton.isDisplayed();
	}

	public boolean isDisplayedHDSPopularProductsCarousel(){
		return hdsPopularProductsCarousel.isDisplayed();
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

	public ProductDetailsPage clickOnFirstProductInsideOrderOnceSection()
	{
		firstProductInsideOrderOnceSection.click();
		return new ProductDetailsPage(driver);
	}

	public MyAccountPage moveToMyAccountPage() throws Exception
	{	
		CommonFunctions.scrolltoViewElement(logo, driver);
		logo.click();
		WaitTool.hardWait();
		CommonFunctions.scrolltoViewElement(myAccountButton, driver);
		myAccountButton.click();
		return new MyAccountPage(driver);
	}

	/**clickHeaderMyCartLinkTextAfterAddTocart
	 *Method to Click on MyCartLinkText in Header	
	 */
	/*public MinicartPage clickHeaderMyCartLinkText() throws Exception {
		WaitTool.waitForElement(driver, headerMyCartLinkText);
		headerMyCartLinkText.click();
		WaitTool.waitFor(driver, true);
		return new MinicartPage(driver);

	}*/
	public ShoppingCartPage clickHeaderMyCartLinkText() throws Exception {
		WaitTool.waitForElement(driver, headerMyCartLinkText);
		headerMyCartLinkText.click();
		WaitTool.waitFor(driver, true);
		return new ShoppingCartPage(driver);

	}

	public void clickHeaderOrderAgain() throws InterruptedException {
		WaitTool.waitForElement(driver, headerOrderAgain);
		headerOrderAgain.click();
		WaitTool.waitFor(driver, true);
		//return new Appliances();
		//return null;
	}

	//Method to Click on frequently purchased in utility bar
	public FrequentlyPurchasedPage clickFrePurchasedUtilityBar() throws InterruptedException {
		WaitTool.waitForElement(driver,	topHeaderfreqPurchasedLinkText);
		topHeaderfreqPurchasedLinkText.click();
		WaitTool.waitFor(driver, true);
		return new FrequentlyPurchasedPage(driver);
	}

	//Method to Click on order history link in utility bar
	public void clickFrePurchasSavedHistoryUtilityBar() throws InterruptedException {
		WaitTool.waitForElement(driver,	topHeaderorderHisStatusLinkText);
		topHeaderorderHisStatusLinkText.click();
		WaitTool.waitFor(driver, true);
	}

	public String returnWelcomeNote() {
		return getWelcomeNote();
	}



	//Method to click on category appliances.
	public Appliances clickCategoryAppliancesLinkText() throws Exception {
	/*	WaitTool.waitForElement(driver,	categoryAppliancesLinkText);
		//WaitTool.hardWait();
		this.categoryAppliancesLinkText.click();
		WaitTool.waitFor(driver, true);*/
		WaitTool.hardWait();
		CommonFunctions.scrolltoViewElement(categoryAppliancesLinkText, driver);
		categoryAppliancesLinkText.click();
		return new Appliances(driver);
	} 

	public CategoryAppliancesPage clickCategoryAppliancessLinkText() throws Exception {
		WaitTool.waitForElement(driver,	categoryAppliancesLinkText);
		//WaitTool.hardWait();
		categoryAppliancesLinkText.click();
		WaitTool.waitFor(driver, true);
		return new CategoryAppliancesPage(driver);
	} 

	//Method to click on search button
	public SearchResultPage clickSearchButton() throws InterruptedException {
		WaitTool.waitForElement(driver,	searchBoxButton);
		searchBoxButton.click();
		WaitTool.waitFor(driver, true);
		return new SearchResultPage(driver);
	}

	//Method to click on search button
	public ProductDetailsPage clickSearchButtonInHomePage() throws InterruptedException {
		WaitTool.waitForElement(driver,	searchBoxButton);
		searchBoxButton.click();
		WaitTool.waitFor(driver, true);
		return new ProductDetailsPage(driver);
	}

	/**
	 * @name verifyBreadCrumbForCurrentPage
	 * @description Method to verify BreadCrumb For CurrentPage
	 * @param text value (current page)
	 * @return boolean match
	 * 
	 *//*	
	public boolean clickOnCategories(String categoryname) throws InterruptedException {		
		driver.findElement(By.partialLinkText(categoryname)).click();
		return 
	}
	  */
	/**
	 * @name verifyBreadCrumbForCurrentPage
	 * @description Method to verify BreadCrumb For CurrentPage
	 * @param text value (current page)
	 * @return boolean match
	 * 
	 */

	public boolean verifyBreadCrumbForCurrentPage(String subCategoryname) throws InterruptedException {		
		String[] breadCrumb = currentPagebreadCrumbHomeLinkText.getText().split("/");
		if(breadCrumb[breadCrumb.length-1].equalsIgnoreCase(subCategoryname)) {
			return false;
		}
		return true;
	}


	/**
	 * @name verifyexploreHDSupplyDropDownOptions
	 * @description Method to verify dropdown options of exploreHDSupplyDropDown
	 * @param String list
	 * @return boolean match
	 * 
	 */
	public boolean verifyexploreHDSupplyDropDownOptions(String drpDownList) throws Exception{
		List<WebElement> accountLabelsList=CommonFunctions.selectDropdownOptions(driver, exploreHDSupplyDropDown);	
		System.out.println(drpDownList);
		String[] colonArray = drpDownList.split(":");
		boolean match = false;		
		for (WebElement we : accountLabelsList) {
			for (int i = 0; i < colonArray.length; i++) {
				if (we.getText().equalsIgnoreCase(colonArray[i])) {
					match = true;
				}
			}
		}
		return match;
	}


	/**
	 * @name selectOptionsFromIndustryTypeDowndown
	 * @description Method to click on option from the industry dropdown.
	 * @param WebElement List
	 * @return 
	 * 
	 */
	public void selectOptionsFromIndustryTypeDowndown(List<WebElement> accountLabelsList) throws InterruptedException {
		accountLabelsList = CommonFunctions.selectDropdownOptions(driver, exploreHDSupplyDropDown);
		CommonFunctions.scrolltoViewElement(exploreHDSupplyDropDown, driver);
		exploreHDSupplyDropDown.click();
		System.out.print(accountLabelsList.get(1).getText());
		CommonFunctions.selectSearchDropdown1(exploreHDSupplyDropDown, accountLabelsList.get(1).getText());
	}




	/**
	 * @name enterDataForSearch
	 * @description Method to enter data in search box.Searchdata taken from input file.
	 * @param String
	 * @return 
	 * 
	 */	
	public void enterDataForSearch(String searchData) {
		searchBoxText.sendKeys(searchData);		
	}

	/**
	 * @name isDisplayedsearchSuggestedProducts
	 * @description Method to verify presence of searchSuggestedProducts .
	 * @param 
	 * @return 
	 * 
	 */	
	public boolean isDisplayedsearchSuggestedProducts(){
		return CommonFunctions.isElementPresent(searchSuggestedProductsHeader);		
	}

	/**
	 * @name isDisplayedsearchSuggestedProducts
	 * @description Method to verify presence of searchSuggestedProducts list
	 * @param String
	 * @return Boolean
	 * 
	 */	
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

	//Method to verify presence of Content recommendation order again
	public boolean isDisplayedOrderAgainContentRecommandation(){
		return CommonFunctions.isElementPresent(OrderAgainContentRecommandation);
	}


	/**
	 * @name clickOnSuggestedSearchResult
	 * @description Method to Click on first suggested search result.
	 * @param 
	 * @return page
	 * 
	 */	

	public ProductDetailsPage clickOnSuggestedSearchResult() throws Exception{
		WaitTool.hardWait();
		suggestedProductsResultsList.get(0).click();
		WaitTool.waitFor(driver, true);
		return new ProductDetailsPage(driver);		
	}


	public QuickOrderPad clickOnQuickOrderLink() 
	{
		headerQuickOrderLinkText.click();
		return new QuickOrderPad(driver);		
	}
	
	/**
	 * @name clearDatainSearchBox
	 * @description Method to clear the contents in search box.
	 * @param 
	 * @return 
	 * 
	 */	
	public void clearDatainSearchBox(){
		searchBoxText.clear();					
	}

	/**
	 * @name isDisplayedsearchAdvanceSearch
	 * @description Method to verify presence of searchAdvanceSearch
	 * @param 
	 * @return 
	 * 
	 */	
	public boolean isDisplayedsearchAdvanceSearch(){
		return CommonFunctions.isElementPresent(searchAdvanceSearch);		

	}

	// Method to Verify HD Logo
	public boolean isDisplayedHeaderHDLogoImage(){
		return CommonFunctions.isElementPresent(headerHDLogoImage);
	}

	// Method to click on HDLogo in any of the Pages
	public void clickHeaderHDLogoImage() throws InterruptedException {
		headerHDLogoImage.click();
	}        





	/**	// Method to Click on Shop By Category in Header	
		public void clickHeaderShopByCategoryLinkText() throws InterruptedException {
			 Thread.sleep(10000);
				WaitTool.waitForElement(driver, headerShopByCategoryLinkText);
				headerShopByCategoryLinkText.click();
				Thread.sleep(10000);
				driver.manage().timeouts().pageLoadTimeout(WaitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

			} */
	/*	//Bhavani commented this
	public String fetchDataFromExcel() throws Exception {
		DBCon dbConnection = new DBCon();
		String userName = dbConnection.loadColdataFromExcel("verifyDisplayHeaderAuthenticateduser", 1);//loadColdataFromExcel
		return userName;

	}

	public boolean usernameVerificationAfterLogin() throws Exception {
		return fetchDataFromExcel().equalsIgnoreCase(displayedUserName.getText());
	}

	public boolean isDisplayedMinicartPopup() throws InterruptedException {

		clickMiniShopCart();
		return CommonFunctions.isElementPresent(miniShopCartPopup);
	}
	 */


	public SearchPage searchByPartNumber(String partNumber)
	{
		searchBox.sendKeys(partNumber);
		searchButton.click();
		return new SearchPage(driver);		
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
	
	public ProductListingPage searchDescription(String keyword)
	{
		searchBox.sendKeys(keyword);
		searchButton.click();
		return new ProductListingPage(driver);		
	}
	

	public OfferPage isMovetoOfferPage()
	{
		offerLink.click();
		return new OfferPage(driver);
	}

	public Boolean isResourceFlyoutDisplayed()
	{
		resourcesLink.click();
		return resourcesFlyout.isDisplayed();
	}

	public EcatalogPage isMovetoECatalogPage()
	{
		eCatalogLink.click();
		return new EcatalogPage(driver);
	}

	/*public void clickOnQuickOrderLink()
	{
		quickOrderLink.click();
	}
	 */

	public LoginPage clickOnregisterOrSignInLink()
	{
		registerOrSignInLinkText.click();
		return new LoginPage(driver);
	}


	public boolean isDisplayedQuotesLinkTextOnAccountHighlites(){
		return CommonFunctions.isElementPresent(QuotesUnderAccHighlightSec);
	}
	public boolean isDisplayedSavedListsLinkTextOnAccountHighlites(){
		return CommonFunctions.isElementPresent(SavedListUnderAccHighlightSec);
	}
	public boolean isDisplayedFrequentOrdersLinkTextOnAccountHighlites(){
		return CommonFunctions.isElementPresent(QuotesUnderAccHighlightSec);
	}
	public boolean isDisplayedOrderHistoryLinkTextOnAccountHighlites(){
		return CommonFunctions.isElementPresent(QuotesUnderAccHighlightSec);
	}

	/**
	 * @name selectOptionsFromIndustryTypeDowndown
	 * @description Method to click on option from the industry dropdown.
	 * @param WebElement List
	 */
	public void selectOptionsFromIndustryTypeDowndown(String option) throws InterruptedException {
		//accountLabelsList = CommonFunctions.selectDropdownOptions(driver, exploreHDSupplyDropDown);
		CommonFunctions.scrolltoViewElement(exploreHDSupplyDropDown, driver);
		exploreHDSupplyDropDown.click();
		System.out.print("option to select" +option);
		CommonFunctions.selectSearchDropdown1(exploreHDSupplyDropDown, option);
	}

	// Method to Click on Shopping Cart	
	public ShoppingCartPage clickShoppingCartCheckOutButton() throws InterruptedException {
		WaitTool.waitForElement(driver, shoppingCartCheckOutButton);
		shoppingCartCheckOutButton.click();
		//WaitTool.waitFor(driver,true) ;
		return new ShoppingCartPage(driver);

	}


	/*
	public MinicartPage clickOnShoppingCartIcon() throws Exception {
		WaitTool.hardWait();
		shoppingCartIcon.click();
		return new MinicartPage(driver);
	}*/
	public ShoppingCartPage clickOnShoppingCartIcon() throws Exception 
	{
		
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 5000);
		wait.until(ExpectedConditions.visibilityOf((shoppingCartIcon)));
		System.out.println("inside clickOnShoppingCartIcon");
		CommonFunctions.scrolltoViewElement(shoppingCartIcon, driver);
		System.out.println("scrolltoViewElement");
		WaitTool.hardWait();
		WaitTool.hardWait();
		shoppingCartIcon.click();
		System.out.println("scrolltoViewElement.click");
		return new ShoppingCartPage(driver);
	}

	public void mouseHooverOnShoppingCartIcon() throws Exception{
		WaitTool.hardWait();
		CommonFunctions.mouseHover(driver, shoppingCartIcon);
	}


	/**
	 * @author nm064123
	 * @description: Method to validate contentHeros display
	 * @return if displayed returns true else false
	 */
	/*	public boolean isDisplayedContentHero() {
		if (contentHeros.isDisplayed()||contentHeros2.isDisplayed()||contentHeros3.isDisplayed()) {
			return true;
		}
		return false;

	}*/

	public Boolean isContentHero1Displayed()
	{
		CommonFunctions.scrolltoViewElement(contentHeros1, driver);
		return contentHeros1.isDisplayed();
	}

	public Boolean isContentHero2Displayed()
	{
		CommonFunctions.scrolltoViewElement(contentHeros2, driver);
		return contentHeros2.isDisplayed();
	}

	public Boolean isContentHero3Displayed()
	{
		CommonFunctions.scrolltoViewElement(contentHeros3, driver);
		return contentHeros3.isDisplayed();
	}

	/**  Method to click on Category or subcategory. {applicable for left navigation and shopByCategory]
	 * @param driver
	 * @param String (Category or Subcategoryname)
	 */
	public void clickOnCategoryOrSubcategory(WebDriver driver,String data,Boolean shopByCategoryPresent ) throws Exception {
		data.toLowerCase();
		WordUtils.capitalize(data);
		String xpath = "//div[contains(text(),";
		String xpath1 = "//div[@class='nav__shop-by-category']//li/a[text()=";
		if (shopByCategoryPresent==true)
			driver.findElement(By.xpath(xpath1 + "'" + data + "']")).click();  
		else{
			if(CommonFunctions.isElementPresent(driver,By.linkText(data))) 
				driver.findElement(By.linkText(data)).click();   
			else if(CommonFunctions.isElementPresent(driver,By.xpath(xpath + "'" + data + "')]")))
				driver.findElement(By.xpath(xpath + "'" + data + "')]")).click(); 
		}
	} 


	public ShoppingCartPage clickViewCartButton() throws InterruptedException {
		miniCartIcon.click();
		Thread.sleep(2000);
		Actions action = new Actions(driver);
		action.moveToElement(viewCartButton).click().build().perform();
		return new ShoppingCartPage(driver) ;

	}

	public ShoppingCartPage clickViewCart(){
		viewCartButton.click();
		return new ShoppingCartPage(driver);
	}

	/**
	 * Methods to click on category,subcategories to reach product list page 
	 * (applicable if user is trying to reach productlist page by left navigation or by shop by category)
	 * @param driver
	 * @param String (Categeory name),String (l1 subcategory name),String (l2 subcategory name)
	 * @return ProductPage
	 */
	public ProductListingPage clickonCategoriesToreachProductList(WebDriver driver,String category,String l1subCategory,String l2subCategory ) throws Exception {
		Boolean shopByCategoryPresent = false;    	
		if(CommonFunctions.isElementPresent(driver.findElement(By.xpath("//div[@class='nav__shop-by-category']/nav")))) 
			shopByCategoryPresent = true;         	
		clickOnCategoryOrSubcategory(driver,category,shopByCategoryPresent);
		clickOnCategoryOrSubcategory(driver,l1subCategory,shopByCategoryPresent);
		clickOnCategoryOrSubcategory(driver,l2subCategory,shopByCategoryPresent);	
		return new ProductListingPage(driver);
	}


	/**
	 * @author nm064123
	 * @description: Method to validate video espots display
	 * @return true if videoeSpot1 is displayed else false
	 */
	public boolean isDisplayedVideoeSpot1() {
		return videoESpot1.isDisplayed();

	}


	/**
	 * @author nm064123
	 * @description: Method to validate video espots display
	 * @return true if videoeSpot2  is displayed else false
	 */
	public boolean isDisplayedVideoeSpot2() {
		return videoESpot2.isDisplayed();

	}

	/**
	 * @author nm064123
	 * @description: Method to validate topCategoriessection display
	 * @return true if topCategories section is displayed else false
	 */

	public boolean isDisplayedtopCategoriesCarouselSection() {
		CommonFunctions.scrollDown(driver);
		CommonFunctions.scrollDown(driver);
		CommonFunctions.scrolltoViewElement(topCategoriesCarouselSection, driver);
		return topCategoriesCarouselSection.isDisplayed();

	}


	/**
	 * @author nm064123
	 * @description: Method to validate product recomendations section display
	 * @return true if recomendations section is displayed else false
	 */
	public boolean isDisplayedRRBRCarouselSection() {
		CommonFunctions.scrollDown(driver);
		CommonFunctions.scrollDown(driver);
		CommonFunctions.scrollDown(driver);
		CommonFunctions.scrollDown(driver);
		return rrBRCarouselSection.isDisplayed();

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

	// The below function verifyLink(String urlLink) verifies any broken links and return the server status. 
	public void verifyLink(String url) {

		//Sometimes we may face exception "java.net.MalformedURLException". Keep the code in try catch block to continue the broken link analysis

		try {
			//Use URL Class - Create object of the URL Class and pass the urlLink as parameter 
			URL link = new URL(url);

			// Create a connection using URL object (i.e., link)
			HttpURLConnection httpConn =(HttpURLConnection)link.openConnection();



			//Set the timeout for 2 seconds
			httpConn.setConnectTimeout(2000);

			//connect using connect method
			httpConn.connect();

			//use getResponseCode() to get the response code. 

			if(httpConn.getResponseCode()== 400) {
				//System.out.println(urlLink+" - "+httpConn.getResponseMessage());
				// System.out.println("Bad request!Error code: 400 It's not you, it's us. This link appears to be broken and needs fixing.");
			}

		}
		//getResponseCode method returns = IOException - if an error occurred connecting to the server. 

		catch (Exception e) {
			//e.printStackTrace();


		}}


	public void clickAddToCartButtonOfFirstProductListView()
	{
		addToCartButtonOfFirstProductListView.click();
	}



	public void clickAddToCartButtonOfFirstProduct()
	{
		addToCartButtonOfFirstProduct.click();
	}



	public boolean cartOverlayDisplayed() {
		return cartOverlay.isDisplayed();

	}



	public void clickCartOverlayCheckoutButton()
	{
		cartOverlayCheckoutButton.click();
	}



	public void clickGridViewIcon()
	{
		gridViewIcon.click();

	}



	public boolean isSignInPagePresent(){
		return CommonFunctions.isElementPresent(signInPage);
	}


	public void enterUserName(String username) {
		usernameField.clear();
		usernameField.sendKeys(username);
	}

	public void enterPassword(String password) {
		passwordField.clear();
		passwordField.sendKeys(password);
	}

	public void clickSignInButton() {
		signInButton.click();
	}

	public void loginFromSignInPage(String username, String password) {
		enterUserName(username);
		enterPassword(password);
		clickSignInButton();
		WaitTool.waitFor(driver, true);
	}

	/**
	 * @author nm064123
	 * Method to click input search by category name and pass to generic search results page
	 */

	public CategorySearchPage searchByCategoryName(String keyword)
	{
		searchBox.sendKeys(keyword);
		searchButton.click();
		return new CategorySearchPage(driver);		
	}

	public boolean heroImageCarousel(){
		return heroImageCarousel.isDisplayed();
	}

	public boolean IsHeroImageCarouselOneDisplayed() throws Exception
	{
		firstRadioButtonInsidePageControlPanel.click();
		WaitTool.hardWait();
		return heroImageCarouselOne.isDisplayed();
	}

	public boolean IsHeroImageCarouselTwoDisplayed() throws Exception
	{
		secondRadioButtonInsidePageControlPanel.click();
		WaitTool.hardWait();
		return heroImageCarouselTwo.isDisplayed();
	}

	public boolean IsHeroImageCarouselThreeDisplayed() throws Exception
	{
		thirdRadioButtonInsidePageControlPanel.click();
		WaitTool.hardWait();
		return heroImageCarouselThree.isDisplayed();
	}

	public boolean isDisplayedPromotionalContent() {

		return CommonFunctions.isElementPresent(prpmotionalContent);
	}

	public boolean isDisplayedSearchBox(){
		return CommonFunctions.isElementPresent(searchBox);
	}


	public String getnoResultSearchText() throws InterruptedException {
		return noResultSearchText.getText().trim();
	}


	public boolean noResultSearchTitle() {
		return  noResultPageTitle.isDisplayed();
	}

	public void clickSearchIcon() {
		searchBoxButton.click();
	}


	public boolean noResultPagePara1() {
		return  noResultPagePara1.isDisplayed();
	}

	public boolean noResultPagePara2() {
		return  noResultPagePara2.isDisplayed();
	}


	public boolean richrelevance() {
		return  richrelevance.isDisplayed();
	}



	public boolean replacementPartText() {
		return  replacementPartText.isDisplayed();
	}

	public void gridViewIcon() {
		gridViewIcon.click();
	}

	public Boolean isSalesRepEmailDisplayed()
	{
		return salesRepEmail.isDisplayed();
	}

	public Boolean isSalesRepNameDisplayed()
	{
		return salesRepName.isDisplayed();
	}

	public Boolean isSalesRepNumberDisplayed()
	{
		return salesRepNumber.isDisplayed();
	}

	public Boolean isSalesRepImageDisplayed()
	{
		return salesRepImage.isDisplayed();
	}

	public Boolean isSalesRepImageOnHeaderDisplayed()
	{
		return salesRepImageOnHeader.isDisplayed();
	}

	public Boolean salesRepInformationOnHeaderDisplayed()
	{
		return salesRepInformationOnHeader.isDisplayed();
	}

	public void clickOnAccountUnderUser()
	{
		accountUnderUser.click();
	}

	public Boolean isAccountUnderUserModalDisplayed()
	{
		return accountUnderUserModal.isDisplayed();
	}

	/**
	 * @return true if Empty Minicart is displayed otherwise False
	 */
	public boolean isDisplayedHeaderMiniCartEmpty() {
		return CommonFunctions.isElementPresent(headerMinicartEmpty);

	}

	public String getIsDisplayedHeaderMiniCartEmptyText(){
		return headerMinicartEmpty.getText().trim();
	}

	public void clickOnAccount0012482415UnderUser()
	{
		CommonFunctions.scrolltoViewElement(account0012482415UnderUserModal, driver);
		account0012482415UnderUserModal.click();
	}

	public void clickOnAccount0012482411UnderUser() throws Exception
	{
		Thread.sleep(5000);
		CommonFunctions.scrolltoViewElement(account0012482411UnderUserModal, driver);
		account0012482411UnderUserModal.click();
	}

	public Boolean isYourTopCategoriesCarouselSection()
	{
		CommonFunctions.scrolltoViewElement(yourTopCategoriesCarouselSection, driver);
		return yourTopCategoriesCarouselSection.isDisplayed();
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
	// Method to click on the BreadCrumb in any of the Pages
	public HomePage clickBreadCrumbHomeLinkText() throws InterruptedException {
		breadCrumbHomeLinkText.click();
		return new HomePage(driver);
	}


	// Method to Verify for Left Navigation
	public boolean isDisplayedLeftNavgation(){
		return CommonFunctions.isElementPresent(leftNavigationImage);
	}



	// Method to get the Categories 	
	public String getCategoryPageHeadingText() {
		return categoryPageHeadingText.getText().trim();
	}


	// Method to Click on Shop By Category in Header	
	public void clickHeaderShopByCategoryLinkText() 
	{
		WaitTool.waitForElement(driver, headerShopByCategoryLinkText);
		headerShopByCategoryLinkText.click();
		WaitTool.waitFor(driver,true);
	}

	public boolean islearnSomethingNewDisplayed()
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

	public Boolean isYourTopCategoriesTitleDisplayed()
	{
		return yourTopCategoriesTitle.isDisplayed();
	}

	public Boolean isCustomProductsTextDisplayed()
	{
		return customProductsText.isDisplayed();	
	}

	public void clickOnShopByCategoryArrow()
	{
		shopByCategoryArrow.click();
	}

	public void clickOnFooterLinks(String linkName) 
	{
		System.out.println("linkName is "+ linkName);
		
		for(WebElement footerlink : allFooterLinks)
		{
			System.out.println("footerlink get text is "+ footerlink.getText());
			if(footerlink.getText().equals(linkName))
			{
				System.out.println("footerlink.getText() is "+ footerlink.getText());
				System.out.println("linkName is "+ linkName);
				footerlink.click();
				break;
			}

		}

	}

	public void moveToNewWindow()
	{
		CommonFunctions.moveToNewWindow(driver);

	}

	public String getTitle()
	{
		return CommonFunctions.getTitle(driver);
	}

	public void moveToParentWindow()
	{
		CommonFunctions.closecurrentBrowser(driver);
		CommonFunctions.moveToNewWindow(driver);
	}

	public boolean isContactUsTextDisplayed()
	{
		return contactUsText.isDisplayed();
	}


	public boolean isSpanishTextDisplayed()
	{
		return spanishText.isDisplayed();
	}


	public boolean isLocationsTextDisplayed()
	{
		return LocationsText.isDisplayed();
	}

	public boolean isOurCompanyTextDisplayed()
	{
		return ourCompanyText.isDisplayed();
	}

	public boolean isaAccountChangeRequestBreadcrumbDisplayed()
	{
		return accountChangeRequestBreadcrumb.isDisplayed();
	}

	public boolean isApplyForCreditTextDisplayed()
	{
		return applyForCreditText.isDisplayed();
	}

	public boolean isFrequentlyAskedQuestionsTextDisplayed()
	{
		return frequentlyAskedQuestionsText.isDisplayed();
	}

	public boolean isAccountRetrievalTextDisplayed()
	{
		return accountRetrievalText.isDisplayed();
	}

	public boolean isWebsiteUpdatesTextDisplayed()
	{
		return websiteUpdatesText.isDisplayed();
	}

	public boolean isContactUsForHelpTextDisplayed()
	{
		return contactUsForHelpText.isDisplayed();
	}

	
	public boolean isReturnPolicyTextDisplayed()
	{
		return returnPolicyText.isDisplayed();
	}

	public boolean isCaliforniaPrivacyTextDisplayed()
	{
		return californiaPrivacyText.isDisplayed();
	}
	
	public boolean isFinePrintAndCatalogIconsTextDisplayed()
	{
		return finePrintAndCatalogIconsText.isDisplayed();
	}
	
	public boolean isPrivacyComplainceTextDisplayed()
	{
		return privacyComplainceText.isDisplayed();
	}
	
	public boolean isPrivacyStatementTextDisplayed()
	{
		return privacyStatementText.isDisplayed();
	}
	
	public boolean isTermOfSaleTextDisplayed()
	{
		return termOfSaleText.isDisplayed();
	}
	
	public boolean isTermOfUseeTextDisplayed()
	{
		return termOfUseText.isDisplayed();
	}
	
	public void selectPropertyDropdown() throws Exception
	{
		if (environmentValue.equals("qa1")||environmentValue.equals("qa2")||environmentValue.equals("beta")){
			System.out.println("***** Selected the property from the dropdown in homepage ***");
			CommonFunctions.scrolltoViewElement(propertyDropdown, driver);
			propertyDropdown.click();
			Thread.sleep(5000);
			CommonFunctions.scrolltoViewElement(account0012482411UnderUserModal, driver);
			account0012482411UnderUserModal.click();
		}
	}
	
	public FrequentlyPurchasedPage clickOnFrequentlyPurchasedLink()
	{
        WaitTool.waitForElement(driver, frequentlyPurchasedLink);
		frequentlyPurchasedLink.click();
		return new FrequentlyPurchasedPage(driver);
	}
	

}











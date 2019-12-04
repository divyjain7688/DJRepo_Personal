package com.selenium.ebiz.pageobject;

import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.WaitTool;
import org.apache.commons.lang.WordUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class HomePage {
	private ArrayList<UsersListBean> usersList;

	int i;
	private WebDriver driver;
	protected WaitTool waitTool;
	private PageManager pageManager;


	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitTool  = new WaitTool();
		pageManager = new PageManager(driver);
	}


	@FindBy(xpath = "//div[@class='content__description type--caption'][contains(text(),'Replacement for discontinued Part# 20610')]")
	WebElement replacementPartText;

	//Minicart widget
	@FindBy(xpath="//div[@class='main__cart-info']//a[@id='widget_minishopcart'][@role='button']")
	public WebElement shoppingCartIcon;

	@FindBy(xpath = "//div[@class='main__cart']//a[@id='widget_minishopcart']//div")
	WebElement shoppingCartProductCount;

	@FindBy(xpath="//div[@class='footer-nav__footer-menu']//a")
	List<WebElement> allFooterLinks;

	//Header HD Logo
	@FindBy(xpath =".//*[@class='header__main']//*[@id='contentRecommendationWidget_HdsHeaderLogoESpot']")
	public WebElement hDSupplyLogoInHeader;//headerHDLogoImage;

	@FindBy(xpath = "//h1[text()='Custom Products Order Forms & Videos']")
	public WebElement customProductsText;

	@FindBy (xpath = "//div[@class='widget-wrapper__header']//*[contains(text(),'Your Top Categories')]")
	WebElement yourTopCategoriesTitle;

	@FindBy(xpath = "//td[text()='0012482415']/../td[1]")
	WebElement account0012482415UnderUserModal;

	@FindBy(xpath = "//tr[@class='property-selector']//td[contains(text(),'0012482411')]")
	public 	WebElement account0012482411UnderUserModal;

	@FindBy(xpath="//*[@data-hds-tag='nav__links-offers__link']")
	WebElement offerLink;

	@FindBy(xpath="//a[contains(text(),'eCATALOGS')]")
	WebElement eCatalogLink;

	//Cobrand Logo
	@FindBy(xpath = "//div[@id='headerRow1']/div[@class='header__main']/section/a/div/div/div/*[@viewBox='0 0 420 90.83']//*[@fill='#fff'][last()]")
	WebElement headerCobrandLogo;

	//Category Recommendation
	@FindBy(xpath = "//div[starts-with(@id,'categoryRecommendationWidget_')]//h4")
	WebElement categoryRecommendationTitleText;

	@FindBy(xpath = "//div[starts-with(@id,'catalogEntryRecommendationWidget_')]//h4")
	WebElement yourCompanysProductsTitleText;

	//Content widget Learn something new
	@FindBy(xpath = "//*[text()='Learn Something New']")
	WebElement contentWidgetLearnSomethingNewTitleText;

	@FindBy(xpath="//input[@id='SimpleSearchForm_SearchTerm']")
	public WebElement searchBox;

	@FindBy(xpath = "//div[@class='search-bar-add-to-cart__list-items']")
	public WebElement searchAdvanceSearch;

	// Searchbox button
	@FindBy(xpath="//*[@id='searchBox']/a/*[name()='svg']/*[name()='g']/*[name()='circle']")
	public WebElement searchButton;

	//Signed In User Name
	@FindBy(xpath = "//div[@class='account__info type--body-small']/a/span[2]")
	WebElement userSignedInUserText;

	//User Account number
	@FindBy(xpath = "//div[@class='account__info type--body-small']//span[contains(text(),'Customer #')]")
	WebElement userAccountNumberText;

	@FindBy(xpath = "//div[@class='account__info type--body-small']/a/span[@class='type--caption type--extra-bold']")
	WebElement userNameText;

	//User Account Name
	@FindBy(xpath="//div[@class='account__suma type--body-small']")
	public WebElement propertyDropdown;

	//Static Website help label
	@FindBy(xpath = "//div[@class='quick-info__help']/span[contains(text(), 'Website Help')]")
	public WebElement websiteHelpLabel;

	//Static Website help Phone number
	@FindBy(xpath = "//div[@class='quick-info__help']/span[contains(text(), '1.877.694.4932')]")
	public WebElement websiteHelpPhoneNumberText;

	//Static Website help Timings
	@FindBy(xpath = "//div[@class='quick-info__help']/span[contains(text(), '(8 a.m. - 8 p.m. EST)')]")
	public WebElement websiteHelpTimeText;

	//Content Heros
	@FindBy(xpath = "//div[@id='content_delivery-hero']")
	WebElement contentHeros1;

	@FindAll(@FindBy(xpath= "//div[@class='search-bar-auto-suggest-results__result-list']/a/div"))
	List <WebElement> suggestedProductsResultsList;

	@FindBy(xpath = "//div[@class='search-bar-auto-suggest-results__result-list']")
	WebElement searchSuggestedProductsHeader;

	//Left navigation Appliance category
	@FindBy(xpath = "//a[starts-with(@id, 'SBN_Appliances_')]")
	WebElement categoryApplianceLeftNavigationLinkText;

	//  Left Nav
	@FindBy(xpath = "//ul[starts-with(@id,'categoryFacetList_1')]")
	WebElement leftNavigationImage;

	//PopularProductsCarousel
	@FindBy(className = "home_page_new_rr1")
	WebElement hdsPopularProductsCarousel;

	//Video Content eSpots (Learn More Spots)
	@FindBy (xpath = "//div[@data-slot-id='11']")
	public WebElement videoESpot1;

	@FindBy (xpath = "//div[@data-slot-id='12']")
	public WebElement videoESpot2;

	//@FindBy(xpath="//*[@id='content_HeroContentBottomLeft']")
	//@FindBy(css="#content_18984-home-page-resource .marketing-espot__content")
	@FindBy(css="#content_19575-home-resource .marketing-espot__content")
	public WebElement learnSomethingNewLeftBlock;

	//@FindBy(xpath="//*[@id='content_HeroContentBottomRight']")
	//@FindBy(css="#content_homepage-resource-turns .marketing-espot__background")
	@FindBy(css="#content_19592-home-resource .marketing-espot__background")
	public WebElement learnSomethingNewRightBlock;

	//@FindBy(xpath="//*[@class='widget-wrapper__header-text montserrat'][contains(text(),'Learn Something New')]")
	@FindBy(css=".el--margin-right-2")
	public WebElement learnSomethingNew;

	// Categories in Left Navigation
	//@FindBy(xpath = "//*[@class='left-nav']//li[1]//a")
	@FindBy(linkText = "Appliances")
	WebElement categoryAppliancesLinkText;

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
	@FindBy(xpath = "//div[@class='account-snapshot__welcome-inner']/span[contains(text(),'Hi')]")
	public WebElement welcomeTextLoggedUser;


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

	//@FindBy(xpath = "//nav[@class='flyout-nav flyout-nav--dynamic flyout-nav--visible']//li/a[contains(text(),'Window Coverings')]")
	@FindBy(xpath = "//div[@class='left-nav']//li/a[contains(text(),'Window Coverings')]")
	WebElement categoryWindowCoveringsLinkText;


	//Footer Page objects
	@FindBy(linkText = "Careers")
	WebElement aboutUsCareersLinkText;

	@FindBy(linkText = "Contact Us")
	WebElement aboutUsContactUsLinkText;

	@FindBy(id = "suggestedProductsResults")
	WebElement suggestedProductsResultsBlock;
	
	@FindBy(xpath = "//div[@id='suggestedProductsResults']//div[@class='el--margin-right-2']")
	List<WebElement> productImagesInSuggestedProductsResultsBlock;
	
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
	@FindBy(xpath = "//div[@class='header-sign-in__header header-sign-out']//span[contains(text(),'SIGN OUT')]")
	WebElement signOutLinkText;

	// ************************Headers****************************************

	@FindBy(xpath = "//span[@class='shop-by-category__label']")
	public WebElement shopByCategoryLinkText;

	@FindBy(xpath = "//a[text()='Resources']")
	public WebElement headerResourcesLinkText;
	
	@FindBy(xpath = "//div[@data-hds-tag='flyout-nav__nav__links-resources']")
	public WebElement resourcesFlyout;
	
	@FindBy(xpath = "//a[text()='Resources']/../div[@class='flyout-nav flyout-nav--visible']//a[text()='Product Resources']")
	public WebElement productResourceLinkFromResourceFlyout;
	
	@FindBy(xpath = "//a[text()='Resources']/../div[@class='flyout-nav flyout-nav--visible']//a[text()='Product Resources']/../div//a[text()='Pool Care & Maintenance']")
	public WebElement poolCareAndMaintenanceLinkFromResourceFlyout;

	@FindBy(linkText = "OFFERS")
	public
	WebElement headerOffersLinkText;

	@FindBy(linkText = "SERVICES")
	public
	WebElement headerServicesLinkText;

	@FindBy(xpath = "//*[text()='NEW!']")
	public
	WebElement headerSubscriptionsLinkText;

	@FindBy(linkText = "eCATALOGS")
	public
	WebElement headereCatalogsLinkText;

	@FindBy(xpath = "//a[@data-hds-tag='nav__links-partslink__link']")
	public WebElement headerPartsLink;

	@FindBy(linkText = "Quotes")
	public WebElement topHeaderquotesLinkText;

	@FindBy(linkText = "Saved Lists")
	public
	WebElement topHeaderSavedlistLinkText;

	@FindBy(linkText = "Order History & Status")
	public
	WebElement topHeaderorderHisStatusLinkText;

	@FindBy(xpath ="//a[text()='Frequently Purchased']")
	public WebElement frequentlyPurchasedLink;

	@FindBy(xpath = "//div[@class='quick-order__label']")
	public
	WebElement headerQuickOrderLinkText;

	@FindBy(xpath = "//h4[contains(text(),'Order Again')][@class='widget-wrapper__header-text montserrat']")
	public WebElement headerOrderAgain;

	@FindBy(xpath = "//button[@class='btn'][text()='VIEW ORDER HISTORY']")
	WebElement viewOrderHistoryButton;

	// added to verify whether search box is above header
	@FindBy(xpath = "//div[@class='quick-info__help']")
	public WebElement headerWebsitehelpLinkText;

	//exploreHDSupply DropDown
	@FindBy(xpath = "//select[@class='jq-select--navigate oswald']")
	WebElement exploreHDSupplyDropDown;

	@FindBy(xpath = "//div[@class='header-mini-cart__empty']")
	WebElement headerMinicartEmpty;

	@FindBy(className = "cart__quantity")
	public WebElement miniCartCount;

	//Register or signIn
	@FindBy(id = "Header_GlobalLogin_signInQuickLink")
	public WebElement registerOrSignInLinkText;

	//Content recommendation order again.
	// @FindBy(xpath = "//h4[contains(text(),'Order Again')]/../../..")
	@FindBy(xpath = "//*[@id=\'title\']")
	public WebElement OrderAgainContentRecommandation;

	//Account icon next to account name.
	@FindBy(xpath = "//a[@id='Header_GlobalLogin_signOutQuickLink']")
	public
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


	@FindBy(xpath="//div[@class='footer-contact']//div[@class='footer-social-container__social-icons type--caps montserrat type--bold type--white']/span[1]")
	WebElement facebookLink;

	@FindBy(xpath="//div[@class='footer-contact']//div[@class='footer-social-container__social-icons type--caps montserrat type--bold type--white']/span[2]")
	WebElement twitterLink;

	@FindBy(xpath="//div[@class='footer-contact']//div[@class='footer-social-container__social-icons type--caps montserrat type--bold type--white']/span[3]")
	WebElement googleplusLink;

	// @FindBy(xpath="//div[@class='footer-contact']//div[@class='footer-social-container__social-icons type--caps montserrat type--bold type--white']/span[4]")
	@FindBy(xpath="//div[@class='footer-contact']//div[@class='footer-social-container__social-icons type--caps montserrat type--bold type--white']/span[3]")
	WebElement linkedinLink;
	
	@FindBy(xpath="//header[@class='nav']/img[@class='lazy-loaded']")
	WebElement linkedInTitle;

	// @FindBy(xpath="//div[@class='footer-contact']//div[@class='footer-social-container__social-icons type--caps montserrat type--bold type--white']/span[5]")
	@FindBy(xpath="//div[@class='footer-contact']//div[@class='footer-social-container__social-icons type--caps montserrat type--bold type--white']/span[4]")
	WebElement youtubeLink;

	//@FindBy(xpath="//div[@class='footer-nav__footer-menu']//div[text()='ABOUT US']")
	// @FindBy(xpath="//div[@class='footer-nav__footer-menu']//div[contains(text(),'ABOUT')]")
	@FindBy(xpath="//a[contains(@href, '/s/about_us')]")
	WebElement aboutusLink;

	//@FindBy(xpath="//div[@class='footer-nav__footer-menu']//div[contains(text(),'HELP')]")
	@FindBy(xpath="//a[contains(.,'HELP')]") // //div[@class='footer-nav__footer-menu']//div[contains(text(),'HELP')]
	WebElement helpLink;

	//@FindBy(xpath="//div[@class='footer-nav__footer-menu']//div[contains(text(),'RETURNS')]")
	@FindBy(xpath="//a[contains(@href, '/s/returns_policy')]") ////div[@class='footer-nav__footer-menu']//div[contains(text(),'RETURNS')]
	WebElement returnsLink;

	//@FindBy(xpath="//div[@class='footer-nav__footer-menu']//div[contains(text(),'TERMS')]")
	@FindBy(xpath="//a[contains(@href, '/s/company_policies')]") ////div[@class='footer-nav__footer-menu']//div[contains(text(),'TERMS')]
	WebElement termsAndPoliciesLink;

	@FindBy(xpath="//span[@class='shop-by-category__label']")
	public
	WebElement shopByCategoryLink;

	@FindBy(xpath="//nav[@class='flyout-nav flyout-nav--dynamic flyout-nav--visible']/div[@class='flyout-menu__page']/div[@class='flyout-nav__list-container']/ul/li/a[text()='Appliances']")
	public
	WebElement listFirstOption;

	@FindBy(xpath="//nav[@class='flyout-nav flyout-nav--dynamic flyout-nav--visible']/div[@class='flyout-menu__page']/div[@class='flyout-nav__list-container']/ul/li/div/div[@class='flyout-nav__list-container']/ul/li/a[text()='Washers & Dryers']")
	WebElement categoryListFirstOption;

	@FindBy(xpath="//nav[@class='flyout-nav flyout-nav--dynamic flyout-nav--visible']/div[@class='flyout-menu__page']/div[@class='flyout-nav__list-container']/ul/li/div/div[@class='flyout-nav__list-container']/ul/li/div/div[@class='flyout-nav__list-container']/ul/li/a[text()='Washer & Dryer Repair']")
	WebElement subCategoryListFirstOption;

	@FindBy(xpath="//div[@class='footer__logo']")
	WebElement hDSupplyLogo;

	@FindBy(xpath="//h4[@class='widget-wrapper__header-text montserrat']")
	WebElement orderAgainLabel;

	//@FindBy(xpath="//strong[@class='type--caps']")
	@FindBy(xpath="//div[@data-hds-tag='product-tile__part-number-container']")
	List<WebElement> eightPartNumbersInsideOrderOnceSection;

	@FindBy(xpath = "//div[@data-hds-tag='product-tile__part-number-container']")   //partNumberInsideOrderOnceSection
	WebElement partNumberInsideOrderOnceSection;

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
	public WebElement heroContentSmallBlock1;

	@FindBy (xpath = "//div[(@class='col4 acol12')and(@data-slot-id='5')]")
	public WebElement heroContentSmallBlock2;

	@FindBy (xpath = "//div[(@class='col4 acol12')and(@data-slot-id='6')]")
	public WebElement heroContentSmallBlock3;
	
	@FindBy (xpath ="//div[(@class='col12')and(@data-slot-id='2')]")
	public WebElement largeMarketingHeroContent;	

	@FindBy(xpath="//div[@class='subcat-grid-tile-container']//section[@class='subcat-grid-tile'][1]//*[@class='btn btn--full btn--small type--caps']")
	WebElement addToCartButtonOfFirstProduct;

	@FindBy(xpath=" //div[@class='subcat-list-tile-container']//section[@class='subcat-list-tile'][1]//*[@class='btn btn--full btn--small type--caps']")
	public WebElement addToCartButtonOfFirstProductListView;

	@FindBy(xpath="//a[@class='btn btn--large btn--full cart-added__checkout-desktop']")
	public WebElement cartOverlayCheckoutButton;

	@FindBy(xpath="//*[@id='WC_AccountDisplay_FormInput_logonId_In_Logon_1']")
	WebElement usernameField;

	@FindBy(xpath="//*[@id='WC_AccountDisplay_FormInput_logonPassword_In_Logon_1']")
	WebElement passwordField;

	@FindBy(xpath="//*[@id='WC_AccountDisplay_links_2']/button")
	WebElement signInButton;

	//PromotionalContent
	@FindBy (xpath ="//div[@class ='pageControl dot']")
	public WebElement promotionalContent;

	@FindBy(xpath = "//div[@class='pageControl dot']/a[1]")
	public WebElement firstRadioButtonInsidePageControlPanel;

	@FindBy(xpath = "//div[@class='pageControl dot']/a[2]")
	public WebElement secondRadioButtonInsidePageControlPanel;

	@FindBy(xpath = "//div[@class='pageControl dot']/a[3]")
	public WebElement thirdRadioButtonInsidePageControlPanel;

	@FindBy(xpath = "//h1[text()='Contact Us']")
	public WebElement contactUsText;

	@FindBy(xpath = "//h1[contains(text(),'Spanish')]")
	public WebElement spanishText;

	@FindBy(xpath = "//h1[text()='Locations']")
	public WebElement LocationsText;

	@FindBy(xpath = "//h1[contains(text(),'Our Company')]")
	public WebElement ourCompanyText;

	@FindBy(xpath = "//span[text()='Account Change Request']")
	public WebElement accountChangeRequestBreadcrumb;

	@FindBy(xpath = "//h1[contains(text(),'Apply for Credit')]")
	public WebElement applyForCreditText;


	@FindBy(xpath = "//h1[contains(text(),'Account Retrieval')]")
	public WebElement accountRetrievalText;

	@FindBy(xpath = "//h2[contains(text(),'Website Upgrades')]")
	public WebElement websiteUpdatesText;
	
	@FindBy (xpath= "//h1[contains(text(),'Site Map')]")
	public WebElement siteMapText;

	@FindBy(xpath = "//h1[contains(text(),'Return Policy')]")
	public WebElement returnPolicyText;

	@FindBy(xpath = "//h1[contains(text(),'California Privacy')]")
	public WebElement californiaPrivacyText;

	@FindBy(xpath = "//h1[contains(text(),'Privacy Statement')]")
	public WebElement privacyStatementText;

	@FindBy(xpath = "//h1[contains(text(),'Terms of Sale')]")
	public WebElement termOfSaleText;

	@FindBy(xpath = "//h1[contains(text(),'Terms of Use')]")
	public WebElement termOfUseText;

	@FindBy(xpath = "//h1[contains(text(),'Fine Print & Catalog Icons')]")
	public WebElement finePrintAndCatalogIconsText;

	@FindBy(xpath = "//*[contains(text(),'COMPLIANCE')]")
	public WebElement privacyComplainceText;

	@FindBy(xpath = "//div[text()='Contact us for help.']")
	//@FindBy(xpath = "//h1[text()='Online Return Form']")
	public WebElement contactUsForHelpText;

	@FindBy(xpath = "//div[@class='left-nav']//a[contains(text(),'Appliances')]")
	public WebElement firstCategoryInleftNavigationImage;

	@FindBy (xpath= "//div[@class='footer__copyright type--white type--body-small']")
	WebElement copyrighMessage;

	@FindBy (xpath= "//u[text()='Click to begin survey']")
	WebElement clickToBeginSurveyButton; 

	@FindBy (xpath= "//span[@style='font-size:22px;']")
	WebElement closeLinkOnManagementPopup; 

	@FindBy (xpath= "//span[text()='No Thanks']")
	WebElement NoThanksOnManagementPopup;
	
	@FindBy (xpath= "//a[@class='subcat-filter-box__header jq-subcat-filter-box--toggle'][contains(text(),'Price')]")
	public WebElement priceDropdown;

	//@FindBy (xpath= "//div[@data-hds-tag='subcat-filter-box__header--facet-value'][contains(text(),'Less than $25')]")
	@FindBy (xpath= "//div[@data-hds-tag='subcat-filter-box__header--facet-value'][contains(text(),'Less than $24.99')]")
	public WebElement priceLessThan25CheckBox;

	@FindBy (xpath= "//div[@id='headerRow1']/div/section/div/nav/div/div/ul/li/a")
	public List<WebElement> categoriesAllLinks;

	@FindBy (xpath= "//*[@id='headerRow1']/div[3]/section/div[1]/nav/div/div/ul/li[26]/div/a[2]/text()")
	public WebElement topcategoriesAllLink;

	@FindBy (xpath= "//*[@class='flyout-nav__li--selected']/div/div/ul/li/a")
	public List<WebElement> subcategoriesAllLinks;

	@FindBy (tagName= "a")
	public List<WebElement> links;

	@FindBy (xpath= "//div[@class='modal__inner']")
	WebElement propertiesPopUpWindow; 
	
	@FindBy (xpath= "//div[@class='modal__inner']/a")
	WebElement propertiesPopUpCloseLink; 
	
	@FindBy (xpath= "//div[@class='modal__inner']//td[@data-hds-tag='property-selection__list__account-number']/..")
	public List<WebElement> accountNumbersOnPropertyModalWindow;
	
	//section[@class="search-bar-auto-suggest-results"]
	@FindBy (xpath= "//section[@class='search-bar-auto-suggest-results']")
	public WebElement autoCompleteSection;
	
	@FindBy (xpath= "//div[@class='search-bar-auto-suggest-results__result-list']/a/div")
	public List<WebElement> partsListInAutoCompleteSection;
	

	/**
	 * return the welcome note textselectPropertyDropdown
	 */
	public String getWelcomeNote() {
		waitTool.waitVisibility(driver, welcomeTextLoggedUser, 60);
		return welcomeTextLoggedUser.getText().trim();
	}

	public void scrollToWelcomeNote() {
		waitTool.waitForElement(driver, welcomeTextLoggedUser);
		pageManager.common().scrolltoViewElement(welcomeTextLoggedUser, driver);

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
		return yourCompanysProductsTitleText.getText().trim();
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
		waitTool.waitForElement(driver,aboutusLink);
		pageManager.common().scrolltoViewElement(aboutusLink, driver);
		return aboutusLink.isDisplayed();
	}

	public Boolean isHelpLinkDisplayed()
	{
		waitTool.waitForElement(driver,helpLink);
		pageManager.common().scrolltoViewElement(helpLink, driver);
		return helpLink.isDisplayed();
	}

	public Boolean isReturnsLinkDisplayed()
	{
		waitTool.waitForElement(driver,returnsLink);
		pageManager.common().scrolltoViewElement(returnsLink, driver);
		return returnsLink.isDisplayed();
	}

	public Boolean isTermsAndPoliciesLinkDisplayed()
	{
		waitTool.waitForElement(driver,termsAndPoliciesLink);
		pageManager.common().scrolltoViewElement(termsAndPoliciesLink, driver);
		return termsAndPoliciesLink.isDisplayed();
	}

	public boolean isPromotionalContentDisplayed(){
		waitTool.waitForElement(driver,promotionalContent);
		return promotionalContent.isDisplayed();
	}

	public Boolean isFacebookLinkDisplayed()
	{

		waitTool.waitForElement(driver, facebookLink);
		return facebookLink.isDisplayed();
	}

	public String clickOnFacebookLink()
	{
		waitTool.waitForElement(driver, facebookLink);
		pageManager.common().scrolltoViewElement(facebookLink, driver);
		facebookLink.click();
		pageManager.common().moveToNewWindow(driver);
		return pageManager.common().getTitle(driver);
	}


	public Boolean isTwitterLinkDisplayed()
	{
		waitTool.waitForElement(driver, twitterLink);
		return twitterLink.isDisplayed();
	}

	public String clickOnTwitterLink()
	{
		waitTool.waitForElement(driver, twitterLink);
		twitterLink.click();
		pageManager.common().moveToNewWindow(driver);
		return pageManager.common().getTitle(driver);
	}

	public Boolean isGoogleplusLinkDisplayed()
	{
		waitTool.waitForElement(driver, googleplusLink);
		return googleplusLink.isDisplayed();
	}

	public String clickOnGoogleplusLink()
	{
		waitTool.waitForElement(driver, googleplusLink);
		googleplusLink.click();
		pageManager.common().moveToNewWindow(driver);
		return pageManager.common().getTitle(driver);
	}

	public Boolean isLinkedinLinkDisplayed()
	{
		waitTool.waitForElement(driver, linkedinLink);
		return linkedinLink.isDisplayed();
	}

	public String clickOnLinkedinLink()
	{
		waitTool.waitForElement(driver, linkedinLink);
		pageManager.common().scrolltoViewElement(linkedinLink, driver);
		linkedinLink.click();
		pageManager.common().moveToNewWindow(driver);
		return pageManager.common().getTitle(driver);
	}

	public Boolean isYoutubeLinkDisplayed()
	{
		waitTool.waitForElement(driver, youtubeLink);
		return youtubeLink.isDisplayed();
	}

	public String clickOnYoutubeLink()
	{
		waitTool.waitForElement(driver, youtubeLink);
		pageManager.common().scrolltoViewElement(youtubeLink, driver);
		youtubeLink.click();
		pageManager.common().moveToNewWindow(driver);
		return pageManager.common().getTitle(driver);
	}

	public void moveToSubCategoryPage() throws Exception
	{
		// wait.until(ExpectedConditions.visibilityOf(shopByCategoryLink));
		waitTool.waitForElement(driver, shopByCategoryLink);
		pageManager.common().scrolltoViewElement(shopByCategoryLink, driver);
		shopByCategoryLink.click();
		waitTool.waitForElement(driver,listFirstOption);
		listFirstOption.click();
		waitTool.waitForElement(driver,categoryListFirstOption);
		categoryListFirstOption.click();
		waitTool.waitForElement(driver,subCategoryListFirstOption);
		subCategoryListFirstOption.click();
	}

	public void movetoCategoryLandingPage() throws Exception
	{
		// wait.until(ExpectedConditions.visibilityOf(shopByCategoryLink));
		waitTool.waitForElement(driver, shopByCategoryLink);
		pageManager.common().scrolltoViewElement(shopByCategoryLink, driver);
		shopByCategoryLink.click();
		waitTool.waitForElement(driver,listFirstOption);
		listFirstOption.click();
		pageManager.categoryAppliancesPage().clickAllAppliancesLinkUnderShopCategories();
		pageManager.appliances().appliancesTitle.isDisplayed();
	}

	public boolean isHDSupplyLogoDisplayed()
	{
		pageManager.common().scrolltoViewElement(hDSupplyLogo, driver);
		return hDSupplyLogo.isDisplayed();
	}

	public void clickOnViewOrderHistoryButton()
	{
		waitTool.waitForElement(driver, viewOrderHistoryButton);
		pageManager.common().scrolltoViewElement(viewOrderHistoryButton, driver);
		viewOrderHistoryButton.click();
	}


	public void clickOfferLink()
	{
		offerLink.click();
	}

	public void clickHeaderResourcesLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, headerResourcesLinkText);
		headerResourcesLinkText.click();
	}

	//public BedBathTableLinens clickCategoryBedBathTableLinensLinkText() throws InterruptedException {
	public void clickCategoryBedBathTableLinensLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, categoryBedBathTableLinensLinkText);
		categoryBedBathTableLinensLinkText.click();
	}

	public void clickCategoryCabinetsCountertopsLink() throws InterruptedException {
		waitTool.waitForElement(driver, categoryCabinetsCountertopsLinkText);
		categoryCabinetsCountertopsLinkText.click();
	}

	public void clickCategoryDoorsMoldingLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, categoryDoorsMoldingLinkText);
		categoryDoorsMoldingLinkText.click();
	}

	public void clickCategoryElectricalLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, categoryElectricalLinkText);
		categoryElectricalLinkText.click();
	}

	public void clickCategoryElectronicsLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, categoryElectronicsLinkText);
		categoryElectronicsLinkText.click();
	}

	public void clickCategoryFitnessExerciseLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, categoryFitnessExerciseLinkText);
		categoryFitnessExerciseLinkText.click();
	}


	//get Copy Right text
	public String getCopyRightText() {
		return copyRightText.getText().trim();
	}

	public String returnCopyRightText() {
		return getCopyRightText();
	}


	//Categories Page methods
	public void clickHvacLinkText(){
		waitTool.waitForElement(driver, categoryHvacLinkText);
		categoryHvacLinkText.click();
	}

	public void clickJanitorialLinkText(){
		waitTool.waitForElement(driver, categoryJanitorialLinkText);
		categoryJanitorialLinkText.click();

	}

	public void clickLightingLinkText() {
		waitTool.waitForElement(driver, categoryLightingLinkText);
		categoryLightingLinkText.click();
	}


	public void clickOfficeSuppliesLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, categoryOfficeSuppliesLinkText);
		categoryOfficeSuppliesLinkText.click();
		waitTool.waitFor(driver, true);
	}


	public void clickPaintSupplieslLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, categoryPaintSuppliesLinkText);
		categoryPaintSuppliesLinkText.click();
		waitTool.waitFor(driver, true);
	}


	public void clickPlumbingLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, categoryPlumbingLinkText);
		categoryPlumbingLinkText.click();
		waitTool.waitFor(driver, true);
	}


	public void clickPoolSuppliesLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, categoryPoolSuppliesLinkText);
		categoryPoolSuppliesLinkText.click();
		waitTool.waitFor(driver, true);
	}


	public void clickPropertyMarketingLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, categoryPropertyMarketingLinkText);
		categoryPropertyMarketingLinkText.click();
		waitTool.waitFor(driver, true);

	}


	public void clickSafetyLinkLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, categorySafetyLinkText);
		categorySafetyLinkText.click();
		waitTool.waitFor(driver, true);

	}


	public void clickSignsLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, categorySignsLinkText);
		categorySignsLinkText.click();
		waitTool.waitFor(driver, true);

	}

	public void clickStorageLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, categoryStorageLinkText);
		categoryStorageLinkText.click();
		waitTool.waitFor(driver, true);
	}

	public void clickToolsLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, categoryToolsLinkText);
		categoryToolsLinkText.click();
		waitTool.waitFor(driver, true);

	}

	public void clickWindowCoveringsLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, categoryWindowCoveringsLinkText);
		categoryWindowCoveringsLinkText.click();
		waitTool.waitFor(driver, true);

	}

	//Static Footer Page Methods
	public void clickAboutUsCareersLinkText() {

		waitTool.waitForElement(driver, aboutUsCareersLinkText);
		aboutUsCareersLinkText.click();
	}

	public void clickAboutUsEnEspanolLinkText() {

		waitTool.waitForElement(driver, aboutUsEnEspanolLinkText);
		aboutUsEnEspanolLinkText.click();
	}

	public void clickAboutUsContactUsLinkText() {

		waitTool.waitForElement(driver, aboutUsContactUsLinkText);
		aboutUsContactUsLinkText.click();
	}

	public void clickAboutUsHDSupplyCanadalLinkText() {

		waitTool.waitForElement(driver, aboutUsHDSupplyCanadalLinkText);
		aboutUsHDSupplyCanadalLinkText.click();
	}

	public void clickAboutUsLocationsLinkText() {

		waitTool.waitForElement(driver, aboutUsLocationsLinkText);
		aboutUsLocationsLinkText.click();
	}

	public void clickAboutUsOurCompanyLinkText() {

		waitTool.waitForElement(driver, aboutUsOurCompanyLinkText);
		aboutUsOurCompanyLinkText.click();
	}

	public void clickHelpAccountChangeRequestLinkText() {

		waitTool.waitForElement(driver, helpAccountChangeRequestLinkText);
		helpAccountChangeRequestLinkText.click();
	}

	/**
	 * Click on Account Icon
	 *
	 */
	public void clickAccountIcon() {
		waitTool.waitForElement(driver, accountIcon);
		accountIcon.click();

	}

	/**
	 * Click on Account link on Header
	 * @return the driver to My Account Page
	 */
	public void clickAccountLinkText() {
		clickAccountIcon();
		waitTool.waitForElement(driver, accountLinkText);
		pageManager.common().scrolltoViewElement(accountLinkText, driver);
		accountLinkText.click();
		waitTool.waitFor(driver, true);
	}

	public void clickLogoutLinkText() {
		//waitTool.waitFor(driver, true);
		clickAccountIcon();
		waitTool.waitForElement(driver, signOutLinkText);
		signOutLinkText.click();
	}

	/**
	 * @description: //Method to click on accountSignOutIcon
	 * @return void
	 */
	public void clickAccountSignOutIcon() throws InterruptedException {
		waitTool.waitForElement(driver, accountIcon);
		accountIcon.click();
		waitTool.waitFor(driver, true);
		signOutLinkText.click();
	}

	public void clickOnSignOutIcon() {
		waitTool.waitForElement(driver, accountIcon);
		pageManager.common().scrolltoViewElement(accountIcon, driver);
		accountIcon.click();
		System.out.println("clicked onnn accout iconnnn");
		waitTool.waitElementToBeClickable(driver,signOutLinkText);
		pageManager.common().mouseHover(driver,signOutLinkText);
		signOutLinkText.click();
		pageManager.common().acceptPopupMessageBox(driver);
	}


	public void clickOnSignOutIconAndCancelPopup() {
		waitTool.waitForElement(driver, accountIcon);
		accountIcon.click();
		waitTool.waitElementToBeClickable(driver,signOutLinkText);

		pageManager.common().mouseHover(driver,signOutLinkText);
		Assert.assertTrue(pageManager.common().isElementPresent(signOutLinkText));
		pageManager.common().mouseHover(driver,signOutLinkText);
		signOutLinkText.click();
		System.out.println("POP:"+pageManager.common().getPopupMessage(driver));
		Assert.assertEquals(pageManager.common().getPopupMessage(driver), "Are you sure you want to Sign Out?");
		
		pageManager.common().cancelPopupMessageBox(driver);

	}

	public void clickOnSignOutIconAndAcceptPopup() throws Exception {
		clickOnHDSupplyLogoInHeader();
		waitTool.waitElementToBeClickable(driver,  accountIcon);
		accountIcon.click();
		waitTool.waitElementToBeClickable(driver,signOutLinkText);

		pageManager.common().mouseHover(driver,signOutLinkText);
		Assert.assertTrue(pageManager.common().isElementPresent(signOutLinkText));
		pageManager.common().mouseHover(driver,signOutLinkText);
		signOutLinkText.click();
		System.out.println("POP:"+pageManager.common().getPopupMessage(driver));
		Assert.assertEquals(pageManager.common().getPopupMessage(driver), "Are you sure you want to Sign Out?");
		
		pageManager.common().acceptPopupMessageBox(driver);

	}
	public void clickHelpApplyforCreditlLinkText() {

		waitTool.waitForElement(driver, helpApplyforCreditlLinkText);
		helpApplyforCreditlLinkText.click();
	}

	public boolean isDisplayedHelpApplyforCreditlLinkText(){

		return pageManager.common().isElementPresent(helpApplyforCreditlLinkText);


	}

	public void clickHelpFaqlLinkText() {

		waitTool.waitForElement(driver, helpFaqlLinkText);
		helpFaqlLinkText.click();
	}

	public boolean isDisplayedHelpFaqlLinkText(){

		return pageManager.common().isElementPresent(helpFaqlLinkText);


	}

	public void clickHelpForgotPasswordLinkText() {

		waitTool.waitForElement(driver, helpForgotPasswordLinkText);
		helpForgotPasswordLinkText.click();
	}

	public boolean isDisplayedHelpForgotPasswordLinkText(){

		return pageManager.common().isElementPresent(helpForgotPasswordLinkText);


	}

	public void clickHelpNewWebsiteFeaturesLinkText() {

		waitTool.waitForElement(driver, helpNewWebsiteFeaturesLinkText);
		helpNewWebsiteFeaturesLinkText.click();
	}

	public boolean isDisplayedHelpNewWebsiteFeaturesLinkText(){

		return pageManager.common().isElementPresent(helpNewWebsiteFeaturesLinkText);


	}

	public void clickHelpSiteMapLinkText() {

		waitTool.waitForElement(driver, helpSiteMapLinkText);
		helpSiteMapLinkText.click();
	}


	public boolean isDisplayedHelpSiteMapLinkText(){

		return pageManager.common().isElementPresent(helpSiteMapLinkText);


	}

	public void clickReturnsFormLinkText() {

		waitTool.waitForElement(driver, returnsFormLinkText);
		returnsFormLinkText.click();
	}

	public boolean isDisplayedReturnsFormLinkText(){

		return pageManager.common().isElementPresent(returnsFormLinkText);


	}

	public void clickReturnPolicyLinkText() {

		waitTool.waitForElement(driver, returnPolicyLinkText);
		returnPolicyLinkText.click();
	}

	public boolean isDisplayedReturnPolicyLinkText(){

		return pageManager.common().isElementPresent(returnPolicyLinkText);


	}

	public void clickTermsAndPoliiciesCaliforniaPrivacyLinkText() {

		waitTool.waitForElement(driver, termsAndPoliiciesCaliforniaPrivacyLinkText);
		termsAndPoliiciesCaliforniaPrivacyLinkText.click();
	}

	public boolean isDisplayedTermsAndPoliiciesCaliforniaPrivacyLinkText(){

		return pageManager.common().isElementPresent(termsAndPoliiciesCaliforniaPrivacyLinkText);


	}

	public void clickTermsAndPoliiciesFinePrintCatalogIconsLinkText() {

		waitTool.waitForElement(driver, termsAndPoliiciesFinePrintCatalogIconsLinkText);
		termsAndPoliiciesFinePrintCatalogIconsLinkText.click();
	}

	public boolean isDisplayedTermsAndPoliiciesFinePrintCatalogIconsLinkText(){

		return pageManager.common().isElementPresent(termsAndPoliiciesFinePrintCatalogIconsLinkText);


	}

	public void clickTermsAndPoliiciesPrivacyPolicyLinkText() {

		waitTool.waitForElement(driver, termsAndPoliiciesPrivacyPolicyLinkText);
		termsAndPoliiciesPrivacyPolicyLinkText.click();
	}

	public boolean isDisplayedTermsAndPoliiciesPrivacyPolicyLinkText(){

		return pageManager.common().isElementPresent(termsAndPoliiciesPrivacyPolicyLinkText);


	}

	public void clickTermsAndPoliiciesPrivacyStatementLinkText() {

		waitTool.waitForElement(driver, termsAndPoliiciesPrivacyStatementLinkText);
		termsAndPoliiciesPrivacyStatementLinkText.click();
	}

	public boolean isDisplayedTermsAndPoliiciesPrivacyStatementLinkText(){

		return pageManager.common().isElementPresent(termsAndPoliiciesPrivacyStatementLinkText);


	}

	public String getTextCopyrightMessage()
	{
		String copyrightMessageText = copyrighMessage.getText();
		System.out.println("copyrightMessageText is "+ copyrightMessageText);
		return copyrightMessageText;
	}
	
	public Boolean isDisplayedCopyrightMessage()
	{
		pageManager.common().scrolltoViewElement(copyrighMessage, driver);
		return copyrighMessage.isDisplayed();
		
	}

	public void clickTermsAndPoliiciesTermsofSaleLink() {

		waitTool.waitForElement(driver, termsAndPoliiciesTermsofSaleLinkText);
		termsAndPoliiciesTermsofSaleLinkText.click();
	}

	public boolean isDisplayedTermsAndPoliiciesTermsofSaleLinkText(){
		return pageManager.common().isElementPresent(termsAndPoliiciesTermsofSaleLinkText);
	}

	public void clickTermsAndPoliiciesTermsOfUseLinkText() {

		waitTool.waitForElement(driver, termsAndPoliiciesTermsOfUseLinkText);
		termsAndPoliiciesTermsOfUseLinkText.click();
	}

	//Method to Click on Quotes in utility bar
	public void clickQuotesUtilityBar() throws InterruptedException {
		waitTool.waitForElement(driver,	topHeaderquotesLinkText);
		topHeaderquotesLinkText.click();
		waitTool.waitFor(driver, true);

	}

	//Method to Click on SavedList in utility bar {once clicked not sure to which its navigated.)
	public void clickSavedListUtilityBar() throws InterruptedException {
		waitTool.waitForElement(driver, topHeaderSavedlistLinkText);
		pageManager.common().scrolltoViewElement(topHeaderSavedlistLinkText, driver);
		topHeaderSavedlistLinkText.click();
		waitTool.waitFor(driver, true);

	}

	/**
	 * Click on the account in my accounts.
	 * @return the signed in user name text
	 */
	public void clickAccount() throws InterruptedException {
		waitTool.waitForElement(driver, account);
		account.click();
		waitTool.waitFor(driver, true);

		
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

	public Boolean isDisplayedUserNameText() {

		return userNameText.isDisplayed();
	}

	/**
	 * @return true if property dropdown is displayed on header otherwise false
	 */
	public Boolean isDisplayedPropertyDropdown() {
		waitTool.waitForElement(driver, propertyDropdown);
		pageManager.common().scrolltoViewElement(propertyDropdown, driver);
		return pageManager.common().isElementPresent(propertyDropdown);
	}

	/**
	 * click on property dropdown on header
	 * @return the driver to Property lookup page
	 */
	public void clickPropertyDropdown() {

		pageManager.common().scrolltoViewElement(propertyDropdown, driver);
		propertyDropdown.click();
	}

	/**
	 * @return the user Account name
	 */
	public String getUserAccountName() {
		waitTool.waitForElement(driver, propertyDropdown);
		return propertyDropdown.getText().trim();
	}
	
	public String getUserAccountNameText() {
		waitTool.waitForElement(driver, userNameText);
		return userNameText.getText().trim();
	}
	
	/**
	 * @return true if Content Heros is present in homepage otherwise false
	 */
	public boolean isDisplayedContentHeros()
	{
		pageManager.common().scrolltoViewElement(contentHeros1, driver);
		return contentHeros1.isEnabled();

	}

	/**
	 * @return true if static website help label is present in utility bar otherwise false
	 */
	public Boolean isDisplayedStaticWebsiteHelpLabel() {
		return pageManager.common().isElementPresent(websiteHelpLabel);
	}

	/**
	 * @return true if static website help Phone number is present in utility bar otherwise false
	 */
	public Boolean isDisplayedStaticWebsiteHelpPhoneNumber() {
		return pageManager.common().isElementPresent(websiteHelpPhoneNumberText);
	}

	/**
	 * @return true if static website help hours is present in utility bar otherwise false
	 */
	public Boolean isDisplayedStaticWebsiteHelpTime() {
		return pageManager.common().isElementPresent(websiteHelpTimeText);
	}


	public boolean isDisplayedMyAccountQuotesQuickLinkInUtilityBar(){
		waitTool.waitForElement(driver,topHeaderquotesLinkText);
		return topHeaderquotesLinkText.isDisplayed();
	}

	/**
	 * click on My Account Subscriptions quick link
	 * @return the driver to Saved Lists Page
	 */
	public void clickMyAccountSubscriptionsQuickLink(){
		pageManager.common().scrolltoViewElement(headerSubscriptionsLinkText,driver);
		waitTool.waitForElement(driver, headerSubscriptionsLinkText);
		headerSubscriptionsLinkText.click();
		waitTool.waitFor(driver, true);
	}

	/**
	 * @return true if My account Subscriptions quick link is displayed on homepage otherwise false
	 */
	public boolean isDisplayedMyAccountSubscriptionsQuickLinkInUtilityBar(){
		waitTool.waitForElement(driver, headerSubscriptionsLinkText);
		pageManager.common().scrolltoViewElement(headerSubscriptionsLinkText, driver);
		return headerSubscriptionsLinkText.isDisplayed();
	}

	/**
	 * click on My Account Saved Lists quick link
	 * @return the driver to Saved Lists Page
	 */
	public void clickMyAccountSavedListsQuickLink(){
		driver.navigate().refresh();
		waitTool.waitForElement(driver,topHeaderSavedlistLinkText);
		pageManager.common().scrolltoViewElement(topHeaderSavedlistLinkText, driver);
		topHeaderSavedlistLinkText.click();
	}

	/**
	 * @return true if My account Saved Lists quick link is displayed on homepage otherwise false
	 */
	public boolean isDisplayedMyAccountSavedListsQuickLinkInUtilityBar(){
		return topHeaderSavedlistLinkText.isDisplayed();
	}


	/**
	 * @return true if My account Frequently Purchased quick link is displayed on homepage otherwise false
	 */
	public boolean isDisplayedMyAccountFrequentlyPurchasedQuickLinkInUtilityBar(){
		return frequentlyPurchasedLink.isDisplayed();

	}


	/**
	 * click on My Account  Order History & Status quick link
	 * @return the driver to rder History & Status Page
	 */
	public void clickTopHeaderOrderHistoryStatusLink(){
		//waitTool.waitForElement(driver, topHeaderorderHisStatusLinkText);
		pageManager.common().scrollUp(driver);
		topHeaderorderHisStatusLinkText.click();
		//waitTool.waitFor(driver, true);
		// return new OrdersPage(driver);
	}

	/**
	 * @return true if My account Order History & Status quick link is displayed on homepage otherwise false
	 */
	public boolean isDisplayedTopHeaderOrderHistoryStatusLink(){
		return topHeaderorderHisStatusLinkText.isDisplayed();
	}

	/**
	 * @return true if Category Left navigation is present on homepage otherwise false
	 */
	public boolean isDisplayedCategoryleftNavigation() {
		return pageManager.common().isElementPresent(categoryApplianceLeftNavigationLinkText);
	}

	//Method to enter items in Search box
	public void enterSearchEdit(String partNumber) {
		searchBox.clear();
		searchBox.sendKeys(partNumber);
	}

	public Boolean isOrderAgainDisplayed()
	{
		pageManager.common().scrollDown(driver);
		return orderAgainLabel.isDisplayed();
	}


	public Boolean isViewOrderHistoryButtonDisplayed()
	{
		pageManager.common().scrollDown(driver);
		return viewOrderHistoryButton.isDisplayed();
	}

	public boolean isDisplayedHDSPopularProductsCarousel(){
		return hdsPopularProductsCarousel.isDisplayed();
	}

	public Boolean isEightPartNumbersInsideOrderOnceSectionDisplayed()
	{
		Boolean flag=false;
		for(WebElement pn : eightPartNumbersInsideOrderOnceSection)
		{
			if(pn.isDisplayed())
			{
				flag=true;
			}
		}
		return flag;
	}

	public Boolean isEightImagesInsideOrderOnceSectionDisplayed()
	{

		Boolean flag=false;
		for(WebElement image : eightImagesInsideOrderOnceSection)
		{
			if(image.isDisplayed())
			{
				flag=true;
			}
		}
		return flag;
	}

	public Boolean isEightProductDescriptionsInsideOrderOnceSectionDisplayed()
	{

		Boolean flag=false;
		for(WebElement pn : eightProductDescriptionsInsideOrderOnceSection)
		{
			if(pn.isDisplayed())
			{
				flag=true;
			}
		}
		return flag;

	}

	public Boolean isEightPricesInsideOrderOnceSectionDisplayed()
	{
		Boolean flag=false;
		for(WebElement price : eightPricesInsideOrderOnceSection)
		{
			if(price.isDisplayed())
			{
				flag=true;
			}
		}
		return flag;
	}

	public Boolean isEightAddToCartButtonsInsideOrderOnceSectionDisplayed()
	{
		Boolean flag=false;
		for(WebElement atc : eightAddToCartButtonInsideOrderOnceSection)
		{
			if(atc.isDisplayed())
			{
				flag=true;
			}
		}
		return flag;
	}

	public Boolean isFourProductVisibleInsideOrderOnceSection()
	{
		return fourProductVisibleAtATimeInOrderOnceSection.isDisplayed();
	}

	public void clickForwardKeyInsideOrderOnceSection()
	{
		pageManager.common().scrolltoViewElement(forwardKeyInsideOrdereOnceSection, driver);
		forwardKeyInsideOrdereOnceSection.click();
	}

	public void clickBackwardKeyInsideOrderOnceSection()
	{
		pageManager.common().scrolltoViewElement(backwardKeyInsideOrdereOnceSection, driver);
		backwardKeyInsideOrdereOnceSection.click();
	}

	public void navigateBack()
	{
		pageManager.common().navigateBack();
		pageManager.common().refresh();
	}

	public void clickOnFirstProductInsideOrderOnceSection()
	{
		firstProductInsideOrderOnceSection.click();

	}

	public void clickHeaderOrderAgain() throws InterruptedException {
		waitTool.waitForElement(driver, headerOrderAgain);
		headerOrderAgain.click();
		waitTool.waitFor(driver, true);
		//return new Appliances();
		//return null;
	}

	public boolean isHeaderOrderAgainDisplayed(){
		waitTool.waitForElement(driver, headerOrderAgain);
		return headerOrderAgain.isDisplayed();

	}

	//Method to Click on frequently purchased in utility bar
	public void clickFrePurchasedUtilityBar() throws InterruptedException {
		waitTool.waitForElement(driver,	frequentlyPurchasedLink);
		frequentlyPurchasedLink.click();
		waitTool.waitFor(driver, true);

	}

	//Method to Click on order history link in utility bar
	/* public void clickFrePurchasSavedHistoryUtilityBar() throws InterruptedException {
       waitTool.waitForElement(driver,	topHeaderorderHisStatusLinkText);
        topHeaderorderHisStatusLinkText.click();
       waitTool.waitFor(driver, true);
    }*/

	public String returnWelcomeNote() {
		return getWelcomeNote();
	}



	//Method to click on category appliances.

	public void clickCategoryAppliancessLinkText() throws Exception {
		waitTool.waitForElement(driver,	categoryAppliancesLinkText);
		pageManager.common().scrolltoViewElement(categoryAppliancesLinkText, driver);
		categoryAppliancesLinkText.click();
		waitTool.waitFor(driver, true);

	}

	//Method to click on search button
	public void clickSearchButton() throws InterruptedException {
		waitTool.waitForElement(driver,	searchButton);
		searchButton.click();
		waitTool.waitFor(driver, true);

	}

	/**
	 * @name verifyBreadCrumbForCurrentPage
	 * @description Method to verify BreadCrumb For CurrentPage
	 * param text value (current page)
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
	 * param String list
	 * @return boolean match
	 *
	 */
	public boolean verifyexploreHDSupplyDropDownOptions(String drpDownList) throws Exception{
		List<WebElement> accountLabelsList=pageManager.common().selectDropdownOptions(driver, exploreHDSupplyDropDown);
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
	 * param WebElement List
	 * @return
	 *
	 */
	public void selectOptionsFromIndustryTypeDowndown(List<WebElement> accountLabelsList) throws InterruptedException {
		accountLabelsList = pageManager.common().selectDropdownOptions(driver, exploreHDSupplyDropDown);
		pageManager.common().scrolltoViewElement(exploreHDSupplyDropDown, driver);
		exploreHDSupplyDropDown.click();
		System.out.print(accountLabelsList.get(1).getText());
		pageManager.common().selectSearchDropdown1(exploreHDSupplyDropDown, accountLabelsList.get(1).getText());
	}


	/**
	 * @name isDisplayedsearchSuggestedProducts
	 * @description Method to verify presence of searchSuggestedProducts list
	 * param String
	 * @return Boolean
	 *
	 */
	public boolean isDisplayedsearchSuggestedProducts(String searchData) throws Exception{
		boolean status = false;
		if(pageManager.common().isElementPresent(suggestedProductsResultsBlock)) {
			for (int i=0;i<suggestedProductsResultsList.size();i++) {
				if(suggestedProductsResultsList.get(i).getText().contains(searchData)) {
					status = true;
				}else
					break;
			}
		}
		return status;
	}


	/**
	 * @name clickOnSuggestedSearchResult
	 * @description Method to Click on first suggested search result.
	 * @param
	 * @return page
	 *
	 */
	public void clickOnQuickOrderLink()
	{
		headerQuickOrderLinkText.click();

	}

	public void clickOnSuggestedSearchResult() throws Exception{
		waitTool.waitForElement(driver, suggestedProductsResultsList.get(0));
		suggestedProductsResultsList.get(0).click();
		waitTool.waitFor(driver, true);

	}


	// Method to Verify HD Logo
	public boolean isDisplayedHeaderHDLogoImage(){
		waitTool.waitForElement(driver, hDSupplyLogoInHeader);
		pageManager.common().scrolltoViewElement(hDSupplyLogoInHeader, driver);
		return pageManager.common().isElementPresent(hDSupplyLogoInHeader);
	}


	public void clickOnHDSupplyLogoInHeader() throws Exception
	{
		waitTool.waitForElement(driver,hDSupplyLogoInHeader);
		pageManager.common().scrolltoViewElement(hDSupplyLogoInHeader, driver);
		hDSupplyLogoInHeader.click();
		System.out.println("waited and clicked on clickOnHDSupplyLogoInHeader");
	}

	public void searchByPartNumber(String partNumber)
	{
		searchBox.sendKeys(partNumber);
		searchButton.click();

	}

	public void searchByKeywordOrPartNumber(String keyword)
	{
		waitTool.waitForElement(driver,searchBox);
		searchBox.getSize();
		searchBox.clear();
		searchBox.sendKeys(keyword);
		pageManager.common().scrolltoViewElement(searchButton, driver);
		searchButton.click();

	}

	public void searchKeywordOrPartNumber(String keyword)
	{
		waitTool.waitForElement(driver,searchBox);
		// wait.until(ExpectedConditions.visibilityOf(searchBox));
		pageManager.common().scrolltoViewElement(searchBox, driver);
		searchBox.clear();
		searchBox.sendKeys(keyword);
		//	.scrolltoViewElement(searchButton, driver);
		searchButton.click();

	}

	public void searchDescription(String keyword)
	{
		searchBox.sendKeys(keyword);
		searchButton.click();

	}

	/*public OfferPage isMovetoOfferPage()
	{
		offerLink.click();
		return new OfferPage(driver);
	}*/

	public Boolean isResourceFlyoutDisplayed()
	{
		return pageManager.common().isElementPresent(resourcesFlyout);
	}

	public void clickECatalogLink()
	{
		eCatalogLink.click();
		// return new EcatalogPage(driver);
	}

	/**
	 * @name selectOptionsFromIndustryTypeDowndown
	 * @description Method to click on option from the industry dropdown.
	 * param WebElement List
	 */
	public void selectOptionsFromIndustryTypeDowndown(String option) throws InterruptedException {
		//accountLabelsList = .selectDropdownOptions(driver, exploreHDSupplyDropDown);
		pageManager.common().scrolltoViewElement(exploreHDSupplyDropDown, driver);
		exploreHDSupplyDropDown.click();
		System.out.print("option to select" +option);
		pageManager.common().selectSearchDropdown1(exploreHDSupplyDropDown, option);
	}

	public void clickOnShoppingCartIcon() throws Exception {
		try 
		{
			pageManager.common().scrolltoViewElement(shoppingCartIcon, driver);
			shoppingCartIcon.click();
		}
		catch(StaleElementReferenceException e)
		{
			pageManager.common().scrolltoViewElement(shoppingCartIcon, driver);
			shoppingCartIcon.click();
		}
	}


	/**  Method to click on Category or subcategory. {applicable for left navigation and shopByCategory]
	 * @param driver
	 * param String (Category or Subcategoryname)
	 */
	public void clickOnCategoryOrSubcategory(WebDriver driver,String data,Boolean shopByCategoryPresent ) throws Exception {
		data.toLowerCase();
		WordUtils.capitalize(data);
		String xpath = "//div[contains(text(),";
		String xpath1 = "//div[@class='nav__shop-by-category']//li/a[text()=";
		if (shopByCategoryPresent==true)
			driver.findElement(By.xpath(xpath1 + "'" + data + "']")).click();
		else{
			if(pageManager.common().isElementPresent(driver,By.linkText(data)))
				driver.findElement(By.linkText(data)).click();
			else if(pageManager.common().isElementPresent(driver,By.xpath(xpath + "'" + data + "')]")))
				driver.findElement(By.xpath(xpath + "'" + data + "')]")).click();
		}
	}


	public boolean isDisplayedtopCategoriesCarouselSection() {
		pageManager.common()	.scrollDown(driver);
		pageManager.common().scrollDown(driver);
		pageManager.common().scrolltoViewElement(topCategoriesCarouselSection, driver);
		return topCategoriesCarouselSection.isDisplayed();
	}


	public void verifyLink() {
		//Sometimes we may face exception "java.net.MalformedURLException". Keep the code in try catch block to continue the broken link analysis
		try {
			//To print the total number of links
			System.out.println("Total links are "+links.size());
			//used for loop to get URLs

			for(int i=0; i<links.size(); i++) {
				WebElement element = links.get(i);
				//By using "href" attribute, we could get the url of the requried link
				String url =element.getAttribute("href");
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
		}
		//getResponseCode method returns = IOException - if an error occurred connecting to the server.

		catch (Exception e) {
			//e.printStackTrace();
		}}

	/**
	 * @author nm064123
	 * Method to click input search by category name and pass to generic search results page
	 */

	public void searchByCategoryName(String keyword)
	{
		searchBox.sendKeys(keyword);
		searchButton.click();

	}

	public boolean IsHeroImageCarouselOneDisplayed() throws Exception
	{
		firstRadioButtonInsidePageControlPanel.click();
		//waitTool.hardWait();
		waitTool.waitForElement(driver, heroImageCarouselOne);
		return heroImageCarouselOne.isDisplayed();
	}

	public boolean IsHeroImageCarouselTwoDisplayed() throws Exception
	{
		secondRadioButtonInsidePageControlPanel.click();
		waitTool.waitForElement(driver, heroImageCarouselOne);
		return heroImageCarouselTwo.isDisplayed();
	}

	public boolean IsHeroImageCarouselThreeDisplayed() throws Exception
	{
		thirdRadioButtonInsidePageControlPanel.click();
		//waitTool.hardWait();
		waitTool.waitForElement(driver, heroImageCarouselThree);
		return heroImageCarouselThree.isDisplayed();
	}

	public boolean isDisplayedPromotionalContent() {

		waitTool.waitForElement(driver, promotionalContent);
		return pageManager.common().isElementPresent(promotionalContent);
	}

	public boolean isDisplayedSearchBox(){
		waitTool.waitForElement(driver, searchBox);
		pageManager.common().scrolltoViewElement(searchBox, driver);
		return pageManager.common().isElementPresent(searchBox);
	}

	public boolean replacementPartText() {
		waitTool.waitForElement(driver, replacementPartText);
		pageManager.common().scrolltoViewElement(replacementPartText, driver);
		return  replacementPartText.isDisplayed();
	}

	public void clickOnAccount0012482415UnderUser()
	{
		pageManager.common().scrolltoViewElement(account0012482415UnderUserModal, driver);
		account0012482415UnderUserModal.click();
	}

	public void clickOnAccount0012482411UnderUser() throws Exception
	{
		waitTool.waitForElement(driver, account0012482411UnderUserModal);
		pageManager.common().scrolltoViewElement(account0012482411UnderUserModal, driver);
		account0012482411UnderUserModal.click();
	}

	public Boolean isYourTopCategoriesCarouselSection()
	{
		pageManager.common().scrolltoViewElement(yourTopCategoriesCarouselSection, driver);
		waitTool.waitForElement(driver, yourTopCategoriesCarouselSection);
		return yourTopCategoriesCarouselSection.isDisplayed();
	}
	
	public Boolean isDisplayedOrderAgainContentRecommandation()
	{
		waitTool.waitForElement(driver, OrderAgainContentRecommandation);
		pageManager.common().scrolltoViewElement(OrderAgainContentRecommandation, driver);
		return OrderAgainContentRecommandation.isDisplayed();
	}

	// Method to Verify for L1 ShopBy Category
	public boolean isDisplayedShopByCategoryL1(){
		waitTool.waitForElement(driver, flyoutShopByCategoryL1Image);
		pageManager.common().scrolltoViewElement(flyoutShopByCategoryL1Image, driver);
		return pageManager.common().isElementPresent(flyoutShopByCategoryL1Image);
	}

	// Method to Verify for L2 ShopBy Category
	public boolean isDisplayedShopByCategoryL2(){
		waitTool.waitForElement(driver, flyoutShopByCategoryL2Image);
		pageManager.common().scrolltoViewElement(flyoutShopByCategoryL2Image, driver);
		return pageManager.common().isElementPresent(flyoutShopByCategoryL2Image);
	}

	// Method to Verify for L3 ShopBy Category
	public boolean isDisplayedShopByCategoryL3(){
		waitTool.waitForElement(driver, flyoutShopByCategoryL3Image);
		pageManager.common().scrolltoViewElement(flyoutShopByCategoryL3Image, driver);
		return pageManager.common().isElementPresent(flyoutShopByCategoryL3Image);
	}

	// Method to click on the BreadCrumb in any of the Pages
	public void clickBreadCrumbHomeLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, pageManager.commonPageObjects().breadCrumbHomeLinkText);
		pageManager.commonPageObjects().breadCrumbHomeLinkText.click();

	}

	// Method to Verify for Left Navigation
	public boolean isDisplayedLeftNavgation(){
		waitTool.waitForElement(driver, leftNavigationImage);
		pageManager.common().scrolltoViewElement(leftNavigationImage, driver);
		return pageManager.common().isElementPresent(leftNavigationImage);
	}

	// Method to get the Categories
	public String getCategoryPageHeadingText() {
		waitTool.waitForElement(driver, categoryPageHeadingText);
		pageManager.common().scrolltoViewElement(categoryPageHeadingText, driver);
		return categoryPageHeadingText.getText().trim();
	}

	public boolean categoryPageHeadingTextIsDisplayed() {
		waitTool.waitForElement(driver, categoryPageHeadingText);
		pageManager.common().scrolltoViewElement(categoryPageHeadingText, driver);
		return categoryPageHeadingText.isDisplayed();
	}

	// Method to Click on Shop By Category in Header
	public void clickHeaderShopByCategoryLinkText()
	{
		waitTool.waitForElement(driver, headerShopByCategoryLinkText);
		pageManager.common().scrolltoViewElement(headerShopByCategoryLinkText, driver);
		headerShopByCategoryLinkText.click();
		waitTool.waitFor(driver,true);
	}

	public Boolean isYourTopCategoriesTitleDisplayed()
	{
		waitTool.waitForElement(driver, yourTopCategoriesTitle);
		pageManager.common().scrolltoViewElement(yourTopCategoriesTitle, driver);
		waitTool.waitForElement(driver, yourTopCategoriesTitle);
		return yourTopCategoriesTitle.isDisplayed();
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
		pageManager.common().moveToNewWindow(driver);
	}

	public String getTitle()
	{
		return pageManager.common().getTitle(driver);
	}

	public void moveToParentWindow()
	{
		pageManager.common().closecurrentBrowser(driver);
		pageManager.common().moveToNewWindow(driver);
	}

	public void selectPropertyDropdownForProd_wchoi() throws Exception
	{
		waitTool.waitVisibility(driver, propertyDropdown, 60);
		pageManager.common().scrolltoViewElement(propertyDropdown, driver);
		propertyDropdown.click();
		waitTool.waitForElement(driver, account0012482411UnderUserModal);
		pageManager.common().scrolltoViewElement(account0012482411UnderUserModal, driver);
		account0012482411UnderUserModal.click();

	}


	public int getShoppingCartProductCount()
	{
		String value;
		waitTool.waitFor(driver, true);
		try 
		{
			waitTool.waitForElement(driver,shoppingCartProductCount);
			value = shoppingCartProductCount.getText().trim();
		}
		catch(StaleElementReferenceException e)
		{
			System.out.println("Exception occured while getShoppingCartProductCount" + e);
			waitTool.waitForElement(driver,shoppingCartProductCount);
			value = shoppingCartProductCount.getText().trim();
		}
		System.out.println("value is "+ value);
		return Integer.parseInt(value);
	}

	public void HomePageRefresh(){
		pageManager.common().refresh();
	}
	public int counterIncrease(int counterValue)
	{
		counterValue=counterValue+1;
		return counterValue;
	}

	public void closeManagementPopup() throws Exception {
		try {
			clickToBeginSurveyButton.isDisplayed();
			NoThanksOnManagementPopup.click();
			System.out.println("management popup appeared and closed :");
		} catch (Exception e) {
			System.out.println("management popup does not appear");
		}
	}

	public void clickOnPriceLessThan25CheckBox(){
			waitTool.waitForElement(driver, priceLessThan25CheckBox);
		pageManager.common().scrolltoViewElement(priceLessThan25CheckBox, driver);
			priceLessThan25CheckBox.click();
		/*try {
			waitTool.waitForElement(driver, priceLessThan25CheckBox);
			.scrolltoViewElement(priceLessThan25CheckBox, driver);
			priceLessThan25CheckBox.click();
		}
		catch(Exception e)
		{
			System.out.println("priceLessThan25CheckBox is not displayed" + e);
		}*/
		//	driver.manage().timeouts().pageLoadTimeout(waitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	}
	
	public void clickOnPriceDropdown(){
		waitTool.waitForElement(driver, priceDropdown);
		pageManager.common().scrolltoViewElement(priceDropdown, driver);
		priceDropdown.click();
	}

	public Boolean IsSelectedPriceLessThan25CheckBox(){

		waitTool.waitForElement(driver, priceLessThan25CheckBox);
		pageManager.common().scrolltoViewElement(priceLessThan25CheckBox, driver);
		return priceLessThan25CheckBox.isEnabled();
	}





	public void verifyAllSubcategoryPage(String rowName, String sheetName) throws Exception {
				usersList = pageManager.dBCon().loadDataFromExcel(rowName, sheetName);
				for (int i = 0; i < categoriesAllLinks.size(); i++) {
					if (categoriesAllLinks.get(i).getText().contains(usersList.get(0).getCategory())) {

						System.out.println("Focused category: " + categoriesAllLinks.get(i).getText());
						System.out.println("Category clicking: " + categoriesAllLinks.get(i).getText());
						categoriesAllLinks.get(i).click();
						waitTool.waitFor(driver,true);
						int subcategorylinkcount =  subcategoriesAllLinks.size();
						subcategoriesAllLinks.get(0).click();
						if (subcategoriesAllLinks.size() > subcategorylinkcount) {
							waitTool.waitForElement(driver, subcategoriesAllLinks.get(1));
							subcategoriesAllLinks.get(1).click();
						}
						Assert.assertTrue(pageManager.homePage().categoryPageHeadingTextIsDisplayed());

					//	if (subcategoriesAllLinks.size() > 0) {

				//		}
					}
				}
	}


	
	public void closePropertiesPopupAndClickCancel()
	{
		propertiesPopUpWindow.isDisplayed();
		propertiesPopUpCloseLink.click();
		pageManager.common().cancelPopupMessageBox(driver);
	}

	
	public void closePropertiesPopupIfDisplayed()
	{
		try
		{
			propertiesPopUpWindow.isDisplayed();
			System.out.println("before clicking ");
			pageManager.common().scrolltoViewElement(accountNumbersOnPropertyModalWindow.get(0), driver);
			accountNumbersOnPropertyModalWindow.get(0).click();
			System.out.println("before clicking ");
		}
		catch(Exception e)
		{
			System.out.println("property modal window does not displayed");
		}
	}
	
	public String getAccountNumber()
	{
		String accountNumber = getUserAccountNumber();
		accountNumber=accountNumber.substring(accountNumber.lastIndexOf("#")+1);
		System.out.println("accountNumber on homepage"+ accountNumber.trim());
		return accountNumber.trim();
	}
	
	public void selectAccountNumberFromPropertiesWindow(String accountNumber)
	{
		for(WebElement accountNumberOnPropertyModalWindow: accountNumbersOnPropertyModalWindow)
		{
				if(accountNumberOnPropertyModalWindow.getText().contains(accountNumber))
				{
					accountNumberOnPropertyModalWindow.click();
					break;
				}
		}
	}
	
	public void selectFirstAccountNumberFromPropertiesWindow()
	{
	
		pageManager.common().scrolltoClickElement(accountNumbersOnPropertyModalWindow.get(0), driver);
	}
	
	public String getValueFromSearchTextBox()
	{
		pageManager.common().scrolltoViewElement(searchBox, driver);
		searchBox.getText();
		return searchBox.getAttribute("value");
	}
	
	public Boolean isAutoCompleteSectionDisplayed()
	{
		Boolean flag= false;
		/*waitTool.waitForElement(driver, autoCompleteSection);
		return autoCompleteSection.isDisplayed();*/
		try
		{
			waitTool.waitForElement(driver, autoCompleteSection);
			autoCompleteSection.isDisplayed();
			flag=true;
			
		}
		catch(Exception e)
		{
			System.out.println("auto suggested section is not displayed");
		}
		return flag;
	}
	
	public void clickOnLastPartFromAutoCompleteSection() throws InterruptedException
	{
		pageManager.common().scrollDown(driver);
		pageManager.common().scrolltoViewElement(partsListInAutoCompleteSection.get(partsListInAutoCompleteSection.size()-1), driver);
		System.out.println("tst is " + partsListInAutoCompleteSection.get(partsListInAutoCompleteSection.size()-1).getText());
	//	Thread.sleep(3000);
		partsListInAutoCompleteSection.get(partsListInAutoCompleteSection.size()-1).click();
	}
	
	public String getCountOfPartsListedInAutoCompleteSection()
	{
		int count = partsListInAutoCompleteSection.size();
		System.out.println("count is "+ count);
		return Integer.toString(count);
	}
	
	public void navigateToPoolCareAndMaintenance()
	{
		headerResourcesLinkText.click();
		productResourceLinkFromResourceFlyout.click();
		poolCareAndMaintenanceLinkFromResourceFlyout.click();
	}
	
	public Boolean isSiteMapTextDisplayed() 
	{
		waitTool.waitForElement(driver, siteMapText);
		return siteMapText.isDisplayed();
	}
	
		public Boolean isPartNumberInsideOrderOnceSectionDisplayed()
	{
		waitTool.waitForElement(driver, partNumberInsideOrderOnceSection);
		pageManager.common().scrolltoViewElement(partNumberInsideOrderOnceSection, driver);
		
		return partNumberInsideOrderOnceSection.isDisplayed();
	}

		public Boolean isDisplayedlearnSomethingNew(){
			waitTool.waitForElement(driver, learnSomethingNew);
			pageManager.common().scrolltoViewElement(learnSomethingNew, driver);	
			return pageManager.common().isElementPresent(learnSomethingNew);
		}  

		public Boolean isDisplayedlearnSomethingNewRightBlock(){
			waitTool.waitForElement(driver, learnSomethingNewRightBlock);
			pageManager.common().scrolltoViewElement(learnSomethingNewRightBlock, driver);
			return learnSomethingNewRightBlock.isDisplayed();
		}  

		public Boolean isDisplayedlearnSomethingNewLeftBlock(){
			waitTool.waitForElement(driver, learnSomethingNewLeftBlock);
			pageManager.common().scrolltoViewElement(learnSomethingNewLeftBlock, driver);
			return learnSomethingNewRightBlock.isDisplayed();
		}  		

	public int getCountOfProductImagesInSuggestedProductsResultsBlock()
	{
		waitTool.waitForElement(driver, suggestedProductsResultsBlock);
		pageManager.common().scrolltoViewElement(suggestedProductsResultsBlock, driver);
		return productImagesInSuggestedProductsResultsBlock.size();
	}
	
	public Boolean ispropertyModalWindowDisplayed()
	{
		waitTool.waitForElement(driver, propertiesPopUpWindow);
		return propertiesPopUpWindow.isDisplayed();
	}
	
}



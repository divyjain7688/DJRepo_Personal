package com.selenium.ebiz.account_management.login;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;

/*
 * @author dj073227
 *
 */
public class HomePageAuthenticatedUser extends BaseClassV8_ParallelGrid
{

	int expectedPartNumbersInsideOrderOnceSection=8;
	int expectedImagesInsideOrderOnceSection = 8;
	int expectedProductDescriptionsInsideOrderOnceSection = 8;
	int expectedPricesInsideOrderOnceSection = 8;
	int expectedAddToCartButtonsInsideOrderOnceSection = 8;
	String facebook = "Facebook";
	String twitter = "Twitter";
	String googleplus = "Google+";
	String linkedin = "LinkedIn";
	String youtube = "YouTube";
	private ArrayList<UsersListBean> usersList;


	/** dj073227
	 * US-Cat-920 - This method is used to verify that footer links ie AboutUs,Returns,Terms
	 *  and Conditions, Help are displayed on Home page
	 * @throws Exception 
	 * @throws  
	 */
	//Modified: Bhavani 09/09/2019: Updated xpaths for aboutusLink, ReturnsLink, TermsAndPoliciesLink, HelpLink
	@Test(dataProvider = "browsers")
	public void login_verifyFooterLinksTest(String browser, String version, String os, Method method) throws Exception 
	{
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		
		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());	
		Assert.assertTrue(pageManager.homePage().isAboutUsDisplayed());
		Assert.assertTrue(pageManager.homePage().isReturnsLinkDisplayed());
		Assert.assertTrue(pageManager.homePage().isTermsAndPoliciesLinkDisplayed());
		Assert.assertTrue(pageManager.homePage().isHelpLinkDisplayed());
	}


	/** dj073227
	 * US-Cat-922 - This method is used to verify that social networking links are displayed 
	 * on Home Page
	 */
	//Modified: Bhavani
	@Test(dataProvider = "browsers")
	public void login_verifyFacebookLink(String browser, String version, String os, Method method) throws Exception 
	{
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());	
		Boolean aboutUsDisplayed = pageManager.homePage().isAboutUsDisplayed();
		pageManager.homePage().isFacebookLinkDisplayed();
		String title = pageManager.homePage().clickOnFacebookLink();
		Assert.assertTrue(aboutUsDisplayed);
		Assert.assertTrue(title.contains(facebook));
	}
	
	//Modified: Bhavani
	@Test(dataProvider = "browsers")
	public void login_verifyTwitterLink(String browser, String version, String os, Method method) throws Exception 
	{
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());	
		pageManager.homePage().isTwitterLinkDisplayed();
		String title = pageManager.homePage().clickOnTwitterLink();
		Assert.assertTrue(title.contains(twitter));
	}

	//Modified: Bhavani
	@Test(dataProvider = "browsers")
	public void login_verifyLinkedInLink(String browser, String version, String os, Method method) throws Exception 
	{
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());	
		Assert.assertTrue(pageManager.homePage().isLinkedinLinkDisplayed());
		String title = pageManager.homePage().clickOnLinkedinLink();
		Assert.assertTrue(title.contains(linkedin));
	}
	
	//Modified: Bhavani
	@Test(dataProvider = "browsers")
	public void login_verifyYouTubeLink(String browser, String version, String os, Method method) throws Exception 
	{
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());	
		pageManager.homePage().isYoutubeLinkDisplayed();
		String title = pageManager.homePage().clickOnYoutubeLink();
		Assert.assertTrue(title.contains(youtube));
	}
	
	/** dj073227
	 * US-Cat-931 - This method is used to verify that HD supply logo is displayed
	 * on Home Page
	 * @throws Exception 
	 * @throws  
	 */
	@Test(description="verifyHDSupplyLogoTest", dataProvider = "browsers")
	public void login_verifyHDSupplyLogoTest(String browser, String version, String os, Method method) throws  Exception 
	{
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		
		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
		Assert.assertTrue(pageManager.homePage().isAboutUsDisplayed());
		Assert.assertTrue(pageManager.homePage().isHDSupplyLogoDisplayed());
	}

	/** dj073227
	 * US-PostOrd-002 -This test is used to verify that once user logged in, user should be able to see "Order once" section in 
	 * home page and also he can navigate to PDP page by clicking any product from Order once section.
	 * @throws Exception 
	 * @throws  
	 */
	
	/* Modidfied: Bhavani 09/09/2019 Updated the eightPartNumbersInsideOrderOnceSection xpath in HomePage at line 516
	 			  Updated Order History title xpath in OrdersPage at line 28 and updated lines 153, 156 by calling respective methods
	 			  Added Asserts	*/
	@Test(dataProvider = "browsers",enabled=false)
	public void login_verifyOnceOrderSection(String browser, String version, String os, Method method) throws  Exception
	{
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		
		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
		Assert.assertTrue(pageManager.homePage().isOrderAgainDisplayed());
		
		Assert.assertTrue(pageManager.homePage().isEightPartNumbersInsideOrderOnceSectionDisplayed()); 
		Assert.assertTrue(pageManager.homePage().isViewOrderHistoryButtonDisplayed());
		Assert.assertTrue(pageManager.homePage().isEightImagesInsideOrderOnceSectionDisplayed()); 
		Assert.assertTrue(pageManager.homePage().isEightProductDescriptionsInsideOrderOnceSectionDisplayed());
		Assert.assertTrue(pageManager.homePage().isEightPricesInsideOrderOnceSectionDisplayed());
		Assert.assertTrue(pageManager.homePage().isEightAddToCartButtonsInsideOrderOnceSectionDisplayed());
		Assert.assertTrue(pageManager.homePage().isFourProductVisibleInsideOrderOnceSection());

		pageManager.homePage().clickForwardKeyInsideOrderOnceSection();
		Assert.assertTrue(pageManager.homePage().isFourProductVisibleInsideOrderOnceSection());
		
		pageManager.homePage().clickBackwardKeyInsideOrderOnceSection();
		Assert.assertTrue(pageManager.homePage().isFourProductVisibleInsideOrderOnceSection());
		
		pageManager.homePage().clickOnFirstProductInsideOrderOnceSection();
		Assert.assertTrue(pageManager.productDetailsPage().isDisplayedproductDetailsHeader());
		pageManager.homePage().navigateBack();
		pageManager.homePage().clickOnViewOrderHistoryButton();
		Assert.assertTrue(pageManager.ordersPage().isDisplayedOrderspageHeading());
	}

	/** dj073227
	 * US-Cat-951 - This method is used to verify that when user logged in and search any product with either keyword
	 * or partnumber, user should be able to see result on search page.
	 */
	//Modified: Bhavani 09/09/19 Added asserts
	@Test(description="searchByKeywordOrPartNumber", dataProvider = "browsers")
	public void login_verifySearchByKeywordOrPartNumber(String browser, String version, String os, Method method) throws  Exception
	{		
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		
		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
		usersList=pageManager.dBCon().loadDataFromExcel("searchByKeywordOrPartNumber","Search");
		pageManager.homePage().searchByKeywordOrPartNumber(usersList.get(0).getSearchProductKeyword());
		Boolean isDisplayedPLPTitle = pageManager.productListingPage().isPlpHeadingTextDisplayed();
		
		pageManager.homePage().navigateBack();
		pageManager.homePage().searchByKeywordOrPartNumber(usersList.get(0).getSearchProductPartNumber());
		Assert.assertTrue(isDisplayedPLPTitle);
		Assert.assertTrue(pageManager.productDetailsPage().isDisplayedproductDetailsHeader());

	}
	/** dj073227
	 * US-Cat-963 - This method is used to verify that user logged in and successfully navigates
	 * to offers page
	 * @throws Exception 
	 * @throws  
	 */
	@Test(description="moveToOfferPage", dataProvider = "browsers")
	public void login_moveToOfferPage(String browser, String version, String os, Method method) throws Exception
	{
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		
		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
		pageManager.homePage().clickOfferLink();
		Assert.assertTrue(pageManager.offerPage().isDisplayedOffersTitleText());
	}

	/** dj073227
	 * US-Cat-961 - This method is used to verify that user logged in and click on resources, user
	 * should be able to see resources flyout.
	 * @throws Exception 
	 * @throws  
	 */
	//Modified: Bhavani 09/09/19 Updated line 213 method in HomePage
	@Test(description="verifyResourcesFlyout", dataProvider = "browsers")
	public void login_verifyResourcesFlyout(String browser, String version, String os, Method method) throws Exception
	{
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		
		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
		pageManager.homePage().clickHeaderResourcesLinkText();
		Assert.assertTrue(pageManager.homePage().isResourceFlyoutDisplayed());
	}

	/** dj073227
	 * US-Cat-962 - This method is used to verify that user logged in and successfully navigates
	 * to ecatalog page
	 * @throws Exception 
	 * @throws  
	 */
	//Modified: Bhavani 09/09/19 Added lines 221 222
	@Test(description="moveToEcatalogPage", dataProvider = "browsers",enabled=true)
	public void login_moveToEcatalogPage(String browser, String version, String os, Method method) throws Exception
	{
		
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
		pageManager.homePage().clickECatalogLink();
		pageManager.common().closecurrentBrowser(driver);  
		pageManager.common().moveToNewWindow(driver); 
		Assert.assertTrue(pageManager.ecatalogPage().isBookshelfFiltersdisplayed());
	}



}

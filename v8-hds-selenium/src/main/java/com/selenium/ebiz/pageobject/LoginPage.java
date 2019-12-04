/**
 * @author Bhavani Manthri <Bhavani.Manthri@hdsupply.com>
 */

package com.selenium.ebiz.pageobject;

import com.selenium.ebiz.tools.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage{

	private WebDriver driver;
	private WaitTool waitTool;
	private PageManager pageManager;
	private ConfigFileRead configread;
	int i;
	public String environmentValue;
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		this.waitTool = new WaitTool();
		PageFactory.initElements(driver, this);
		this.pageManager=new PageManager(driver);
		this.configread=new ConfigFileRead();
	}

	//Register or signIn	
	@FindBy(css = "#Header_GlobalLogin_signInQuickLink")
			//(id = "Header_GlobalLogin_signInQuickLink")
	public WebElement headerRegisterOrSignInLinkText;

	@FindBy(xpath="//a[@class='btn btn--large btn--hollow header-sign-in__button--style']")
	WebElement registerForAnAccountButton;	

	//Account icon
	@FindBy(xpath = "//a[@id='Header_GlobalLogin_signOutQuickLink']")
	WebElement accountIcon;

	//Sign Out link
	@FindBy(xpath = "//a[@id='Header_GlobalLogin_loggedInDropdown_SignOut']/div/span[contains(text(), 'SIGN OUT')]")
	WebElement signOutLinkText;

	//My Account link
	@FindBy(xpath = "//a[@id='Header_GlobalLogin_loggedInDropdown_SignOut']/div/span[contains(text(), 'ACCOUNT')]")
	WebElement accountLinkText;

	//Register or Sign in quick link
	/*@FindBy(css = "a#Header_GlobalLogin_signInQuickLink")
	public WebElement headerRegisterOrSignInLinkText;*/

	//username
	@FindBy(id = "Header_GlobalLogin_WC_AccountDisplay_FormInput_logonId_In_Logon_1")  
	WebElement userNameEdit;

	//password
	@FindBy(id = "Header_GlobalLogin_WC_AccountDisplay_FormInput_logonPassword_In_Logon_1")     
	WebElement passwordEdit;

	//Sign in button
	@FindBy(id = "Header_GlobalLogin_WC_AccountDisplay_links_2") 
	WebElement signInButton;

	@FindBy (xpath="//a[text()='Register OR Sign in']")
	WebElement signInOrRegister;

	@FindBy (css="#Header_GlobalLogin_WC_AccountDisplay_FormInput_logonId_In_Logon_1")
	WebElement userName;

	@FindBy (css="#Header_GlobalLogin_WC_AccountDisplay_FormInput_logonPassword_In_Logon_1")
	WebElement password;

	@FindBy (xpath="//div[@id='Header_GlobalLogin_inlinelogonErrorMessage_GL_logonPassword']//div[contains(.,'Please type a valid password')]")
	public WebElement passwordErrorMessage;

	@FindBy (xpath="//div[@id='Header_GlobalLogin_inlineLogonErrorMessage_GL_logonId']/div[contains(.,'Please type a valid')]")
	public WebElement userNameErrorMessage;

	//Forgot username and password
	@FindBy(id = "Header_GlobalLogin_WC_AccountDisplay_links_1")
	WebElement forgotUsernameAndPasswordLinkText;

	//Minicart widget
	@FindBy(id = "widget_minishopcart")  
	WebElement shoppingCartIcon;

	//Remember Me checkbox
	@FindBy(id = "Header_GlobalLogin_WC_AccountDisplay_div_10")
	WebElement rememberMeCheckbox;

	@FindBy(xpath="//*[@class='myaccount_error']")
	WebElement invalidUserNameOrPasswordMessage;

	@FindBy(xpath = "//div[@id='Header_GlobalLogin_inlineLogonErrorMessage_GL_logonId']/div")
	WebElement emptyUserNameMessage;

	@FindBy(xpath = "//div[@id='Header_GlobalLogin_inlinelogonErrorMessage_GL_logonPassword']/div")
	WebElement emptyPasswordMessage;

	@FindBy(xpath = "//a[@data-hds-tag='shopping-cart__item-footer-links-clearcart-btn']")
	WebElement emptyCartLink;

	@FindBy(xpath = "//div[@class='account-snapshot__welcome-inner']/span")
	public WebElement welcomeText;

	@FindBy(css = "span.type--light")
	WebElement createAnAccountText;

	@FindBy(xpath =( "//span[contains(text(),'Account #')]|//span[contains(text(),'Customer #')]"))
	public WebElement loggedAccountNumberText;
	
	@FindBy(xpath="//div[@class='modal modal--visible modal--overflow']")
	WebElement finalDaysToSavePopup;

	@FindBy(xpath="//div[@class='modal__content el--center']//img")
	WebElement shopNowOnFinalDaysToSavePopup;

	@FindBy(xpath="//*[@class='modal__close jq-close-modal']")
	public
	WebElement closeShopNowOnFinalDaysToSavePopup;
	
	@FindBy(xpath="//span[text()='Spend More & Save']")
	WebElement spendMoreAndSaveInBreadcrumb;
	
	@FindBy(xpath="//div[@class='breadcrumbs']/a[text()='Home']")
	WebElement homeInBreadcrumb;

	@FindBy (xpath= "//table[@class='table--responsive']/tbody/tr[1]/td[1]")
	public WebElement firstAcountName;
	
	@FindBy (xpath= "//input[@class='obo-search__input ajax-table--search_input']")
	public WebElement ebizSupportAccountNumberTextBox;
	
	@FindBy (xpath= "//a[@class='jq-ajax-table--search']")
	public WebElement ebizSupportAccountNumberSearchLink;
	
	@FindBy (xpath= "//tbody/tr[1]")
	public WebElement ebizSupportAccountNDetailRow;
	
	public void clickOnRegisterOrSignIn()
	{
		signInOrRegister.click();
	}

	public void tryLogout() {
		try {pageManager.loginPage().loggedAccountNumberText.isDisplayed();
		pageManager.loginPage().logoutOfApplication();
		System.out.println("Test logout");
		}
		catch (Exception e){
			System.out.println("Ignore Logout");
		}
	}

	public HomePage signInToApplication(String username,String pwd) throws Exception
	{
		enterUserName(username);
		enterPassword(pwd);
		signInButton.click();
		//	waitTool.hardWait();
		return new HomePage(driver);
	}

	public void signInToApplicationWithIncorrectPassword(String username,String pwd) throws Exception
	{
		enterUserName(username);
		enterPassword(pwd);
		signInButton.click();
		//waitTool.hardWait();
	}

	public Boolean signInToApplicationwithoutPassword(String username)
	{
		signInOrRegister.click();
		enterUserName(username);
		signInButton.click();
		userName.clear();
		return passwordErrorMessage.isDisplayed();
	}
	
	public void clickOnRegisterLink()
	{
		waitTool.waitForElement(driver, headerRegisterOrSignInLinkText);
		pageManager.common().scrolltoViewElement(headerRegisterOrSignInLinkText, driver);
		headerRegisterOrSignInLinkText.getSize();
		headerRegisterOrSignInLinkText.click();
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
		//	waitTool.hardWait();
		waitTool.waitForElement(driver, emptyCartLink);
		emptyCartLink.click();
		pageManager.common().acceptPopupMessageBox(driver);
		return new LoginPage(driver); 
	}

	/**
	 * Click on Header Register Or Sign Link
	 * @return 
	 */

	public  void clickHeaderRegisterOrSignInLinkText() {

		waitTool.waitForElement(driver, headerRegisterOrSignInLinkText);
		pageManager.common().scrolltoViewElement(headerRegisterOrSignInLinkText, driver);
		headerRegisterOrSignInLinkText.click();

	}
	public void clickForgotUsernameOrPassword() {
		forgotUsernameAndPasswordLinkText.click();
	}
	/**
	 * Enter username
	 * @param username
	 */
	public void enterUserName(String username) {
		/*		WebDriverWait wait = new WebDriverWait(driver, 5000);
		wait.until(ExpectedConditions.visibilityOf((userNameEdit)));*/
		waitTool.waitForElement(driver,userNameEdit);
		pageManager.common().scrolltoViewElement(userNameEdit, driver);
		userNameEdit.clear();
		userNameEdit.sendKeys(username);
	}

	/**
	 * Enter Password
	 * @param password
	 */
	public void enterPassword(String password) {
		waitTool.waitForElement(driver, passwordEdit);
		pageManager.common().scrolltoViewElement(passwordEdit, driver);
		passwordEdit.clear();
		passwordEdit.sendKeys(password);
	}

	/**
	 * Click on Sign In button
	 * @return the driver to HomePage
	 */
	public void clickSignInButton() {
		signInButton.click();
		waitTool.waitFor(driver, true);
	}

	/**
	 * Login to the HD Supply site with specified username and password
	 * @param username
	 * @param password
	 * @return the driver to click on sign In button method
	 * @throws Exception 
	 */
	public void loginToHdSupplySite(String username, String password) throws Exception
	{
		clickHeaderRegisterOrSignInLinkText();
		enterUserName(username);
		enterPassword(password);
		signInButton.click();
		waitTool.waitFor(driver, true);
	}

	public void loginToHdSupplySiteFromProductPage(String username, String password)
	{
		clickHeaderRegisterOrSignInLinkText();
		enterUserName(username);
		enterPassword(password);
		//	return clickSignInButton();
		signInButton.click();
	}

	/**
	 * Login to the HD Supply site with specified  password
	 * @param password
	 * @return the driver to click on sign In button method
	 */
	public void loginToHdSupplySite(String password) {
		enterPassword(password);
	}

	/**
	 * Click on Sign out quick link on Header
	 */
	public void clickLogoutLinkText() {
		waitTool.waitFor(driver, true);
		clickAccountIcon();
		waitTool.waitForElement(driver, signOutLinkText);
		signOutLinkText.click();

	}

	/**
	 * Method to logout of application
	 */
	public void logoutOfApplication() {
		clickLogoutLinkText();
		pageManager.common().acceptPopupMessageBox(driver);
	}

	/**
	 * @return true if Register Or Sign In link is present on the Homepage otherwise false
	 */
	public boolean isDisplayedRegisterOrSignInLinkText() {
		waitTool.waitForElement(driver, headerRegisterOrSignInLinkText);
		pageManager.common().scrolltoViewElement(headerRegisterOrSignInLinkText, driver);
		return pageManager.common().isElementPresent(headerRegisterOrSignInLinkText);
	}
	/**
	 * 
	 * @return true if forgot Username And Password Link is present
	 */
	public boolean isDisplayedforgotUsernameOrPasswordLinkText() {
		return pageManager.common().isElementPresent(forgotUsernameAndPasswordLinkText);
	}

	/**
	 * click on shopping cart icon on Header
	 * @return the driver to Minicart page
	 */
	/*public MinicartPage clickOnShoppingCartIcon(){
		shoppingCartIcon.click();
		return new MinicartPage(driver);
	}*/
	/*public ShoppingCartPage clickShoppingCartIcon()
	{		
		waitTool.waitForElement(driver, shoppingCartIcon);
		.scrolltoViewElement(shoppingCartIcon, driver);
		shoppingCartIcon.click();
		return new ShoppingCartPage(driver);
	}*/


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
		waitTool.waitForElement(driver, accountIcon);
		pageManager.common().scrolltoViewElement(accountIcon, driver);
		accountIcon.getLocation();
		System.out.println("Before clicking on Account Icon");
		accountIcon.click();

	}

	/**
	 * Click on Account link on Header
	 * @return the driver to My Account Page
	 */
	public void clickAccountLinkText() {
		clickAccountIcon();
		waitTool.waitForElement(driver, accountLinkText);

	}

	/**
	 * Click on Forgot username and password link from Sign In modal window
	 * @return the driver to Account Retrieval Page
	 */
	public void clickForgotUsernameAndPasswordLinkText() {
		forgotUsernameAndPasswordLinkText.click();
		waitTool.waitFor(driver, true);
	}



	public Boolean invalidUserNameOrPasswordMessageTextIsDisplayed()
	{
		pageManager.common().scrolltoViewElement(invalidUserNameOrPasswordMessage,driver);
		System.out.println("Error text: " + invalidUserNameOrPasswordMessage.getText());
		return invalidUserNameOrPasswordMessage.isDisplayed();
	}
	
	public String getInvalidUserNameOrPasswordMessageText()
	{
		pageManager.common().scrolltoViewElement(invalidUserNameOrPasswordMessage,driver);
		System.out.println("Error text: " + invalidUserNameOrPasswordMessage.getText());
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
	public void selectRememberMeCheckboxAndloginToHdSupplySite(String username, String password) {
		clickHeaderRegisterOrSignInLinkText();
		enterUserName(username);
		enterPassword(password);
		selectRememberMeCheckbox();
		clickSignInButton();
	}

	/**
	 * @return the prepopulated username if rememeber me checkbox is selected in previous login otherwise return empty value
	 */
	public String getUsernamePrepopulatedValue() {
		System.out.println("username propopualated value = "+userNameEdit.getAttribute("value"));
		return userNameEdit.getAttribute("value");
	}

	public void clickOnRegisterForAnAccountButton()
	{
		registerForAnAccountButton.click();

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
		waitTool.waitForElement(driver, createAnAccountText);
		pageManager.common().scrolltoViewElement(createAnAccountText, driver);
		return pageManager.common().isElementPresent(createAnAccountText);
	}

	//Method to verify presence of RegisterOrSignIn	
	/*public boolean isDisplayedRegisterOrSignIn(){
		return .isElementPresent(headerRegisterOrSignInLinkText);
	}*/

	public void LoginToHDS(String username, String password){
		if(environmentValue.equals("dev1")||environmentValue.equals("dev2")||environmentValue.equals("dev3"))
		{
			loginToHDS_V8(RandomAccountSelect.devusers.pop(), configread.getPassword());


		} else {
			loginToHDS_V8(username, configread.getPassword());
			System.out.println("Username:" + username);

		}

		pageManager.homePage().scrollToWelcomeNote();
		System.out.println("Display welcome message   " + pageManager.homePage().welcomeTextLoggedUser.getText());

		Assert.assertTrue(pageManager.homePage().welcomeTextLoggedUser.getText().contains("Hi"));

	}

	public void loginToHDS_V8(String Username, String Password){
		/*
		Do not modify the method with any assertions after the login
		 */
		waitTool.waitForElement(driver, headerRegisterOrSignInLinkText);
		pageManager.common().scrolltoViewElement(headerRegisterOrSignInLinkText, driver);
		headerRegisterOrSignInLinkText.getSize();
		headerRegisterOrSignInLinkText.click();
		waitTool.waitFor(driver, true);
		waitTool.waitForElement(driver,userName);
		pageManager.common().scrolltoViewElement(userName, driver);
		enterUserName(Username);
		waitTool.waitForElement(driver,password);
		pageManager.common().scrolltoViewElement(password, driver);
		enterPassword(Password);
		signInButton.click();
		waitTool.waitForElement(driver,loggedAccountNumberText);
	}
	
	public void loginToHDSWithIncorrectPassword(String Username, String Password){
		/*
		Do not modify the method with any assertions after the login
		 */
		waitTool.waitForElement(driver, headerRegisterOrSignInLinkText);
		pageManager.common().scrolltoViewElement(headerRegisterOrSignInLinkText, driver);
		headerRegisterOrSignInLinkText.getSize();
		headerRegisterOrSignInLinkText.click();
		waitTool.waitFor(driver, true);
		waitTool.waitForElement(driver,userName);
		pageManager.common().scrolltoViewElement(userName, driver);
		enterUserName(Username);
		waitTool.waitForElement(driver,password);
		pageManager.common().scrolltoViewElement(password, driver);
		enterPassword(Password);
		signInButton.click();
	}

	public void loginToHDS_dev(String Username, String Password) throws InterruptedException {
		//waitTool.waitForJStoLoad(driver);
		//System.out.println("Wait for waitForJStoLoad");
        waitTool.waitForAjax(driver);
        System.out.println("Waiting for Ajax after click");

		/*
		Do not modify the method with any assertions after the login
		 */

		//   wait.until(ExpectedConditions.visibilityOf(headerRegisterOrSignInLinkText));
		waitTool.waitForElement(driver, headerRegisterOrSignInLinkText);
		pageManager.common().scrolltoViewElement(headerRegisterOrSignInLinkText, driver);
		headerRegisterOrSignInLinkText.getSize();
		headerRegisterOrSignInLinkText.click();
		waitTool.waitFor(driver, true);


		waitTool.waitForElement(driver,userName);
		pageManager.common().scrolltoViewElement(userName, driver);
		enterUserName(Username);

		waitTool.waitForElement(driver,password);
		pageManager.common().scrolltoViewElement(password, driver);
		enterPassword(Password);
		//		waitTool.waitFor(driver, true);
		signInButton.click();
		//wait.until(ExpectedConditions.invisibilityOf(signInButton));
		//.scrolltoViewElement(loggedAccountNumberText, driver);
		//waitTool.waitFor(driver, true);
		waitTool.waitForElement(driver,loggedAccountNumberText);
	}

	public void jsclick() {

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", headerRegisterOrSignInLinkText);
	}
	
	public void loginToHDSForOBOUser(String Username, String Password){

		waitTool.waitForElement(driver, headerRegisterOrSignInLinkText);
		pageManager.common().scrolltoViewElement(headerRegisterOrSignInLinkText, driver);
		headerRegisterOrSignInLinkText.getSize();
		headerRegisterOrSignInLinkText.click();
		//waitTool.waitFor(driver, true);
		waitTool.waitForElement(driver,userName);
		pageManager.common().scrolltoViewElement(userName, driver);
		enterUserName(Username);
		//		waitTool.waitFor(driver, true);
		waitTool.waitForElement(driver,password);
		pageManager.common().scrolltoViewElement(password, driver);
		enterPassword(Password);
		//		waitTool.waitFor(driver, true);
		signInButton.click();
		//wait.until(ExpectedConditions.invisibilityOf(signInButton));
		//.scrolltoViewElement(loggedAccountNumberText, driver);
		//waitTool.waitFor(driver, true);
		waitTool.waitForElement(driver,firstAcountName);
	}
	
	public void loginToHDSForEbizupportUser(String Username, String Password){

		waitTool.waitForElement(driver, headerRegisterOrSignInLinkText);
		pageManager.common().scrolltoViewElement(headerRegisterOrSignInLinkText, driver);
		headerRegisterOrSignInLinkText.getSize();
		headerRegisterOrSignInLinkText.click();
		//waitTool.waitFor(driver, true);
		waitTool.waitForElement(driver,userName);
		pageManager.common().scrolltoViewElement(userName, driver);
		enterUserName(Username);
		//		waitTool.waitFor(driver, true);
		waitTool.waitForElement(driver,password);
		pageManager.common().scrolltoViewElement(password, driver);
		enterPassword(Password);
		//		waitTool.waitFor(driver, true);
		signInButton.click();
		//wait.until(ExpectedConditions.invisibilityOf(signInButton));
		//.scrolltoViewElement(loggedAccountNumberText, driver);
		//waitTool.waitFor(driver, true);
		waitTool.waitForElement(driver,ebizSupportAccountNumberSearchLink);
	}
	
	public void clickFirstAccountForOBOUser()
	{
		firstAcountName.click();
		waitTool.waitFor(driver, true);
	}

	public void navigateToShopAllFromPopUpWindow() throws Exception {
        waitTool.waitFor(driver,true);

        //boolean bool=false;
		try {shopNowOnFinalDaysToSavePopup.isDisplayed();

			closeShopNowOnFinalDaysToSavePopup.click();
			System.out.println("Popup closed");
			waitTool.waitForInvisibilityOfElement(driver,shopNowOnFinalDaysToSavePopup);
			waitTool.waitFor(driver,true);
		//	Assert.assertFalse(shopNowOnFinalDaysToSavePopup.isDisplayed());
		//	waitTool.waitForElement(driver,headerRegisterOrSignInLinkText);
		//	bool= headerRegisterOrSignInLinkText.isDisplayed();
		//	System.out.println("bool is.." + bool );

		}
		catch (NoSuchElementException e){
			System.out.println("No Popup to be closed");
		}
		//return bool;
		
	}
	
	public void selectAccountNumberForEbizSupportUser(String anumber)
	{
		ebizSupportAccountNumberTextBox.clear();
		ebizSupportAccountNumberTextBox.sendKeys(anumber);
		ebizSupportAccountNumberSearchLink.click();
		waitTool.waitForElement(driver, ebizSupportAccountNDetailRow);
		ebizSupportAccountNDetailRow.click();
		waitTool.waitFor(driver, true);
	}

	/*	public HomePage loginToHDS_V8() throws Exception {
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
		waitTool.waitFor(driver, true);
		enterUserName(user);
		waitTool.waitFor(driver, true);
		enterPassword(prop.getProperty("password"));
		waitTool.waitFor(driver, true);
		signInButton.click();
		//waitTool.hardWait();
		return new HomePage(driver);
	}

	 */

	public boolean IsDisplayedUserName() {
		waitTool.waitForElement(driver, userNameEdit);
		pageManager.common().scrolltoViewElement(userNameEdit, driver);
		return pageManager.common().isElementPresent(userNameEdit);
	}
	
	public boolean IsDisplayedPassword() {
		waitTool.waitForElement(driver, passwordEdit);
		pageManager.common().scrolltoViewElement(passwordEdit, driver);
		return pageManager.common().isElementPresent(passwordEdit);
	}


}


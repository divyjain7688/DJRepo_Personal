package com.selenium.ebiz.pageobject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.selenium.ebiz.baseclass.BaseClass;
import com.selenium.ebiz.tools.CommonFunctions;
import com.selenium.ebiz.tools.WaitTool;

public class MyAccountPage extends BaseClass{

	public MyAccountPage(WebDriver driver) 	
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		WebDriverWait wait = new WebDriverWait(driver,0);
		wait.until(ExpectedConditions.visibilityOf(thankYouMessage));
	}
	static String Str;
	String comPref;

	@FindBy(xpath="//p[text()='Thanks for being a loyal HD Supply customer!']")
	WebElement thankYouMessage;

	@FindBy(xpath="//h2[@class='widget-wrapper__header-text montserrat strong']")
	WebElement updateAddressHeading;
	@FindBy(xpath="//div[@class='account__orders-item']//h3[text()='Orders']")
	WebElement ordersLink;

	@FindBy(xpath="//div[@class='account__orders-item']//h3[text()='Lists']")
	WebElement listsLink;

	@FindBy(xpath="//div[@class='account__orders-item']//h3[text()='Quotes']")
	WebElement quotesLink;

	@FindBy(xpath="//div[@class='account__orders-item']//h3[text()='Frequently Purchased']")
	WebElement frequentlyPurchasedLink;


	@FindBy(xpath="//div[@class='account__orders-item']//h3[text()='Recurring Orders']")
	WebElement recurringOrdersLink;

	@FindBy(xpath="//div[@class='account__orders-item']//h3[text()='Electronic Invoicing']")
	WebElement electronicInvoicingLink;

	@FindBy(xpath="//div[@class='account__orders-item']//h3[text()='Approve orders']")
	WebElement approveOrdersLink;

	@FindBy(xpath="//h4[@class='widget-wrapper__header-text montserrat'][text()='Manage Account']/../..//h3[text()='About You']/../..")
	WebElement aboutYouBlock;

	@FindBy(xpath="//h4[@class='widget-wrapper__header-text montserrat'][text()='Manage Account']/../..//h3[text()='Billing Information']/../..")
	WebElement billingInformationBlock;

	@FindBy(xpath="//h4[@class='widget-wrapper__header-text montserrat'][text()='Manage Account']/../..//h3[text()='Shipping Information']/../..")
	WebElement shippingInformationBlock;

	@FindBy(xpath="//h4[@class='widget-wrapper__header-text montserrat'][text()='Manage Account']/../..//h3[text()='Email Confirmations']/../..")
	WebElement emailConfirmationsBlock;

	@FindBy(xpath="//h4[@class='widget-wrapper__header-text montserrat'][text()='Manage Account']/../..//h3[text()='About You']/../..//a[text()='Change Email Address']")
	WebElement changeEmailAddressLinkInsideAboutYouBlock;

	@FindBy(xpath="//h4[@class='widget-wrapper__header-text montserrat'][text()='Manage Account']/../..//h3[text()='About You']/../..//a[text()='Change Password']")
	WebElement changePasswordLinkInsideAboutYouBlock;

	@FindBy(xpath="//h4[@class='widget-wrapper__header-text montserrat'][text()='Manage Account']/../..//h3[text()='Billing Information']/../..//strong[text()='Default Billing Address']/../..")
	WebElement defaultBillingAddressInsideBillingInformationBlock;

	@FindBy(xpath="//h4[@class='widget-wrapper__header-text montserrat'][text()='Manage Account']/../..//h3[text()='Shipping Information']/../..//a[text()='Manage Shipping Address']")
	WebElement manageShippingAddressLinkInsideShippingInformationBlock;

	@FindBy(xpath="//h4[@class='widget-wrapper__header-text montserrat'][text()='Manage Account']/../..//h3[text()='Shipping Information']/../..//a[text()='Add Shipping Address']")
	WebElement addShippingAddressLinkInsideShippingInformationBlock;

	@FindBy(xpath="//h4[@class='widget-wrapper__header-text montserrat'][text()='Manage Account']/../..//h3[text()='Email Confirmations']/../..//a[text()='Communication preferences']")
	WebElement communicationPreferencesInsideEmailConfirmationsBlock;

	@FindBy(xpath="//h4[@class='widget-wrapper__header-text montserrat'][text()='Order Again']/../../..//div[@class='owl-item'][1]//div[@class='part-number-container']")
	WebElement addToCartButtonOfFirstProductInsideOrderOnceSection;

	@FindBy(xpath="//div[@class='header-mini-cart__header']")
	WebElement successfullyAddedToCartMessage;

	@FindBy(xpath="//div[@class='main__cart-info']//a[@id='widget_minishopcart'][@role='button']")  
	WebElement shoppingCartIcon;
	
	//Register or signIn	
	@FindBy(xpath = "//div[@class='account__user-details']")
	WebElement myAccountWelcomeNote;

	//Register or signIn	
	@FindBy(xpath = "//div[@class='account__user-links']//a[text()='Change Email Address']")
	WebElement changeEmailAddressLinkText;

	@FindBy (xpath= "//*[@id='content']/div[2]/div[3]/div[2]/div[4]/div[2]/div/p/a")
	WebElement communicationPreferencesLinkText;

	//@FindBy (xpath= "//h4[@class='widget-wrapper__header-text montserrat'][text()='Manage Account']/../..//h3[text()='About You']/../../div[@class='account__orders-content']/p[3]")
	@FindBy (xpath= "//h4[@class='widget-wrapper__header-text montserrat'][text()='Manage Account']/../..//h3[text()='About You']/../../div[@class='account__orders-content']/p[5]")
	WebElement displayedEmailAddress;

	@FindBy (xpath= "//div[@class='change_password__tabs']//input")
	WebElement newEmailTextBox;

	@FindBy (xpath= "//div[@class='change_password__tabs change_password__tabs--confirm']//input")
	WebElement confirmNewEmailTextBox;

	@FindBy (xpath= "//button[@class='btn btn--hollow']")
	WebElement updateEmailAddressButton;

	@FindBy (xpath= "//button[@class='btn btn--hollow']")
	WebElement updatePasswordButton;

	@FindBy (xpath= "//strong[contains(text(),'Only my web orders')]/../../span")
	WebElement onlyMyWebOrderRadioButton;

	@FindBy (xpath= "//strong[contains(text(),'All order at my property')]/../../span")
	WebElement allOrderRadioButton;

	@FindBy (xpath= "//h4[@class='widget-wrapper__header-text montserrat'][text()='Manage Account']/../..//h3[text()='Email Confirmations']/../..//a[text()='Communication preferences']/../../../p[1]")
	WebElement displayedCommunicationPreference;

	@FindBy (xpath= "//button[@class='btn btn--hollow item--update montserrat']")
	WebElement updateCommunicationPreferenceButton;

	@FindBy (xpath= "//span[text()='Old Password']/../..//input")
	WebElement oldPasswordTextBox;

	@FindBy (xpath= "//span[contains(text(),'New Password')]/../..//input")
	WebElement newPasswordTextBox;

	@FindBy (xpath = "//a[@class='panelLinkSelected Header_GlobalLogin_signOutQuickLink_CSR header-select']")
	WebElement logo;

	@FindBy (xpath="//span[text()='SIGN OUT']")
	WebElement SignOutLink;

	@FindBy (xpath="//button[text()='Add New shipping Address']")
	WebElement addNewShippingAddressButton;

	@FindBy (xpath="//div[@class='credentials__submit-item']/a")
	WebElement backButton;	

	@FindBy (xpath="//input[@name='nickName']")
	WebElement shippingAddressNameTextBox;

	@FindBy (xpath="//input[@name='address1']")
	WebElement addressTextBox;

	@FindBy (xpath="//input[@name='city']")
	WebElement cityTextBox;

	@FindBy (xpath="//input[@name='zipCode']")
	WebElement zipCodeTextBox;

	@FindBy (xpath="//input[@name='phone1']")
	WebElement phoneNumberTextBox;

	@FindBy(xpath="//select[@name='state']")
	WebElement 	stateDropdown;

	@FindBy(xpath="//input[@id='organizationName']")
	WebElement 	companyOrPropertyName;

	@FindBy(xpath="//input[@name='address2']")
	WebElement 	floorOrSuiteTextBox;

	@FindBy(xpath="//button[@class='btn btn--hollow']")
	WebElement 	addButton;

	@FindBy(xpath="//button[@class='btn btn--hollow']")
	WebElement 	updateButton;

	@FindBy(xpath="//div[text()='The Shipping Address Name cannot be empty.']")
	WebElement 	nickNameFieldError;

	@FindBy(xpath="//div[text()='Type an address in the Street address field.']")
	WebElement 	addressFieldError;

	@FindBy(xpath="//div[text()='Type a city name in the City field.']")
	WebElement 	cityFieldError;

	@FindBy(xpath="//div[text()='Type a state or province name in the State/province field.']")
	WebElement 	stateFieldError;

	@FindBy(xpath="//div[text()='Type a ZIP or postal code in the ZIP/postal code field.']")
	WebElement 	zipcodeFieldError;

	//@FindBy(xpath="//div[@class='input__error']")
	@FindBy(xpath="//div[@class='WCTooltip']")
	WebElement 	fieldErrorOnAddAddress;
	
	@FindBy(xpath="//div[@class=\"account__orders-item\"]/div/h3[text()='About You']/../../div[2]/p[4]")
	WebElement 	addressLine1AsPerSC;
	
	
	@FindBy(xpath="//strong[text()='Default Shipping Address']/../../p[2]")
	WebElement 	addressLine2Part1AsPerSC;


	@FindBy(xpath="//strong[text()='Default Shipping Address']/../../p[3]")
	WebElement 	addressLine2Part2AsPerSC;
	
	@FindBy(xpath="//strong[text()='Default Shipping Address']/../../p[5]")
	WebElement 	addressLine3AsPerSC;
	
	
	/*	@FindBy(xpath="//a[text()='Edit']/../..//div[@class='address-default__list-details']/p[1]")
	WebElement 	addressLine1;

	@FindBy(xpath="//a[text()='Edit']/../..//div[@class='address-default__list-details']/p[2]")
	WebElement 	addressLine2;

	@FindBy(xpath="//a[text()='Edit']/../..//div[@class='address-default__list-details']/p[3]")
	WebElement 	addressLine3;

	@FindBy(xpath="//a[text()='Edit']/../..//div[@class='address-default__list-details']/p[4]")
	WebElement 	addressLine4;*/

	@FindBy(xpath="//div[@class=\"manage-address\"]//div[@class=\"address-default\"][last()]/div/div/p/strong")
	WebElement 	addressLine1;

	@FindBy(xpath="//div[@class=\"manage-address\"]//div[@class=\"address-default\"][last()]/div/div/p[2]")
	WebElement 	addressLine2;

	@FindBy(xpath="//div[@class=\"manage-address\"]//div[@class=\"address-default\"][last()]/div/div/p[3]")
	WebElement 	addressLine3;

	@FindBy(xpath="//div[@class=\"manage-address\"]//div[@class=\"address-default\"][last()]/div/div/p[4]")
	WebElement 	addressLine4;

	@FindBy(xpath="//a[text()='Delete']")
	List<WebElement> deleteButtons;

	@FindBy(xpath="//a[text()='Edit']")
	List<WebElement> editButton;

	@FindBy(xpath="//div[@class='breadcrumbs']//a[text()='My Account']")
	WebElement 	myAccountsInBreadCrum;

	@FindBy(xpath="//p[@class='oswald']")
	WebElement 	defaultShippingAddressText;


	@FindBy(xpath="//div[@class='content__description type--caption']")
	WebElement 	oldPasswordError;	

	//@FindBy(xpath="//div[@class='input__error']")
	@FindBy(xpath="//div[@class='content__description type--caption']")
	WebElement 	newPasswordError;	

	@FindBy(xpath="//div[@id='message']")
	WebElement 	emailIdNotMatchErrorMessage;	

	@FindBy(xpath="//div[@id='message']")
	WebElement 	emailAddressErrorMessage;	
	
	

	public Boolean isOrdersLinkDisplayed()
	{
		return ordersLink.isDisplayed();
	}

	public Boolean isListsLinkDisplayed()
	{
		return listsLink.isDisplayed();
	}

	public Boolean isQuotesLinkDisplayed()
	{
		return quotesLink.isDisplayed();
	}

	public Boolean isFrequentlyPurchasedLinkDisplayed()
	{
		return frequentlyPurchasedLink.isDisplayed();
	}

	public Boolean isRecurringOrdersLinkDisplayed()
	{
		return recurringOrdersLink.isDisplayed();
	}

	public Boolean isElectronicInvoicingLinkDisplayed()
	{
		return electronicInvoicingLink.isDisplayed();
	}

	public Boolean isApproveOrdersLinkDisplayed()
	{
		return approveOrdersLink.isDisplayed();
	}

	public Boolean isAboutYouBlockUnderManageAccountSectionDisplayed()
	{
		return aboutYouBlock.isDisplayed();
	}

	public Boolean isBillingInformationBlockUnderManageAccountSectionDisplayed()
	{
		return billingInformationBlock.isDisplayed();
	}

	public Boolean isShippingInformationBlockUnderManageAccountSectionDisplayed()
	{
		return shippingInformationBlock.isDisplayed();
	}

	public Boolean isEmailConfirmationsBlockUnderManageAccountSectionDisplayed()
	{
		return emailConfirmationsBlock.isDisplayed();
	}

	public Boolean isChangeEmailAddressLinkInsideAboutYouBlockDisplayed()
	{
		return changeEmailAddressLinkInsideAboutYouBlock.isDisplayed();
	}

	public Boolean isChangePasswordLinkInsideAboutYouBlockDisplayed()
	{
		return changePasswordLinkInsideAboutYouBlock.isDisplayed();
	}

	public Boolean isDefaultBillingAddressInsideBillingInformationBlockDisplayed()
	{
		return defaultBillingAddressInsideBillingInformationBlock.isDisplayed();
	}

	public Boolean isManageShippingAddressLinkInsideShippingInformationBlockDisplayed()
	{
		return manageShippingAddressLinkInsideShippingInformationBlock.isDisplayed();
	}

	public Boolean isAddShippingAddressLinkInsideShippingInformationBlockDisplayed()
	{
		return addShippingAddressLinkInsideShippingInformationBlock.isDisplayed();
	}

	public Boolean isCommunicationPreferencesInsideEmailConfirmationsBlockDisplayed()
	{
		return communicationPreferencesInsideEmailConfirmationsBlock.isDisplayed();
	}

	public Boolean isProductFromOrderOnceSectionAddedToCart() throws Exception
	{	
		addToCartButtonOfFirstProductInsideOrderOnceSection.click();
		WaitTool.hardWait();
		return successfullyAddedToCartMessage.isEnabled();
	}


	public FrequentlyPurchasedPage moveToFrequentlyPurchsedPage()
	{
		CommonFunctions.scrolltoViewElement(frequentlyPurchasedLink, driver);
		frequentlyPurchasedLink.click();
		return new FrequentlyPurchasedPage(driver);
	}

	public OrderHistoryAndStatusPage moveToOrderHistoryAndStatusPage()
	{
		ordersLink.click();
		return new OrderHistoryAndStatusPage(driver);
	}

	/**Method to get Welcome note text from my account page
	 * @return welcome note string 
	 */	
	public String getMyaccountWelcomeNote() {
		WaitTool.waitForElement(driver, myAccountWelcomeNote);
		System.out.println("dajsfdj");
		return myAccountWelcomeNote.getText().trim();
	}

	/**Method to Click on ChangeEmailAddress under manage account
	 * @return 
	 * @return 
	 */
	public ChangeEmailAddressPage clickChangeEmailAddressLinkText() throws InterruptedException {
		WaitTool.waitForElement(driver, changeEmailAddressLinkText);
		changeEmailAddressLinkText.click();
		WaitTool.waitFor(driver, true);
		return new ChangeEmailAddressPage(driver);
	}

	/**
	 * Click Add Shipping address link from My account page
	 * @return the driver to Add New Shipping Address Page
	 */
	public AddNewShippingAddressPage clickAddShippingAddressLinkInsideShippingInformationBlock() {
		addShippingAddressLinkInsideShippingInformationBlock.click();
		WaitTool.waitFor(driver, true);
		return new AddNewShippingAddressPage(driver);

	}

	/* @author nm064123
	 * Method to to click and navigate o communications preference page
	 *  
	 */

	public CommunicationsPreferencesPage clickCommunicationsPreferencesLink(){
		communicationPreferencesLinkText.click();
		return new CommunicationsPreferencesPage(driver);
	}

	/*public void disaplyedOldEmailAddressValue()
	{
		Str = displayedEmailAddress.getText();
		System.out.println("emailStr is " + Str);
	}*/
	
	public String disaplyedOldEmailAddressValue()
	{
		String str = displayedEmailAddress.getText();
		System.out.println("emailStr is " + str);
		return str;
	}

	public String dispalyedUpdatedEmailAddress()
	{
		System.out.println("displayedEmailAddress.getText(); is " + displayedEmailAddress.getText());
		return displayedEmailAddress.getText();
	}

	public void changeEmailAddress(String email)
	{
		changeEmailAddressLinkInsideAboutYouBlock.click();
		newEmailTextBox.sendKeys(email);
		confirmNewEmailTextBox.sendKeys(email);
		updateEmailAddressButton.click();
	}

	public void changeEmailAddress()
	{
		changeEmailAddressLinkInsideAboutYouBlock.click();
		newEmailTextBox.clear();
		confirmNewEmailTextBox.clear();
		updateEmailAddressButton.click();
	}

	public Boolean isEmailAddressErrorDisplayed() 
	{
		return emailAddressErrorMessage.isDisplayed();
	}

	/*public Boolean changeEmailAddressError(String email)
	{
		changeEmailAddressLinkInsideAboutYouBlock.click();
		newEmailTextBox.sendKeys(email);
		confirmNewEmailTextBox.sendKeys(Str);
		updateEmailAddressButton.click();
		return emailIdNotMatchErrorMessage.isDisplayed();
	}*/
	
	public Boolean changeEmailAddressError(String oldEmail, String email)
	{
		changeEmailAddressLinkInsideAboutYouBlock.click();
		newEmailTextBox.sendKeys(email);
		confirmNewEmailTextBox.sendKeys(oldEmail);
		updateEmailAddressButton.click();
		return emailIdNotMatchErrorMessage.isDisplayed();
	}
	

	/*public void revertEmailAddress()
	{		
		changeEmailAddressLinkInsideAboutYouBlock.click();
		newEmailTextBox.sendKeys(Str);
		confirmNewEmailTextBox.sendKeys(Str);
		updateEmailAddressButton.click();
	}*/
	
	public void revertEmailAddress(String disaplyedOldEmailAddressValue)
	{		
		changeEmailAddressLinkInsideAboutYouBlock.click();
		newEmailTextBox.sendKeys(disaplyedOldEmailAddressValue);
		confirmNewEmailTextBox.sendKeys(disaplyedOldEmailAddressValue);
		updateEmailAddressButton.click();
	}

	public String changeCommunicationPrefenceToReceiveOnlyMyOrder()
	{
		WaitTool.waitForElement(driver, communicationPreferencesInsideEmailConfirmationsBlock);
		communicationPreferencesInsideEmailConfirmationsBlock.click();
		onlyMyWebOrderRadioButton.click();
		updateCommunicationPreferenceButton.click();
		comPref = displayedCommunicationPreference.getText();
		System.out.println("compref is" + comPref);
		return comPref;

	}

	public String changeCommunicationPrefenceToReceiveAllOrder()
	{
		CommonFunctions.scrolltoViewElement(communicationPreferencesInsideEmailConfirmationsBlock, driver);
		communicationPreferencesInsideEmailConfirmationsBlock.click();
		allOrderRadioButton.click();
		updateCommunicationPreferenceButton.click();
		comPref = displayedCommunicationPreference.getText();
		System.out.println("compref is" + comPref);
		return comPref;

	}

	public void changePassword(String oldPassword,String newPassword)
	{
		changePasswordLinkInsideAboutYouBlock.click();
		oldPasswordTextBox.sendKeys(oldPassword);
		newPasswordTextBox.sendKeys(newPassword);
		updatePasswordButton.click();
	}


	public Boolean isOldPasswordErrorDisplayed(String oldPassword,String newPassword)
	{
		changePasswordLinkInsideAboutYouBlock.click();
		oldPasswordTextBox.sendKeys(newPassword);
		newPasswordTextBox.sendKeys(oldPassword);
		updatePasswordButton.click();
		return oldPasswordError.isDisplayed();
	}

	public Boolean isNewPasswordLengthErrorDisplayed(String oldPassword,String newPassword)
	{
		newPassword=newPassword+newPassword+newPassword;
		oldPasswordTextBox.sendKeys(oldPassword);
		newPasswordTextBox.sendKeys(newPassword);
		updatePasswordButton.click();
		return newPasswordError.isDisplayed();
	}

	public Boolean isNewPasswordBlankErrorDisplayed(String oldPassword)
	{
		oldPasswordTextBox.sendKeys(oldPassword);
		updatePasswordButton.click();
		return newPasswordError.isDisplayed();
	}


	public LoginPage logoutFromMyAccount()
	{
		logo.click();
		SignOutLink.click();
		CommonFunctions.acceptPopupMessageBox(driver);
		return new LoginPage(driver);
	}

	public void goToAddressBook() 
	{
		CommonFunctions.scrolltoViewElement(manageShippingAddressLinkInsideShippingInformationBlock, driver);
		manageShippingAddressLinkInsideShippingInformationBlock.click();
	}

	public void addNewShippingAddressButton() 
	{
		addNewShippingAddressButton.click();
	}

	public Boolean isAddNewShippingAddressButton() 
	{
		return addNewShippingAddressButton.isDisplayed();
	}

	public MyAccountPage navigateBackToAddressBookFromNewShipingAddress() 
	{
        WaitTool.waitForElement(driver, backButton);
		backButton.click();
		return new MyAccountPage(driver);
	}

	public void clearAllFieldsinAddressBook()
	{
		shippingAddressNameTextBox.clear();
		addressTextBox.clear();
		floorOrSuiteTextBox.clear();
		cityTextBox.clear();
		CommonFunctions.selectDropdown(stateDropdown, "Select a State");
		zipCodeTextBox.clear();
		phoneNumberTextBox.clear();
		companyOrPropertyName.clear();
	}
	
	public void clearAllFieldsinAddressBookBeforeEdit()
	{
		//shippingAddressNameTextBox.clear();
		addressTextBox.clear();
		floorOrSuiteTextBox.clear();
		cityTextBox.clear();
		CommonFunctions.selectDropdown(stateDropdown, "Select a State");
		zipCodeTextBox.clear();
		phoneNumberTextBox.clear();
		companyOrPropertyName.clear();
	}

	public Boolean shippingAddressNameError(String address,String city,String state, String zipcode,String phnumber,String cpname)
	{
		phnumber = phnumber.replace("'", "");
		zipcode = zipcode.replace("'", "");
		addressTextBox.sendKeys(address);
		//floorOrSuiteTextBox.sendKeys(floor);
		cityTextBox.sendKeys(city);
		companyOrPropertyName.sendKeys(cpname);
		CommonFunctions.selectDropdown(stateDropdown, state);
		zipCodeTextBox.sendKeys(zipcode);
		phoneNumberTextBox.sendKeys(phnumber);
		addButton.click();
		/*return fieldErrorOnAddAddress.getText();*/
		return fieldErrorOnAddAddress.isDisplayed();

	}

	public Boolean addressError(String shippingAddress,String city,String state, String zipcode,String phnumber,String cpname)
	{
		phnumber = phnumber.replace("'", "");
		zipcode = zipcode.replace("'", "");
		shippingAddressNameTextBox.sendKeys(shippingAddress);
		//floorOrSuiteTextBox.sendKeys(floor);
		cityTextBox.sendKeys(city);
		CommonFunctions.selectDropdown(stateDropdown, state);
		zipCodeTextBox.sendKeys(zipcode);
		phoneNumberTextBox.sendKeys(phnumber);
		companyOrPropertyName.sendKeys(cpname);
		addButton.click();
		/*		return addressFieldError.getText();*/
		return fieldErrorOnAddAddress.isDisplayed();
	}

	public Boolean cityError(String shippingAddress, String address,String state, String zipcode,String phnumber,String cpname) 
	{
		phnumber = phnumber.replace("'", "");
		zipcode = zipcode.replace("'", "");
		shippingAddressNameTextBox.sendKeys(shippingAddress);
		addressTextBox.sendKeys(address);
		//floorOrSuiteTextBox.sendKeys(floor);
		companyOrPropertyName.sendKeys(cpname);
		CommonFunctions.selectDropdown(stateDropdown, state);
		zipCodeTextBox.sendKeys(zipcode);
		phoneNumberTextBox.sendKeys(phnumber);
		addButton.click();
		/*return cityFieldError.getText();*/
		return fieldErrorOnAddAddress.isDisplayed();
	}


	public Boolean stateError(String shippingAddress, String address,String city, String zipcode,String phnumber,String cpname) 
	{
		phnumber = phnumber.replace("'", "");
		zipcode = zipcode.replace("'", "");
		shippingAddressNameTextBox.sendKeys(shippingAddress);
		addressTextBox.sendKeys(address);
		//	floorOrSuiteTextBox.sendKeys(floor);
		cityTextBox.sendKeys(city);
		companyOrPropertyName.sendKeys(cpname);
		zipCodeTextBox.sendKeys(zipcode);
		phoneNumberTextBox.sendKeys(phnumber);
		addButton.click();
		/*return stateFieldError.getText();*/
		return fieldErrorOnAddAddress.isDisplayed();
	}

	public Boolean zipcodeError(String shippingAddress, String address,String city, String state,String phnumber,String cpname) 
	{
		phnumber = phnumber.replace("'", "");
		shippingAddressNameTextBox.sendKeys(shippingAddress);
		addressTextBox.sendKeys(address);
		//	floorOrSuiteTextBox.sendKeys(floor);
		cityTextBox.sendKeys(city);
		companyOrPropertyName.sendKeys(cpname);
		CommonFunctions.selectDropdown(stateDropdown, state);
		phoneNumberTextBox.sendKeys(phnumber);
		addButton.click();
		/*return zipcodeFieldError.getText();*/
		return fieldErrorOnAddAddress.isDisplayed();
	}


	public Boolean companyPropertyError(String shippingAddress, String address,String city, String state,String phnumber,String zipcode)
	{
		phnumber = phnumber.replace("'", "");
		zipcode = zipcode.replace("'", "");
		shippingAddressNameTextBox.sendKeys(shippingAddress);
		addressTextBox.sendKeys(address);
		//	floorOrSuiteTextBox.sendKeys(floor);
		cityTextBox.sendKeys(city);
		zipCodeTextBox.sendKeys(zipcode);
		CommonFunctions.selectDropdown(stateDropdown, state);
		phoneNumberTextBox.sendKeys(phnumber);
		addButton.click();
		/*return zipcodeFieldError.getText();*/
		return fieldErrorOnAddAddress.isDisplayed();
	}

	public Boolean phoneNumberError(String shippingAddress, String address,String city, String state,String cpname,String zipcode)
	{
		zipcode = zipcode.replace("'", "");
		shippingAddressNameTextBox.sendKeys(shippingAddress);
		addressTextBox.sendKeys(address);
		//	floorOrSuiteTextBox.sendKeys(floor);
		cityTextBox.sendKeys(city);
		zipCodeTextBox.sendKeys(zipcode);
		CommonFunctions.selectDropdown(stateDropdown, state);
		companyOrPropertyName.sendKeys(cpname);
		addButton.click();
		/*return zipcodeFieldError.getText();*/
		return fieldErrorOnAddAddress.isDisplayed();
	}

	public void addAddress(String shippingAddress, String address,String floor,String city, String state,String zipcode,String phnumber,String cpname) throws Exception
	{
		phnumber = phnumber.replace("'", "");
		zipcode = zipcode.replace("'", "");
		shippingAddressNameTextBox.sendKeys(shippingAddress);
		addressTextBox.sendKeys(address);
		floorOrSuiteTextBox.sendKeys(floor);
		cityTextBox.sendKeys(city);
		zipCodeTextBox.sendKeys(zipcode);
		CommonFunctions.selectDropdown(stateDropdown, state);
		phoneNumberTextBox.sendKeys(phnumber);
		companyOrPropertyName.sendKeys(cpname);
		WaitTool.hardWait();
		addButton.click();
	}

	public String addressLine1()
	{
		System.out.println("addressLine1 is "+ addressLine1);
		return addressLine1.getText();
	}

	public String addressLine2()
	{
		System.out.println("addressLine2 is "+ addressLine2);
		return addressLine2.getText();
	}

	public String addressLine3()
	{		
		System.out.println("addressLine3 is "+ addressLine3);
		return addressLine3.getText();
	}

	public String addressLine4()
	{
		System.out.println("addressLine4 is "+ addressLine4);
		return addressLine4.getText();
	}


	public void clickOnDeleteButtons()
	{
		int i=0;
		if(deleteButtons.size()>0)
		{
			for(WebElement del : deleteButtons)
			{
				del.click();
				i++;
				System.out.println("value of i is" + i );
				CommonFunctions.acceptPopupMessageBox(driver);
			}
		}
	}

	public Boolean isDeleteButtonNotdisplayed()
	{
		if(deleteButtons.size()==0)
		{
			System.out.println("deleteButtons.size()==0");
			return true;
		}
		else
		{
			return false;
		}
	}

	public Boolean isEditButtonNotdisplayed()
	{
		if(editButton.size()==0)
		{
			System.out.println("editButton.size()==0");
			return true;
		}
		else
		{
			return false;
		}
	}

	public void goToMyAccountsFrommBreadCrum() 
	{
		myAccountsInBreadCrum.click();
	}

	/*public void updateAddress(String address,String floor,String city, String state,String zipcode,String phnumber)
	{
		addressTextBox.sendKeys(address);
		floorOrSuiteTextBox.sendKeys(floor);
		cityTextBox.sendKeys(city);
		zipCodeTextBox.sendKeys(zipcode);
		CommonFunctions.selectDropdown(stateDropdown, state);
		phoneNumberTextBox.sendKeys(phnumber);
		updateButton.click();
	}*/
	public void updateAddress(String address,String floor,String city, String state,String zipcode,String phnumber,String cpname) throws Exception
	{
		phnumber = phnumber.replace("'", "");
		zipcode = zipcode.replace("'", "");
	//	shippingAddressNameTextBox.sendKeys(shippingAddress);
		addressTextBox.sendKeys(address);
		floorOrSuiteTextBox.sendKeys(floor);
		cityTextBox.sendKeys(city);
		zipCodeTextBox.sendKeys(zipcode);
		CommonFunctions.selectDropdown(stateDropdown, state);
		phoneNumberTextBox.sendKeys(phnumber);
		companyOrPropertyName.sendKeys(cpname);
		WaitTool.hardWait();
		addButton.click();
	}

	public void goToAddressBookManageEdit() 
	{
		manageShippingAddressLinkInsideShippingInformationBlock.click();
		clickOnEditButton();

	}

	public void clickOnEditButton()
	{
		int i=0;
		for(WebElement edit : editButton)
		{
			if(edit.isDisplayed())
			{
				edit.click();
				i++;
				System.out.println("value of i is" + i );
			}
		}
	}

	public void clearAllFieldsinUpdateAddressBook()
	{
		addressTextBox.clear();
		floorOrSuiteTextBox.clear();
		cityTextBox.clear();
		CommonFunctions.selectDropdown(stateDropdown, "Select a State");
		zipCodeTextBox.clear();
		phoneNumberTextBox.clear();
	}

	public String UpdatedAddress()
	{
		return updateAddressHeading.getText();
	}
	
	public ShoppingCartPage clickOnShoppingCartIcon() throws Exception {
		WaitTool.hardWait();
		shoppingCartIcon.click();
		return new ShoppingCartPage(driver);
	}
	

	public Boolean isDefaultShippingAddressText() 
	{
		return defaultShippingAddressText.isDisplayed();
	}
	
	public String getShippingAddressLine1Text()
	{
		System.out.println("addressLine1AsPerSC.getText() is "+ addressLine1AsPerSC.getText());
		return addressLine1AsPerSC.getText();
				
	}
	
	public String getShippingAddressLine2Text()
	{
		System.out.println("addressLine2AsPerSC.getText() is "+ addressLine2Part1AsPerSC.getText()+" "+addressLine2Part2AsPerSC.getText());
		return addressLine2Part1AsPerSC.getText()+" "+addressLine2Part2AsPerSC.getText();
				
	}
	
	public String getShippingAddressLine3Text()
	{
		System.out.println("addressLine3AsPerSC.getText() is "+ addressLine3AsPerSC.getText());
		return addressLine3AsPerSC.getText();
				
	}
	
	

}





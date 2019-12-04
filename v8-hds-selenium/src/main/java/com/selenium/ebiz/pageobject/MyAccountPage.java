package com.selenium.ebiz.pageobject;

import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.WaitTool;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class MyAccountPage{
	private WebDriver driver;
	private WaitTool waitTool;
	public PageManager pageManager;

	public MyAccountPage(WebDriver driver) 	
	{
		this.driver = driver;
		this.waitTool = new WaitTool();
		PageFactory.initElements(driver, this);
		pageManager=new PageManager(driver);


	}
	static String Str;
	String comPref;

	@FindBy(xpath="//p[text()='Thanks for being a loyal HD Supply customer!']")
	public WebElement thankYouMessage;
	
	@FindBy(xpath="//a[text()='Your Properties']")
	public WebElement yourPropertiesLinkInAccountMenu;
	
	@FindBy(xpath="//a[text()='Manage Orders']")
	public WebElement manageOrdersLinkInAccountMenu;
	
	@FindBy(xpath="//th[text()='Name']")
	public WebElement nameHeaderInPropertiesTable;
	
	@FindBy(xpath="//th[text()='Account #']")
	public WebElement accountHeaderInPropertiesTable;
	
	@FindBy(xpath="//th[text()='City']")
	public WebElement cityHeaderrInPropertiesTable;
	
	@FindBy(xpath="//th[text()='State']")
	public WebElement stateHeaderInPropertiesTable;
	
	@FindBy(xpath="//p[contains(text(),'Your email address has been successfully updated!')]")
	public WebElement successfulEmailUpdateMessage;
	
	@FindBy(xpath="//div[@class='modal__inner']/a[@title='Close Modal']")
	public WebElement closeChangeEmailModalWindow;
	
	/*@FindBy(xpath="//h2[@class='widget-wrapper__header-text montserrat strong']")
	WebElement updateAddressHeading;*/
	
	@FindBy(xpath="//div[@class='account__orders-item']//h3[text()='Orders']")
	WebElement ordersLink;

	@FindBy(xpath="//div[@class='account__orders-item']//h3[text()='Lists']")
	WebElement listsLink;

	@FindBy(xpath="//div[@class='account__orders-item']//h3[text()='Quotes']")
	WebElement quotesLink;

	@FindBy(xpath="//div[@class='account__orders-item']//h3[text()='Frequently Purchased']")
	WebElement frequentlyPurchasedLink;

	@FindBy(xpath="//div[@class='account__orders-item']//h3[text()='Subscriptions']")
	WebElement subscriptionsLink;

	@FindBy(xpath="//div[@class='account__orders-item']//h3[text()='Electronic Invoicing']")
	WebElement electronicInvoicingLink;
	
	@FindBy(xpath="//h1[text()='Electronic Invoicing']")
	WebElement electronicInvoicingHeaderText;
	
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

	@FindBy(xpath="//span[text()='User Account']/..//a[text()='Edit']")
	WebElement editEmailAddressLink;
	
	@FindBy(xpath="//span[text()='Password']/../a")
	WebElement editPasswordLink;
	
	@FindBy(xpath="//div[text()='Email id does not match.']")
	public WebElement emailIdDoesNotMatchError;
	
	@FindBy(xpath="//td[1]")
	List<WebElement> namesInPropertiesTable;
	
	@FindBy(xpath="//td[2]")
	List<WebElement> accountNumbersInPropertiesTable;
	
	@FindBy(xpath="//td[3]")
	List<WebElement> citiesInPropertiesTable;
	
	@FindBy(xpath="//td[4]")
	List<WebElement> statesInPropertiesTable;
	
	@FindBy(xpath="//td[4]")
	List<WebElement> NamesInPropertiesTable;
	@FindBy(xpath="//a[text()='Change Password']")
	WebElement changePasswordLinkInsideAboutYouBlock;

	@FindBy(xpath="//h4[@class='widget-wrapper__header-text montserrat'][text()='Manage Account']/../..//h3[text()='Billing Information']/../..//strong[text()='Default Billing Address']/../..")
	WebElement defaultBillingAddressInsideBillingInformationBlock;

	@FindBy(xpath="//a[text()='Manage Shipping Address']")
	public WebElement manageShippingAddressLinkInAccountMenu;

	@FindBy(xpath = "//h4[text()='Manage Shipping Address']")
	WebElement manageShippingAddressHeadingTitle;

	@FindBy(xpath="//a[text()='Add Shipping Address']")
	WebElement addShippingAddressLinkInsideShippingInformationBlock;

	@FindBy(xpath = "//*[@data-hds-tag='new-address__heading']")
	WebElement newAddressPageTitle;

	@FindBy(xpath="//a[text()='Communication preferences']")
	public WebElement communicationPreferencesLink;
	
	@FindBy(xpath="//h2[text()='COMMUNICATION PREFERENCES']")
	public WebElement communicationPreferencesHeaderText;
	
	@FindBy(xpath="//a[text()='About']")
	public WebElement aboutLink;
	
	@FindBy(xpath="//span[text()='Customer Number']")
	public WebElement customerNumberText;
	
	@FindBy(xpath="//h4[@class='widget-wrapper__header-text montserrat'][text()='Order Again']/../../..//div[@class='owl-item'][1]//div[@class='part-number-container']")
	WebElement addToCartButtonOfFirstProductInsideOrderOnceSection;

	@FindBy(xpath="//div[@class='header-mini-cart__header']")
	WebElement successfullyAddedToCartMessage;

	/*@FindBy(xpath="//div[@class='main__cart-info']//a[@id='widget_minishopcart'][@role='button']")  
	WebElement shoppingCartIcon;*/
	
	//Register or signIn	
	@FindBy(xpath = "//div[@class='account__user-details']")
	WebElement myAccountWelcomeNote;

	//Register or signIn	
	@FindBy(xpath = "//div[@class='account__user-links']//a[text()='Change Email Address']")
	WebElement changeEmailAddressLinkText;

	@FindBy (xpath= "//*[@id='content']/div[2]/div[3]/div[2]/div[4]/div[2]/div/p/a")
	WebElement communicationPreferencesLinkText;

	//@FindBy (xpath= "//h4[@class='widget-wrapper__header-text montserrat'][text()='Manage Account']/../..//h3[text()='About You']/../../div[@class='account__orders-content']/p[3]")
	@FindBy (xpath= "//span[text()='User Account']/../br[3]")
	WebElement displayedEmailAddress;

	@FindBy (xpath= "//input[@id='email1']")
	WebElement newEmailTextBox;

	@FindBy (xpath= "//input[@id='verifyEmail']")
	WebElement confirmNewEmailTextBox;

	@FindBy (xpath= "//button[@class='btn btn--primary']")
	WebElement updateEmailAddressButton;

	@FindBy (xpath= "//button[@class='btn btn--primary']")
	WebElement updatePasswordButton;

	@FindBy (xpath= "//strong[contains(text(),'Only my web orders')]/../../span")
	WebElement onlyMyWebOrderRadioButton;

	@FindBy (xpath= "//strong[contains(text(),'All orders at my property')]")
	WebElement allOrderRadioButton;
	
	@FindBy (xpath= "//strong[text()='No Confirmations']/../../span")
	WebElement noConfirmationRadioButton;
	

	@FindBy (xpath= "//h4[@class='widget-wrapper__header-text montserrat'][text()='Manage Account']/../..//h3[text()='Email Confirmations']/../..//a[text()='Communication preferences']/../../../p[1]")
	WebElement displayedCommunicationPreference;

	@FindBy (xpath= "//button[@class='btn btn--hollow item--update montserrat']")
	WebElement updateCommunicationPreferenceButton;
	//p[@class="reset-password-success__message"]
	@FindBy (xpath= "//button[@class='btn btn--hollow item--update montserrat']")
	WebElement preferenceUpdateMessage;

	@FindBy (xpath= "//span[text()='Old Password']/../..//input")
	WebElement oldPasswordTextBox;

	@FindBy (xpath= "//span[contains(text(),'New Password')]/../..//input")
	WebElement newPasswordTextBox;

	@FindBy (xpath = "//a[@class='panelLinkSelected Header_GlobalLogin_signOutQuickLink_CSR header-select']")
	WebElement logo;
	
	@FindBy (xpath= "//h1[text()='Change Email Address']")
	WebElement changeEmailAddressHeaderText;

	@FindBy (xpath="//span[text()='SIGN OUT']")
	WebElement SignOutLink;

	@FindBy (xpath="//button[text()='Add New shipping Address']")
	WebElement addNewShippingAddressButton;

	@FindBy (xpath="//div[@class='manage-shipping-address__btn']//button[text()='Add Shipping Address']")
	WebElement addShippingAddressButton;
	
	
	@FindBy (xpath="//h1[@data-hds-tag='new-address__heading']")
	WebElement addNewShippingAddressText;
	
	@FindBy (xpath="//div[@class='credentials__submit-item']/a")
	WebElement backButton;	

	@FindBy (xpath="//input[@name='nickName']")
	WebElement shippingAddressNameTextBox;

	@FindBy (xpath="//input[@name='shipTo_address1']")
	WebElement addressTextBox;
	
	@FindBy (xpath="//input[@data-element='shipping_route'][@name='address1']")
	WebElement addressTextBoxInEdit;

	@FindBy (xpath="//input[@name='city']")
	WebElement cityTextBox;

	@FindBy (xpath="//input[@name='zipCode']")
	WebElement zipCodeTextBox;

	@FindBy (xpath="//input[@name='phone1']")
	WebElement phoneNumberTextBox;

	@FindBy(xpath="//select[@name='state']")
	WebElement 	stateDropdown;

	@FindBy(xpath="//input[@name='organizationName']")
	WebElement 	companyOrPropertyName;

	@FindBy(xpath="//input[@name='address2']")
	WebElement 	floorOrSuiteTextBox;

	@FindBy(xpath="//button[@class='btn btn--hollow']")
	WebElement 	addButton;
	
	@FindBy(xpath="//div[@class='credentials__submit']//a[@class='btn btn--large']")
	WebElement 	submitButton;

	@FindBy(xpath="//div[@class='credentials__submit']//button")
	WebElement 	submitButtonAfterEdit;
	
	@FindBy(xpath="//a[@class=\"modal__close jq-close-modal\"]")
	WebElement 	cancelButtonAfterEdit;
	
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
	
	@FindBy(xpath="//div[@class='account__orders-item']/div/h3[text()='About You']/../../div[2]/p[4]")
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

	@FindBy(xpath="//div[@class='manage-address']//div[@class='address-default'][last()]/div/div/p/strong")
	WebElement 	addressLine1;

	@FindBy(xpath="//div[@class='manage-address']//div[@class='address-default'][last()]/div/div/p[2]")
	WebElement 	addressLine2;

	@FindBy(xpath = "//div[@class='manage-address']//div[@class='address-default']/div/div/p[2]")
	public
	List<WebElement> listAllAddresses;

	@FindBy(xpath="//div[@class='manage-address']//div[@class='address-default']/div/div/p[3]")
	List<WebElement> 	addressLine3;

	@FindBy(xpath="//div[@class='manage-address']//div[@class='address-default']/div/div/p[4]")
	List<WebElement> 	addressLine4;

	@FindBy(xpath="//a[text()='Delete']")
    public
    List<WebElement> deleteButtons;
	
	@FindBy(xpath="//button[@class='btn btn--primary'][text()='Confirm']")
	WebElement 	confirmDeleteButton;
	
	@FindBy(xpath="//a[text()='Edit']")
	List<WebElement> editButton;
	
	@FindBy(xpath="//td[1]")
	List<WebElement> nameList;

	@FindBy(xpath="//td[2]")
	List<WebElement> addressList;
	
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
	
	@FindBy(xpath="//li[@class='left-nav-footer ']/a")
	public WebElement 	myProfileLogo;	
	
	@FindBy(xpath="//span[text()='Customer Number']/..")
	public WebElement 	customerNumberInformation;

	@FindBy(xpath="//span[text()='Type of Business']/..")
	public WebElement 	typeOfBusinessInformation;
	
	@FindBy(xpath="//span[text()='User Account']/..")
	public WebElement 	userAccountInformation;
	
	@FindBy(xpath="//span[text()='Password']/..")
	public WebElement 	passwordInformation;
	
	@FindBy(xpath="//a[@id='_loggedInDropdown_SignOut']")
	public WebElement 	signOutLinkInMenu;
	
	@FindBy(xpath="//a[@class='link--featured'][contains(text(),'Account')]")
	public WebElement 	accountHeaderText;
	
	@FindBy(xpath="//*[@id='Account-Icons-/-Accounts-Default']")
	public WebElement 	myProfileLinkInMenu;
	
	@FindBy(xpath="//h4[text()='Your Properties']")
	public WebElement 	yourPropertiesHeaderText;
	
	@FindBy(xpath="//div[@class='property-selection__header type--body-medium']/div[1]")
	public WebElement 	propertyNameText;
	
	@FindBy(xpath="//div[@class='property-selection__header type--body-medium']/div[2]")
	public WebElement 	addressText;
	
	@FindBy(xpath="//div[@class='property-selection__header type--body-medium']/div[3]")
	public WebElement 	cityStateText;
	
	@FindBy(xpath="//tr[@class='property-selector']/td[2]")
	public List<WebElement>	listOfCustomers;
	
	
	@FindBy(xpath="//h4[text()='Manage Shipping Address']")
	public WebElement 	manageShippingAddressHeaderText;
	
	@FindBy(xpath="//h4[text()='Manage Orders']")
	public WebElement 	manageOrdersHeaderText;
	
	@FindBy(xpath="//span[text()='Your Property:']/../span")
	public WebElement 	yourPropertyText;
	
	@FindBy(xpath="//span[text()='Your Property:']/..")
	public WebElement 	accountNumberText;

	@FindBy(xpath="//span[text()='Your Property:']/../a")
	public WebElement 	changeLink;
	
	@FindBy(xpath="//span[text()='Your Property:']")
	public WebElement 	yourPropertiesHeaderTextInManageShippingAdddress;
	
	@FindBy(xpath="//div[text()='default']/..")
	public WebElement 	defaultShippingAddress;
	
	@FindBy(xpath="//table[@class=\"table--responsive\"]//th[1]")
	public WebElement 	nameHeaderInAddressTable;
	
	@FindBy(xpath="//table[@class=\"table--responsive\"]//th[2]")
	public WebElement 	addressHeaderInAddressTable;
	
	@FindBy(xpath="//table[@class=\"table--responsive\"]//th[3]")
	public WebElement 	attentionHeaderInAddressTable;
	
	@FindBy(xpath="//table[@class=\"table--responsive\"]//th[4]")
	public WebElement 	actionsHeaderInAddressTable;
	
	@FindBy(xpath="//tbody/tr")
	public List<WebElement> listOfAddressesInManageShippingAddressTab;
	
	public Boolean isOrdersLinkDisplayed()
	{
		waitTool.waitForElement(driver, ordersLink);
		pageManager.common().scrolltoViewElement(ordersLink, driver);
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
		return subscriptionsLink.isDisplayed();
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
		return editEmailAddressLink.isDisplayed();
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
		return manageShippingAddressLinkInAccountMenu.isDisplayed();
	}

	public Boolean isAddShippingAddressLinkInsideShippingInformationBlockDisplayed()
	{
		return addShippingAddressLinkInsideShippingInformationBlock.isDisplayed();
	}

	public Boolean isCommunicationPreferencesInsideEmailConfirmationsBlockDisplayed()
	{
		return communicationPreferencesLink.isDisplayed();
	}


	public void moveToFrequentlyPurchsedPage()
	{
		pageManager.common().scrolltoViewElement(frequentlyPurchasedLink, driver);
		frequentlyPurchasedLink.click();

	}

	public void moveToOrderHistoryAndStatusPage()
	{
		waitTool.waitForElement(driver, ordersLink);
		pageManager.common().scrolltoViewElement(ordersLink, driver);
		ordersLink.click();

	}

	/**Method to get Welcome note text from my account page
	 * @return welcome note string 
	 */	
	public String getMyaccountWelcomeNote() {
		waitTool.waitForElement(driver, myAccountWelcomeNote);
		System.out.println("dajsfdj");
		return myAccountWelcomeNote.getText().trim();
	}

	/**Method to Click on ChangeEmailAddress under manage account
	 * @return 
	 * @return 
	 */
	public void clickChangeEmailAddressLinkText() throws InterruptedException {
		waitTool.waitForElement(driver, changeEmailAddressLinkText);
		changeEmailAddressLinkText.click();
		waitTool.waitFor(driver, true);

	}

	/**
	 * Click Add Shipping address link from My account page
	 * @return the driver to Add New Shipping Address Page
	 */
	public void clickAddShippingAddressLinkInsideShippingInformationBlock() {
		addShippingAddressLinkInsideShippingInformationBlock.click();
	}

	/* @author nm064123
	 * Method to to click and navigate o communications preference page
	 *  
	 */

	public void clickCommunicationsPreferencesLink(){
		communicationPreferencesLinkText.click();

	}

	/*public void disaplyedOldEmailAddressValue()
	{
		Str = displayedEmailAddress.getText();
		System.out.println("emailStr is " + Str);
	}*/
	
	public String disaplyedOldEmailAddressValue()
	{
		waitTool.waitFor(driver, true);
		System.out.println("11111111111");
		String str = displayedEmailAddress.getText();
		System.out.println("2222222222");
		System.out.println("emailStr is " + str);
		return str;
	}

	public String dispalyedUpdatedEmailAddress()
	{
		waitTool.waitForElement(driver, displayedEmailAddress);
		System.out.println("displayedEmailAddress.getText(); is " + displayedEmailAddress.getText());
		return displayedEmailAddress.getAttribute("value");
	}
	
	public Boolean displayedUpdatedEmailAddress(String updatedEmailAddress)
	{
		waitTool.waitFor(driver, true);
		waitTool.waitForElement(driver, userAccountInformation);
		return userAccountInformation.getText().contains(updatedEmailAddress);
	}


	public void changeEmailAddress(String email)
	{
		waitTool.waitFor(driver, true);
		pageManager.common().refresh();
		editEmailAddressLink.click();
		waitTool.waitForElement(driver, changeEmailAddressHeaderText);
		newEmailTextBox.sendKeys(email);
		confirmNewEmailTextBox.sendKeys(email);
		pageManager.common().scrolltoViewElement(updateEmailAddressButton, driver);
		updateEmailAddressButton.click();
	}
	
	public void changeEmailAddressToGetError(String email)
	{
		editEmailAddressLink.click();
		waitTool.waitForElement(driver, changeEmailAddressHeaderText);
		newEmailTextBox.sendKeys(email);
		confirmNewEmailTextBox.sendKeys(email+pageManager.common().getRandomString(4));
		updateEmailAddressButton.click();
	}

	public void changeEmailAddress()
	{
		editEmailAddressLink.click();
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
		editEmailAddressLink.click();
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
		editEmailAddressLink.click();
		newEmailTextBox.sendKeys(disaplyedOldEmailAddressValue);
		confirmNewEmailTextBox.sendKeys(disaplyedOldEmailAddressValue);
		updateEmailAddressButton.click();
	}

	public Boolean changeCommunicationPrefenceToReceiveOnlyMyOrder()
	{
		waitTool.waitForElement(driver, communicationPreferencesLink);
		communicationPreferencesLink.click();
		onlyMyWebOrderRadioButton.click();
		pageManager.common().scrolltoViewElement(updateCommunicationPreferenceButton, driver);
		updateCommunicationPreferenceButton.click();
		waitTool.waitForElement(driver, preferenceUpdateMessage);
		/*comPref = displayedCommunicationPreference.getText();
		System.out.println("compref is" + comPref);
		return comPref;*/
		return preferenceUpdateMessage.isDisplayed();

	}

	public Boolean changeCommunicationPrefenceToReceiveAllOrder()
	{
		pageManager.common().scrolltoViewElement(communicationPreferencesLink, driver);
		communicationPreferencesLink.click();
		waitTool.waitForElement(driver, allOrderRadioButton);
		allOrderRadioButton.click();
		pageManager.common().scrolltoViewElement(updateCommunicationPreferenceButton, driver);
		updateCommunicationPreferenceButton.click();
	/*	comPref = displayedCommunicationPreference.getText();
		System.out.println("compref is" + comPref);
		return comPref;*/
		waitTool.waitForElement(driver, preferenceUpdateMessage);
		return preferenceUpdateMessage.isDisplayed();

	}
	
	
	public Boolean changeCommunicationPrefenceToNoConfirmation()
	{
		pageManager.common().scrolltoViewElement(communicationPreferencesLink, driver);
		communicationPreferencesLink.click();
		waitTool.waitForElement(driver, noConfirmationRadioButton);
		noConfirmationRadioButton.click();
		pageManager.common().scrolltoViewElement(updateCommunicationPreferenceButton, driver);
		updateCommunicationPreferenceButton.click();
		waitTool.waitForElement(driver, preferenceUpdateMessage);
		return preferenceUpdateMessage.isDisplayed();

	}
	
	
	public void changePassword(String oldPassword,String newPassword)
	{
		editPasswordLink.click();
		waitTool.waitForElement(driver,oldPasswordTextBox);
		pageManager.common().scrolltoViewElement(oldPasswordTextBox,driver);
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


	public void logoutFromMyAccount() throws Exception
	{
		waitTool.waitForElement(driver, logo);
		pageManager.common().scrolltoViewElement(logo, driver);
		logo.click();
		waitTool.waitForElement(driver, SignOutLink);
		SignOutLink.click();
		pageManager.common().acceptPopupMessageBox(driver);

	}

	public void goToAddressBook() 
	{
		pageManager.common().scrolltoViewElement(manageShippingAddressLinkInAccountMenu, driver);
		manageShippingAddressLinkInAccountMenu.click();
	}
	
	public void goToYourProperties() 
	{
		waitTool.waitForElement(driver, yourPropertiesLinkInAccountMenu);
		pageManager.common().scrolltoViewElement(yourPropertiesLinkInAccountMenu, driver);
		yourPropertiesLinkInAccountMenu.click();
		waitTool.waitFor(driver, true);
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
        waitTool.waitForElement(driver, backButton);
		backButton.click();
		return new MyAccountPage(driver);
	}

	public void clearAllFieldsinAddressBook()
	{
		shippingAddressNameTextBox.clear();
		addressTextBox.clear();
		floorOrSuiteTextBox.clear();
		cityTextBox.clear();
		pageManager.common().selectByVisibleTextFromDropdown(stateDropdown, "Select a State");
		zipCodeTextBox.clear();
		phoneNumberTextBox.clear();
		companyOrPropertyName.clear();
	}
	
	public void clearAllFieldsinAddressBookBeforeEdit()
	{
		//shippingAddressNameTextBox.clear();
		waitTool.waitForElement(driver, floorOrSuiteTextBox);
		addressTextBoxInEdit.clear();
		floorOrSuiteTextBox.clear();
		cityTextBox.clear();
		pageManager.common().selectByVisibleTextFromDropdown(stateDropdown, "Select a State");
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
		pageManager.common().selectByVisibleTextFromDropdown(stateDropdown, state);
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
		pageManager.common().selectByVisibleTextFromDropdown(stateDropdown, state);
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
		pageManager.common().selectByVisibleTextFromDropdown(stateDropdown, state);
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
		pageManager.common().selectByVisibleTextFromDropdown(stateDropdown, state);
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
		pageManager.common().selectByVisibleTextFromDropdown(stateDropdown, state);
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
		pageManager.common().selectByVisibleTextFromDropdown(stateDropdown, state);
		companyOrPropertyName.sendKeys(cpname);
		addButton.click();
		/*return zipcodeFieldError.getText();*/
		return fieldErrorOnAddAddress.isDisplayed();
	}

	public void addAddress(String shippingAddress, String address,String floor,String city, String state,String zipcode,String phnumber,String cpname) throws Exception
	{
		System.out.println("shippingAddress is "+ shippingAddress);
		System.out.println("address is "+ address);
		System.out.println("floor is "+ floor);
		System.out.println("city is "+ city);
		System.out.println("state is "+ state);
		System.out.println("zipcode is "+ zipcode);
		System.out.println("phnumber is "+ phnumber);
		System.out.println("cpname is "+ cpname);

		waitTool.waitForElement(driver, addNewShippingAddressText);
		phnumber = phnumber.replace("'", "");
		zipcode = zipcode.replace("'", "");
		shippingAddressNameTextBox.sendKeys(shippingAddress);
		addressTextBox.sendKeys(address);
		floorOrSuiteTextBox.sendKeys(floor);
		cityTextBox.sendKeys(city);
		zipCodeTextBox.sendKeys(zipcode);
		pageManager.common().selectByVisibleTextFromDropdown(stateDropdown, state);
		phoneNumberTextBox.sendKeys(phnumber);
		companyOrPropertyName.sendKeys(cpname);
		//waitTool.hardWait();
		waitTool.waitForElement(driver, addButton);
		addButton.click();
	}

	public String addressLine1()
	{
		System.out.println("addressLine1 is "+ addressLine1.getText());
		return addressLine1.getText();
	}

	public String addressLine2()
	{
		System.out.println("addressLine2 is "+ addressLine2.getText());
		return addressLine2.getText();
	}

	public String addressLine3(int i)
	{		
		System.out.println("addressLine3 is "+ addressLine3.get(i).getText());
		return addressLine3.get(i).getText();
	}

	public String addressLine4(int i)
	{
		System.out.println("addressLine4 is "+ addressLine4.get(i).getText());
		return addressLine4.get(i).getText();
	}


	public void clickOnDeleteButtons()
	{
		//int i=0;
	/*	try
		{*/
			System.out.println("deleteButtons.size() "+ deleteButtons.size());
		if(deleteButtons.size()>0)
		{
			for(int i=deleteButtons.size()-1;i>=0;i--)
			{
				pageManager.common().scrolltoViewElement(deleteButtons.get(i), driver);
				deleteButtons.get(i).click();
				waitTool.waitForElement(driver, confirmDeleteButton);
				confirmDeleteButton.click();
				waitTool.waitFor(driver, true);
			}
		}
		/*}
		catch(Exception e)
		{
			System.out.println("deleteButtons is not displayed "+ e);
		}*/
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

	public void updateAddress(String address,String floor,String city, String state,String zipcode,String phnumber,String cpname) throws Exception
	{
		phnumber = phnumber.replace("'", "");
		zipcode = zipcode.replace("'", "");
		floor = floor.replace("'", "");
	//	shippingAddressNameTextBox.sendKeys(shippingAddress);
		addressTextBoxInEdit.sendKeys(address);
		floorOrSuiteTextBox.sendKeys(floor);
		cityTextBox.sendKeys(city);
		zipCodeTextBox.sendKeys(zipcode);
		pageManager.common().selectByVisibleTextFromDropdown(stateDropdown, state);
		phoneNumberTextBox.sendKeys(phnumber);
		companyOrPropertyName.sendKeys(cpname);
		pageManager.common().scrolltoViewElement(submitButtonAfterEdit, driver);
		submitButtonAfterEdit.click();
		waitTool.waitForElement(driver, manageShippingAddressHeadingTitle);
	}
	
	public void updateAddressAndCancel(String address,String floor,String city, String state,String zipcode,String phnumber,String cpname) throws Exception
	{
		
		phnumber = phnumber.replace("'", "");
		zipcode = zipcode.replace("'", "");
		floor = floor.replace("'", "");
	//	shippingAddressNameTextBox.sendKeys(shippingAddress);
		addressTextBoxInEdit.sendKeys(address);
		floorOrSuiteTextBox.sendKeys(floor);
		cityTextBox.sendKeys(city);
		zipCodeTextBox.sendKeys(zipcode);
		pageManager.common().selectByVisibleTextFromDropdown(stateDropdown, state);
		phoneNumberTextBox.sendKeys(phnumber);
		companyOrPropertyName.sendKeys(cpname);
		cancelButtonAfterEdit.click();
		waitTool.waitForElement(driver, manageShippingAddressHeadingTitle);
	}
	

	public void goToAddressBookManageEdit() 
	{
		manageShippingAddressLinkInAccountMenu.click();
		clickOnEditButton();

	}
	public void deleteNonDefaultAddress()
	{
		manageShippingAddressLinkInAccountMenu.click();
		clickOnDeleteButtons();
	}

	public void clickOnEditButton()
	{

		editButton.get(0).click();
	}
	
	public void clickOnEditButtonForAddedAddress(String nameFinal)
	{
		System.out.println("nameList is ");
		for(WebElement list : nameList)
		{
			System.out.println(list.getText());
		}
		System.out.println("nameFinal is "+ nameFinal);
		int i;
		for(i=0;i<nameList.size();i++ )
		{
			
			pageManager.common().scrolltoViewElement(nameList.get(i), driver);
			if(nameList.get(i).getText().toLowerCase().trim().equalsIgnoreCase(nameFinal.trim()))
			{
				System.out.println("got value of"+ nameFinal.trim() +"  "+i);
				pageManager.common().scrolltoViewElement(editButton.get(i), driver);
				editButton.get(i).click();
				break;
			}
		}
	}
	
	public void deleteNewlyAddedAddress(String nameFinal)
	{
		int i;
		for(i=0;i<nameList.size();i++ )
		{
			pageManager.common().scrolltoViewElement(nameList.get(i), driver);
			if(nameList.get(i).getText().toLowerCase().trim().equalsIgnoreCase(nameFinal.trim()))
			{
				deleteButtons.get(i).click();
				waitTool.waitForElement(driver, confirmDeleteButton);
				pageManager.common().scrolltoViewElement(confirmDeleteButton, driver);
				confirmDeleteButton.click();
				waitTool.waitFor(driver, true);
				break;
			}
		}
	}
	
	
	
	public Boolean verifyAddress(String nameFinal,String address,String floorSuite,String city,String state,String zipcode,String phone,String comProp)
	{
		floorSuite=floorSuite.replace("'", "");
		zipcode=zipcode.replace("'", "");
		int i;
		Boolean flag = false;

		System.out.println("nameList is ");
		for(WebElement list : nameList)
		{
			System.out.println(list.getText());
		}
		System.out.println("nameFinal is "+ nameFinal);
		for(i=0;i<nameList.size();i++ )
		{
			pageManager.common().scrolltoViewElement(nameList.get(i), driver);
			if(nameList.get(i).getText().toLowerCase().trim().equalsIgnoreCase(nameFinal.trim()))
			{
				System.out.println("got value of"+ nameFinal.trim() +"  "+i);

				if(addressList.get(i).getText().contains(address) && addressList.get(i).getText().contains(floorSuite)
						&& addressList.get(i).getText().contains(city) && addressList.get(i).getText().contains(zipcode))
				{
					System.out.println(addressList.get(i).getText() + "contains all " + address + " "+ floorSuite+" " + city + " "+ zipcode);
				flag=true;

				break;
				}

			}
		}
		if(flag==true)
		{	
		deleteNewlyAddedAddress(nameFinal);
		}
		return flag;
	}
		

	public void clearAllFieldsinUpdateAddressBook()
	{
		addressTextBox.clear();
		floorOrSuiteTextBox.clear();
		cityTextBox.clear();
		pageManager.common().selectByVisibleTextFromDropdown(stateDropdown, "Select a State");
		zipCodeTextBox.clear();
		phoneNumberTextBox.clear();
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

	public String fillOutNewShippingAddress(String addressName, String companyName, String address, String city, String state, String zip,String phoneNumber){
		
		waitTool.waitForElement(driver,addShippingAddressButton);
		pageManager.common().scrolltoViewElement(addShippingAddressButton, driver);
		addShippingAddressButton.click();
		waitTool.waitForElement(driver, shippingAddressNameTextBox);
		String nameFinal = addressName + pageManager.common().getRandomString(4);
		shippingAddressNameTextBox.sendKeys(nameFinal);
		companyOrPropertyName.sendKeys(companyName + pageManager.common().getRandomString(4) );
		addressTextBox.sendKeys(address);
		cityTextBox.sendKeys(city);
		//stateDropdown.click();
		pageManager.common().selectByVisibleTextFromDropdown(stateDropdown, state);
		zipCodeTextBox.sendKeys(zip);
		phoneNumberTextBox.sendKeys(phoneNumber);
		pageManager.common().scrolltoViewElement(submitButton,driver);
		submitButton.click();
		pageManager.common().refresh();
		waitTool.waitForElement(driver, manageShippingAddressHeadingTitle);
		pageManager.common().scrolltoViewElement(manageShippingAddressHeadingTitle, driver);
		Assert.assertTrue(manageShippingAddressHeadingTitle.isDisplayed());
		return nameFinal;
	}
	
	public Boolean verifyAboutYouInformation()
	{
		Boolean flag = false;
		List<Boolean> flags = new ArrayList<Boolean>();
		flags.add(passwordInformation.isDisplayed());
		flags.add(userAccountInformation.isDisplayed());
		flags.add(typeOfBusinessInformation.isDisplayed());
		flags.add(customerNumberInformation.isDisplayed());
		
		if(flags.contains(false))
		{
			flag=false;
		}
		else
		{
			flag=true;
		}
		return flag;

	}
	
	public void clickOnMyProfileLogo()
	{
		waitTool.waitForElement(driver, myProfileLogo);
		pageManager.common().scrolltoViewElement(myProfileLogo, driver);
		myProfileLogo.click();
		waitTool.waitFor(driver, true);
	}
	

	public Boolean isSuccessfulEmailUpdateMessageDisplayed()
	{
		waitTool.waitForElement(driver, successfulEmailUpdateMessage);
		return successfulEmailUpdateMessage.isDisplayed();

	}
	
	public Boolean isEmailDoesNotErrorDisplayed()
	{
		waitTool.waitForElement(driver, emailIdDoesNotMatchError);
		Boolean flag =  emailIdDoesNotMatchError.isDisplayed();
		closeChangeEmailModalWindow.click();
		return flag;

	}

	public Boolean areValuesUnderPropertiesTableSorted(String valueType)
	{
		Boolean flag = true;
		LinkedList<String> valuesInAscendingOrder = new LinkedList<String>(); 
		LinkedList<String> valuesInDescendingOrder =new LinkedList<String>(); 
		if(valueType.equals("name"))
		{
			nameHeaderInPropertiesTable.click();
			for(WebElement name : namesInPropertiesTable)
			{
				valuesInAscendingOrder.add(name.getText());
			}
			System.out.println("valuesInAscendingOrder iss"+ valuesInAscendingOrder);
			nameHeaderInPropertiesTable.click();
			for(WebElement name : namesInPropertiesTable)
			{
				valuesInDescendingOrder.add(name.getText());
			}
			System.out.println("valuesInDescendingOrder iss"+ valuesInDescendingOrder);

			if(valuesInAscendingOrder.equals(valuesInDescendingOrder) && valuesInAscendingOrder.size()>1 && valuesInDescendingOrder.size()>1)
			{
				flag =false;
			}
		}
		
		if(valueType.equals("accountNumber"))
		{
			accountHeaderInPropertiesTable.click();
			for(WebElement accountNumber : accountNumbersInPropertiesTable)
			{
				valuesInAscendingOrder.add(accountNumber.getText());
			}
			accountHeaderInPropertiesTable.click();
			for(WebElement accountNumber : accountNumbersInPropertiesTable)
			{
				valuesInDescendingOrder.add(accountNumber.getText());
			}

			if(valuesInAscendingOrder.equals(valuesInDescendingOrder) && valuesInAscendingOrder.size()>1 && valuesInDescendingOrder.size()>1)
			{
				flag =false;
			}
		}
		
		if(valueType.equals("city"))
		{
			cityHeaderrInPropertiesTable.click();
			for(WebElement city : citiesInPropertiesTable)
			{
				valuesInAscendingOrder.add(city.getText());
			}
			cityHeaderrInPropertiesTable.click();
			for(WebElement city : citiesInPropertiesTable)
			{
				valuesInDescendingOrder.add(city.getText());
			}

			if(valuesInAscendingOrder.equals(valuesInDescendingOrder) && valuesInAscendingOrder.size()>1 && valuesInDescendingOrder.size()>1)
			{
				flag =false;
			}
		}
		
		if(valueType.equals("state"))
		{
			stateHeaderInPropertiesTable.click();
			for(WebElement state : statesInPropertiesTable)
			{
				valuesInAscendingOrder.add(state.getText());
			}
			stateHeaderInPropertiesTable.click();
			for(WebElement state : statesInPropertiesTable)
			{
				valuesInDescendingOrder.add(state.getText());
			}

			if(valuesInAscendingOrder.equals(valuesInDescendingOrder) && valuesInAscendingOrder.size()>1 && valuesInDescendingOrder.size()>1)
			{
				flag =false;
			}
		}
		return flag;

	}
	
	public Boolean isYourPropertiesHeaderTextDisplayed()
	{
		yourPropertiesLinkInAccountMenu.click();
		waitTool.waitFor(driver, true);
		return yourPropertiesHeaderText.isDisplayed();
	}
	
	public Boolean isManageShippingAddressHeaderTextDisplayed()
	{
		manageShippingAddressLinkInAccountMenu.click();
		waitTool.waitFor(driver, true);
		return manageShippingAddressHeaderText.isDisplayed();
	}
	
	public Boolean isManageOrdersHeaderTextDisplayed()
	{
		manageOrdersLinkInAccountMenu.click();
		waitTool.waitFor(driver, true);
		return manageOrdersHeaderText.isDisplayed();
	}
	
	public Boolean isAboutYouPageDisplayed()
	{
		aboutLink.click();
		waitTool.waitFor(driver, true);
		return customerNumberText.isDisplayed();
	}
	
	public Boolean isCommunicationPreferencesHeaderTextDisplayed()
	{
		communicationPreferencesLink.click();
		waitTool.waitFor(driver, true);
		return communicationPreferencesHeaderText.isDisplayed();
	}
	
	public Boolean verifyCancelSignOut()
	{
		signOutLinkInMenu.click();
		pageManager.common().cancelPopupMessageBox(driver);
		return signOutLinkInMenu.isDisplayed();
	}
	
	public Boolean verifySignOut()
	{
		signOutLinkInMenu.click();
		pageManager.common().acceptPopupMessageBox(driver);
		waitTool.waitFor(driver, true);
		return pageManager.loginPage().signInOrRegister.isDisplayed();
	}

	public Boolean verifyNavigateToYourPropertiesByClickOnChange()
	{
		changeLink.click();
		waitTool.waitFor(driver, true);
		return yourPropertiesHeaderText.isDisplayed();
	}
	
	
	public Boolean isNavigatedToQuotesPage()
	{
		quotesLink.click();
		waitTool.waitFor(driver, true);
		pageManager.quoteListsPage().isDisplayedQuotesPageHeadingText();
		pageManager.common().navigateBack();
		waitTool.waitForElement(driver, manageOrdersHeaderText);
		return manageOrdersHeaderText.isDisplayed();

	}
	
	public Boolean isNavigatedToOrdersPage()
	{
		ordersLink.click();
		waitTool.waitFor(driver, true);
		pageManager.ordersPage().isDisplayedOrderspageHeading();
		pageManager.common().navigateBack();
		waitTool.waitForElement(driver, manageOrdersHeaderText);
		return manageOrdersHeaderText.isDisplayed();

	}
	
	public Boolean isNavigatedToListPage()
	{
		listsLink.click();
		waitTool.waitFor(driver, true);
		pageManager.savedListsPage().isDisplayedSavedListspageHeadingText();
		pageManager.common().navigateBack();
		waitTool.waitForElement(driver, manageOrdersHeaderText);
		return manageOrdersHeaderText.isDisplayed();
	}
	
	public Boolean isNavigatedToFrequentlyPurchasedPage()
	{
		frequentlyPurchasedLink.click();
		waitTool.waitFor(driver, true);
		pageManager.frequentlyPurchasedPage().isDisplayedSortByDropDown();
		pageManager.common().navigateBack();
		waitTool.waitForElement(driver, manageOrdersHeaderText);
		return manageOrdersHeaderText.isDisplayed();

	}
	
	public Boolean isNavigatedToSubscriptionsPage()
	{
		subscriptionsLink.click();
		waitTool.waitFor(driver, true);
		pageManager.subscriptionsPage().subscriptionsPageHeadingText.isDisplayed();
		pageManager.common().navigateBack();
		waitTool.waitForElement(driver, manageOrdersHeaderText);
		return manageOrdersHeaderText.isDisplayed();

	}
	
	public Boolean isNavigatedToElectronicInvoicingPage()
	{
		electronicInvoicingLink.click();
		waitTool.waitFor(driver, true);
		electronicInvoicingHeaderText.isDisplayed();
		pageManager.common().navigateBack();
		waitTool.waitForElement(driver, manageOrdersHeaderText);
		return manageOrdersHeaderText.isDisplayed();

	}
	
	public Boolean isListOfCustomersDisplayed()
	{
		Boolean flag = false;
		if(listOfCustomers.size()>0)
		{
			flag=true;
		}
		return flag;
	}
	
	public String navigateToOtherCustomer()
	{
		if(listOfCustomers.size()>1)
		{
			String value = listOfCustomers.get(1).getText();
			listOfCustomers.get(1).click();
			waitTool.waitFor(driver, true);
			return value;
		}
		else
		{
			String value = listOfCustomers.get(0).getText();
			listOfCustomers.get(0).click();
			waitTool.waitFor(driver, true);
			return value;
		}
	}

	public Boolean areHeadersDisplayed()
	{
		Boolean flag = true;
		List<Boolean> values = new LinkedList();
		values.add(attentionHeaderInAddressTable.isDisplayed());
		values.add(addressHeaderInAddressTable.isDisplayed());
		values.add(nameHeaderInAddressTable.isDisplayed());
		values.add(actionsHeaderInAddressTable.isDisplayed());
		if(values.contains(false))
		{
			flag=false;	
		}
		return flag;


	}
	
	public Boolean isListOfAddressesInManageShippingAddressDisplayed()
	{
		Boolean flag = false;
		if(listOfAddressesInManageShippingAddressTab.size()>0)
			flag=true;
		return flag;
	}

}





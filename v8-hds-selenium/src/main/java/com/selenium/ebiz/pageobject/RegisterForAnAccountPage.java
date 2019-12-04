package com.selenium.ebiz.pageobject;

import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.WaitTool;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;

public class RegisterForAnAccountPage
{
	private ArrayList<UsersListBean> usersList,usersList1;

	PageManager pageManager;
	private  WebDriver driver; 
	private WaitTool   waitTool;
	String str = "abcd";
	public RegisterForAnAccountPage(WebDriver driver)
	{
		this.driver = driver;  this.waitTool = new WaitTool();
		PageFactory.initElements(driver, this);
		pageManager = new PageManager(driver);

	}

	@FindBy(xpath="//div[@class='WCTooltip']")
	WebElement errorMessage;

	@FindBy(xpath="//div[@class='input__error']")
	WebElement fieldErrorOnAddAddress;

	@FindBy(xpath = "//p[contains(text(),'brand new to HD Supply')]") 
	WebElement brandNewUserToHDSupplyRadioButton;

	@FindBy(xpath = "//select[@id='industryType']") 
	WebElement industryTypeDropdown;

	@FindBy(xpath = "//select[@name='businessType']") 
	WebElement typeOfBusinessDropdown;

	@FindBy(xpath = "//span[@id='unitTypeNameSpan']") 
	WebElement numberOfText;

	@FindBy(xpath = "//div[@class='cust-profile__field-item']//input[@name='orgName']") 
	WebElement companyName;

	@FindBy(xpath = "//div[@class='cust-profile__field-item']//span[contains(text(),'Property Name')]/..//div[@class='WCTooltip']")  
	public WebElement companyNameErrorMessage;

	@FindBy(xpath = "//span[text()='First Name']/..//div[@class='WCTooltip']") 
	public WebElement firstNameErrorMessage;

	@FindBy(xpath = "//span[text()='Last Name']/..//div[@class='WCTooltip']") 
	public WebElement lastNameErrorMessage;

	@FindBy(xpath = "//span[contains(text(),'Number of ')]/..//div[@class='WCTooltip']") 
	public WebElement numberOfErrorMessage;

	@FindBy(xpath = "//form[@name='UserRegDefaultShippingForm']/div[@class='shipping-billing__form-fields']//span[text()='Address']/../div[@class='WCTooltip']") 
	public WebElement addressErrorMessage;

	@FindBy(xpath = "//div[contains(text(),'Error: Our system requires a minimum combination of 6 numbers')]") 
	public WebElement passwordErrorMessage;

	@FindBy(xpath = "//div[@class='cust-profile__field-item']//span[contains(text(),'Property Name')]")  
	public WebElement companyNameMandatory;

	@FindBy(xpath = "//span[text()='First Name']") 
	public WebElement firstNameMandatory;

	@FindBy(xpath = "//span[text()='Last Name']") 
	public WebElement lastNameMandatory;

	@FindBy(xpath = "//span[text()='Phone Number']") 
	public WebElement phoneNumberMandatory;

	@FindBy(xpath = "//span[text()='Industry']") 
	public WebElement industryMandatory;

	@FindBy(xpath = "//span[text()='Select Type of Business']") 
	public WebElement selectTypeOfBusinessMandatory;

	@FindBy(xpath = "//span[contains(text(),'Number of ')]") 
	public WebElement numberOfMandatory;

	@FindBy(xpath = "//input[@name='firstName']") 
	WebElement firstName;

	@FindBy(xpath = "//input[@name='lastName']") 
	WebElement lastName;

	@FindBy(xpath = "//input[@name='phone1']") 
	WebElement phoneNumber;

	@FindBy(xpath = "//input[@id='WC_UserRegistrationAddForm_FormInput_faxNum_In_Register_1']") 
	WebElement faxNumber;

	@FindBy(xpath = "//input[@id='orgEntityQty']") 
	WebElement numberOf;

	@FindBy(xpath = "//form[@id='USerRegCustomerProfileForm']//div[@class='cust-profile__form-footer']/button[contains(text(),'Next')]") 
	WebElement nextButton1;

	@FindBy(xpath = "//input[@id='HDS_UserRegistrationAddForm_AddressEntryForm_FormInput_shipping_addressname_1']") 
	WebElement shippingAddressName;

	@FindBy(xpath = "//div[@class='shipping-billing__form-fields']//label[@class='form-field--required']/span[text()='Company/ Property Name']/../input") 
	WebElement propertyName;

	@FindBy(xpath = "//input[@id='HDS_UserRegistrationAddForm_AddressEntryForm_FormInput_shipping_attentionof_1']") 
	WebElement attentionOf;

	@FindBy(xpath = "//input[@id='shipping_autocomplete']") 
	WebElement lookupAddress;

	@FindBy(xpath = "//input[@id='HDS_UserRegistrationAddForm_AddressEntryForm_FormInput_shipping_address1_1']") 
	WebElement address;

	@FindBy(xpath = "//input[@id='HDS_UserRegistrationAddForm_AddressEntryForm_FormInput_shipping_address2_1']") 
	WebElement floorOrSuite;

	@FindBy(xpath = "//input[@id='HDS_UserRegistrationAddForm_AddressEntryForm_FormInput_shipping_city_1']") 
	WebElement city;

	@FindBy(xpath = "//select[@id='HDS_UserRegistrationAddForm_AddressEntryForm_FormInput_shipping_state_1']") 
	WebElement stateDropdown;

	@FindBy(xpath = "//input[@id='HDS_UserRegistrationAddForm_AddressEntryForm_FormInput_shipping_zipcode_1']") 
	WebElement zipCode;

	@FindBy(xpath = "//div[@class='shipping-billing__form']/div[@class='credentials__submit']//button[@class='btn']") 
	WebElement nextButton2;

	@FindBy(xpath = "//input[@name='emailAddress']") 
	WebElement emailAddress;

	@FindBy(xpath = "//input[@name='confirmEmailAddress']") 
	WebElement confirmEmailAddress;

	@FindBy(xpath = "//input[@id='WC_UserRegistrationAddForm_FormInput_logonId_In_Register_1_1']") 
	WebElement userName;

	@FindBy(xpath = "//input[@id='WC_UserRegistrationAddForm_FormInput_logonPassword_In_Register_1']") 
	WebElement password;

	@FindBy(xpath = "//div[@class=shipping-billing__form--mtb]//span") 
	WebElement billingAddressSame;

	@FindBy(xpath = "//button[@id='WC_UserRegistrationAddForm_FormInput_Submit']") 
	WebElement submitButton;

	@FindBy(xpath = "//div[@class='confirmation__header']/p[1]") 
	WebElement thankyouForRegistration;

	@FindBy(xpath = "//div[@class='header__main']//div[@id='contentRecommendationWidget_HdsHeaderLogoESpot']")
	WebElement hDSupplyLogoInHeader;

	@FindBy(xpath = "//h4[@data-hds-tag='UR_ShippingBilling-register_shipping-billing__heading']/../div/div/p/strong[contains(text(),'Please Note:')]")
	public WebElement defaultShippingMessage1;

	@FindBy(xpath = "//h4[@data-hds-tag='UR_ShippingBilling-register_shipping-billing__heading']/../div/div")
	public WebElement defaultShippingMessage2;

	@FindBy(xpath = "//h4[@data-hds-tag='UR_ShippingBilling-register_shipping-billing__heading']/../div/div[contains(text(),'We may deliver some products to residential addresses. Contact us for details at 1.877.694.4932')]")
	public WebElement defaultShippingMessage3;

	public void clickOnBrandNewUSerToHDSupply()
	{

		pageManager.common().scrolltoViewElement(brandNewUserToHDSupplyRadioButton, driver);
		System.out.println("moved to brandNewUserToHDSupplyRadioButton");
		brandNewUserToHDSupplyRadioButton.click();
	}

	public void selectIndustryFromDropdown(String industry)
	{
		Select select = new Select(industryTypeDropdown);
		select.selectByVisibleText(industry);
	}

	public void selectTypeOfBusinessFromDropdown(String business)
	{
		Select select = new Select(typeOfBusinessDropdown);
		select.selectByVisibleText(business);
	}

	public String NumberOfTextDisplayed()
	{
		System.out.println("numberOfText.getText() issss"  + numberOfText.getText());
		return numberOfText.getText();
	}

	public void insertValueInCompanyName(String comprop)
	{
		companyName.clear();
		System.out.println("comprop is " + comprop);
		String random = pageManager.common().getRandomNumber();
		comprop = comprop+ random;
		System.out.println("compropName is "+ comprop);
		companyName.sendKeys(comprop);
	}


	public void insertValueInFirstName(String fName)
	{
		firstName.clear();
		String random = pageManager.common().getRandomNumber();
		fName = fName+ random;
		System.out.println("fName is "+ fName);
		firstName.sendKeys(fName);
	}

	public void insertValueInLastName(String lname)
	{
		lastName.clear();
		String random = pageManager.common().getRandomNumber();
		lname = lname+ random;
		System.out.println("lname is "+ lname);
		lastName.sendKeys(lname);
	}

	public void insertValueInPhoneNumber()
	{
		phoneNumber.clear();
		String random1 = pageManager.common().getRandomNumber();
		String random2 = pageManager.common().getRandomNumber();
		String pnumber = "98"+ random1+random2;
		System.out.println("pnumber is "+ pnumber);
		phoneNumber.sendKeys(pnumber);
	}


	public void insertValueInFaxNumber()
	{
		faxNumber.clear();
		String random1 = pageManager.common().getRandomNumber();
		String random2 = pageManager.common().getRandomNumber();
		String fnumber = "98"+ random1+random2;
		System.out.println("fnumber is "+ fnumber);
		faxNumber.sendKeys(fnumber);
	}

	public void insertInvalidValueInPhoneNumber()
	{
		phoneNumber.clear();
		System.out.println("str is "+ str);
		phoneNumber.sendKeys(str);
	}

	public void insertValueInNumberOf()
	{
		numberOf.clear();
		String random = pageManager.common().getRandomNumber();
		System.out.println("random is "+ random);
		numberOf.sendKeys(random);
	}

	public void insertValueInNumberOf(String nOf)
	{
		numberOf.clear();
		numberOf.sendKeys(nOf);
	}

	public void insertInvalidValueInNumberOf()
	{
		numberOf.clear();
		System.out.println("str is "+ str);
		numberOf.sendKeys(str);
	}


	public void clickOnNextButton1()
	{
		pageManager.common().scrolltoViewElement(nextButton1, driver);
		nextButton1.click();
	}

	public void insertValueInShippingAddrsssName(String shipadd)
	{
		shippingAddressName.clear();
		System.out.println("shipadd is "+ shipadd);
		shippingAddressName.sendKeys(shipadd);
	}

	public void insertValueInPropertyName(String comprop)
	{
		propertyName.clear();
		System.out.println("comprop is " + comprop);
		String random = pageManager.common().getRandomNumber();
		comprop = comprop+ random;
		System.out.println("comprop is "+ comprop);
		propertyName.sendKeys(comprop);
	}

	public void insertValueInAttentionOf()
	{
		attentionOf.clear();
		String random = pageManager.common().getRandomNumber();
		System.out.println("random is "+ random);
		attentionOf.sendKeys(random);
	}

	public void insertValueInLookupAddress(String lookup)
	{
		lookupAddress.clear();
		System.out.println("lookup is "+ lookup);	
		lookupAddress.sendKeys(lookup);
	}


	public void insertValueInAddress(String add)
	{
		address.clear();
		System.out.println("add is "+ add);
		address.sendKeys(add);
	}

	public void insertValueInFloorOrSuite()
	{
		floorOrSuite.clear();
		String random = pageManager.common().getRandomNumber();
		System.out.println("random is "+ random);
		floorOrSuite.sendKeys(random);
	}

	public void insertValueInCity(String cname)
	{
		city.clear();
		System.out.println("cname is "+ cname);
		city.sendKeys(cname);
	}

	public void selectStateFromDropdown(String state)
	{
		Select select = new Select(stateDropdown);
		System.out.println("state is "+ state);
		select.selectByVisibleText(state);
	}

	public void insertValueInZipcode(String zcode) 
	{
		zipCode.clear();
		zcode = zcode.replace("'", "");
		System.out.println("zcode is "+ zcode);
		zipCode.sendKeys(zcode);
	}

	public Boolean isBillingAddressSameShiipingAddress()
	{
		return billingAddressSame.isSelected();
	}

	public void clickOnNextButton2()
	{
		pageManager.common().scrolltoViewElement(nextButton2, driver);
		nextButton2.click();
	}

	public String insertValueInEmailAddress(String name)
	{
		pageManager.common().scrolltoViewElement(emailAddress, driver);
		waitTool.waitForElement(driver, emailAddress);
		emailAddress.clear();
		String random = pageManager.common().getRandomNumber();
		String email = name+ random+"@something.apartments"; /*@gmail.com";*/
		System.out.println("email is "+ email);
		emailAddress.sendKeys(email);
		return email;
	}

	public void insertValueInConfirmEmailAddress(String confemail)
	{
		confirmEmailAddress.clear();
		System.out.println("confemail is "+ confemail);
		confirmEmailAddress.sendKeys(confemail);
	}


	public String insertValueInUsername(String uname)
	{
		userName.clear();
		String random = pageManager.common().getRandomNumber();
		uname = uname+ random;
		System.out.println("uname is "+ uname);
		userName.sendKeys(uname);
		return uname;
	}

	public void insertValueInPassword(String pwd)
	{
		password.clear();
		System.out.println("pwd is "+ pwd);
		password.sendKeys(pwd);
	}

	public void clickOnSubmit() throws Exception
	{
		pageManager.common().scrolltoViewElement(submitButton, driver);
		submitButton.click();
	}

	public Boolean isThankyouForRegistrationDisplayed() 
	{
		waitTool.waitForElement(driver, thankyouForRegistration);
		pageManager.common().scrolltoViewElement(thankyouForRegistration, driver);
		return thankyouForRegistration.isDisplayed();
	}

	public Boolean isCompanyNameMandatoryDisplayed()
	{
		return companyNameMandatory.isDisplayed();
	}

	public Boolean isFieldErrorOnAddAddressDisplayed()
	{
		return fieldErrorOnAddAddress.isDisplayed();
	}

	public HomePage clickOnHDSupplyLogoInHeader()
	{
		pageManager.common().scrolltoViewElement(hDSupplyLogoInHeader, driver);
		hDSupplyLogoInHeader.click();
		return new HomePage(driver);
	}

	public Boolean isPasswordErrorMessageDisplayed()
	{
		waitTool.waitForElement(driver, passwordErrorMessage);
		pageManager.common().scrolltoViewElement(passwordErrorMessage, driver);
		return passwordErrorMessage.isDisplayed();
	}


	public void fillCustomerDetails(String rowName,String sheetName) throws Exception 
	{	
		usersList = pageManager.dBCon().loadDataFromExcel(rowName,sheetName);
		System.out.println("user list is " + usersList);
		pageManager.registerForAnAccountPage().insertValueInCompanyName(usersList.get(0).getCompanyOrPropertyName());
		pageManager.registerForAnAccountPage().insertValueInFirstName(usersList.get(0).getFirstName());
		pageManager.registerForAnAccountPage().insertValueInLastName(usersList.get(0).getLastName());
		pageManager.registerForAnAccountPage().insertValueInPhoneNumber();
		pageManager.registerForAnAccountPage().selectIndustryFromDropdown(usersList.get(0).getIndustry());
		pageManager.registerForAnAccountPage().selectTypeOfBusinessFromDropdown(usersList.get(0).getTypeofBusiness());
		pageManager.registerForAnAccountPage().insertValueInNumberOf(usersList.get(0).getNumberof());
		//pageManager.registerForAnAccountPage().insertValueInNumberOf();
	}

	public void fillCustomerAndAddressDetails(String rowName,String sheetName) throws Exception 
	{	
		usersList = pageManager.dBCon().loadDataFromExcel(rowName,sheetName);
		pageManager.registerForAnAccountPage().insertValueInCompanyName(usersList.get(0).getCompanyOrPropertyName());
		pageManager.registerForAnAccountPage().insertValueInFirstName(usersList.get(0).getFirstName());
		pageManager.registerForAnAccountPage().insertValueInLastName(usersList.get(0).getLastName());
		pageManager.registerForAnAccountPage().insertValueInPhoneNumber();
		pageManager.registerForAnAccountPage().selectIndustryFromDropdown(usersList.get(0).getIndustry());
		pageManager.registerForAnAccountPage().selectTypeOfBusinessFromDropdown(usersList.get(0).getTypeofBusiness());
		pageManager.registerForAnAccountPage().insertValueInNumberOf();	
		pageManager.registerForAnAccountPage().clickOnNextButton1();
		pageManager.registerForAnAccountPage().insertValueInShippingAddrsssName(usersList.get(0).getShippingAddressName());
		pageManager.registerForAnAccountPage().insertValueInPropertyName(usersList.get(0).getCompanyOrPropertyName());
		pageManager.registerForAnAccountPage().insertValueInAttentionOf();
		pageManager.registerForAnAccountPage().insertValueInLookupAddress(usersList.get(0).getLookupAddress());
		pageManager.registerForAnAccountPage().insertValueInAddress(usersList.get(0).getAddress());
		pageManager.registerForAnAccountPage().insertValueInFloorOrSuite();
		pageManager.registerForAnAccountPage().insertValueInCity(usersList.get(0).getCity());
		pageManager.registerForAnAccountPage().selectStateFromDropdown(usersList.get(0).getState());
		pageManager.registerForAnAccountPage().insertValueInZipcode(usersList.get(0).getZipCode());

	}
	
	public void fillCustomerAddressAndLoginDetails(String rowName,String sheetName) throws Exception 
	{	
		System.out.println("rowName is" + rowName + " and sheetName is " + sheetName);
		usersList = pageManager.dBCon().loadDataFromExcel(rowName,sheetName);
		System.out.println("user list is " + usersList);
		usersList1 = pageManager.dBCon().loadDataFromExcel(rowName,sheetName);
		pageManager.registerForAnAccountPage().insertValueInCompanyName(usersList1.get(0).getCompanyOrPropertyName());
		pageManager.registerForAnAccountPage().insertValueInFirstName(usersList1.get(0).getFirstName());
		pageManager.registerForAnAccountPage().insertValueInLastName(usersList1.get(0).getLastName());
		pageManager.registerForAnAccountPage().insertValueInPhoneNumber();
		pageManager.registerForAnAccountPage().selectIndustryFromDropdown(usersList1.get(0).getIndustry());
		pageManager.registerForAnAccountPage().selectTypeOfBusinessFromDropdown(usersList1.get(0).getTypeofBusiness());
		pageManager.registerForAnAccountPage().insertValueInNumberOf();	
		pageManager.registerForAnAccountPage().clickOnNextButton1();
		pageManager.registerForAnAccountPage().insertValueInShippingAddrsssName(usersList1.get(0).getShippingAddressName());
		pageManager.registerForAnAccountPage().insertValueInPropertyName(usersList1.get(0).getCompanyOrPropertyName());
		pageManager.registerForAnAccountPage().insertValueInAttentionOf();
		pageManager.registerForAnAccountPage().insertValueInLookupAddress(usersList1.get(0).getLookupAddress());
		pageManager.registerForAnAccountPage().insertValueInAddress(usersList1.get(0).getAddress());
		pageManager.registerForAnAccountPage().insertValueInFloorOrSuite();
		pageManager.registerForAnAccountPage().insertValueInCity(usersList1.get(0).getCity());
		pageManager.registerForAnAccountPage().selectStateFromDropdown(usersList1.get(0).getState());
		pageManager.registerForAnAccountPage().insertValueInZipcode(usersList1.get(0).getZipCode());
		pageManager.registerForAnAccountPage().clickOnNextButton2();
		String email = pageManager.registerForAnAccountPage().insertValueInEmailAddress(usersList1.get(0).getEmailAddress());
		pageManager.registerForAnAccountPage().insertValueInConfirmEmailAddress(email);
		pageManager.registerForAnAccountPage().insertValueInUsername(usersList1.get(0).getUsername());
		pageManager.registerForAnAccountPage().insertValueInPassword(usersList1.get(0).getpassword());
		pageManager.registerForAnAccountPage().clickOnSubmit();

	}
	
	public boolean isAddressErrorMessageDisplayed()
	{
		waitTool.waitForElement(driver, addressErrorMessage);
		pageManager.common().scrolltoViewElement(addressErrorMessage, driver);
		return addressErrorMessage.isDisplayed();
	}
	
	public boolean isDefaultShippingMessage1Displayed()
	{
		waitTool.waitForElement(driver, defaultShippingMessage1);
		pageManager.common().scrolltoViewElement(defaultShippingMessage1, driver);
		return defaultShippingMessage1.isDisplayed();
	}
	
	public boolean isDefaultShippingMessage2Displayed()
	{
		waitTool.waitForElement(driver, defaultShippingMessage2);
		pageManager.common().scrolltoViewElement(defaultShippingMessage2, driver);
		return defaultShippingMessage2.isDisplayed();
	}
	
	public boolean isDefaultShippingMessage3Displayed()
	{
		waitTool.waitForElement(driver, defaultShippingMessage3);
		pageManager.common().scrolltoViewElement(defaultShippingMessage3, driver);
		return defaultShippingMessage3.isDisplayed();
	}
	
	public boolean isNumberOfErrorMessageDisplayed()
	{
		waitTool.waitForElement(driver, numberOfErrorMessage);
		pageManager.common().scrolltoViewElement(numberOfErrorMessage, driver);
		return numberOfErrorMessage.isDisplayed();
	}
	
	public boolean isLastNameErrorMessageDisplayed()
	{
		waitTool.waitForElement(driver, lastNameErrorMessage);
		pageManager.common().scrolltoViewElement(lastNameErrorMessage, driver);
		return lastNameErrorMessage.isDisplayed();
	}
	
	public boolean isFirstNameErrorMessageDisplayed()
	{
		waitTool.waitForElement(driver, firstNameErrorMessage);
		pageManager.common().scrolltoViewElement(firstNameErrorMessage, driver);
		return firstNameErrorMessage.isDisplayed();
	}
	
	public boolean isCompanyNameErrorMessageDisplayed()
	{
		waitTool.waitForElement(driver, companyNameErrorMessage);
		pageManager.common().scrolltoViewElement(companyNameErrorMessage, driver);
		return companyNameErrorMessage.isDisplayed();
	}
	
}

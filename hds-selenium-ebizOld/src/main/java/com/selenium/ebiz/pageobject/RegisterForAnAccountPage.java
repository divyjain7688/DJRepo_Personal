package com.selenium.ebiz.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.selenium.ebiz.baseclass.BaseClass;
import com.selenium.ebiz.tools.CommonFunctions;

public class RegisterForAnAccountPage extends BaseClass
{
	String str = "abcd";
	public RegisterForAnAccountPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.visibilityOf((brandNewUserToHDSupplyRadioButton)));
	}

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
	
	@FindBy(xpath = "//div[@class='cust-profile__field-item']//input[@name='orgName']/../span") 
	WebElement companyNameMandatory;
	
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

	public void clickOnBrandNewUSerToHDSupply()
	{

		CommonFunctions.scrolltoViewElement(brandNewUserToHDSupplyRadioButton, driver);
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
		String random = CommonFunctions.getRandomNumber();
		comprop = comprop+ random;
		System.out.println("compropName is "+ comprop);
		companyName.sendKeys(comprop);
	}


	public void insertValueInFirstName(String fName)
	{
		firstName.clear();
		String random = CommonFunctions.getRandomNumber();
		fName = fName+ random;
		System.out.println("fName is "+ fName);
		firstName.sendKeys(fName);
	}

	public void insertValueInLastName(String lname)
	{
		lastName.clear();
		String random = CommonFunctions.getRandomNumber();
		lname = lname+ random;
		System.out.println("lname is "+ lname);
		lastName.sendKeys(lname);
	}

	public void insertValueInPhoneNumber()
	{
		phoneNumber.clear();
		String random1 = CommonFunctions.getRandomNumber();
		String random2 = CommonFunctions.getRandomNumber();
		String pnumber = "98"+ random1+random2;
		System.out.println("pnumber is "+ pnumber);
		phoneNumber.sendKeys(pnumber);
	}
	
	
	public void insertValueInFaxNumber()
	{
		faxNumber.clear();
		String random1 = CommonFunctions.getRandomNumber();
		String random2 = CommonFunctions.getRandomNumber();
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
		String random = CommonFunctions.getRandomNumber();
		System.out.println("random is "+ random);
		numberOf.sendKeys(random);
	}
	
	public void insertInvalidValueInNumberOf()
	{
		numberOf.clear();
		System.out.println("str is "+ str);
		numberOf.sendKeys(str);
	}


	public void clickOnNextButton1()
	{
		CommonFunctions.scrolltoViewElement(nextButton2, driver);
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
		String random = CommonFunctions.getRandomNumber();
		comprop = comprop+ random;
		System.out.println("comprop is "+ comprop);
		propertyName.sendKeys(comprop);
	}

	public void insertValueInAttentionOf()
	{
		attentionOf.clear();
		String random = CommonFunctions.getRandomNumber();
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
		String random = CommonFunctions.getRandomNumber();
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
		CommonFunctions.scrolltoViewElement(nextButton2, driver);
		nextButton2.click();
	}

	public String insertValueInEmailAddress(String name)
	{
		emailAddress.clear();
		String random = CommonFunctions.getRandomNumber();
		String email = name+ random+"@gmail.com";
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


	public void insertValueInUsername(String uname)
	{
		userName.clear();
		String random = CommonFunctions.getRandomNumber();
		uname = uname+ random;
		System.out.println("uname is "+ uname);
		userName.sendKeys(uname);
	}

	public void insertValueInPassword(String pwd)
	{
		password.clear();
		System.out.println("pwd is "+ pwd);
		password.sendKeys(pwd);
	}

	public void clickOnSubmit()
	{
		CommonFunctions.scrolltoViewElement(submitButton, driver);
		submitButton.click();
	}

	public Boolean isThankyouForRegistrationDisplayed() 
	{
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
		CommonFunctions.scrolltoViewElement(hDSupplyLogoInHeader, driver);
		hDSupplyLogoInHeader.click();
		return new HomePage(driver);
	}
}

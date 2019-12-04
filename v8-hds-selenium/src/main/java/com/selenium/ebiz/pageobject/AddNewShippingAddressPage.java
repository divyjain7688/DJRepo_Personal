package com.selenium.ebiz.pageobject;

import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.WaitTool;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewShippingAddressPage {

	private WebDriver driver;
	private WaitTool waitTool;
	private PageManager pageManager;

	public AddNewShippingAddressPage(WebDriver driver) {
		this.driver = driver;
		this.waitTool = new WaitTool();
		this.pageManager = new PageManager(driver);
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//form[@id='AddressForm']//button[contains(text(),'Add')]")
	WebElement addButton;

	@FindBy(xpath = "//form[@id='AddressForm']//input[@name='nickName']")
	WebElement shippingAddressNameEdit;

	@FindBy(xpath = "//form[@id='AddressForm']//input[@name='organizationName']")
	WebElement companyOrPropertyNameEdit;

	@FindBy(xpath = "//form[@id='AddressForm']//input[@name='addressField1']")
	WebElement attentionOfEdit;

	@FindBy(xpath = "//form[@id='AddressForm']//input[@class='lookup-add']")
	WebElement lookupAddressEdit;

	@FindBy(xpath = "//form[@id='AddressForm']//input[@name='address2']")
	WebElement addressEdit;

	@FindBy(xpath = "//form[@id='AddressForm']//input[@name='address1']")
	WebElement floorOrSuiteEdit;

	@FindBy(xpath = "//form[@id='AddressForm']//input[@name='city']")
	WebElement cityEdit;

	@FindBy(xpath = "//form[@id='AddressForm']//select[@name='state']")
	WebElement stateDropdown;

	@FindBy(xpath = "//form[@id='AddressForm']//input[@name='zipCode']")
	WebElement zipcodeEdit;

	@FindBy(xpath = "//form[@id='AddressForm']//input[@name='phone1']")
	WebElement phoneNumberEdit;

	// @FindBy(id = "error")
	@FindBy(xpath = "//div[@class='new-address__tabs']//div[@class='input_error']")
	WebElement errorMessage;

	/**
	 * Enter Shipping Address name
	 * 
	 * @param Shipping address name
	 */
	/*
	 * public void enterShippingAddressName(String shippingAddressName){
	 * shippingAddressNameEdit.sendKeys(shippingAddressName); }
	 */

	/**
	 * Enter company or Property name
	 * 
	 * @param company or Property name
	 */
	/*
	 * public void enterCompanyOrPropertyName(String companyOrPropertyName){
	 * companyOrPropertyNameEdit.sendKeys(companyOrPropertyName); }
	 */

	/**
	 * Enter attention Of
	 */
	public void enterAttentionOf(String attentionOf) {
		attentionOfEdit.sendKeys(attentionOf);
	}

	/**
	 * Enter lookup address
	 */
	public void enterLookupAddress(String lookupAddress) {
		lookupAddressEdit.sendKeys(lookupAddress);
	}

	/**
	 * Enter address
	 * 
	 * @param address
	 */
	public void enterAddress(String address) {
		addressEdit.sendKeys(address);
	}

	/**
	 * Enter Floor or suite
	 *
	 */
	public void enterFloorOrSuite(String floorOrSuite) {
		floorOrSuiteEdit.sendKeys(floorOrSuite);
	}

	/**
	 * Enter City
	 * 
	 * @param city
	 */
	public void enterCity(String city) {
		cityEdit.sendKeys(city);
	}

	/**
	 * Enter State
	 * 
	 * @param state
	 */
	public void enterState(String state) {
		pageManager.common().selectByVisibleTextFromDropdown(stateDropdown, state);
	}

	/**
	 * Enter zip code
	 * 
	 * @param zipcode
	 */
	public void enterZipcode(String zipcode) {
		zipcodeEdit.sendKeys(zipcode);
	}

	/**
	 * Enter Phone number
	 *
	 */
	public void enterPhoneNumber(String phoneNum) {
		phoneNumberEdit.sendKeys(phoneNum);
	}

	/**
	 * Click Add button
	 */
	public void clickAddButton() {
		addButton.click();
		waitTool.waitFor(driver, true);
	}

	/**
	 * @return true if error message displayed for mandatory validation otherwise
	 *         false
	 */
	public boolean isDisplayedErrorMessage() {
		System.out.println(errorMessage.getText());
		return errorMessage.isDisplayed();
	}

	/**
	 * Method to Add new shipping address - Enter data in all fields and click Add
	 * button
	 * 
	 * @param shippingAddressName
	 * @param companyOrPropertyName
	 * @param attentionOf
	 * @param lookupAddress
	 * @param address
	 * @param flooreOrSuite
	 * @param city
	 * @param state
	 * @param zipCode
	 * @param phoneNumber
	 * @throws Exception
	 */
	/*
	 * public void addNewShippingAddress(String shippingAddressName, String
	 * companyOrPropertyName, String attentionOf, String lookupAddress, String
	 * address, String flooreOrSuite, String city, String state, String zipCode,
	 * String phoneNumber) throws Exception{
	 * enterShippingAddressName(shippingAddressName);
	 * enterCompanyOrPropertyName(companyOrPropertyName);
	 * enterAttentionOf(attentionOf); enterLookupAddress(lookupAddress);
	 * enterAddress(address); enterFloorOrSuite(flooreOrSuite); enterCity(city);
	 * enterState(state); enterZipcode(zipCode); enterPhoneNumber(phoneNumber);
	 * waitTool.hardWait(); clickAddButton();
	 * 
	 * }
	 */
}

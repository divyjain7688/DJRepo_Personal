package com.selenium.ebiz.account_management.registration;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.tools.PageManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class CreateNewRegistrationGuest extends BaseClassV8_ParallelGrid{

	private ArrayList<UsersListBean> usersList;
//disabled test cases because they are failing when clicking on shopping cart button and giving stale reference element exception
	/**
	 ALM TestId - 657789 - [1]Create_New_Registration_Guest
	 author - Divy Jain

	 FYI: the issue when you register new user with new account, a new accoutn is registered in sap and sold to is assigned.
	 In qa2 some times the sold to assigned is already existing in qa2 DB and hence failing intermittently.
	 This is a lower env specific issue. Devops should check with SAP team to see if all keys have been updated post db refresh
	 */
	@Test(description="verify Manadatory Sign On Register Page",dataProvider = "browsers")
	public void reg_verifyMandatorySignOnRegisterPage(String browser, String version, String os, Method method) throws Exception
	{
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.loginPage().navigateToShopAllFromPopUpWindow();
		usersList = pageManager.dBCon().loadDataFromExcel("searchByKeywordOrPartNumber","Search");
		pageManager.homePage().searchKeywordOrPartNumber(usersList.get(0).getSearchProductPartNumber());
		Log.info("Search product number from list" + usersList.get(0).getSearchProductPartNumber());
		//pageManager.productDetailsPage().addToCartPDP();/*clickAddToCartButton();*/
		pageManager.productDetailsPage().clickAddToCartButton();
		pageManager.homePage().clickOnShoppingCartIcon();
		pageManager.shoppingCartPage().clickonCheckOutButton();
		pageManager.signInOrRegisterPage().clickOnRegisterButton();
		pageManager.registerForAnAccountPage().clickOnBrandNewUSerToHDSupply();
		Assert.assertTrue(pageManager.registerForAnAccountPage().companyNameMandatory.isDisplayed());
		Assert.assertTrue(pageManager.registerForAnAccountPage().firstNameMandatory.isDisplayed());
		Assert.assertTrue(pageManager.registerForAnAccountPage().lastNameMandatory.isDisplayed());
		Assert.assertTrue(pageManager.registerForAnAccountPage().phoneNumberMandatory.isDisplayed());
		Assert.assertTrue(pageManager.registerForAnAccountPage().industryMandatory.isDisplayed());
		Assert.assertTrue(pageManager.registerForAnAccountPage().selectTypeOfBusinessMandatory.isDisplayed());
		Assert.assertTrue(pageManager.registerForAnAccountPage().numberOfMandatory.isDisplayed());
	}

	/**
	 ALM TestId - 657789 - [1]Create_New_Registration_Guest
	 author - Divy Jain
	 */
	@Test(description="verify Special Character Error Message On Company Name",dataProvider = "browsers")
	public void reg_verifySpecialCharErrorMessageOnCompanyName(String browser, String version, String os, Method method) throws Exception
	{
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.loginPage().navigateToShopAllFromPopUpWindow();
		usersList = pageManager.dBCon().loadDataFromExcel("searchByKeywordOrPartNumber","Search");
		pageManager.homePage().searchKeywordOrPartNumber(usersList.get(0).getSearchProductPartNumber());
		Log.info("Search product number from list" + usersList.get(0).getSearchProductPartNumber());
		//pageManager.productDetailsPage().addToCartPDP();/*clickAddToCartButton();*/
		pageManager.productDetailsPage().clickAddToCartButton();
		pageManager.homePage().clickOnShoppingCartIcon();
		pageManager.shoppingCartPage().clickonCheckOutButton();
		pageManager.signInOrRegisterPage().clickOnRegisterButton();
		pageManager.registerForAnAccountPage().clickOnBrandNewUSerToHDSupply();
		pageManager.registerForAnAccountPage().fillCustomerDetails("RegistrationDataForIncorrectCompanyNameErrorMessage","Registration");		
		pageManager.registerForAnAccountPage().clickOnNextButton1();
		Assert.assertTrue(pageManager.registerForAnAccountPage().isCompanyNameErrorMessageDisplayed());
	}
	
	/**
	 ALM TestId - 657789 - [1]Create_New_Registration_Guest
	 author - Divy Jain
	 */
	@Test(description="verify Special Character Error Message On First Name",dataProvider = "browsers")
	public void reg_verifySpecialCharErrorMessageOnFirstName(String browser, String version, String os, Method method) throws Exception
	{
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.loginPage().navigateToShopAllFromPopUpWindow();
		usersList = pageManager.dBCon().loadDataFromExcel("searchByKeywordOrPartNumber","Search");
		pageManager.homePage().searchKeywordOrPartNumber(usersList.get(0).getSearchProductPartNumber());
		Log.info("Search product number from list" + usersList.get(0).getSearchProductPartNumber());
		//pageManager.productDetailsPage().addToCartPDP();/*clickAddToCartButton();*/
		pageManager.productDetailsPage().clickAddToCartButton();
		pageManager.homePage().clickOnShoppingCartIcon();
		pageManager.shoppingCartPage().clickonCheckOutButton();
		pageManager.signInOrRegisterPage().clickOnRegisterButton();
		pageManager.registerForAnAccountPage().clickOnBrandNewUSerToHDSupply();
		pageManager.registerForAnAccountPage().fillCustomerDetails("RegistrationDataForIncorrectFirstErrorMessage","Registration");		
		pageManager.registerForAnAccountPage().clickOnNextButton1();
		Assert.assertTrue(pageManager.registerForAnAccountPage().isFirstNameErrorMessageDisplayed());
	}

	/**
	 ALM TestId - 657789 - [1]Create_New_Registration_Guest
	 author - Divy Jain
	 */
	@Test(description="verify Special Character Error Message On Last Name",dataProvider = "browsers")
	public void reg_verifySpecialCharErrorMessageOnLastName(String browser, String version, String os, Method method) throws Exception
	{
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.loginPage().navigateToShopAllFromPopUpWindow();
		usersList = pageManager.dBCon().loadDataFromExcel("searchByKeywordOrPartNumber","Search");
		pageManager.homePage().searchKeywordOrPartNumber(usersList.get(0).getSearchProductPartNumber());
		Log.info("Search product number from list" + usersList.get(0).getSearchProductPartNumber());
		//pageManager.productDetailsPage().addToCartPDP();/*clickAddToCartButton();*/
		pageManager.productDetailsPage().clickAddToCartButton();
		pageManager.homePage().clickOnShoppingCartIcon();
		pageManager.shoppingCartPage().clickonCheckOutButton();
		pageManager.signInOrRegisterPage().clickOnRegisterButton();
		pageManager.registerForAnAccountPage().clickOnBrandNewUSerToHDSupply();
		pageManager.registerForAnAccountPage().fillCustomerDetails("RegistrationDataForIncorrectLastErrorMessage","Registration");		
		pageManager.registerForAnAccountPage().clickOnNextButton1();
		Assert.assertTrue(pageManager.registerForAnAccountPage().isLastNameErrorMessageDisplayed());
	}

	/**
	 ALM TestId - 657789 - [1]Create_New_Registration_Guest
	 author - Divy Jain
	 */
	@Test(description="verify Special Character Error Message On Number Of",dataProvider = "browsers")
	public void reg_verifySpecialCharErrorMessageOnNumberOf(String browser, String version, String os, Method method) throws Exception
	{
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.loginPage().navigateToShopAllFromPopUpWindow();
		usersList = pageManager.dBCon().loadDataFromExcel("searchByKeywordOrPartNumber","Search");
		pageManager.homePage().searchKeywordOrPartNumber(usersList.get(0).getSearchProductPartNumber());
		Log.info("Search product number from list" + usersList.get(0).getSearchProductPartNumber());
		//pageManager.productDetailsPage().addToCartPDP();/*clickAddToCartButton();*/
		pageManager.productDetailsPage().clickAddToCartButton();
		pageManager.homePage().clickOnShoppingCartIcon();
		pageManager.shoppingCartPage().clickonCheckOutButton();
		pageManager.signInOrRegisterPage().clickOnRegisterButton();
		pageManager.registerForAnAccountPage().clickOnBrandNewUSerToHDSupply();
		pageManager.registerForAnAccountPage().fillCustomerDetails("RegistrationDataForIncorrectNumberOfErrorMessage","Registration");	
		pageManager.registerForAnAccountPage().clickOnNextButton1();
		Assert.assertTrue(pageManager.registerForAnAccountPage().isNumberOfErrorMessageDisplayed());
	}

	/**
	 ALM TestId - 657789 - [1]Create_New_Registration_Guest
	 author - Divy Jain
	 */
	@Test(description="verify Default Shipping Information",dataProvider = "browsers")
	public void reg_verifyDefaultShippingInformation(String browser, String version, String os, Method method) throws Exception
	{
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.loginPage().navigateToShopAllFromPopUpWindow();
		usersList = pageManager.dBCon().loadDataFromExcel("searchByKeywordOrPartNumber","Search");
		pageManager.homePage().searchKeywordOrPartNumber(usersList.get(0).getSearchProductPartNumber());
		Log.info("Search product number from list" + usersList.get(0).getSearchProductPartNumber());
		//pageManager.productDetailsPage().addToCartPDP();/*clickAddToCartButton();*/
		pageManager.productDetailsPage().clickAddToCartButton();
		pageManager.homePage().clickOnShoppingCartIcon();
		pageManager.shoppingCartPage().clickonCheckOutButton();
		pageManager.signInOrRegisterPage().clickOnRegisterButton();
		pageManager.registerForAnAccountPage().clickOnBrandNewUSerToHDSupply();
		pageManager.registerForAnAccountPage().fillCustomerDetails("RegistrationforNewUser","Registration");			
		pageManager.registerForAnAccountPage().clickOnNextButton1();
		Assert.assertTrue(pageManager.registerForAnAccountPage().isDefaultShippingMessage1Displayed());
		Assert.assertTrue(pageManager.registerForAnAccountPage().isDefaultShippingMessage2Displayed());
		Assert.assertTrue(pageManager.registerForAnAccountPage().isDefaultShippingMessage3Displayed());
	}

	/**
	 ALM TestId - 657789 - [1]Create_New_Registration_Guest
	 author - Divy Jain
	 */
	@Test(description="verify Special Character Error Message On Address",dataProvider = "browsers")
	public void reg_verifySpecialCharErrorMessageOnAddress(String browser, String version, String os, Method method) throws Exception
	{
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.loginPage().navigateToShopAllFromPopUpWindow();
		usersList = pageManager.dBCon().loadDataFromExcel("searchByKeywordOrPartNumber","Search");
		pageManager.homePage().searchKeywordOrPartNumber(usersList.get(0).getSearchProductPartNumber());
		Log.info("Search product number from list" + usersList.get(0).getSearchProductPartNumber());
		//pageManager.productDetailsPage().addToCartPDP();/*clickAddToCartButton();*/
		pageManager.productDetailsPage().clickAddToCartButton();
		pageManager.homePage().clickOnShoppingCartIcon();
		pageManager.shoppingCartPage().clickonCheckOutButton();
		pageManager.signInOrRegisterPage().clickOnRegisterButton();
		pageManager.registerForAnAccountPage().clickOnBrandNewUSerToHDSupply();
		pageManager.registerForAnAccountPage().fillCustomerAndAddressDetails("RegistrationDataforIncorrectAddressErrorMessage","Registration");			
		pageManager.registerForAnAccountPage().clickOnNextButton2();
		Assert.assertTrue(pageManager.registerForAnAccountPage().isAddressErrorMessageDisplayed());
	}
	
	/**
	 ALM TestId - 657789 - [1]Create_New_Registration_Guest
	 author - Divy Jain
	 */
	@Test(dataProvider = "browsers", enabled = false)
	public void reg_verifyErrorMessageOnPassword(String browser, String version, String os, Method method) throws Exception
	{
		/*09/09/2019 : Divy Jain - Earlier application was accepting ?password, so replaced it with ?pass and got the expected error message.*/
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.loginPage().navigateToShopAllFromPopUpWindow();
		usersList = pageManager.dBCon().loadDataFromExcel("searchByKeywordOrPartNumber","Search");
		pageManager.homePage().searchKeywordOrPartNumber(usersList.get(0).getSearchProductPartNumber());
		Log.info("Search product number from list" + usersList.get(0).getSearchProductPartNumber());
		//pageManager.productDetailsPage().addToCartPDP();/*clickAddToCartButton();*/
		pageManager.productDetailsPage().clickAddToCartButton();
		pageManager.homePage().clickOnShoppingCartIcon();
		pageManager.shoppingCartPage().clickonCheckOutButton();
		pageManager.signInOrRegisterPage().clickOnRegisterButton();
		pageManager.registerForAnAccountPage().clickOnBrandNewUSerToHDSupply();
		pageManager.registerForAnAccountPage().fillCustomerAddressAndLoginDetails("RegistrationDataforIncorrectPasswordErrorMessage","Registration");	
		Assert.assertTrue(pageManager.registerForAnAccountPage().isPasswordErrorMessageDisplayed());

	}

	/**
	 ALM TestId - 657789 - [1]Create_New_Registration_Guest
	 author - Divy Jain
	 */
	//Divy Jain - Executed 10 times in local and remote . Did not notice any issue.
	@Test(dataProvider = "browsers", enabled = true)
	public void reg_verifyRegistration(String browser, String version, String os, Method method) throws Exception
	{
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.loginPage().navigateToShopAllFromPopUpWindow();
		usersList = pageManager.dBCon().loadDataFromExcel("searchByKeywordOrPartNumber","Search");
		pageManager.homePage().searchKeywordOrPartNumber(usersList.get(0).getSearchProductPartNumber());
		Log.info("Search product number from list" + usersList.get(0).getSearchProductPartNumber());
		//pageManager.productDetailsPage().addToCartPDP();/*clickAddToCartButton();*/
		pageManager.productDetailsPage().clickAddToCartButton();
		pageManager.homePage().clickOnShoppingCartIcon();
		pageManager.shoppingCartPage().clickonCheckOutButton();
		pageManager.signInOrRegisterPage().clickOnRegisterButton();
		pageManager.registerForAnAccountPage().clickOnBrandNewUSerToHDSupply();
		pageManager.registerForAnAccountPage().fillCustomerAddressAndLoginDetails("RegistrationCorrectData", "Registration");
		Assert.assertTrue(pageManager.registerForAnAccountPage().isThankyouForRegistrationDisplayed());

	}
}

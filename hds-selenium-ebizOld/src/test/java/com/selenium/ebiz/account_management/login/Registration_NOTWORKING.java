package com.selenium.ebiz.account_management.login;

import java.net.MalformedURLException;
import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.selenium.ebiz.baseclass.BaseClass;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.dbcon.DBCon;
import com.selenium.ebiz.pageobject.HomePage;
import com.selenium.ebiz.pageobject.LoginPage;
import com.selenium.ebiz.pageobject.ProductDetailsPage;
import com.selenium.ebiz.pageobject.ProductListingPage;
import com.selenium.ebiz.pageobject.RegisterForAnAccountPage;
import com.selenium.ebiz.pageobject.SearchPage;
import com.selenium.ebiz.pageobject.ShoppingCartPage;
import com.selenium.ebiz.pageobject.SignInOrRegisterPage;
import com.selenium.ebiz.tools.WaitTool;

public class Registration_NOTWORKING extends BaseClass{
	ArrayList<UsersListBean> usersList;
	DBCon dbConnection = new DBCon();
	LoginPage loginPage;
	HomePage homePage;
	SignInOrRegisterPage signInOrRegisterPage;
	SearchPage searchPage;
	ProductDetailsPage productDetailsPage;
	ProductListingPage productListingPage;
	ShoppingCartPage shoppingCartPage;
	RegisterForAnAccountPage registerForAnAccountPage;

	String numberOfSeats = "Number of Seats";
	String numberOfUnits = "Number of Units";
	String numberOfUnit = "Number of Unit";
	String numberOfRooms = "Number of Rooms";
	String numberOfSpaces = "Number of Spaces";
	String numberOfEmployees = "Number of Employees";
	String numberOfBeds = "Number of Beds";
	String numberOfSqFt = "Number of Sq Ft";

	@BeforeMethod
	public void driverSetup() throws MalformedURLException {
		driver = initialize();
		loginPage = new LoginPage(driver);

	}

	/**
	 * 118409 - Verify company type and unit of measurement
	 */
	@Test(priority=1)
	public void verifyCompanyTypeAndUnitOfMeasurement() throws Exception 
	{	
		loginPage.clickOnRegisterOrSignIn();
		registerForAnAccountPage = loginPage.clickOnRegisterForAnAccountButton();
		registerForAnAccountPage.clickOnBrandNewUSerToHDSupply();
		usersList = dbConnection.loadDataFromExcel("MultiFamilyHousing_SingleMultiFamilyHousing","RegistrationIndustryTypeOfBuss");
		registerForAnAccountPage.selectIndustryFromDropdown(usersList.get(0).getIndustry());
		registerForAnAccountPage.selectTypeOfBusinessFromDropdown(usersList.get(0).getTypeofBusiness());
		Assert.assertEquals(registerForAnAccountPage.NumberOfTextDisplayed(), numberOfUnits);

		usersList = dbConnection.loadDataFromExcel("MultiFamilyHousing_MobileHomeParks","RegistrationIndustryTypeOfBuss");
		registerForAnAccountPage.selectIndustryFromDropdown(usersList.get(0).getIndustry());
		registerForAnAccountPage.selectTypeOfBusinessFromDropdown(usersList.get(0).getTypeofBusiness());
		Assert.assertEquals(registerForAnAccountPage.NumberOfTextDisplayed(), numberOfUnits);

		usersList = dbConnection.loadDataFromExcel("MultiFamilyHousing_OwnersAssociation","RegistrationIndustryTypeOfBuss");
		registerForAnAccountPage.selectIndustryFromDropdown(usersList.get(0).getIndustry());
		registerForAnAccountPage.selectTypeOfBusinessFromDropdown(usersList.get(0).getTypeofBusiness());
		Assert.assertEquals(registerForAnAccountPage.NumberOfTextDisplayed(), numberOfUnits);

		usersList = dbConnection.loadDataFromExcel("MultiFamilyHousing_PrivateStudentApts","RegistrationIndustryTypeOfBuss");
		registerForAnAccountPage.selectIndustryFromDropdown(usersList.get(0).getIndustry());
		registerForAnAccountPage.selectTypeOfBusinessFromDropdown(usersList.get(0).getTypeofBusiness());
		Assert.assertEquals(registerForAnAccountPage.NumberOfTextDisplayed(), numberOfUnits);

		usersList = dbConnection.loadDataFromExcel("Hospitality_Restaurants","RegistrationIndustryTypeOfBuss");
		registerForAnAccountPage.selectIndustryFromDropdown(usersList.get(0).getIndustry());
		registerForAnAccountPage.selectTypeOfBusinessFromDropdown(usersList.get(0).getTypeofBusiness());
		Assert.assertEquals(registerForAnAccountPage.NumberOfTextDisplayed(), numberOfSeats);

		usersList = dbConnection.loadDataFromExcel("Hospitality_LodgingRestaurants","RegistrationIndustryTypeOfBuss");
		registerForAnAccountPage.selectIndustryFromDropdown(usersList.get(0).getIndustry());
		registerForAnAccountPage.selectTypeOfBusinessFromDropdown(usersList.get(0).getTypeofBusiness());
		Assert.assertEquals(registerForAnAccountPage.NumberOfTextDisplayed(), numberOfSeats);

		usersList = dbConnection.loadDataFromExcel("Hospitality_LodgingHotel/Motel","RegistrationIndustryTypeOfBuss");
		registerForAnAccountPage.selectIndustryFromDropdown(usersList.get(0).getIndustry());
		registerForAnAccountPage.selectTypeOfBusinessFromDropdown(usersList.get(0).getTypeofBusiness());
		Assert.assertEquals(registerForAnAccountPage.NumberOfTextDisplayed(), numberOfRooms);

		usersList = dbConnection.loadDataFromExcel("Hospitality_RVPark/Campgrounds","RegistrationIndustryTypeOfBuss");
		registerForAnAccountPage.selectIndustryFromDropdown(usersList.get(0).getIndustry());
		registerForAnAccountPage.selectTypeOfBusinessFromDropdown(usersList.get(0).getTypeofBusiness());
		Assert.assertEquals(registerForAnAccountPage.NumberOfTextDisplayed(), numberOfSpaces);

		usersList = dbConnection.loadDataFromExcel("Hospitality_TimeShare/Vacationrental","RegistrationIndustryTypeOfBuss");
		registerForAnAccountPage.selectIndustryFromDropdown(usersList.get(0).getIndustry());
		registerForAnAccountPage.selectTypeOfBusinessFromDropdown(usersList.get(0).getTypeofBusiness());
		Assert.assertEquals(registerForAnAccountPage.NumberOfTextDisplayed(), numberOfUnits);

		usersList = dbConnection.loadDataFromExcel("Hospitality_GolfCourse/CountryClub","RegistrationIndustryTypeOfBuss");
		registerForAnAccountPage.selectIndustryFromDropdown(usersList.get(0).getIndustry());
		registerForAnAccountPage.selectTypeOfBusinessFromDropdown(usersList.get(0).getTypeofBusiness());
		Assert.assertEquals(registerForAnAccountPage.NumberOfTextDisplayed(), numberOfUnits);

		usersList = dbConnection.loadDataFromExcel("Healthcare_Assistedliving","RegistrationIndustryTypeOfBuss");
		registerForAnAccountPage.selectIndustryFromDropdown(usersList.get(0).getIndustry());
		registerForAnAccountPage.selectTypeOfBusinessFromDropdown(usersList.get(0).getTypeofBusiness());
		Assert.assertEquals(registerForAnAccountPage.NumberOfTextDisplayed(), numberOfBeds);

		usersList = dbConnection.loadDataFromExcel("Healthcare_IndependentLiving","RegistrationIndustryTypeOfBuss");
		registerForAnAccountPage.selectIndustryFromDropdown(usersList.get(0).getIndustry());
		registerForAnAccountPage.selectTypeOfBusinessFromDropdown(usersList.get(0).getTypeofBusiness());
		Assert.assertEquals(registerForAnAccountPage.NumberOfTextDisplayed(), numberOfUnits);

		usersList = dbConnection.loadDataFromExcel("Healthcare_SkilledNursing","RegistrationIndustryTypeOfBuss");
		registerForAnAccountPage.selectIndustryFromDropdown(usersList.get(0).getIndustry());
		registerForAnAccountPage.selectTypeOfBusinessFromDropdown(usersList.get(0).getTypeofBusiness());
		Assert.assertEquals(registerForAnAccountPage.NumberOfTextDisplayed(), numberOfBeds);

		usersList = dbConnection.loadDataFromExcel("Healthcare_HealthcareFacility","RegistrationIndustryTypeOfBuss");
		registerForAnAccountPage.selectIndustryFromDropdown(usersList.get(0).getIndustry());
		registerForAnAccountPage.selectTypeOfBusinessFromDropdown(usersList.get(0).getTypeofBusiness());
		Assert.assertEquals(registerForAnAccountPage.NumberOfTextDisplayed(), numberOfUnit);

		usersList = dbConnection.loadDataFromExcel("Healthcare_Hospitals","RegistrationIndustryTypeOfBuss");
		registerForAnAccountPage.selectIndustryFromDropdown(usersList.get(0).getIndustry());
		registerForAnAccountPage.selectTypeOfBusinessFromDropdown(usersList.get(0).getTypeofBusiness());
		Assert.assertEquals(registerForAnAccountPage.NumberOfTextDisplayed(), numberOfBeds);

		usersList = dbConnection.loadDataFromExcel("Healthcare_Practitioner","RegistrationIndustryTypeOfBuss");
		registerForAnAccountPage.selectIndustryFromDropdown(usersList.get(0).getIndustry());
		registerForAnAccountPage.selectTypeOfBusinessFromDropdown(usersList.get(0).getTypeofBusiness());
		Assert.assertEquals(registerForAnAccountPage.NumberOfTextDisplayed(), numberOfUnit);

		usersList = dbConnection.loadDataFromExcel("Healthcare_ConstructionHealthcare","RegistrationIndustryTypeOfBuss");
		registerForAnAccountPage.selectIndustryFromDropdown(usersList.get(0).getIndustry());
		registerForAnAccountPage.selectTypeOfBusinessFromDropdown(usersList.get(0).getTypeofBusiness());
		Assert.assertEquals(registerForAnAccountPage.NumberOfTextDisplayed(), numberOfEmployees);

		usersList = dbConnection.loadDataFromExcel("GovernmentFederal_DoDorCivilianAgency","RegistrationIndustryTypeOfBuss");
		registerForAnAccountPage.selectIndustryFromDropdown(usersList.get(0).getIndustry());
		registerForAnAccountPage.selectTypeOfBusinessFromDropdown(usersList.get(0).getTypeofBusiness());
		Assert.assertEquals(registerForAnAccountPage.NumberOfTextDisplayed(), numberOfUnits);

		usersList = dbConnection.loadDataFromExcel("GovernmentFederal_MilitaryLodging/TempHousing","RegistrationIndustryTypeOfBuss");
		registerForAnAccountPage.selectIndustryFromDropdown(usersList.get(0).getIndustry());
		registerForAnAccountPage.selectTypeOfBusinessFromDropdown(usersList.get(0).getTypeofBusiness());
		Assert.assertEquals(registerForAnAccountPage.NumberOfTextDisplayed(), numberOfRooms);

		usersList = dbConnection.loadDataFromExcel("GovernmentFederal_Prison/CorrectionalFacility","RegistrationIndustryTypeOfBuss");
		registerForAnAccountPage.selectIndustryFromDropdown(usersList.get(0).getIndustry());
		registerForAnAccountPage.selectTypeOfBusinessFromDropdown(usersList.get(0).getTypeofBusiness());
		Assert.assertEquals(registerForAnAccountPage.NumberOfTextDisplayed(), numberOfBeds);

		usersList = dbConnection.loadDataFromExcel("GovernmentFederal_MedicalFacility","RegistrationIndustryTypeOfBuss");
		registerForAnAccountPage.selectIndustryFromDropdown(usersList.get(0).getIndustry());
		registerForAnAccountPage.selectTypeOfBusinessFromDropdown(usersList.get(0).getTypeofBusiness());
		Assert.assertEquals(registerForAnAccountPage.NumberOfTextDisplayed(), numberOfBeds);

		usersList = dbConnection.loadDataFromExcel("GovernmentState/Local_State/County/CityGovernmentAgency","RegistrationIndustryTypeOfBuss");
		registerForAnAccountPage.selectIndustryFromDropdown(usersList.get(0).getIndustry());
		registerForAnAccountPage.selectTypeOfBusinessFromDropdown(usersList.get(0).getTypeofBusiness());
		Assert.assertEquals(registerForAnAccountPage.NumberOfTextDisplayed(), numberOfUnits);

		usersList = dbConnection.loadDataFromExcel("GovernmentState/Local_HousingAuthority","RegistrationIndustryTypeOfBuss");
		registerForAnAccountPage.selectIndustryFromDropdown(usersList.get(0).getIndustry());
		registerForAnAccountPage.selectTypeOfBusinessFromDropdown(usersList.get(0).getTypeofBusiness());
		Assert.assertEquals(registerForAnAccountPage.NumberOfTextDisplayed(), numberOfUnits);

		usersList = dbConnection.loadDataFromExcel("GovernmentState/Local_Prison/CorrectionalFacility","RegistrationIndustryTypeOfBuss");
		registerForAnAccountPage.selectIndustryFromDropdown(usersList.get(0).getIndustry());
		registerForAnAccountPage.selectTypeOfBusinessFromDropdown(usersList.get(0).getTypeofBusiness());
		Assert.assertEquals(registerForAnAccountPage.NumberOfTextDisplayed(), numberOfBeds);

		usersList = dbConnection.loadDataFromExcel("GovernmentState/Local_MedicalFacility","RegistrationIndustryTypeOfBuss");
		registerForAnAccountPage.selectIndustryFromDropdown(usersList.get(0).getIndustry());
		registerForAnAccountPage.selectTypeOfBusinessFromDropdown(usersList.get(0).getTypeofBusiness());
		Assert.assertEquals(registerForAnAccountPage.NumberOfTextDisplayed(), numberOfBeds);

		usersList = dbConnection.loadDataFromExcel("GovernmentContractorOrReseller_FederalGovernmentHousing","RegistrationIndustryTypeOfBuss");
		registerForAnAccountPage.selectIndustryFromDropdown(usersList.get(0).getIndustry());
		registerForAnAccountPage.selectTypeOfBusinessFromDropdown(usersList.get(0).getTypeofBusiness());
		Assert.assertEquals(registerForAnAccountPage.NumberOfTextDisplayed(), numberOfUnits);

		usersList = dbConnection.loadDataFromExcel("GovernmentContractorOrReseller_FederalGovernmentFacilities","RegistrationIndustryTypeOfBuss");
		registerForAnAccountPage.selectIndustryFromDropdown(usersList.get(0).getIndustry());
		registerForAnAccountPage.selectTypeOfBusinessFromDropdown(usersList.get(0).getTypeofBusiness());
		Assert.assertEquals(registerForAnAccountPage.NumberOfTextDisplayed(), numberOfUnits);

		usersList = dbConnection.loadDataFromExcel("GovernmentContractorOrReseller_GovernmentReseller","RegistrationIndustryTypeOfBuss");
		registerForAnAccountPage.selectIndustryFromDropdown(usersList.get(0).getIndustry());
		registerForAnAccountPage.selectTypeOfBusinessFromDropdown(usersList.get(0).getTypeofBusiness());
		Assert.assertEquals(registerForAnAccountPage.NumberOfTextDisplayed(), numberOfSqFt);

		usersList = dbConnection.loadDataFromExcel("GovernmentContractorOrReseller_SLEDContractor","RegistrationIndustryTypeOfBuss");
		registerForAnAccountPage.selectIndustryFromDropdown(usersList.get(0).getIndustry());
		registerForAnAccountPage.selectTypeOfBusinessFromDropdown(usersList.get(0).getTypeofBusiness());
		Assert.assertEquals(registerForAnAccountPage.NumberOfTextDisplayed(), numberOfSqFt);

		usersList = dbConnection.loadDataFromExcel("Education_University&CollegeHousing","RegistrationIndustryTypeOfBuss");
		registerForAnAccountPage.selectIndustryFromDropdown(usersList.get(0).getIndustry());
		registerForAnAccountPage.selectTypeOfBusinessFromDropdown(usersList.get(0).getTypeofBusiness());
		Assert.assertEquals(registerForAnAccountPage.NumberOfTextDisplayed(), numberOfBeds);

		usersList = dbConnection.loadDataFromExcel("Education_HigherEducationFacilities","RegistrationIndustryTypeOfBuss");
		registerForAnAccountPage.selectIndustryFromDropdown(usersList.get(0).getIndustry());
		registerForAnAccountPage.selectTypeOfBusinessFromDropdown(usersList.get(0).getTypeofBusiness());
		Assert.assertEquals(registerForAnAccountPage.NumberOfTextDisplayed(), numberOfUnits);

		usersList = dbConnection.loadDataFromExcel("Education_K12","RegistrationIndustryTypeOfBuss");
		registerForAnAccountPage.selectIndustryFromDropdown(usersList.get(0).getIndustry());
		registerForAnAccountPage.selectTypeOfBusinessFromDropdown(usersList.get(0).getTypeofBusiness());
		Assert.assertEquals(registerForAnAccountPage.NumberOfTextDisplayed(), numberOfUnits);

		usersList = dbConnection.loadDataFromExcel("FacilitiesOther_Retail/Resale","RegistrationIndustryTypeOfBuss");
		registerForAnAccountPage.selectIndustryFromDropdown(usersList.get(0).getIndustry());
		registerForAnAccountPage.selectTypeOfBusinessFromDropdown(usersList.get(0).getTypeofBusiness());
		Assert.assertEquals(registerForAnAccountPage.NumberOfTextDisplayed(), numberOfSqFt);

		usersList = dbConnection.loadDataFromExcel("FacilitiesOther_OtherFacility","RegistrationIndustryTypeOfBuss");
		registerForAnAccountPage.selectIndustryFromDropdown(usersList.get(0).getIndustry());
		registerForAnAccountPage.selectTypeOfBusinessFromDropdown(usersList.get(0).getTypeofBusiness());
		Assert.assertEquals(registerForAnAccountPage.NumberOfTextDisplayed(), numberOfUnits);

		usersList = dbConnection.loadDataFromExcel("FacilitiesOther_Liquidator","RegistrationIndustryTypeOfBuss");
		registerForAnAccountPage.selectIndustryFromDropdown(usersList.get(0).getIndustry());
		registerForAnAccountPage.selectTypeOfBusinessFromDropdown(usersList.get(0).getTypeofBusiness());
		Assert.assertEquals(registerForAnAccountPage.NumberOfTextDisplayed(), numberOfSqFt);

		usersList = dbConnection.loadDataFromExcel("FacilitiesOther_NonProfit","RegistrationIndustryTypeOfBuss");
		registerForAnAccountPage.selectIndustryFromDropdown(usersList.get(0).getIndustry());
		registerForAnAccountPage.selectTypeOfBusinessFromDropdown(usersList.get(0).getTypeofBusiness());
		Assert.assertEquals(registerForAnAccountPage.NumberOfTextDisplayed(), numberOfSqFt);

		usersList = dbConnection.loadDataFromExcel("Commercial_OfficeBuilding>4Stories","RegistrationIndustryTypeOfBuss");
		registerForAnAccountPage.selectIndustryFromDropdown(usersList.get(0).getIndustry());
		registerForAnAccountPage.selectTypeOfBusinessFromDropdown(usersList.get(0).getTypeofBusiness());
		Assert.assertEquals(registerForAnAccountPage.NumberOfTextDisplayed(), numberOfSqFt);

		usersList = dbConnection.loadDataFromExcel("Commercial_Maintenance","RegistrationIndustryTypeOfBuss");
		registerForAnAccountPage.selectIndustryFromDropdown(usersList.get(0).getIndustry());
		registerForAnAccountPage.selectTypeOfBusinessFromDropdown(usersList.get(0).getTypeofBusiness());
		Assert.assertEquals(registerForAnAccountPage.NumberOfTextDisplayed(), numberOfEmployees);

		usersList = dbConnection.loadDataFromExcel("Commercial_ContractorMaintenance","RegistrationIndustryTypeOfBuss");
		registerForAnAccountPage.selectIndustryFromDropdown(usersList.get(0).getIndustry());
		registerForAnAccountPage.selectTypeOfBusinessFromDropdown(usersList.get(0).getTypeofBusiness());
		Assert.assertEquals(registerForAnAccountPage.NumberOfTextDisplayed(), numberOfUnits);

		usersList = dbConnection.loadDataFromExcel("Commercial_Remodeler","RegistrationIndustryTypeOfBuss");
		registerForAnAccountPage.selectIndustryFromDropdown(usersList.get(0).getIndustry());
		registerForAnAccountPage.selectTypeOfBusinessFromDropdown(usersList.get(0).getTypeofBusiness());
		Assert.assertEquals(registerForAnAccountPage.NumberOfTextDisplayed(), numberOfEmployees);

		usersList = dbConnection.loadDataFromExcel("Commercial_ConstructionMultiFamilyHousing","RegistrationIndustryTypeOfBuss");
		registerForAnAccountPage.selectIndustryFromDropdown(usersList.get(0).getIndustry());
		registerForAnAccountPage.selectTypeOfBusinessFromDropdown(usersList.get(0).getTypeofBusiness());
		Assert.assertEquals(registerForAnAccountPage.NumberOfTextDisplayed(), numberOfEmployees);

		usersList = dbConnection.loadDataFromExcel("Commercial_ConstructionLodging","RegistrationIndustryTypeOfBuss");
		registerForAnAccountPage.selectIndustryFromDropdown(usersList.get(0).getIndustry());
		registerForAnAccountPage.selectTypeOfBusinessFromDropdown(usersList.get(0).getTypeofBusiness());
		Assert.assertEquals(registerForAnAccountPage.NumberOfTextDisplayed(), numberOfEmployees);

		usersList = dbConnection.loadDataFromExcel("Commercial_ConstructionCommercial","RegistrationIndustryTypeOfBuss");
		registerForAnAccountPage.selectIndustryFromDropdown(usersList.get(0).getIndustry());
		registerForAnAccountPage.selectTypeOfBusinessFromDropdown(usersList.get(0).getTypeofBusiness());
		Assert.assertEquals(registerForAnAccountPage.NumberOfTextDisplayed(), numberOfEmployees);

		usersList = dbConnection.loadDataFromExcel("Commercial_Mercantile","RegistrationIndustryTypeOfBuss");
		registerForAnAccountPage.selectIndustryFromDropdown(usersList.get(0).getIndustry());
		registerForAnAccountPage.selectTypeOfBusinessFromDropdown(usersList.get(0).getTypeofBusiness());
		Assert.assertEquals(registerForAnAccountPage.NumberOfTextDisplayed(), numberOfSqFt);

		usersList = dbConnection.loadDataFromExcel("Commercial_Service","RegistrationIndustryTypeOfBuss");
		registerForAnAccountPage.selectIndustryFromDropdown(usersList.get(0).getIndustry());
		registerForAnAccountPage.selectTypeOfBusinessFromDropdown(usersList.get(0).getTypeofBusiness());
		Assert.assertEquals(registerForAnAccountPage.NumberOfTextDisplayed(), numberOfSqFt);

		usersList = dbConnection.loadDataFromExcel("Commercial_PublicAssembly","RegistrationIndustryTypeOfBuss");
		registerForAnAccountPage.selectIndustryFromDropdown(usersList.get(0).getIndustry());
		registerForAnAccountPage.selectTypeOfBusinessFromDropdown(usersList.get(0).getTypeofBusiness());
		Assert.assertEquals(registerForAnAccountPage.NumberOfTextDisplayed(), numberOfSqFt);

		usersList = dbConnection.loadDataFromExcel("Commercial_StorageUnits/Warehouses","RegistrationIndustryTypeOfBuss");
		registerForAnAccountPage.selectIndustryFromDropdown(usersList.get(0).getIndustry());
		registerForAnAccountPage.selectTypeOfBusinessFromDropdown(usersList.get(0).getTypeofBusiness());
		Assert.assertEquals(registerForAnAccountPage.NumberOfTextDisplayed(), numberOfSqFt);

		usersList = dbConnection.loadDataFromExcel("Commercial_Reseller","RegistrationIndustryTypeOfBuss");
		registerForAnAccountPage.selectIndustryFromDropdown(usersList.get(0).getIndustry());
		registerForAnAccountPage.selectTypeOfBusinessFromDropdown(usersList.get(0).getTypeofBusiness());
		Assert.assertEquals(registerForAnAccountPage.NumberOfTextDisplayed(), numberOfSqFt);

		usersList = dbConnection.loadDataFromExcel("Commercial_Funeral","RegistrationIndustryTypeOfBuss");
		registerForAnAccountPage.selectIndustryFromDropdown(usersList.get(0).getIndustry());
		registerForAnAccountPage.selectTypeOfBusinessFromDropdown(usersList.get(0).getTypeofBusiness());
		Assert.assertEquals(registerForAnAccountPage.NumberOfTextDisplayed(), numberOfUnits);

		usersList = dbConnection.loadDataFromExcel("Commercial_Realtors","RegistrationIndustryTypeOfBuss");
		registerForAnAccountPage.selectIndustryFromDropdown(usersList.get(0).getIndustry());
		registerForAnAccountPage.selectTypeOfBusinessFromDropdown(usersList.get(0).getTypeofBusiness());
		Assert.assertEquals(registerForAnAccountPage.NumberOfTextDisplayed(), numberOfUnits);

		usersList = dbConnection.loadDataFromExcel("Industrial_Manufacturer","RegistrationIndustryTypeOfBuss");
		registerForAnAccountPage.selectIndustryFromDropdown(usersList.get(0).getIndustry());
		registerForAnAccountPage.selectTypeOfBusinessFromDropdown(usersList.get(0).getTypeofBusiness());
		Assert.assertEquals(registerForAnAccountPage.NumberOfTextDisplayed(), numberOfSqFt);

		usersList = dbConnection.loadDataFromExcel("ResidentialAndConsumer_Consumer","RegistrationIndustryTypeOfBuss");
		registerForAnAccountPage.selectIndustryFromDropdown(usersList.get(0).getIndustry());
		registerForAnAccountPage.selectTypeOfBusinessFromDropdown(usersList.get(0).getTypeofBusiness());
		Assert.assertEquals(registerForAnAccountPage.NumberOfTextDisplayed(), numberOfUnits);
	}

	/**divy jain
	 * 118410 - Verify company type and unit of measurement_Continue Checkout
	 */
	@Test(priority=2)
	public void verifyCompanyTypeAndUnitOfMeasurementAfterCheckout() throws Exception
	{
		usersList = dbConnection.loadDataFromExcel("searchByKeywordOrPartNumber","Search");
		searchPage= loginPage.searchByKeywordOrPartNumber(usersList.get(0).getSearchProductPartNumber());
		productDetailsPage = searchPage.clickOnProduct();
		productDetailsPage.clickAddToCartButton();
		WaitTool.hardWait();
		productDetailsPage.clickOnCloseAddtocartSuccessPopup();
		WaitTool.hardWait();
		productDetailsPage.refreshPage();
		WaitTool.hardWait();
		shoppingCartPage = loginPage.clickShoppingCartIcon();
		signInOrRegisterPage = shoppingCartPage.clickShoppingCartCheckOutButtonAsGuestUser();
		registerForAnAccountPage=signInOrRegisterPage.clickOnRegisterButton();
		registerForAnAccountPage.clickOnBrandNewUSerToHDSupply();

		usersList = dbConnection.loadDataFromExcel("MultiFamilyHousing_SingleMultiFamilyHousing","RegistrationIndustryTypeOfBuss");
		registerForAnAccountPage.selectIndustryFromDropdown(usersList.get(0).getIndustry());
		registerForAnAccountPage.selectTypeOfBusinessFromDropdown(usersList.get(0).getTypeofBusiness());
		Assert.assertEquals(registerForAnAccountPage.NumberOfTextDisplayed(), numberOfUnits);

		usersList = dbConnection.loadDataFromExcel("MultiFamilyHousing_MobileHomeParks","RegistrationIndustryTypeOfBuss");
		registerForAnAccountPage.selectIndustryFromDropdown(usersList.get(0).getIndustry());
		registerForAnAccountPage.selectTypeOfBusinessFromDropdown(usersList.get(0).getTypeofBusiness());
		Assert.assertEquals(registerForAnAccountPage.NumberOfTextDisplayed(), numberOfUnits);

		usersList = dbConnection.loadDataFromExcel("MultiFamilyHousing_OwnersAssociation","RegistrationIndustryTypeOfBuss");
		registerForAnAccountPage.selectIndustryFromDropdown(usersList.get(0).getIndustry());
		registerForAnAccountPage.selectTypeOfBusinessFromDropdown(usersList.get(0).getTypeofBusiness());
		Assert.assertEquals(registerForAnAccountPage.NumberOfTextDisplayed(), numberOfUnits);

		usersList = dbConnection.loadDataFromExcel("MultiFamilyHousing_PrivateStudentApts","RegistrationIndustryTypeOfBuss");
		registerForAnAccountPage.selectIndustryFromDropdown(usersList.get(0).getIndustry());
		registerForAnAccountPage.selectTypeOfBusinessFromDropdown(usersList.get(0).getTypeofBusiness());
		Assert.assertEquals(registerForAnAccountPage.NumberOfTextDisplayed(), numberOfUnits);

		usersList = dbConnection.loadDataFromExcel("Hospitality_Restaurants","RegistrationIndustryTypeOfBuss");
		registerForAnAccountPage.selectIndustryFromDropdown(usersList.get(0).getIndustry());
		registerForAnAccountPage.selectTypeOfBusinessFromDropdown(usersList.get(0).getTypeofBusiness());
		Assert.assertEquals(registerForAnAccountPage.NumberOfTextDisplayed(), numberOfSeats);

		usersList = dbConnection.loadDataFromExcel("Hospitality_LodgingRestaurants","RegistrationIndustryTypeOfBuss");
		registerForAnAccountPage.selectIndustryFromDropdown(usersList.get(0).getIndustry());
		registerForAnAccountPage.selectTypeOfBusinessFromDropdown(usersList.get(0).getTypeofBusiness());
		Assert.assertEquals(registerForAnAccountPage.NumberOfTextDisplayed(), numberOfSeats);

		usersList = dbConnection.loadDataFromExcel("Hospitality_LodgingHotel/Motel","RegistrationIndustryTypeOfBuss");
		registerForAnAccountPage.selectIndustryFromDropdown(usersList.get(0).getIndustry());
		registerForAnAccountPage.selectTypeOfBusinessFromDropdown(usersList.get(0).getTypeofBusiness());
		Assert.assertEquals(registerForAnAccountPage.NumberOfTextDisplayed(), numberOfRooms);

		usersList = dbConnection.loadDataFromExcel("Hospitality_RVPark/Campgrounds","RegistrationIndustryTypeOfBuss");
		registerForAnAccountPage.selectIndustryFromDropdown(usersList.get(0).getIndustry());
		registerForAnAccountPage.selectTypeOfBusinessFromDropdown(usersList.get(0).getTypeofBusiness());
		Assert.assertEquals(registerForAnAccountPage.NumberOfTextDisplayed(), numberOfSpaces);

		usersList = dbConnection.loadDataFromExcel("Hospitality_TimeShare/Vacationrental","RegistrationIndustryTypeOfBuss");
		registerForAnAccountPage.selectIndustryFromDropdown(usersList.get(0).getIndustry());
		registerForAnAccountPage.selectTypeOfBusinessFromDropdown(usersList.get(0).getTypeofBusiness());
		Assert.assertEquals(registerForAnAccountPage.NumberOfTextDisplayed(), numberOfUnits);

		usersList = dbConnection.loadDataFromExcel("Hospitality_GolfCourse/CountryClub","RegistrationIndustryTypeOfBuss");
		registerForAnAccountPage.selectIndustryFromDropdown(usersList.get(0).getIndustry());
		registerForAnAccountPage.selectTypeOfBusinessFromDropdown(usersList.get(0).getTypeofBusiness());
		Assert.assertEquals(registerForAnAccountPage.NumberOfTextDisplayed(), numberOfUnits);

		usersList = dbConnection.loadDataFromExcel("Healthcare_Assistedliving","RegistrationIndustryTypeOfBuss");
		registerForAnAccountPage.selectIndustryFromDropdown(usersList.get(0).getIndustry());
		registerForAnAccountPage.selectTypeOfBusinessFromDropdown(usersList.get(0).getTypeofBusiness());
		Assert.assertEquals(registerForAnAccountPage.NumberOfTextDisplayed(), numberOfBeds);

		usersList = dbConnection.loadDataFromExcel("Healthcare_IndependentLiving","RegistrationIndustryTypeOfBuss");
		registerForAnAccountPage.selectIndustryFromDropdown(usersList.get(0).getIndustry());
		registerForAnAccountPage.selectTypeOfBusinessFromDropdown(usersList.get(0).getTypeofBusiness());
		Assert.assertEquals(registerForAnAccountPage.NumberOfTextDisplayed(), numberOfUnits);

		usersList = dbConnection.loadDataFromExcel("Healthcare_SkilledNursing","RegistrationIndustryTypeOfBuss");
		registerForAnAccountPage.selectIndustryFromDropdown(usersList.get(0).getIndustry());
		registerForAnAccountPage.selectTypeOfBusinessFromDropdown(usersList.get(0).getTypeofBusiness());
		Assert.assertEquals(registerForAnAccountPage.NumberOfTextDisplayed(), numberOfBeds);

		usersList = dbConnection.loadDataFromExcel("Healthcare_HealthcareFacility","RegistrationIndustryTypeOfBuss");
		registerForAnAccountPage.selectIndustryFromDropdown(usersList.get(0).getIndustry());
		registerForAnAccountPage.selectTypeOfBusinessFromDropdown(usersList.get(0).getTypeofBusiness());
		Assert.assertEquals(registerForAnAccountPage.NumberOfTextDisplayed(), numberOfUnit);

		usersList = dbConnection.loadDataFromExcel("Healthcare_Hospitals","RegistrationIndustryTypeOfBuss");
		registerForAnAccountPage.selectIndustryFromDropdown(usersList.get(0).getIndustry());
		registerForAnAccountPage.selectTypeOfBusinessFromDropdown(usersList.get(0).getTypeofBusiness());
		Assert.assertEquals(registerForAnAccountPage.NumberOfTextDisplayed(), numberOfBeds);

		usersList = dbConnection.loadDataFromExcel("Healthcare_Practitioner","RegistrationIndustryTypeOfBuss");
		registerForAnAccountPage.selectIndustryFromDropdown(usersList.get(0).getIndustry());
		registerForAnAccountPage.selectTypeOfBusinessFromDropdown(usersList.get(0).getTypeofBusiness());
		Assert.assertEquals(registerForAnAccountPage.NumberOfTextDisplayed(), numberOfUnit);

		usersList = dbConnection.loadDataFromExcel("Healthcare_ConstructionHealthcare","RegistrationIndustryTypeOfBuss");
		registerForAnAccountPage.selectIndustryFromDropdown(usersList.get(0).getIndustry());
		registerForAnAccountPage.selectTypeOfBusinessFromDropdown(usersList.get(0).getTypeofBusiness());
		Assert.assertEquals(registerForAnAccountPage.NumberOfTextDisplayed(), numberOfEmployees);

		usersList = dbConnection.loadDataFromExcel("GovernmentFederal_DoDorCivilianAgency","RegistrationIndustryTypeOfBuss");
		registerForAnAccountPage.selectIndustryFromDropdown(usersList.get(0).getIndustry());
		registerForAnAccountPage.selectTypeOfBusinessFromDropdown(usersList.get(0).getTypeofBusiness());
		Assert.assertEquals(registerForAnAccountPage.NumberOfTextDisplayed(), numberOfUnits);

		usersList = dbConnection.loadDataFromExcel("GovernmentFederal_MilitaryLodging/TempHousing","RegistrationIndustryTypeOfBuss");
		registerForAnAccountPage.selectIndustryFromDropdown(usersList.get(0).getIndustry());
		registerForAnAccountPage.selectTypeOfBusinessFromDropdown(usersList.get(0).getTypeofBusiness());
		Assert.assertEquals(registerForAnAccountPage.NumberOfTextDisplayed(), numberOfRooms);

		usersList = dbConnection.loadDataFromExcel("GovernmentFederal_Prison/CorrectionalFacility","RegistrationIndustryTypeOfBuss");
		registerForAnAccountPage.selectIndustryFromDropdown(usersList.get(0).getIndustry());
		registerForAnAccountPage.selectTypeOfBusinessFromDropdown(usersList.get(0).getTypeofBusiness());
		Assert.assertEquals(registerForAnAccountPage.NumberOfTextDisplayed(), numberOfBeds);

		usersList = dbConnection.loadDataFromExcel("GovernmentFederal_MedicalFacility","RegistrationIndustryTypeOfBuss");
		registerForAnAccountPage.selectIndustryFromDropdown(usersList.get(0).getIndustry());
		registerForAnAccountPage.selectTypeOfBusinessFromDropdown(usersList.get(0).getTypeofBusiness());
		Assert.assertEquals(registerForAnAccountPage.NumberOfTextDisplayed(), numberOfBeds);

		usersList = dbConnection.loadDataFromExcel("GovernmentState/Local_State/County/CityGovernmentAgency","RegistrationIndustryTypeOfBuss");
		registerForAnAccountPage.selectIndustryFromDropdown(usersList.get(0).getIndustry());
		registerForAnAccountPage.selectTypeOfBusinessFromDropdown(usersList.get(0).getTypeofBusiness());
		Assert.assertEquals(registerForAnAccountPage.NumberOfTextDisplayed(), numberOfUnits);

		usersList = dbConnection.loadDataFromExcel("GovernmentState/Local_HousingAuthority","RegistrationIndustryTypeOfBuss");
		registerForAnAccountPage.selectIndustryFromDropdown(usersList.get(0).getIndustry());
		registerForAnAccountPage.selectTypeOfBusinessFromDropdown(usersList.get(0).getTypeofBusiness());
		Assert.assertEquals(registerForAnAccountPage.NumberOfTextDisplayed(), numberOfUnits);

		usersList = dbConnection.loadDataFromExcel("GovernmentState/Local_Prison/CorrectionalFacility","RegistrationIndustryTypeOfBuss");
		registerForAnAccountPage.selectIndustryFromDropdown(usersList.get(0).getIndustry());
		registerForAnAccountPage.selectTypeOfBusinessFromDropdown(usersList.get(0).getTypeofBusiness());
		Assert.assertEquals(registerForAnAccountPage.NumberOfTextDisplayed(), numberOfBeds);

		usersList = dbConnection.loadDataFromExcel("GovernmentState/Local_MedicalFacility","RegistrationIndustryTypeOfBuss");
		registerForAnAccountPage.selectIndustryFromDropdown(usersList.get(0).getIndustry());
		registerForAnAccountPage.selectTypeOfBusinessFromDropdown(usersList.get(0).getTypeofBusiness());
		Assert.assertEquals(registerForAnAccountPage.NumberOfTextDisplayed(), numberOfBeds);

		usersList = dbConnection.loadDataFromExcel("GovernmentContractorOrReseller_FederalGovernmentHousing","RegistrationIndustryTypeOfBuss");
		registerForAnAccountPage.selectIndustryFromDropdown(usersList.get(0).getIndustry());
		registerForAnAccountPage.selectTypeOfBusinessFromDropdown(usersList.get(0).getTypeofBusiness());
		Assert.assertEquals(registerForAnAccountPage.NumberOfTextDisplayed(), numberOfUnits);

		usersList = dbConnection.loadDataFromExcel("GovernmentContractorOrReseller_FederalGovernmentFacilities","RegistrationIndustryTypeOfBuss");
		registerForAnAccountPage.selectIndustryFromDropdown(usersList.get(0).getIndustry());
		registerForAnAccountPage.selectTypeOfBusinessFromDropdown(usersList.get(0).getTypeofBusiness());
		Assert.assertEquals(registerForAnAccountPage.NumberOfTextDisplayed(), numberOfUnits);

		usersList = dbConnection.loadDataFromExcel("GovernmentContractorOrReseller_GovernmentReseller","RegistrationIndustryTypeOfBuss");
		registerForAnAccountPage.selectIndustryFromDropdown(usersList.get(0).getIndustry());
		registerForAnAccountPage.selectTypeOfBusinessFromDropdown(usersList.get(0).getTypeofBusiness());
		Assert.assertEquals(registerForAnAccountPage.NumberOfTextDisplayed(), numberOfSqFt);

		usersList = dbConnection.loadDataFromExcel("GovernmentContractorOrReseller_SLEDContractor","RegistrationIndustryTypeOfBuss");
		registerForAnAccountPage.selectIndustryFromDropdown(usersList.get(0).getIndustry());
		registerForAnAccountPage.selectTypeOfBusinessFromDropdown(usersList.get(0).getTypeofBusiness());
		Assert.assertEquals(registerForAnAccountPage.NumberOfTextDisplayed(), numberOfSqFt);

		usersList = dbConnection.loadDataFromExcel("Education_University&CollegeHousing","RegistrationIndustryTypeOfBuss");
		registerForAnAccountPage.selectIndustryFromDropdown(usersList.get(0).getIndustry());
		registerForAnAccountPage.selectTypeOfBusinessFromDropdown(usersList.get(0).getTypeofBusiness());
		Assert.assertEquals(registerForAnAccountPage.NumberOfTextDisplayed(), numberOfBeds);

		usersList = dbConnection.loadDataFromExcel("Education_HigherEducationFacilities","RegistrationIndustryTypeOfBuss");
		registerForAnAccountPage.selectIndustryFromDropdown(usersList.get(0).getIndustry());
		registerForAnAccountPage.selectTypeOfBusinessFromDropdown(usersList.get(0).getTypeofBusiness());
		Assert.assertEquals(registerForAnAccountPage.NumberOfTextDisplayed(), numberOfUnits);

		usersList = dbConnection.loadDataFromExcel("Education_K12","RegistrationIndustryTypeOfBuss");
		registerForAnAccountPage.selectIndustryFromDropdown(usersList.get(0).getIndustry());
		registerForAnAccountPage.selectTypeOfBusinessFromDropdown(usersList.get(0).getTypeofBusiness());
		Assert.assertEquals(registerForAnAccountPage.NumberOfTextDisplayed(), numberOfUnits);

		usersList = dbConnection.loadDataFromExcel("FacilitiesOther_Retail/Resale","RegistrationIndustryTypeOfBuss");
		registerForAnAccountPage.selectIndustryFromDropdown(usersList.get(0).getIndustry());
		registerForAnAccountPage.selectTypeOfBusinessFromDropdown(usersList.get(0).getTypeofBusiness());
		Assert.assertEquals(registerForAnAccountPage.NumberOfTextDisplayed(), numberOfSqFt);

		usersList = dbConnection.loadDataFromExcel("FacilitiesOther_OtherFacility","RegistrationIndustryTypeOfBuss");
		registerForAnAccountPage.selectIndustryFromDropdown(usersList.get(0).getIndustry());
		registerForAnAccountPage.selectTypeOfBusinessFromDropdown(usersList.get(0).getTypeofBusiness());
		Assert.assertEquals(registerForAnAccountPage.NumberOfTextDisplayed(), numberOfUnits);

		usersList = dbConnection.loadDataFromExcel("FacilitiesOther_Liquidator","RegistrationIndustryTypeOfBuss");
		registerForAnAccountPage.selectIndustryFromDropdown(usersList.get(0).getIndustry());
		registerForAnAccountPage.selectTypeOfBusinessFromDropdown(usersList.get(0).getTypeofBusiness());
		Assert.assertEquals(registerForAnAccountPage.NumberOfTextDisplayed(), numberOfSqFt);

		usersList = dbConnection.loadDataFromExcel("FacilitiesOther_NonProfit","RegistrationIndustryTypeOfBuss");
		registerForAnAccountPage.selectIndustryFromDropdown(usersList.get(0).getIndustry());
		registerForAnAccountPage.selectTypeOfBusinessFromDropdown(usersList.get(0).getTypeofBusiness());
		Assert.assertEquals(registerForAnAccountPage.NumberOfTextDisplayed(), numberOfSqFt);

		usersList = dbConnection.loadDataFromExcel("Commercial_OfficeBuilding>4Stories","RegistrationIndustryTypeOfBuss");
		registerForAnAccountPage.selectIndustryFromDropdown(usersList.get(0).getIndustry());
		registerForAnAccountPage.selectTypeOfBusinessFromDropdown(usersList.get(0).getTypeofBusiness());
		Assert.assertEquals(registerForAnAccountPage.NumberOfTextDisplayed(), numberOfSqFt);

		usersList = dbConnection.loadDataFromExcel("Commercial_Maintenance","RegistrationIndustryTypeOfBuss");
		registerForAnAccountPage.selectIndustryFromDropdown(usersList.get(0).getIndustry());
		registerForAnAccountPage.selectTypeOfBusinessFromDropdown(usersList.get(0).getTypeofBusiness());
		Assert.assertEquals(registerForAnAccountPage.NumberOfTextDisplayed(), numberOfEmployees);

		usersList = dbConnection.loadDataFromExcel("Commercial_ContractorMaintenance","RegistrationIndustryTypeOfBuss");
		registerForAnAccountPage.selectIndustryFromDropdown(usersList.get(0).getIndustry());
		registerForAnAccountPage.selectTypeOfBusinessFromDropdown(usersList.get(0).getTypeofBusiness());
		Assert.assertEquals(registerForAnAccountPage.NumberOfTextDisplayed(), numberOfUnits);

		usersList = dbConnection.loadDataFromExcel("Commercial_Remodeler","RegistrationIndustryTypeOfBuss");
		registerForAnAccountPage.selectIndustryFromDropdown(usersList.get(0).getIndustry());
		registerForAnAccountPage.selectTypeOfBusinessFromDropdown(usersList.get(0).getTypeofBusiness());
		Assert.assertEquals(registerForAnAccountPage.NumberOfTextDisplayed(), numberOfEmployees);

		usersList = dbConnection.loadDataFromExcel("Commercial_ConstructionMultiFamilyHousing","RegistrationIndustryTypeOfBuss");
		registerForAnAccountPage.selectIndustryFromDropdown(usersList.get(0).getIndustry());
		registerForAnAccountPage.selectTypeOfBusinessFromDropdown(usersList.get(0).getTypeofBusiness());
		Assert.assertEquals(registerForAnAccountPage.NumberOfTextDisplayed(), numberOfEmployees);

		usersList = dbConnection.loadDataFromExcel("Commercial_ConstructionLodging","RegistrationIndustryTypeOfBuss");
		registerForAnAccountPage.selectIndustryFromDropdown(usersList.get(0).getIndustry());
		registerForAnAccountPage.selectTypeOfBusinessFromDropdown(usersList.get(0).getTypeofBusiness());
		Assert.assertEquals(registerForAnAccountPage.NumberOfTextDisplayed(), numberOfEmployees);

		usersList = dbConnection.loadDataFromExcel("Commercial_ConstructionCommercial","RegistrationIndustryTypeOfBuss");
		registerForAnAccountPage.selectIndustryFromDropdown(usersList.get(0).getIndustry());
		registerForAnAccountPage.selectTypeOfBusinessFromDropdown(usersList.get(0).getTypeofBusiness());
		Assert.assertEquals(registerForAnAccountPage.NumberOfTextDisplayed(), numberOfEmployees);

		usersList = dbConnection.loadDataFromExcel("Commercial_Mercantile","RegistrationIndustryTypeOfBuss");
		registerForAnAccountPage.selectIndustryFromDropdown(usersList.get(0).getIndustry());
		registerForAnAccountPage.selectTypeOfBusinessFromDropdown(usersList.get(0).getTypeofBusiness());
		Assert.assertEquals(registerForAnAccountPage.NumberOfTextDisplayed(), numberOfSqFt);

		usersList = dbConnection.loadDataFromExcel("Commercial_Service","RegistrationIndustryTypeOfBuss");
		registerForAnAccountPage.selectIndustryFromDropdown(usersList.get(0).getIndustry());
		registerForAnAccountPage.selectTypeOfBusinessFromDropdown(usersList.get(0).getTypeofBusiness());
		Assert.assertEquals(registerForAnAccountPage.NumberOfTextDisplayed(), numberOfSqFt);

		usersList = dbConnection.loadDataFromExcel("Commercial_PublicAssembly","RegistrationIndustryTypeOfBuss");
		registerForAnAccountPage.selectIndustryFromDropdown(usersList.get(0).getIndustry());
		registerForAnAccountPage.selectTypeOfBusinessFromDropdown(usersList.get(0).getTypeofBusiness());
		Assert.assertEquals(registerForAnAccountPage.NumberOfTextDisplayed(), numberOfSqFt);

		usersList = dbConnection.loadDataFromExcel("Commercial_StorageUnits/Warehouses","RegistrationIndustryTypeOfBuss");
		registerForAnAccountPage.selectIndustryFromDropdown(usersList.get(0).getIndustry());
		registerForAnAccountPage.selectTypeOfBusinessFromDropdown(usersList.get(0).getTypeofBusiness());
		Assert.assertEquals(registerForAnAccountPage.NumberOfTextDisplayed(), numberOfSqFt);

		usersList = dbConnection.loadDataFromExcel("Commercial_Reseller","RegistrationIndustryTypeOfBuss");
		registerForAnAccountPage.selectIndustryFromDropdown(usersList.get(0).getIndustry());
		registerForAnAccountPage.selectTypeOfBusinessFromDropdown(usersList.get(0).getTypeofBusiness());
		Assert.assertEquals(registerForAnAccountPage.NumberOfTextDisplayed(), numberOfSqFt);

		usersList = dbConnection.loadDataFromExcel("Commercial_Funeral","RegistrationIndustryTypeOfBuss");
		registerForAnAccountPage.selectIndustryFromDropdown(usersList.get(0).getIndustry());
		registerForAnAccountPage.selectTypeOfBusinessFromDropdown(usersList.get(0).getTypeofBusiness());
		Assert.assertEquals(registerForAnAccountPage.NumberOfTextDisplayed(), numberOfUnits);

		usersList = dbConnection.loadDataFromExcel("Commercial_Realtors","RegistrationIndustryTypeOfBuss");
		registerForAnAccountPage.selectIndustryFromDropdown(usersList.get(0).getIndustry());
		registerForAnAccountPage.selectTypeOfBusinessFromDropdown(usersList.get(0).getTypeofBusiness());
		Assert.assertEquals(registerForAnAccountPage.NumberOfTextDisplayed(), numberOfUnits);

		usersList = dbConnection.loadDataFromExcel("Industrial_Manufacturer","RegistrationIndustryTypeOfBuss");
		registerForAnAccountPage.selectIndustryFromDropdown(usersList.get(0).getIndustry());
		registerForAnAccountPage.selectTypeOfBusinessFromDropdown(usersList.get(0).getTypeofBusiness());
		Assert.assertEquals(registerForAnAccountPage.NumberOfTextDisplayed(), numberOfSqFt);

		usersList = dbConnection.loadDataFromExcel("ResidentialAndConsumer_Consumer","RegistrationIndustryTypeOfBuss");
		registerForAnAccountPage.selectIndustryFromDropdown(usersList.get(0).getIndustry());
		registerForAnAccountPage.selectTypeOfBusinessFromDropdown(usersList.get(0).getTypeofBusiness());
		Assert.assertEquals(registerForAnAccountPage.NumberOfTextDisplayed(), numberOfUnits);

	}


	/**Divy Jain
	 * 107728 - Create a new user Registration
	 * 98183	Verify required registration fields are indeed required
	 */
	@Test(priority=3)
	public void RegistrationforNewUser() throws Exception 
	{	
		loginPage.clickOnRegisterOrSignIn();
		registerForAnAccountPage = loginPage.clickOnRegisterForAnAccountButton();
		registerForAnAccountPage.clickOnBrandNewUSerToHDSupply();
		usersList = dbConnection.loadDataFromExcel("RegistrationforNewUser","Registration");
		registerForAnAccountPage.insertValueInCompanyName(usersList.get(0).getCompanyOrPropertyName());
		registerForAnAccountPage.insertValueInFirstName(usersList.get(0).getFirstName());
		registerForAnAccountPage.insertValueInLastName(usersList.get(0).getLastName());
		registerForAnAccountPage.insertValueInPhoneNumber();
		registerForAnAccountPage.insertValueInFaxNumber();
		registerForAnAccountPage.selectIndustryFromDropdown(usersList.get(0).getIndustry());
		registerForAnAccountPage.selectTypeOfBusinessFromDropdown(usersList.get(0).getTypeofBusiness());
		registerForAnAccountPage.insertValueInNumberOf();
		registerForAnAccountPage.clickOnNextButton1();
		registerForAnAccountPage.insertValueInShippingAddrsssName(usersList.get(0).getShippingAddressName());
		registerForAnAccountPage.insertValueInPropertyName(usersList.get(0).getCompanyOrPropertyName());
		registerForAnAccountPage.insertValueInAttentionOf();
		registerForAnAccountPage.insertValueInLookupAddress(usersList.get(0).getLookupAddress());
		registerForAnAccountPage.insertValueInAddress(usersList.get(0).getAddress());
		registerForAnAccountPage.insertValueInFloorOrSuite();
		registerForAnAccountPage.insertValueInCity(usersList.get(0).getCity());
		registerForAnAccountPage.selectStateFromDropdown(usersList.get(0).getState());
		registerForAnAccountPage.insertValueInZipcode(usersList.get(0).getZipCode());
		//Assert.assertTrue(registerForAnAccountPage.isBillingAddressSameShiipingAddress());
		registerForAnAccountPage.clickOnNextButton2();
		String email = registerForAnAccountPage.insertValueInEmailAddress(usersList.get(0).getEmailAddress());
		registerForAnAccountPage.insertValueInConfirmEmailAddress(email);
		registerForAnAccountPage.insertValueInUsername(usersList.get(0).getUsername());
		registerForAnAccountPage.insertValueInPassword(usersList.get(0).getpassword());
		registerForAnAccountPage.clickOnSubmit();
		Assert.assertTrue(registerForAnAccountPage.isThankyouForRegistrationDisplayed());

	}

	/**Divy Jain
	 * 146586 - Address and Zip Code Validation- New Customer
	 * This test case is failing because zipcode is accepting char value
	 */
	@Test(priority=4)
	public void VerifyStringInputForNumberFields() throws Exception
	{
		loginPage.clickOnRegisterOrSignIn();
		registerForAnAccountPage = loginPage.clickOnRegisterForAnAccountButton();
		registerForAnAccountPage.clickOnBrandNewUSerToHDSupply();
		usersList = dbConnection.loadDataFromExcel("RegistrationforNewUser","Registration");
		registerForAnAccountPage.insertValueInCompanyName(usersList.get(0).getCompanyOrPropertyName());
		registerForAnAccountPage.insertValueInFirstName(usersList.get(0).getFirstName());
		registerForAnAccountPage.insertValueInLastName(usersList.get(0).getLastName());
		registerForAnAccountPage.insertInvalidValueInPhoneNumber();
		registerForAnAccountPage.selectIndustryFromDropdown(usersList.get(0).getIndustry());
		registerForAnAccountPage.selectTypeOfBusinessFromDropdown(usersList.get(0).getTypeofBusiness());
		registerForAnAccountPage.insertValueInNumberOf();
		registerForAnAccountPage.clickOnNextButton1();
		Assert.assertTrue(registerForAnAccountPage.isFieldErrorOnAddAddressDisplayed());
		registerForAnAccountPage.insertValueInCompanyName(usersList.get(0).getCompanyOrPropertyName());
		registerForAnAccountPage.insertValueInFirstName(usersList.get(0).getFirstName());
		registerForAnAccountPage.insertValueInLastName(usersList.get(0).getLastName());
		registerForAnAccountPage.insertValueInPhoneNumber();
		registerForAnAccountPage.selectIndustryFromDropdown(usersList.get(0).getIndustry());
		registerForAnAccountPage.selectTypeOfBusinessFromDropdown(usersList.get(0).getTypeofBusiness());
		registerForAnAccountPage.insertInvalidValueInNumberOf();
		registerForAnAccountPage.clickOnNextButton1();
		registerForAnAccountPage.insertValueInCompanyName(usersList.get(0).getCompanyOrPropertyName());
		registerForAnAccountPage.insertValueInFirstName(usersList.get(0).getFirstName());
		registerForAnAccountPage.insertValueInLastName(usersList.get(0).getLastName());
		registerForAnAccountPage.insertValueInPhoneNumber();
		registerForAnAccountPage.selectIndustryFromDropdown(usersList.get(0).getIndustry());
		registerForAnAccountPage.selectTypeOfBusinessFromDropdown(usersList.get(0).getTypeofBusiness());
		registerForAnAccountPage.insertValueInNumberOf();
		registerForAnAccountPage.clickOnNextButton1();
		registerForAnAccountPage.insertValueInShippingAddrsssName(usersList.get(0).getShippingAddressName());
		registerForAnAccountPage.insertValueInPropertyName(usersList.get(0).getCompanyOrPropertyName());
		registerForAnAccountPage.insertValueInAttentionOf();
		registerForAnAccountPage.insertValueInLookupAddress(usersList.get(0).getLookupAddress());
		registerForAnAccountPage.insertValueInAddress(usersList.get(0).getAddress());
		registerForAnAccountPage.insertValueInFloorOrSuite();
		registerForAnAccountPage.insertValueInCity(usersList.get(0).getCity());
		registerForAnAccountPage.selectStateFromDropdown(usersList.get(0).getState());
		registerForAnAccountPage.insertValueInZipcode(usersList.get(0).getFirstName());
		registerForAnAccountPage.clickOnNextButton2();
		Assert.assertTrue(registerForAnAccountPage.isFieldErrorOnAddAddressDisplayed());

	}


	/**Divy Jain
	 * 98184 - Verify non-required registration fields are not required to register
	 */
	@Test(priority=5)
	public void RegistrationforNewUserWithOnlyMandatoryFields() throws Exception 
	{	
		loginPage.clickOnRegisterOrSignIn();
		registerForAnAccountPage = loginPage.clickOnRegisterForAnAccountButton();
		registerForAnAccountPage.clickOnBrandNewUSerToHDSupply();
		usersList = dbConnection.loadDataFromExcel("RegistrationforNewUser","Registration");
		registerForAnAccountPage.insertValueInCompanyName(usersList.get(0).getCompanyOrPropertyName());
		registerForAnAccountPage.insertValueInFirstName(usersList.get(0).getFirstName());
		registerForAnAccountPage.insertValueInLastName(usersList.get(0).getLastName());
		registerForAnAccountPage.insertValueInPhoneNumber();
		registerForAnAccountPage.selectIndustryFromDropdown(usersList.get(0).getIndustry());
		registerForAnAccountPage.selectTypeOfBusinessFromDropdown(usersList.get(0).getTypeofBusiness());
		registerForAnAccountPage.insertValueInNumberOf();
		registerForAnAccountPage.clickOnNextButton1();
		registerForAnAccountPage.insertValueInPropertyName(usersList.get(0).getCompanyOrPropertyName());
		registerForAnAccountPage.insertValueInAttentionOf();
		registerForAnAccountPage.insertValueInAddress(usersList.get(0).getAddress());
		registerForAnAccountPage.insertValueInCity(usersList.get(0).getCity());
		registerForAnAccountPage.selectStateFromDropdown(usersList.get(0).getState());
		registerForAnAccountPage.insertValueInZipcode(usersList.get(0).getZipCode());
		//Assert.assertTrue(registerForAnAccountPage.isBillingAddressSameShiipingAddress());
		registerForAnAccountPage.clickOnNextButton2();
		String email = registerForAnAccountPage.insertValueInEmailAddress(usersList.get(0).getEmailAddress());
		registerForAnAccountPage.insertValueInConfirmEmailAddress(email);
		registerForAnAccountPage.insertValueInUsername(usersList.get(0).getUsername());
		registerForAnAccountPage.insertValueInPassword(usersList.get(0).getpassword());
		registerForAnAccountPage.clickOnSubmit();
		Assert.assertTrue(registerForAnAccountPage.isThankyouForRegistrationDisplayed());

	}

}

package com.selenium.ebiz.footer;

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

public class FooterLinkParameterization extends BaseClass {

	ArrayList<UsersListBean> usersList;
	DBCon dbConnection = new DBCon();
	HomePage homePage;
	LoginPage loginPage;
	String careerPageTitle = "HD Supply Jobs";
	String contactUsPagetitle = "https://qa2.hdsupplysolutions.com//s/contact_us";
	String hDsupplyCanadaTitle = "HD Supply Facilities Maintenance - MRO Products & Solutions";

	/**
	 * 
	 * @author Neha
	 * This test is to verify there are Static Links to Content Pages in Footer
	 * This TestScript is Mapped to the US-Ord-932
	 * @throws Exception 
	 * 
	 * 
	 */

	@BeforeMethod
	public void driverSetup() throws MalformedURLException, Exception 
	{
		driver = initialize();
		loginPage = new LoginPage(driver);
		homePage = loginPage.loginToHdSupplySite(prop.getProperty("username"), prop.getProperty("password"));

	} 

	/*
	 * The Below tests will click on individual links. 
	 * 
	 */

	/*	@Test(priority = 0)
	public void clickOnCareerLinks() throws Exception 
	{
		usersList = dbConnection.loadDataFromExcel("clickOnCareerLink","HDSTestdata");
		//CommonFunctions.scrollDowntillFooterLinks(driver);
		WaitTool.hardWait();
		// clicking on the Career Link
		homePage.clickAboutUsCareersLinkText();
		WaitTool.hardWait();

		// Getting all the list of footer link
		List<WebElement> AllFooterLinks = driver.findElements(By.xpath("//div[@id='footerWrapper']/div/div/div/div/ul/li/a"));
		System.out.println("Size: " + AllFooterLinks.size());
		for (int i = 0; i < AllFooterLinks.size(); i++) {
		// comparing from the inputsheet and from the list
			System.out.println("AllFooterLinks.get(i).getText() :"
					+ AllFooterLinks.get(i).getText());
			System.out.println("usersList.get(0).getFooterLink() :"
					+ usersList.get(0).getFooterLink());
			if (AllFooterLinks.get(i).getText()
					.equalsIgnoreCase(usersList.get(0).getFooterLink()))
			{
		// clicking on the links
			AllFooterLinks.get(i).click();
			WaitTool.waitFor(driver, true);
			}
			else {
				break;
			}
		}
	}
	 */

	@Test(priority = 0)
	public void clickOnCareerLinks() throws Exception 
	{
		usersList = dbConnection.loadDataFromExcel("clickOnCareerLink","HDSTestdata");
		String linkName = usersList.get(0).getFooterLink();
		homePage.clickOnFooterLinks(linkName);
		homePage.moveToNewWindow();
		System.out.println("childPageTitle isss" + homePage.getTitle());
		Assert.assertTrue(homePage.getTitle().equals(careerPageTitle));
		homePage.moveToParentWindow();
	}

	@Test(priority = 1)
	public void clickOnContactUsLink() throws Exception
	{
		usersList = dbConnection.loadDataFromExcel("clickContactUsLink","HDSTestdata");
		String linkName = usersList.get(0).getFooterLink();
		System.out.println("linkName is "+ linkName);
		homePage.clickOnFooterLinks(linkName);
		System.out.println("childPageTitle isss" + homePage.getTitle());
		Assert.assertTrue(homePage.isContactUsTextDisplayed());
	}

	@Test(priority = 2)
	public void clickOnEnEspanolLink() throws Exception
	{
		usersList = dbConnection.loadDataFromExcel("clickEnEspanolLink","HDSTestdata");
		String linkName = usersList.get(0).getFooterLink();
		System.out.println("linkName is "+ linkName);
		homePage.clickOnFooterLinks(linkName);
		System.out.println("childPageTitle isss" + homePage.getTitle());
		Assert.assertTrue(homePage.isSpanishTextDisplayed());
	}

	@Test(priority = 3)
	public void clickHDSupplyCanadaLink() throws Exception 
	{
		usersList = dbConnection.loadDataFromExcel("clickHDSupplyCanadaLink","HDSTestdata");
		String linkName = usersList.get(0).getFooterLink();
		System.out.println("linkName is "+ linkName);
		homePage.clickOnFooterLinks(linkName);
		System.out.println("childPageTitle isss" + homePage.getTitle());
		Assert.assertTrue(homePage.getTitle().contains(hDsupplyCanadaTitle));
	}

	@Test(priority = 4)
	public void clickLocationsLink() throws Exception
	{
		usersList = dbConnection.loadDataFromExcel("clickLocationsLink","HDSTestdata");
		String linkName = usersList.get(0).getFooterLink();
		System.out.println("linkName is "+ linkName);
		homePage.clickOnFooterLinks(linkName);
		Assert.assertTrue(homePage.isLocationsTextDisplayed());
	}

	@Test(priority = 5)
	public void clickOurCompanyLink() throws Exception
	{
		usersList = dbConnection.loadDataFromExcel("clickOurCompanyLink","HDSTestdata");
		String linkName = usersList.get(0).getFooterLink();
		System.out.println("linkName is "+ linkName);
		homePage.clickOnFooterLinks(linkName);
		System.out.println("title is"+ homePage.getTitle());
		Assert.assertTrue(homePage.isOurCompanyTextDisplayed());
	}

	@Test(priority = 6)
	public void clickAccountChangeRequestLink() throws Exception 
	{
		usersList = dbConnection.loadDataFromExcel("clickAccountChangeRequestLink", "HDSTestdata");
		String linkName = usersList.get(0).getFooterLink();
		System.out.println("linkName is "+ linkName);
		homePage.clickOnFooterLinks(linkName);
		System.out.println("title is"+ homePage.getTitle());
		Assert.assertTrue(homePage.isaAccountChangeRequestBreadcrumbDisplayed());
	}

	@Test(priority = 7)
	public void clickApplyforCreditLink() throws Exception {
		// Getting the Data from the input Data
		usersList = dbConnection.loadDataFromExcel("clickApplyforCreditLink","HDSTestdata");
		String linkName = usersList.get(0).getFooterLink();
		System.out.println("linkName is "+ linkName);
		homePage.clickOnFooterLinks(linkName);
		System.out.println("title is"+ homePage.getTitle());
		Assert.assertTrue(homePage.isApplyForCreditTextDisplayed());
	}

	@Test(priority = 8)
	public void clickFAQLink() throws Exception
	{
		usersList = dbConnection.loadDataFromExcel("clickFAQLink","HDSTestdata");	
		String linkName = usersList.get(0).getFooterLink();
		System.out.println("linkName is "+ linkName);
		homePage.clickOnFooterLinks(linkName);
		System.out.println("title is"+ homePage.getTitle());
		Assert.assertTrue(homePage.isFrequentlyAskedQuestionsTextDisplayed());
	}

	@Test(priority = 9)
	public void clickForgotPasswordLink() throws Exception
	{
		usersList = dbConnection.loadDataFromExcel("clickForgotPasswordLink","HDSTestdata");
		String linkName = usersList.get(0).getFooterLink();
		System.out.println("linkName is "+ linkName);
		homePage.clickOnFooterLinks(linkName);
		System.out.println("title is"+ homePage.getTitle());
		Assert.assertTrue(homePage.isAccountRetrievalTextDisplayed());
	}

	@Test(priority = 10)
	public void clickNewWebsiteFeaturesLink() throws Exception {
		usersList = dbConnection.loadDataFromExcel("clickNewWebsiteFeaturesLink", "HDSTestdata");
		String linkName = usersList.get(0).getFooterLink();
		homePage.clickOnFooterLinks(linkName);
		System.out.println("title is"+ homePage.getTitle());
		Assert.assertTrue(homePage.isWebsiteUpdatesTextDisplayed());
	}

	@Test(priority = 11)
	public void clickSiteMapLink() throws Exception
	{
		usersList = dbConnection.loadDataFromExcel("clickSiteMapLink","HDSTestdata");
		String linkName = usersList.get(0).getFooterLink();
		homePage.clickOnFooterLinks(linkName);
		System.out.println("title is"+ homePage.getTitle());
		//Assert.assertTrue(homePage.isWebsiteUpdatesTextDisplayed());
	}

	@Test(priority = 12)
	public void clickReturnsFormLink() throws Exception 
	{
		usersList = dbConnection.loadDataFromExcel("clickReturnsFormLink","HDSTestdata");
		String linkName = usersList.get(0).getFooterLink();
		homePage.clickOnFooterLinks(linkName);
		System.out.println("title is"+ homePage.getTitle());
		Assert.assertTrue(homePage.isContactUsForHelpTextDisplayed());
	}

	@Test(priority = 13)
	public void clickReturnPolicyLink() throws Exception
	{
		usersList = dbConnection.loadDataFromExcel("clickReturnPolicyLink","HDSTestdata");
		String linkName = usersList.get(0).getFooterLink();
		homePage.clickOnFooterLinks(linkName);
		System.out.println("title is"+ homePage.getTitle());
		Assert.assertTrue(homePage.isReturnPolicyTextDisplayed());
	}

	@Test(priority = 14)
	public void clickCaliforniaPolicyLink() throws Exception
	{
		usersList = dbConnection.loadDataFromExcel("clickCaliforniaPrivacyLink", "HDSTestdata");
		String linkName = usersList.get(0).getFooterLink();
		homePage.clickOnFooterLinks(linkName);
		System.out.println("title is"+ homePage.getTitle());
		Assert.assertTrue(homePage.isCaliforniaPrivacyTextDisplayed());
	}

	@Test(priority = 15)
	public void clickOnFinePrintCatalogIcons() throws Exception {
		usersList = dbConnection.loadDataFromExcel("clickFinePrint&CatalogIconsLink", "HDSTestdata");
		String linkName = usersList.get(0).getFooterLink();
		homePage.clickOnFooterLinks(linkName);
		System.out.println("title is"+ homePage.getTitle());
		Assert.assertTrue(homePage.isFinePrintAndCatalogIconsTextDisplayed());
	}

	@Test(priority = 16)
	public void clickPrivacyPolicyLink() throws Exception {
		usersList = dbConnection.loadDataFromExcel("clickPrivacyPolicyLink","HDSTestdata");
		String linkName = usersList.get(0).getFooterLink();
		homePage.clickOnFooterLinks(linkName);
		homePage.moveToNewWindow();
		System.out.println("title is"+ homePage.getTitle());
		Assert.assertTrue(homePage.isPrivacyComplainceTextDisplayed());
		homePage.moveToParentWindow();
	}

	@Test(priority = 17)
	public void clickPrivacyStatementLink() throws Exception {
		usersList = dbConnection.loadDataFromExcel("clickPrivacyStatementLink","HDSTestdata");
		String linkName = usersList.get(0).getFooterLink();
		homePage.clickOnFooterLinks(linkName);
		System.out.println("title is"+ homePage.getTitle());
		Assert.assertTrue(homePage.isPrivacyStatementTextDisplayed());
	}

	@Test(priority = 18)
	public void clickTermsOfSaleLink() throws Exception {
		usersList = dbConnection.loadDataFromExcel("clickTermsOfSaleLink","HDSTestdata");
		String linkName = usersList.get(0).getFooterLink();
		homePage.clickOnFooterLinks(linkName);
		System.out.println("title is"+ homePage.getTitle());
		Assert.assertTrue(homePage.isTermOfSaleTextDisplayed());

	}

	@Test(priority = 19)
	public void clickTermsOfUseLink() throws Exception {
		usersList = dbConnection.loadDataFromExcel("clickTermsOfUseLink","HDSTestdata");
		String linkName = usersList.get(0).getFooterLink();
		homePage.clickOnFooterLinks(linkName);
		System.out.println("title is"+ homePage.getTitle());
		Assert.assertTrue(homePage.isTermOfUseeTextDisplayed());
	}
}
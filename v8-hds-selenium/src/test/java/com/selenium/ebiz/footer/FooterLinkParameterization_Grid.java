package com.selenium.ebiz.footer;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class FooterLinkParameterization_Grid extends BaseClassV8_ParallelGrid {


	String careerPageTitle = "HD Supply Jobs";
	String contactUsPagetitle = "https://qa2.hdsupplysolutions.com//s/contact_us";
	String hDsupplyCanadaTitle = "HD Supply Facilities Maintenance - MRO Products & Solutions";
	private ArrayList<UsersListBean> usersList;

	/**
	 * 
	 * @author Neha
	 * This test is to verify there are Static Links to Content Pages in Footer
	 * This TestScript is Mapped to the US-Ord-932
	 * @throws Exception 
	 * modified: Iuliia
	 * 
	 */


	@Test(dataProvider = "browsers")
	public void footer_VerifyCareerLinks(String browser, String version, String os, Method method) throws Exception
	{
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);

		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(),configread.getPassword());
		usersList=pageManager.dBCon().loadDataFromExcel("clickOnCareerLink","HDSTestdata");
		String linkName = usersList.get(0).getFooterLink();
		pageManager.homePage().clickOnFooterLinks(linkName);
		pageManager.homePage().moveToNewWindow();
		pageManager.homePage().clickOnFooterLinks(linkName);
		pageManager.homePage().moveToNewWindow();
		System.out.println("childPageTitle isss" + 	pageManager.homePage().getTitle());
		Assert.assertEquals(pageManager.homePage().getTitle(), careerPageTitle);
	}

	@Test(dataProvider = "browsers")
	public void footer_VerifyContactUsTextIsDisplayed(String browser, String version, String os, Method method) throws Exception
	{
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(),configread.getPassword());

		usersList=pageManager.dBCon().loadDataFromExcel("clickContactUsLink","HDSTestdata");
		String linkName = usersList.get(0).getFooterLink();
		System.out.println("linkName is "+ linkName);
		pageManager.homePage().clickOnFooterLinks(linkName);
		System.out.println("childPageTitle isss" + pageManager.homePage().getTitle());
		Assert.assertTrue(pageManager.homePage().contactUsText.isDisplayed());
	}

	@Test(dataProvider = "browsers")
	public void footer_VerifySpanishTextIsDisplayed(String browser, String version, String os, Method method) throws Exception
	{
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(),configread.getPassword());
		usersList=pageManager.dBCon().loadDataFromExcel("clickEnEspanolLink","HDSTestdata");
		String linkName = usersList.get(0).getFooterLink();
		System.out.println("linkName is "+ linkName);
		pageManager.homePage().clickOnFooterLinks(linkName);
		System.out.println("childPageTitle isss" + pageManager.homePage().getTitle());
		Assert.assertTrue(pageManager.homePage().spanishText.isDisplayed());
	}

	@Test(dataProvider = "browsers")
	public void footer_VerifyHDSupplyCanadaLink(String browser, String version, String os, Method method) throws Exception
	{
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(),configread.getPassword());
		usersList=pageManager.dBCon().loadDataFromExcel("clickHDSupplyCanadaLink","HDSTestdata");
		String linkName = usersList.get(0).getFooterLink();
		System.out.println("linkName is "+ linkName);
		pageManager.homePage().clickOnFooterLinks(linkName);
		System.out.println("childPageTitle isss" + pageManager.homePage().getTitle());
		Assert.assertTrue(pageManager.homePage().getTitle().contains(hDsupplyCanadaTitle));
	}

	@Test(dataProvider = "browsers")
	public void footer_VerifyLocationsTextLink(String browser, String version, String os, Method method) throws Exception
	{
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(),configread.getPassword());
		usersList=pageManager.dBCon().loadDataFromExcel("clickLocationsLink","HDSTestdata");
		String linkName = usersList.get(0).getFooterLink();
		System.out.println("linkName is "+ linkName);
		pageManager.homePage().clickOnFooterLinks(linkName);
		Assert.assertTrue(pageManager.homePage().LocationsText.isDisplayed());
	}

	@Test(dataProvider = "browsers")
	public void footer_VerifyOurCompanyLink(String browser, String version, String os, Method method) throws Exception
	{
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(),configread.getPassword());
		usersList=pageManager.dBCon().loadDataFromExcel("clickOurCompanyLink","HDSTestdata");
		 String linkName = usersList.get(0).getFooterLink();
		System.out.println("linkName is "+ linkName);
		pageManager.homePage().clickOnFooterLinks(linkName);
		System.out.println("title is"+ pageManager.homePage().getTitle());
		Assert.assertTrue(pageManager.homePage().ourCompanyText.isDisplayed());
	}

	@Test(dataProvider = "browsers")
	public void footer_VerifyAccountChangeRequestLink(String browser, String version, String os, Method method) throws Exception
	{
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(),configread.getPassword());
		usersList=pageManager.dBCon().loadDataFromExcel("clickAccountChangeRequestLink","HDSTestdata");
		 String linkName = usersList.get(0).getFooterLink();
		System.out.println("linkName is "+ linkName);
		pageManager.homePage().clickOnFooterLinks(linkName);
		System.out.println("title is"+ pageManager.homePage().getTitle());
		Assert.assertTrue(pageManager.homePage().accountChangeRequestBreadcrumb.isDisplayed());
	}

	@Test(dataProvider = "browsers")
	public void footer_VerifyApplyforCreditLink(String browser, String version, String os, Method method) throws Exception
	{
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		// Getting the Data from the input Data
		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(),configread.getPassword());
		usersList=pageManager.dBCon().loadDataFromExcel("clickApplyforCreditLink","HDSTestdata");
		 String linkName = usersList.get(0).getFooterLink();
		System.out.println("linkName is "+ linkName);
		pageManager.homePage().clickOnFooterLinks(linkName);
		System.out.println("title is"+ pageManager.homePage().getTitle());
		Assert.assertTrue(pageManager.homePage().applyForCreditText.isDisplayed());
	}

	@Test(dataProvider = "browsers")
	public void footer_VerifyFAQLink(String browser, String version, String os, Method method) throws Exception
	{
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(),configread.getPassword());
		usersList=pageManager.dBCon().loadDataFromExcel("clickFAQLink","HDSTestdata");
		 String linkName = usersList.get(0).getFooterLink();
		System.out.println("linkName is "+ linkName);
		pageManager.homePage().clickOnFooterLinks(linkName);
		System.out.println("title is"+ pageManager.homePage().getTitle());
		Assert.assertTrue(pageManager.homePage().isDisplayedMyAccountFrequentlyPurchasedQuickLinkInUtilityBar());
	}

	@Test(dataProvider = "browsers")
	public void footer_VerifyAccountRetrievalText(String browser, String version, String os, Method method) throws Exception
	{
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(),configread.getPassword());
		usersList=pageManager.dBCon().loadDataFromExcel("clickForgotPasswordLink","HDSTestdata");
		 String linkName = usersList.get(0).getFooterLink();
		System.out.println("linkName is "+ linkName);
		pageManager.homePage().clickOnFooterLinks(linkName);
		System.out.println("title is"+ pageManager.homePage().getTitle());
		Assert.assertTrue(pageManager.homePage().accountRetrievalText.isDisplayed());
	}

	@Test(dataProvider = "browsers")
	public void footer_VerifyNewWebsiteFeaturesLink(String browser, String version, String os, Method method) throws Exception
	{
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(),configread.getPassword());
		usersList=pageManager.dBCon().loadDataFromExcel("clickNewWebsiteFeaturesLink","HDSTestdata");
		 String linkName = usersList.get(0).getFooterLink();
		pageManager.homePage().clickOnFooterLinks(linkName);
		System.out.println("title is"+ pageManager.homePage().getTitle());
		Assert.assertTrue(pageManager.homePage().websiteUpdatesText.isDisplayed());
	}

	//09/09/2019 Modified: Bhavani Added Assert at line 215 and fixed the webelement property in HomePage at line 627 for SiteMap
	@Test(dataProvider = "browsers", enabled = true)
	public void footer_clickSiteMapLink(String browser, String version, String os, Method method) throws Exception
	{
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		
		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(),configread.getPassword());
		usersList=pageManager.dBCon().loadDataFromExcel("clickSiteMapLink","HDSTestdata");
		String linkName = usersList.get(0).getFooterLink();
		pageManager.homePage().clickOnFooterLinks(linkName);
		
		System.out.println("title is"+ pageManager.homePage().getTitle());
		Assert.assertTrue(pageManager.homePage().isSiteMapTextDisplayed());
	}

	@Test(dataProvider = "browsers")
	public void footer_VerifyContactUsForHelpText(String browser, String version, String os, Method method) throws Exception
	{
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(),configread.getPassword());
		usersList=pageManager.dBCon().loadDataFromExcel("clickReturnsFormLink","HDSTestdata");
		 String linkName = usersList.get(0).getFooterLink();
		pageManager.homePage().clickOnFooterLinks(linkName);
		System.out.println("title is"+ pageManager.homePage().getTitle());
		Assert.assertTrue(pageManager.homePage().contactUsForHelpText.isDisplayed());
	}

	@Test(dataProvider = "browsers")
	public void footer_VerifyReturnPolicyLink(String browser, String version, String os, Method method) throws Exception
	{
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(),configread.getPassword());
		usersList=pageManager.dBCon().loadDataFromExcel("clickReturnPolicyLink","HDSTestdata");
		 String linkName = usersList.get(0).getFooterLink();
		pageManager.homePage().clickOnFooterLinks(linkName);
		System.out.println("title is"+ pageManager.homePage().getTitle());
		Assert.assertTrue(pageManager.homePage().returnPolicyText.isDisplayed());
	}

	@Test( dataProvider = "browsers")
	public void footer_VerifyCaliforniaPolicyLink(String browser, String version, String os, Method method) throws Exception
	{
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(),configread.getPassword());
		usersList=pageManager.dBCon().loadDataFromExcel("clickCaliforniaPrivacyLink","HDSTestdata");
		 String linkName = usersList.get(0).getFooterLink();
		pageManager.homePage().clickOnFooterLinks(linkName);
		System.out.println("title is"+ pageManager.homePage().getTitle());
		Assert.assertTrue(pageManager.homePage().californiaPrivacyText.isDisplayed());
	}

	@Test(dataProvider = "browsers")
	public void footer_VerifyFinePrintCatalogIcons(String browser, String version, String os, Method method) throws Exception
	{
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(),configread.getPassword());
		usersList=pageManager.dBCon().loadDataFromExcel("clickFinePrint&CatalogIconsLink","HDSTestdata");
		 String linkName = usersList.get(0).getFooterLink();
		pageManager.homePage().clickOnFooterLinks(linkName);
		System.out.println("title is"+ pageManager.homePage().getTitle());
		Assert.assertTrue(pageManager.homePage().finePrintAndCatalogIconsText.isDisplayed());
	}

	@Test( dataProvider = "browsers")
	public void footer_VerifyPrivacyPolicyLink(String browser, String version, String os, Method method) throws Exception
	{
		/*
		 09/04/2019 Divy Jain : updated xpath of privacyComplainceText and script is working fine 
		*/
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(),configread.getPassword());
		usersList=pageManager.dBCon().loadDataFromExcel("clickPrivacyPolicyLink","HDSTestdata");
		 String linkName = usersList.get(0).getFooterLink();
		pageManager.homePage().clickOnFooterLinks(linkName);
		pageManager.homePage().moveToNewWindow();
		System.out.println("title is"+ pageManager.homePage().getTitle());
		Assert.assertTrue(pageManager.homePage().privacyComplainceText.isDisplayed());
	}

	@Test(dataProvider = "browsers")
	public void footer_VerifyPrivacyStatementLink(String browser, String version, String os, Method method) throws Exception
	{
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(),configread.getPassword());
		usersList=pageManager.dBCon().loadDataFromExcel("clickPrivacyStatementLink","HDSTestdata");
		 String linkName = usersList.get(0).getFooterLink();
		pageManager.homePage().clickOnFooterLinks(linkName);
		System.out.println("title is"+ pageManager.homePage().getTitle());
		Assert.assertTrue(pageManager.homePage().privacyStatementText.isDisplayed());
	}

	@Test(dataProvider = "browsers")
	public void footer_VerifyTermsOfSaleLink(String browser, String version, String os, Method method) throws Exception
	{
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(),configread.getPassword());
		usersList=pageManager.dBCon().loadDataFromExcel("clickTermsOfSaleLink","HDSTestdata");
		 String linkName = usersList.get(0).getFooterLink();
		pageManager.homePage().clickOnFooterLinks(linkName);
		System.out.println("title is"+ pageManager.homePage().getTitle());
		Assert.assertTrue(pageManager.homePage().termOfSaleText.isDisplayed());

	}

	@Test(dataProvider = "browsers")
	public void footer_VerifyTermsOfUseLink(String browser, String version, String os, Method method) throws Exception
	{
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(),configread.getPassword());
		usersList=pageManager.dBCon().loadDataFromExcel("clickTermsOfUseLink","HDSTestdata");
		 String linkName = usersList.get(0).getFooterLink();
		pageManager.homePage().clickOnFooterLinks(linkName);
		System.out.println("title is"+ pageManager.homePage().getTitle());
		Assert.assertTrue(pageManager.homePage().termOfUseText.isDisplayed());
	}
}
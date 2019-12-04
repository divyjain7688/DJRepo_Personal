/**
 * 
 * @author suresh
 * 
 * This test will verify the headers in the application after login
 * 
 * This TestScript is Mapped to the US-CAT-960
 * 
 * 
 * 
 */

package com.selenium.ebiz.header;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;


public class HeaderServiceFlyoutAndCustomProductsTextDisplayed extends BaseClassV8_ParallelGrid{

	/**
	 *  Verify the Headers and click on the Services to Check the flyout
	 */	
	@Test(dataProvider = "browsers")
	public void header_verifyHeadersandServicesFlyoutTest(String browser, String version, String os, Method method) throws Exception{
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
		pageManager.headerServicesPage().clickHeaderServicesLinkText();
		boolean isDisplayedL1FlyoutServices = pageManager.headerServicesPage().isDisplayedL1FlyoutServices();
		pageManager.headerServicesPage().clickHeaderServicesCustomProductsLinkText();
		boolean isDisplayedL2FlyoutServices = pageManager.headerServicesPage().isDisplayedL2FlyoutServices();
		Assert.assertTrue(isDisplayedL1FlyoutServices);
		Assert.assertTrue(isDisplayedL2FlyoutServices);

	}

	/**
	 *
	 * @author Neha Dev
	 * Display Static Content Pages for Unauthenticated User
	 * This Test script is mapped to US-Cat-850
	 * @throws Exception
	 * modified by: Iuliia
	 */


	@Test(dataProvider = "browsers")
	public void header_verifyHeaderCustomProductsTextLogUser(String browser, String version, String os, Method method) throws Exception {
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
		pageManager.homePage().moveToSubCategoryPage();
		pageManager.headerServicesPage().clickHeaderServicesLinkText();
		pageManager.headerServicesPage().clickHeaderServicesCustomProductsLinkText();
		pageManager.headerServicesPage().clickHeaderServicesOrderFormsLinkText();
		Assert.assertTrue(pageManager.homePage().customProductsText.isDisplayed());

	}

	@Test(dataProvider = "browsers")
	public void header_verifyHeaderCustomProductsTextGuestUser(String browser, String version, String os, Method method) throws Exception {
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.homePage().moveToSubCategoryPage();
		pageManager.headerServicesPage().clickHeaderServicesLinkText();
		pageManager.headerServicesPage().clickHeaderServicesCustomProductsLinkText();
		pageManager.headerServicesPage().clickHeaderServicesOrderFormsLinkText();
		Assert.assertTrue(pageManager.homePage().customProductsText.isDisplayed());

	}
	
}	


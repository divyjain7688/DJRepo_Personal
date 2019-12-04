package com.selenium.ebiz.subscribtion;
import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class ValidateSubscribtionBreadcrumbs extends BaseClassV8_ParallelGrid{
	/**
	 * @author Bino Jayasingh
	 * Mapped with W80-8473
	 * This test will verify the breadcrumb in the Subscription page after login
	 */	
	@Test(dataProvider = "browsers")
	public void subscription_verifySubscriptionbreadcrums(String browser, String version, String os, Method method) throws Exception{
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
		pageManager.homePage().clickMyAccountSubscriptionsQuickLink();
		String breadcrumbname = pageManager.subscriptionsPage().getSubscriptionspagebreadcrumbText();
		Assert.assertEquals(breadcrumbname, "Subscription Lists");
		
	}
	
	/**
	 * @author Bino Jayasingh
	 * Mapped with W80-8473
	 * This test will verify the Subscription page breadcrumb navigation back to Home page
	 */	
	@Test(dataProvider = "browsers")
	public void subscription_verifyBreadcrumbnavigatebacktoHome(String browser, String version, String os, Method method) throws Exception{
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
		pageManager.homePage().clickMyAccountSubscriptionsQuickLink();
		pageManager.homePage().clickBreadCrumbHomeLinkText();
		Assert.assertTrue((pageManager.homePage().isDisplayedCategoryleftNavigation()));		
	}	
}

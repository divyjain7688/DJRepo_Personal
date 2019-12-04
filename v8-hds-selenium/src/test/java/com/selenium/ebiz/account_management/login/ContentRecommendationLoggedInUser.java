package com.selenium.ebiz.account_management.login;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class ContentRecommendationLoggedInUser extends BaseClassV8_ParallelGrid {

	/**
	 * To verify as Authenticated User I want to view the User Content Recommendations which displays recommended 
	 * product content to the user. 
	 * 
	 * 
	 * US-Cat-1110
	 * 
	 * */

	//Modified: Bhavani - 08/30/19 Uncommented line 31 and updated line 32 method in HomePage 
	@Test(description="verifyContentRecommandationForAuthenticatedUser", dataProvider = "browsers")
	public void login_verifyContentRecommandationForAuthenticatedUser(String browser, String version, String os, Method method) throws Exception {
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		
        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
		Assert.assertTrue(pageManager.homePage().isYourTopCategoriesCarouselSection());
		Assert.assertTrue(pageManager.homePage().isDisplayedOrderAgainContentRecommandation());
	}

}

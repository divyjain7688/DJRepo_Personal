/**
 * 
 * @author suresh
 * 
 * This test will verify about the Display HD Logo in Header
 * 
 * 
 * This Test Script is Mapped to US-Cat-964
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

public class HeaderVerifyHDLogo extends BaseClassV8_ParallelGrid{

	/**
	 *  This is to check HD logo and then move to subCategory and then click on HD Logo to come back to homepage
	 *  Iuliia 8/21/2019 Rerun on stage, no issues found.
	 */	

	@Test(dataProvider = "browsers")
	public void header_verifyHDLogoAuthenticateUserTest(String browser, String version, String os, Method method) throws Exception{
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
		boolean isDisplayedHeaderHDLogoImage = pageManager.homePage().isDisplayedHeaderHDLogoImage();
		pageManager.homePage().moveToSubCategoryPage();
		pageManager.homePage().clickOnHDSupplyLogoInHeader();
		Assert.assertTrue(pageManager.homePage().isDisplayedLeftNavgation());
		Assert.assertTrue(isDisplayedHeaderHDLogoImage);
	}
}


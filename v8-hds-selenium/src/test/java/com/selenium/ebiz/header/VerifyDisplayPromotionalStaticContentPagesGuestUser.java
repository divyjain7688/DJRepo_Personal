package com.selenium.ebiz.header;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.tools.PageManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;


public class VerifyDisplayPromotionalStaticContentPagesGuestUser extends BaseClassV8_ParallelGrid {

	public String newListName="List_";
	/**
	 * 
	 * @author Neha Dev
	 * Display Static Content Pages for guest User
	 * This Test script is mapped to US-Cat-870
	 * @throws Exception 
	 * 
	 */
	@Test(dataProvider = "browsers")
	public void header_VerifyPromotionalStaticContentPageGuestUser(String browser, String version, String os, Method method) throws Exception
	{
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		Assert.assertTrue(pageManager.homePage().isDisplayedPromotionalContent());

	}	   

}



package com.selenium.ebiz.email_and_print_pages;

import com.selenium.ebiz.baseclass.BaseClassV8_Parallel;
import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class printPageTest_notCompleted extends BaseClassV8_ParallelGrid {


	/**
	 * verify print a page - Click the Print link will bring up the browser print dialog box
	 * This Test script is mapped to US-Cat-152
	 *  Reviewed and modified by Bhavani
	 */
	
	@Test(dataProvider = "browsers",enabled = false)
	public void printPage_verifyPrintPage(String browser, String version, String os, Method method) throws Exception {
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
		pageManager.homePage().clickQuotesUtilityBar();
	//	pageManager.quoteListsPage().clickOnFirstQuoteName();
	//	pageManager.quotesPriceDetailPage().isDisplayedPriceQuoteTitle();
		Log.info(driver.getWindowHandle());
		pageManager.commonPageObjects().printIcon.click();
		pageManager.wait();
		Log.info(driver.getWindowHandle());
	//	pageManager.CommonPageObjects().getShadowRootElement(pageManager.CommonPageObjects().printTextOnPrintPage);
	}
	
	
	
	

	
}

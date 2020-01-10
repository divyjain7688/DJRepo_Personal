package com.selenium.ebiz.static_links;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.selenium.ebiz.baseclass.BaseClass;
import com.selenium.ebiz.pageobject.HomePage;
import com.selenium.ebiz.pageobject.LoginPage;

public class Error500Page extends BaseClass {

	HomePage homePage;
	LoginPage loginPage;

	@BeforeMethod	
	public void driverSetup() throws MalformedURLException {
		driver= initialize();

	}	

	/**
	 * @author Smitha
	 * US-Acct-360 - User will see Error 500 - Internal Server Error when something has gone wrong at server side
	 */

	@Test
	public void verify500ErrorPage() throws Exception {
		String pageSource = driver.getPageSource();
		System.out.println("error=" +pageSource );
		Assert.assertTrue(pageSource.contains("500 Internal Server Error"));
	}	


}	






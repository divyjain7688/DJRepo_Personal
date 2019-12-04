package com.crm.qa;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest(){
		super();
	}
	
	@BeforeTest
	public void setUp(){
		initialization();
		loginPage = new LoginPage();	
	}
	
	@Test/*(retryAnalyzer=analyzer.RetryAnalyzer.class)*/
	public void loginPageTitleTest(){
		String title = loginPage.validateLoginPageTitle();
		log.info("title is ------------------->" + title);
		Assert.assertEquals(title, "Free test CRM #1 cloud software for any business large or small");
	}
	
	@Test
	public void crmLogoImageTest(){
		boolean flag = loginPage.validateCRMImage();
		Assert.assertTrue(flag);
	}
	
/*	@Test(priority=3)
	public void loginTest(){
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	*/
	
	
	@AfterTest
	public void tearDown(){
		driver.quit();
	}
	
	
	
	

}

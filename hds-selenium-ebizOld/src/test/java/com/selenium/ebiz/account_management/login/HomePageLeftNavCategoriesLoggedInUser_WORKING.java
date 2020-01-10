package com.selenium.ebiz.account_management.login;

/**
 * 
 * @author nm064123
 */
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.selenium.ebiz.baseclass.BaseClass;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.dbcon.DBCon;
import com.selenium.ebiz.pageobject.HomePage;
import com.selenium.ebiz.pageobject.LoginPage;
import com.selenium.ebiz.tools.WaitTool;

public class HomePageLeftNavCategoriesLoggedInUser_WORKING extends BaseClass{
	ArrayList<UsersListBean> usersList;
	DBCon dbConnection = new DBCon();
	HomePage homePage;
	LoginPage	loginPage;

	@BeforeMethod
	public void initializeDriver() throws MalformedURLException, Exception
	{
		driver = initialize();
		loginPage = new LoginPage(driver);
		homePage = loginPage.loginToHdSupplySite(prop.getProperty("username"), prop.getProperty("password"));
	}


	/**
	 * @author nm064123
	 * @Story : US-Cat-251: Display Top Level Categories as Left Nav List on Home Page - Authenticated User
	 * 
	 * 
	 */
	@Test
	public void leftNavCategoryValidation() throws Exception
	{
		WebElement leftNavCategoryLinks = driver.findElement(By.xpath("//*[starts-with(@id,'categoryFacetList')]"));
		List<WebElement> leftNavCategoryLinksList = leftNavCategoryLinks.findElements(By.tagName("li"));
		System.out.println("leftNavCategoryLinksList issssssss"+ leftNavCategoryLinksList);
		usersList = dbConnection.loadDataFromExcel("leftNavCategoryValidation", "HomePageLeftNav");

		for (int i = 0; i < leftNavCategoryLinksList.size(); i++) {
			int ListNo = i+1;
			WebElement leftNavCategoryName = driver.findElement(By.xpath("//*[starts-with(@id,'categoryFacetList')]/li["+ListNo+"]"));
			String leftNavCategoryNameValue = leftNavCategoryName.getText(); 
			UsersListBean users = usersList.get(i);
			String leftNavCatNameExcel=users.getleftNavCategoryName();
			String leftNavCatUrlExcel = users.getleftNavCategoryPageURL();
			String leftNavCatPageTitleExcel = users.getleftNavCategoryPageTitle();
			Assert.assertEquals(leftNavCategoryNameValue, leftNavCatNameExcel);
			leftNavCategoryName.click();
			WaitTool.hardWait();
			String leftNavCategoryURL = driver.getCurrentUrl();
			Assert.assertTrue(leftNavCategoryURL.contains(leftNavCatUrlExcel));
			String leftNavCategoryPageTitle = driver.getTitle();
			Assert.assertEquals(leftNavCategoryPageTitle, leftNavCatPageTitleExcel);
			driver.navigate().back();			
		}
	}

}

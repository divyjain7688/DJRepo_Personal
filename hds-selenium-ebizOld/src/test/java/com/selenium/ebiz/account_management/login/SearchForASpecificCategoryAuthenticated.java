/**
 * @author nm064123
 */

package com.selenium.ebiz.account_management.login;

import java.net.MalformedURLException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.selenium.ebiz.baseclass.BaseClass;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.dbcon.DBCon;
import com.selenium.ebiz.pageobject.HomePage;
import com.selenium.ebiz.pageobject.LoginPage;
import com.selenium.ebiz.tools.WaitTool;

public class SearchForASpecificCategoryAuthenticated extends BaseClass{

	ArrayList<UsersListBean> usersList;
	DBCon dbConnection = new DBCon();
	HomePage homePage;
	LoginPage	loginPage;

	@BeforeMethod
	public void driverInitialize() throws MalformedURLException, Exception {
		driver = initialize();
		loginPage = new LoginPage(driver);
		homePage = loginPage.loginToHdSupplySite(prop.getProperty("username"), prop.getProperty("password"));
	}

	/**
	 * Story : US-Cat-250: Display Category Page
	 * A user searches for a specific category
	 * @throws Exception 
	 * 
	 */
	@Test
	public void validateCategoryPageBySearch() throws Exception {

		WaitTool.hardWait();
		usersList = dbConnection.loadDataFromExcel("leftNavCategoryValidation", "CategorySearch");

		for (int i=0; i<=usersList.size(); i++) {
			UsersListBean users = usersList.get(i);
			String SearchCatNameExcel=users.getSearchCategoryName();
			String SearchCatUrlExcel = users.getSearchCategoryPageURL();
			String SearchCatPageTitleExcel = users.getSearchCategoryPageTitle();
			homePage.searchByCategoryName(SearchCatNameExcel);
			WaitTool.hardWait2sec();
			String SearchCatClickURL = driver.getCurrentUrl();
			String SearchCatClickPageTitle = driver.getTitle();
			String SearchCatClickName = driver.findElement(By.xpath("//h1[contains(text(),'"+SearchCatNameExcel+"')]")).getText();
			Assert.assertEquals(SearchCatClickPageTitle, SearchCatPageTitleExcel);
			Assert.assertTrue(SearchCatClickURL.contains(SearchCatUrlExcel));
			/*	System.out.println("ExcelFileCatName   :   " +SearchCatNameExcel + "   "+ "SearchCatClickName   :" +SearchCatClickName  );
				System.out.println("SearchCatUrlExcel   :   " +SearchCatUrlExcel + "   "+ "SearchCatClickURL   :" +SearchCatClickURL  );
				System.out.println("SearchCatPageTitleExcel   :   " +SearchCatPageTitleExcel + "   "+ "SearchCatClickPageTitle   :" +SearchCatClickPageTitle  );
			*/
			driver.navigate().back();
			WaitTool.hardWait();
		} 			

	}

}

package com.selenium.ebiz.header;

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
import com.selenium.ebiz.tools.WaitTool;

public class HeaderShopByCategory_WORKING  extends BaseClass{
	ArrayList<UsersListBean> usersList;
	DBCon dbConnection = new DBCon();
	HomePage homePage;

	@BeforeMethod
	public void driverSetup() throws MalformedURLException{
		initialize();
	}

	@Test(priority=0)
	public void clickOnDoorAndMouldingLinks() throws Exception{
		// Getting the Data from the input Data			
		usersList = dbConnection.loadDataFromExcel("clickOnDoorAndMouldingLinks","HDSTestdata");
		homePage = new HomePage(driver);
		// clicking on the ShopBy Category Link
		homePage.clickHeaderShopByCategoryLinkText();
		// Getting all the list of Shop By Category
		List<WebElement> categoriesAllLinks = driver.findElements(By.xpath("//div[@id='headerRow1']/div/section/div/nav/div/div/ul/li/a"));
		System.out.println("categoriesAllLinks:"+categoriesAllLinks.size());
		for(int i=0 ; i<categoriesAllLinks.size() ; i++)
		{
			// comparing from the inputsheet and from the list
			System.out.println("Categories :" +categoriesAllLinks.get(i).getText());
			if(categoriesAllLinks.get(i).getText().equalsIgnoreCase(usersList.get(0).getCategory())) {	
				System.out.println("Categories" +categoriesAllLinks.get(i).getText());
				WaitTool.waitForElement(driver, categoriesAllLinks.get(i));
				// clicking on the links
				categoriesAllLinks.get(i).click();
				WaitTool.waitFor(driver, true);
				// Getting the list of elements from L2 Categories
				List<WebElement> topcategoriesAllLinks = driver.findElements(By.xpath("//div[@id='headerRow1']/div/section/div/nav/div/div/ul/li[@class='flyout-nav__li--selected']/div/div/ul/li/a"));

				for(int j=0 ; j<topcategoriesAllLinks.size() ; j++) {

					WaitTool.waitForElement(driver, topcategoriesAllLinks.get(j));
					//  clicking on L2 links
					topcategoriesAllLinks.get(j).click();
					WaitTool.waitFor(driver, true);
					// Getting the list from L3 Categories
					List <WebElement> subcategoriesAllLinks = driver.findElements(By.xpath(" //div[@id='headerRow1']/div/section/div/nav/div/div/ul/li/div/div/ul/li[@class='flyout-nav__li--selected']/div/div/ul/li/a"));

					if(subcategoriesAllLinks.size() != 0){
						for(int k=0 ; k<subcategoriesAllLinks.size() ; k++) {
							WaitTool.waitForElement(driver, subcategoriesAllLinks.get(k));
							String subCategory = subcategoriesAllLinks.get(k).getText();
							// Clicking on the L3 Link
							subcategoriesAllLinks.get(k).click();
							WaitTool.waitFor(driver, true);
							// Verifying the Selected Product with the displayed product
							Assert.assertTrue(homePage.getCategoryPageHeadingText().equalsIgnoreCase(subCategory));

							// Clicking on the Shop By Category header
							homePage.clickHeaderShopByCategoryLinkText();
							categoriesAllLinks = driver.findElements(By.xpath("//div[@id='headerRow1']/div/section/div/nav/div/div/ul/li/a"));
							categoriesAllLinks.get(i).click();
							WaitTool.waitFor(driver, true);
							topcategoriesAllLinks = driver.findElements(By.xpath("//div[@id='headerRow1']/div/section/div/nav/div/div/ul/li[@class='flyout-nav__li--selected']/div/div/ul/li/a"));
							topcategoriesAllLinks.get(j).click();
							WaitTool.waitFor(driver, true);
							subcategoriesAllLinks = driver.findElements(By.xpath(" //div[@id='headerRow1']/div/section/div/nav/div/div/ul/li/div/div/ul/li[@class='flyout-nav__li--selected']/div/div/ul/li/a"));
						}

					}else {

						break;
					}

					subcategoriesAllLinks = driver.findElements(By.xpath(" //div[@id='headerRow1']/div/section/div/nav/div/div/ul/li/div/div/ul/li[@class='flyout-nav__li--selected']/div/div/ul/li/a"));
				}

				topcategoriesAllLinks = driver.findElements(By.xpath("//div[@id='headerRow1']/div/section/div/nav/div/div/ul/li[@class='flyout-nav__li--selected']/div/div/ul/li/a"));
			}
		}
		categoriesAllLinks = driver.findElements(By.xpath("//div[@id='headerRow1']/div/section/div/nav/div/div/ul/li/a"));

	} 


	@Test(priority=1)
	public void clickOnElectricalLinks() throws Exception{
		// Getting the Data from the input Data			
		usersList = dbConnection.loadDataFromExcel("clickOnElectricalLinks","HDSTestdata");
		homePage = new HomePage(driver);
		// clicking on the ShopBy Category Link
		homePage.clickHeaderShopByCategoryLinkText();
		// Getting all the list of Shop By Cateogry
		List<WebElement> categoriesAllLinks = driver.findElements(By.xpath("//div[@id='headerRow1']/div/section/div/nav/div/div/ul/li/a"));

		for(int i=0 ; i<categoriesAllLinks.size() ; i++)
		{
			// comparing from the inputsheet and from the list
			if(categoriesAllLinks.get(i).getText().equalsIgnoreCase(usersList.get(0).getCategory())) {	
				// System.out.println("Categories" +categoriesAllLinks.get(i).getText());
				WaitTool.waitForElement(driver, categoriesAllLinks.get(i));
				// clicking on the links
				categoriesAllLinks.get(i).click();
				WaitTool.waitFor(driver, true);
				// Getting the list of elements from L2 Categories
				List<WebElement> topcategoriesAllLinks = driver.findElements(By.xpath("//div[@id='headerRow1']/div/section/div/nav/div/div/ul/li[@class='flyout-nav__li--selected']/div/div/ul/li/a"));


				for(int j=0 ; j<topcategoriesAllLinks.size() ; j++) {

					WaitTool.waitForElement(driver, topcategoriesAllLinks.get(j));
					//  clicking on L2 links
					topcategoriesAllLinks.get(j).click();
					WaitTool.waitFor(driver, true);
					// Getting the list from L3 Categories
					List <WebElement> subcategoriesAllLinks = driver.findElements(By.xpath(" //div[@id='headerRow1']/div/section/div/nav/div/div/ul/li/div/div/ul/li[@class='flyout-nav__li--selected']/div/div/ul/li/a"));

					if(subcategoriesAllLinks.size() != 0){
						for(int k=0 ; k<subcategoriesAllLinks.size() ; k++) {
							WaitTool.waitForElement(driver, subcategoriesAllLinks.get(k));
							String subCategory = subcategoriesAllLinks.get(k).getText();
							// Clicking on the L3 Link
							subcategoriesAllLinks.get(k).click();
							WaitTool.waitFor(driver, true);
							// Verifying the Selected Product with the displayed product
							Assert.assertTrue(homePage.getCategoryPageHeadingText().equalsIgnoreCase(subCategory));

							// Clicking on the Shop By Category header
							homePage.clickHeaderShopByCategoryLinkText();
							categoriesAllLinks = driver.findElements(By.xpath("//div[@id='headerRow1']/div/section/div/nav/div/div/ul/li/a"));
							categoriesAllLinks.get(i).click();
							WaitTool.waitFor(driver, true);
							topcategoriesAllLinks = driver.findElements(By.xpath("//div[@id='headerRow1']/div/section/div/nav/div/div/ul/li[@class='flyout-nav__li--selected']/div/div/ul/li/a"));
							topcategoriesAllLinks.get(j).click();
							WaitTool.waitFor(driver, true);
							subcategoriesAllLinks = driver.findElements(By.xpath(" //div[@id='headerRow1']/div/section/div/nav/div/div/ul/li/div/div/ul/li[@class='flyout-nav__li--selected']/div/div/ul/li/a"));
						}

					}else {

						break;
					}

					subcategoriesAllLinks = driver.findElements(By.xpath(" //div[@id='headerRow1']/div/section/div/nav/div/div/ul/li/div/div/ul/li[@class='flyout-nav__li--selected']/div/div/ul/li/a"));
				}

				topcategoriesAllLinks = driver.findElements(By.xpath("//div[@id='headerRow1']/div/section/div/nav/div/div/ul/li[@class='flyout-nav__li--selected']/div/div/ul/li/a"));
			}
		}
		categoriesAllLinks = driver.findElements(By.xpath("//div[@id='headerRow1']/div/section/div/nav/div/div/ul/li/a"));

	} 


	@Test(priority=2)
	public void clickOnFlooringCeilingLinks() throws Exception{
		// Getting the Data from the input Data			
		usersList = dbConnection.loadDataFromExcel("clickOnFlooringCeilingLinks","HDSTestdata");
		homePage = new HomePage(driver);
		// clicking on the ShopBy Category Link
		homePage.clickHeaderShopByCategoryLinkText();
		// Getting all the list of Shop By Cateogry
		List<WebElement> categoriesAllLinks = driver.findElements(By.xpath("//div[@id='headerRow1']/div/section/div/nav/div/div/ul/li/a"));

		for(int i=0 ; i<categoriesAllLinks.size() ; i++)
		{
			// comparing from the inputsheet and from the list
			if(categoriesAllLinks.get(i).getText().equalsIgnoreCase(usersList.get(0).getCategory())) {	
				// System.out.println("Categories" +categoriesAllLinks.get(i).getText());
				WaitTool.waitForElement(driver, categoriesAllLinks.get(i));
				// clicking on the links
				categoriesAllLinks.get(i).click();
				WaitTool.waitFor(driver, true);
				// Getting the list of elements from L2 Categories
				List<WebElement> topcategoriesAllLinks = driver.findElements(By.xpath("//div[@id='headerRow1']/div/section/div/nav/div/div/ul/li[@class='flyout-nav__li--selected']/div/div/ul/li/a"));


				for(int j=0 ; j<topcategoriesAllLinks.size() ; j++) {

					WaitTool.waitForElement(driver, topcategoriesAllLinks.get(j));
					//  clicking on L2 links
					topcategoriesAllLinks.get(j).click();
					WaitTool.waitFor(driver, true);
					// Getting the list from L3 Categories
					List <WebElement> subcategoriesAllLinks = driver.findElements(By.xpath(" //div[@id='headerRow1']/div/section/div/nav/div/div/ul/li/div/div/ul/li[@class='flyout-nav__li--selected']/div/div/ul/li/a"));

					if(subcategoriesAllLinks.size() != 0){
						for(int k=0 ; k<subcategoriesAllLinks.size() ; k++) {
							WaitTool.waitForElement(driver, subcategoriesAllLinks.get(k));
							String subCategory = subcategoriesAllLinks.get(k).getText();
							// Clicking on the L3 Link
							subcategoriesAllLinks.get(k).click();
							WaitTool.waitFor(driver, true);
							// Verifying the Selected Product with the displayed product
							Assert.assertTrue(homePage.getCategoryPageHeadingText().equalsIgnoreCase(subCategory));

							// Clicking on the Shop By Category header
							homePage.clickHeaderShopByCategoryLinkText();
							categoriesAllLinks = driver.findElements(By.xpath("//div[@id='headerRow1']/div/section/div/nav/div/div/ul/li/a"));
							categoriesAllLinks.get(i).click();
							WaitTool.waitFor(driver, true);
							topcategoriesAllLinks = driver.findElements(By.xpath("//div[@id='headerRow1']/div/section/div/nav/div/div/ul/li[@class='flyout-nav__li--selected']/div/div/ul/li/a"));
							topcategoriesAllLinks.get(j).click();
							WaitTool.waitFor(driver, true);
							subcategoriesAllLinks = driver.findElements(By.xpath(" //div[@id='headerRow1']/div/section/div/nav/div/div/ul/li/div/div/ul/li[@class='flyout-nav__li--selected']/div/div/ul/li/a"));
						}

					}else {

						break;
					}

					subcategoriesAllLinks = driver.findElements(By.xpath(" //div[@id='headerRow1']/div/section/div/nav/div/div/ul/li/div/div/ul/li[@class='flyout-nav__li--selected']/div/div/ul/li/a"));
				}

				topcategoriesAllLinks = driver.findElements(By.xpath("//div[@id='headerRow1']/div/section/div/nav/div/div/ul/li[@class='flyout-nav__li--selected']/div/div/ul/li/a"));
			}
		}
		categoriesAllLinks = driver.findElements(By.xpath("//div[@id='headerRow1']/div/section/div/nav/div/div/ul/li/a"));

	} 


	@Test(priority=3)
	public void clickOnHealthcareSuppliesLinks() throws Exception{
		// Getting the Data from the input Data			
		usersList = dbConnection.loadDataFromExcel("clickOnHealthcareSuppliesLinks","HDSTestdata");
		homePage = new HomePage(driver);
		// clicking on the ShopBy Category Link
		homePage.clickHeaderShopByCategoryLinkText();
		// Getting all the list of Shop By Cateogry
		List<WebElement> categoriesAllLinks = driver.findElements(By.xpath("//div[@id='headerRow1']/div/section/div/nav/div/div/ul/li/a"));

		for(int i=0 ; i<categoriesAllLinks.size() ; i++)
		{
			// comparing from the inputsheet and from the list
			if(categoriesAllLinks.get(i).getText().equalsIgnoreCase(usersList.get(0).getCategory())) {	
				// System.out.println("Categories" +categoriesAllLinks.get(i).getText());
				WaitTool.waitForElement(driver, categoriesAllLinks.get(i));
				// clicking on the links
				categoriesAllLinks.get(i).click();
				WaitTool.waitFor(driver, true);
				// Getting the list of elements from L2 Categories
				List<WebElement> topcategoriesAllLinks = driver.findElements(By.xpath("//div[@id='headerRow1']/div/section/div/nav/div/div/ul/li[@class='flyout-nav__li--selected']/div/div/ul/li/a"));


				for(int j=0 ; j<topcategoriesAllLinks.size() ; j++) {

					WaitTool.waitForElement(driver, topcategoriesAllLinks.get(j));
					//  clicking on L2 links
					topcategoriesAllLinks.get(j).click();
					WaitTool.waitFor(driver, true);
					// Getting the list from L3 Categories
					List <WebElement> subcategoriesAllLinks = driver.findElements(By.xpath(" //div[@id='headerRow1']/div/section/div/nav/div/div/ul/li/div/div/ul/li[@class='flyout-nav__li--selected']/div/div/ul/li/a"));

					if(subcategoriesAllLinks.size() != 0){
						for(int k=0 ; k<subcategoriesAllLinks.size() ; k++) {
							WaitTool.waitForElement(driver, subcategoriesAllLinks.get(k));
							String subCategory = subcategoriesAllLinks.get(k).getText();
							// Clicking on the L3 Link
							subcategoriesAllLinks.get(k).click();
							WaitTool.waitFor(driver, true);
							// Verifying the Selected Product with the displayed product
							Assert.assertTrue(homePage.getCategoryPageHeadingText().equalsIgnoreCase(subCategory));

							// Clicking on the Shop By Category header
							homePage.clickHeaderShopByCategoryLinkText();
							categoriesAllLinks = driver.findElements(By.xpath("//div[@id='headerRow1']/div/section/div/nav/div/div/ul/li/a"));
							categoriesAllLinks.get(i).click();
							WaitTool.waitFor(driver, true);
							topcategoriesAllLinks = driver.findElements(By.xpath("//div[@id='headerRow1']/div/section/div/nav/div/div/ul/li[@class='flyout-nav__li--selected']/div/div/ul/li/a"));
							topcategoriesAllLinks.get(j).click();
							WaitTool.waitFor(driver, true);
							subcategoriesAllLinks = driver.findElements(By.xpath(" //div[@id='headerRow1']/div/section/div/nav/div/div/ul/li/div/div/ul/li[@class='flyout-nav__li--selected']/div/div/ul/li/a"));
						}

					}else {

						break;
					}

					subcategoriesAllLinks = driver.findElements(By.xpath(" //div[@id='headerRow1']/div/section/div/nav/div/div/ul/li/div/div/ul/li[@class='flyout-nav__li--selected']/div/div/ul/li/a"));
				}

				topcategoriesAllLinks = driver.findElements(By.xpath("//div[@id='headerRow1']/div/section/div/nav/div/div/ul/li[@class='flyout-nav__li--selected']/div/div/ul/li/a"));
			}
		}
		categoriesAllLinks = driver.findElements(By.xpath("//div[@id='headerRow1']/div/section/div/nav/div/div/ul/li/a"));

	} 


	@Test(priority=4)
	public void clickOnHospitalitySuppliesLinks() throws Exception{
		// Getting the Data from the input Data			
		usersList = dbConnection.loadDataFromExcel("clickOnHospitalitySuppliesLinks","HDSTestdata");
		homePage = new HomePage(driver);
		// clicking on the ShopBy Category Link
		homePage.clickHeaderShopByCategoryLinkText();
		// Getting all the list of Shop By Cateogry
		List<WebElement> categoriesAllLinks = driver.findElements(By.xpath("//div[@id='headerRow1']/div/section/div/nav/div/div/ul/li/a"));

		for(int i=0 ; i<categoriesAllLinks.size() ; i++)
		{
			// comparing from the inputsheet and from the list
			if(categoriesAllLinks.get(i).getText().equalsIgnoreCase(usersList.get(0).getCategory())) {	
				// System.out.println("Categories" +categoriesAllLinks.get(i).getText());
				WaitTool.waitForElement(driver, categoriesAllLinks.get(i));
				// clicking on the links
				categoriesAllLinks.get(i).click();
				WaitTool.waitFor(driver, true);
				// Getting the list of elements from L2 Categories
				List<WebElement> topcategoriesAllLinks = driver.findElements(By.xpath("//div[@id='headerRow1']/div/section/div/nav/div/div/ul/li[@class='flyout-nav__li--selected']/div/div/ul/li/a"));


				for(int j=0 ; j<topcategoriesAllLinks.size() ; j++) {

					WaitTool.waitForElement(driver, topcategoriesAllLinks.get(j));
					//  clicking on L2 links
					topcategoriesAllLinks.get(j).click();
					WaitTool.waitFor(driver, true);
					// Getting the list from L3 Categories
					List <WebElement> subcategoriesAllLinks = driver.findElements(By.xpath(" //div[@id='headerRow1']/div/section/div/nav/div/div/ul/li/div/div/ul/li[@class='flyout-nav__li--selected']/div/div/ul/li/a"));

					if(subcategoriesAllLinks.size() != 0){
						for(int k=0 ; k<subcategoriesAllLinks.size() ; k++) {
							WaitTool.waitForElement(driver, subcategoriesAllLinks.get(k));
							String subCategory = subcategoriesAllLinks.get(k).getText();
							// Clicking on the L3 Link
							subcategoriesAllLinks.get(k).click();
							WaitTool.waitFor(driver, true);
							// Verifying the Selected Product with the displayed product
							Assert.assertTrue(homePage.getCategoryPageHeadingText().equalsIgnoreCase(subCategory));

							// Clicking on the Shop By Category header
							homePage.clickHeaderShopByCategoryLinkText();
							categoriesAllLinks = driver.findElements(By.xpath("//div[@id='headerRow1']/div/section/div/nav/div/div/ul/li/a"));
							categoriesAllLinks.get(i).click();
							WaitTool.waitFor(driver, true);
							topcategoriesAllLinks = driver.findElements(By.xpath("//div[@id='headerRow1']/div/section/div/nav/div/div/ul/li[@class='flyout-nav__li--selected']/div/div/ul/li/a"));
							topcategoriesAllLinks.get(j).click();
							WaitTool.waitFor(driver, true);
							subcategoriesAllLinks = driver.findElements(By.xpath(" //div[@id='headerRow1']/div/section/div/nav/div/div/ul/li/div/div/ul/li[@class='flyout-nav__li--selected']/div/div/ul/li/a"));
						}

					}else {

						break;
					}

					subcategoriesAllLinks = driver.findElements(By.xpath(" //div[@id='headerRow1']/div/section/div/nav/div/div/ul/li/div/div/ul/li[@class='flyout-nav__li--selected']/div/div/ul/li/a"));
				}

				topcategoriesAllLinks = driver.findElements(By.xpath("//div[@id='headerRow1']/div/section/div/nav/div/div/ul/li[@class='flyout-nav__li--selected']/div/div/ul/li/a"));
			}
		}
		categoriesAllLinks = driver.findElements(By.xpath("//div[@id='headerRow1']/div/section/div/nav/div/div/ul/li/a"));

	} 


	@Test(priority=5)
	public void clickOnHVACLinks() throws Exception{
		// Getting the Data from the input Data			
		usersList = dbConnection.loadDataFromExcel("clickOnHVACLinks","HDSTestdata");
		homePage = new HomePage(driver);
		// clicking on the ShopBy Category Link
		homePage.clickHeaderShopByCategoryLinkText();
		// Getting all the list of Shop By Cateogry
		List<WebElement> categoriesAllLinks = driver.findElements(By.xpath("//div[@id='headerRow1']/div/section/div/nav/div/div/ul/li/a"));

		for(int i=0 ; i<categoriesAllLinks.size() ; i++)
		{
			// comparing from the inputsheet and from the list
			if(categoriesAllLinks.get(i).getText().equalsIgnoreCase(usersList.get(0).getCategory())) {	
				// System.out.println("Categories" +categoriesAllLinks.get(i).getText());
				WaitTool.waitForElement(driver, categoriesAllLinks.get(i));
				// clicking on the links
				categoriesAllLinks.get(i).click();
				WaitTool.waitFor(driver, true);
				// Getting the list of elements from L2 Categories
				List<WebElement> topcategoriesAllLinks = driver.findElements(By.xpath("//div[@id='headerRow1']/div/section/div/nav/div/div/ul/li[@class='flyout-nav__li--selected']/div/div/ul/li/a"));


				for(int j=0 ; j<topcategoriesAllLinks.size() ; j++) {

					WaitTool.waitForElement(driver, topcategoriesAllLinks.get(j));
					//  clicking on L2 links
					topcategoriesAllLinks.get(j).click();
					WaitTool.waitFor(driver, true);
					// Getting the list from L3 Categories
					List <WebElement> subcategoriesAllLinks = driver.findElements(By.xpath(" //div[@id='headerRow1']/div/section/div/nav/div/div/ul/li/div/div/ul/li[@class='flyout-nav__li--selected']/div/div/ul/li/a"));

					if(subcategoriesAllLinks.size() != 0){
						for(int k=0 ; k<subcategoriesAllLinks.size() ; k++) {
							WaitTool.waitForElement(driver, subcategoriesAllLinks.get(k));
							String subCategory = subcategoriesAllLinks.get(k).getText();
							// Clicking on the L3 Link
							subcategoriesAllLinks.get(k).click();
							WaitTool.waitFor(driver, true);
							// Verifying the Selected Product with the displayed product
							Assert.assertTrue(homePage.getCategoryPageHeadingText().equalsIgnoreCase(subCategory));

							// Clicking on the Shop By Category header
							homePage.clickHeaderShopByCategoryLinkText();
							categoriesAllLinks = driver.findElements(By.xpath("//div[@id='headerRow1']/div/section/div/nav/div/div/ul/li/a"));
							categoriesAllLinks.get(i).click();
							WaitTool.waitFor(driver, true);
							topcategoriesAllLinks = driver.findElements(By.xpath("//div[@id='headerRow1']/div/section/div/nav/div/div/ul/li[@class='flyout-nav__li--selected']/div/div/ul/li/a"));
							topcategoriesAllLinks.get(j).click();
							WaitTool.waitFor(driver, true);
							subcategoriesAllLinks = driver.findElements(By.xpath(" //div[@id='headerRow1']/div/section/div/nav/div/div/ul/li/div/div/ul/li[@class='flyout-nav__li--selected']/div/div/ul/li/a"));
						}

					}else {

						break;
					}

					subcategoriesAllLinks = driver.findElements(By.xpath(" //div[@id='headerRow1']/div/section/div/nav/div/div/ul/li/div/div/ul/li[@class='flyout-nav__li--selected']/div/div/ul/li/a"));
				}

				topcategoriesAllLinks = driver.findElements(By.xpath("//div[@id='headerRow1']/div/section/div/nav/div/div/ul/li[@class='flyout-nav__li--selected']/div/div/ul/li/a"));
			}
		}
		categoriesAllLinks = driver.findElements(By.xpath("//div[@id='headerRow1']/div/section/div/nav/div/div/ul/li/a"));

	} 


	@Test(priority=6)
	public void clickOnJanitorialLinks() throws Exception{
		// Getting the Data from the input Data			
		usersList = dbConnection.loadDataFromExcel("clickOnJanitorialLinks","HDSTestdata");
		homePage = new HomePage(driver);
		// clicking on the ShopBy Category Link
		homePage.clickHeaderShopByCategoryLinkText();
		// Getting all the list of Shop By Cateogry
		List<WebElement> categoriesAllLinks = driver.findElements(By.xpath("//div[@id='headerRow1']/div/section/div/nav/div/div/ul/li/a"));

		for(int i=0 ; i<categoriesAllLinks.size() ; i++)
		{
			// comparing from the inputsheet and from the list
			if(categoriesAllLinks.get(i).getText().equalsIgnoreCase(usersList.get(0).getCategory())) {	
				// System.out.println("Categories" +categoriesAllLinks.get(i).getText());
				WaitTool.waitForElement(driver, categoriesAllLinks.get(i));
				// clicking on the links
				categoriesAllLinks.get(i).click();
				WaitTool.waitFor(driver, true);
				// Getting the list of elements from L2 Categories
				List<WebElement> topcategoriesAllLinks = driver.findElements(By.xpath("//div[@id='headerRow1']/div/section/div/nav/div/div/ul/li[@class='flyout-nav__li--selected']/div/div/ul/li/a"));


				for(int j=0 ; j<topcategoriesAllLinks.size() ; j++) {

					WaitTool.waitForElement(driver, topcategoriesAllLinks.get(j));
					//  clicking on L2 links
					topcategoriesAllLinks.get(j).click();
					WaitTool.waitFor(driver, true);
					// Getting the list from L3 Categories
					List <WebElement> subcategoriesAllLinks = driver.findElements(By.xpath(" //div[@id='headerRow1']/div/section/div/nav/div/div/ul/li/div/div/ul/li[@class='flyout-nav__li--selected']/div/div/ul/li/a"));

					if(subcategoriesAllLinks.size() != 0){
						for(int k=0 ; k<subcategoriesAllLinks.size() ; k++) {
							WaitTool.waitForElement(driver, subcategoriesAllLinks.get(k));
							String subCategory = subcategoriesAllLinks.get(k).getText();
							// Clicking on the L3 Link
							subcategoriesAllLinks.get(k).click();
							WaitTool.waitFor(driver, true);
							// Verifying the Selected Product with the displayed product
							Assert.assertTrue(homePage.getCategoryPageHeadingText().equalsIgnoreCase(subCategory));

							// Clicking on the Shop By Category header
							homePage.clickHeaderShopByCategoryLinkText();
							categoriesAllLinks = driver.findElements(By.xpath("//div[@id='headerRow1']/div/section/div/nav/div/div/ul/li/a"));
							categoriesAllLinks.get(i).click();
							WaitTool.waitFor(driver, true);
							topcategoriesAllLinks = driver.findElements(By.xpath("//div[@id='headerRow1']/div/section/div/nav/div/div/ul/li[@class='flyout-nav__li--selected']/div/div/ul/li/a"));
							topcategoriesAllLinks.get(j).click();
							WaitTool.waitFor(driver, true);
							subcategoriesAllLinks = driver.findElements(By.xpath(" //div[@id='headerRow1']/div/section/div/nav/div/div/ul/li/div/div/ul/li[@class='flyout-nav__li--selected']/div/div/ul/li/a"));
						}

					}else {

						break;
					}

					subcategoriesAllLinks = driver.findElements(By.xpath(" //div[@id='headerRow1']/div/section/div/nav/div/div/ul/li/div/div/ul/li[@class='flyout-nav__li--selected']/div/div/ul/li/a"));
				}

				topcategoriesAllLinks = driver.findElements(By.xpath("//div[@id='headerRow1']/div/section/div/nav/div/div/ul/li[@class='flyout-nav__li--selected']/div/div/ul/li/a"));
			}
		}
		categoriesAllLinks = driver.findElements(By.xpath("//div[@id='headerRow1']/div/section/div/nav/div/div/ul/li/a"));

	} 


	@Test(priority=7)
	public void clickOnToolsLinks() throws Exception{
		// Getting the Data from the input Data			
		usersList = dbConnection.loadDataFromExcel("clickOnToolsLinks","HDSTestdata");
		homePage = new HomePage(driver);
		// clicking on the ShopBy Category Link
		homePage.clickHeaderShopByCategoryLinkText();
		// Getting all the list of Shop By Cateogry
		List<WebElement> categoriesAllLinks = driver.findElements(By.xpath("//div[@id='headerRow1']/div/section/div/nav/div/div/ul/li/a"));

		for(int i=0 ; i<categoriesAllLinks.size() ; i++)
		{
			// comparing from the inputsheet and from the list
			if(categoriesAllLinks.get(i).getText().equalsIgnoreCase(usersList.get(0).getCategory())) {	
				// System.out.println("Categories" +categoriesAllLinks.get(i).getText());
				WaitTool.waitForElement(driver, categoriesAllLinks.get(i));
				// clicking on the links
				categoriesAllLinks.get(i).click();
				WaitTool.waitFor(driver, true);
				// Getting the list of elements from L2 Categories
				List<WebElement> topcategoriesAllLinks = driver.findElements(By.xpath("//div[@id='headerRow1']/div/section/div/nav/div/div/ul/li[@class='flyout-nav__li--selected']/div/div/ul/li/a"));


				for(int j=0 ; j<topcategoriesAllLinks.size() ; j++) {

					WaitTool.waitForElement(driver, topcategoriesAllLinks.get(j));
					//  clicking on L2 links
					topcategoriesAllLinks.get(j).click();
					WaitTool.waitFor(driver, true);
					// Getting the list from L3 Categories
					List <WebElement> subcategoriesAllLinks = driver.findElements(By.xpath(" //div[@id='headerRow1']/div/section/div/nav/div/div/ul/li/div/div/ul/li[@class='flyout-nav__li--selected']/div/div/ul/li/a"));

					if(subcategoriesAllLinks.size() != 0){
						for(int k=0 ; k<subcategoriesAllLinks.size() ; k++) {
							WaitTool.waitForElement(driver, subcategoriesAllLinks.get(k));
							String subCategory = subcategoriesAllLinks.get(k).getText();
							// Clicking on the L3 Link
							subcategoriesAllLinks.get(k).click();
							WaitTool.waitFor(driver, true);
							// Verifying the Selected Product with the displayed product
							Assert.assertTrue(homePage.getCategoryPageHeadingText().equalsIgnoreCase(subCategory));

							// Clicking on the Shop By Category header
							homePage.clickHeaderShopByCategoryLinkText();
							categoriesAllLinks = driver.findElements(By.xpath("//div[@id='headerRow1']/div/section/div/nav/div/div/ul/li/a"));
							categoriesAllLinks.get(i).click();
							WaitTool.waitFor(driver, true);
							topcategoriesAllLinks = driver.findElements(By.xpath("//div[@id='headerRow1']/div/section/div/nav/div/div/ul/li[@class='flyout-nav__li--selected']/div/div/ul/li/a"));
							topcategoriesAllLinks.get(j).click();
							WaitTool.waitFor(driver, true);
							subcategoriesAllLinks = driver.findElements(By.xpath(" //div[@id='headerRow1']/div/section/div/nav/div/div/ul/li/div/div/ul/li[@class='flyout-nav__li--selected']/div/div/ul/li/a"));
						}

					}else {

						break;
					}

					subcategoriesAllLinks = driver.findElements(By.xpath(" //div[@id='headerRow1']/div/section/div/nav/div/div/ul/li/div/div/ul/li[@class='flyout-nav__li--selected']/div/div/ul/li/a"));
				}

				topcategoriesAllLinks = driver.findElements(By.xpath("//div[@id='headerRow1']/div/section/div/nav/div/div/ul/li[@class='flyout-nav__li--selected']/div/div/ul/li/a"));
			}
		}
		categoriesAllLinks = driver.findElements(By.xpath("//div[@id='headerRow1']/div/section/div/nav/div/div/ul/li/a"));

	} 



	/**		@Test
	public void clickOnCategoriesAndSubCategoryLinks() throws Exception{
		homePage = new Homepage();

		homePage.clickHeaderShopByCategoryLinkText();
		List<WebElement> categoriesAllLinks = driver.findElements(By.xpath("//div[@id='headerRow1']/div/section/div/nav/div/div/ul/li/a"));

		for(int i=0 ; i<categoriesAllLinks.size() ; i++)
        {


        // System.out.println("Categories" +categoriesAllLinks.get(i).getText());
			WaitTool.waitForElement(driver, categoriesAllLinks.get(i));
			categoriesAllLinks.get(i).click();
			WaitTool.waitFor(driver, true);
			List<WebElement> topcategoriesAllLinks = driver.findElements(By.xpath("//div[@id='headerRow1']/div/section/div/nav/div/div/ul/li[@class='flyout-nav__li--selected']/div/div/ul/li/a"));


			for(int j=0 ; j<topcategoriesAllLinks.size() ; j++) {


		//		System.out.println("Top Categories" +topcategoriesAllLinks.get(j).getText());
				WaitTool.waitForElement(driver, topcategoriesAllLinks.get(j));
				topcategoriesAllLinks.get(j).click();
				WaitTool.waitFor(driver, true);
				List <WebElement> subcategoriesAllLinks = driver.findElements(By.xpath(" //div[@id='headerRow1']/div/section/div/nav/div/div/ul/li/div/div/ul/li[@class='flyout-nav__li--selected']/div/div/ul/li/a"));
				if(subcategoriesAllLinks.size() != 0){
				for(int k=0 ; k<subcategoriesAllLinks.size() ; k++) {
					WaitTool.waitForElement(driver, subcategoriesAllLinks.get(k));
					subcategoriesAllLinks.get(k).click();
					WaitTool.waitFor(driver, true);

				homePage.clickHeaderShopByCategoryLinkText();
				categoriesAllLinks = driver.findElements(By.xpath("//div[@id='headerRow1']/div/section/div/nav/div/div/ul/li/a"));
				categoriesAllLinks.get(i).click();
				WaitTool.waitFor(driver, true);
				topcategoriesAllLinks = driver.findElements(By.xpath("//div[@id='headerRow1']/div/section/div/nav/div/div/ul/li[@class='flyout-nav__li--selected']/div/div/ul/li/a"));
				topcategoriesAllLinks.get(j).click();
				WaitTool.waitFor(driver, true);
				subcategoriesAllLinks = driver.findElements(By.xpath(" //div[@id='headerRow1']/div/section/div/nav/div/div/ul/li/div/div/ul/li[@class='flyout-nav__li--selected']/div/div/ul/li/a"));
				}

				}else {

					break;
				}

				//subcategoriesAllLinks = driver.findElements(By.xpath(" //div[@id='headerRow1']/div/section/div/nav/div/div/ul/li/div/div/ul/li/div/div/ul/li/a"));
				subcategoriesAllLinks = driver.findElements(By.xpath(" //div[@id='headerRow1']/div/section/div/nav/div/div/ul/li/div/div/ul/li[@class='flyout-nav__li--selected']/div/div/ul/li/a"));
			}

			topcategoriesAllLinks = driver.findElements(By.xpath("//div[@id='headerRow1']/div/section/div/nav/div/div/ul/li[@class='flyout-nav__li--selected']/div/div/ul/li/a"));


		//	CommonFunctions.navigateBackToPreviousPage(driver);
		//	categoriesAllLinks = driver.findElements(By.xpath("//ul[starts-with(@id,'categoryFacetList_1_13054_')]/li"));
        }
		categoriesAllLinks = driver.findElements(By.xpath("//div[@id='headerRow1']/div/section/div/nav/div/div/ul/li/a"));

	}  */

	//@AfterMethod
	public void tearDown(){
		driver.quit();
	} 

}



